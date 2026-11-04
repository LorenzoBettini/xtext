/*******************************************************************************
 * Copyright (c) 2026 Eclipse Xtext Committers and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.JavacTask;

import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.objectweb.asm.Type;

/**
 * Finds parameter names for JDK methods whose class files contain no names.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 * */
final class JdkSourceParameterNames {
	private static final JavaCompiler COMPILER = ToolProvider.getSystemJavaCompiler();
	private static final int CACHE_SIZE = 128;
	// Cache extracted signatures rather than javac trees, which retain the entire parsed source file.
	// A missing source or class is cached as an empty list. JDK sources are stable during a JVM run.
	private static final Map<CacheKey, List<SourceMethod>> CACHE = Collections.synchronizedMap(
			new LinkedHashMap<>(CACHE_SIZE, 0.75f, true) {
				private static final long serialVersionUID = 1L;
				@Override
				protected boolean removeEldestEntry(Map.Entry<CacheKey, List<SourceMethod>> eldest) {
					return size() > CACHE_SIZE;
				}
			});

	private record CacheKey(Path archive, String entry, List<String> classNames) {}

	private record SourceMethod(String name, List<String> parameterTypes, List<String> parameterNames) {}

	static JdkSourceParameterNames forClass(BinaryClass binaryClass) {
		org.eclipse.emf.common.util.URI location = binaryClass.getLocationURI();
		if (location == null || !location.toString().startsWith("jrt:/")) {
			return null;
		}
		Path javaHome = Path.of(System.getProperty("java.home"));
		Path archive = javaHome.resolve("lib/src.zip");
		if (!Files.isRegularFile(archive)) {
			archive = javaHome.resolve("../lib/src.zip").normalize();
		}
		if (!Files.isRegularFile(archive) || COMPILER == null) {
			return null;
		}
		String locationPath = location.toString().substring("jrt:/".length());
		int moduleEnd = locationPath.indexOf('/');
		if (moduleEnd < 0) {
			return null;
		}
		String classPath = locationPath.substring(moduleEnd + 1);
		int nestedClass = classPath.indexOf('$');
		if (nestedClass >= 0) {
			classPath = classPath.substring(0, nestedClass) + ".class";
		}
		String entry = locationPath.substring(0, moduleEnd + 1) + classPath.substring(0, classPath.length() - 6) + ".java";
		String binarySimpleName = binaryClass.getName().substring(binaryClass.getName().lastIndexOf('.') + 1);
		return new JdkSourceParameterNames(archive, entry, binarySimpleName.split("\\$"));
	}

	private final Path archive;
	private final String entry;
	private final String[] classNames;
	private boolean loaded;
	private List<SourceMethod> methods = List.of();

	private JdkSourceParameterNames(Path archive, String entry, String[] classNames) {
		this.archive = archive;
		this.entry = entry;
		this.classNames = classNames;
	}

	List<String> getParameterNames(String methodName, String descriptor, int parameterCount) {
		if (!loaded) {
			load();
		}
		Type[] binaryParameters = Type.getArgumentTypes(descriptor);
		int leadingParameters = binaryParameters.length - parameterCount;
		if (leadingParameters < 0) {
			return null;
		}
		SourceMethod match = null;
		int bestScore = -1;
		boolean ambiguous = false;
		for (SourceMethod method : methods) {
			if (method.name().equals(methodName) && method.parameterNames().size() == parameterCount) {
				int score = 0;
				for (int i = 0; i < parameterCount; i++) {
					int parameterScore = matchType(method.parameterTypes().get(i), binaryParameters[leadingParameters + i]);
					if (parameterScore < 0) {
						score = -1;
						break;
					}
					score += parameterScore;
				}
				if (score > bestScore) {
					match = method;
					bestScore = score;
					ambiguous = false;
				} else if (score >= 0 && score == bestScore) {
					ambiguous = true;
				}
			}
		}
		if (match == null || ambiguous) {
			return null;
		}
		return match.parameterNames();
	}

	private static int matchType(String sourceType, Type binaryType) {
		StringBuilder erased = new StringBuilder(sourceType.length());
		int genericDepth = 0;
		for (int i = 0; i < sourceType.length(); i++) {
			char ch = sourceType.charAt(i);
			if (ch == '<') {
				genericDepth++;
			} else if (ch == '>') {
				genericDepth--;
			} else if (genericDepth == 0 && !Character.isWhitespace(ch)) {
				erased.append(ch);
			}
		}
		String sourceName = erased.toString().replace("...", "[]");
		String binaryName = binaryType.getClassName();
		int sourceDimensions = 0;
		int binaryDimensions = 0;
		while (sourceName.endsWith("[]")) {
			sourceName = sourceName.substring(0, sourceName.length() - 2);
			sourceDimensions++;
		}
		while (binaryName.endsWith("[]")) {
			binaryName = binaryName.substring(0, binaryName.length() - 2);
			binaryDimensions++;
		}
		if (sourceDimensions != binaryDimensions) {
			return -1;
		}
		if (sourceName.equals(binaryName) || binaryName.endsWith("." + sourceName)) {
			return 2;
		}
		if (sourceName.length() == 1 && Character.isUpperCase(sourceName.charAt(0))) {
			return 1; // A type parameter can have an arbitrary erased bound.
		}
		return -1;
	}

	private void load() {
		loaded = true;
		CacheKey key = new CacheKey(archive, entry, List.of(classNames));
		List<SourceMethod> cached = CACHE.get(key);
		if (cached != null) {
			methods = cached;
			return;
		}
		methods = readMethods();
		CACHE.put(key, methods);
	}

	private List<SourceMethod> readMethods() {
		try (ZipFile zip = new ZipFile(archive.toFile())) {
			ZipEntry sourceEntry = zip.getEntry(entry);
			if (sourceEntry == null) {
				return List.of();
			}
			String source;
			try (var stream = zip.getInputStream(sourceEntry)) {
				source = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
			}
			JavaFileObject file = new SimpleJavaFileObject(URI.create("string:///" + classNames[0] + ".java"), JavaFileObject.Kind.SOURCE) {
				@Override
				public CharSequence getCharContent(boolean ignoreEncodingErrors) {
					return source;
				}
			};
			JavacTask task = (JavacTask) COMPILER.getTask(null, null, diagnostic -> {}, List.of("-proc:none"), null, List.of(file));
			CompilationUnitTree unit = task.parse().iterator().next();
			ClassTree type = findClass(unit.getTypeDecls(), classNames[0]);
			for (int i = 1; type != null && i < classNames.length; i++) {
				type = findClass(type.getMembers(), classNames[i]);
			}
			if (type != null) {
				List<SourceMethod> found = new ArrayList<>();
				for (Tree member : type.getMembers()) {
					if (member instanceof MethodTree method) {
						List<String> parameterTypes = new ArrayList<>(method.getParameters().size());
						List<String> parameterNames = new ArrayList<>(method.getParameters().size());
						method.getParameters().forEach(parameter -> {
							parameterTypes.add(parameter.getType().toString());
							parameterNames.add(parameter.getName().toString());
						});
						found.add(new SourceMethod(method.getName().toString(), List.copyOf(parameterTypes), List.copyOf(parameterNames)));
					}
				}
				return List.copyOf(found);
			}
		} catch (IOException | RuntimeException | LinkageError e) {
			// Source lookup is optional; JDK compiler classes may be unavailable from the current classloader.
		}
		return List.of();
	}

	private static ClassTree findClass(Iterable<? extends Tree> declarations, String name) {
		for (Tree declaration : declarations) {
			if (declaration instanceof ClassTree type && type.getSimpleName().contentEquals(name)) {
				return type;
			}
		}
		return null;
	}
}
