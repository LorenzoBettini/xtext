/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parser.antlr.bug378967Test.AfterObj;
import org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage;
import org.eclipse.xtext.parser.antlr.bug378967Test.Root;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule1;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule2;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule3;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule4;
import org.eclipse.xtext.parser.antlr.bug378967Test.SObj;
import org.eclipse.xtext.parser.antlr.services.Bug378967TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class Bug378967TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Bug378967TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Bug378967TestPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Bug378967TestPackage.AFTER_OBJ:
				sequence_AfterObj(context, (AfterObj) semanticObject); 
				return; 
			case Bug378967TestPackage.ROOT:
				sequence_Root(context, (Root) semanticObject); 
				return; 
			case Bug378967TestPackage.RULE1:
				sequence_Rule1(context, (Rule1) semanticObject); 
				return; 
			case Bug378967TestPackage.RULE2:
				sequence_Rule2(context, (Rule2) semanticObject); 
				return; 
			case Bug378967TestPackage.RULE3:
				sequence_Rule3(context, (Rule3) semanticObject); 
				return; 
			case Bug378967TestPackage.RULE4:
				sequence_Rule4(context, (Rule4) semanticObject); 
				return; 
			case Bug378967TestPackage.SOBJ:
				sequence_SObj(context, (SObj) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     AfterObj returns AfterObj
	 *
	 * Constraint:
	 *     value='after'
	 * </pre>
	 */
	protected void sequence_AfterObj(ISerializationContext context, AfterObj semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.AFTER_OBJ__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.AFTER_OBJ__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAfterObjAccess().getValueAfterKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Root returns Root
	 *
	 * Constraint:
	 *     (element=Rule1 | element=Rule2 | element=Rule3 | element=Rule4)
	 * </pre>
	 */
	protected void sequence_Root(ISerializationContext context, Root semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Rule1 returns Rule1
	 *
	 * Constraint:
	 *     (type=FirstEnum value=INT unit=SecondEnum)
	 * </pre>
	 */
	protected void sequence_Rule1(ISerializationContext context, Rule1 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE1__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE1__TYPE));
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE1__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE1__VALUE));
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE1__UNIT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE1__UNIT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRule1Access().getTypeFirstEnumEnumRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getRule1Access().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.accept(grammarAccess.getRule1Access().getUnitSecondEnumEnumRuleCall_2_0(), semanticObject.getUnit());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Rule2 returns Rule2
	 *
	 * Constraint:
	 *     value=INT
	 * </pre>
	 */
	protected void sequence_Rule2(ISerializationContext context, Rule2 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE2__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE2__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRule2Access().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Rule3 returns Rule3
	 *
	 * Constraint:
	 *     value=INT
	 * </pre>
	 */
	protected void sequence_Rule3(ISerializationContext context, Rule3 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE3__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE3__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRule3Access().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Rule4 returns Rule4
	 *
	 * Constraint:
	 *     (after=AfterObj value=INT s=SObj)
	 * </pre>
	 */
	protected void sequence_Rule4(ISerializationContext context, Rule4 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE4__AFTER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE4__AFTER));
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE4__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE4__VALUE));
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE4__S) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE4__S));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRule4Access().getAfterAfterObjParserRuleCall_0_0(), semanticObject.getAfter());
		feeder.accept(grammarAccess.getRule4Access().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.accept(grammarAccess.getRule4Access().getSSObjParserRuleCall_2_0(), semanticObject.getS());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SObj returns SObj
	 *
	 * Constraint:
	 *     value='s'
	 * </pre>
	 */
	protected void sequence_SObj(ISerializationContext context, SObj semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.SOBJ__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.SOBJ__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSObjAccess().getValueSKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
}
