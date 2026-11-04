/*******************************************************************************
 * Copyright (c) 2026 Eclipse Xtext Committers and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * Tests for real parameter names in the compiler.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class RealParameterNamesCompilerTest extends AbstractXtendTestCase {

	@Inject
	private CompilerTestHelper compiler;

	@Test
	public void consumerAdapterUsesJdkSourceParameterName() {
		String javaCode = compiler.toJavaCode("""
				package foo
				import java.util.function.Consumer
				class Test {
					def void use(Consumer<String> consumer) {}
					def void convert((String)=>void fn) {
						use(fn)
					}
				}
				""");
		assertTrue(javaCode, javaCode.contains("public void accept(String t)"));
		assertTrue(javaCode, javaCode.contains("fn.apply(t);"));
		compiler.compileToClass(javaCode);
	}

	@Test
	public void delegateUsesParameterNamesFromBinaryInterface() {
		String javaCode = compiler.toJavaCode("""
				package foo
				import org.eclipse.xtend.lib.annotations.Delegate
				import org.eclipse.xtend.lib.macro.file.FileLocations
				class Test implements FileLocations {
					@Delegate FileLocations locations
				}
				""");
		assertTrue(javaCode, javaCode.contains("getTargetFolder(final Path sourceFolder)"));
		assertTrue(javaCode, javaCode.contains("getTargetFolder(sourceFolder)"));
		compiler.compileToClass(javaCode);
	}
}
