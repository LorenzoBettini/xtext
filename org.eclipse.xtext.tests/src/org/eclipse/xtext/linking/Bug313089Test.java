/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Bug313089Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug313089TestLanguageStandaloneSetup.class);
	}
	
	@Test public void testUnassignedAction() throws Exception {
		getModelAndExpect("foo bar foo", 0);
		
	}
	
	@Test public void testAssignedAction() throws Exception {
		getModelAndExpect("foo baz baz0 baz baz1 foo",0);
	}
}

