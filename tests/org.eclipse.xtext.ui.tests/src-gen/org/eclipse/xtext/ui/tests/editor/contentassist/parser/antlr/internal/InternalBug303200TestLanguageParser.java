package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug303200TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBug303200TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LT", "RULE_ID", "RULE_WS", "'function'", "'['", "']'", "'('", "','", "')'", "'{'", "'}'", "';'", "'.'"
    };
    public static final int RULE_ID=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int RULE_WS=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int RULE_LT=4;

    // delegates
    // delegators


        public InternalBug303200TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug303200TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug303200TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug303200TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private Bug303200TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug303200TestLanguageParser(TokenStream input, Bug303200TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Program";	
       	}
       	
       	@Override
       	protected Bug303200TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleProgram"
    // InternalBug303200TestLanguage.g:73:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalBug303200TestLanguage.g:74:2: (iv_ruleProgram= ruleProgram EOF )
            // InternalBug303200TestLanguage.g:75:2: iv_ruleProgram= ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgram; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalBug303200TestLanguage.g:82:1: ruleProgram returns [EObject current=null] : ( () ( (this_LT_1= RULE_LT )* ( (lv_directives_2_0= ruleProgramDirective ) ) )* (this_LT_3= RULE_LT )* ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token this_LT_1=null;
        Token this_LT_3=null;
        EObject lv_directives_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:85:28: ( ( () ( (this_LT_1= RULE_LT )* ( (lv_directives_2_0= ruleProgramDirective ) ) )* (this_LT_3= RULE_LT )* ) )
            // InternalBug303200TestLanguage.g:86:1: ( () ( (this_LT_1= RULE_LT )* ( (lv_directives_2_0= ruleProgramDirective ) ) )* (this_LT_3= RULE_LT )* )
            {
            // InternalBug303200TestLanguage.g:86:1: ( () ( (this_LT_1= RULE_LT )* ( (lv_directives_2_0= ruleProgramDirective ) ) )* (this_LT_3= RULE_LT )* )
            // InternalBug303200TestLanguage.g:86:2: () ( (this_LT_1= RULE_LT )* ( (lv_directives_2_0= ruleProgramDirective ) ) )* (this_LT_3= RULE_LT )*
            {
            // InternalBug303200TestLanguage.g:86:2: ()
            // InternalBug303200TestLanguage.g:87:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getProgramAccess().getProgramAction_0(),
                          current);
                  
            }

            }

            // InternalBug303200TestLanguage.g:95:2: ( (this_LT_1= RULE_LT )* ( (lv_directives_2_0= ruleProgramDirective ) ) )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:95:3: (this_LT_1= RULE_LT )* ( (lv_directives_2_0= ruleProgramDirective ) )
            	    {
            	    // InternalBug303200TestLanguage.g:95:3: (this_LT_1= RULE_LT )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==RULE_LT) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // InternalBug303200TestLanguage.g:95:4: this_LT_1= RULE_LT
            	    	    {
            	    	    this_LT_1=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_LT_1, grammarAccess.getProgramAccess().getLTTerminalRuleCall_1_0()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);

            	    // InternalBug303200TestLanguage.g:99:3: ( (lv_directives_2_0= ruleProgramDirective ) )
            	    // InternalBug303200TestLanguage.g:100:1: (lv_directives_2_0= ruleProgramDirective )
            	    {
            	    // InternalBug303200TestLanguage.g:100:1: (lv_directives_2_0= ruleProgramDirective )
            	    // InternalBug303200TestLanguage.g:101:3: lv_directives_2_0= ruleProgramDirective
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProgramAccess().getDirectivesProgramDirectiveParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_directives_2_0=ruleProgramDirective();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"directives",
            	              		lv_directives_2_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.ProgramDirective");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalBug303200TestLanguage.g:117:4: (this_LT_3= RULE_LT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_LT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:117:5: this_LT_3= RULE_LT
            	    {
            	    this_LT_3=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_LT_3, grammarAccess.getProgramAccess().getLTTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleProgramDirective"
    // InternalBug303200TestLanguage.g:129:1: entryRuleProgramDirective returns [EObject current=null] : iv_ruleProgramDirective= ruleProgramDirective EOF ;
    public final EObject entryRuleProgramDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramDirective = null;


        try {
            // InternalBug303200TestLanguage.g:130:2: (iv_ruleProgramDirective= ruleProgramDirective EOF )
            // InternalBug303200TestLanguage.g:131:2: iv_ruleProgramDirective= ruleProgramDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramDirectiveRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProgramDirective=ruleProgramDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgramDirective; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramDirective"


    // $ANTLR start "ruleProgramDirective"
    // InternalBug303200TestLanguage.g:138:1: ruleProgramDirective returns [EObject current=null] : (this_FunctionDefinition_0= ruleFunctionDefinition | this_Statement_1= ruleStatement ) ;
    public final EObject ruleProgramDirective() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionDefinition_0 = null;

        EObject this_Statement_1 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:141:28: ( (this_FunctionDefinition_0= ruleFunctionDefinition | this_Statement_1= ruleStatement ) )
            // InternalBug303200TestLanguage.g:142:1: (this_FunctionDefinition_0= ruleFunctionDefinition | this_Statement_1= ruleStatement )
            {
            // InternalBug303200TestLanguage.g:142:1: (this_FunctionDefinition_0= ruleFunctionDefinition | this_Statement_1= ruleStatement )
            int alt4=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA4_1 = input.LA(2);

                if ( (synpred4_InternalBug303200TestLanguage()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
                }
                break;
            case 8:
                {
                alt4=1;
                }
                break;
            case 7:
                {
                int LA4_3 = input.LA(2);

                if ( (synpred4_InternalBug303200TestLanguage()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                alt4=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalBug303200TestLanguage.g:143:2: this_FunctionDefinition_0= ruleFunctionDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getProgramDirectiveAccess().getFunctionDefinitionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionDefinition_0=ruleFunctionDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FunctionDefinition_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBug303200TestLanguage.g:156:2: this_Statement_1= ruleStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getProgramDirectiveAccess().getStatementParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Statement_1=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Statement_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramDirective"


    // $ANTLR start "entryRuleFunctionDefinition"
    // InternalBug303200TestLanguage.g:175:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalBug303200TestLanguage.g:176:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalBug303200TestLanguage.g:177:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDefinition"


    // $ANTLR start "ruleFunctionDefinition"
    // InternalBug303200TestLanguage.g:184:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_attributes_0_0= ruleAttribute ) )* otherlv_1= 'function' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_LT_2=null;
        Token lv_name_3_0=null;
        Token this_LT_4=null;
        Token this_LT_6=null;
        EObject lv_attributes_0_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_body_7_0 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:187:28: ( ( ( (lv_attributes_0_0= ruleAttribute ) )* otherlv_1= 'function' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) ) )
            // InternalBug303200TestLanguage.g:188:1: ( ( (lv_attributes_0_0= ruleAttribute ) )* otherlv_1= 'function' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) )
            {
            // InternalBug303200TestLanguage.g:188:1: ( ( (lv_attributes_0_0= ruleAttribute ) )* otherlv_1= 'function' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) )
            // InternalBug303200TestLanguage.g:188:2: ( (lv_attributes_0_0= ruleAttribute ) )* otherlv_1= 'function' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) )
            {
            // InternalBug303200TestLanguage.g:188:2: ( (lv_attributes_0_0= ruleAttribute ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||LA5_0==8) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:189:1: (lv_attributes_0_0= ruleAttribute )
            	    {
            	    // InternalBug303200TestLanguage.g:189:1: (lv_attributes_0_0= ruleAttribute )
            	    // InternalBug303200TestLanguage.g:190:3: lv_attributes_0_0= ruleAttribute
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getAttributesAttributeParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_attributes_0_0=ruleAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"attributes",
            	              		lv_attributes_0_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.Attribute");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_1=(Token)match(input,7,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getFunctionKeyword_1());
                  
            }
            // InternalBug303200TestLanguage.g:210:1: (this_LT_2= RULE_LT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_LT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:210:2: this_LT_2= RULE_LT
            	    {
            	    this_LT_2=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_LT_2, grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalBug303200TestLanguage.g:214:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalBug303200TestLanguage.g:215:1: (lv_name_3_0= RULE_ID )
            {
            // InternalBug303200TestLanguage.g:215:1: (lv_name_3_0= RULE_ID )
            // InternalBug303200TestLanguage.g:216:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_3_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.ID");
              	    
            }

            }


            }

            // InternalBug303200TestLanguage.g:232:2: (this_LT_4= RULE_LT )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_LT) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:232:3: this_LT_4= RULE_LT
            	    {
            	    this_LT_4=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_LT_4, grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalBug303200TestLanguage.g:236:3: ( (lv_params_5_0= ruleParameters ) )
            // InternalBug303200TestLanguage.g:237:1: (lv_params_5_0= ruleParameters )
            {
            // InternalBug303200TestLanguage.g:237:1: (lv_params_5_0= ruleParameters )
            // InternalBug303200TestLanguage.g:238:3: lv_params_5_0= ruleParameters
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParamsParametersParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_9);
            lv_params_5_0=ruleParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"params",
                      		lv_params_5_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.Parameters");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBug303200TestLanguage.g:254:2: (this_LT_6= RULE_LT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_LT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:254:3: this_LT_6= RULE_LT
            	    {
            	    this_LT_6=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_LT_6, grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_6()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalBug303200TestLanguage.g:258:3: ( (lv_body_7_0= ruleBlock ) )
            // InternalBug303200TestLanguage.g:259:1: (lv_body_7_0= ruleBlock )
            {
            // InternalBug303200TestLanguage.g:259:1: (lv_body_7_0= ruleBlock )
            // InternalBug303200TestLanguage.g:260:3: lv_body_7_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBodyBlockParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_body_7_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_7_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.Block");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDefinition"


    // $ANTLR start "entryRuleAttribute"
    // InternalBug303200TestLanguage.g:284:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalBug303200TestLanguage.g:285:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalBug303200TestLanguage.g:286:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalBug303200TestLanguage.g:293:1: ruleAttribute returns [EObject current=null] : ( ( (lv_ident_0_0= RULE_ID ) ) | ( () otherlv_2= '[' (this_LT_3= RULE_LT )* ( (lv_expression_4_0= rulePostfixExpression ) ) (this_LT_5= RULE_LT )* otherlv_6= ']' ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_ident_0_0=null;
        Token otherlv_2=null;
        Token this_LT_3=null;
        Token this_LT_5=null;
        Token otherlv_6=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:296:28: ( ( ( (lv_ident_0_0= RULE_ID ) ) | ( () otherlv_2= '[' (this_LT_3= RULE_LT )* ( (lv_expression_4_0= rulePostfixExpression ) ) (this_LT_5= RULE_LT )* otherlv_6= ']' ) ) )
            // InternalBug303200TestLanguage.g:297:1: ( ( (lv_ident_0_0= RULE_ID ) ) | ( () otherlv_2= '[' (this_LT_3= RULE_LT )* ( (lv_expression_4_0= rulePostfixExpression ) ) (this_LT_5= RULE_LT )* otherlv_6= ']' ) )
            {
            // InternalBug303200TestLanguage.g:297:1: ( ( (lv_ident_0_0= RULE_ID ) ) | ( () otherlv_2= '[' (this_LT_3= RULE_LT )* ( (lv_expression_4_0= rulePostfixExpression ) ) (this_LT_5= RULE_LT )* otherlv_6= ']' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==8) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalBug303200TestLanguage.g:297:2: ( (lv_ident_0_0= RULE_ID ) )
                    {
                    // InternalBug303200TestLanguage.g:297:2: ( (lv_ident_0_0= RULE_ID ) )
                    // InternalBug303200TestLanguage.g:298:1: (lv_ident_0_0= RULE_ID )
                    {
                    // InternalBug303200TestLanguage.g:298:1: (lv_ident_0_0= RULE_ID )
                    // InternalBug303200TestLanguage.g:299:3: lv_ident_0_0= RULE_ID
                    {
                    lv_ident_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_ident_0_0, grammarAccess.getAttributeAccess().getIdentIDTerminalRuleCall_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAttributeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"ident",
                              		lv_ident_0_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.ID");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug303200TestLanguage.g:316:6: ( () otherlv_2= '[' (this_LT_3= RULE_LT )* ( (lv_expression_4_0= rulePostfixExpression ) ) (this_LT_5= RULE_LT )* otherlv_6= ']' )
                    {
                    // InternalBug303200TestLanguage.g:316:6: ( () otherlv_2= '[' (this_LT_3= RULE_LT )* ( (lv_expression_4_0= rulePostfixExpression ) ) (this_LT_5= RULE_LT )* otherlv_6= ']' )
                    // InternalBug303200TestLanguage.g:316:7: () otherlv_2= '[' (this_LT_3= RULE_LT )* ( (lv_expression_4_0= rulePostfixExpression ) ) (this_LT_5= RULE_LT )* otherlv_6= ']'
                    {
                    // InternalBug303200TestLanguage.g:316:7: ()
                    // InternalBug303200TestLanguage.g:317:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAttributeAccess().getBracketAttributeAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,8,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_1_1());
                          
                    }
                    // InternalBug303200TestLanguage.g:329:1: (this_LT_3= RULE_LT )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_LT) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalBug303200TestLanguage.g:329:2: this_LT_3= RULE_LT
                    	    {
                    	    this_LT_3=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_LT_3, grammarAccess.getAttributeAccess().getLTTerminalRuleCall_1_2()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // InternalBug303200TestLanguage.g:333:3: ( (lv_expression_4_0= rulePostfixExpression ) )
                    // InternalBug303200TestLanguage.g:334:1: (lv_expression_4_0= rulePostfixExpression )
                    {
                    // InternalBug303200TestLanguage.g:334:1: (lv_expression_4_0= rulePostfixExpression )
                    // InternalBug303200TestLanguage.g:335:3: lv_expression_4_0= rulePostfixExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAttributeAccess().getExpressionPostfixExpressionParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_expression_4_0=rulePostfixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_4_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.PostfixExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBug303200TestLanguage.g:351:2: (this_LT_5= RULE_LT )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_LT) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalBug303200TestLanguage.g:351:3: this_LT_5= RULE_LT
                    	    {
                    	    this_LT_5=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_LT_5, grammarAccess.getAttributeAccess().getLTTerminalRuleCall_1_4()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,9,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_1_5());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleParameters"
    // InternalBug303200TestLanguage.g:367:1: entryRuleParameters returns [EObject current=null] : iv_ruleParameters= ruleParameters EOF ;
    public final EObject entryRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameters = null;


        try {
            // InternalBug303200TestLanguage.g:368:2: (iv_ruleParameters= ruleParameters EOF )
            // InternalBug303200TestLanguage.g:369:2: iv_ruleParameters= ruleParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParametersRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameters=ruleParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameters; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameters"


    // $ANTLR start "ruleParameters"
    // InternalBug303200TestLanguage.g:376:1: ruleParameters returns [EObject current=null] : ( () otherlv_1= '(' (this_LT_2= RULE_LT )* ( ( (lv_params_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* (otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_params_7_0= RULE_ID ) ) (this_LT_8= RULE_LT )* )* )? otherlv_9= ')' ) ;
    public final EObject ruleParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_LT_2=null;
        Token lv_params_3_0=null;
        Token this_LT_4=null;
        Token otherlv_5=null;
        Token this_LT_6=null;
        Token lv_params_7_0=null;
        Token this_LT_8=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:379:28: ( ( () otherlv_1= '(' (this_LT_2= RULE_LT )* ( ( (lv_params_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* (otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_params_7_0= RULE_ID ) ) (this_LT_8= RULE_LT )* )* )? otherlv_9= ')' ) )
            // InternalBug303200TestLanguage.g:380:1: ( () otherlv_1= '(' (this_LT_2= RULE_LT )* ( ( (lv_params_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* (otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_params_7_0= RULE_ID ) ) (this_LT_8= RULE_LT )* )* )? otherlv_9= ')' )
            {
            // InternalBug303200TestLanguage.g:380:1: ( () otherlv_1= '(' (this_LT_2= RULE_LT )* ( ( (lv_params_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* (otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_params_7_0= RULE_ID ) ) (this_LT_8= RULE_LT )* )* )? otherlv_9= ')' )
            // InternalBug303200TestLanguage.g:380:2: () otherlv_1= '(' (this_LT_2= RULE_LT )* ( ( (lv_params_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* (otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_params_7_0= RULE_ID ) ) (this_LT_8= RULE_LT )* )* )? otherlv_9= ')'
            {
            // InternalBug303200TestLanguage.g:380:2: ()
            // InternalBug303200TestLanguage.g:381:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParametersAccess().getParametersAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,10,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParametersAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalBug303200TestLanguage.g:393:1: (this_LT_2= RULE_LT )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_LT) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:393:2: this_LT_2= RULE_LT
            	    {
            	    this_LT_2=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_LT_2, grammarAccess.getParametersAccess().getLTTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalBug303200TestLanguage.g:397:3: ( ( (lv_params_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* (otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_params_7_0= RULE_ID ) ) (this_LT_8= RULE_LT )* )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalBug303200TestLanguage.g:397:4: ( (lv_params_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* (otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_params_7_0= RULE_ID ) ) (this_LT_8= RULE_LT )* )*
                    {
                    // InternalBug303200TestLanguage.g:397:4: ( (lv_params_3_0= RULE_ID ) )
                    // InternalBug303200TestLanguage.g:398:1: (lv_params_3_0= RULE_ID )
                    {
                    // InternalBug303200TestLanguage.g:398:1: (lv_params_3_0= RULE_ID )
                    // InternalBug303200TestLanguage.g:399:3: lv_params_3_0= RULE_ID
                    {
                    lv_params_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_params_3_0, grammarAccess.getParametersAccess().getParamsIDTerminalRuleCall_3_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getParametersRule());
                      	        }
                             		addWithLastConsumed(
                             			current, 
                             			"params",
                              		lv_params_3_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.ID");
                      	    
                    }

                    }


                    }

                    // InternalBug303200TestLanguage.g:415:2: (this_LT_4= RULE_LT )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_LT) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalBug303200TestLanguage.g:415:3: this_LT_4= RULE_LT
                    	    {
                    	    this_LT_4=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_LT_4, grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // InternalBug303200TestLanguage.g:419:3: (otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_params_7_0= RULE_ID ) ) (this_LT_8= RULE_LT )* )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==11) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalBug303200TestLanguage.g:419:5: otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_params_7_0= RULE_ID ) ) (this_LT_8= RULE_LT )*
                    	    {
                    	    otherlv_5=(Token)match(input,11,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getParametersAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // InternalBug303200TestLanguage.g:423:1: (this_LT_6= RULE_LT )*
                    	    loop14:
                    	    do {
                    	        int alt14=2;
                    	        int LA14_0 = input.LA(1);

                    	        if ( (LA14_0==RULE_LT) ) {
                    	            alt14=1;
                    	        }


                    	        switch (alt14) {
                    	    	case 1 :
                    	    	    // InternalBug303200TestLanguage.g:423:2: this_LT_6= RULE_LT
                    	    	    {
                    	    	    this_LT_6=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	          newLeafNode(this_LT_6, grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_2_1()); 
                    	    	          
                    	    	    }

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop14;
                    	        }
                    	    } while (true);

                    	    // InternalBug303200TestLanguage.g:427:3: ( (lv_params_7_0= RULE_ID ) )
                    	    // InternalBug303200TestLanguage.g:428:1: (lv_params_7_0= RULE_ID )
                    	    {
                    	    // InternalBug303200TestLanguage.g:428:1: (lv_params_7_0= RULE_ID )
                    	    // InternalBug303200TestLanguage.g:429:3: lv_params_7_0= RULE_ID
                    	    {
                    	    lv_params_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_params_7_0, grammarAccess.getParametersAccess().getParamsIDTerminalRuleCall_3_2_2_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getParametersRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"params",
                    	              		lv_params_7_0, 
                    	              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.ID");
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // InternalBug303200TestLanguage.g:445:2: (this_LT_8= RULE_LT )*
                    	    loop15:
                    	    do {
                    	        int alt15=2;
                    	        int LA15_0 = input.LA(1);

                    	        if ( (LA15_0==RULE_LT) ) {
                    	            alt15=1;
                    	        }


                    	        switch (alt15) {
                    	    	case 1 :
                    	    	    // InternalBug303200TestLanguage.g:445:3: this_LT_8= RULE_LT
                    	    	    {
                    	    	    this_LT_8=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	          newLeafNode(this_LT_8, grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_2_3()); 
                    	    	          
                    	    	    }

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop15;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,12,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getParametersAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameters"


    // $ANTLR start "entryRuleBlock"
    // InternalBug303200TestLanguage.g:461:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalBug303200TestLanguage.g:462:2: (iv_ruleBlock= ruleBlock EOF )
            // InternalBug303200TestLanguage.g:463:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalBug303200TestLanguage.g:470:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (this_LT_2= RULE_LT )* ( (lv_directives_3_0= ruleStatement ) ) )* (this_LT_4= RULE_LT )* otherlv_5= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_LT_2=null;
        Token this_LT_4=null;
        Token otherlv_5=null;
        EObject lv_directives_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:473:28: ( ( () otherlv_1= '{' ( (this_LT_2= RULE_LT )* ( (lv_directives_3_0= ruleStatement ) ) )* (this_LT_4= RULE_LT )* otherlv_5= '}' ) )
            // InternalBug303200TestLanguage.g:474:1: ( () otherlv_1= '{' ( (this_LT_2= RULE_LT )* ( (lv_directives_3_0= ruleStatement ) ) )* (this_LT_4= RULE_LT )* otherlv_5= '}' )
            {
            // InternalBug303200TestLanguage.g:474:1: ( () otherlv_1= '{' ( (this_LT_2= RULE_LT )* ( (lv_directives_3_0= ruleStatement ) ) )* (this_LT_4= RULE_LT )* otherlv_5= '}' )
            // InternalBug303200TestLanguage.g:474:2: () otherlv_1= '{' ( (this_LT_2= RULE_LT )* ( (lv_directives_3_0= ruleStatement ) ) )* (this_LT_4= RULE_LT )* otherlv_5= '}'
            {
            // InternalBug303200TestLanguage.g:474:2: ()
            // InternalBug303200TestLanguage.g:475:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBlockAccess().getBlockAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalBug303200TestLanguage.g:487:1: ( (this_LT_2= RULE_LT )* ( (lv_directives_3_0= ruleStatement ) ) )*
            loop19:
            do {
                int alt19=2;
                alt19 = dfa19.predict(input);
                switch (alt19) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:487:2: (this_LT_2= RULE_LT )* ( (lv_directives_3_0= ruleStatement ) )
            	    {
            	    // InternalBug303200TestLanguage.g:487:2: (this_LT_2= RULE_LT )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==RULE_LT) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // InternalBug303200TestLanguage.g:487:3: this_LT_2= RULE_LT
            	    	    {
            	    	    this_LT_2=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_LT_2, grammarAccess.getBlockAccess().getLTTerminalRuleCall_2_0()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop18;
            	        }
            	    } while (true);

            	    // InternalBug303200TestLanguage.g:491:3: ( (lv_directives_3_0= ruleStatement ) )
            	    // InternalBug303200TestLanguage.g:492:1: (lv_directives_3_0= ruleStatement )
            	    {
            	    // InternalBug303200TestLanguage.g:492:1: (lv_directives_3_0= ruleStatement )
            	    // InternalBug303200TestLanguage.g:493:3: lv_directives_3_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBlockAccess().getDirectivesStatementParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_directives_3_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBlockRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"directives",
            	              		lv_directives_3_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalBug303200TestLanguage.g:509:4: (this_LT_4= RULE_LT )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_LT) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:509:5: this_LT_4= RULE_LT
            	    {
            	    this_LT_4=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_LT_4, grammarAccess.getBlockAccess().getLTTerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStatement"
    // InternalBug303200TestLanguage.g:525:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalBug303200TestLanguage.g:526:2: (iv_ruleStatement= ruleStatement EOF )
            // InternalBug303200TestLanguage.g:527:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalBug303200TestLanguage.g:534:1: ruleStatement returns [EObject current=null] : (this_Block_0= ruleBlock | ( () ( (lv_expression_2_0= rulePostfixExpression ) ) (otherlv_3= ';' | this_LT_4= RULE_LT ) ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token this_LT_4=null;
        EObject this_Block_0 = null;

        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:537:28: ( (this_Block_0= ruleBlock | ( () ( (lv_expression_2_0= rulePostfixExpression ) ) (otherlv_3= ';' | this_LT_4= RULE_LT ) ) ) )
            // InternalBug303200TestLanguage.g:538:1: (this_Block_0= ruleBlock | ( () ( (lv_expression_2_0= rulePostfixExpression ) ) (otherlv_3= ';' | this_LT_4= RULE_LT ) ) )
            {
            // InternalBug303200TestLanguage.g:538:1: (this_Block_0= ruleBlock | ( () ( (lv_expression_2_0= rulePostfixExpression ) ) (otherlv_3= ';' | this_LT_4= RULE_LT ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==13) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_ID||LA22_0==7) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalBug303200TestLanguage.g:539:2: this_Block_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Block_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Block_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBug303200TestLanguage.g:551:6: ( () ( (lv_expression_2_0= rulePostfixExpression ) ) (otherlv_3= ';' | this_LT_4= RULE_LT ) )
                    {
                    // InternalBug303200TestLanguage.g:551:6: ( () ( (lv_expression_2_0= rulePostfixExpression ) ) (otherlv_3= ';' | this_LT_4= RULE_LT ) )
                    // InternalBug303200TestLanguage.g:551:7: () ( (lv_expression_2_0= rulePostfixExpression ) ) (otherlv_3= ';' | this_LT_4= RULE_LT )
                    {
                    // InternalBug303200TestLanguage.g:551:7: ()
                    // InternalBug303200TestLanguage.g:552:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStatementAccess().getExpressionStatementAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalBug303200TestLanguage.g:560:2: ( (lv_expression_2_0= rulePostfixExpression ) )
                    // InternalBug303200TestLanguage.g:561:1: (lv_expression_2_0= rulePostfixExpression )
                    {
                    // InternalBug303200TestLanguage.g:561:1: (lv_expression_2_0= rulePostfixExpression )
                    // InternalBug303200TestLanguage.g:562:3: lv_expression_2_0= rulePostfixExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getExpressionPostfixExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_15);
                    lv_expression_2_0=rulePostfixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_2_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.PostfixExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBug303200TestLanguage.g:578:2: (otherlv_3= ';' | this_LT_4= RULE_LT )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==15) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==RULE_LT) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalBug303200TestLanguage.g:578:4: otherlv_3= ';'
                            {
                            otherlv_3=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getStatementAccess().getSemicolonKeyword_1_2_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // InternalBug303200TestLanguage.g:583:6: this_LT_4= RULE_LT
                            {
                            this_LT_4=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_LT_4, grammarAccess.getStatementAccess().getLTTerminalRuleCall_1_2_1()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRulePostfixExpression"
    // InternalBug303200TestLanguage.g:595:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalBug303200TestLanguage.g:596:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalBug303200TestLanguage.g:597:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostfixExpression"


    // $ANTLR start "rulePostfixExpression"
    // InternalBug303200TestLanguage.g:604:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) ) | ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' ) )* ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        Token this_LT_2=null;
        Token this_LT_5=null;
        Token otherlv_6=null;
        Token this_LT_7=null;
        Token this_LT_9=null;
        Token otherlv_10=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_property_3_0 = null;

        EObject lv_arguments_8_0 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:607:28: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) ) | ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' ) )* ) )
            // InternalBug303200TestLanguage.g:608:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) ) | ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' ) )* )
            {
            // InternalBug303200TestLanguage.g:608:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) ) | ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' ) )* )
            // InternalBug303200TestLanguage.g:609:2: this_PrimaryExpression_0= rulePrimaryExpression ( ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) ) | ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_16);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBug303200TestLanguage.g:620:1: ( ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) ) | ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' ) )*
            loop28:
            do {
                int alt28=3;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:620:2: ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) )
            	    {
            	    // InternalBug303200TestLanguage.g:620:2: ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) )
            	    // InternalBug303200TestLanguage.g:620:3: () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) )
            	    {
            	    // InternalBug303200TestLanguage.g:620:3: ()
            	    // InternalBug303200TestLanguage.g:621:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPostfixExpressionAccess().getPostfixExpressionExpressionAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBug303200TestLanguage.g:629:2: (this_LT_2= RULE_LT )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==RULE_LT) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // InternalBug303200TestLanguage.g:629:3: this_LT_2= RULE_LT
            	    	    {
            	    	    this_LT_2=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_17); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_LT_2, grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_0_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop23;
            	        }
            	    } while (true);

            	    // InternalBug303200TestLanguage.g:633:3: ( (lv_property_3_0= rulePropertyOperator ) )
            	    // InternalBug303200TestLanguage.g:634:1: (lv_property_3_0= rulePropertyOperator )
            	    {
            	    // InternalBug303200TestLanguage.g:634:1: (lv_property_3_0= rulePropertyOperator )
            	    // InternalBug303200TestLanguage.g:635:3: lv_property_3_0= rulePropertyOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPropertyPropertyOperatorParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_16);
            	    lv_property_3_0=rulePropertyOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"property",
            	              		lv_property_3_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.PropertyOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBug303200TestLanguage.g:652:6: ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' )
            	    {
            	    // InternalBug303200TestLanguage.g:652:6: ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' )
            	    // InternalBug303200TestLanguage.g:652:7: () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')'
            	    {
            	    // InternalBug303200TestLanguage.g:652:7: ()
            	    // InternalBug303200TestLanguage.g:653:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPostfixExpressionAccess().getInvocationExpressionAction_1_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBug303200TestLanguage.g:661:2: (this_LT_5= RULE_LT )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==RULE_LT) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // InternalBug303200TestLanguage.g:661:3: this_LT_5= RULE_LT
            	    	    {
            	    	    this_LT_5=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_LT_5, grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);

            	    otherlv_6=(Token)match(input,10,FollowSets000.FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getPostfixExpressionAccess().getLeftParenthesisKeyword_1_1_2());
            	          
            	    }
            	    // InternalBug303200TestLanguage.g:669:1: (this_LT_7= RULE_LT )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==RULE_LT) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // InternalBug303200TestLanguage.g:669:2: this_LT_7= RULE_LT
            	    	    {
            	    	    this_LT_7=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_18); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_LT_7, grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_3()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop25;
            	        }
            	    } while (true);

            	    // InternalBug303200TestLanguage.g:673:3: ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==RULE_ID||LA27_0==7) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // InternalBug303200TestLanguage.g:673:4: ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )*
            	            {
            	            // InternalBug303200TestLanguage.g:673:4: ( (lv_arguments_8_0= ruleListExpression ) )
            	            // InternalBug303200TestLanguage.g:674:1: (lv_arguments_8_0= ruleListExpression )
            	            {
            	            // InternalBug303200TestLanguage.g:674:1: (lv_arguments_8_0= ruleListExpression )
            	            // InternalBug303200TestLanguage.g:675:3: lv_arguments_8_0= ruleListExpression
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getArgumentsListExpressionParserRuleCall_1_1_4_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_19);
            	            lv_arguments_8_0=ruleListExpression();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"arguments",
            	                      		lv_arguments_8_0, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.ListExpression");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }

            	            // InternalBug303200TestLanguage.g:691:2: (this_LT_9= RULE_LT )*
            	            loop26:
            	            do {
            	                int alt26=2;
            	                int LA26_0 = input.LA(1);

            	                if ( (LA26_0==RULE_LT) ) {
            	                    alt26=1;
            	                }


            	                switch (alt26) {
            	            	case 1 :
            	            	    // InternalBug303200TestLanguage.g:691:3: this_LT_9= RULE_LT
            	            	    {
            	            	    this_LT_9=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	          newLeafNode(this_LT_9, grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_4_1()); 
            	            	          
            	            	    }

            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop26;
            	                }
            	            } while (true);


            	            }
            	            break;

            	    }

            	    otherlv_10=(Token)match(input,12,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_10, grammarAccess.getPostfixExpressionAccess().getRightParenthesisKeyword_1_1_5());
            	          
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRuleListExpression"
    // InternalBug303200TestLanguage.g:707:1: entryRuleListExpression returns [EObject current=null] : iv_ruleListExpression= ruleListExpression EOF ;
    public final EObject entryRuleListExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListExpression = null;


        try {
            // InternalBug303200TestLanguage.g:708:2: (iv_ruleListExpression= ruleListExpression EOF )
            // InternalBug303200TestLanguage.g:709:2: iv_ruleListExpression= ruleListExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleListExpression=ruleListExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListExpression"


    // $ANTLR start "ruleListExpression"
    // InternalBug303200TestLanguage.g:716:1: ruleListExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= rulePostfixExpression ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ',' (this_LT_3= RULE_LT )* ( (lv_expressions_4_0= rulePostfixExpression ) ) )* ) ;
    public final EObject ruleListExpression() throws RecognitionException {
        EObject current = null;

        Token this_LT_1=null;
        Token otherlv_2=null;
        Token this_LT_3=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:719:28: ( ( ( (lv_expressions_0_0= rulePostfixExpression ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ',' (this_LT_3= RULE_LT )* ( (lv_expressions_4_0= rulePostfixExpression ) ) )* ) )
            // InternalBug303200TestLanguage.g:720:1: ( ( (lv_expressions_0_0= rulePostfixExpression ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ',' (this_LT_3= RULE_LT )* ( (lv_expressions_4_0= rulePostfixExpression ) ) )* )
            {
            // InternalBug303200TestLanguage.g:720:1: ( ( (lv_expressions_0_0= rulePostfixExpression ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ',' (this_LT_3= RULE_LT )* ( (lv_expressions_4_0= rulePostfixExpression ) ) )* )
            // InternalBug303200TestLanguage.g:720:2: ( (lv_expressions_0_0= rulePostfixExpression ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ',' (this_LT_3= RULE_LT )* ( (lv_expressions_4_0= rulePostfixExpression ) ) )*
            {
            // InternalBug303200TestLanguage.g:720:2: ( (lv_expressions_0_0= rulePostfixExpression ) )
            // InternalBug303200TestLanguage.g:721:1: (lv_expressions_0_0= rulePostfixExpression )
            {
            // InternalBug303200TestLanguage.g:721:1: (lv_expressions_0_0= rulePostfixExpression )
            // InternalBug303200TestLanguage.g:722:3: lv_expressions_0_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getListExpressionAccess().getExpressionsPostfixExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_20);
            lv_expressions_0_0=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getListExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"expressions",
                      		lv_expressions_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.PostfixExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBug303200TestLanguage.g:738:2: ( (this_LT_1= RULE_LT )* otherlv_2= ',' (this_LT_3= RULE_LT )* ( (lv_expressions_4_0= rulePostfixExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                alt31 = dfa31.predict(input);
                switch (alt31) {
            	case 1 :
            	    // InternalBug303200TestLanguage.g:738:3: (this_LT_1= RULE_LT )* otherlv_2= ',' (this_LT_3= RULE_LT )* ( (lv_expressions_4_0= rulePostfixExpression ) )
            	    {
            	    // InternalBug303200TestLanguage.g:738:3: (this_LT_1= RULE_LT )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==RULE_LT) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // InternalBug303200TestLanguage.g:738:4: this_LT_1= RULE_LT
            	    	    {
            	    	    this_LT_1=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_21); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_LT_1, grammarAccess.getListExpressionAccess().getLTTerminalRuleCall_1_0()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop29;
            	        }
            	    } while (true);

            	    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getListExpressionAccess().getCommaKeyword_1_1());
            	          
            	    }
            	    // InternalBug303200TestLanguage.g:746:1: (this_LT_3= RULE_LT )*
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==RULE_LT) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // InternalBug303200TestLanguage.g:746:2: this_LT_3= RULE_LT
            	    	    {
            	    	    this_LT_3=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_LT_3, grammarAccess.getListExpressionAccess().getLTTerminalRuleCall_1_2()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop30;
            	        }
            	    } while (true);

            	    // InternalBug303200TestLanguage.g:750:3: ( (lv_expressions_4_0= rulePostfixExpression ) )
            	    // InternalBug303200TestLanguage.g:751:1: (lv_expressions_4_0= rulePostfixExpression )
            	    {
            	    // InternalBug303200TestLanguage.g:751:1: (lv_expressions_4_0= rulePostfixExpression )
            	    // InternalBug303200TestLanguage.g:752:3: lv_expressions_4_0= rulePostfixExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getListExpressionAccess().getExpressionsPostfixExpressionParserRuleCall_1_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    lv_expressions_4_0=rulePostfixExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getListExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_4_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.PostfixExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListExpression"


    // $ANTLR start "entryRulePropertyOperator"
    // InternalBug303200TestLanguage.g:776:1: entryRulePropertyOperator returns [EObject current=null] : iv_rulePropertyOperator= rulePropertyOperator EOF ;
    public final EObject entryRulePropertyOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyOperator = null;


        try {
            // InternalBug303200TestLanguage.g:777:2: (iv_rulePropertyOperator= rulePropertyOperator EOF )
            // InternalBug303200TestLanguage.g:778:2: iv_rulePropertyOperator= rulePropertyOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyOperator=rulePropertyOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyOperator; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyOperator"


    // $ANTLR start "rulePropertyOperator"
    // InternalBug303200TestLanguage.g:785:1: rulePropertyOperator returns [EObject current=null] : ( (otherlv_0= '.' (this_LT_1= RULE_LT )* ( (lv_name_2_0= RULE_ID ) ) ) | (otherlv_3= '[' (this_LT_4= RULE_LT )* ( (lv_expressions_5_0= ruleListExpression ) ) (this_LT_6= RULE_LT )* otherlv_7= ']' ) ) ;
    public final EObject rulePropertyOperator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_LT_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token this_LT_4=null;
        Token this_LT_6=null;
        Token otherlv_7=null;
        EObject lv_expressions_5_0 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:788:28: ( ( (otherlv_0= '.' (this_LT_1= RULE_LT )* ( (lv_name_2_0= RULE_ID ) ) ) | (otherlv_3= '[' (this_LT_4= RULE_LT )* ( (lv_expressions_5_0= ruleListExpression ) ) (this_LT_6= RULE_LT )* otherlv_7= ']' ) ) )
            // InternalBug303200TestLanguage.g:789:1: ( (otherlv_0= '.' (this_LT_1= RULE_LT )* ( (lv_name_2_0= RULE_ID ) ) ) | (otherlv_3= '[' (this_LT_4= RULE_LT )* ( (lv_expressions_5_0= ruleListExpression ) ) (this_LT_6= RULE_LT )* otherlv_7= ']' ) )
            {
            // InternalBug303200TestLanguage.g:789:1: ( (otherlv_0= '.' (this_LT_1= RULE_LT )* ( (lv_name_2_0= RULE_ID ) ) ) | (otherlv_3= '[' (this_LT_4= RULE_LT )* ( (lv_expressions_5_0= ruleListExpression ) ) (this_LT_6= RULE_LT )* otherlv_7= ']' ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            else if ( (LA35_0==8) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalBug303200TestLanguage.g:789:2: (otherlv_0= '.' (this_LT_1= RULE_LT )* ( (lv_name_2_0= RULE_ID ) ) )
                    {
                    // InternalBug303200TestLanguage.g:789:2: (otherlv_0= '.' (this_LT_1= RULE_LT )* ( (lv_name_2_0= RULE_ID ) ) )
                    // InternalBug303200TestLanguage.g:789:4: otherlv_0= '.' (this_LT_1= RULE_LT )* ( (lv_name_2_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getPropertyOperatorAccess().getFullStopKeyword_0_0());
                          
                    }
                    // InternalBug303200TestLanguage.g:793:1: (this_LT_1= RULE_LT )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==RULE_LT) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalBug303200TestLanguage.g:793:2: this_LT_1= RULE_LT
                    	    {
                    	    this_LT_1=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_LT_1, grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_0_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    // InternalBug303200TestLanguage.g:797:3: ( (lv_name_2_0= RULE_ID ) )
                    // InternalBug303200TestLanguage.g:798:1: (lv_name_2_0= RULE_ID )
                    {
                    // InternalBug303200TestLanguage.g:798:1: (lv_name_2_0= RULE_ID )
                    // InternalBug303200TestLanguage.g:799:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_2_0, grammarAccess.getPropertyOperatorAccess().getNameIDTerminalRuleCall_0_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropertyOperatorRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug303200TestLanguage.g:816:6: (otherlv_3= '[' (this_LT_4= RULE_LT )* ( (lv_expressions_5_0= ruleListExpression ) ) (this_LT_6= RULE_LT )* otherlv_7= ']' )
                    {
                    // InternalBug303200TestLanguage.g:816:6: (otherlv_3= '[' (this_LT_4= RULE_LT )* ( (lv_expressions_5_0= ruleListExpression ) ) (this_LT_6= RULE_LT )* otherlv_7= ']' )
                    // InternalBug303200TestLanguage.g:816:8: otherlv_3= '[' (this_LT_4= RULE_LT )* ( (lv_expressions_5_0= ruleListExpression ) ) (this_LT_6= RULE_LT )* otherlv_7= ']'
                    {
                    otherlv_3=(Token)match(input,8,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPropertyOperatorAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // InternalBug303200TestLanguage.g:820:1: (this_LT_4= RULE_LT )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_LT) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalBug303200TestLanguage.g:820:2: this_LT_4= RULE_LT
                    	    {
                    	    this_LT_4=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_LT_4, grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    // InternalBug303200TestLanguage.g:824:3: ( (lv_expressions_5_0= ruleListExpression ) )
                    // InternalBug303200TestLanguage.g:825:1: (lv_expressions_5_0= ruleListExpression )
                    {
                    // InternalBug303200TestLanguage.g:825:1: (lv_expressions_5_0= ruleListExpression )
                    // InternalBug303200TestLanguage.g:826:3: lv_expressions_5_0= ruleListExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyOperatorAccess().getExpressionsListExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_expressions_5_0=ruleListExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyOperatorRule());
                      	        }
                             		set(
                             			current, 
                             			"expressions",
                              		lv_expressions_5_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.ListExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBug303200TestLanguage.g:842:2: (this_LT_6= RULE_LT )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==RULE_LT) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalBug303200TestLanguage.g:842:3: this_LT_6= RULE_LT
                    	    {
                    	    this_LT_6=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_LT_6, grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_1_3()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,9,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getPropertyOperatorAccess().getRightSquareBracketKeyword_1_4());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyOperator"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalBug303200TestLanguage.g:858:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalBug303200TestLanguage.g:859:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalBug303200TestLanguage.g:860:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalBug303200TestLanguage.g:867:1: rulePrimaryExpression returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ( () otherlv_3= 'function' (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token this_LT_4=null;
        Token this_LT_6=null;
        EObject lv_params_5_0 = null;

        EObject lv_body_7_0 = null;


         enterRule(); 
            
        try {
            // InternalBug303200TestLanguage.g:870:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ( () otherlv_3= 'function' (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) ) ) )
            // InternalBug303200TestLanguage.g:871:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ( () otherlv_3= 'function' (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) ) )
            {
            // InternalBug303200TestLanguage.g:871:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ( () otherlv_3= 'function' (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                alt38=1;
            }
            else if ( (LA38_0==7) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalBug303200TestLanguage.g:871:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // InternalBug303200TestLanguage.g:871:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // InternalBug303200TestLanguage.g:871:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // InternalBug303200TestLanguage.g:871:3: ()
                    // InternalBug303200TestLanguage.g:872:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryExpressionAccess().getIdentifierAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalBug303200TestLanguage.g:880:2: ( (lv_name_1_0= RULE_ID ) )
                    // InternalBug303200TestLanguage.g:881:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalBug303200TestLanguage.g:881:1: (lv_name_1_0= RULE_ID )
                    // InternalBug303200TestLanguage.g:882:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getPrimaryExpressionAccess().getNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug303200TestLanguage.g:899:6: ( () otherlv_3= 'function' (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) )
                    {
                    // InternalBug303200TestLanguage.g:899:6: ( () otherlv_3= 'function' (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) ) )
                    // InternalBug303200TestLanguage.g:899:7: () otherlv_3= 'function' (this_LT_4= RULE_LT )* ( (lv_params_5_0= ruleParameters ) ) (this_LT_6= RULE_LT )* ( (lv_body_7_0= ruleBlock ) )
                    {
                    // InternalBug303200TestLanguage.g:899:7: ()
                    // InternalBug303200TestLanguage.g:900:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryExpressionAccess().getFunctionExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,7,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getFunctionKeyword_1_1());
                          
                    }
                    // InternalBug303200TestLanguage.g:912:1: (this_LT_4= RULE_LT )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==RULE_LT) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalBug303200TestLanguage.g:912:2: this_LT_4= RULE_LT
                    	    {
                    	    this_LT_4=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_LT_4, grammarAccess.getPrimaryExpressionAccess().getLTTerminalRuleCall_1_2()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    // InternalBug303200TestLanguage.g:916:3: ( (lv_params_5_0= ruleParameters ) )
                    // InternalBug303200TestLanguage.g:917:1: (lv_params_5_0= ruleParameters )
                    {
                    // InternalBug303200TestLanguage.g:917:1: (lv_params_5_0= ruleParameters )
                    // InternalBug303200TestLanguage.g:918:3: lv_params_5_0= ruleParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParamsParametersParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_params_5_0=ruleParameters();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"params",
                              		lv_params_5_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.Parameters");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBug303200TestLanguage.g:934:2: (this_LT_6= RULE_LT )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==RULE_LT) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalBug303200TestLanguage.g:934:3: this_LT_6= RULE_LT
                    	    {
                    	    this_LT_6=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_LT_6, grammarAccess.getPrimaryExpressionAccess().getLTTerminalRuleCall_1_4()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    // InternalBug303200TestLanguage.g:938:3: ( (lv_body_7_0= ruleBlock ) )
                    // InternalBug303200TestLanguage.g:939:1: (lv_body_7_0= ruleBlock )
                    {
                    // InternalBug303200TestLanguage.g:939:1: (lv_body_7_0= ruleBlock )
                    // InternalBug303200TestLanguage.g:940:3: lv_body_7_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBodyBlockParserRuleCall_1_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_body_7_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"body",
                              		lv_body_7_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug303200TestLanguage.Block");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"

    // $ANTLR start synpred4_InternalBug303200TestLanguage
    public final void synpred4_InternalBug303200TestLanguage_fragment() throws RecognitionException {   
        EObject this_FunctionDefinition_0 = null;


        // InternalBug303200TestLanguage.g:143:2: (this_FunctionDefinition_0= ruleFunctionDefinition )
        // InternalBug303200TestLanguage.g:143:2: this_FunctionDefinition_0= ruleFunctionDefinition
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_FunctionDefinition_0=ruleFunctionDefinition();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalBug303200TestLanguage

    // $ANTLR start synpred24_InternalBug303200TestLanguage
    public final void synpred24_InternalBug303200TestLanguage_fragment() throws RecognitionException {   
        Token this_LT_2=null;
        EObject lv_property_3_0 = null;


        // InternalBug303200TestLanguage.g:620:2: ( ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) ) )
        // InternalBug303200TestLanguage.g:620:2: ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) )
        {
        // InternalBug303200TestLanguage.g:620:2: ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) )
        // InternalBug303200TestLanguage.g:620:3: () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) )
        {
        // InternalBug303200TestLanguage.g:620:3: ()
        // InternalBug303200TestLanguage.g:621:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBug303200TestLanguage.g:629:2: (this_LT_2= RULE_LT )*
        loop47:
        do {
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_LT) ) {
                alt47=1;
            }


            switch (alt47) {
        	case 1 :
        	    // InternalBug303200TestLanguage.g:629:3: this_LT_2= RULE_LT
        	    {
        	    this_LT_2=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_17); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop47;
            }
        } while (true);

        // InternalBug303200TestLanguage.g:633:3: ( (lv_property_3_0= rulePropertyOperator ) )
        // InternalBug303200TestLanguage.g:634:1: (lv_property_3_0= rulePropertyOperator )
        {
        // InternalBug303200TestLanguage.g:634:1: (lv_property_3_0= rulePropertyOperator )
        // InternalBug303200TestLanguage.g:635:3: lv_property_3_0= rulePropertyOperator
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPropertyPropertyOperatorParserRuleCall_1_0_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_property_3_0=rulePropertyOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred24_InternalBug303200TestLanguage

    // $ANTLR start synpred29_InternalBug303200TestLanguage
    public final void synpred29_InternalBug303200TestLanguage_fragment() throws RecognitionException {   
        Token this_LT_5=null;
        Token otherlv_6=null;
        Token this_LT_7=null;
        Token this_LT_9=null;
        Token otherlv_10=null;
        EObject lv_arguments_8_0 = null;


        // InternalBug303200TestLanguage.g:652:6: ( ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' ) )
        // InternalBug303200TestLanguage.g:652:6: ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' )
        {
        // InternalBug303200TestLanguage.g:652:6: ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' )
        // InternalBug303200TestLanguage.g:652:7: () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')'
        {
        // InternalBug303200TestLanguage.g:652:7: ()
        // InternalBug303200TestLanguage.g:653:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBug303200TestLanguage.g:661:2: (this_LT_5= RULE_LT )*
        loop49:
        do {
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_LT) ) {
                alt49=1;
            }


            switch (alt49) {
        	case 1 :
        	    // InternalBug303200TestLanguage.g:661:3: this_LT_5= RULE_LT
        	    {
        	    this_LT_5=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_8); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop49;
            }
        } while (true);

        otherlv_6=(Token)match(input,10,FollowSets000.FOLLOW_18); if (state.failed) return ;
        // InternalBug303200TestLanguage.g:669:1: (this_LT_7= RULE_LT )*
        loop50:
        do {
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_LT) ) {
                alt50=1;
            }


            switch (alt50) {
        	case 1 :
        	    // InternalBug303200TestLanguage.g:669:2: this_LT_7= RULE_LT
        	    {
        	    this_LT_7=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_18); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop50;
            }
        } while (true);

        // InternalBug303200TestLanguage.g:673:3: ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )?
        int alt52=2;
        int LA52_0 = input.LA(1);

        if ( (LA52_0==RULE_ID||LA52_0==7) ) {
            alt52=1;
        }
        switch (alt52) {
            case 1 :
                // InternalBug303200TestLanguage.g:673:4: ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )*
                {
                // InternalBug303200TestLanguage.g:673:4: ( (lv_arguments_8_0= ruleListExpression ) )
                // InternalBug303200TestLanguage.g:674:1: (lv_arguments_8_0= ruleListExpression )
                {
                // InternalBug303200TestLanguage.g:674:1: (lv_arguments_8_0= ruleListExpression )
                // InternalBug303200TestLanguage.g:675:3: lv_arguments_8_0= ruleListExpression
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getArgumentsListExpressionParserRuleCall_1_1_4_0_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_19);
                lv_arguments_8_0=ruleListExpression();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalBug303200TestLanguage.g:691:2: (this_LT_9= RULE_LT )*
                loop51:
                do {
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==RULE_LT) ) {
                        alt51=1;
                    }


                    switch (alt51) {
                	case 1 :
                	    // InternalBug303200TestLanguage.g:691:3: this_LT_9= RULE_LT
                	    {
                	    this_LT_9=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_19); if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop51;
                    }
                } while (true);


                }
                break;

        }

        otherlv_10=(Token)match(input,12,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred29_InternalBug303200TestLanguage

    // Delegated rules

    public final boolean synpred4_InternalBug303200TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalBug303200TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalBug303200TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalBug303200TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalBug303200TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalBug303200TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA31 dfa31 = new DFA31(this);
    static final String dfa_1s = "\4\uffff";
    static final String dfa_2s = "\2\2\2\uffff";
    static final String dfa_3s = "\2\4\2\uffff";
    static final String dfa_4s = "\2\15\2\uffff";
    static final String dfa_5s = "\2\uffff\1\2\1\1";
    static final String dfa_6s = "\4\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\3\1\uffff\2\3\4\uffff\1\3",
            "\1\1\1\3\1\uffff\2\3\4\uffff\1\3",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 95:2: ( (this_LT_1= RULE_LT )* ( (lv_directives_2_0= ruleProgramDirective ) ) )*";
        }
    }
    static final String dfa_8s = "\2\16\2\uffff";
    static final String[] dfa_9s = {
            "\1\1\1\3\1\uffff\1\3\5\uffff\1\3\1\2",
            "\1\1\1\3\1\uffff\1\3\5\uffff\1\3\1\2",
            "",
            ""
    };
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final short[][] dfa_9 = unpackEncodedStringArray(dfa_9s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_3;
            this.max = dfa_8;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_9;
        }
        public String getDescription() {
            return "()* loopback of 487:1: ( (this_LT_2= RULE_LT )* ( (lv_directives_3_0= ruleStatement ) ) )*";
        }
    }
    static final String dfa_10s = "\12\uffff";
    static final String dfa_11s = "\1\2\11\uffff";
    static final String dfa_12s = "\1\4\1\0\10\uffff";
    static final String dfa_13s = "\1\20\1\0\10\uffff";
    static final String dfa_14s = "\2\uffff\1\3\4\uffff\1\1\1\uffff\1\2";
    static final String dfa_15s = "\1\uffff\1\0\10\uffff}>";
    static final String[] dfa_16s = {
            "\1\1\3\uffff\1\7\1\2\1\11\2\2\2\uffff\1\2\1\7",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final char[] dfa_12 = DFA.unpackEncodedStringToUnsignedChars(dfa_12s);
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[][] dfa_16 = unpackEncodedStringArray(dfa_16s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_10;
            this.eof = dfa_11;
            this.min = dfa_12;
            this.max = dfa_13;
            this.accept = dfa_14;
            this.special = dfa_15;
            this.transition = dfa_16;
        }
        public String getDescription() {
            return "()* loopback of 620:1: ( ( () (this_LT_2= RULE_LT )* ( (lv_property_3_0= rulePropertyOperator ) ) ) | ( () (this_LT_5= RULE_LT )* otherlv_6= '(' (this_LT_7= RULE_LT )* ( ( (lv_arguments_8_0= ruleListExpression ) ) (this_LT_9= RULE_LT )* )? otherlv_10= ')' ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalBug303200TestLanguage()) ) {s = 7;}

                        else if ( (synpred29_InternalBug303200TestLanguage()) ) {s = 9;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index28_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_17s = "\2\14\2\uffff";
    static final String[] dfa_18s = {
            "\1\1\4\uffff\1\2\1\uffff\1\3\1\2",
            "\1\1\4\uffff\1\2\1\uffff\1\3\1\2",
            "",
            ""
    };
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_17;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "()* loopback of 738:2: ( (this_LT_1= RULE_LT )* otherlv_2= ',' (this_LT_3= RULE_LT )* ( (lv_expressions_4_0= rulePostfixExpression ) ) )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000021B0L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000021B2L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000001A0L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000210L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001810L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000000061B0L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000010512L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010110L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000000031B0L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000810L});
    }


}