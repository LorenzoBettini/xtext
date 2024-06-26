/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.parser.antlr.bug443221Test.Model;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug443221Test extends AbstractXtextTests{

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug443221TestLanguageStandaloneSetup.class);
	}

	@Test
	public void testParse() throws Exception {
		Model model = (Model) getModel("dummy MyID _ _dummy_ __dummy__ $__dummy__ $ DollarSign");
		assertEquals("MyID", model.getName());
	}

}
