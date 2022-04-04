package com.arsene.dsl.query.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.arsene.dsl.query.services.QueryDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalQueryDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'var'", "'='", "'print'", "'||'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'mod'", "'*'", "'/'", "'^'", "'!'", "'('", "')'", "'true'", "'false'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalQueryDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQueryDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQueryDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalQueryDsl.g"; }



     	private QueryDslGrammarAccess grammarAccess;

        public InternalQueryDslParser(TokenStream input, QueryDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected QueryDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalQueryDsl.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalQueryDsl.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalQueryDsl.g:65:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalQueryDsl.g:71:1: ruleModel returns [EObject current=null] : ( (lv_instructions_0_0= ruleInstruction ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_instructions_0_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:77:2: ( ( (lv_instructions_0_0= ruleInstruction ) )* )
            // InternalQueryDsl.g:78:2: ( (lv_instructions_0_0= ruleInstruction ) )*
            {
            // InternalQueryDsl.g:78:2: ( (lv_instructions_0_0= ruleInstruction ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalQueryDsl.g:79:3: (lv_instructions_0_0= ruleInstruction )
            	    {
            	    // InternalQueryDsl.g:79:3: (lv_instructions_0_0= ruleInstruction )
            	    // InternalQueryDsl.g:80:4: lv_instructions_0_0= ruleInstruction
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getModelAccess().getInstructionsInstructionParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_instructions_0_0=ruleInstruction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getModelRule());
            	      				}
            	      				add(
            	      					current,
            	      					"instructions",
            	      					lv_instructions_0_0,
            	      					"com.arsene.dsl.query.QueryDsl.Instruction");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleInstruction"
    // InternalQueryDsl.g:100:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // InternalQueryDsl.g:100:52: (iv_ruleInstruction= ruleInstruction EOF )
            // InternalQueryDsl.g:101:2: iv_ruleInstruction= ruleInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalQueryDsl.g:107:1: ruleInstruction returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_GlobalCommand_2= ruleGlobalCommand ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_Assignment_1 = null;

        EObject this_GlobalCommand_2 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:113:2: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_GlobalCommand_2= ruleGlobalCommand ) )
            // InternalQueryDsl.g:114:2: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_GlobalCommand_2= ruleGlobalCommand )
            {
            // InternalQueryDsl.g:114:2: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_GlobalCommand_2= ruleGlobalCommand )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalQueryDsl.g:115:3: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getInstructionAccess().getVariableDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableDeclaration_0=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:124:3: this_Assignment_1= ruleAssignment
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getInstructionAccess().getAssignmentParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Assignment_1=ruleAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Assignment_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:133:3: this_GlobalCommand_2= ruleGlobalCommand
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getInstructionAccess().getGlobalCommandParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_GlobalCommand_2=ruleGlobalCommand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_GlobalCommand_2;
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
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalQueryDsl.g:145:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalQueryDsl.g:145:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalQueryDsl.g:146:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalQueryDsl.g:152:1: ruleVariableDeclaration returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_initExp_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_initExp_3_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:158:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_initExp_3_0= ruleExpression ) ) )? ) )
            // InternalQueryDsl.g:159:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_initExp_3_0= ruleExpression ) ) )? )
            {
            // InternalQueryDsl.g:159:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_initExp_3_0= ruleExpression ) ) )? )
            // InternalQueryDsl.g:160:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_initExp_3_0= ruleExpression ) ) )?
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVariableDeclarationAccess().getVarKeyword_0());
              		
            }
            // InternalQueryDsl.g:164:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQueryDsl.g:165:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQueryDsl.g:165:4: (lv_name_1_0= RULE_ID )
            // InternalQueryDsl.g:166:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalQueryDsl.g:182:3: (otherlv_2= '=' ( (lv_initExp_3_0= ruleExpression ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalQueryDsl.g:183:4: otherlv_2= '=' ( (lv_initExp_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalQueryDsl.g:187:4: ( (lv_initExp_3_0= ruleExpression ) )
                    // InternalQueryDsl.g:188:5: (lv_initExp_3_0= ruleExpression )
                    {
                    // InternalQueryDsl.g:188:5: (lv_initExp_3_0= ruleExpression )
                    // InternalQueryDsl.g:189:6: lv_initExp_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitExpExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_initExp_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"initExp",
                      							lv_initExp_3_0,
                      							"com.arsene.dsl.query.QueryDsl.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleVarRef"
    // InternalQueryDsl.g:211:1: entryRuleVarRef returns [EObject current=null] : iv_ruleVarRef= ruleVarRef EOF ;
    public final EObject entryRuleVarRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarRef = null;


        try {
            // InternalQueryDsl.g:211:47: (iv_ruleVarRef= ruleVarRef EOF )
            // InternalQueryDsl.g:212:2: iv_ruleVarRef= ruleVarRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarRef=ruleVarRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVarRef"


    // $ANTLR start "ruleVarRef"
    // InternalQueryDsl.g:218:1: ruleVarRef returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVarRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:224:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalQueryDsl.g:225:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalQueryDsl.g:225:2: ( (otherlv_0= RULE_ID ) )
            // InternalQueryDsl.g:226:3: (otherlv_0= RULE_ID )
            {
            // InternalQueryDsl.g:226:3: (otherlv_0= RULE_ID )
            // InternalQueryDsl.g:227:4: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getVarRefRule());
              				}
              			
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_0, grammarAccess.getVarRefAccess().getRefVariableDeclarationCrossReference_0());
              			
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
    // $ANTLR end "ruleVarRef"


    // $ANTLR start "entryRuleAssignment"
    // InternalQueryDsl.g:241:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalQueryDsl.g:241:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalQueryDsl.g:242:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalQueryDsl.g:248:1: ruleAssignment returns [EObject current=null] : ( ( (lv_v_0_0= ruleVarRef ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_v_0_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:254:2: ( ( ( (lv_v_0_0= ruleVarRef ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:255:2: ( ( (lv_v_0_0= ruleVarRef ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:255:2: ( ( (lv_v_0_0= ruleVarRef ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExpression ) ) )
            // InternalQueryDsl.g:256:3: ( (lv_v_0_0= ruleVarRef ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExpression ) )
            {
            // InternalQueryDsl.g:256:3: ( (lv_v_0_0= ruleVarRef ) )
            // InternalQueryDsl.g:257:4: (lv_v_0_0= ruleVarRef )
            {
            // InternalQueryDsl.g:257:4: (lv_v_0_0= ruleVarRef )
            // InternalQueryDsl.g:258:5: lv_v_0_0= ruleVarRef
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentAccess().getVVarRefParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_v_0_0=ruleVarRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignmentRule());
              					}
              					set(
              						current,
              						"v",
              						lv_v_0_0,
              						"com.arsene.dsl.query.QueryDsl.VarRef");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalQueryDsl.g:279:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:280:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:280:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:281:5: lv_exp_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentAccess().getExpExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_exp_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignmentRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_2_0,
              						"com.arsene.dsl.query.QueryDsl.Expression");
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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleGlobalCommand"
    // InternalQueryDsl.g:302:1: entryRuleGlobalCommand returns [EObject current=null] : iv_ruleGlobalCommand= ruleGlobalCommand EOF ;
    public final EObject entryRuleGlobalCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalCommand = null;


        try {
            // InternalQueryDsl.g:302:54: (iv_ruleGlobalCommand= ruleGlobalCommand EOF )
            // InternalQueryDsl.g:303:2: iv_ruleGlobalCommand= ruleGlobalCommand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGlobalCommandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGlobalCommand=ruleGlobalCommand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGlobalCommand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleGlobalCommand"


    // $ANTLR start "ruleGlobalCommand"
    // InternalQueryDsl.g:309:1: ruleGlobalCommand returns [EObject current=null] : ( () otherlv_1= 'print' ( (lv_params_2_0= ruleExpression ) ) ) ;
    public final EObject ruleGlobalCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_params_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:315:2: ( ( () otherlv_1= 'print' ( (lv_params_2_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:316:2: ( () otherlv_1= 'print' ( (lv_params_2_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:316:2: ( () otherlv_1= 'print' ( (lv_params_2_0= ruleExpression ) ) )
            // InternalQueryDsl.g:317:3: () otherlv_1= 'print' ( (lv_params_2_0= ruleExpression ) )
            {
            // InternalQueryDsl.g:317:3: ()
            // InternalQueryDsl.g:318:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getGlobalCommandAccess().getPrintCommandAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,13,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getGlobalCommandAccess().getPrintKeyword_1());
              		
            }
            // InternalQueryDsl.g:328:3: ( (lv_params_2_0= ruleExpression ) )
            // InternalQueryDsl.g:329:4: (lv_params_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:329:4: (lv_params_2_0= ruleExpression )
            // InternalQueryDsl.g:330:5: lv_params_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGlobalCommandAccess().getParamsExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_params_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getGlobalCommandRule());
              					}
              					add(
              						current,
              						"params",
              						lv_params_2_0,
              						"com.arsene.dsl.query.QueryDsl.Expression");
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
    // $ANTLR end "ruleGlobalCommand"


    // $ANTLR start "entryRuleExpression"
    // InternalQueryDsl.g:351:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalQueryDsl.g:351:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalQueryDsl.g:352:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalQueryDsl.g:358:1: ruleExpression returns [EObject current=null] : this_Or_0= ruleOr ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Or_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:364:2: (this_Or_0= ruleOr )
            // InternalQueryDsl.g:365:2: this_Or_0= ruleOr
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getOrParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_Or_0=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Or_0;
              		afterParserOrEnumRuleCall();
              	
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOr"
    // InternalQueryDsl.g:376:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalQueryDsl.g:376:43: (iv_ruleOr= ruleOr EOF )
            // InternalQueryDsl.g:377:2: iv_ruleOr= ruleOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalQueryDsl.g:383:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '||' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:389:2: ( (this_And_0= ruleAnd ( () otherlv_2= '||' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalQueryDsl.g:390:2: (this_And_0= ruleAnd ( () otherlv_2= '||' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalQueryDsl.g:390:2: (this_And_0= ruleAnd ( () otherlv_2= '||' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalQueryDsl.g:391:3: this_And_0= ruleAnd ( () otherlv_2= '||' ( (lv_right_3_0= ruleAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_8);
            this_And_0=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_And_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalQueryDsl.g:399:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleAnd ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalQueryDsl.g:400:4: () otherlv_2= '||' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalQueryDsl.g:400:4: ()
            	    // InternalQueryDsl.g:401:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,14,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalQueryDsl.g:411:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalQueryDsl.g:412:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalQueryDsl.g:412:5: (lv_right_3_0= ruleAnd )
            	    // InternalQueryDsl.g:413:6: lv_right_3_0= ruleAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.dsl.query.QueryDsl.And");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalQueryDsl.g:435:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalQueryDsl.g:435:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalQueryDsl.g:436:2: iv_ruleAnd= ruleAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalQueryDsl.g:442:1: ruleAnd returns [EObject current=null] : (this_Equality_0= ruleEquality ( () otherlv_2= '&&' ( (lv_right_3_0= ruleEquality ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Equality_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:448:2: ( (this_Equality_0= ruleEquality ( () otherlv_2= '&&' ( (lv_right_3_0= ruleEquality ) ) )* ) )
            // InternalQueryDsl.g:449:2: (this_Equality_0= ruleEquality ( () otherlv_2= '&&' ( (lv_right_3_0= ruleEquality ) ) )* )
            {
            // InternalQueryDsl.g:449:2: (this_Equality_0= ruleEquality ( () otherlv_2= '&&' ( (lv_right_3_0= ruleEquality ) ) )* )
            // InternalQueryDsl.g:450:3: this_Equality_0= ruleEquality ( () otherlv_2= '&&' ( (lv_right_3_0= ruleEquality ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndAccess().getEqualityParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_9);
            this_Equality_0=ruleEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Equality_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalQueryDsl.g:458:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleEquality ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalQueryDsl.g:459:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleEquality ) )
            	    {
            	    // InternalQueryDsl.g:459:4: ()
            	    // InternalQueryDsl.g:460:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,15,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalQueryDsl.g:470:4: ( (lv_right_3_0= ruleEquality ) )
            	    // InternalQueryDsl.g:471:5: (lv_right_3_0= ruleEquality )
            	    {
            	    // InternalQueryDsl.g:471:5: (lv_right_3_0= ruleEquality )
            	    // InternalQueryDsl.g:472:6: lv_right_3_0= ruleEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_right_3_0=ruleEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.dsl.query.QueryDsl.Equality");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleEquality"
    // InternalQueryDsl.g:494:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // InternalQueryDsl.g:494:49: (iv_ruleEquality= ruleEquality EOF )
            // InternalQueryDsl.g:495:2: iv_ruleEquality= ruleEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEquality=ruleEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquality; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalQueryDsl.g:501:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:507:2: ( (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalQueryDsl.g:508:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalQueryDsl.g:508:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalQueryDsl.g:509:3: this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_10);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Comparison_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalQueryDsl.g:517:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=16 && LA7_0<=17)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalQueryDsl.g:518:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalQueryDsl.g:518:4: ()
            	    // InternalQueryDsl.g:519:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalQueryDsl.g:525:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalQueryDsl.g:526:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalQueryDsl.g:526:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalQueryDsl.g:527:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalQueryDsl.g:527:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==16) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==17) ) {
            	        alt6=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalQueryDsl.g:528:7: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,16,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalQueryDsl.g:539:7: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,17,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalQueryDsl.g:552:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalQueryDsl.g:553:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalQueryDsl.g:553:5: (lv_right_3_0= ruleComparison )
            	    // InternalQueryDsl.g:554:6: lv_right_3_0= ruleComparison
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.dsl.query.QueryDsl.Comparison");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // InternalQueryDsl.g:576:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalQueryDsl.g:576:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalQueryDsl.g:577:2: iv_ruleComparison= ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparison; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalQueryDsl.g:583:1: ruleComparison returns [EObject current=null] : (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_PlusOrMinus_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:589:2: ( (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* ) )
            // InternalQueryDsl.g:590:2: (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* )
            {
            // InternalQueryDsl.g:590:2: (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* )
            // InternalQueryDsl.g:591:3: this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonAccess().getPlusOrMinusParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_11);
            this_PlusOrMinus_0=rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PlusOrMinus_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalQueryDsl.g:599:3: ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=18 && LA9_0<=21)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalQueryDsl.g:600:4: () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) )
            	    {
            	    // InternalQueryDsl.g:600:4: ()
            	    // InternalQueryDsl.g:601:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalQueryDsl.g:607:4: ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) )
            	    // InternalQueryDsl.g:608:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    {
            	    // InternalQueryDsl.g:608:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    // InternalQueryDsl.g:609:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    {
            	    // InternalQueryDsl.g:609:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    int alt8=4;
            	    switch ( input.LA(1) ) {
            	    case 18:
            	        {
            	        alt8=1;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt8=2;
            	        }
            	        break;
            	    case 20:
            	        {
            	        alt8=3;
            	        }
            	        break;
            	    case 21:
            	        {
            	        alt8=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // InternalQueryDsl.g:610:7: lv_op_2_1= '>='
            	            {
            	            lv_op_2_1=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalQueryDsl.g:621:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalQueryDsl.g:632:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,20,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalQueryDsl.g:643:7: lv_op_2_4= '<'
            	            {
            	            lv_op_2_4=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalQueryDsl.g:656:4: ( (lv_right_3_0= rulePlusOrMinus ) )
            	    // InternalQueryDsl.g:657:5: (lv_right_3_0= rulePlusOrMinus )
            	    {
            	    // InternalQueryDsl.g:657:5: (lv_right_3_0= rulePlusOrMinus )
            	    // InternalQueryDsl.g:658:6: lv_right_3_0= rulePlusOrMinus
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonAccess().getRightPlusOrMinusParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_right_3_0=rulePlusOrMinus();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getComparisonRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.dsl.query.QueryDsl.PlusOrMinus");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRulePlusOrMinus"
    // InternalQueryDsl.g:680:1: entryRulePlusOrMinus returns [EObject current=null] : iv_rulePlusOrMinus= rulePlusOrMinus EOF ;
    public final EObject entryRulePlusOrMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusOrMinus = null;


        try {
            // InternalQueryDsl.g:680:52: (iv_rulePlusOrMinus= rulePlusOrMinus EOF )
            // InternalQueryDsl.g:681:2: iv_rulePlusOrMinus= rulePlusOrMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusOrMinusRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePlusOrMinus=rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusOrMinus; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePlusOrMinus"


    // $ANTLR start "rulePlusOrMinus"
    // InternalQueryDsl.g:687:1: rulePlusOrMinus returns [EObject current=null] : (this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )* ) ;
    public final EObject rulePlusOrMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Mod_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:693:2: ( (this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )* ) )
            // InternalQueryDsl.g:694:2: (this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )* )
            {
            // InternalQueryDsl.g:694:2: (this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )* )
            // InternalQueryDsl.g:695:3: this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPlusOrMinusAccess().getModParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_12);
            this_Mod_0=ruleMod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Mod_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalQueryDsl.g:703:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=22 && LA11_0<=23)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalQueryDsl.g:704:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) )
            	    {
            	    // InternalQueryDsl.g:704:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==22) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==23) ) {
            	        alt10=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // InternalQueryDsl.g:705:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalQueryDsl.g:705:5: ( () otherlv_2= '+' )
            	            // InternalQueryDsl.g:706:6: () otherlv_2= '+'
            	            {
            	            // InternalQueryDsl.g:706:6: ()
            	            // InternalQueryDsl.g:707:7: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              							current = forceCreateModelElementAndSet(
            	              								grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0(),
            	              								current);
            	              						
            	            }

            	            }

            	            otherlv_2=(Token)match(input,22,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_2, grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1());
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalQueryDsl.g:719:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalQueryDsl.g:719:5: ( () otherlv_4= '-' )
            	            // InternalQueryDsl.g:720:6: () otherlv_4= '-'
            	            {
            	            // InternalQueryDsl.g:720:6: ()
            	            // InternalQueryDsl.g:721:7: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              							current = forceCreateModelElementAndSet(
            	              								grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0(),
            	              								current);
            	              						
            	            }

            	            }

            	            otherlv_4=(Token)match(input,23,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_4, grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1());
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // InternalQueryDsl.g:733:4: ( (lv_right_5_0= ruleMod ) )
            	    // InternalQueryDsl.g:734:5: (lv_right_5_0= ruleMod )
            	    {
            	    // InternalQueryDsl.g:734:5: (lv_right_5_0= ruleMod )
            	    // InternalQueryDsl.g:735:6: lv_right_5_0= ruleMod
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPlusOrMinusAccess().getRightModParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_right_5_0=ruleMod();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPlusOrMinusRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_5_0,
            	      							"com.arsene.dsl.query.QueryDsl.Mod");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // $ANTLR end "rulePlusOrMinus"


    // $ANTLR start "entryRuleMod"
    // InternalQueryDsl.g:757:1: entryRuleMod returns [EObject current=null] : iv_ruleMod= ruleMod EOF ;
    public final EObject entryRuleMod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMod = null;


        try {
            // InternalQueryDsl.g:757:44: (iv_ruleMod= ruleMod EOF )
            // InternalQueryDsl.g:758:2: iv_ruleMod= ruleMod EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMod=ruleMod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMod; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMod"


    // $ANTLR start "ruleMod"
    // InternalQueryDsl.g:764:1: ruleMod returns [EObject current=null] : (this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= 'mod' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )* ) ;
    public final EObject ruleMod() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_MulOrDiv_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:770:2: ( (this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= 'mod' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )* ) )
            // InternalQueryDsl.g:771:2: (this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= 'mod' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )* )
            {
            // InternalQueryDsl.g:771:2: (this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= 'mod' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )* )
            // InternalQueryDsl.g:772:3: this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= 'mod' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getModAccess().getMulOrDivParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_13);
            this_MulOrDiv_0=ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MulOrDiv_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalQueryDsl.g:780:3: ( ( () ( (lv_op_2_0= 'mod' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalQueryDsl.g:781:4: ( () ( (lv_op_2_0= 'mod' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) )
            	    {
            	    // InternalQueryDsl.g:781:4: ( () ( (lv_op_2_0= 'mod' ) ) )
            	    // InternalQueryDsl.g:782:5: () ( (lv_op_2_0= 'mod' ) )
            	    {
            	    // InternalQueryDsl.g:782:5: ()
            	    // InternalQueryDsl.g:783:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getModAccess().getModLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalQueryDsl.g:789:5: ( (lv_op_2_0= 'mod' ) )
            	    // InternalQueryDsl.g:790:6: (lv_op_2_0= 'mod' )
            	    {
            	    // InternalQueryDsl.g:790:6: (lv_op_2_0= 'mod' )
            	    // InternalQueryDsl.g:791:7: lv_op_2_0= 'mod'
            	    {
            	    lv_op_2_0=(Token)match(input,24,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_op_2_0, grammarAccess.getModAccess().getOpModKeyword_1_0_1_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getModRule());
            	      							}
            	      							setWithLastConsumed(current, "op", lv_op_2_0, "mod");
            	      						
            	    }

            	    }


            	    }


            	    }

            	    // InternalQueryDsl.g:804:4: ( (lv_right_3_0= ruleMulOrDiv ) )
            	    // InternalQueryDsl.g:805:5: (lv_right_3_0= ruleMulOrDiv )
            	    {
            	    // InternalQueryDsl.g:805:5: (lv_right_3_0= ruleMulOrDiv )
            	    // InternalQueryDsl.g:806:6: lv_right_3_0= ruleMulOrDiv
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModAccess().getRightMulOrDivParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_right_3_0=ruleMulOrDiv();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getModRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.dsl.query.QueryDsl.MulOrDiv");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // $ANTLR end "ruleMod"


    // $ANTLR start "entryRuleMulOrDiv"
    // InternalQueryDsl.g:828:1: entryRuleMulOrDiv returns [EObject current=null] : iv_ruleMulOrDiv= ruleMulOrDiv EOF ;
    public final EObject entryRuleMulOrDiv() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMulOrDiv = null;


        try {
            // InternalQueryDsl.g:828:49: (iv_ruleMulOrDiv= ruleMulOrDiv EOF )
            // InternalQueryDsl.g:829:2: iv_ruleMulOrDiv= ruleMulOrDiv EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMulOrDivRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMulOrDiv=ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMulOrDiv; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMulOrDiv"


    // $ANTLR start "ruleMulOrDiv"
    // InternalQueryDsl.g:835:1: ruleMulOrDiv returns [EObject current=null] : (this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )* ) ;
    public final EObject ruleMulOrDiv() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Expo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:841:2: ( (this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )* ) )
            // InternalQueryDsl.g:842:2: (this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )* )
            {
            // InternalQueryDsl.g:842:2: (this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )* )
            // InternalQueryDsl.g:843:3: this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMulOrDivAccess().getExpoParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_14);
            this_Expo_0=ruleExpo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expo_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalQueryDsl.g:851:3: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=25 && LA14_0<=26)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalQueryDsl.g:852:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) )
            	    {
            	    // InternalQueryDsl.g:852:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
            	    // InternalQueryDsl.g:853:5: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    {
            	    // InternalQueryDsl.g:853:5: ()
            	    // InternalQueryDsl.g:854:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMulOrDivAccess().getMulOrDivLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalQueryDsl.g:860:5: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // InternalQueryDsl.g:861:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // InternalQueryDsl.g:861:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // InternalQueryDsl.g:862:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // InternalQueryDsl.g:862:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==25) ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0==26) ) {
            	        alt13=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // InternalQueryDsl.g:863:8: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,25,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getMulOrDivAccess().getOpAsteriskKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMulOrDivRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalQueryDsl.g:874:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getMulOrDivAccess().getOpSolidusKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMulOrDivRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalQueryDsl.g:888:4: ( (lv_right_3_0= ruleExpo ) )
            	    // InternalQueryDsl.g:889:5: (lv_right_3_0= ruleExpo )
            	    {
            	    // InternalQueryDsl.g:889:5: (lv_right_3_0= ruleExpo )
            	    // InternalQueryDsl.g:890:6: lv_right_3_0= ruleExpo
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMulOrDivAccess().getRightExpoParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_right_3_0=ruleExpo();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMulOrDivRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.dsl.query.QueryDsl.Expo");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "ruleMulOrDiv"


    // $ANTLR start "entryRuleExpo"
    // InternalQueryDsl.g:912:1: entryRuleExpo returns [EObject current=null] : iv_ruleExpo= ruleExpo EOF ;
    public final EObject entryRuleExpo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpo = null;


        try {
            // InternalQueryDsl.g:912:45: (iv_ruleExpo= ruleExpo EOF )
            // InternalQueryDsl.g:913:2: iv_ruleExpo= ruleExpo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpoRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpo=ruleExpo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpo; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExpo"


    // $ANTLR start "ruleExpo"
    // InternalQueryDsl.g:919:1: ruleExpo returns [EObject current=null] : (this_Prefixed_0= rulePrefixed ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) ;
    public final EObject ruleExpo() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_Prefixed_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:925:2: ( (this_Prefixed_0= rulePrefixed ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) )
            // InternalQueryDsl.g:926:2: (this_Prefixed_0= rulePrefixed ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            {
            // InternalQueryDsl.g:926:2: (this_Prefixed_0= rulePrefixed ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            // InternalQueryDsl.g:927:3: this_Prefixed_0= rulePrefixed ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExpoAccess().getPrefixedParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_15);
            this_Prefixed_0=rulePrefixed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Prefixed_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalQueryDsl.g:935:3: ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==27) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalQueryDsl.g:936:4: ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrefixed ) )
            	    {
            	    // InternalQueryDsl.g:936:4: ( () ( (lv_op_2_0= '^' ) ) )
            	    // InternalQueryDsl.g:937:5: () ( (lv_op_2_0= '^' ) )
            	    {
            	    // InternalQueryDsl.g:937:5: ()
            	    // InternalQueryDsl.g:938:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getExpoAccess().getExpoLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalQueryDsl.g:944:5: ( (lv_op_2_0= '^' ) )
            	    // InternalQueryDsl.g:945:6: (lv_op_2_0= '^' )
            	    {
            	    // InternalQueryDsl.g:945:6: (lv_op_2_0= '^' )
            	    // InternalQueryDsl.g:946:7: lv_op_2_0= '^'
            	    {
            	    lv_op_2_0=(Token)match(input,27,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_op_2_0, grammarAccess.getExpoAccess().getOpCircumflexAccentKeyword_1_0_1_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getExpoRule());
            	      							}
            	      							setWithLastConsumed(current, "op", lv_op_2_0, "^");
            	      						
            	    }

            	    }


            	    }


            	    }

            	    // InternalQueryDsl.g:959:4: ( (lv_right_3_0= rulePrefixed ) )
            	    // InternalQueryDsl.g:960:5: (lv_right_3_0= rulePrefixed )
            	    {
            	    // InternalQueryDsl.g:960:5: (lv_right_3_0= rulePrefixed )
            	    // InternalQueryDsl.g:961:6: lv_right_3_0= rulePrefixed
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getExpoAccess().getRightPrefixedParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_right_3_0=rulePrefixed();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getExpoRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.dsl.query.QueryDsl.Prefixed");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "ruleExpo"


    // $ANTLR start "entryRulePrefixed"
    // InternalQueryDsl.g:983:1: entryRulePrefixed returns [EObject current=null] : iv_rulePrefixed= rulePrefixed EOF ;
    public final EObject entryRulePrefixed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixed = null;


        try {
            // InternalQueryDsl.g:983:49: (iv_rulePrefixed= rulePrefixed EOF )
            // InternalQueryDsl.g:984:2: iv_rulePrefixed= rulePrefixed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrefixed=rulePrefixed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixed; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrefixed"


    // $ANTLR start "rulePrefixed"
    // InternalQueryDsl.g:990:1: rulePrefixed returns [EObject current=null] : ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) ;
    public final EObject rulePrefixed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expression_2_0 = null;

        EObject lv_expression_5_0 = null;

        EObject this_Atomic_6 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:996:2: ( ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) )
            // InternalQueryDsl.g:997:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            {
            // InternalQueryDsl.g:997:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt16=1;
                }
                break;
            case 23:
                {
                alt16=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 29:
            case 31:
            case 32:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalQueryDsl.g:998:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    {
                    // InternalQueryDsl.g:998:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    // InternalQueryDsl.g:999:4: () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) )
                    {
                    // InternalQueryDsl.g:999:4: ()
                    // InternalQueryDsl.g:1000:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getNotAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalQueryDsl.g:1006:4: ( ( '!' )=>otherlv_1= '!' )
                    // InternalQueryDsl.g:1007:5: ( '!' )=>otherlv_1= '!'
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1());
                      				
                    }

                    }

                    // InternalQueryDsl.g:1013:4: ( (lv_expression_2_0= ruleAtomic ) )
                    // InternalQueryDsl.g:1014:5: (lv_expression_2_0= ruleAtomic )
                    {
                    // InternalQueryDsl.g:1014:5: (lv_expression_2_0= ruleAtomic )
                    // InternalQueryDsl.g:1015:6: lv_expression_2_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixedRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_2_0,
                      							"com.arsene.dsl.query.QueryDsl.Atomic");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1034:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    {
                    // InternalQueryDsl.g:1034:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    // InternalQueryDsl.g:1035:4: () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) )
                    {
                    // InternalQueryDsl.g:1035:4: ()
                    // InternalQueryDsl.g:1036:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalQueryDsl.g:1042:4: ( ( '-' )=>otherlv_4= '-' )
                    // InternalQueryDsl.g:1043:5: ( '-' )=>otherlv_4= '-'
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1());
                      				
                    }

                    }

                    // InternalQueryDsl.g:1049:4: ( (lv_expression_5_0= ruleAtomic ) )
                    // InternalQueryDsl.g:1050:5: (lv_expression_5_0= ruleAtomic )
                    {
                    // InternalQueryDsl.g:1050:5: (lv_expression_5_0= ruleAtomic )
                    // InternalQueryDsl.g:1051:6: lv_expression_5_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_5_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixedRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_5_0,
                      							"com.arsene.dsl.query.QueryDsl.Atomic");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1070:3: this_Atomic_6= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrefixedAccess().getAtomicParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Atomic_6=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Atomic_6;
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
    // $ANTLR end "rulePrefixed"


    // $ANTLR start "entryRuleAtomic"
    // InternalQueryDsl.g:1082:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // InternalQueryDsl.g:1082:47: (iv_ruleAtomic= ruleAtomic EOF )
            // InternalQueryDsl.g:1083:2: iv_ruleAtomic= ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomic; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // InternalQueryDsl.g:1089:1: ruleAtomic returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_value_5_0= RULE_INT ) ) ) | ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) ) | ( () ( (lv_value_9_0= RULE_STRING ) ) ) | this_VarRef_10= ruleVarRef ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_value_5_0=null;
        Token lv_value_7_1=null;
        Token lv_value_7_2=null;
        Token lv_value_9_0=null;
        EObject lv_expr_2_0 = null;

        EObject this_VarRef_10 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:1095:2: ( ( ( () otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_value_5_0= RULE_INT ) ) ) | ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) ) | ( () ( (lv_value_9_0= RULE_STRING ) ) ) | this_VarRef_10= ruleVarRef ) )
            // InternalQueryDsl.g:1096:2: ( ( () otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_value_5_0= RULE_INT ) ) ) | ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) ) | ( () ( (lv_value_9_0= RULE_STRING ) ) ) | this_VarRef_10= ruleVarRef )
            {
            // InternalQueryDsl.g:1096:2: ( ( () otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_value_5_0= RULE_INT ) ) ) | ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) ) | ( () ( (lv_value_9_0= RULE_STRING ) ) ) | this_VarRef_10= ruleVarRef )
            int alt18=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt18=1;
                }
                break;
            case RULE_INT:
                {
                alt18=2;
                }
                break;
            case 31:
            case 32:
                {
                alt18=3;
                }
                break;
            case RULE_STRING:
                {
                alt18=4;
                }
                break;
            case RULE_ID:
                {
                alt18=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalQueryDsl.g:1097:3: ( () otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalQueryDsl.g:1097:3: ( () otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalQueryDsl.g:1098:4: () otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    // InternalQueryDsl.g:1098:4: ()
                    // InternalQueryDsl.g:1099:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getPrimaryAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalQueryDsl.g:1109:4: ( (lv_expr_2_0= ruleExpression ) )
                    // InternalQueryDsl.g:1110:5: (lv_expr_2_0= ruleExpression )
                    {
                    // InternalQueryDsl.g:1110:5: (lv_expr_2_0= ruleExpression )
                    // InternalQueryDsl.g:1111:6: lv_expr_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getExprExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_expr_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_2_0,
                      							"com.arsene.dsl.query.QueryDsl.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1134:3: ( () ( (lv_value_5_0= RULE_INT ) ) )
                    {
                    // InternalQueryDsl.g:1134:3: ( () ( (lv_value_5_0= RULE_INT ) ) )
                    // InternalQueryDsl.g:1135:4: () ( (lv_value_5_0= RULE_INT ) )
                    {
                    // InternalQueryDsl.g:1135:4: ()
                    // InternalQueryDsl.g:1136:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getIntConstantAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalQueryDsl.g:1142:4: ( (lv_value_5_0= RULE_INT ) )
                    // InternalQueryDsl.g:1143:5: (lv_value_5_0= RULE_INT )
                    {
                    // InternalQueryDsl.g:1143:5: (lv_value_5_0= RULE_INT )
                    // InternalQueryDsl.g:1144:6: lv_value_5_0= RULE_INT
                    {
                    lv_value_5_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_5_0, grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_5_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1162:3: ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) )
                    {
                    // InternalQueryDsl.g:1162:3: ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) )
                    // InternalQueryDsl.g:1163:4: () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) )
                    {
                    // InternalQueryDsl.g:1163:4: ()
                    // InternalQueryDsl.g:1164:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getBoolConstantAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalQueryDsl.g:1170:4: ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) )
                    // InternalQueryDsl.g:1171:5: ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) )
                    {
                    // InternalQueryDsl.g:1171:5: ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) )
                    // InternalQueryDsl.g:1172:6: (lv_value_7_1= 'true' | lv_value_7_2= 'false' )
                    {
                    // InternalQueryDsl.g:1172:6: (lv_value_7_1= 'true' | lv_value_7_2= 'false' )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==31) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==32) ) {
                        alt17=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalQueryDsl.g:1173:7: lv_value_7_1= 'true'
                            {
                            lv_value_7_1=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_7_1, grammarAccess.getAtomicAccess().getValueTrueKeyword_2_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_7_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalQueryDsl.g:1184:7: lv_value_7_2= 'false'
                            {
                            lv_value_7_2=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_7_2, grammarAccess.getAtomicAccess().getValueFalseKeyword_2_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_7_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1199:3: ( () ( (lv_value_9_0= RULE_STRING ) ) )
                    {
                    // InternalQueryDsl.g:1199:3: ( () ( (lv_value_9_0= RULE_STRING ) ) )
                    // InternalQueryDsl.g:1200:4: () ( (lv_value_9_0= RULE_STRING ) )
                    {
                    // InternalQueryDsl.g:1200:4: ()
                    // InternalQueryDsl.g:1201:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getStringConstantAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalQueryDsl.g:1207:4: ( (lv_value_9_0= RULE_STRING ) )
                    // InternalQueryDsl.g:1208:5: (lv_value_9_0= RULE_STRING )
                    {
                    // InternalQueryDsl.g:1208:5: (lv_value_9_0= RULE_STRING )
                    // InternalQueryDsl.g:1209:6: lv_value_9_0= RULE_STRING
                    {
                    lv_value_9_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_9_0, grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_9_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1227:3: this_VarRef_10= ruleVarRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getVarRefParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VarRef_10=ruleVarRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VarRef_10;
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
    // $ANTLR end "ruleAtomic"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002812L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000001B0800070L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000003C0002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000040000000L});

}