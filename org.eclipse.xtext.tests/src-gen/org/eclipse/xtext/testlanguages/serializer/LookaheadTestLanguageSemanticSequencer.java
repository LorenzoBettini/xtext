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
import org.eclipse.xtext.testlanguages.lookaheadLang.Entry;
import org.eclipse.xtext.testlanguages.lookaheadLang.FewerLookAheadStrings;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead0;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead2;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead3;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead4;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAheadPredicate;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookAheadStrings;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookBeyond;
import org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class LookaheadTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private LookaheadTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == LookaheadLangPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case LookaheadLangPackage.ENTRY:
				sequence_Entry(context, (Entry) semanticObject); 
				return; 
			case LookaheadLangPackage.FEWER_LOOK_AHEAD_STRINGS:
				sequence_FewerLookAheadStrings(context, (FewerLookAheadStrings) semanticObject); 
				return; 
			case LookaheadLangPackage.LOOK_AHEAD0:
				sequence_LookAhead0(context, (LookAhead0) semanticObject); 
				return; 
			case LookaheadLangPackage.LOOK_AHEAD1:
				sequence_LookAhead1(context, (LookAhead1) semanticObject); 
				return; 
			case LookaheadLangPackage.LOOK_AHEAD2:
				sequence_LookAhead2(context, (LookAhead2) semanticObject); 
				return; 
			case LookaheadLangPackage.LOOK_AHEAD3:
				sequence_LookAhead3(context, (LookAhead3) semanticObject); 
				return; 
			case LookaheadLangPackage.LOOK_AHEAD4:
				sequence_LookAhead4(context, (LookAhead4) semanticObject); 
				return; 
			case LookaheadLangPackage.LOOK_AHEAD_PREDICATE:
				sequence_LookAheadPredicate(context, (LookAheadPredicate) semanticObject); 
				return; 
			case LookaheadLangPackage.LOOK_AHEAD_STRINGS:
				sequence_LookAheadStrings(context, (LookAheadStrings) semanticObject); 
				return; 
			case LookaheadLangPackage.LOOK_BEYOND:
				sequence_LookBeyond(context, (LookBeyond) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Entry returns Entry
	 *
	 * Constraint:
	 *     contents+=Alts+
	 * </pre>
	 */
	protected void sequence_Entry(ISerializationContext context, Entry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     FewerLookAheadStrings returns FewerLookAheadStrings
	 *
	 * Constraint:
	 *     (values+=STRING values+=STRING values+=ID)
	 * </pre>
	 */
	protected void sequence_FewerLookAheadStrings(ISerializationContext context, FewerLookAheadStrings semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alts returns LookAhead0
	 *     LookAhead0 returns LookAhead0
	 *
	 * Constraint:
	 *     x='a'
	 * </pre>
	 */
	protected void sequence_LookAhead0(ISerializationContext context, LookAhead0 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD0__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD0__X));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLookAhead0Access().getXAKeyword_1_0(), semanticObject.getX());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alts returns LookAhead1
	 *     LookAhead1 returns LookAhead1
	 *
	 * Constraint:
	 *     (y=LookAhead2 x='b' z='d')
	 * </pre>
	 */
	protected void sequence_LookAhead1(ISerializationContext context, LookAhead1 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD1__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD1__Y));
			if (transientValues.isValueTransient(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD1__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD1__X));
			if (transientValues.isValueTransient(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD1__Z) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD1__Z));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLookAhead1Access().getYLookAhead2ParserRuleCall_1_0(), semanticObject.getY());
		feeder.accept(grammarAccess.getLookAhead1Access().getXBKeyword_2_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getLookAhead1Access().getZDKeyword_3_0(), semanticObject.getZ());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     LookAhead2 returns LookAhead2
	 *
	 * Constraint:
	 *     (z='foo' | z='bar')
	 * </pre>
	 */
	protected void sequence_LookAhead2(ISerializationContext context, LookAhead2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alts returns LookAhead3
	 *     LookAhead3 returns LookAhead3
	 *
	 * Constraint:
	 *     (x='b' z=LookAhead4)
	 * </pre>
	 */
	protected void sequence_LookAhead3(ISerializationContext context, LookAhead3 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD3__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD3__X));
			if (transientValues.isValueTransient(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD3__Z) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LookaheadLangPackage.Literals.LOOK_AHEAD3__Z));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLookAhead3Access().getXBKeyword_2_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getLookAhead3Access().getZLookAhead4ParserRuleCall_3_0(), semanticObject.getZ());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     LookAhead4 returns LookAhead4
	 *
	 * Constraint:
	 *     (x='c' | x='d')
	 * </pre>
	 */
	protected void sequence_LookAhead4(ISerializationContext context, LookAhead4 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alts returns LookAheadPredicate
	 *     LookAheadPredicate returns LookAheadPredicate
	 *
	 * Constraint:
	 *     {LookAheadPredicate}
	 * </pre>
	 */
	protected void sequence_LookAheadPredicate(ISerializationContext context, LookAheadPredicate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     LookAheadStrings returns LookAheadStrings
	 *
	 * Constraint:
	 *     values+=STRING+
	 * </pre>
	 */
	protected void sequence_LookAheadStrings(ISerializationContext context, LookAheadStrings semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Alts returns LookBeyond
	 *     LookBeyond returns LookBeyond
	 *
	 * Constraint:
	 *     (left=LookAheadStrings? right=FewerLookAheadStrings)
	 * </pre>
	 */
	protected void sequence_LookBeyond(ISerializationContext context, LookBeyond semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
