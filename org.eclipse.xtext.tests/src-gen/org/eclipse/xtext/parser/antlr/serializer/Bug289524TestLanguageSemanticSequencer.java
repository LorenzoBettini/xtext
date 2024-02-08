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
import org.eclipse.xtext.parser.antlr.bug289524Test.Bug289524TestPackage;
import org.eclipse.xtext.parser.antlr.bug289524Test.Contained;
import org.eclipse.xtext.parser.antlr.bug289524Test.Model;
import org.eclipse.xtext.parser.antlr.bug289524Test.ModelElement;
import org.eclipse.xtext.parser.antlr.services.Bug289524TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class Bug289524TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Bug289524TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Bug289524TestPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Bug289524TestPackage.CONTAINED:
				sequence_Contained(context, (Contained) semanticObject); 
				return; 
			case Bug289524TestPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case Bug289524TestPackage.MODEL_ELEMENT:
				sequence_ModelElement(context, (ModelElement) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Contained returns Contained
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_Contained(ISerializationContext context, Contained semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug289524TestPackage.Literals.CONTAINED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug289524TestPackage.Literals.CONTAINED__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getContainedAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ModelElement returns ModelElement
	 *
	 * Constraint:
	 *     (containments+=Contained | (refs+=[Contained|ID] refs+=[Contained|ID]*))+
	 * </pre>
	 */
	protected void sequence_ModelElement(ISerializationContext context, ModelElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     refs+=ModelElement*
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
