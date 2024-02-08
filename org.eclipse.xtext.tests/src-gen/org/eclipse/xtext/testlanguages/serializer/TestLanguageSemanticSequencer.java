/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.testLang.ChoiceElement;
import org.eclipse.xtext.testlanguages.testLang.Model;
import org.eclipse.xtext.testlanguages.testLang.ReducibleComposite;
import org.eclipse.xtext.testlanguages.testLang.TerminalElement;
import org.eclipse.xtext.testlanguages.testLang.TestLangPackage;

@SuppressWarnings("all")
public class TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TestLangPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TestLangPackage.CHOICE_ELEMENT:
				sequence_ChoiceRule(context, (ChoiceElement) semanticObject); 
				return; 
			case TestLangPackage.MODEL:
				sequence_EntryRule(context, (Model) semanticObject); 
				return; 
			case TestLangPackage.REDUCIBLE_COMPOSITE:
				sequence_ReducibleRule(context, (ReducibleComposite) semanticObject); 
				return; 
			case TestLangPackage.TERMINAL_ELEMENT:
				sequence_TerminalRule(context, (TerminalElement) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractRule returns ChoiceElement
	 *     ChoiceRule returns ChoiceElement
	 *
	 * Constraint:
	 *     (optionalKeyword?='optional'? name=ID)
	 * </pre>
	 */
	protected void sequence_ChoiceRule(ISerializationContext context, ChoiceElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EntryRule returns Model
	 *
	 * Constraint:
	 *     multiFeature+=AbstractRule+
	 * </pre>
	 */
	protected void sequence_EntryRule(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractRule returns ReducibleComposite
	 *     ReducibleRule returns ReducibleComposite
	 *
	 * Constraint:
	 *     (actionFeature+=ReducibleRule_ReducibleComposite_2_0 actionFeature+=TerminalRule)
	 * </pre>
	 */
	protected void sequence_ReducibleRule(ISerializationContext context, ReducibleComposite semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractRule returns TerminalElement
	 *     ReducibleRule returns TerminalElement
	 *     ReducibleRule.ReducibleComposite_2_0 returns TerminalElement
	 *     TerminalRule returns TerminalElement
	 *
	 * Constraint:
	 *     stringFeature=STRING
	 * </pre>
	 */
	protected void sequence_TerminalRule(ISerializationContext context, TerminalElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TestLangPackage.Literals.TERMINAL_ELEMENT__STRING_FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TestLangPackage.Literals.TERMINAL_ELEMENT__STRING_FEATURE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalRuleAccess().getStringFeatureSTRINGTerminalRuleCall_0(), semanticObject.getStringFeature());
		feeder.finish();
	}
	
	
}
