/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.purexbase.pureXbase.PureXbasePackage;
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.serializer.XbaseSemanticSequencer;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public class PureXbaseSemanticSequencer extends XbaseSemanticSequencer {

	@Inject
	private PureXbaseGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == PureXbasePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case PureXbasePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			}
		else if (epackage == TypesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_FORMAL_PARAMETER:
				if (rule == grammarAccess.getFullJvmFormalParameterRule()) {
					sequence_FullJvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
				sequence_JvmParameterizedTypeReference(context, (JvmInnerTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_LOWER_BOUND:
				if (rule == grammarAccess.getJvmLowerBoundAndedRule()) {
					sequence_JvmLowerBoundAnded(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if (action == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()) {
					sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmTypeReferenceRule()
						|| action == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getJvmParameterizedTypeReferenceRule()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
				return; 
			case TypesPackage.JVM_UPPER_BOUND:
				if (rule == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
				return; 
			}
		else if (epackage == XbasePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XbasePackage.XASSIGNMENT:
				sequence_XAssignment_XMemberFeatureCall(context, (XAssignment) semanticObject); 
				return; 
			case XbasePackage.XBASIC_FOR_LOOP_EXPRESSION:
				sequence_XBasicForLoopExpression(context, (XBasicForLoopExpression) semanticObject); 
				return; 
			case XbasePackage.XBINARY_OPERATION:
				sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(context, (XBinaryOperation) semanticObject); 
				return; 
			case XbasePackage.XBLOCK_EXPRESSION:
				if (rule == grammarAccess.getSpecialBlockExpressionRule()) {
					sequence_SpecialBlockExpression(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXConditionalExpressionRule()
						|| action == grammarAccess.getXConditionalExpressionAccess().getXIfExpressionIfAction_1_0_0_0()
						|| rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXBlockExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XBlockExpression(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXExpressionInClosureRule()) {
					sequence_XExpressionInClosure(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBOOLEAN_LITERAL:
				sequence_XBooleanLiteral(context, (XBooleanLiteral) semanticObject); 
				return; 
			case XbasePackage.XCASE_PART:
				sequence_XCasePart(context, (XCasePart) semanticObject); 
				return; 
			case XbasePackage.XCASTED_EXPRESSION:
				sequence_XCastedExpression(context, (XCastedExpression) semanticObject); 
				return; 
			case XbasePackage.XCATCH_CLAUSE:
				sequence_XCatchClause(context, (XCatchClause) semanticObject); 
				return; 
			case XbasePackage.XCLOSURE:
				if (rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXConditionalExpressionRule()
						|| action == grammarAccess.getXConditionalExpressionAccess().getXIfExpressionIfAction_1_0_0_0()
						|| rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXLiteralRule()
						|| rule == grammarAccess.getXClosureRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXShortClosureRule()) {
					sequence_XShortClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONSTRUCTOR_CALL:
				sequence_XConstructorCall(context, (XConstructorCall) semanticObject); 
				return; 
			case XbasePackage.XDO_WHILE_EXPRESSION:
				sequence_XDoWhileExpression(context, (XDoWhileExpression) semanticObject); 
				return; 
			case XbasePackage.XFEATURE_CALL:
				sequence_XFeatureCall(context, (XFeatureCall) semanticObject); 
				return; 
			case XbasePackage.XFOR_LOOP_EXPRESSION:
				sequence_XForLoopExpression(context, (XForLoopExpression) semanticObject); 
				return; 
			case XbasePackage.XIF_EXPRESSION:
				if (rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXConditionalExpressionRule()
						|| action == grammarAccess.getXConditionalExpressionAccess().getXIfExpressionIfAction_1_0_0_0()
						|| rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XConditionalExpression_XIfExpression(context, (XIfExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXIfExpressionRule()) {
					sequence_XIfExpression(context, (XIfExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
				sequence_XRelationalExpression(context, (XInstanceOfExpression) semanticObject); 
				return; 
			case XbasePackage.XLIST_LITERAL:
				sequence_XListLiteral(context, (XListLiteral) semanticObject); 
				return; 
			case XbasePackage.XMEMBER_FEATURE_CALL:
				sequence_XMemberFeatureCall(context, (XMemberFeatureCall) semanticObject); 
				return; 
			case XbasePackage.XNULL_LITERAL:
				sequence_XNullLiteral(context, (XNullLiteral) semanticObject); 
				return; 
			case XbasePackage.XNUMBER_LITERAL:
				sequence_XNumberLiteral(context, (XNumberLiteral) semanticObject); 
				return; 
			case XbasePackage.XPOSTFIX_OPERATION:
				sequence_XPostfixOperation(context, (XPostfixOperation) semanticObject); 
				return; 
			case XbasePackage.XRETURN_EXPRESSION:
				sequence_XReturnExpression(context, (XReturnExpression) semanticObject); 
				return; 
			case XbasePackage.XSET_LITERAL:
				sequence_XSetLiteral(context, (XSetLiteral) semanticObject); 
				return; 
			case XbasePackage.XSTRING_LITERAL:
				sequence_XStringLiteral(context, (XStringLiteral) semanticObject); 
				return; 
			case XbasePackage.XSWITCH_EXPRESSION:
				sequence_XSwitchExpression(context, (XSwitchExpression) semanticObject); 
				return; 
			case XbasePackage.XSYNCHRONIZED_EXPRESSION:
				sequence_XSynchronizedExpression(context, (XSynchronizedExpression) semanticObject); 
				return; 
			case XbasePackage.XTHROW_EXPRESSION:
				sequence_XThrowExpression(context, (XThrowExpression) semanticObject); 
				return; 
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION:
				sequence_XTryCatchFinallyExpression(context, (XTryCatchFinallyExpression) semanticObject); 
				return; 
			case XbasePackage.XTYPE_LITERAL:
				sequence_XTypeLiteral(context, (XTypeLiteral) semanticObject); 
				return; 
			case XbasePackage.XUNARY_OPERATION:
				sequence_XUnaryOperation(context, (XUnaryOperation) semanticObject); 
				return; 
			case XbasePackage.XVARIABLE_DECLARATION:
				if (rule == grammarAccess.getInitialisedVariableDeclarationRule()) {
					sequence_InitialisedVariableDeclaration(context, (XVariableDeclaration) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXExpressionOrVarDeclarationRule()
						|| rule == grammarAccess.getXVariableDeclarationRule()) {
					sequence_XVariableDeclaration(context, (XVariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XWHILE_EXPRESSION:
				sequence_XWhileExpression(context, (XWhileExpression) semanticObject); 
				return; 
			}
		else if (epackage == XtypePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_DECLARATION:
				sequence_XImportDeclaration(context, (XImportDeclaration) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_SECTION:
				sequence_XImportSection(context, (XImportSection) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     InitialisedVariableDeclaration returns XVariableDeclaration
	 *
	 * Constraint:
	 *     (writeable?='var'? ((type=JvmTypeReference name=ValidID) | name=ValidID) right=XExpression)
	 * </pre>
	 */
	protected void sequence_InitialisedVariableDeclaration(ISerializationContext context, XVariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmLowerBoundAnded returns JvmLowerBound
	 *
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 * </pre>
	 */
	protected void sequence_JvmLowerBoundAnded(ISerializationContext context, JvmLowerBound semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), semanticObject.getTypeReference());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmLowerBound returns JvmLowerBound
	 *
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 * </pre>
	 */
	protected void sequence_JvmLowerBound(ISerializationContext context, JvmLowerBound semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), semanticObject.getTypeReference());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmTypeReference returns JvmInnerTypeReference
	 *     JvmTypeReference.JvmGenericArrayTypeReference_0_1_0_0 returns JvmInnerTypeReference
	 *     JvmParameterizedTypeReference returns JvmInnerTypeReference
	 *     JvmParameterizedTypeReference.JvmInnerTypeReference_1_4_0_0_0 returns JvmInnerTypeReference
	 *     JvmArgumentTypeReference returns JvmInnerTypeReference
	 *
	 * Constraint:
	 *     (
	 *         outer=JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0 
	 *         type=[JvmType|ValidID] 
	 *         (arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)?
	 *     )
	 * </pre>
	 */
	protected void sequence_JvmParameterizedTypeReference(ISerializationContext context, JvmInnerTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmParameterizedTypeReference.JvmInnerTypeReference_1_4_0_0_0 returns JvmParameterizedTypeReference
	 *
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)
	 * </pre>
	 */
	protected void sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(ISerializationContext context, JvmParameterizedTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmTypeReference returns JvmParameterizedTypeReference
	 *     JvmTypeReference.JvmGenericArrayTypeReference_0_1_0_0 returns JvmParameterizedTypeReference
	 *     JvmParameterizedTypeReference returns JvmParameterizedTypeReference
	 *     JvmArgumentTypeReference returns JvmParameterizedTypeReference
	 *
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] (arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)?)
	 * </pre>
	 */
	protected void sequence_JvmParameterizedTypeReference(ISerializationContext context, JvmParameterizedTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmTypeParameter returns JvmTypeParameter
	 *
	 * Constraint:
	 *     (name=ValidID (constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*)?)
	 * </pre>
	 */
	protected void sequence_JvmTypeParameter(ISerializationContext context, JvmTypeParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmTypeReference returns JvmGenericArrayTypeReference
	 *     JvmTypeReference.JvmGenericArrayTypeReference_0_1_0_0 returns JvmGenericArrayTypeReference
	 *     JvmArgumentTypeReference returns JvmGenericArrayTypeReference
	 *
	 * Constraint:
	 *     componentType=JvmTypeReference_JvmGenericArrayTypeReference_0_1_0_0
	 * </pre>
	 */
	protected void sequence_JvmTypeReference(ISerializationContext context, JvmGenericArrayTypeReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(), semanticObject.getComponentType());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmUpperBoundAnded returns JvmUpperBound
	 *
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 * </pre>
	 */
	protected void sequence_JvmUpperBoundAnded(ISerializationContext context, JvmUpperBound semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), semanticObject.getTypeReference());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmUpperBound returns JvmUpperBound
	 *
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 * </pre>
	 */
	protected void sequence_JvmUpperBound(ISerializationContext context, JvmUpperBound semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), semanticObject.getTypeReference());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmArgumentTypeReference returns JvmWildcardTypeReference
	 *     JvmWildcardTypeReference returns JvmWildcardTypeReference
	 *
	 * Constraint:
	 *     ((constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*) | (constraints+=JvmLowerBound constraints+=JvmLowerBoundAnded*))?
	 * </pre>
	 */
	protected void sequence_JvmWildcardTypeReference(ISerializationContext context, JvmWildcardTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (importSection=XImportSection? block=SpecialBlockExpression)
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SpecialBlockExpression returns XBlockExpression
	 *
	 * Constraint:
	 *     expressions+=XExpressionOrVarDeclaration*
	 * </pre>
	 */
	protected void sequence_SpecialBlockExpression(ISerializationContext context, XBlockExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     XAssignment returns XBinaryOperation
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XBinaryOperation
	 *     XConditionalExpression returns XBinaryOperation
	 *     XConditionalExpression.XIfExpression_1_0_0_0 returns XBinaryOperation
	 *     XExpression returns XBinaryOperation
	 *     XOrExpression returns XBinaryOperation
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XAndExpression returns XBinaryOperation
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XEqualityExpression returns XBinaryOperation
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XRelationalExpression returns XBinaryOperation
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XBinaryOperation
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XBinaryOperation
	 *     XOtherOperatorExpression returns XBinaryOperation
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XAdditiveExpression returns XBinaryOperation
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XMultiplicativeExpression returns XBinaryOperation
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XUnaryOperation returns XBinaryOperation
	 *     XCastedExpression returns XBinaryOperation
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XBinaryOperation
	 *     XPostfixOperation returns XBinaryOperation
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XBinaryOperation
	 *     XMemberFeatureCall returns XBinaryOperation
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XBinaryOperation
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XBinaryOperation
	 *     XPrimaryExpression returns XBinaryOperation
	 *     XParenthesizedExpression returns XBinaryOperation
	 *     XExpressionOrVarDeclaration returns XBinaryOperation
	 *
	 * Constraint:
	 *     (
	 *         (leftOperand=XAssignment_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpMultiAssign] rightOperand=XAssignment) | 
	 *         (leftOperand=XOrExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpOr] rightOperand=XAndExpression) | 
	 *         (leftOperand=XAndExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAnd] rightOperand=XEqualityExpression) | 
	 *         (leftOperand=XEqualityExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpEquality] rightOperand=XRelationalExpression) | 
	 *         (leftOperand=XRelationalExpression_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpCompare] rightOperand=XOtherOperatorExpression) | 
	 *         (leftOperand=XOtherOperatorExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpOther] rightOperand=XAdditiveExpression) | 
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XUnaryOperation)
	 *     )
	 * </pre>
	 */
	protected void sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(ISerializationContext context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     XAssignment returns XAssignment
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XAssignment
	 *     XConditionalExpression returns XAssignment
	 *     XConditionalExpression.XIfExpression_1_0_0_0 returns XAssignment
	 *     XExpression returns XAssignment
	 *     XOrExpression returns XAssignment
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XAndExpression returns XAssignment
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XEqualityExpression returns XAssignment
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XRelationalExpression returns XAssignment
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XAssignment
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XAssignment
	 *     XOtherOperatorExpression returns XAssignment
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XAdditiveExpression returns XAssignment
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XMultiplicativeExpression returns XAssignment
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XUnaryOperation returns XAssignment
	 *     XCastedExpression returns XAssignment
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XAssignment
	 *     XPostfixOperation returns XAssignment
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XAssignment
	 *     XMemberFeatureCall returns XAssignment
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XAssignment
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XAssignment
	 *     XPrimaryExpression returns XAssignment
	 *     XParenthesizedExpression returns XAssignment
	 *     XExpressionOrVarDeclaration returns XAssignment
	 *
	 * Constraint:
	 *     (
	 *         (feature=[JvmIdentifiableElement|FeatureCallID] value=XAssignment) | 
	 *         (assignable=XMemberFeatureCall_XAssignment_1_0_0_0_0 explicitStatic?='::'? feature=[JvmIdentifiableElement|FeatureCallID] value=XAssignment)
	 *     )
	 * </pre>
	 */
	protected void sequence_XAssignment_XMemberFeatureCall(ISerializationContext context, XAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     XAssignment returns XIfExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XIfExpression
	 *     XConditionalExpression returns XIfExpression
	 *     XConditionalExpression.XIfExpression_1_0_0_0 returns XIfExpression
	 *     XExpression returns XIfExpression
	 *     XOrExpression returns XIfExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XAndExpression returns XIfExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XEqualityExpression returns XIfExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XRelationalExpression returns XIfExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XIfExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XIfExpression
	 *     XOtherOperatorExpression returns XIfExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XAdditiveExpression returns XIfExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XMultiplicativeExpression returns XIfExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XUnaryOperation returns XIfExpression
	 *     XCastedExpression returns XIfExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XIfExpression
	 *     XPostfixOperation returns XIfExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XIfExpression
	 *     XMemberFeatureCall returns XIfExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XIfExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XIfExpression
	 *     XPrimaryExpression returns XIfExpression
	 *     XParenthesizedExpression returns XIfExpression
	 *     XExpressionOrVarDeclaration returns XIfExpression
	 *
	 * Constraint:
	 *     (
	 *         (if=XConditionalExpression_XIfExpression_1_0_0_0 conditionalExpression?='?' then=XExpression else=XExpression?) | 
	 *         (if=XExpression then=XExpression else=XExpression?)
	 *     )
	 * </pre>
	 */
	protected void sequence_XConditionalExpression_XIfExpression(ISerializationContext context, XIfExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     JvmTypeReference returns XFunctionTypeRef
	 *     XFunctionTypeRef returns XFunctionTypeRef
	 *     JvmArgumentTypeReference returns XFunctionTypeRef
	 *
	 * Constraint:
	 *     ((paramTypes+=JvmTypeReference paramTypes+=JvmTypeReference*)? returnType=JvmTypeReference)
	 * </pre>
	 */
	protected void sequence_XFunctionTypeRef(ISerializationContext context, XFunctionTypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     XImportDeclaration returns XImportDeclaration
	 *
	 * Constraint:
	 *     (
	 *         (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport] (wildcard?='*' | memberName=ValidID)) | 
	 *         importedType=[JvmDeclaredType|QualifiedName] | 
	 *         importedNamespace=QualifiedNameWithWildcard
	 *     )
	 * </pre>
	 */
	protected void sequence_XImportDeclaration(ISerializationContext context, XImportDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     XImportSection returns XImportSection
	 *
	 * Constraint:
	 *     importDeclarations+=XImportDeclaration+
	 * </pre>
	 */
	protected void sequence_XImportSection(ISerializationContext context, XImportSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     XTryCatchFinallyExpression returns XTryCatchFinallyExpression
	 *     XAssignment returns XTryCatchFinallyExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XConditionalExpression returns XTryCatchFinallyExpression
	 *     XConditionalExpression.XIfExpression_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XExpression returns XTryCatchFinallyExpression
	 *     XOrExpression returns XTryCatchFinallyExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XAndExpression returns XTryCatchFinallyExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XEqualityExpression returns XTryCatchFinallyExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XRelationalExpression returns XTryCatchFinallyExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XTryCatchFinallyExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XOtherOperatorExpression returns XTryCatchFinallyExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XAdditiveExpression returns XTryCatchFinallyExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XMultiplicativeExpression returns XTryCatchFinallyExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XUnaryOperation returns XTryCatchFinallyExpression
	 *     XCastedExpression returns XTryCatchFinallyExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XPostfixOperation returns XTryCatchFinallyExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XTryCatchFinallyExpression
	 *     XMemberFeatureCall returns XTryCatchFinallyExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XTryCatchFinallyExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XPrimaryExpression returns XTryCatchFinallyExpression
	 *     XParenthesizedExpression returns XTryCatchFinallyExpression
	 *     XExpressionOrVarDeclaration returns XTryCatchFinallyExpression
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             resources+=InitialisedVariableDeclaration 
	 *             resources+=InitialisedVariableDeclaration* 
	 *             expression=XExpression 
	 *             ((catchClauses+=XCatchClause+ finallyExpression=XExpression?) | finallyExpression=XExpression)?
	 *         ) | 
	 *         (expression=XExpression ((catchClauses+=XCatchClause+ finallyExpression=XExpression?) | finallyExpression=XExpression))
	 *     )
	 * </pre>
	 */
	protected void sequence_XTryCatchFinallyExpression(ISerializationContext context, XTryCatchFinallyExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
