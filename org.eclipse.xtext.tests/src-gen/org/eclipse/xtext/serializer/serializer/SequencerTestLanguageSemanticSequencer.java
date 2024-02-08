/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.serializer;

import com.google.common.collect.ImmutableSet;
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
import org.eclipse.xtext.serializer.sequencertest.AltList1;
import org.eclipse.xtext.serializer.sequencertest.AltList2;
import org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.Complex1;
import org.eclipse.xtext.serializer.sequencertest.Delegation;
import org.eclipse.xtext.serializer.sequencertest.DelegationA;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.FragmentCallerType;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywords;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.MultiTerminals;
import org.eclipse.xtext.serializer.sequencertest.NullCrossRef;
import org.eclipse.xtext.serializer.sequencertest.NullValue;
import org.eclipse.xtext.serializer.sequencertest.Optional;
import org.eclipse.xtext.serializer.sequencertest.OptionalDouble;
import org.eclipse.xtext.serializer.sequencertest.ParameterCaller;
import org.eclipse.xtext.serializer.sequencertest.ParameterDelegation;
import org.eclipse.xtext.serializer.sequencertest.Parameterized;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.SimpleAlternative;
import org.eclipse.xtext.serializer.sequencertest.SimpleGroup;
import org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild1;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild2;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild3;
import org.eclipse.xtext.serializer.sequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.sequencertest.SingleEnum;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywords;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.SingleTerminals;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal2;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroup;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupBoolean;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupOptional;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupVal2;
import org.eclipse.xtext.serializer.services.SequencerTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class SequencerTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private SequencerTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == SequencertestPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case SequencertestPackage.ALT_LIST1:
				sequence_AltList1(context, (AltList1) semanticObject); 
				return; 
			case SequencertestPackage.ALT_LIST2:
				sequence_AltList2(context, (AltList2) semanticObject); 
				return; 
			case SequencertestPackage.ALTERNATIVE_MULTIPLICITIES:
				sequence_AlternativeMultiplicities(context, (AlternativeMultiplicities) semanticObject); 
				return; 
			case SequencertestPackage.COMPLEX1:
				sequence_Complex1(context, (Complex1) semanticObject); 
				return; 
			case SequencertestPackage.DELEGATION:
				if (action == grammarAccess.getDelegationAccess().getDelegationALeftAction_1_2_0()) {
					sequence_Delegation$D$true$_DelegationA_1_2_0(context, (Delegation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDelegationRule() && (ImmutableSet.of(grammarAccess.getDelegationRule().getParameters().get(0/*D*/)).equals(parameters)
				 			|| parameters.isEmpty())) {
					sequence_Delegation$P$false$(context, (Delegation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDelegationRule() && (ImmutableSet.of(grammarAccess.getDelegationRule().getParameters().get(0/*D*/), grammarAccess.getDelegationRule().getParameters().get(1/*P*/)).equals(parameters)
				 			|| ImmutableSet.of(grammarAccess.getDelegationRule().getParameters().get(1/*P*/)).equals(parameters))) {
					sequence_Delegation$P$true$(context, (Delegation) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.DELEGATION_A:
				sequence_Delegation$D$true$(context, (DelegationA) semanticObject); 
				return; 
			case SequencertestPackage.DEPENDENT_ALTERNATIVE1:
				sequence_DependentAlternative1(context, (DependentAlternative1) semanticObject); 
				return; 
			case SequencertestPackage.DEPENDENT_ALTERNATIVE2:
				sequence_DependentAlternative2(context, (DependentAlternative2) semanticObject); 
				return; 
			case SequencertestPackage.FLOAT:
				sequence_Float(context, (org.eclipse.xtext.serializer.sequencertest.Float) semanticObject); 
				return; 
			case SequencertestPackage.FRAGMENT_CALLER_TYPE:
				sequence_Fragment1_FragmentCaller(context, (FragmentCallerType) semanticObject); 
				return; 
			case SequencertestPackage.GROUP_MULTIPLICITIES:
				sequence_GroupMultiplicities(context, (GroupMultiplicities) semanticObject); 
				return; 
			case SequencertestPackage.LIST1:
				sequence_List1(context, (List1) semanticObject); 
				return; 
			case SequencertestPackage.LIST2:
				sequence_List2(context, (List2) semanticObject); 
				return; 
			case SequencertestPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case SequencertestPackage.MULTI_KEYWORDS:
				sequence_MultiKeywords(context, (MultiKeywords) semanticObject); 
				return; 
			case SequencertestPackage.MULTI_KEYWORDS_OR_ID:
				sequence_MultiKeywordsOrID(context, (MultiKeywordsOrID) semanticObject); 
				return; 
			case SequencertestPackage.MULTI_TERMINALS:
				sequence_MultiTerminals(context, (MultiTerminals) semanticObject); 
				return; 
			case SequencertestPackage.NULL_CROSS_REF:
				if (rule == grammarAccess.getNullCrossRefGeneratedRule()) {
					sequence_NullCrossRefGenerated(context, (NullCrossRef) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNullCrossRefInterpretedRule()) {
					sequence_NullCrossRefInterpreted(context, (NullCrossRef) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.NULL_VALUE:
				if (rule == grammarAccess.getNullValueGeneratedRule()) {
					sequence_NullValueGenerated(context, (NullValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNullValueInterpretedRule()) {
					sequence_NullValueInterpreted(context, (NullValue) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.OPTIONAL:
				sequence_Optional(context, (Optional) semanticObject); 
				return; 
			case SequencertestPackage.OPTIONAL_DOUBLE:
				sequence_OptionalDouble(context, (OptionalDouble) semanticObject); 
				return; 
			case SequencertestPackage.PARAMETER_CALLER:
				sequence_ParameterCaller(context, (ParameterCaller) semanticObject); 
				return; 
			case SequencertestPackage.PARAMETER_DELEGATION:
				sequence_ParameterDelegation(context, (ParameterDelegation) semanticObject); 
				return; 
			case SequencertestPackage.PARAMETERIZED:
				if (rule == grammarAccess.getParameterizedRule() && (parameters.isEmpty())) {
					sequence_Parameterized$P$false$Q$false$(context, (Parameterized) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getParameterizedRule() && (ImmutableSet.of(grammarAccess.getParameterizedRule().getParameters().get(1/*Q*/)).equals(parameters))) {
					sequence_Parameterized$P$false$Q$true$(context, (Parameterized) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getParameterizedRule() && (ImmutableSet.of(grammarAccess.getParameterizedRule().getParameters().get(0/*P*/), grammarAccess.getParameterizedRule().getParameters().get(1/*Q*/)).equals(parameters)
				 			|| ImmutableSet.of(grammarAccess.getParameterizedRule().getParameters().get(0/*P*/)).equals(parameters))) {
					sequence_Parameterized$P$true$(context, (Parameterized) semanticObject); 
					return; 
				}
				else break;
			case SequencertestPackage.SIMPLE_ALTERNATIVE:
				sequence_SimpleAlternative(context, (SimpleAlternative) semanticObject); 
				return; 
			case SequencertestPackage.SIMPLE_GROUP:
				sequence_SimpleGroup(context, (SimpleGroup) semanticObject); 
				return; 
			case SequencertestPackage.SIMPLE_MULTIPLICITIES:
				sequence_SimpleMultiplicities(context, (SimpleMultiplicities) semanticObject); 
				return; 
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE:
				sequence_SingleContainmentReference(context, (SingleContainmentReference) semanticObject); 
				return; 
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD1:
				sequence_SingleContainmentReferenceChild1(context, (SingleContainmentReferenceChild1) semanticObject); 
				return; 
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD2:
				sequence_SingleContainmentReferenceChild2(context, (SingleContainmentReferenceChild2) semanticObject); 
				return; 
			case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD3:
				sequence_SingleContainmentReferenceChild3(context, (SingleContainmentReferenceChild3) semanticObject); 
				return; 
			case SequencertestPackage.SINGLE_CROSS_REFERENCE:
				sequence_SingleCrossReference(context, (SingleCrossReference) semanticObject); 
				return; 
			case SequencertestPackage.SINGLE_ENUM:
				sequence_SingleEnum(context, (SingleEnum) semanticObject); 
				return; 
			case SequencertestPackage.SINGLE_KEYWORDS:
				sequence_SingleKeywords(context, (SingleKeywords) semanticObject); 
				return; 
			case SequencertestPackage.SINGLE_KEYWORDS_OR_ID:
				sequence_SingleKeywordsOrID(context, (SingleKeywordsOrID) semanticObject); 
				return; 
			case SequencertestPackage.SINGLE_TERMINALS:
				sequence_SingleTerminals(context, (SingleTerminals) semanticObject); 
				return; 
			case SequencertestPackage.UNORDERED_ALTERNATIVE:
				sequence_UnorderedAlternative(context, (UnorderedAlternative) semanticObject); 
				return; 
			case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL:
				sequence_UnorderedAlternativeVal(context, (UnorderedAlternativeVal) semanticObject); 
				return; 
			case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL2:
				sequence_UnorderedAlternativeVal2(context, (UnorderedAlternativeVal2) semanticObject); 
				return; 
			case SequencertestPackage.UNORDERED_GROUP:
				sequence_UnorderedGroup(context, (UnorderedGroup) semanticObject); 
				return; 
			case SequencertestPackage.UNORDERED_GROUP_BOOLEAN:
				sequence_UnorderedGroupBoolean(context, (UnorderedGroupBoolean) semanticObject); 
				return; 
			case SequencertestPackage.UNORDERED_GROUP_OPTIONAL:
				sequence_UnorderedGroupOptional(context, (UnorderedGroupOptional) semanticObject); 
				return; 
			case SequencertestPackage.UNORDERED_GROUP_VAL:
				sequence_UnorderedGroupVal(context, (UnorderedGroupVal) semanticObject); 
				return; 
			case SequencertestPackage.UNORDERED_GROUP_VAL2:
				sequence_UnorderedGroupVal2(context, (UnorderedGroupVal2) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     AltList1 returns AltList1
	 *
	 * Constraint:
	 *     ((val1=ID val2=ID) | (val1=ID val3=ID) | (val1=ID val4=ID?))
	 * </pre>
	 */
	protected void sequence_AltList1(ISerializationContext context, AltList1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AltList2 returns AltList2
	 *
	 * Constraint:
	 *     ((val1+=ID val2=ID) | (val1+=ID val1+=ID* val3=ID))
	 * </pre>
	 */
	protected void sequence_AltList2(ISerializationContext context, AltList2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AlternativeMultiplicities returns AlternativeMultiplicities
	 *
	 * Constraint:
	 *     ((val2=ID | val3=ID)? (val4+=ID | val5+=ID)+ val6+=ID? (val7+=ID? val6+=ID?)*)
	 * </pre>
	 */
	protected void sequence_AlternativeMultiplicities(ISerializationContext context, AlternativeMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Complex1 returns Complex1
	 *
	 * Constraint:
	 *     (val1=ID? val2=ID? (val3+=ID | val4+=ID | val5+=ID | val6+=ID)*)
	 * </pre>
	 */
	protected void sequence_Complex1(ISerializationContext context, Complex1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Delegation<D,P> returns DelegationA
	 *     Delegation<D> returns DelegationA
	 *
	 * Constraint:
	 *     (left=Delegation_DelegationA_1_2_0 rc2=Delegation)
	 * </pre>
	 */
	protected void sequence_Delegation$D$true$(ISerializationContext context, DelegationA semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.DELEGATION_A__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.DELEGATION_A__LEFT));
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.DELEGATION_A__RC2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.DELEGATION_A__RC2));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDelegationAccess().getDelegationALeftAction_1_2_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getDelegationAccess().getRc2DelegationParserRuleCall_1_2_1_0(), semanticObject.getRc2());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Delegation.DelegationA_1_2_0<D,P> returns Delegation
	 *     Delegation.DelegationA_1_2_0<D> returns Delegation
	 *
	 * Constraint:
	 *     (p=ID | np=INT)
	 * </pre>
	 */
	protected void sequence_Delegation$D$true$_DelegationA_1_2_0(ISerializationContext context, Delegation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Delegation<D> returns Delegation
	 *     Delegation returns Delegation
	 *
	 * Constraint:
	 *     np=INT
	 * </pre>
	 */
	protected void sequence_Delegation$P$false$(ISerializationContext context, Delegation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.DELEGATION__NP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.DELEGATION__NP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDelegationAccess().getNpINTTerminalRuleCall_0_0_1_0_0(), semanticObject.getNp());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Delegation<D,P> returns Delegation
	 *     Delegation<P> returns Delegation
	 *
	 * Constraint:
	 *     p=ID
	 * </pre>
	 */
	protected void sequence_Delegation$P$true$(ISerializationContext context, Delegation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.DELEGATION__P) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.DELEGATION__P));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDelegationAccess().getPIDTerminalRuleCall_0_0_0_0_0(), semanticObject.getP());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     DependentAlternative1 returns DependentAlternative1
	 *
	 * Constraint:
	 *     (val=ID | (val=ID flag?='kw1'))
	 * </pre>
	 */
	protected void sequence_DependentAlternative1(ISerializationContext context, DependentAlternative1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     DependentAlternative2 returns DependentAlternative2
	 *
	 * Constraint:
	 *     ((val+=ID val+=ID+) | (val+=ID+ flag?='kw1'))
	 * </pre>
	 */
	protected void sequence_DependentAlternative2(ISerializationContext context, DependentAlternative2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Float returns Float
	 *
	 * Constraint:
	 *     {Float}
	 * </pre>
	 */
	protected void sequence_Float(ISerializationContext context, org.eclipse.xtext.serializer.sequencertest.Float semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     FragmentCaller returns FragmentCallerType
	 *
	 * Constraint:
	 *     (val1=ID fragVal=ID val=ID)
	 * </pre>
	 */
	protected void sequence_Fragment1_FragmentCaller(ISerializationContext context, FragmentCallerType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.FRAGMENT_CALLER_TYPE__VAL1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.FRAGMENT_CALLER_TYPE__VAL1));
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.FRAGMENT_CALLER_TYPE__FRAG_VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.FRAGMENT_CALLER_TYPE__FRAG_VAL));
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.FRAGMENT_CALLER_TYPE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.FRAGMENT_CALLER_TYPE__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFragmentCallerAccess().getVal1IDTerminalRuleCall_1_0(), semanticObject.getVal1());
		feeder.accept(grammarAccess.getFragment1Access().getFragValIDTerminalRuleCall_0(), semanticObject.getFragVal());
		feeder.accept(grammarAccess.getFragmentCallerAccess().getValIDTerminalRuleCall_3_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     GroupMultiplicities returns GroupMultiplicities
	 *
	 * Constraint:
	 *     (val1=ID (val2=ID val3=ID)? (val4+=ID val5+=ID)+ (val6+=ID val7+=ID)*)
	 * </pre>
	 */
	protected void sequence_GroupMultiplicities(ISerializationContext context, GroupMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     List1 returns List1
	 *
	 * Constraint:
	 *     (val1+=ID val1+=ID*)
	 * </pre>
	 */
	protected void sequence_List1(ISerializationContext context, List1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     List2 returns List2
	 *
	 * Constraint:
	 *     (val1+=ID val1+=ID*)?
	 * </pre>
	 */
	protected void sequence_List2(ISerializationContext context, List2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (
	 *         x1=SimpleGroup | 
	 *         x2=SimpleAlternative | 
	 *         x3=SimpleMultiplicities | 
	 *         x4=GroupMultiplicities | 
	 *         x5=AlternativeMultiplicities | 
	 *         x6=List1 | 
	 *         x7=List2 | 
	 *         x8=AltList1 | 
	 *         x9=AltList2 | 
	 *         x10=SingleKeywords | 
	 *         x11=SingleKeywordsOrID | 
	 *         x12=SingleTerminals | 
	 *         x10=MultiKeywords | 
	 *         x11=MultiKeywordsOrID | 
	 *         x12=MultiTerminals | 
	 *         x13=SingleEnum | 
	 *         x14=SingleCrossReference | 
	 *         x15=SingleContainmentReference | 
	 *         x19=DependentAlternative1 | 
	 *         x20=DependentAlternative2 | 
	 *         x21=Optional | 
	 *         x22=Float | 
	 *         x23=UnorderedAlternative | 
	 *         x24=UnorderedGroup | 
	 *         x25=UnorderedGroupOptional | 
	 *         x26=UnorderedGroupBoolean | 
	 *         x27=Complex1 | 
	 *         x28=OptionalDouble | 
	 *         x29=NullValueGenerated | 
	 *         x30=NullValueInterpreted | 
	 *         x31=NullCrossRefGenerated | 
	 *         x32=NullCrossRefInterpreted | 
	 *         x33=FragmentCaller | 
	 *         x34=ParameterCaller | 
	 *         x35=ParameterDelegation
	 *     )
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MultiKeywordsOrID returns MultiKeywordsOrID
	 *
	 * Constraint:
	 *     (val+='kw1' | val+='kw2' | val+='kw3' | val+=ID)
	 * </pre>
	 */
	protected void sequence_MultiKeywordsOrID(ISerializationContext context, MultiKeywordsOrID semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MultiKeywords returns MultiKeywords
	 *
	 * Constraint:
	 *     (val+='kw1' | val+='kw2' | val+='kw3')
	 * </pre>
	 */
	protected void sequence_MultiKeywords(ISerializationContext context, MultiKeywords semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MultiTerminals returns MultiTerminals
	 *
	 * Constraint:
	 *     (val+=ID1 | val+=ID2)
	 * </pre>
	 */
	protected void sequence_MultiTerminals(ISerializationContext context, MultiTerminals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NullCrossRefGenerated returns NullCrossRef
	 *
	 * Constraint:
	 *     ref=[EObject|ID]
	 * </pre>
	 */
	protected void sequence_NullCrossRefGenerated(ISerializationContext context, NullCrossRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.NULL_CROSS_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.NULL_CROSS_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNullCrossRefGeneratedAccess().getRefEObjectIDTerminalRuleCall_1_0_1(), semanticObject.eGet(SequencertestPackage.Literals.NULL_CROSS_REF__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NullCrossRefInterpreted returns NullCrossRef
	 *
	 * Constraint:
	 *     (ref=[EObject|ID] foo=ID?)
	 * </pre>
	 */
	protected void sequence_NullCrossRefInterpreted(ISerializationContext context, NullCrossRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NullValueGenerated returns NullValue
	 *
	 * Constraint:
	 *     value=NULL_STRING
	 * </pre>
	 */
	protected void sequence_NullValueGenerated(ISerializationContext context, NullValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.NULL_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.NULL_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNullValueGeneratedAccess().getValueNULL_STRINGParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NullValueInterpreted returns NullValue
	 *
	 * Constraint:
	 *     (value=NULL_STRING foo=ID?)
	 * </pre>
	 */
	protected void sequence_NullValueInterpreted(ISerializationContext context, NullValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OptionalDouble returns OptionalDouble
	 *
	 * Constraint:
	 *     (double0=DOUBLE (double1=DOUBLE double2=DOUBLE)?)
	 * </pre>
	 */
	protected void sequence_OptionalDouble(ISerializationContext context, OptionalDouble semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Optional returns Optional
	 *
	 * Constraint:
	 *     (int0=INT (int1=INT int2=INT)?)
	 * </pre>
	 */
	protected void sequence_Optional(ISerializationContext context, Optional semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ParameterCaller returns ParameterCaller
	 *
	 * Constraint:
	 *     (p=Parameterized | p=Parameterized | p=Parameterized | p=Parameterized)
	 * </pre>
	 */
	protected void sequence_ParameterCaller(ISerializationContext context, ParameterCaller semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ParameterDelegation returns ParameterDelegation
	 *
	 * Constraint:
	 *     (p=Delegation | p=Delegation)
	 * </pre>
	 */
	protected void sequence_ParameterDelegation(ISerializationContext context, ParameterDelegation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Parameterized returns Parameterized
	 *
	 * Constraint:
	 *     v2=ID
	 * </pre>
	 */
	protected void sequence_Parameterized$P$false$Q$false$(ISerializationContext context, Parameterized semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.PARAMETERIZED__V2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.PARAMETERIZED__V2));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParameterizedAccess().getV2IDTerminalRuleCall_1_1_0(), semanticObject.getV2());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Parameterized<Q> returns Parameterized
	 *
	 * Constraint:
	 *     (v2=ID v3=ID?)
	 * </pre>
	 */
	protected void sequence_Parameterized$P$false$Q$true$(ISerializationContext context, Parameterized semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Parameterized<P,Q> returns Parameterized
	 *     Parameterized<P> returns Parameterized
	 *
	 * Constraint:
	 *     v1=ID
	 * </pre>
	 */
	protected void sequence_Parameterized$P$true$(ISerializationContext context, Parameterized semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.PARAMETERIZED__V1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.PARAMETERIZED__V1));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParameterizedAccess().getV1IDTerminalRuleCall_0_1_0(), semanticObject.getV1());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SimpleAlternative returns SimpleAlternative
	 *
	 * Constraint:
	 *     (val1=ID | val2=ID)
	 * </pre>
	 */
	protected void sequence_SimpleAlternative(ISerializationContext context, SimpleAlternative semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SimpleGroup returns SimpleGroup
	 *
	 * Constraint:
	 *     (val1=ID val2=ID)
	 * </pre>
	 */
	protected void sequence_SimpleGroup(ISerializationContext context, SimpleGroup semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SIMPLE_GROUP__VAL1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SIMPLE_GROUP__VAL1));
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SIMPLE_GROUP__VAL2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SIMPLE_GROUP__VAL2));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSimpleGroupAccess().getVal1IDTerminalRuleCall_1_0(), semanticObject.getVal1());
		feeder.accept(grammarAccess.getSimpleGroupAccess().getVal2IDTerminalRuleCall_2_0(), semanticObject.getVal2());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SimpleMultiplicities returns SimpleMultiplicities
	 *
	 * Constraint:
	 *     (val1=ID val2=ID? val3+=ID+ val4+=ID*)
	 * </pre>
	 */
	protected void sequence_SimpleMultiplicities(ISerializationContext context, SimpleMultiplicities semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleContainmentReferenceChild1 returns SingleContainmentReferenceChild1
	 *
	 * Constraint:
	 *     val='kw1'
	 * </pre>
	 */
	protected void sequence_SingleContainmentReferenceChild1(ISerializationContext context, SingleContainmentReferenceChild1 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD1__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD1__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSingleContainmentReferenceChild1Access().getValKw1Keyword_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleContainmentReferenceChild2 returns SingleContainmentReferenceChild2
	 *
	 * Constraint:
	 *     val='kw2'
	 * </pre>
	 */
	protected void sequence_SingleContainmentReferenceChild2(ISerializationContext context, SingleContainmentReferenceChild2 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD2__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD2__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSingleContainmentReferenceChild2Access().getValKw2Keyword_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleContainmentReferenceChild3 returns SingleContainmentReferenceChild3
	 *
	 * Constraint:
	 *     val='kw3'
	 * </pre>
	 */
	protected void sequence_SingleContainmentReferenceChild3(ISerializationContext context, SingleContainmentReferenceChild3 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD3__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.SINGLE_CONTAINMENT_REFERENCE_CHILD3__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSingleContainmentReferenceChild3Access().getValKw3Keyword_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleContainmentReference returns SingleContainmentReference
	 *
	 * Constraint:
	 *     (child=SingleContainmentReferenceChild1 | child=SingleContainmentReferenceChild2 | child=SingleContainmentReferenceChild3)
	 * </pre>
	 */
	protected void sequence_SingleContainmentReference(ISerializationContext context, SingleContainmentReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleCrossReference returns SingleCrossReference
	 *
	 * Constraint:
	 *     ((name=ID1 | name=ID2 | name=ID3) (ref=[SingleCrossReference|ID1] | ref=[SingleCrossReference|ID2] | ref=[SingleCrossReference|ID3]))
	 * </pre>
	 */
	protected void sequence_SingleCrossReference(ISerializationContext context, SingleCrossReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleEnum returns SingleEnum
	 *
	 * Constraint:
	 *     (val=DefEnum1 | val=DefEnum2 | val=DefEnum3)
	 * </pre>
	 */
	protected void sequence_SingleEnum(ISerializationContext context, SingleEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleKeywordsOrID returns SingleKeywordsOrID
	 *
	 * Constraint:
	 *     (val='kw1' | val='kw2' | val='kw3' | val=ID)
	 * </pre>
	 */
	protected void sequence_SingleKeywordsOrID(ISerializationContext context, SingleKeywordsOrID semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleKeywords returns SingleKeywords
	 *
	 * Constraint:
	 *     (val='kw1' | val='kw2' | val='kw3')
	 * </pre>
	 */
	protected void sequence_SingleKeywords(ISerializationContext context, SingleKeywords semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleTerminals returns SingleTerminals
	 *
	 * Constraint:
	 *     (val=ID1 | val=ID2)
	 * </pre>
	 */
	protected void sequence_SingleTerminals(ISerializationContext context, SingleTerminals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnorderedAlternativeValDelegate returns UnorderedAlternativeVal2
	 *     UnorderedAlternativeVal2 returns UnorderedAlternativeVal2
	 *
	 * Constraint:
	 *     val=ID
	 * </pre>
	 */
	protected void sequence_UnorderedAlternativeVal2(ISerializationContext context, UnorderedAlternativeVal2 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.UNORDERED_ALTERNATIVE_VAL2__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.UNORDERED_ALTERNATIVE_VAL2__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnorderedAlternativeVal2Access().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnorderedAlternativeVal returns UnorderedAlternativeVal
	 *
	 * Constraint:
	 *     val=ID
	 * </pre>
	 */
	protected void sequence_UnorderedAlternativeVal(ISerializationContext context, UnorderedAlternativeVal semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.UNORDERED_ALTERNATIVE_VAL__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.UNORDERED_ALTERNATIVE_VAL__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnorderedAlternativeValAccess().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnorderedAlternative returns UnorderedAlternative
	 *
	 * Constraint:
	 *     (val1+=ID | val2+=INT | val3+=UnorderedAlternativeVal | val4+=UnorderedAlternativeValDelegate)*
	 * </pre>
	 */
	protected void sequence_UnorderedAlternative(ISerializationContext context, UnorderedAlternative semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnorderedGroupBoolean returns UnorderedGroupBoolean
	 *
	 * Constraint:
	 *     (val1?='kw1' | val2?='kw2' | val3?='kw3')*
	 * </pre>
	 */
	protected void sequence_UnorderedGroupBoolean(ISerializationContext context, UnorderedGroupBoolean semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnorderedGroupOptional returns UnorderedGroupOptional
	 *
	 * Constraint:
	 *     (val1=ID | va2=ID | val3=ID)*
	 * </pre>
	 */
	protected void sequence_UnorderedGroupOptional(ISerializationContext context, UnorderedGroupOptional semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnorderedGroupValDelegate returns UnorderedGroupVal2
	 *     UnorderedGroupVal2 returns UnorderedGroupVal2
	 *
	 * Constraint:
	 *     val=ID
	 * </pre>
	 */
	protected void sequence_UnorderedGroupVal2(ISerializationContext context, UnorderedGroupVal2 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.UNORDERED_GROUP_VAL2__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.UNORDERED_GROUP_VAL2__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnorderedGroupVal2Access().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnorderedGroupVal returns UnorderedGroupVal
	 *
	 * Constraint:
	 *     val=ID
	 * </pre>
	 */
	protected void sequence_UnorderedGroupVal(ISerializationContext context, UnorderedGroupVal semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SequencertestPackage.Literals.UNORDERED_GROUP_VAL__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SequencertestPackage.Literals.UNORDERED_GROUP_VAL__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnorderedGroupValAccess().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnorderedGroup returns UnorderedGroup
	 *
	 * Constraint:
	 *     (val1=ID | val2=INT | val3=UnorderedGroupVal | val4=UnorderedGroupValDelegate)+
	 * </pre>
	 */
	protected void sequence_UnorderedGroup(ISerializationContext context, UnorderedGroup semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
