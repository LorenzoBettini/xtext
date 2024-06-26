/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.xtext.linking.Bug289059TestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.bug289059Test.Model;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug289059Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug289059TestLanguageStandaloneSetup.class);
	}
	
	@Test public void testModelLinked_01() throws Exception {
		String modelAsText = "model model";
		Model model = (Model) getModel(modelAsText);
		assertSame(model, model.getReference());
	}
	
	@Test public void testModelLinked_02() throws Exception {
		String modelAsText = "model enabled model";
		Model model = (Model) getModel(modelAsText);
		assertSame(model, model.getReference());
	}
	
}
