/*******************************************************************************
 * Copyright (c) 2026 Eclipse Xtext Committers and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.junit.Test;

/**
 * Tests for {@link JdkSourceParameterNames}.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class JdkSourceParameterNamesTest {

	@Test
	public void distinguishesOverloadsWithTheSameArity() {
		JdkSourceParameterNames names = JdkSourceParameterNames.forClass(
				new BinaryClass("java.util.List", getClass().getClassLoader()));
		assertNotNull(names);
		assertEquals(List.of("e1"), names.getParameterNames("of", "(Ljava/lang/Object;)Ljava/util/List;", 1));
		assertEquals(List.of("elements"), names.getParameterNames("of", "([Ljava/lang/Object;)Ljava/util/List;", 1));
	}
}
