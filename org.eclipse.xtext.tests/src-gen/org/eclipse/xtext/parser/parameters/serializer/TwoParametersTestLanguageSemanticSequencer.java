/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.parameters.serializer;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario;
import org.eclipse.xtext.parser.parameters.services.TwoParametersTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class TwoParametersTestLanguageSemanticSequencer extends ParametersTestLanguageSemanticSequencer {

	@Inject
	private TwoParametersTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ParametersTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS:
				sequence_ParserRuleParameters(context, (ParserRuleParameters) semanticObject); 
				return; 
			case ParametersTestLanguagePackage.SCENARIO:
				if (rule == grammarAccess.getScenario1Rule() && (parameters.isEmpty())) {
					sequence_Scenario1$Param$false$(context, (Scenario) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScenario1Rule() && (ImmutableSet.of(grammarAccess.getScenario1Rule().getParameters().get(0/*Param*/)).equals(parameters))) {
					sequence_Scenario1$Param$true$(context, (Scenario) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScenario2Rule()) {
					sequence_Scenario2(context, (Scenario) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScenario3Rule()) {
					sequence_Scenario3(context, (Scenario) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScenario4Rule()) {
					sequence_Scenario4(context, (Scenario) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScenario5Rule() && (ImmutableSet.of(grammarAccess.getScenario5Rule().getParameters().get(0/*A*/), grammarAccess.getScenario5Rule().getParameters().get(1/*B*/)).equals(parameters))) {
					sequence_Scenario5$A$true$B$true$(context, (Scenario) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScenario5Rule() && (ImmutableSet.of(grammarAccess.getScenario5Rule().getParameters().get(0/*A*/)).equals(parameters)
				 			|| ImmutableSet.of(grammarAccess.getScenario5Rule().getParameters().get(1/*B*/)).equals(parameters)
				 			|| parameters.isEmpty())) {
					sequence_Scenario5(context, (Scenario) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScenario6Rule()) {
					sequence_Scenario6(context, (Scenario) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScenario7Rule()) {
					sequence_Scenario7(context, (Scenario) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScenario8Rule()) {
					sequence_Scenario8(context, (Scenario) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     ParserRuleParameters returns ParserRuleParameters
	 *
	 * Constraint:
	 *     (
	 *         scenario=Scenario5 | 
	 *         scenario=Scenario5 | 
	 *         scenario=Scenario6 | 
	 *         scenario=Scenario6 | 
	 *         scenario=Scenario6 | 
	 *         scenario=Scenario6 | 
	 *         scenario=Scenario7 | 
	 *         scenario=Scenario7 | 
	 *         scenario=Scenario8 | 
	 *         scenario=Scenario6 | 
	 *         scenario=Scenario8 | 
	 *         scenario=Scenario6 | 
	 *         scenario=Scenario8 | 
	 *         scenario=Scenario6 | 
	 *         scenario=Scenario8 | 
	 *         scenario=Scenario6
	 *     )
	 * </pre>
	 */
	protected void sequence_ParserRuleParameters(ISerializationContext context, ParserRuleParameters semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Scenario5<A,B> returns Scenario
	 *
	 * Constraint:
	 *     first=ID
	 * </pre>
	 */
	protected void sequence_Scenario5$A$true$B$true$(ISerializationContext context, Scenario semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParametersTestLanguagePackage.Literals.SCENARIO__FIRST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParametersTestLanguagePackage.Literals.SCENARIO__FIRST));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getScenario5Access().getFirstIDTerminalRuleCall_0_0_0(), semanticObject.getFirst());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Scenario5<A> returns Scenario
	 *     Scenario5<B> returns Scenario
	 *     Scenario5 returns Scenario
	 *
	 * Constraint:
	 *     second=ID
	 * </pre>
	 */
	protected void sequence_Scenario5(ISerializationContext context, Scenario semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParametersTestLanguagePackage.Literals.SCENARIO__SECOND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParametersTestLanguagePackage.Literals.SCENARIO__SECOND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getScenario5Access().getSecondIDTerminalRuleCall_1_0_0(), semanticObject.getSecond());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Scenario6<A,B> returns Scenario
	 *     Scenario6<A> returns Scenario
	 *     Scenario6<B> returns Scenario
	 *     Scenario6 returns Scenario
	 *
	 * Constraint:
	 *     first=IdOrKeyword2
	 * </pre>
	 */
	protected void sequence_Scenario6(ISerializationContext context, Scenario semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParametersTestLanguagePackage.Literals.SCENARIO__FIRST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParametersTestLanguagePackage.Literals.SCENARIO__FIRST));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getScenario6Access().getFirstIdOrKeyword2ParserRuleCall_0(), semanticObject.getFirst());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Scenario7<A,B> returns Scenario
	 *     Scenario7<A> returns Scenario
	 *     Scenario7<B> returns Scenario
	 *     Scenario7 returns Scenario
	 *
	 * Constraint:
	 *     (first=IdOrKeyword2 | second='keyword')
	 * </pre>
	 */
	protected void sequence_Scenario7(ISerializationContext context, Scenario semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Scenario8<A,B> returns Scenario
	 *     Scenario8<A> returns Scenario
	 *     Scenario8<B> returns Scenario
	 *     Scenario8 returns Scenario
	 *
	 * Constraint:
	 *     second=IdOrKeyword2
	 * </pre>
	 */
	protected void sequence_Scenario8(ISerializationContext context, Scenario semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParametersTestLanguagePackage.Literals.SCENARIO__SECOND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParametersTestLanguagePackage.Literals.SCENARIO__SECOND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getScenario8Access().getSecondIdOrKeyword2ParserRuleCall_0_0(), semanticObject.getSecond());
		feeder.finish();
	}
	
	
}
