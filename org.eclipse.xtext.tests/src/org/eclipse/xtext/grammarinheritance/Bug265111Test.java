/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug265111Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test public void testParseGrammar() throws Exception {
		String grammar = "grammar test with org.eclipse.xtext.grammarinheritance.BaseInheritanceTestLanguage\n" +
				"generate test 'http://test'\n" +
				"Root: A | Model;" +
				"A: 'A' name=ID;";
		Resource r = getResourceFromStringAndExpect(grammar, 1);
		Grammar g = (Grammar) r.getContents().get(0);
		assertEquals("test", g.getName());
		assertEquals(r.getErrors().toString(), 1, r.getErrors().size());

	}
}
