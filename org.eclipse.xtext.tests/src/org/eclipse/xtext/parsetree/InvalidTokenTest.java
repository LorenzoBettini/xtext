/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.List;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguageStandaloneSetup;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * @author Jan K�hnlein - Initial contribution and API
 */
public class InvalidTokenTest extends AbstractXtextTests {

	@Test public void testInvalidTokenError() throws Exception {
		with(OptionalEmptyTestLanguageStandaloneSetup.class);
		ICompositeNode rootNode = getRootNodeAndExpect("/*", 1);
		List<INode> allErrorNodes = Lists.newArrayList(Iterators.filter(rootNode.getAsTreeIterable().iterator(), new Predicate<INode>() {
			@Override
			public boolean apply(INode input) {
				return input.getSyntaxErrorMessage() != null;
			}
		}));
		assertFalse(allErrorNodes.isEmpty());
		INode syntaxErrorNode = allErrorNodes.get(0);
		assertTrue(syntaxErrorNode.getSyntaxErrorMessage().getMessage().contains("mismatched character"));
	}
}
