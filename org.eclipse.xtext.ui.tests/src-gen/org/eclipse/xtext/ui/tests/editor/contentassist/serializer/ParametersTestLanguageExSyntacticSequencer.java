/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ParametersTestLanguageExGrammarAccess;

@SuppressWarnings("all")
public class ParametersTestLanguageExSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ParametersTestLanguageExGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_10_1_1_1_q;
	protected AbstractElementAlias match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_11_1_1_1_q;
	protected AbstractElementAlias match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_8_1_1_1_q;
	protected AbstractElementAlias match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_9_1_1_1_q;
	protected AbstractElementAlias match_Scenario5_IncludeKeyword_0_1_or_TrailingKeyword_1_1;
	protected AbstractElementAlias match_Scenario5_IncludeKeyword_2_2_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ParametersTestLanguageExGrammarAccess) access;
		match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_10_1_1_1_q = new TokenAlias(false, true, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_10_1_1_1());
		match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_11_1_1_1_q = new TokenAlias(false, true, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_11_1_1_1());
		match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_8_1_1_1_q = new TokenAlias(false, true, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_8_1_1_1());
		match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_9_1_1_1_q = new TokenAlias(false, true, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_9_1_1_1());
		match_Scenario5_IncludeKeyword_0_1_or_TrailingKeyword_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getScenario5Access().getIncludeKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getScenario5Access().getTrailingKeyword_1_1()));
		match_Scenario5_IncludeKeyword_2_2_0_q = new TokenAlias(false, true, grammarAccess.getScenario5Access().getIncludeKeyword_2_2_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_10_1_1_1_q.equals(syntax))
				emit_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_10_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_11_1_1_1_q.equals(syntax))
				emit_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_11_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_8_1_1_1_q.equals(syntax))
				emit_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_8_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_9_1_1_1_q.equals(syntax))
				emit_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_9_1_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Scenario5_IncludeKeyword_0_1_or_TrailingKeyword_1_1.equals(syntax))
				emit_Scenario5_IncludeKeyword_0_1_or_TrailingKeyword_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Scenario5_IncludeKeyword_2_2_0_q.equals(syntax))
				emit_Scenario5_IncludeKeyword_2_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'trailing'?
	 *
	 * This ambiguous syntax occurs at:
	 *     scenario=Scenario2 (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_10_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'trailing'?
	 *
	 * This ambiguous syntax occurs at:
	 *     scenario=Scenario2 (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_11_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'trailing'?
	 *
	 * This ambiguous syntax occurs at:
	 *     scenario=Scenario2 (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_8_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'trailing'?
	 *
	 * This ambiguous syntax occurs at:
	 *     scenario=Scenario2 (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParametersTestLanguageParserRuleParameters_TrailingKeyword_1_9_1_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'include' | 'trailing'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 
	 * </pre>
	 */
	protected void emit_Scenario5_IncludeKeyword_0_1_or_TrailingKeyword_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'include'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'scenario5' (ambiguity) first=IdOrKeyword
	 
	 * </pre>
	 */
	protected void emit_Scenario5_IncludeKeyword_2_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
