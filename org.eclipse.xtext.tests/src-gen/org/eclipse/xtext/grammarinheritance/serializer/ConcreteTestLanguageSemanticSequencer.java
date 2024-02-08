/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.grammarinheritance.ametamodel.AModel;
import org.eclipse.xtext.grammarinheritance.ametamodel.AType;
import org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage;
import org.eclipse.xtext.grammarinheritance.foo.AType2;
import org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule;
import org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule;
import org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule;
import org.eclipse.xtext.grammarinheritance.foo.FooPackage;
import org.eclipse.xtext.grammarinheritance.foo.Subrule1;
import org.eclipse.xtext.grammarinheritance.foo.Subrule2;
import org.eclipse.xtext.grammarinheritance.foo.Subrule3;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ConcreteTestLanguageSemanticSequencer extends AbstractTestLanguageSemanticSequencer {

	@Inject
	private ConcreteTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == AmetamodelPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case AmetamodelPackage.AMODEL:
				if (rule == grammarAccess.getAbstractCallExtendedParserRuleRule()) {
					sequence_AbstractCallExtendedParserRule(context, (AModel) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAbstractCallOverridenParserRuleRule()) {
					sequence_AbstractCallOverridenParserRule(context, (AModel) semanticObject); 
					return; 
				}
				else break;
			case AmetamodelPackage.ATYPE:
				if (rule == grammarAccess.getInheritedParserRuleRule()) {
					sequence_InheritedParserRule(context, (AType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOverridableParserRuleRule()) {
					sequence_OverridableParserRule(context, (AType) semanticObject); 
					return; 
				}
				else break;
			}
		else if (epackage == FooPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case FooPackage.ATYPE2:
				sequence_OverridableParserRule2(context, (AType2) semanticObject); 
				return; 
			case FooPackage.CALL_EXTENDED_PARSER_RULE:
				sequence_CallExtendedParserRule(context, (CallExtendedParserRule) semanticObject); 
				return; 
			case FooPackage.CALL_OVERRIDEN_PARSER_RULE:
				sequence_CallOverridenParserRule(context, (CallOverridenParserRule) semanticObject); 
				return; 
			case FooPackage.CONCRETE_PARSER_RULE:
				sequence_ConcreteParserRule(context, (ConcreteParserRule) semanticObject); 
				return; 
			case FooPackage.SUBRULE1:
				sequence_Subrule1(context, (Subrule1) semanticObject); 
				return; 
			case FooPackage.SUBRULE2:
				sequence_Subrule2(context, (Subrule2) semanticObject); 
				return; 
			case FooPackage.SUBRULE3:
				sequence_Subrule3(context, (Subrule3) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     RootRule returns CallExtendedParserRule
	 *     CallExtendedParserRule returns CallExtendedParserRule
	 *
	 * Constraint:
	 *     call=AbstractCallExtendedParserRule
	 * </pre>
	 */
	protected void sequence_CallExtendedParserRule(ISerializationContext context, CallExtendedParserRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FooPackage.Literals.CALL_EXTENDED_PARSER_RULE__CALL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.CALL_EXTENDED_PARSER_RULE__CALL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCallExtendedParserRuleAccess().getCallAbstractCallExtendedParserRuleParserRuleCall_0(), semanticObject.getCall());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RootRule returns CallOverridenParserRule
	 *     CallOverridenParserRule returns CallOverridenParserRule
	 *
	 * Constraint:
	 *     call=AbstractCallOverridenParserRule
	 * </pre>
	 */
	protected void sequence_CallOverridenParserRule(ISerializationContext context, CallOverridenParserRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FooPackage.Literals.CALL_OVERRIDEN_PARSER_RULE__CALL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.CALL_OVERRIDEN_PARSER_RULE__CALL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCallOverridenParserRuleAccess().getCallAbstractCallOverridenParserRuleParserRuleCall_0(), semanticObject.getCall());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RootRule returns ConcreteParserRule
	 *     ConcreteParserRule returns ConcreteParserRule
	 *
	 * Constraint:
	 *     (magicNumber=REAL elements+=InheritedParserRule*)
	 * </pre>
	 */
	protected void sequence_ConcreteParserRule(ISerializationContext context, ConcreteParserRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RootRule returns AType2
	 *     OverridableParserRule2 returns AType2
	 *
	 * Constraint:
	 *     (name=ID age=INT)
	 * </pre>
	 */
	protected void sequence_OverridableParserRule2(ISerializationContext context, AType2 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
			if (transientValues.isValueTransient(semanticObject, FooPackage.Literals.ATYPE2__AGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.ATYPE2__AGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOverridableParserRule2Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getOverridableParserRule2Access().getAgeINTTerminalRuleCall_3_0(), semanticObject.getAge());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OverridableParserRule returns AType
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_OverridableParserRule(ISerializationContext context, AType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ExtendableParserRule returns Subrule1
	 *     Subrule1 returns Subrule1
	 *
	 * Constraint:
	 *     (name=ID sub1=ID)
	 * </pre>
	 */
	protected void sequence_Subrule1(ISerializationContext context, Subrule1 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
			if (transientValues.isValueTransient(semanticObject, FooPackage.Literals.SUBRULE1__SUB1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.SUBRULE1__SUB1));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSubrule1Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSubrule1Access().getSub1IDTerminalRuleCall_2_0(), semanticObject.getSub1());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ExtendableParserRule returns Subrule2
	 *     Subrule2 returns Subrule2
	 *
	 * Constraint:
	 *     (name=ID sub2=STRING)
	 * </pre>
	 */
	protected void sequence_Subrule2(ISerializationContext context, Subrule2 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
			if (transientValues.isValueTransient(semanticObject, FooPackage.Literals.SUBRULE2__SUB2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.SUBRULE2__SUB2));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSubrule2Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSubrule2Access().getSub2STRINGTerminalRuleCall_2_0(), semanticObject.getSub2());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ExtendableParserRule returns Subrule3
	 *     Subrule3 returns Subrule3
	 *
	 * Constraint:
	 *     (name=ID sub1=INT)
	 * </pre>
	 */
	protected void sequence_Subrule3(ISerializationContext context, Subrule3 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
			if (transientValues.isValueTransient(semanticObject, FooPackage.Literals.SUBRULE3__SUB1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FooPackage.Literals.SUBRULE3__SUB1));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSubrule3Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSubrule3Access().getSub1INTTerminalRuleCall_2_0(), semanticObject.getSub1());
		feeder.finish();
	}
	
	
}
