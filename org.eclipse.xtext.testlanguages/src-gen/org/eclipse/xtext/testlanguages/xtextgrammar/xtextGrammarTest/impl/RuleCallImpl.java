/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.AbstractRule;
import org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.RuleCall;
import org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.XtextGrammarTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.impl.RuleCallImpl#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleCallImpl extends AbstractElementImpl implements RuleCall
{
  /**
   * The cached value of the '{@link #getRule() <em>Rule</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRule()
   * @generated
   * @ordered
   */
  protected AbstractRule rule;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleCallImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return XtextGrammarTestPackage.Literals.RULE_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AbstractRule getRule()
  {
    if (rule != null && rule.eIsProxy())
    {
      InternalEObject oldRule = (InternalEObject)rule;
      rule = (AbstractRule)eResolveProxy(oldRule);
      if (rule != oldRule)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextGrammarTestPackage.RULE_CALL__RULE, oldRule, rule));
      }
    }
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractRule basicGetRule()
  {
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRule(AbstractRule newRule)
  {
    AbstractRule oldRule = rule;
    rule = newRule;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextGrammarTestPackage.RULE_CALL__RULE, oldRule, rule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case XtextGrammarTestPackage.RULE_CALL__RULE:
        if (resolve) return getRule();
        return basicGetRule();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case XtextGrammarTestPackage.RULE_CALL__RULE:
        setRule((AbstractRule)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case XtextGrammarTestPackage.RULE_CALL__RULE:
        setRule((AbstractRule)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case XtextGrammarTestPackage.RULE_CALL__RULE:
        return rule != null;
    }
    return super.eIsSet(featureID);
  }

} //RuleCallImpl
