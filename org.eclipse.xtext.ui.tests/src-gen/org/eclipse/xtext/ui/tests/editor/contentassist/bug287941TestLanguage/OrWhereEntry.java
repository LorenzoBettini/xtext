/**
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.OrWhereEntry#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getOrWhereEntry()
 * @model
 * @generated
 */
public interface OrWhereEntry extends WhereEntry
{
  /**
   * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.WhereEntry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entries</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getOrWhereEntry_Entries()
   * @model containment="true"
   * @generated
   */
  EList<WhereEntry> getEntries();

} // OrWhereEntry
