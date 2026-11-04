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
import java.util.List;
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
	private List<MethodTree> methods = List.of();

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
		MethodTree match = null;
		int bestScore = -1;
		boolean ambiguous = false;
		for (MethodTree method : methods) {
			if (method.getName().contentEquals(methodName) && method.getParameters().size() == parameterCount) {
				int score = 0;
				for (int i = 0; i < parameterCount; i++) {
					int parameterScore = matchType(method.getParameters().get(i).getType().toString(), binaryParameters[leadingParameters + i]);
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
		List<String> names = new ArrayList<>(parameterCount);
		match.getParameters().forEach(parameter -> names.add(parameter.getName().toString()));
		return names;
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
		try (ZipFile zip = new ZipFile(archive.toFile())) {
			ZipEntry sourceEntry = zip.getEntry(entry);
			if (sourceEntry == null) {
				return;
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
				List<MethodTree> found = new ArrayList<>();
				for (Tree member : type.getMembers()) {
					if (member instanceof MethodTree method) {
						found.add(method);
					}
				}
				methods = found;
			}
		} catch (IOException | RuntimeException e) {
			// Source archives are optional; the binary parameter name remains the fallback.
		}
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
