package com.arsene.query.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.arsene.query.services.QueryDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQueryDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Query'", "'User'", "'('", "','", "')'", "'return'", "'['", "']'", "'Workspace'", "'Project'", "'Metamodel'", "'=>'", "'Model'", "'Dsl'", "'microSyntax'", "'modelQuery'", "'type'", "':'", "'EOL'", "'OCL'", "'fullTextSearch'", "'min_match'", "'operator'", "'qualityMetrics'", "'transformable'", "'id'", "'name'", "'qa'", "'qb'", "'qc'", "'qd'", "'qe'", "'qf'", "'qg'", "'qh'", "'qi'", "'qj'", "'qk'", "'ql'", "'qm'", "'qn'", "'qo'", "'qp'", "'qq'", "'qr'", "'qs'", "'qt'", "'qu'", "'qv'", "'AND'", "'OR'", "'EXACT'", "'filter'", "'size'", "'=='", "'>='", "'<='", "'<'", "'>'", "'gte'", "'lte'", "'lt'", "'gt'", "'username'", "'email'", "'createdAt'", "'updatedAt'", "'description'", "'owner'", "'projects'", "'user'", "'workspace'", "'sharedUser'", "'comments'", "'accessControl'", "'ePackage'", "'ext'", "'involvedOperations'", "'metrics'", "'models'", "'license'", "'metamodel'", "'project'", "'storageUrl'", "'unique_name'", "'userId'", "'workspaceId'", "'projectId'", "'eClassifier'", "'ePackageName'", "'ePackageNsURI'", "'ePackageNsPrefix'", "'quality-metric'", "'model'", "'extension'", "'operation'", "'unique-name'", "'var'", "'='", "'true'", "'false'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=4;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

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
        	return "QueryModel";
       	}

       	@Override
       	protected QueryDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleQueryModel"
    // InternalQueryDsl.g:64:1: entryRuleQueryModel returns [EObject current=null] : iv_ruleQueryModel= ruleQueryModel EOF ;
    public final EObject entryRuleQueryModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryModel = null;


        try {
            // InternalQueryDsl.g:64:51: (iv_ruleQueryModel= ruleQueryModel EOF )
            // InternalQueryDsl.g:65:2: iv_ruleQueryModel= ruleQueryModel EOF
            {
             newCompositeNode(grammarAccess.getQueryModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQueryModel=ruleQueryModel();

            state._fsp--;

             current =iv_ruleQueryModel; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQueryModel"


    // $ANTLR start "ruleQueryModel"
    // InternalQueryDsl.g:71:1: ruleQueryModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleQueryModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:77:2: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // InternalQueryDsl.g:78:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // InternalQueryDsl.g:78:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==108) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalQueryDsl.g:79:3: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // InternalQueryDsl.g:79:3: (lv_elements_0_0= ruleAbstractElement )
            	    // InternalQueryDsl.g:80:4: lv_elements_0_0= ruleAbstractElement
            	    {

            	    				newCompositeNode(grammarAccess.getQueryModelAccess().getElementsAbstractElementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getQueryModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"com.arsene.query.QueryDsl.AbstractElement");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryModel"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalQueryDsl.g:100:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // InternalQueryDsl.g:100:56: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // InternalQueryDsl.g:101:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;

             current =iv_ruleAbstractElement; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalQueryDsl.g:107:1: ruleAbstractElement returns [EObject current=null] : (this_Variable_0= ruleVariable | this_User_1= ruleUser | this_Workspace_2= ruleWorkspace | this_Project_3= ruleProject | this_Metamodel_4= ruleMetamodel | this_Model_5= ruleModel | this_Dsl_6= ruleDsl ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_Variable_0 = null;

        EObject this_User_1 = null;

        EObject this_Workspace_2 = null;

        EObject this_Project_3 = null;

        EObject this_Metamodel_4 = null;

        EObject this_Model_5 = null;

        EObject this_Dsl_6 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:113:2: ( (this_Variable_0= ruleVariable | this_User_1= ruleUser | this_Workspace_2= ruleWorkspace | this_Project_3= ruleProject | this_Metamodel_4= ruleMetamodel | this_Model_5= ruleModel | this_Dsl_6= ruleDsl ) )
            // InternalQueryDsl.g:114:2: (this_Variable_0= ruleVariable | this_User_1= ruleUser | this_Workspace_2= ruleWorkspace | this_Project_3= ruleProject | this_Metamodel_4= ruleMetamodel | this_Model_5= ruleModel | this_Dsl_6= ruleDsl )
            {
            // InternalQueryDsl.g:114:2: (this_Variable_0= ruleVariable | this_User_1= ruleUser | this_Workspace_2= ruleWorkspace | this_Project_3= ruleProject | this_Metamodel_4= ruleMetamodel | this_Model_5= ruleModel | this_Dsl_6= ruleDsl )
            int alt2=7;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==108) ) {
                alt2=1;
            }
            else if ( (LA2_0==11) ) {
                switch ( input.LA(2) ) {
                case 24:
                    {
                    alt2=7;
                    }
                    break;
                case 12:
                    {
                    alt2=2;
                    }
                    break;
                case 19:
                    {
                    alt2=3;
                    }
                    break;
                case 20:
                    {
                    alt2=4;
                    }
                    break;
                case 21:
                    {
                    alt2=5;
                    }
                    break;
                case 23:
                    {
                    alt2=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalQueryDsl.g:115:3: this_Variable_0= ruleVariable
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getVariableParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Variable_0=ruleVariable();

                    state._fsp--;


                    			current = this_Variable_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:124:3: this_User_1= ruleUser
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getUserParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_User_1=ruleUser();

                    state._fsp--;


                    			current = this_User_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:133:3: this_Workspace_2= ruleWorkspace
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getWorkspaceParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Workspace_2=ruleWorkspace();

                    state._fsp--;


                    			current = this_Workspace_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:142:3: this_Project_3= ruleProject
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getProjectParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Project_3=ruleProject();

                    state._fsp--;


                    			current = this_Project_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:151:3: this_Metamodel_4= ruleMetamodel
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getMetamodelParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Metamodel_4=ruleMetamodel();

                    state._fsp--;


                    			current = this_Metamodel_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:160:3: this_Model_5= ruleModel
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getModelParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Model_5=ruleModel();

                    state._fsp--;


                    			current = this_Model_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:169:3: this_Dsl_6= ruleDsl
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getDslParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Dsl_6=ruleDsl();

                    state._fsp--;


                    			current = this_Dsl_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleUser"
    // InternalQueryDsl.g:181:1: entryRuleUser returns [EObject current=null] : iv_ruleUser= ruleUser EOF ;
    public final EObject entryRuleUser() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUser = null;


        try {
            // InternalQueryDsl.g:181:45: (iv_ruleUser= ruleUser EOF )
            // InternalQueryDsl.g:182:2: iv_ruleUser= ruleUser EOF
            {
             newCompositeNode(grammarAccess.getUserRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUser=ruleUser();

            state._fsp--;

             current =iv_ruleUser; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUser"


    // $ANTLR start "ruleUser"
    // InternalQueryDsl.g:188:1: ruleUser returns [EObject current=null] : (otherlv_0= 'Query' otherlv_1= 'User' otherlv_2= '(' ( (lv_uservar_3_0= ruleUserVar ) ) (otherlv_4= ',' ( (lv_uservars_5_0= ruleUserVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleUserField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleUserField ) ) )* otherlv_12= ']' ) ;
    public final EObject ruleUser() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_uservar_3_0 = null;

        EObject lv_uservars_5_0 = null;

        EObject lv_field_9_0 = null;

        EObject lv_fields_11_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:194:2: ( (otherlv_0= 'Query' otherlv_1= 'User' otherlv_2= '(' ( (lv_uservar_3_0= ruleUserVar ) ) (otherlv_4= ',' ( (lv_uservars_5_0= ruleUserVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleUserField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleUserField ) ) )* otherlv_12= ']' ) )
            // InternalQueryDsl.g:195:2: (otherlv_0= 'Query' otherlv_1= 'User' otherlv_2= '(' ( (lv_uservar_3_0= ruleUserVar ) ) (otherlv_4= ',' ( (lv_uservars_5_0= ruleUserVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleUserField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleUserField ) ) )* otherlv_12= ']' )
            {
            // InternalQueryDsl.g:195:2: (otherlv_0= 'Query' otherlv_1= 'User' otherlv_2= '(' ( (lv_uservar_3_0= ruleUserVar ) ) (otherlv_4= ',' ( (lv_uservars_5_0= ruleUserVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleUserField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleUserField ) ) )* otherlv_12= ']' )
            // InternalQueryDsl.g:196:3: otherlv_0= 'Query' otherlv_1= 'User' otherlv_2= '(' ( (lv_uservar_3_0= ruleUserVar ) ) (otherlv_4= ',' ( (lv_uservars_5_0= ruleUserVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleUserField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleUserField ) ) )* otherlv_12= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getUserAccess().getQueryKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getUserAccess().getUserKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getUserAccess().getLeftParenthesisKeyword_2());
            		
            // InternalQueryDsl.g:208:3: ( (lv_uservar_3_0= ruleUserVar ) )
            // InternalQueryDsl.g:209:4: (lv_uservar_3_0= ruleUserVar )
            {
            // InternalQueryDsl.g:209:4: (lv_uservar_3_0= ruleUserVar )
            // InternalQueryDsl.g:210:5: lv_uservar_3_0= ruleUserVar
            {

            					newCompositeNode(grammarAccess.getUserAccess().getUservarUserVarParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_uservar_3_0=ruleUserVar();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUserRule());
            					}
            					set(
            						current,
            						"uservar",
            						lv_uservar_3_0,
            						"com.arsene.query.QueryDsl.UserVar");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:227:3: (otherlv_4= ',' ( (lv_uservars_5_0= ruleUserVar ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalQueryDsl.g:228:4: otherlv_4= ',' ( (lv_uservars_5_0= ruleUserVar ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_4, grammarAccess.getUserAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalQueryDsl.g:232:4: ( (lv_uservars_5_0= ruleUserVar ) )
            	    // InternalQueryDsl.g:233:5: (lv_uservars_5_0= ruleUserVar )
            	    {
            	    // InternalQueryDsl.g:233:5: (lv_uservars_5_0= ruleUserVar )
            	    // InternalQueryDsl.g:234:6: lv_uservars_5_0= ruleUserVar
            	    {

            	    						newCompositeNode(grammarAccess.getUserAccess().getUservarsUserVarParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_uservars_5_0=ruleUserVar();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUserRule());
            	    						}
            	    						add(
            	    							current,
            	    							"uservars",
            	    							lv_uservars_5_0,
            	    							"com.arsene.query.QueryDsl.UserVar");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getUserAccess().getRightParenthesisKeyword_5());
            		
            otherlv_7=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_7, grammarAccess.getUserAccess().getReturnKeyword_6());
            		
            otherlv_8=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_8, grammarAccess.getUserAccess().getLeftSquareBracketKeyword_7());
            		
            // InternalQueryDsl.g:264:3: ( (lv_field_9_0= ruleUserField ) )
            // InternalQueryDsl.g:265:4: (lv_field_9_0= ruleUserField )
            {
            // InternalQueryDsl.g:265:4: (lv_field_9_0= ruleUserField )
            // InternalQueryDsl.g:266:5: lv_field_9_0= ruleUserField
            {

            					newCompositeNode(grammarAccess.getUserAccess().getFieldUserFieldParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_11);
            lv_field_9_0=ruleUserField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUserRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_9_0,
            						"com.arsene.query.QueryDsl.UserField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:283:3: (otherlv_10= ',' ( (lv_fields_11_0= ruleUserField ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalQueryDsl.g:284:4: otherlv_10= ',' ( (lv_fields_11_0= ruleUserField ) )
            	    {
            	    otherlv_10=(Token)match(input,14,FOLLOW_10); 

            	    				newLeafNode(otherlv_10, grammarAccess.getUserAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalQueryDsl.g:288:4: ( (lv_fields_11_0= ruleUserField ) )
            	    // InternalQueryDsl.g:289:5: (lv_fields_11_0= ruleUserField )
            	    {
            	    // InternalQueryDsl.g:289:5: (lv_fields_11_0= ruleUserField )
            	    // InternalQueryDsl.g:290:6: lv_fields_11_0= ruleUserField
            	    {

            	    						newCompositeNode(grammarAccess.getUserAccess().getFieldsUserFieldParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_fields_11_0=ruleUserField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUserRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_11_0,
            	    							"com.arsene.query.QueryDsl.UserField");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_12=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getUserAccess().getRightSquareBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUser"


    // $ANTLR start "entryRuleWorkspace"
    // InternalQueryDsl.g:316:1: entryRuleWorkspace returns [EObject current=null] : iv_ruleWorkspace= ruleWorkspace EOF ;
    public final EObject entryRuleWorkspace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkspace = null;


        try {
            // InternalQueryDsl.g:316:50: (iv_ruleWorkspace= ruleWorkspace EOF )
            // InternalQueryDsl.g:317:2: iv_ruleWorkspace= ruleWorkspace EOF
            {
             newCompositeNode(grammarAccess.getWorkspaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkspace=ruleWorkspace();

            state._fsp--;

             current =iv_ruleWorkspace; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleWorkspace"


    // $ANTLR start "ruleWorkspace"
    // InternalQueryDsl.g:323:1: ruleWorkspace returns [EObject current=null] : (otherlv_0= 'Query' otherlv_1= 'Workspace' otherlv_2= '(' ( (lv_spacevar_3_0= ruleWorkspaceVar ) ) (otherlv_4= ',' ( (lv_spacevars_5_0= ruleWorkspaceVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleWorkspaceField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleWorkspaceField ) ) )* otherlv_12= ']' ) ;
    public final EObject ruleWorkspace() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_spacevar_3_0 = null;

        EObject lv_spacevars_5_0 = null;

        EObject lv_field_9_0 = null;

        EObject lv_fields_11_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:329:2: ( (otherlv_0= 'Query' otherlv_1= 'Workspace' otherlv_2= '(' ( (lv_spacevar_3_0= ruleWorkspaceVar ) ) (otherlv_4= ',' ( (lv_spacevars_5_0= ruleWorkspaceVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleWorkspaceField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleWorkspaceField ) ) )* otherlv_12= ']' ) )
            // InternalQueryDsl.g:330:2: (otherlv_0= 'Query' otherlv_1= 'Workspace' otherlv_2= '(' ( (lv_spacevar_3_0= ruleWorkspaceVar ) ) (otherlv_4= ',' ( (lv_spacevars_5_0= ruleWorkspaceVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleWorkspaceField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleWorkspaceField ) ) )* otherlv_12= ']' )
            {
            // InternalQueryDsl.g:330:2: (otherlv_0= 'Query' otherlv_1= 'Workspace' otherlv_2= '(' ( (lv_spacevar_3_0= ruleWorkspaceVar ) ) (otherlv_4= ',' ( (lv_spacevars_5_0= ruleWorkspaceVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleWorkspaceField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleWorkspaceField ) ) )* otherlv_12= ']' )
            // InternalQueryDsl.g:331:3: otherlv_0= 'Query' otherlv_1= 'Workspace' otherlv_2= '(' ( (lv_spacevar_3_0= ruleWorkspaceVar ) ) (otherlv_4= ',' ( (lv_spacevars_5_0= ruleWorkspaceVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleWorkspaceField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleWorkspaceField ) ) )* otherlv_12= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getWorkspaceAccess().getQueryKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getWorkspaceAccess().getWorkspaceKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getWorkspaceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalQueryDsl.g:343:3: ( (lv_spacevar_3_0= ruleWorkspaceVar ) )
            // InternalQueryDsl.g:344:4: (lv_spacevar_3_0= ruleWorkspaceVar )
            {
            // InternalQueryDsl.g:344:4: (lv_spacevar_3_0= ruleWorkspaceVar )
            // InternalQueryDsl.g:345:5: lv_spacevar_3_0= ruleWorkspaceVar
            {

            					newCompositeNode(grammarAccess.getWorkspaceAccess().getSpacevarWorkspaceVarParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_spacevar_3_0=ruleWorkspaceVar();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkspaceRule());
            					}
            					set(
            						current,
            						"spacevar",
            						lv_spacevar_3_0,
            						"com.arsene.query.QueryDsl.WorkspaceVar");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:362:3: (otherlv_4= ',' ( (lv_spacevars_5_0= ruleWorkspaceVar ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalQueryDsl.g:363:4: otherlv_4= ',' ( (lv_spacevars_5_0= ruleWorkspaceVar ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_13); 

            	    				newLeafNode(otherlv_4, grammarAccess.getWorkspaceAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalQueryDsl.g:367:4: ( (lv_spacevars_5_0= ruleWorkspaceVar ) )
            	    // InternalQueryDsl.g:368:5: (lv_spacevars_5_0= ruleWorkspaceVar )
            	    {
            	    // InternalQueryDsl.g:368:5: (lv_spacevars_5_0= ruleWorkspaceVar )
            	    // InternalQueryDsl.g:369:6: lv_spacevars_5_0= ruleWorkspaceVar
            	    {

            	    						newCompositeNode(grammarAccess.getWorkspaceAccess().getSpacevarsWorkspaceVarParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_spacevars_5_0=ruleWorkspaceVar();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getWorkspaceRule());
            	    						}
            	    						add(
            	    							current,
            	    							"spacevars",
            	    							lv_spacevars_5_0,
            	    							"com.arsene.query.QueryDsl.WorkspaceVar");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getWorkspaceAccess().getRightParenthesisKeyword_5());
            		
            otherlv_7=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_7, grammarAccess.getWorkspaceAccess().getReturnKeyword_6());
            		
            otherlv_8=(Token)match(input,17,FOLLOW_14); 

            			newLeafNode(otherlv_8, grammarAccess.getWorkspaceAccess().getLeftSquareBracketKeyword_7());
            		
            // InternalQueryDsl.g:399:3: ( (lv_field_9_0= ruleWorkspaceField ) )
            // InternalQueryDsl.g:400:4: (lv_field_9_0= ruleWorkspaceField )
            {
            // InternalQueryDsl.g:400:4: (lv_field_9_0= ruleWorkspaceField )
            // InternalQueryDsl.g:401:5: lv_field_9_0= ruleWorkspaceField
            {

            					newCompositeNode(grammarAccess.getWorkspaceAccess().getFieldWorkspaceFieldParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_11);
            lv_field_9_0=ruleWorkspaceField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkspaceRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_9_0,
            						"com.arsene.query.QueryDsl.WorkspaceField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:418:3: (otherlv_10= ',' ( (lv_fields_11_0= ruleWorkspaceField ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalQueryDsl.g:419:4: otherlv_10= ',' ( (lv_fields_11_0= ruleWorkspaceField ) )
            	    {
            	    otherlv_10=(Token)match(input,14,FOLLOW_14); 

            	    				newLeafNode(otherlv_10, grammarAccess.getWorkspaceAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalQueryDsl.g:423:4: ( (lv_fields_11_0= ruleWorkspaceField ) )
            	    // InternalQueryDsl.g:424:5: (lv_fields_11_0= ruleWorkspaceField )
            	    {
            	    // InternalQueryDsl.g:424:5: (lv_fields_11_0= ruleWorkspaceField )
            	    // InternalQueryDsl.g:425:6: lv_fields_11_0= ruleWorkspaceField
            	    {

            	    						newCompositeNode(grammarAccess.getWorkspaceAccess().getFieldsWorkspaceFieldParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_fields_11_0=ruleWorkspaceField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getWorkspaceRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_11_0,
            	    							"com.arsene.query.QueryDsl.WorkspaceField");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_12=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getWorkspaceAccess().getRightSquareBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkspace"


    // $ANTLR start "entryRuleProject"
    // InternalQueryDsl.g:451:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // InternalQueryDsl.g:451:48: (iv_ruleProject= ruleProject EOF )
            // InternalQueryDsl.g:452:2: iv_ruleProject= ruleProject EOF
            {
             newCompositeNode(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProject=ruleProject();

            state._fsp--;

             current =iv_ruleProject; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalQueryDsl.g:458:1: ruleProject returns [EObject current=null] : (otherlv_0= 'Query' otherlv_1= 'Project' otherlv_2= '(' ( (lv_projectvar_3_0= ruleProjectVar ) ) (otherlv_4= ',' ( (lv_projectvars_5_0= ruleProjectVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleProjectField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleProjectField ) ) )* otherlv_12= ']' ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_projectvar_3_0 = null;

        EObject lv_projectvars_5_0 = null;

        EObject lv_field_9_0 = null;

        EObject lv_fields_11_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:464:2: ( (otherlv_0= 'Query' otherlv_1= 'Project' otherlv_2= '(' ( (lv_projectvar_3_0= ruleProjectVar ) ) (otherlv_4= ',' ( (lv_projectvars_5_0= ruleProjectVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleProjectField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleProjectField ) ) )* otherlv_12= ']' ) )
            // InternalQueryDsl.g:465:2: (otherlv_0= 'Query' otherlv_1= 'Project' otherlv_2= '(' ( (lv_projectvar_3_0= ruleProjectVar ) ) (otherlv_4= ',' ( (lv_projectvars_5_0= ruleProjectVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleProjectField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleProjectField ) ) )* otherlv_12= ']' )
            {
            // InternalQueryDsl.g:465:2: (otherlv_0= 'Query' otherlv_1= 'Project' otherlv_2= '(' ( (lv_projectvar_3_0= ruleProjectVar ) ) (otherlv_4= ',' ( (lv_projectvars_5_0= ruleProjectVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleProjectField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleProjectField ) ) )* otherlv_12= ']' )
            // InternalQueryDsl.g:466:3: otherlv_0= 'Query' otherlv_1= 'Project' otherlv_2= '(' ( (lv_projectvar_3_0= ruleProjectVar ) ) (otherlv_4= ',' ( (lv_projectvars_5_0= ruleProjectVar ) ) )* otherlv_6= ')' otherlv_7= 'return' otherlv_8= '[' ( (lv_field_9_0= ruleProjectField ) ) (otherlv_10= ',' ( (lv_fields_11_0= ruleProjectField ) ) )* otherlv_12= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getProjectAccess().getQueryKeyword_0());
            		
            otherlv_1=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getProjectAccess().getProjectKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getProjectAccess().getLeftParenthesisKeyword_2());
            		
            // InternalQueryDsl.g:478:3: ( (lv_projectvar_3_0= ruleProjectVar ) )
            // InternalQueryDsl.g:479:4: (lv_projectvar_3_0= ruleProjectVar )
            {
            // InternalQueryDsl.g:479:4: (lv_projectvar_3_0= ruleProjectVar )
            // InternalQueryDsl.g:480:5: lv_projectvar_3_0= ruleProjectVar
            {

            					newCompositeNode(grammarAccess.getProjectAccess().getProjectvarProjectVarParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_projectvar_3_0=ruleProjectVar();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProjectRule());
            					}
            					set(
            						current,
            						"projectvar",
            						lv_projectvar_3_0,
            						"com.arsene.query.QueryDsl.ProjectVar");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:497:3: (otherlv_4= ',' ( (lv_projectvars_5_0= ruleProjectVar ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalQueryDsl.g:498:4: otherlv_4= ',' ( (lv_projectvars_5_0= ruleProjectVar ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_16); 

            	    				newLeafNode(otherlv_4, grammarAccess.getProjectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalQueryDsl.g:502:4: ( (lv_projectvars_5_0= ruleProjectVar ) )
            	    // InternalQueryDsl.g:503:5: (lv_projectvars_5_0= ruleProjectVar )
            	    {
            	    // InternalQueryDsl.g:503:5: (lv_projectvars_5_0= ruleProjectVar )
            	    // InternalQueryDsl.g:504:6: lv_projectvars_5_0= ruleProjectVar
            	    {

            	    						newCompositeNode(grammarAccess.getProjectAccess().getProjectvarsProjectVarParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_projectvars_5_0=ruleProjectVar();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"projectvars",
            	    							lv_projectvars_5_0,
            	    							"com.arsene.query.QueryDsl.ProjectVar");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getProjectAccess().getRightParenthesisKeyword_5());
            		
            otherlv_7=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_7, grammarAccess.getProjectAccess().getReturnKeyword_6());
            		
            otherlv_8=(Token)match(input,17,FOLLOW_17); 

            			newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getLeftSquareBracketKeyword_7());
            		
            // InternalQueryDsl.g:534:3: ( (lv_field_9_0= ruleProjectField ) )
            // InternalQueryDsl.g:535:4: (lv_field_9_0= ruleProjectField )
            {
            // InternalQueryDsl.g:535:4: (lv_field_9_0= ruleProjectField )
            // InternalQueryDsl.g:536:5: lv_field_9_0= ruleProjectField
            {

            					newCompositeNode(grammarAccess.getProjectAccess().getFieldProjectFieldParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_11);
            lv_field_9_0=ruleProjectField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProjectRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_9_0,
            						"com.arsene.query.QueryDsl.ProjectField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:553:3: (otherlv_10= ',' ( (lv_fields_11_0= ruleProjectField ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==14) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalQueryDsl.g:554:4: otherlv_10= ',' ( (lv_fields_11_0= ruleProjectField ) )
            	    {
            	    otherlv_10=(Token)match(input,14,FOLLOW_17); 

            	    				newLeafNode(otherlv_10, grammarAccess.getProjectAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalQueryDsl.g:558:4: ( (lv_fields_11_0= ruleProjectField ) )
            	    // InternalQueryDsl.g:559:5: (lv_fields_11_0= ruleProjectField )
            	    {
            	    // InternalQueryDsl.g:559:5: (lv_fields_11_0= ruleProjectField )
            	    // InternalQueryDsl.g:560:6: lv_fields_11_0= ruleProjectField
            	    {

            	    						newCompositeNode(grammarAccess.getProjectAccess().getFieldsProjectFieldParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_fields_11_0=ruleProjectField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_11_0,
            	    							"com.arsene.query.QueryDsl.ProjectField");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_12=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getProjectAccess().getRightSquareBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleMetamodel"
    // InternalQueryDsl.g:586:1: entryRuleMetamodel returns [EObject current=null] : iv_ruleMetamodel= ruleMetamodel EOF ;
    public final EObject entryRuleMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetamodel = null;


        try {
            // InternalQueryDsl.g:586:50: (iv_ruleMetamodel= ruleMetamodel EOF )
            // InternalQueryDsl.g:587:2: iv_ruleMetamodel= ruleMetamodel EOF
            {
             newCompositeNode(grammarAccess.getMetamodelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetamodel=ruleMetamodel();

            state._fsp--;

             current =iv_ruleMetamodel; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMetamodel"


    // $ANTLR start "ruleMetamodel"
    // InternalQueryDsl.g:593:1: ruleMetamodel returns [EObject current=null] : (otherlv_0= 'Query' otherlv_1= 'Metamodel' otherlv_2= '(' ( (lv_metamodelVar_3_0= ruleMetamodelVar ) ) (otherlv_4= ',' ( (lv_metamodelVars_5_0= ruleMetamodelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_qm_11_0= ruleQualityMetric ) ) | ( (lv_transfo_12_0= ruleTransformable ) ) ) )* otherlv_13= 'return' otherlv_14= '[' ( (lv_field_15_0= ruleMetamodelField ) ) (otherlv_16= ',' ( (lv_fields_17_0= ruleMetamodelField ) ) )* otherlv_18= ']' ) ;
    public final EObject ruleMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_metamodelVar_3_0 = null;

        EObject lv_metamodelVars_5_0 = null;

        EObject lv_syntax_8_0 = null;

        EObject lv_textSearch_9_0 = null;

        EObject lv_filter_10_0 = null;

        EObject lv_qm_11_0 = null;

        EObject lv_transfo_12_0 = null;

        EObject lv_field_15_0 = null;

        EObject lv_fields_17_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:599:2: ( (otherlv_0= 'Query' otherlv_1= 'Metamodel' otherlv_2= '(' ( (lv_metamodelVar_3_0= ruleMetamodelVar ) ) (otherlv_4= ',' ( (lv_metamodelVars_5_0= ruleMetamodelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_qm_11_0= ruleQualityMetric ) ) | ( (lv_transfo_12_0= ruleTransformable ) ) ) )* otherlv_13= 'return' otherlv_14= '[' ( (lv_field_15_0= ruleMetamodelField ) ) (otherlv_16= ',' ( (lv_fields_17_0= ruleMetamodelField ) ) )* otherlv_18= ']' ) )
            // InternalQueryDsl.g:600:2: (otherlv_0= 'Query' otherlv_1= 'Metamodel' otherlv_2= '(' ( (lv_metamodelVar_3_0= ruleMetamodelVar ) ) (otherlv_4= ',' ( (lv_metamodelVars_5_0= ruleMetamodelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_qm_11_0= ruleQualityMetric ) ) | ( (lv_transfo_12_0= ruleTransformable ) ) ) )* otherlv_13= 'return' otherlv_14= '[' ( (lv_field_15_0= ruleMetamodelField ) ) (otherlv_16= ',' ( (lv_fields_17_0= ruleMetamodelField ) ) )* otherlv_18= ']' )
            {
            // InternalQueryDsl.g:600:2: (otherlv_0= 'Query' otherlv_1= 'Metamodel' otherlv_2= '(' ( (lv_metamodelVar_3_0= ruleMetamodelVar ) ) (otherlv_4= ',' ( (lv_metamodelVars_5_0= ruleMetamodelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_qm_11_0= ruleQualityMetric ) ) | ( (lv_transfo_12_0= ruleTransformable ) ) ) )* otherlv_13= 'return' otherlv_14= '[' ( (lv_field_15_0= ruleMetamodelField ) ) (otherlv_16= ',' ( (lv_fields_17_0= ruleMetamodelField ) ) )* otherlv_18= ']' )
            // InternalQueryDsl.g:601:3: otherlv_0= 'Query' otherlv_1= 'Metamodel' otherlv_2= '(' ( (lv_metamodelVar_3_0= ruleMetamodelVar ) ) (otherlv_4= ',' ( (lv_metamodelVars_5_0= ruleMetamodelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_qm_11_0= ruleQualityMetric ) ) | ( (lv_transfo_12_0= ruleTransformable ) ) ) )* otherlv_13= 'return' otherlv_14= '[' ( (lv_field_15_0= ruleMetamodelField ) ) (otherlv_16= ',' ( (lv_fields_17_0= ruleMetamodelField ) ) )* otherlv_18= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getMetamodelAccess().getQueryKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getMetamodelAccess().getMetamodelKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getMetamodelAccess().getLeftParenthesisKeyword_2());
            		
            // InternalQueryDsl.g:613:3: ( (lv_metamodelVar_3_0= ruleMetamodelVar ) )
            // InternalQueryDsl.g:614:4: (lv_metamodelVar_3_0= ruleMetamodelVar )
            {
            // InternalQueryDsl.g:614:4: (lv_metamodelVar_3_0= ruleMetamodelVar )
            // InternalQueryDsl.g:615:5: lv_metamodelVar_3_0= ruleMetamodelVar
            {

            					newCompositeNode(grammarAccess.getMetamodelAccess().getMetamodelVarMetamodelVarParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_metamodelVar_3_0=ruleMetamodelVar();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMetamodelRule());
            					}
            					set(
            						current,
            						"metamodelVar",
            						lv_metamodelVar_3_0,
            						"com.arsene.query.QueryDsl.MetamodelVar");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:632:3: (otherlv_4= ',' ( (lv_metamodelVars_5_0= ruleMetamodelVar ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==14) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalQueryDsl.g:633:4: otherlv_4= ',' ( (lv_metamodelVars_5_0= ruleMetamodelVar ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_19); 

            	    				newLeafNode(otherlv_4, grammarAccess.getMetamodelAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalQueryDsl.g:637:4: ( (lv_metamodelVars_5_0= ruleMetamodelVar ) )
            	    // InternalQueryDsl.g:638:5: (lv_metamodelVars_5_0= ruleMetamodelVar )
            	    {
            	    // InternalQueryDsl.g:638:5: (lv_metamodelVars_5_0= ruleMetamodelVar )
            	    // InternalQueryDsl.g:639:6: lv_metamodelVars_5_0= ruleMetamodelVar
            	    {

            	    						newCompositeNode(grammarAccess.getMetamodelAccess().getMetamodelVarsMetamodelVarParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_metamodelVars_5_0=ruleMetamodelVar();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMetamodelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"metamodelVars",
            	    							lv_metamodelVars_5_0,
            	    							"com.arsene.query.QueryDsl.MetamodelVar");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_20); 

            			newLeafNode(otherlv_6, grammarAccess.getMetamodelAccess().getRightParenthesisKeyword_5());
            		
            // InternalQueryDsl.g:661:3: (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_qm_11_0= ruleQualityMetric ) ) | ( (lv_transfo_12_0= ruleTransformable ) ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==22) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalQueryDsl.g:662:4: otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_qm_11_0= ruleQualityMetric ) ) | ( (lv_transfo_12_0= ruleTransformable ) ) )
            	    {
            	    otherlv_7=(Token)match(input,22,FOLLOW_21); 

            	    				newLeafNode(otherlv_7, grammarAccess.getMetamodelAccess().getEqualsSignGreaterThanSignKeyword_6_0());
            	    			
            	    // InternalQueryDsl.g:666:4: ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_qm_11_0= ruleQualityMetric ) ) | ( (lv_transfo_12_0= ruleTransformable ) ) )
            	    int alt10=5;
            	    switch ( input.LA(1) ) {
            	    case 25:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    case 63:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt10=4;
            	        }
            	        break;
            	    case 35:
            	        {
            	        alt10=5;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // InternalQueryDsl.g:667:5: ( (lv_syntax_8_0= ruleMicroSyntax ) )
            	            {
            	            // InternalQueryDsl.g:667:5: ( (lv_syntax_8_0= ruleMicroSyntax ) )
            	            // InternalQueryDsl.g:668:6: (lv_syntax_8_0= ruleMicroSyntax )
            	            {
            	            // InternalQueryDsl.g:668:6: (lv_syntax_8_0= ruleMicroSyntax )
            	            // InternalQueryDsl.g:669:7: lv_syntax_8_0= ruleMicroSyntax
            	            {

            	            							newCompositeNode(grammarAccess.getMetamodelAccess().getSyntaxMicroSyntaxParserRuleCall_6_1_0_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_syntax_8_0=ruleMicroSyntax();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getMetamodelRule());
            	            							}
            	            							set(
            	            								current,
            	            								"syntax",
            	            								lv_syntax_8_0,
            	            								"com.arsene.query.QueryDsl.MicroSyntax");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalQueryDsl.g:687:5: ( (lv_textSearch_9_0= ruleFullTextSearch ) )
            	            {
            	            // InternalQueryDsl.g:687:5: ( (lv_textSearch_9_0= ruleFullTextSearch ) )
            	            // InternalQueryDsl.g:688:6: (lv_textSearch_9_0= ruleFullTextSearch )
            	            {
            	            // InternalQueryDsl.g:688:6: (lv_textSearch_9_0= ruleFullTextSearch )
            	            // InternalQueryDsl.g:689:7: lv_textSearch_9_0= ruleFullTextSearch
            	            {

            	            							newCompositeNode(grammarAccess.getMetamodelAccess().getTextSearchFullTextSearchParserRuleCall_6_1_1_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_textSearch_9_0=ruleFullTextSearch();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getMetamodelRule());
            	            							}
            	            							set(
            	            								current,
            	            								"textSearch",
            	            								lv_textSearch_9_0,
            	            								"com.arsene.query.QueryDsl.FullTextSearch");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalQueryDsl.g:707:5: ( (lv_filter_10_0= ruleFilter ) )
            	            {
            	            // InternalQueryDsl.g:707:5: ( (lv_filter_10_0= ruleFilter ) )
            	            // InternalQueryDsl.g:708:6: (lv_filter_10_0= ruleFilter )
            	            {
            	            // InternalQueryDsl.g:708:6: (lv_filter_10_0= ruleFilter )
            	            // InternalQueryDsl.g:709:7: lv_filter_10_0= ruleFilter
            	            {

            	            							newCompositeNode(grammarAccess.getMetamodelAccess().getFilterFilterParserRuleCall_6_1_2_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_filter_10_0=ruleFilter();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getMetamodelRule());
            	            							}
            	            							set(
            	            								current,
            	            								"filter",
            	            								lv_filter_10_0,
            	            								"com.arsene.query.QueryDsl.Filter");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // InternalQueryDsl.g:727:5: ( (lv_qm_11_0= ruleQualityMetric ) )
            	            {
            	            // InternalQueryDsl.g:727:5: ( (lv_qm_11_0= ruleQualityMetric ) )
            	            // InternalQueryDsl.g:728:6: (lv_qm_11_0= ruleQualityMetric )
            	            {
            	            // InternalQueryDsl.g:728:6: (lv_qm_11_0= ruleQualityMetric )
            	            // InternalQueryDsl.g:729:7: lv_qm_11_0= ruleQualityMetric
            	            {

            	            							newCompositeNode(grammarAccess.getMetamodelAccess().getQmQualityMetricParserRuleCall_6_1_3_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_qm_11_0=ruleQualityMetric();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getMetamodelRule());
            	            							}
            	            							set(
            	            								current,
            	            								"qm",
            	            								lv_qm_11_0,
            	            								"com.arsene.query.QueryDsl.QualityMetric");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 5 :
            	            // InternalQueryDsl.g:747:5: ( (lv_transfo_12_0= ruleTransformable ) )
            	            {
            	            // InternalQueryDsl.g:747:5: ( (lv_transfo_12_0= ruleTransformable ) )
            	            // InternalQueryDsl.g:748:6: (lv_transfo_12_0= ruleTransformable )
            	            {
            	            // InternalQueryDsl.g:748:6: (lv_transfo_12_0= ruleTransformable )
            	            // InternalQueryDsl.g:749:7: lv_transfo_12_0= ruleTransformable
            	            {

            	            							newCompositeNode(grammarAccess.getMetamodelAccess().getTransfoTransformableParserRuleCall_6_1_4_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_transfo_12_0=ruleTransformable();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getMetamodelRule());
            	            							}
            	            							set(
            	            								current,
            	            								"transfo",
            	            								lv_transfo_12_0,
            	            								"com.arsene.query.QueryDsl.Transformable");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_13=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_13, grammarAccess.getMetamodelAccess().getReturnKeyword_7());
            		
            otherlv_14=(Token)match(input,17,FOLLOW_22); 

            			newLeafNode(otherlv_14, grammarAccess.getMetamodelAccess().getLeftSquareBracketKeyword_8());
            		
            // InternalQueryDsl.g:776:3: ( (lv_field_15_0= ruleMetamodelField ) )
            // InternalQueryDsl.g:777:4: (lv_field_15_0= ruleMetamodelField )
            {
            // InternalQueryDsl.g:777:4: (lv_field_15_0= ruleMetamodelField )
            // InternalQueryDsl.g:778:5: lv_field_15_0= ruleMetamodelField
            {

            					newCompositeNode(grammarAccess.getMetamodelAccess().getFieldMetamodelFieldParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_11);
            lv_field_15_0=ruleMetamodelField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMetamodelRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_15_0,
            						"com.arsene.query.QueryDsl.MetamodelField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:795:3: (otherlv_16= ',' ( (lv_fields_17_0= ruleMetamodelField ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalQueryDsl.g:796:4: otherlv_16= ',' ( (lv_fields_17_0= ruleMetamodelField ) )
            	    {
            	    otherlv_16=(Token)match(input,14,FOLLOW_22); 

            	    				newLeafNode(otherlv_16, grammarAccess.getMetamodelAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalQueryDsl.g:800:4: ( (lv_fields_17_0= ruleMetamodelField ) )
            	    // InternalQueryDsl.g:801:5: (lv_fields_17_0= ruleMetamodelField )
            	    {
            	    // InternalQueryDsl.g:801:5: (lv_fields_17_0= ruleMetamodelField )
            	    // InternalQueryDsl.g:802:6: lv_fields_17_0= ruleMetamodelField
            	    {

            	    						newCompositeNode(grammarAccess.getMetamodelAccess().getFieldsMetamodelFieldParserRuleCall_10_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_fields_17_0=ruleMetamodelField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMetamodelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_17_0,
            	    							"com.arsene.query.QueryDsl.MetamodelField");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_18=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getMetamodelAccess().getRightSquareBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetamodel"


    // $ANTLR start "entryRuleModel"
    // InternalQueryDsl.g:828:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalQueryDsl.g:828:46: (iv_ruleModel= ruleModel EOF )
            // InternalQueryDsl.g:829:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalQueryDsl.g:835:1: ruleModel returns [EObject current=null] : (otherlv_0= 'Query' otherlv_1= 'Model' otherlv_2= '(' ( (lv_modelVar_3_0= ruleModelVar ) ) (otherlv_4= ',' ( (lv_modelVars_5_0= ruleModelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_q_11_0= ruleModelQuery ) ) ) )* otherlv_12= 'return' otherlv_13= '[' ( (lv_field_14_0= ruleModelField ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleModelField ) ) )* otherlv_17= ']' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_modelVar_3_0 = null;

        EObject lv_modelVars_5_0 = null;

        EObject lv_syntax_8_0 = null;

        EObject lv_textSearch_9_0 = null;

        EObject lv_filter_10_0 = null;

        EObject lv_q_11_0 = null;

        EObject lv_field_14_0 = null;

        EObject lv_fields_16_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:841:2: ( (otherlv_0= 'Query' otherlv_1= 'Model' otherlv_2= '(' ( (lv_modelVar_3_0= ruleModelVar ) ) (otherlv_4= ',' ( (lv_modelVars_5_0= ruleModelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_q_11_0= ruleModelQuery ) ) ) )* otherlv_12= 'return' otherlv_13= '[' ( (lv_field_14_0= ruleModelField ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleModelField ) ) )* otherlv_17= ']' ) )
            // InternalQueryDsl.g:842:2: (otherlv_0= 'Query' otherlv_1= 'Model' otherlv_2= '(' ( (lv_modelVar_3_0= ruleModelVar ) ) (otherlv_4= ',' ( (lv_modelVars_5_0= ruleModelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_q_11_0= ruleModelQuery ) ) ) )* otherlv_12= 'return' otherlv_13= '[' ( (lv_field_14_0= ruleModelField ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleModelField ) ) )* otherlv_17= ']' )
            {
            // InternalQueryDsl.g:842:2: (otherlv_0= 'Query' otherlv_1= 'Model' otherlv_2= '(' ( (lv_modelVar_3_0= ruleModelVar ) ) (otherlv_4= ',' ( (lv_modelVars_5_0= ruleModelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_q_11_0= ruleModelQuery ) ) ) )* otherlv_12= 'return' otherlv_13= '[' ( (lv_field_14_0= ruleModelField ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleModelField ) ) )* otherlv_17= ']' )
            // InternalQueryDsl.g:843:3: otherlv_0= 'Query' otherlv_1= 'Model' otherlv_2= '(' ( (lv_modelVar_3_0= ruleModelVar ) ) (otherlv_4= ',' ( (lv_modelVars_5_0= ruleModelVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_q_11_0= ruleModelQuery ) ) ) )* otherlv_12= 'return' otherlv_13= '[' ( (lv_field_14_0= ruleModelField ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleModelField ) ) )* otherlv_17= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getQueryKeyword_0());
            		
            otherlv_1=(Token)match(input,23,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getModelAccess().getModelKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getModelAccess().getLeftParenthesisKeyword_2());
            		
            // InternalQueryDsl.g:855:3: ( (lv_modelVar_3_0= ruleModelVar ) )
            // InternalQueryDsl.g:856:4: (lv_modelVar_3_0= ruleModelVar )
            {
            // InternalQueryDsl.g:856:4: (lv_modelVar_3_0= ruleModelVar )
            // InternalQueryDsl.g:857:5: lv_modelVar_3_0= ruleModelVar
            {

            					newCompositeNode(grammarAccess.getModelAccess().getModelVarModelVarParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_modelVar_3_0=ruleModelVar();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"modelVar",
            						lv_modelVar_3_0,
            						"com.arsene.query.QueryDsl.ModelVar");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:874:3: (otherlv_4= ',' ( (lv_modelVars_5_0= ruleModelVar ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==14) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalQueryDsl.g:875:4: otherlv_4= ',' ( (lv_modelVars_5_0= ruleModelVar ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_19); 

            	    				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalQueryDsl.g:879:4: ( (lv_modelVars_5_0= ruleModelVar ) )
            	    // InternalQueryDsl.g:880:5: (lv_modelVars_5_0= ruleModelVar )
            	    {
            	    // InternalQueryDsl.g:880:5: (lv_modelVars_5_0= ruleModelVar )
            	    // InternalQueryDsl.g:881:6: lv_modelVars_5_0= ruleModelVar
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getModelVarsModelVarParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_modelVars_5_0=ruleModelVar();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"modelVars",
            	    							lv_modelVars_5_0,
            	    							"com.arsene.query.QueryDsl.ModelVar");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_20); 

            			newLeafNode(otherlv_6, grammarAccess.getModelAccess().getRightParenthesisKeyword_5());
            		
            // InternalQueryDsl.g:903:3: (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_q_11_0= ruleModelQuery ) ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==22) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalQueryDsl.g:904:4: otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_q_11_0= ruleModelQuery ) ) )
            	    {
            	    otherlv_7=(Token)match(input,22,FOLLOW_24); 

            	    				newLeafNode(otherlv_7, grammarAccess.getModelAccess().getEqualsSignGreaterThanSignKeyword_6_0());
            	    			
            	    // InternalQueryDsl.g:908:4: ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) | ( (lv_q_11_0= ruleModelQuery ) ) )
            	    int alt14=4;
            	    switch ( input.LA(1) ) {
            	    case 25:
            	        {
            	        alt14=1;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt14=2;
            	        }
            	        break;
            	    case 63:
            	        {
            	        alt14=3;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt14=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt14) {
            	        case 1 :
            	            // InternalQueryDsl.g:909:5: ( (lv_syntax_8_0= ruleMicroSyntax ) )
            	            {
            	            // InternalQueryDsl.g:909:5: ( (lv_syntax_8_0= ruleMicroSyntax ) )
            	            // InternalQueryDsl.g:910:6: (lv_syntax_8_0= ruleMicroSyntax )
            	            {
            	            // InternalQueryDsl.g:910:6: (lv_syntax_8_0= ruleMicroSyntax )
            	            // InternalQueryDsl.g:911:7: lv_syntax_8_0= ruleMicroSyntax
            	            {

            	            							newCompositeNode(grammarAccess.getModelAccess().getSyntaxMicroSyntaxParserRuleCall_6_1_0_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_syntax_8_0=ruleMicroSyntax();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getModelRule());
            	            							}
            	            							set(
            	            								current,
            	            								"syntax",
            	            								lv_syntax_8_0,
            	            								"com.arsene.query.QueryDsl.MicroSyntax");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalQueryDsl.g:929:5: ( (lv_textSearch_9_0= ruleFullTextSearch ) )
            	            {
            	            // InternalQueryDsl.g:929:5: ( (lv_textSearch_9_0= ruleFullTextSearch ) )
            	            // InternalQueryDsl.g:930:6: (lv_textSearch_9_0= ruleFullTextSearch )
            	            {
            	            // InternalQueryDsl.g:930:6: (lv_textSearch_9_0= ruleFullTextSearch )
            	            // InternalQueryDsl.g:931:7: lv_textSearch_9_0= ruleFullTextSearch
            	            {

            	            							newCompositeNode(grammarAccess.getModelAccess().getTextSearchFullTextSearchParserRuleCall_6_1_1_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_textSearch_9_0=ruleFullTextSearch();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getModelRule());
            	            							}
            	            							set(
            	            								current,
            	            								"textSearch",
            	            								lv_textSearch_9_0,
            	            								"com.arsene.query.QueryDsl.FullTextSearch");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalQueryDsl.g:949:5: ( (lv_filter_10_0= ruleFilter ) )
            	            {
            	            // InternalQueryDsl.g:949:5: ( (lv_filter_10_0= ruleFilter ) )
            	            // InternalQueryDsl.g:950:6: (lv_filter_10_0= ruleFilter )
            	            {
            	            // InternalQueryDsl.g:950:6: (lv_filter_10_0= ruleFilter )
            	            // InternalQueryDsl.g:951:7: lv_filter_10_0= ruleFilter
            	            {

            	            							newCompositeNode(grammarAccess.getModelAccess().getFilterFilterParserRuleCall_6_1_2_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_filter_10_0=ruleFilter();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getModelRule());
            	            							}
            	            							set(
            	            								current,
            	            								"filter",
            	            								lv_filter_10_0,
            	            								"com.arsene.query.QueryDsl.Filter");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // InternalQueryDsl.g:969:5: ( (lv_q_11_0= ruleModelQuery ) )
            	            {
            	            // InternalQueryDsl.g:969:5: ( (lv_q_11_0= ruleModelQuery ) )
            	            // InternalQueryDsl.g:970:6: (lv_q_11_0= ruleModelQuery )
            	            {
            	            // InternalQueryDsl.g:970:6: (lv_q_11_0= ruleModelQuery )
            	            // InternalQueryDsl.g:971:7: lv_q_11_0= ruleModelQuery
            	            {

            	            							newCompositeNode(grammarAccess.getModelAccess().getQModelQueryParserRuleCall_6_1_3_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_q_11_0=ruleModelQuery();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getModelRule());
            	            							}
            	            							set(
            	            								current,
            	            								"q",
            	            								lv_q_11_0,
            	            								"com.arsene.query.QueryDsl.ModelQuery");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_12=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_12, grammarAccess.getModelAccess().getReturnKeyword_7());
            		
            otherlv_13=(Token)match(input,17,FOLLOW_25); 

            			newLeafNode(otherlv_13, grammarAccess.getModelAccess().getLeftSquareBracketKeyword_8());
            		
            // InternalQueryDsl.g:998:3: ( (lv_field_14_0= ruleModelField ) )
            // InternalQueryDsl.g:999:4: (lv_field_14_0= ruleModelField )
            {
            // InternalQueryDsl.g:999:4: (lv_field_14_0= ruleModelField )
            // InternalQueryDsl.g:1000:5: lv_field_14_0= ruleModelField
            {

            					newCompositeNode(grammarAccess.getModelAccess().getFieldModelFieldParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_11);
            lv_field_14_0=ruleModelField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_14_0,
            						"com.arsene.query.QueryDsl.ModelField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:1017:3: (otherlv_15= ',' ( (lv_fields_16_0= ruleModelField ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==14) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalQueryDsl.g:1018:4: otherlv_15= ',' ( (lv_fields_16_0= ruleModelField ) )
            	    {
            	    otherlv_15=(Token)match(input,14,FOLLOW_25); 

            	    				newLeafNode(otherlv_15, grammarAccess.getModelAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalQueryDsl.g:1022:4: ( (lv_fields_16_0= ruleModelField ) )
            	    // InternalQueryDsl.g:1023:5: (lv_fields_16_0= ruleModelField )
            	    {
            	    // InternalQueryDsl.g:1023:5: (lv_fields_16_0= ruleModelField )
            	    // InternalQueryDsl.g:1024:6: lv_fields_16_0= ruleModelField
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getFieldsModelFieldParserRuleCall_10_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_fields_16_0=ruleModelField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_16_0,
            	    							"com.arsene.query.QueryDsl.ModelField");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_17=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getModelAccess().getRightSquareBracketKeyword_11());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleDsl"
    // InternalQueryDsl.g:1050:1: entryRuleDsl returns [EObject current=null] : iv_ruleDsl= ruleDsl EOF ;
    public final EObject entryRuleDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDsl = null;


        try {
            // InternalQueryDsl.g:1050:44: (iv_ruleDsl= ruleDsl EOF )
            // InternalQueryDsl.g:1051:2: iv_ruleDsl= ruleDsl EOF
            {
             newCompositeNode(grammarAccess.getDslRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDsl=ruleDsl();

            state._fsp--;

             current =iv_ruleDsl; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDsl"


    // $ANTLR start "ruleDsl"
    // InternalQueryDsl.g:1057:1: ruleDsl returns [EObject current=null] : (otherlv_0= 'Query' otherlv_1= 'Dsl' otherlv_2= '(' ( (lv_dslVar_3_0= ruleDslVar ) ) (otherlv_4= ',' ( (lv_dslVars_5_0= ruleDslVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) ) )* otherlv_11= 'return' otherlv_12= '[' ( (lv_field_13_0= ruleDslField ) ) (otherlv_14= ',' ( (lv_fields_15_0= ruleDslField ) ) )* otherlv_16= ']' ) ;
    public final EObject ruleDsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_dslVar_3_0 = null;

        EObject lv_dslVars_5_0 = null;

        EObject lv_syntax_8_0 = null;

        EObject lv_textSearch_9_0 = null;

        EObject lv_filter_10_0 = null;

        EObject lv_field_13_0 = null;

        EObject lv_fields_15_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:1063:2: ( (otherlv_0= 'Query' otherlv_1= 'Dsl' otherlv_2= '(' ( (lv_dslVar_3_0= ruleDslVar ) ) (otherlv_4= ',' ( (lv_dslVars_5_0= ruleDslVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) ) )* otherlv_11= 'return' otherlv_12= '[' ( (lv_field_13_0= ruleDslField ) ) (otherlv_14= ',' ( (lv_fields_15_0= ruleDslField ) ) )* otherlv_16= ']' ) )
            // InternalQueryDsl.g:1064:2: (otherlv_0= 'Query' otherlv_1= 'Dsl' otherlv_2= '(' ( (lv_dslVar_3_0= ruleDslVar ) ) (otherlv_4= ',' ( (lv_dslVars_5_0= ruleDslVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) ) )* otherlv_11= 'return' otherlv_12= '[' ( (lv_field_13_0= ruleDslField ) ) (otherlv_14= ',' ( (lv_fields_15_0= ruleDslField ) ) )* otherlv_16= ']' )
            {
            // InternalQueryDsl.g:1064:2: (otherlv_0= 'Query' otherlv_1= 'Dsl' otherlv_2= '(' ( (lv_dslVar_3_0= ruleDslVar ) ) (otherlv_4= ',' ( (lv_dslVars_5_0= ruleDslVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) ) )* otherlv_11= 'return' otherlv_12= '[' ( (lv_field_13_0= ruleDslField ) ) (otherlv_14= ',' ( (lv_fields_15_0= ruleDslField ) ) )* otherlv_16= ']' )
            // InternalQueryDsl.g:1065:3: otherlv_0= 'Query' otherlv_1= 'Dsl' otherlv_2= '(' ( (lv_dslVar_3_0= ruleDslVar ) ) (otherlv_4= ',' ( (lv_dslVars_5_0= ruleDslVar ) ) )* otherlv_6= ')' (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) ) )* otherlv_11= 'return' otherlv_12= '[' ( (lv_field_13_0= ruleDslField ) ) (otherlv_14= ',' ( (lv_fields_15_0= ruleDslField ) ) )* otherlv_16= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getDslAccess().getQueryKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getDslAccess().getDslKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getDslAccess().getLeftParenthesisKeyword_2());
            		
            // InternalQueryDsl.g:1077:3: ( (lv_dslVar_3_0= ruleDslVar ) )
            // InternalQueryDsl.g:1078:4: (lv_dslVar_3_0= ruleDslVar )
            {
            // InternalQueryDsl.g:1078:4: (lv_dslVar_3_0= ruleDslVar )
            // InternalQueryDsl.g:1079:5: lv_dslVar_3_0= ruleDslVar
            {

            					newCompositeNode(grammarAccess.getDslAccess().getDslVarDslVarParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_dslVar_3_0=ruleDslVar();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDslRule());
            					}
            					set(
            						current,
            						"dslVar",
            						lv_dslVar_3_0,
            						"com.arsene.query.QueryDsl.DslVar");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:1096:3: (otherlv_4= ',' ( (lv_dslVars_5_0= ruleDslVar ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==14) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalQueryDsl.g:1097:4: otherlv_4= ',' ( (lv_dslVars_5_0= ruleDslVar ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_19); 

            	    				newLeafNode(otherlv_4, grammarAccess.getDslAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalQueryDsl.g:1101:4: ( (lv_dslVars_5_0= ruleDslVar ) )
            	    // InternalQueryDsl.g:1102:5: (lv_dslVars_5_0= ruleDslVar )
            	    {
            	    // InternalQueryDsl.g:1102:5: (lv_dslVars_5_0= ruleDslVar )
            	    // InternalQueryDsl.g:1103:6: lv_dslVars_5_0= ruleDslVar
            	    {

            	    						newCompositeNode(grammarAccess.getDslAccess().getDslVarsDslVarParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_dslVars_5_0=ruleDslVar();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDslRule());
            	    						}
            	    						add(
            	    							current,
            	    							"dslVars",
            	    							lv_dslVars_5_0,
            	    							"com.arsene.query.QueryDsl.DslVar");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_20); 

            			newLeafNode(otherlv_6, grammarAccess.getDslAccess().getRightParenthesisKeyword_5());
            		
            // InternalQueryDsl.g:1125:3: (otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==22) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalQueryDsl.g:1126:4: otherlv_7= '=>' ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) )
            	    {
            	    otherlv_7=(Token)match(input,22,FOLLOW_27); 

            	    				newLeafNode(otherlv_7, grammarAccess.getDslAccess().getEqualsSignGreaterThanSignKeyword_6_0());
            	    			
            	    // InternalQueryDsl.g:1130:4: ( ( (lv_syntax_8_0= ruleMicroSyntax ) ) | ( (lv_textSearch_9_0= ruleFullTextSearch ) ) | ( (lv_filter_10_0= ruleFilter ) ) )
            	    int alt18=3;
            	    switch ( input.LA(1) ) {
            	    case 25:
            	        {
            	        alt18=1;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt18=2;
            	        }
            	        break;
            	    case 63:
            	        {
            	        alt18=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt18) {
            	        case 1 :
            	            // InternalQueryDsl.g:1131:5: ( (lv_syntax_8_0= ruleMicroSyntax ) )
            	            {
            	            // InternalQueryDsl.g:1131:5: ( (lv_syntax_8_0= ruleMicroSyntax ) )
            	            // InternalQueryDsl.g:1132:6: (lv_syntax_8_0= ruleMicroSyntax )
            	            {
            	            // InternalQueryDsl.g:1132:6: (lv_syntax_8_0= ruleMicroSyntax )
            	            // InternalQueryDsl.g:1133:7: lv_syntax_8_0= ruleMicroSyntax
            	            {

            	            							newCompositeNode(grammarAccess.getDslAccess().getSyntaxMicroSyntaxParserRuleCall_6_1_0_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_syntax_8_0=ruleMicroSyntax();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getDslRule());
            	            							}
            	            							set(
            	            								current,
            	            								"syntax",
            	            								lv_syntax_8_0,
            	            								"com.arsene.query.QueryDsl.MicroSyntax");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalQueryDsl.g:1151:5: ( (lv_textSearch_9_0= ruleFullTextSearch ) )
            	            {
            	            // InternalQueryDsl.g:1151:5: ( (lv_textSearch_9_0= ruleFullTextSearch ) )
            	            // InternalQueryDsl.g:1152:6: (lv_textSearch_9_0= ruleFullTextSearch )
            	            {
            	            // InternalQueryDsl.g:1152:6: (lv_textSearch_9_0= ruleFullTextSearch )
            	            // InternalQueryDsl.g:1153:7: lv_textSearch_9_0= ruleFullTextSearch
            	            {

            	            							newCompositeNode(grammarAccess.getDslAccess().getTextSearchFullTextSearchParserRuleCall_6_1_1_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_textSearch_9_0=ruleFullTextSearch();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getDslRule());
            	            							}
            	            							set(
            	            								current,
            	            								"textSearch",
            	            								lv_textSearch_9_0,
            	            								"com.arsene.query.QueryDsl.FullTextSearch");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalQueryDsl.g:1171:5: ( (lv_filter_10_0= ruleFilter ) )
            	            {
            	            // InternalQueryDsl.g:1171:5: ( (lv_filter_10_0= ruleFilter ) )
            	            // InternalQueryDsl.g:1172:6: (lv_filter_10_0= ruleFilter )
            	            {
            	            // InternalQueryDsl.g:1172:6: (lv_filter_10_0= ruleFilter )
            	            // InternalQueryDsl.g:1173:7: lv_filter_10_0= ruleFilter
            	            {

            	            							newCompositeNode(grammarAccess.getDslAccess().getFilterFilterParserRuleCall_6_1_2_0());
            	            						
            	            pushFollow(FOLLOW_20);
            	            lv_filter_10_0=ruleFilter();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getDslRule());
            	            							}
            	            							set(
            	            								current,
            	            								"filter",
            	            								lv_filter_10_0,
            	            								"com.arsene.query.QueryDsl.Filter");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_11=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_11, grammarAccess.getDslAccess().getReturnKeyword_7());
            		
            otherlv_12=(Token)match(input,17,FOLLOW_28); 

            			newLeafNode(otherlv_12, grammarAccess.getDslAccess().getLeftSquareBracketKeyword_8());
            		
            // InternalQueryDsl.g:1200:3: ( (lv_field_13_0= ruleDslField ) )
            // InternalQueryDsl.g:1201:4: (lv_field_13_0= ruleDslField )
            {
            // InternalQueryDsl.g:1201:4: (lv_field_13_0= ruleDslField )
            // InternalQueryDsl.g:1202:5: lv_field_13_0= ruleDslField
            {

            					newCompositeNode(grammarAccess.getDslAccess().getFieldDslFieldParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_11);
            lv_field_13_0=ruleDslField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDslRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_13_0,
            						"com.arsene.query.QueryDsl.DslField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:1219:3: (otherlv_14= ',' ( (lv_fields_15_0= ruleDslField ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==14) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalQueryDsl.g:1220:4: otherlv_14= ',' ( (lv_fields_15_0= ruleDslField ) )
            	    {
            	    otherlv_14=(Token)match(input,14,FOLLOW_28); 

            	    				newLeafNode(otherlv_14, grammarAccess.getDslAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalQueryDsl.g:1224:4: ( (lv_fields_15_0= ruleDslField ) )
            	    // InternalQueryDsl.g:1225:5: (lv_fields_15_0= ruleDslField )
            	    {
            	    // InternalQueryDsl.g:1225:5: (lv_fields_15_0= ruleDslField )
            	    // InternalQueryDsl.g:1226:6: lv_fields_15_0= ruleDslField
            	    {

            	    						newCompositeNode(grammarAccess.getDslAccess().getFieldsDslFieldParserRuleCall_10_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_fields_15_0=ruleDslField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDslRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_15_0,
            	    							"com.arsene.query.QueryDsl.DslField");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_16=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getDslAccess().getRightSquareBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDsl"


    // $ANTLR start "entryRuleMicroSyntax"
    // InternalQueryDsl.g:1252:1: entryRuleMicroSyntax returns [EObject current=null] : iv_ruleMicroSyntax= ruleMicroSyntax EOF ;
    public final EObject entryRuleMicroSyntax() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroSyntax = null;


        try {
            // InternalQueryDsl.g:1252:52: (iv_ruleMicroSyntax= ruleMicroSyntax EOF )
            // InternalQueryDsl.g:1253:2: iv_ruleMicroSyntax= ruleMicroSyntax EOF
            {
             newCompositeNode(grammarAccess.getMicroSyntaxRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMicroSyntax=ruleMicroSyntax();

            state._fsp--;

             current =iv_ruleMicroSyntax; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMicroSyntax"


    // $ANTLR start "ruleMicroSyntax"
    // InternalQueryDsl.g:1259:1: ruleMicroSyntax returns [EObject current=null] : (otherlv_0= 'microSyntax' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleMicroSyntax() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:1265:2: ( (otherlv_0= 'microSyntax' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalQueryDsl.g:1266:2: (otherlv_0= 'microSyntax' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalQueryDsl.g:1266:2: (otherlv_0= 'microSyntax' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalQueryDsl.g:1267:3: otherlv_0= 'microSyntax' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMicroSyntaxAccess().getMicroSyntaxKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getMicroSyntaxAccess().getLeftParenthesisKeyword_1());
            		
            // InternalQueryDsl.g:1275:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:1276:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:1276:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:1277:5: lv_exp_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getMicroSyntaxAccess().getExpExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
            lv_exp_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMicroSyntaxRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMicroSyntaxAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMicroSyntax"


    // $ANTLR start "entryRuleModelQuery"
    // InternalQueryDsl.g:1302:1: entryRuleModelQuery returns [EObject current=null] : iv_ruleModelQuery= ruleModelQuery EOF ;
    public final EObject entryRuleModelQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelQuery = null;


        try {
            // InternalQueryDsl.g:1302:51: (iv_ruleModelQuery= ruleModelQuery EOF )
            // InternalQueryDsl.g:1303:2: iv_ruleModelQuery= ruleModelQuery EOF
            {
             newCompositeNode(grammarAccess.getModelQueryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModelQuery=ruleModelQuery();

            state._fsp--;

             current =iv_ruleModelQuery; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModelQuery"


    // $ANTLR start "ruleModelQuery"
    // InternalQueryDsl.g:1309:1: ruleModelQuery returns [EObject current=null] : (otherlv_0= 'modelQuery' otherlv_1= '(' otherlv_2= 'type' otherlv_3= ':' ruleQueryLang otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ) ;
    public final EObject ruleModelQuery() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_expr_6_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:1315:2: ( (otherlv_0= 'modelQuery' otherlv_1= '(' otherlv_2= 'type' otherlv_3= ':' ruleQueryLang otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ) )
            // InternalQueryDsl.g:1316:2: (otherlv_0= 'modelQuery' otherlv_1= '(' otherlv_2= 'type' otherlv_3= ':' ruleQueryLang otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' )
            {
            // InternalQueryDsl.g:1316:2: (otherlv_0= 'modelQuery' otherlv_1= '(' otherlv_2= 'type' otherlv_3= ':' ruleQueryLang otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' )
            // InternalQueryDsl.g:1317:3: otherlv_0= 'modelQuery' otherlv_1= '(' otherlv_2= 'type' otherlv_3= ':' ruleQueryLang otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getModelQueryAccess().getModelQueryKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getModelQueryAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,27,FOLLOW_32); 

            			newLeafNode(otherlv_2, grammarAccess.getModelQueryAccess().getTypeKeyword_2());
            		
            otherlv_3=(Token)match(input,28,FOLLOW_33); 

            			newLeafNode(otherlv_3, grammarAccess.getModelQueryAccess().getColonKeyword_3());
            		

            			newCompositeNode(grammarAccess.getModelQueryAccess().getQueryLangParserRuleCall_4());
            		
            pushFollow(FOLLOW_34);
            ruleQueryLang();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_5=(Token)match(input,14,FOLLOW_29); 

            			newLeafNode(otherlv_5, grammarAccess.getModelQueryAccess().getCommaKeyword_5());
            		
            // InternalQueryDsl.g:1344:3: ( (lv_expr_6_0= ruleExpression ) )
            // InternalQueryDsl.g:1345:4: (lv_expr_6_0= ruleExpression )
            {
            // InternalQueryDsl.g:1345:4: (lv_expr_6_0= ruleExpression )
            // InternalQueryDsl.g:1346:5: lv_expr_6_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getModelQueryAccess().getExprExpressionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_30);
            lv_expr_6_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelQueryRule());
            					}
            					set(
            						current,
            						"expr",
            						lv_expr_6_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getModelQueryAccess().getRightParenthesisKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelQuery"


    // $ANTLR start "entryRuleQueryLang"
    // InternalQueryDsl.g:1371:1: entryRuleQueryLang returns [String current=null] : iv_ruleQueryLang= ruleQueryLang EOF ;
    public final String entryRuleQueryLang() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQueryLang = null;


        try {
            // InternalQueryDsl.g:1371:49: (iv_ruleQueryLang= ruleQueryLang EOF )
            // InternalQueryDsl.g:1372:2: iv_ruleQueryLang= ruleQueryLang EOF
            {
             newCompositeNode(grammarAccess.getQueryLangRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQueryLang=ruleQueryLang();

            state._fsp--;

             current =iv_ruleQueryLang.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQueryLang"


    // $ANTLR start "ruleQueryLang"
    // InternalQueryDsl.g:1378:1: ruleQueryLang returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'EOL' | kw= 'OCL' ) ;
    public final AntlrDatatypeRuleToken ruleQueryLang() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:1384:2: ( (kw= 'EOL' | kw= 'OCL' ) )
            // InternalQueryDsl.g:1385:2: (kw= 'EOL' | kw= 'OCL' )
            {
            // InternalQueryDsl.g:1385:2: (kw= 'EOL' | kw= 'OCL' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            else if ( (LA21_0==30) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalQueryDsl.g:1386:3: kw= 'EOL'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getQueryLangAccess().getEOLKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1392:3: kw= 'OCL'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getQueryLangAccess().getOCLKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryLang"


    // $ANTLR start "entryRuleFullTextSearch"
    // InternalQueryDsl.g:1401:1: entryRuleFullTextSearch returns [EObject current=null] : iv_ruleFullTextSearch= ruleFullTextSearch EOF ;
    public final EObject entryRuleFullTextSearch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullTextSearch = null;


        try {
            // InternalQueryDsl.g:1401:55: (iv_ruleFullTextSearch= ruleFullTextSearch EOF )
            // InternalQueryDsl.g:1402:2: iv_ruleFullTextSearch= ruleFullTextSearch EOF
            {
             newCompositeNode(grammarAccess.getFullTextSearchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFullTextSearch=ruleFullTextSearch();

            state._fsp--;

             current =iv_ruleFullTextSearch; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFullTextSearch"


    // $ANTLR start "ruleFullTextSearch"
    // InternalQueryDsl.g:1408:1: ruleFullTextSearch returns [EObject current=null] : (otherlv_0= 'fullTextSearch' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_exps_4_0= ruleExpression ) ) )* ( (otherlv_5= ',' otherlv_6= 'min_match' otherlv_7= ':' this_INT_8= RULE_INT ) | (otherlv_9= ',' otherlv_10= 'operator' otherlv_11= ':' ( (lv_op_12_0= ruleOperator ) ) ) )? otherlv_13= ')' ) ;
    public final EObject ruleFullTextSearch() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token this_INT_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_exp_2_0 = null;

        EObject lv_exps_4_0 = null;

        EObject lv_op_12_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:1414:2: ( (otherlv_0= 'fullTextSearch' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_exps_4_0= ruleExpression ) ) )* ( (otherlv_5= ',' otherlv_6= 'min_match' otherlv_7= ':' this_INT_8= RULE_INT ) | (otherlv_9= ',' otherlv_10= 'operator' otherlv_11= ':' ( (lv_op_12_0= ruleOperator ) ) ) )? otherlv_13= ')' ) )
            // InternalQueryDsl.g:1415:2: (otherlv_0= 'fullTextSearch' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_exps_4_0= ruleExpression ) ) )* ( (otherlv_5= ',' otherlv_6= 'min_match' otherlv_7= ':' this_INT_8= RULE_INT ) | (otherlv_9= ',' otherlv_10= 'operator' otherlv_11= ':' ( (lv_op_12_0= ruleOperator ) ) ) )? otherlv_13= ')' )
            {
            // InternalQueryDsl.g:1415:2: (otherlv_0= 'fullTextSearch' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_exps_4_0= ruleExpression ) ) )* ( (otherlv_5= ',' otherlv_6= 'min_match' otherlv_7= ':' this_INT_8= RULE_INT ) | (otherlv_9= ',' otherlv_10= 'operator' otherlv_11= ':' ( (lv_op_12_0= ruleOperator ) ) ) )? otherlv_13= ')' )
            // InternalQueryDsl.g:1416:3: otherlv_0= 'fullTextSearch' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_exps_4_0= ruleExpression ) ) )* ( (otherlv_5= ',' otherlv_6= 'min_match' otherlv_7= ':' this_INT_8= RULE_INT ) | (otherlv_9= ',' otherlv_10= 'operator' otherlv_11= ':' ( (lv_op_12_0= ruleOperator ) ) ) )? otherlv_13= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFullTextSearchAccess().getFullTextSearchKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getFullTextSearchAccess().getLeftParenthesisKeyword_1());
            		
            // InternalQueryDsl.g:1424:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:1425:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:1425:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:1426:5: lv_exp_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getFullTextSearchAccess().getExpExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_exp_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFullTextSearchRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:1443:3: (otherlv_3= ',' ( (lv_exps_4_0= ruleExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==14) ) {
                    int LA22_1 = input.LA(2);

                    if ( ((LA22_1>=RULE_INT && LA22_1<=RULE_STRING)||(LA22_1>=110 && LA22_1<=111)) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // InternalQueryDsl.g:1444:4: otherlv_3= ',' ( (lv_exps_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,14,FOLLOW_29); 

            	    				newLeafNode(otherlv_3, grammarAccess.getFullTextSearchAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalQueryDsl.g:1448:4: ( (lv_exps_4_0= ruleExpression ) )
            	    // InternalQueryDsl.g:1449:5: (lv_exps_4_0= ruleExpression )
            	    {
            	    // InternalQueryDsl.g:1449:5: (lv_exps_4_0= ruleExpression )
            	    // InternalQueryDsl.g:1450:6: lv_exps_4_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getFullTextSearchAccess().getExpsExpressionParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_exps_4_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFullTextSearchRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exps",
            	    							lv_exps_4_0,
            	    							"com.arsene.query.QueryDsl.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // InternalQueryDsl.g:1468:3: ( (otherlv_5= ',' otherlv_6= 'min_match' otherlv_7= ':' this_INT_8= RULE_INT ) | (otherlv_9= ',' otherlv_10= 'operator' otherlv_11= ':' ( (lv_op_12_0= ruleOperator ) ) ) )?
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==14) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==32) ) {
                    alt23=1;
                }
                else if ( (LA23_1==33) ) {
                    alt23=2;
                }
            }
            switch (alt23) {
                case 1 :
                    // InternalQueryDsl.g:1469:4: (otherlv_5= ',' otherlv_6= 'min_match' otherlv_7= ':' this_INT_8= RULE_INT )
                    {
                    // InternalQueryDsl.g:1469:4: (otherlv_5= ',' otherlv_6= 'min_match' otherlv_7= ':' this_INT_8= RULE_INT )
                    // InternalQueryDsl.g:1470:5: otherlv_5= ',' otherlv_6= 'min_match' otherlv_7= ':' this_INT_8= RULE_INT
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_35); 

                    					newLeafNode(otherlv_5, grammarAccess.getFullTextSearchAccess().getCommaKeyword_4_0_0());
                    				
                    otherlv_6=(Token)match(input,32,FOLLOW_32); 

                    					newLeafNode(otherlv_6, grammarAccess.getFullTextSearchAccess().getMin_matchKeyword_4_0_1());
                    				
                    otherlv_7=(Token)match(input,28,FOLLOW_36); 

                    					newLeafNode(otherlv_7, grammarAccess.getFullTextSearchAccess().getColonKeyword_4_0_2());
                    				
                    this_INT_8=(Token)match(input,RULE_INT,FOLLOW_30); 

                    					newLeafNode(this_INT_8, grammarAccess.getFullTextSearchAccess().getINTTerminalRuleCall_4_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1488:4: (otherlv_9= ',' otherlv_10= 'operator' otherlv_11= ':' ( (lv_op_12_0= ruleOperator ) ) )
                    {
                    // InternalQueryDsl.g:1488:4: (otherlv_9= ',' otherlv_10= 'operator' otherlv_11= ':' ( (lv_op_12_0= ruleOperator ) ) )
                    // InternalQueryDsl.g:1489:5: otherlv_9= ',' otherlv_10= 'operator' otherlv_11= ':' ( (lv_op_12_0= ruleOperator ) )
                    {
                    otherlv_9=(Token)match(input,14,FOLLOW_37); 

                    					newLeafNode(otherlv_9, grammarAccess.getFullTextSearchAccess().getCommaKeyword_4_1_0());
                    				
                    otherlv_10=(Token)match(input,33,FOLLOW_32); 

                    					newLeafNode(otherlv_10, grammarAccess.getFullTextSearchAccess().getOperatorKeyword_4_1_1());
                    				
                    otherlv_11=(Token)match(input,28,FOLLOW_38); 

                    					newLeafNode(otherlv_11, grammarAccess.getFullTextSearchAccess().getColonKeyword_4_1_2());
                    				
                    // InternalQueryDsl.g:1501:5: ( (lv_op_12_0= ruleOperator ) )
                    // InternalQueryDsl.g:1502:6: (lv_op_12_0= ruleOperator )
                    {
                    // InternalQueryDsl.g:1502:6: (lv_op_12_0= ruleOperator )
                    // InternalQueryDsl.g:1503:7: lv_op_12_0= ruleOperator
                    {

                    							newCompositeNode(grammarAccess.getFullTextSearchAccess().getOpOperatorParserRuleCall_4_1_3_0());
                    						
                    pushFollow(FOLLOW_30);
                    lv_op_12_0=ruleOperator();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFullTextSearchRule());
                    							}
                    							set(
                    								current,
                    								"op",
                    								lv_op_12_0,
                    								"com.arsene.query.QueryDsl.Operator");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getFullTextSearchAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFullTextSearch"


    // $ANTLR start "entryRuleQualityMetric"
    // InternalQueryDsl.g:1530:1: entryRuleQualityMetric returns [EObject current=null] : iv_ruleQualityMetric= ruleQualityMetric EOF ;
    public final EObject entryRuleQualityMetric() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityMetric = null;


        try {
            // InternalQueryDsl.g:1530:54: (iv_ruleQualityMetric= ruleQualityMetric EOF )
            // InternalQueryDsl.g:1531:2: iv_ruleQualityMetric= ruleQualityMetric EOF
            {
             newCompositeNode(grammarAccess.getQualityMetricRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualityMetric=ruleQualityMetric();

            state._fsp--;

             current =iv_ruleQualityMetric; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQualityMetric"


    // $ANTLR start "ruleQualityMetric"
    // InternalQueryDsl.g:1537:1: ruleQualityMetric returns [EObject current=null] : (otherlv_0= 'qualityMetrics' otherlv_1= '(' ( (lv_qExp_2_0= ruleQExp ) ) ( ( (lv_operator_3_0= ruleOperator ) ) ( (lv_qExps_4_0= ruleQExp ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleQualityMetric() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_qExp_2_0 = null;

        EObject lv_operator_3_0 = null;

        EObject lv_qExps_4_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:1543:2: ( (otherlv_0= 'qualityMetrics' otherlv_1= '(' ( (lv_qExp_2_0= ruleQExp ) ) ( ( (lv_operator_3_0= ruleOperator ) ) ( (lv_qExps_4_0= ruleQExp ) ) )* otherlv_5= ')' ) )
            // InternalQueryDsl.g:1544:2: (otherlv_0= 'qualityMetrics' otherlv_1= '(' ( (lv_qExp_2_0= ruleQExp ) ) ( ( (lv_operator_3_0= ruleOperator ) ) ( (lv_qExps_4_0= ruleQExp ) ) )* otherlv_5= ')' )
            {
            // InternalQueryDsl.g:1544:2: (otherlv_0= 'qualityMetrics' otherlv_1= '(' ( (lv_qExp_2_0= ruleQExp ) ) ( ( (lv_operator_3_0= ruleOperator ) ) ( (lv_qExps_4_0= ruleQExp ) ) )* otherlv_5= ')' )
            // InternalQueryDsl.g:1545:3: otherlv_0= 'qualityMetrics' otherlv_1= '(' ( (lv_qExp_2_0= ruleQExp ) ) ( ( (lv_operator_3_0= ruleOperator ) ) ( (lv_qExps_4_0= ruleQExp ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getQualityMetricAccess().getQualityMetricsKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getQualityMetricAccess().getLeftParenthesisKeyword_1());
            		
            // InternalQueryDsl.g:1553:3: ( (lv_qExp_2_0= ruleQExp ) )
            // InternalQueryDsl.g:1554:4: (lv_qExp_2_0= ruleQExp )
            {
            // InternalQueryDsl.g:1554:4: (lv_qExp_2_0= ruleQExp )
            // InternalQueryDsl.g:1555:5: lv_qExp_2_0= ruleQExp
            {

            					newCompositeNode(grammarAccess.getQualityMetricAccess().getQExpQExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_40);
            lv_qExp_2_0=ruleQExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQualityMetricRule());
            					}
            					set(
            						current,
            						"qExp",
            						lv_qExp_2_0,
            						"com.arsene.query.QueryDsl.QExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:1572:3: ( ( (lv_operator_3_0= ruleOperator ) ) ( (lv_qExps_4_0= ruleQExp ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=60 && LA24_0<=62)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalQueryDsl.g:1573:4: ( (lv_operator_3_0= ruleOperator ) ) ( (lv_qExps_4_0= ruleQExp ) )
            	    {
            	    // InternalQueryDsl.g:1573:4: ( (lv_operator_3_0= ruleOperator ) )
            	    // InternalQueryDsl.g:1574:5: (lv_operator_3_0= ruleOperator )
            	    {
            	    // InternalQueryDsl.g:1574:5: (lv_operator_3_0= ruleOperator )
            	    // InternalQueryDsl.g:1575:6: lv_operator_3_0= ruleOperator
            	    {

            	    						newCompositeNode(grammarAccess.getQualityMetricAccess().getOperatorOperatorParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_39);
            	    lv_operator_3_0=ruleOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getQualityMetricRule());
            	    						}
            	    						set(
            	    							current,
            	    							"operator",
            	    							lv_operator_3_0,
            	    							"com.arsene.query.QueryDsl.Operator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalQueryDsl.g:1592:4: ( (lv_qExps_4_0= ruleQExp ) )
            	    // InternalQueryDsl.g:1593:5: (lv_qExps_4_0= ruleQExp )
            	    {
            	    // InternalQueryDsl.g:1593:5: (lv_qExps_4_0= ruleQExp )
            	    // InternalQueryDsl.g:1594:6: lv_qExps_4_0= ruleQExp
            	    {

            	    						newCompositeNode(grammarAccess.getQualityMetricAccess().getQExpsQExpParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_qExps_4_0=ruleQExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getQualityMetricRule());
            	    						}
            	    						set(
            	    							current,
            	    							"qExps",
            	    							lv_qExps_4_0,
            	    							"com.arsene.query.QueryDsl.QExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getQualityMetricAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualityMetric"


    // $ANTLR start "entryRuleTransformable"
    // InternalQueryDsl.g:1620:1: entryRuleTransformable returns [EObject current=null] : iv_ruleTransformable= ruleTransformable EOF ;
    public final EObject entryRuleTransformable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformable = null;


        try {
            // InternalQueryDsl.g:1620:54: (iv_ruleTransformable= ruleTransformable EOF )
            // InternalQueryDsl.g:1621:2: iv_ruleTransformable= ruleTransformable EOF
            {
             newCompositeNode(grammarAccess.getTransformableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransformable=ruleTransformable();

            state._fsp--;

             current =iv_ruleTransformable; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTransformable"


    // $ANTLR start "ruleTransformable"
    // InternalQueryDsl.g:1627:1: ruleTransformable returns [EObject current=null] : (otherlv_0= 'transformable' otherlv_1= '(' ( ( (lv_param_2_0= ruleTransParam ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleExpression ) ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleTransParam ) ) otherlv_7= ':' ( (lv_exp_8_0= ruleExpression ) ) )? otherlv_9= ')' ) ;
    public final EObject ruleTransformable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_param_2_0 = null;

        EObject lv_exp_4_0 = null;

        EObject lv_param_6_0 = null;

        EObject lv_exp_8_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:1633:2: ( (otherlv_0= 'transformable' otherlv_1= '(' ( ( (lv_param_2_0= ruleTransParam ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleExpression ) ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleTransParam ) ) otherlv_7= ':' ( (lv_exp_8_0= ruleExpression ) ) )? otherlv_9= ')' ) )
            // InternalQueryDsl.g:1634:2: (otherlv_0= 'transformable' otherlv_1= '(' ( ( (lv_param_2_0= ruleTransParam ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleExpression ) ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleTransParam ) ) otherlv_7= ':' ( (lv_exp_8_0= ruleExpression ) ) )? otherlv_9= ')' )
            {
            // InternalQueryDsl.g:1634:2: (otherlv_0= 'transformable' otherlv_1= '(' ( ( (lv_param_2_0= ruleTransParam ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleExpression ) ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleTransParam ) ) otherlv_7= ':' ( (lv_exp_8_0= ruleExpression ) ) )? otherlv_9= ')' )
            // InternalQueryDsl.g:1635:3: otherlv_0= 'transformable' otherlv_1= '(' ( ( (lv_param_2_0= ruleTransParam ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleExpression ) ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleTransParam ) ) otherlv_7= ':' ( (lv_exp_8_0= ruleExpression ) ) )? otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTransformableAccess().getTransformableKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_41); 

            			newLeafNode(otherlv_1, grammarAccess.getTransformableAccess().getLeftParenthesisKeyword_1());
            		
            // InternalQueryDsl.g:1643:3: ( ( (lv_param_2_0= ruleTransParam ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleExpression ) ) )
            // InternalQueryDsl.g:1644:4: ( (lv_param_2_0= ruleTransParam ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleExpression ) )
            {
            // InternalQueryDsl.g:1644:4: ( (lv_param_2_0= ruleTransParam ) )
            // InternalQueryDsl.g:1645:5: (lv_param_2_0= ruleTransParam )
            {
            // InternalQueryDsl.g:1645:5: (lv_param_2_0= ruleTransParam )
            // InternalQueryDsl.g:1646:6: lv_param_2_0= ruleTransParam
            {

            						newCompositeNode(grammarAccess.getTransformableAccess().getParamTransParamParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_32);
            lv_param_2_0=ruleTransParam();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getTransformableRule());
            						}
            						set(
            							current,
            							"param",
            							lv_param_2_0,
            							"com.arsene.query.QueryDsl.TransParam");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            otherlv_3=(Token)match(input,28,FOLLOW_29); 

            				newLeafNode(otherlv_3, grammarAccess.getTransformableAccess().getColonKeyword_2_1());
            			
            // InternalQueryDsl.g:1667:4: ( (lv_exp_4_0= ruleExpression ) )
            // InternalQueryDsl.g:1668:5: (lv_exp_4_0= ruleExpression )
            {
            // InternalQueryDsl.g:1668:5: (lv_exp_4_0= ruleExpression )
            // InternalQueryDsl.g:1669:6: lv_exp_4_0= ruleExpression
            {

            						newCompositeNode(grammarAccess.getTransformableAccess().getExpExpressionParserRuleCall_2_2_0());
            					
            pushFollow(FOLLOW_7);
            lv_exp_4_0=ruleExpression();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getTransformableRule());
            						}
            						set(
            							current,
            							"exp",
            							lv_exp_4_0,
            							"com.arsene.query.QueryDsl.Expression");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            // InternalQueryDsl.g:1687:3: (otherlv_5= ',' ( (lv_param_6_0= ruleTransParam ) ) otherlv_7= ':' ( (lv_exp_8_0= ruleExpression ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==14) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalQueryDsl.g:1688:4: otherlv_5= ',' ( (lv_param_6_0= ruleTransParam ) ) otherlv_7= ':' ( (lv_exp_8_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_41); 

                    				newLeafNode(otherlv_5, grammarAccess.getTransformableAccess().getCommaKeyword_3_0());
                    			
                    // InternalQueryDsl.g:1692:4: ( (lv_param_6_0= ruleTransParam ) )
                    // InternalQueryDsl.g:1693:5: (lv_param_6_0= ruleTransParam )
                    {
                    // InternalQueryDsl.g:1693:5: (lv_param_6_0= ruleTransParam )
                    // InternalQueryDsl.g:1694:6: lv_param_6_0= ruleTransParam
                    {

                    						newCompositeNode(grammarAccess.getTransformableAccess().getParamTransParamParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_param_6_0=ruleTransParam();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransformableRule());
                    						}
                    						set(
                    							current,
                    							"param",
                    							lv_param_6_0,
                    							"com.arsene.query.QueryDsl.TransParam");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,28,FOLLOW_29); 

                    				newLeafNode(otherlv_7, grammarAccess.getTransformableAccess().getColonKeyword_3_2());
                    			
                    // InternalQueryDsl.g:1715:4: ( (lv_exp_8_0= ruleExpression ) )
                    // InternalQueryDsl.g:1716:5: (lv_exp_8_0= ruleExpression )
                    {
                    // InternalQueryDsl.g:1716:5: (lv_exp_8_0= ruleExpression )
                    // InternalQueryDsl.g:1717:6: lv_exp_8_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getTransformableAccess().getExpExpressionParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_exp_8_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransformableRule());
                    						}
                    						set(
                    							current,
                    							"exp",
                    							lv_exp_8_0,
                    							"com.arsene.query.QueryDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getTransformableAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformable"


    // $ANTLR start "entryRuleTransParam"
    // InternalQueryDsl.g:1743:1: entryRuleTransParam returns [EObject current=null] : iv_ruleTransParam= ruleTransParam EOF ;
    public final EObject entryRuleTransParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransParam = null;


        try {
            // InternalQueryDsl.g:1743:51: (iv_ruleTransParam= ruleTransParam EOF )
            // InternalQueryDsl.g:1744:2: iv_ruleTransParam= ruleTransParam EOF
            {
             newCompositeNode(grammarAccess.getTransParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransParam=ruleTransParam();

            state._fsp--;

             current =iv_ruleTransParam; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTransParam"


    // $ANTLR start "ruleTransParam"
    // InternalQueryDsl.g:1750:1: ruleTransParam returns [EObject current=null] : ( ( (lv_type_0_1= 'id' | lv_type_0_2= 'name' ) ) ) ;
    public final EObject ruleTransParam() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:1756:2: ( ( ( (lv_type_0_1= 'id' | lv_type_0_2= 'name' ) ) ) )
            // InternalQueryDsl.g:1757:2: ( ( (lv_type_0_1= 'id' | lv_type_0_2= 'name' ) ) )
            {
            // InternalQueryDsl.g:1757:2: ( ( (lv_type_0_1= 'id' | lv_type_0_2= 'name' ) ) )
            // InternalQueryDsl.g:1758:3: ( (lv_type_0_1= 'id' | lv_type_0_2= 'name' ) )
            {
            // InternalQueryDsl.g:1758:3: ( (lv_type_0_1= 'id' | lv_type_0_2= 'name' ) )
            // InternalQueryDsl.g:1759:4: (lv_type_0_1= 'id' | lv_type_0_2= 'name' )
            {
            // InternalQueryDsl.g:1759:4: (lv_type_0_1= 'id' | lv_type_0_2= 'name' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==36) ) {
                alt26=1;
            }
            else if ( (LA26_0==37) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalQueryDsl.g:1760:5: lv_type_0_1= 'id'
                    {
                    lv_type_0_1=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_type_0_1, grammarAccess.getTransParamAccess().getTypeIdKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTransParamRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1771:5: lv_type_0_2= 'name'
                    {
                    lv_type_0_2=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_type_0_2, grammarAccess.getTransParamAccess().getTypeNameKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTransParamRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_2, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransParam"


    // $ANTLR start "entryRuleQExp"
    // InternalQueryDsl.g:1787:1: entryRuleQExp returns [EObject current=null] : iv_ruleQExp= ruleQExp EOF ;
    public final EObject entryRuleQExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQExp = null;


        try {
            // InternalQueryDsl.g:1787:45: (iv_ruleQExp= ruleQExp EOF )
            // InternalQueryDsl.g:1788:2: iv_ruleQExp= ruleQExp EOF
            {
             newCompositeNode(grammarAccess.getQExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQExp=ruleQExp();

            state._fsp--;

             current =iv_ruleQExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQExp"


    // $ANTLR start "ruleQExp"
    // InternalQueryDsl.g:1794:1: ruleQExp returns [EObject current=null] : ( ( (lv_qAttr_0_0= ruleQattribute ) ) ( (lv_comp_1_0= ruleComparison ) ) ( (lv_n_2_0= RULE_INT ) ) ) ;
    public final EObject ruleQExp() throws RecognitionException {
        EObject current = null;

        Token lv_n_2_0=null;
        EObject lv_qAttr_0_0 = null;

        EObject lv_comp_1_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:1800:2: ( ( ( (lv_qAttr_0_0= ruleQattribute ) ) ( (lv_comp_1_0= ruleComparison ) ) ( (lv_n_2_0= RULE_INT ) ) ) )
            // InternalQueryDsl.g:1801:2: ( ( (lv_qAttr_0_0= ruleQattribute ) ) ( (lv_comp_1_0= ruleComparison ) ) ( (lv_n_2_0= RULE_INT ) ) )
            {
            // InternalQueryDsl.g:1801:2: ( ( (lv_qAttr_0_0= ruleQattribute ) ) ( (lv_comp_1_0= ruleComparison ) ) ( (lv_n_2_0= RULE_INT ) ) )
            // InternalQueryDsl.g:1802:3: ( (lv_qAttr_0_0= ruleQattribute ) ) ( (lv_comp_1_0= ruleComparison ) ) ( (lv_n_2_0= RULE_INT ) )
            {
            // InternalQueryDsl.g:1802:3: ( (lv_qAttr_0_0= ruleQattribute ) )
            // InternalQueryDsl.g:1803:4: (lv_qAttr_0_0= ruleQattribute )
            {
            // InternalQueryDsl.g:1803:4: (lv_qAttr_0_0= ruleQattribute )
            // InternalQueryDsl.g:1804:5: lv_qAttr_0_0= ruleQattribute
            {

            					newCompositeNode(grammarAccess.getQExpAccess().getQAttrQattributeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_42);
            lv_qAttr_0_0=ruleQattribute();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQExpRule());
            					}
            					set(
            						current,
            						"qAttr",
            						lv_qAttr_0_0,
            						"com.arsene.query.QueryDsl.Qattribute");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:1821:3: ( (lv_comp_1_0= ruleComparison ) )
            // InternalQueryDsl.g:1822:4: (lv_comp_1_0= ruleComparison )
            {
            // InternalQueryDsl.g:1822:4: (lv_comp_1_0= ruleComparison )
            // InternalQueryDsl.g:1823:5: lv_comp_1_0= ruleComparison
            {

            					newCompositeNode(grammarAccess.getQExpAccess().getCompComparisonParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_36);
            lv_comp_1_0=ruleComparison();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQExpRule());
            					}
            					set(
            						current,
            						"comp",
            						lv_comp_1_0,
            						"com.arsene.query.QueryDsl.Comparison");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQueryDsl.g:1840:3: ( (lv_n_2_0= RULE_INT ) )
            // InternalQueryDsl.g:1841:4: (lv_n_2_0= RULE_INT )
            {
            // InternalQueryDsl.g:1841:4: (lv_n_2_0= RULE_INT )
            // InternalQueryDsl.g:1842:5: lv_n_2_0= RULE_INT
            {
            lv_n_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_n_2_0, grammarAccess.getQExpAccess().getNINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQExpRule());
            					}
            					setWithLastConsumed(
            						current,
            						"n",
            						lv_n_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQExp"


    // $ANTLR start "entryRuleQattribute"
    // InternalQueryDsl.g:1862:1: entryRuleQattribute returns [EObject current=null] : iv_ruleQattribute= ruleQattribute EOF ;
    public final EObject entryRuleQattribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQattribute = null;


        try {
            // InternalQueryDsl.g:1862:51: (iv_ruleQattribute= ruleQattribute EOF )
            // InternalQueryDsl.g:1863:2: iv_ruleQattribute= ruleQattribute EOF
            {
             newCompositeNode(grammarAccess.getQattributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQattribute=ruleQattribute();

            state._fsp--;

             current =iv_ruleQattribute; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQattribute"


    // $ANTLR start "ruleQattribute"
    // InternalQueryDsl.g:1869:1: ruleQattribute returns [EObject current=null] : ( ( (lv_type_0_1= 'qa' | lv_type_0_2= 'qb' | lv_type_0_3= 'qc' | lv_type_0_4= 'qd' | lv_type_0_5= 'qe' | lv_type_0_6= 'qf' | lv_type_0_7= 'qg' | lv_type_0_8= 'qh' | lv_type_0_9= 'qi' | lv_type_0_10= 'qj' | lv_type_0_11= 'qk' | lv_type_0_12= 'ql' | lv_type_0_13= 'qm' | lv_type_0_14= 'qn' | lv_type_0_15= 'qo' | lv_type_0_16= 'qp' | lv_type_0_17= 'qq' | lv_type_0_18= 'qr' | lv_type_0_19= 'qs' | lv_type_0_20= 'qt' | lv_type_0_21= 'qu' | lv_type_0_22= 'qv' ) ) ) ;
    public final EObject ruleQattribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token lv_type_0_3=null;
        Token lv_type_0_4=null;
        Token lv_type_0_5=null;
        Token lv_type_0_6=null;
        Token lv_type_0_7=null;
        Token lv_type_0_8=null;
        Token lv_type_0_9=null;
        Token lv_type_0_10=null;
        Token lv_type_0_11=null;
        Token lv_type_0_12=null;
        Token lv_type_0_13=null;
        Token lv_type_0_14=null;
        Token lv_type_0_15=null;
        Token lv_type_0_16=null;
        Token lv_type_0_17=null;
        Token lv_type_0_18=null;
        Token lv_type_0_19=null;
        Token lv_type_0_20=null;
        Token lv_type_0_21=null;
        Token lv_type_0_22=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:1875:2: ( ( ( (lv_type_0_1= 'qa' | lv_type_0_2= 'qb' | lv_type_0_3= 'qc' | lv_type_0_4= 'qd' | lv_type_0_5= 'qe' | lv_type_0_6= 'qf' | lv_type_0_7= 'qg' | lv_type_0_8= 'qh' | lv_type_0_9= 'qi' | lv_type_0_10= 'qj' | lv_type_0_11= 'qk' | lv_type_0_12= 'ql' | lv_type_0_13= 'qm' | lv_type_0_14= 'qn' | lv_type_0_15= 'qo' | lv_type_0_16= 'qp' | lv_type_0_17= 'qq' | lv_type_0_18= 'qr' | lv_type_0_19= 'qs' | lv_type_0_20= 'qt' | lv_type_0_21= 'qu' | lv_type_0_22= 'qv' ) ) ) )
            // InternalQueryDsl.g:1876:2: ( ( (lv_type_0_1= 'qa' | lv_type_0_2= 'qb' | lv_type_0_3= 'qc' | lv_type_0_4= 'qd' | lv_type_0_5= 'qe' | lv_type_0_6= 'qf' | lv_type_0_7= 'qg' | lv_type_0_8= 'qh' | lv_type_0_9= 'qi' | lv_type_0_10= 'qj' | lv_type_0_11= 'qk' | lv_type_0_12= 'ql' | lv_type_0_13= 'qm' | lv_type_0_14= 'qn' | lv_type_0_15= 'qo' | lv_type_0_16= 'qp' | lv_type_0_17= 'qq' | lv_type_0_18= 'qr' | lv_type_0_19= 'qs' | lv_type_0_20= 'qt' | lv_type_0_21= 'qu' | lv_type_0_22= 'qv' ) ) )
            {
            // InternalQueryDsl.g:1876:2: ( ( (lv_type_0_1= 'qa' | lv_type_0_2= 'qb' | lv_type_0_3= 'qc' | lv_type_0_4= 'qd' | lv_type_0_5= 'qe' | lv_type_0_6= 'qf' | lv_type_0_7= 'qg' | lv_type_0_8= 'qh' | lv_type_0_9= 'qi' | lv_type_0_10= 'qj' | lv_type_0_11= 'qk' | lv_type_0_12= 'ql' | lv_type_0_13= 'qm' | lv_type_0_14= 'qn' | lv_type_0_15= 'qo' | lv_type_0_16= 'qp' | lv_type_0_17= 'qq' | lv_type_0_18= 'qr' | lv_type_0_19= 'qs' | lv_type_0_20= 'qt' | lv_type_0_21= 'qu' | lv_type_0_22= 'qv' ) ) )
            // InternalQueryDsl.g:1877:3: ( (lv_type_0_1= 'qa' | lv_type_0_2= 'qb' | lv_type_0_3= 'qc' | lv_type_0_4= 'qd' | lv_type_0_5= 'qe' | lv_type_0_6= 'qf' | lv_type_0_7= 'qg' | lv_type_0_8= 'qh' | lv_type_0_9= 'qi' | lv_type_0_10= 'qj' | lv_type_0_11= 'qk' | lv_type_0_12= 'ql' | lv_type_0_13= 'qm' | lv_type_0_14= 'qn' | lv_type_0_15= 'qo' | lv_type_0_16= 'qp' | lv_type_0_17= 'qq' | lv_type_0_18= 'qr' | lv_type_0_19= 'qs' | lv_type_0_20= 'qt' | lv_type_0_21= 'qu' | lv_type_0_22= 'qv' ) )
            {
            // InternalQueryDsl.g:1877:3: ( (lv_type_0_1= 'qa' | lv_type_0_2= 'qb' | lv_type_0_3= 'qc' | lv_type_0_4= 'qd' | lv_type_0_5= 'qe' | lv_type_0_6= 'qf' | lv_type_0_7= 'qg' | lv_type_0_8= 'qh' | lv_type_0_9= 'qi' | lv_type_0_10= 'qj' | lv_type_0_11= 'qk' | lv_type_0_12= 'ql' | lv_type_0_13= 'qm' | lv_type_0_14= 'qn' | lv_type_0_15= 'qo' | lv_type_0_16= 'qp' | lv_type_0_17= 'qq' | lv_type_0_18= 'qr' | lv_type_0_19= 'qs' | lv_type_0_20= 'qt' | lv_type_0_21= 'qu' | lv_type_0_22= 'qv' ) )
            // InternalQueryDsl.g:1878:4: (lv_type_0_1= 'qa' | lv_type_0_2= 'qb' | lv_type_0_3= 'qc' | lv_type_0_4= 'qd' | lv_type_0_5= 'qe' | lv_type_0_6= 'qf' | lv_type_0_7= 'qg' | lv_type_0_8= 'qh' | lv_type_0_9= 'qi' | lv_type_0_10= 'qj' | lv_type_0_11= 'qk' | lv_type_0_12= 'ql' | lv_type_0_13= 'qm' | lv_type_0_14= 'qn' | lv_type_0_15= 'qo' | lv_type_0_16= 'qp' | lv_type_0_17= 'qq' | lv_type_0_18= 'qr' | lv_type_0_19= 'qs' | lv_type_0_20= 'qt' | lv_type_0_21= 'qu' | lv_type_0_22= 'qv' )
            {
            // InternalQueryDsl.g:1878:4: (lv_type_0_1= 'qa' | lv_type_0_2= 'qb' | lv_type_0_3= 'qc' | lv_type_0_4= 'qd' | lv_type_0_5= 'qe' | lv_type_0_6= 'qf' | lv_type_0_7= 'qg' | lv_type_0_8= 'qh' | lv_type_0_9= 'qi' | lv_type_0_10= 'qj' | lv_type_0_11= 'qk' | lv_type_0_12= 'ql' | lv_type_0_13= 'qm' | lv_type_0_14= 'qn' | lv_type_0_15= 'qo' | lv_type_0_16= 'qp' | lv_type_0_17= 'qq' | lv_type_0_18= 'qr' | lv_type_0_19= 'qs' | lv_type_0_20= 'qt' | lv_type_0_21= 'qu' | lv_type_0_22= 'qv' )
            int alt27=22;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt27=1;
                }
                break;
            case 39:
                {
                alt27=2;
                }
                break;
            case 40:
                {
                alt27=3;
                }
                break;
            case 41:
                {
                alt27=4;
                }
                break;
            case 42:
                {
                alt27=5;
                }
                break;
            case 43:
                {
                alt27=6;
                }
                break;
            case 44:
                {
                alt27=7;
                }
                break;
            case 45:
                {
                alt27=8;
                }
                break;
            case 46:
                {
                alt27=9;
                }
                break;
            case 47:
                {
                alt27=10;
                }
                break;
            case 48:
                {
                alt27=11;
                }
                break;
            case 49:
                {
                alt27=12;
                }
                break;
            case 50:
                {
                alt27=13;
                }
                break;
            case 51:
                {
                alt27=14;
                }
                break;
            case 52:
                {
                alt27=15;
                }
                break;
            case 53:
                {
                alt27=16;
                }
                break;
            case 54:
                {
                alt27=17;
                }
                break;
            case 55:
                {
                alt27=18;
                }
                break;
            case 56:
                {
                alt27=19;
                }
                break;
            case 57:
                {
                alt27=20;
                }
                break;
            case 58:
                {
                alt27=21;
                }
                break;
            case 59:
                {
                alt27=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalQueryDsl.g:1879:5: lv_type_0_1= 'qa'
                    {
                    lv_type_0_1=(Token)match(input,38,FOLLOW_2); 

                    					newLeafNode(lv_type_0_1, grammarAccess.getQattributeAccess().getTypeQaKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1890:5: lv_type_0_2= 'qb'
                    {
                    lv_type_0_2=(Token)match(input,39,FOLLOW_2); 

                    					newLeafNode(lv_type_0_2, grammarAccess.getQattributeAccess().getTypeQbKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1901:5: lv_type_0_3= 'qc'
                    {
                    lv_type_0_3=(Token)match(input,40,FOLLOW_2); 

                    					newLeafNode(lv_type_0_3, grammarAccess.getQattributeAccess().getTypeQcKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1912:5: lv_type_0_4= 'qd'
                    {
                    lv_type_0_4=(Token)match(input,41,FOLLOW_2); 

                    					newLeafNode(lv_type_0_4, grammarAccess.getQattributeAccess().getTypeQdKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1923:5: lv_type_0_5= 'qe'
                    {
                    lv_type_0_5=(Token)match(input,42,FOLLOW_2); 

                    					newLeafNode(lv_type_0_5, grammarAccess.getQattributeAccess().getTypeQeKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:1934:5: lv_type_0_6= 'qf'
                    {
                    lv_type_0_6=(Token)match(input,43,FOLLOW_2); 

                    					newLeafNode(lv_type_0_6, grammarAccess.getQattributeAccess().getTypeQfKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_6, null);
                    				

                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:1945:5: lv_type_0_7= 'qg'
                    {
                    lv_type_0_7=(Token)match(input,44,FOLLOW_2); 

                    					newLeafNode(lv_type_0_7, grammarAccess.getQattributeAccess().getTypeQgKeyword_0_6());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_7, null);
                    				

                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:1956:5: lv_type_0_8= 'qh'
                    {
                    lv_type_0_8=(Token)match(input,45,FOLLOW_2); 

                    					newLeafNode(lv_type_0_8, grammarAccess.getQattributeAccess().getTypeQhKeyword_0_7());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_8, null);
                    				

                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:1967:5: lv_type_0_9= 'qi'
                    {
                    lv_type_0_9=(Token)match(input,46,FOLLOW_2); 

                    					newLeafNode(lv_type_0_9, grammarAccess.getQattributeAccess().getTypeQiKeyword_0_8());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_9, null);
                    				

                    }
                    break;
                case 10 :
                    // InternalQueryDsl.g:1978:5: lv_type_0_10= 'qj'
                    {
                    lv_type_0_10=(Token)match(input,47,FOLLOW_2); 

                    					newLeafNode(lv_type_0_10, grammarAccess.getQattributeAccess().getTypeQjKeyword_0_9());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_10, null);
                    				

                    }
                    break;
                case 11 :
                    // InternalQueryDsl.g:1989:5: lv_type_0_11= 'qk'
                    {
                    lv_type_0_11=(Token)match(input,48,FOLLOW_2); 

                    					newLeafNode(lv_type_0_11, grammarAccess.getQattributeAccess().getTypeQkKeyword_0_10());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_11, null);
                    				

                    }
                    break;
                case 12 :
                    // InternalQueryDsl.g:2000:5: lv_type_0_12= 'ql'
                    {
                    lv_type_0_12=(Token)match(input,49,FOLLOW_2); 

                    					newLeafNode(lv_type_0_12, grammarAccess.getQattributeAccess().getTypeQlKeyword_0_11());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_12, null);
                    				

                    }
                    break;
                case 13 :
                    // InternalQueryDsl.g:2011:5: lv_type_0_13= 'qm'
                    {
                    lv_type_0_13=(Token)match(input,50,FOLLOW_2); 

                    					newLeafNode(lv_type_0_13, grammarAccess.getQattributeAccess().getTypeQmKeyword_0_12());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_13, null);
                    				

                    }
                    break;
                case 14 :
                    // InternalQueryDsl.g:2022:5: lv_type_0_14= 'qn'
                    {
                    lv_type_0_14=(Token)match(input,51,FOLLOW_2); 

                    					newLeafNode(lv_type_0_14, grammarAccess.getQattributeAccess().getTypeQnKeyword_0_13());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_14, null);
                    				

                    }
                    break;
                case 15 :
                    // InternalQueryDsl.g:2033:5: lv_type_0_15= 'qo'
                    {
                    lv_type_0_15=(Token)match(input,52,FOLLOW_2); 

                    					newLeafNode(lv_type_0_15, grammarAccess.getQattributeAccess().getTypeQoKeyword_0_14());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_15, null);
                    				

                    }
                    break;
                case 16 :
                    // InternalQueryDsl.g:2044:5: lv_type_0_16= 'qp'
                    {
                    lv_type_0_16=(Token)match(input,53,FOLLOW_2); 

                    					newLeafNode(lv_type_0_16, grammarAccess.getQattributeAccess().getTypeQpKeyword_0_15());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_16, null);
                    				

                    }
                    break;
                case 17 :
                    // InternalQueryDsl.g:2055:5: lv_type_0_17= 'qq'
                    {
                    lv_type_0_17=(Token)match(input,54,FOLLOW_2); 

                    					newLeafNode(lv_type_0_17, grammarAccess.getQattributeAccess().getTypeQqKeyword_0_16());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_17, null);
                    				

                    }
                    break;
                case 18 :
                    // InternalQueryDsl.g:2066:5: lv_type_0_18= 'qr'
                    {
                    lv_type_0_18=(Token)match(input,55,FOLLOW_2); 

                    					newLeafNode(lv_type_0_18, grammarAccess.getQattributeAccess().getTypeQrKeyword_0_17());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_18, null);
                    				

                    }
                    break;
                case 19 :
                    // InternalQueryDsl.g:2077:5: lv_type_0_19= 'qs'
                    {
                    lv_type_0_19=(Token)match(input,56,FOLLOW_2); 

                    					newLeafNode(lv_type_0_19, grammarAccess.getQattributeAccess().getTypeQsKeyword_0_18());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_19, null);
                    				

                    }
                    break;
                case 20 :
                    // InternalQueryDsl.g:2088:5: lv_type_0_20= 'qt'
                    {
                    lv_type_0_20=(Token)match(input,57,FOLLOW_2); 

                    					newLeafNode(lv_type_0_20, grammarAccess.getQattributeAccess().getTypeQtKeyword_0_19());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_20, null);
                    				

                    }
                    break;
                case 21 :
                    // InternalQueryDsl.g:2099:5: lv_type_0_21= 'qu'
                    {
                    lv_type_0_21=(Token)match(input,58,FOLLOW_2); 

                    					newLeafNode(lv_type_0_21, grammarAccess.getQattributeAccess().getTypeQuKeyword_0_20());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_21, null);
                    				

                    }
                    break;
                case 22 :
                    // InternalQueryDsl.g:2110:5: lv_type_0_22= 'qv'
                    {
                    lv_type_0_22=(Token)match(input,59,FOLLOW_2); 

                    					newLeafNode(lv_type_0_22, grammarAccess.getQattributeAccess().getTypeQvKeyword_0_21());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQattributeRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_22, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQattribute"


    // $ANTLR start "entryRuleOperator"
    // InternalQueryDsl.g:2126:1: entryRuleOperator returns [EObject current=null] : iv_ruleOperator= ruleOperator EOF ;
    public final EObject entryRuleOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperator = null;


        try {
            // InternalQueryDsl.g:2126:49: (iv_ruleOperator= ruleOperator EOF )
            // InternalQueryDsl.g:2127:2: iv_ruleOperator= ruleOperator EOF
            {
             newCompositeNode(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperator=ruleOperator();

            state._fsp--;

             current =iv_ruleOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalQueryDsl.g:2133:1: ruleOperator returns [EObject current=null] : ( ( (lv_op_0_1= 'AND' | lv_op_0_2= 'OR' | lv_op_0_3= 'EXACT' ) ) ) ;
    public final EObject ruleOperator() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:2139:2: ( ( ( (lv_op_0_1= 'AND' | lv_op_0_2= 'OR' | lv_op_0_3= 'EXACT' ) ) ) )
            // InternalQueryDsl.g:2140:2: ( ( (lv_op_0_1= 'AND' | lv_op_0_2= 'OR' | lv_op_0_3= 'EXACT' ) ) )
            {
            // InternalQueryDsl.g:2140:2: ( ( (lv_op_0_1= 'AND' | lv_op_0_2= 'OR' | lv_op_0_3= 'EXACT' ) ) )
            // InternalQueryDsl.g:2141:3: ( (lv_op_0_1= 'AND' | lv_op_0_2= 'OR' | lv_op_0_3= 'EXACT' ) )
            {
            // InternalQueryDsl.g:2141:3: ( (lv_op_0_1= 'AND' | lv_op_0_2= 'OR' | lv_op_0_3= 'EXACT' ) )
            // InternalQueryDsl.g:2142:4: (lv_op_0_1= 'AND' | lv_op_0_2= 'OR' | lv_op_0_3= 'EXACT' )
            {
            // InternalQueryDsl.g:2142:4: (lv_op_0_1= 'AND' | lv_op_0_2= 'OR' | lv_op_0_3= 'EXACT' )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt28=1;
                }
                break;
            case 61:
                {
                alt28=2;
                }
                break;
            case 62:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalQueryDsl.g:2143:5: lv_op_0_1= 'AND'
                    {
                    lv_op_0_1=(Token)match(input,60,FOLLOW_2); 

                    					newLeafNode(lv_op_0_1, grammarAccess.getOperatorAccess().getOpANDKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2154:5: lv_op_0_2= 'OR'
                    {
                    lv_op_0_2=(Token)match(input,61,FOLLOW_2); 

                    					newLeafNode(lv_op_0_2, grammarAccess.getOperatorAccess().getOpORKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2165:5: lv_op_0_3= 'EXACT'
                    {
                    lv_op_0_3=(Token)match(input,62,FOLLOW_2); 

                    					newLeafNode(lv_op_0_3, grammarAccess.getOperatorAccess().getOpEXACTKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_3, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleFilter"
    // InternalQueryDsl.g:2181:1: entryRuleFilter returns [EObject current=null] : iv_ruleFilter= ruleFilter EOF ;
    public final EObject entryRuleFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilter = null;


        try {
            // InternalQueryDsl.g:2181:47: (iv_ruleFilter= ruleFilter EOF )
            // InternalQueryDsl.g:2182:2: iv_ruleFilter= ruleFilter EOF
            {
             newCompositeNode(grammarAccess.getFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilter=ruleFilter();

            state._fsp--;

             current =iv_ruleFilter; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFilter"


    // $ANTLR start "ruleFilter"
    // InternalQueryDsl.g:2188:1: ruleFilter returns [EObject current=null] : (otherlv_0= 'filter' otherlv_1= '(' ( (lv_filterExp_2_0= ruleFilterExp ) )? (otherlv_3= ',' ( (lv_filterExps_4_0= ruleFilterExp ) ) )? (otherlv_5= ',' otherlv_6= 'size' otherlv_7= ':' ( (lv_comp_8_0= ruleComparison ) ) ( (lv_exp_9_0= ruleExpression ) ) ) otherlv_10= ')' ) ;
    public final EObject ruleFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_filterExp_2_0 = null;

        EObject lv_filterExps_4_0 = null;

        EObject lv_comp_8_0 = null;

        EObject lv_exp_9_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:2194:2: ( (otherlv_0= 'filter' otherlv_1= '(' ( (lv_filterExp_2_0= ruleFilterExp ) )? (otherlv_3= ',' ( (lv_filterExps_4_0= ruleFilterExp ) ) )? (otherlv_5= ',' otherlv_6= 'size' otherlv_7= ':' ( (lv_comp_8_0= ruleComparison ) ) ( (lv_exp_9_0= ruleExpression ) ) ) otherlv_10= ')' ) )
            // InternalQueryDsl.g:2195:2: (otherlv_0= 'filter' otherlv_1= '(' ( (lv_filterExp_2_0= ruleFilterExp ) )? (otherlv_3= ',' ( (lv_filterExps_4_0= ruleFilterExp ) ) )? (otherlv_5= ',' otherlv_6= 'size' otherlv_7= ':' ( (lv_comp_8_0= ruleComparison ) ) ( (lv_exp_9_0= ruleExpression ) ) ) otherlv_10= ')' )
            {
            // InternalQueryDsl.g:2195:2: (otherlv_0= 'filter' otherlv_1= '(' ( (lv_filterExp_2_0= ruleFilterExp ) )? (otherlv_3= ',' ( (lv_filterExps_4_0= ruleFilterExp ) ) )? (otherlv_5= ',' otherlv_6= 'size' otherlv_7= ':' ( (lv_comp_8_0= ruleComparison ) ) ( (lv_exp_9_0= ruleExpression ) ) ) otherlv_10= ')' )
            // InternalQueryDsl.g:2196:3: otherlv_0= 'filter' otherlv_1= '(' ( (lv_filterExp_2_0= ruleFilterExp ) )? (otherlv_3= ',' ( (lv_filterExps_4_0= ruleFilterExp ) ) )? (otherlv_5= ',' otherlv_6= 'size' otherlv_7= ':' ( (lv_comp_8_0= ruleComparison ) ) ( (lv_exp_9_0= ruleExpression ) ) ) otherlv_10= ')'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFilterAccess().getFilterKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getFilterAccess().getLeftParenthesisKeyword_1());
            		
            // InternalQueryDsl.g:2204:3: ( (lv_filterExp_2_0= ruleFilterExp ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=70 && LA29_0<=73)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalQueryDsl.g:2205:4: (lv_filterExp_2_0= ruleFilterExp )
                    {
                    // InternalQueryDsl.g:2205:4: (lv_filterExp_2_0= ruleFilterExp )
                    // InternalQueryDsl.g:2206:5: lv_filterExp_2_0= ruleFilterExp
                    {

                    					newCompositeNode(grammarAccess.getFilterAccess().getFilterExpFilterExpParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_34);
                    lv_filterExp_2_0=ruleFilterExp();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFilterRule());
                    					}
                    					set(
                    						current,
                    						"filterExp",
                    						lv_filterExp_2_0,
                    						"com.arsene.query.QueryDsl.FilterExp");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalQueryDsl.g:2223:3: (otherlv_3= ',' ( (lv_filterExps_4_0= ruleFilterExp ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==14) ) {
                int LA30_1 = input.LA(2);

                if ( ((LA30_1>=70 && LA30_1<=73)) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // InternalQueryDsl.g:2224:4: otherlv_3= ',' ( (lv_filterExps_4_0= ruleFilterExp ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_44); 

                    				newLeafNode(otherlv_3, grammarAccess.getFilterAccess().getCommaKeyword_3_0());
                    			
                    // InternalQueryDsl.g:2228:4: ( (lv_filterExps_4_0= ruleFilterExp ) )
                    // InternalQueryDsl.g:2229:5: (lv_filterExps_4_0= ruleFilterExp )
                    {
                    // InternalQueryDsl.g:2229:5: (lv_filterExps_4_0= ruleFilterExp )
                    // InternalQueryDsl.g:2230:6: lv_filterExps_4_0= ruleFilterExp
                    {

                    						newCompositeNode(grammarAccess.getFilterAccess().getFilterExpsFilterExpParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_filterExps_4_0=ruleFilterExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterRule());
                    						}
                    						set(
                    							current,
                    							"filterExps",
                    							lv_filterExps_4_0,
                    							"com.arsene.query.QueryDsl.FilterExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalQueryDsl.g:2248:3: (otherlv_5= ',' otherlv_6= 'size' otherlv_7= ':' ( (lv_comp_8_0= ruleComparison ) ) ( (lv_exp_9_0= ruleExpression ) ) )
            // InternalQueryDsl.g:2249:4: otherlv_5= ',' otherlv_6= 'size' otherlv_7= ':' ( (lv_comp_8_0= ruleComparison ) ) ( (lv_exp_9_0= ruleExpression ) )
            {
            otherlv_5=(Token)match(input,14,FOLLOW_45); 

            				newLeafNode(otherlv_5, grammarAccess.getFilterAccess().getCommaKeyword_4_0());
            			
            otherlv_6=(Token)match(input,64,FOLLOW_32); 

            				newLeafNode(otherlv_6, grammarAccess.getFilterAccess().getSizeKeyword_4_1());
            			
            otherlv_7=(Token)match(input,28,FOLLOW_42); 

            				newLeafNode(otherlv_7, grammarAccess.getFilterAccess().getColonKeyword_4_2());
            			
            // InternalQueryDsl.g:2261:4: ( (lv_comp_8_0= ruleComparison ) )
            // InternalQueryDsl.g:2262:5: (lv_comp_8_0= ruleComparison )
            {
            // InternalQueryDsl.g:2262:5: (lv_comp_8_0= ruleComparison )
            // InternalQueryDsl.g:2263:6: lv_comp_8_0= ruleComparison
            {

            						newCompositeNode(grammarAccess.getFilterAccess().getCompComparisonParserRuleCall_4_3_0());
            					
            pushFollow(FOLLOW_29);
            lv_comp_8_0=ruleComparison();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getFilterRule());
            						}
            						set(
            							current,
            							"comp",
            							lv_comp_8_0,
            							"com.arsene.query.QueryDsl.Comparison");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalQueryDsl.g:2280:4: ( (lv_exp_9_0= ruleExpression ) )
            // InternalQueryDsl.g:2281:5: (lv_exp_9_0= ruleExpression )
            {
            // InternalQueryDsl.g:2281:5: (lv_exp_9_0= ruleExpression )
            // InternalQueryDsl.g:2282:6: lv_exp_9_0= ruleExpression
            {

            						newCompositeNode(grammarAccess.getFilterAccess().getExpExpressionParserRuleCall_4_4_0());
            					
            pushFollow(FOLLOW_30);
            lv_exp_9_0=ruleExpression();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getFilterRule());
            						}
            						set(
            							current,
            							"exp",
            							lv_exp_9_0,
            							"com.arsene.query.QueryDsl.Expression");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            otherlv_10=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getFilterAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilter"


    // $ANTLR start "entryRuleFilterExp"
    // InternalQueryDsl.g:2308:1: entryRuleFilterExp returns [EObject current=null] : iv_ruleFilterExp= ruleFilterExp EOF ;
    public final EObject entryRuleFilterExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilterExp = null;


        try {
            // InternalQueryDsl.g:2308:50: (iv_ruleFilterExp= ruleFilterExp EOF )
            // InternalQueryDsl.g:2309:2: iv_ruleFilterExp= ruleFilterExp EOF
            {
             newCompositeNode(grammarAccess.getFilterExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilterExp=ruleFilterExp();

            state._fsp--;

             current =iv_ruleFilterExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFilterExp"


    // $ANTLR start "ruleFilterExp"
    // InternalQueryDsl.g:2315:1: ruleFilterExp returns [EObject current=null] : ( ( (lv_filterkey_0_0= ruleFilterKeyword ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleFilterExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_filterkey_0_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:2321:2: ( ( ( (lv_filterkey_0_0= ruleFilterKeyword ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:2322:2: ( ( (lv_filterkey_0_0= ruleFilterKeyword ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:2322:2: ( ( (lv_filterkey_0_0= ruleFilterKeyword ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            // InternalQueryDsl.g:2323:3: ( (lv_filterkey_0_0= ruleFilterKeyword ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) )
            {
            // InternalQueryDsl.g:2323:3: ( (lv_filterkey_0_0= ruleFilterKeyword ) )
            // InternalQueryDsl.g:2324:4: (lv_filterkey_0_0= ruleFilterKeyword )
            {
            // InternalQueryDsl.g:2324:4: (lv_filterkey_0_0= ruleFilterKeyword )
            // InternalQueryDsl.g:2325:5: lv_filterkey_0_0= ruleFilterKeyword
            {

            					newCompositeNode(grammarAccess.getFilterExpAccess().getFilterkeyFilterKeywordParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_32);
            lv_filterkey_0_0=ruleFilterKeyword();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterExpRule());
            					}
            					set(
            						current,
            						"filterkey",
            						lv_filterkey_0_0,
            						"com.arsene.query.QueryDsl.FilterKeyword");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getFilterExpAccess().getColonKeyword_1());
            		
            // InternalQueryDsl.g:2346:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:2347:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:2347:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:2348:5: lv_exp_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getFilterExpAccess().getExpExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterExpRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilterExp"


    // $ANTLR start "entryRuleComparison"
    // InternalQueryDsl.g:2369:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalQueryDsl.g:2369:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalQueryDsl.g:2370:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalQueryDsl.g:2376:1: ruleComparison returns [EObject current=null] : ( ( (lv_type_0_1= '==' | lv_type_0_2= '>=' | lv_type_0_3= '<=' | lv_type_0_4= '<' | lv_type_0_5= '>' ) ) ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token lv_type_0_3=null;
        Token lv_type_0_4=null;
        Token lv_type_0_5=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:2382:2: ( ( ( (lv_type_0_1= '==' | lv_type_0_2= '>=' | lv_type_0_3= '<=' | lv_type_0_4= '<' | lv_type_0_5= '>' ) ) ) )
            // InternalQueryDsl.g:2383:2: ( ( (lv_type_0_1= '==' | lv_type_0_2= '>=' | lv_type_0_3= '<=' | lv_type_0_4= '<' | lv_type_0_5= '>' ) ) )
            {
            // InternalQueryDsl.g:2383:2: ( ( (lv_type_0_1= '==' | lv_type_0_2= '>=' | lv_type_0_3= '<=' | lv_type_0_4= '<' | lv_type_0_5= '>' ) ) )
            // InternalQueryDsl.g:2384:3: ( (lv_type_0_1= '==' | lv_type_0_2= '>=' | lv_type_0_3= '<=' | lv_type_0_4= '<' | lv_type_0_5= '>' ) )
            {
            // InternalQueryDsl.g:2384:3: ( (lv_type_0_1= '==' | lv_type_0_2= '>=' | lv_type_0_3= '<=' | lv_type_0_4= '<' | lv_type_0_5= '>' ) )
            // InternalQueryDsl.g:2385:4: (lv_type_0_1= '==' | lv_type_0_2= '>=' | lv_type_0_3= '<=' | lv_type_0_4= '<' | lv_type_0_5= '>' )
            {
            // InternalQueryDsl.g:2385:4: (lv_type_0_1= '==' | lv_type_0_2= '>=' | lv_type_0_3= '<=' | lv_type_0_4= '<' | lv_type_0_5= '>' )
            int alt31=5;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt31=1;
                }
                break;
            case 66:
                {
                alt31=2;
                }
                break;
            case 67:
                {
                alt31=3;
                }
                break;
            case 68:
                {
                alt31=4;
                }
                break;
            case 69:
                {
                alt31=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalQueryDsl.g:2386:5: lv_type_0_1= '=='
                    {
                    lv_type_0_1=(Token)match(input,65,FOLLOW_2); 

                    					newLeafNode(lv_type_0_1, grammarAccess.getComparisonAccess().getTypeEqualsSignEqualsSignKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getComparisonRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2397:5: lv_type_0_2= '>='
                    {
                    lv_type_0_2=(Token)match(input,66,FOLLOW_2); 

                    					newLeafNode(lv_type_0_2, grammarAccess.getComparisonAccess().getTypeGreaterThanSignEqualsSignKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getComparisonRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2408:5: lv_type_0_3= '<='
                    {
                    lv_type_0_3=(Token)match(input,67,FOLLOW_2); 

                    					newLeafNode(lv_type_0_3, grammarAccess.getComparisonAccess().getTypeLessThanSignEqualsSignKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getComparisonRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:2419:5: lv_type_0_4= '<'
                    {
                    lv_type_0_4=(Token)match(input,68,FOLLOW_2); 

                    					newLeafNode(lv_type_0_4, grammarAccess.getComparisonAccess().getTypeLessThanSignKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getComparisonRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:2430:5: lv_type_0_5= '>'
                    {
                    lv_type_0_5=(Token)match(input,69,FOLLOW_2); 

                    					newLeafNode(lv_type_0_5, grammarAccess.getComparisonAccess().getTypeGreaterThanSignKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getComparisonRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_5, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleFilterKeyword"
    // InternalQueryDsl.g:2446:1: entryRuleFilterKeyword returns [EObject current=null] : iv_ruleFilterKeyword= ruleFilterKeyword EOF ;
    public final EObject entryRuleFilterKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilterKeyword = null;


        try {
            // InternalQueryDsl.g:2446:54: (iv_ruleFilterKeyword= ruleFilterKeyword EOF )
            // InternalQueryDsl.g:2447:2: iv_ruleFilterKeyword= ruleFilterKeyword EOF
            {
             newCompositeNode(grammarAccess.getFilterKeywordRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilterKeyword=ruleFilterKeyword();

            state._fsp--;

             current =iv_ruleFilterKeyword; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFilterKeyword"


    // $ANTLR start "ruleFilterKeyword"
    // InternalQueryDsl.g:2453:1: ruleFilterKeyword returns [EObject current=null] : ( ( (lv_type_0_1= 'gte' | lv_type_0_2= 'lte' | lv_type_0_3= 'lt' | lv_type_0_4= 'gt' ) ) ) ;
    public final EObject ruleFilterKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token lv_type_0_3=null;
        Token lv_type_0_4=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:2459:2: ( ( ( (lv_type_0_1= 'gte' | lv_type_0_2= 'lte' | lv_type_0_3= 'lt' | lv_type_0_4= 'gt' ) ) ) )
            // InternalQueryDsl.g:2460:2: ( ( (lv_type_0_1= 'gte' | lv_type_0_2= 'lte' | lv_type_0_3= 'lt' | lv_type_0_4= 'gt' ) ) )
            {
            // InternalQueryDsl.g:2460:2: ( ( (lv_type_0_1= 'gte' | lv_type_0_2= 'lte' | lv_type_0_3= 'lt' | lv_type_0_4= 'gt' ) ) )
            // InternalQueryDsl.g:2461:3: ( (lv_type_0_1= 'gte' | lv_type_0_2= 'lte' | lv_type_0_3= 'lt' | lv_type_0_4= 'gt' ) )
            {
            // InternalQueryDsl.g:2461:3: ( (lv_type_0_1= 'gte' | lv_type_0_2= 'lte' | lv_type_0_3= 'lt' | lv_type_0_4= 'gt' ) )
            // InternalQueryDsl.g:2462:4: (lv_type_0_1= 'gte' | lv_type_0_2= 'lte' | lv_type_0_3= 'lt' | lv_type_0_4= 'gt' )
            {
            // InternalQueryDsl.g:2462:4: (lv_type_0_1= 'gte' | lv_type_0_2= 'lte' | lv_type_0_3= 'lt' | lv_type_0_4= 'gt' )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt32=1;
                }
                break;
            case 71:
                {
                alt32=2;
                }
                break;
            case 72:
                {
                alt32=3;
                }
                break;
            case 73:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalQueryDsl.g:2463:5: lv_type_0_1= 'gte'
                    {
                    lv_type_0_1=(Token)match(input,70,FOLLOW_2); 

                    					newLeafNode(lv_type_0_1, grammarAccess.getFilterKeywordAccess().getTypeGteKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFilterKeywordRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2474:5: lv_type_0_2= 'lte'
                    {
                    lv_type_0_2=(Token)match(input,71,FOLLOW_2); 

                    					newLeafNode(lv_type_0_2, grammarAccess.getFilterKeywordAccess().getTypeLteKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFilterKeywordRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2485:5: lv_type_0_3= 'lt'
                    {
                    lv_type_0_3=(Token)match(input,72,FOLLOW_2); 

                    					newLeafNode(lv_type_0_3, grammarAccess.getFilterKeywordAccess().getTypeLtKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFilterKeywordRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:2496:5: lv_type_0_4= 'gt'
                    {
                    lv_type_0_4=(Token)match(input,73,FOLLOW_2); 

                    					newLeafNode(lv_type_0_4, grammarAccess.getFilterKeywordAccess().getTypeGtKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFilterKeywordRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_4, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilterKeyword"


    // $ANTLR start "entryRuleUserVar"
    // InternalQueryDsl.g:2512:1: entryRuleUserVar returns [EObject current=null] : iv_ruleUserVar= ruleUserVar EOF ;
    public final EObject entryRuleUserVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserVar = null;


        try {
            // InternalQueryDsl.g:2512:48: (iv_ruleUserVar= ruleUserVar EOF )
            // InternalQueryDsl.g:2513:2: iv_ruleUserVar= ruleUserVar EOF
            {
             newCompositeNode(grammarAccess.getUserVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUserVar=ruleUserVar();

            state._fsp--;

             current =iv_ruleUserVar; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUserVar"


    // $ANTLR start "ruleUserVar"
    // InternalQueryDsl.g:2519:1: ruleUserVar returns [EObject current=null] : (this_UserParam_0= ruleUserParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleUserVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_UserParam_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:2525:2: ( (this_UserParam_0= ruleUserParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:2526:2: (this_UserParam_0= ruleUserParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:2526:2: (this_UserParam_0= ruleUserParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            // InternalQueryDsl.g:2527:3: this_UserParam_0= ruleUserParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) )
            {

            			newCompositeNode(grammarAccess.getUserVarAccess().getUserParamParserRuleCall_0());
            		
            pushFollow(FOLLOW_32);
            this_UserParam_0=ruleUserParam();

            state._fsp--;


            			current = this_UserParam_0;
            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,28,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getUserVarAccess().getColonKeyword_1());
            		
            // InternalQueryDsl.g:2539:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:2540:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:2540:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:2541:5: lv_exp_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getUserVarAccess().getExpExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUserVarRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUserVar"


    // $ANTLR start "entryRuleWorkspaceVar"
    // InternalQueryDsl.g:2562:1: entryRuleWorkspaceVar returns [EObject current=null] : iv_ruleWorkspaceVar= ruleWorkspaceVar EOF ;
    public final EObject entryRuleWorkspaceVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkspaceVar = null;


        try {
            // InternalQueryDsl.g:2562:53: (iv_ruleWorkspaceVar= ruleWorkspaceVar EOF )
            // InternalQueryDsl.g:2563:2: iv_ruleWorkspaceVar= ruleWorkspaceVar EOF
            {
             newCompositeNode(grammarAccess.getWorkspaceVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkspaceVar=ruleWorkspaceVar();

            state._fsp--;

             current =iv_ruleWorkspaceVar; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleWorkspaceVar"


    // $ANTLR start "ruleWorkspaceVar"
    // InternalQueryDsl.g:2569:1: ruleWorkspaceVar returns [EObject current=null] : (this_WorkspaceParam_0= ruleWorkspaceParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleWorkspaceVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_WorkspaceParam_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:2575:2: ( (this_WorkspaceParam_0= ruleWorkspaceParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:2576:2: (this_WorkspaceParam_0= ruleWorkspaceParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:2576:2: (this_WorkspaceParam_0= ruleWorkspaceParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            // InternalQueryDsl.g:2577:3: this_WorkspaceParam_0= ruleWorkspaceParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) )
            {

            			newCompositeNode(grammarAccess.getWorkspaceVarAccess().getWorkspaceParamParserRuleCall_0());
            		
            pushFollow(FOLLOW_32);
            this_WorkspaceParam_0=ruleWorkspaceParam();

            state._fsp--;


            			current = this_WorkspaceParam_0;
            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,28,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getWorkspaceVarAccess().getColonKeyword_1());
            		
            // InternalQueryDsl.g:2589:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:2590:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:2590:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:2591:5: lv_exp_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getWorkspaceVarAccess().getExpExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkspaceVarRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkspaceVar"


    // $ANTLR start "entryRuleProjectVar"
    // InternalQueryDsl.g:2612:1: entryRuleProjectVar returns [EObject current=null] : iv_ruleProjectVar= ruleProjectVar EOF ;
    public final EObject entryRuleProjectVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectVar = null;


        try {
            // InternalQueryDsl.g:2612:51: (iv_ruleProjectVar= ruleProjectVar EOF )
            // InternalQueryDsl.g:2613:2: iv_ruleProjectVar= ruleProjectVar EOF
            {
             newCompositeNode(grammarAccess.getProjectVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProjectVar=ruleProjectVar();

            state._fsp--;

             current =iv_ruleProjectVar; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleProjectVar"


    // $ANTLR start "ruleProjectVar"
    // InternalQueryDsl.g:2619:1: ruleProjectVar returns [EObject current=null] : (this_ProjectParam_0= ruleProjectParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleProjectVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ProjectParam_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:2625:2: ( (this_ProjectParam_0= ruleProjectParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:2626:2: (this_ProjectParam_0= ruleProjectParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:2626:2: (this_ProjectParam_0= ruleProjectParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            // InternalQueryDsl.g:2627:3: this_ProjectParam_0= ruleProjectParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) )
            {

            			newCompositeNode(grammarAccess.getProjectVarAccess().getProjectParamParserRuleCall_0());
            		
            pushFollow(FOLLOW_32);
            this_ProjectParam_0=ruleProjectParam();

            state._fsp--;


            			current = this_ProjectParam_0;
            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,28,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getProjectVarAccess().getColonKeyword_1());
            		
            // InternalQueryDsl.g:2639:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:2640:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:2640:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:2641:5: lv_exp_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getProjectVarAccess().getExpExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProjectVarRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectVar"


    // $ANTLR start "entryRuleMetamodelVar"
    // InternalQueryDsl.g:2662:1: entryRuleMetamodelVar returns [EObject current=null] : iv_ruleMetamodelVar= ruleMetamodelVar EOF ;
    public final EObject entryRuleMetamodelVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetamodelVar = null;


        try {
            // InternalQueryDsl.g:2662:53: (iv_ruleMetamodelVar= ruleMetamodelVar EOF )
            // InternalQueryDsl.g:2663:2: iv_ruleMetamodelVar= ruleMetamodelVar EOF
            {
             newCompositeNode(grammarAccess.getMetamodelVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetamodelVar=ruleMetamodelVar();

            state._fsp--;

             current =iv_ruleMetamodelVar; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMetamodelVar"


    // $ANTLR start "ruleMetamodelVar"
    // InternalQueryDsl.g:2669:1: ruleMetamodelVar returns [EObject current=null] : ( ruleMetamodelParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleMetamodelVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:2675:2: ( ( ruleMetamodelParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:2676:2: ( ruleMetamodelParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:2676:2: ( ruleMetamodelParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            // InternalQueryDsl.g:2677:3: ruleMetamodelParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) )
            {

            			newCompositeNode(grammarAccess.getMetamodelVarAccess().getMetamodelParamParserRuleCall_0());
            		
            pushFollow(FOLLOW_32);
            ruleMetamodelParam();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,28,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getMetamodelVarAccess().getColonKeyword_1());
            		
            // InternalQueryDsl.g:2688:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:2689:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:2689:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:2690:5: lv_exp_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getMetamodelVarAccess().getExpExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMetamodelVarRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetamodelVar"


    // $ANTLR start "entryRuleModelVar"
    // InternalQueryDsl.g:2711:1: entryRuleModelVar returns [EObject current=null] : iv_ruleModelVar= ruleModelVar EOF ;
    public final EObject entryRuleModelVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelVar = null;


        try {
            // InternalQueryDsl.g:2711:49: (iv_ruleModelVar= ruleModelVar EOF )
            // InternalQueryDsl.g:2712:2: iv_ruleModelVar= ruleModelVar EOF
            {
             newCompositeNode(grammarAccess.getModelVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModelVar=ruleModelVar();

            state._fsp--;

             current =iv_ruleModelVar; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModelVar"


    // $ANTLR start "ruleModelVar"
    // InternalQueryDsl.g:2718:1: ruleModelVar returns [EObject current=null] : ( ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleModelVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:2724:2: ( ( ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:2725:2: ( ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:2725:2: ( ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            // InternalQueryDsl.g:2726:3: ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) )
            {

            			newCompositeNode(grammarAccess.getModelVarAccess().getParamParserRuleCall_0());
            		
            pushFollow(FOLLOW_32);
            ruleParam();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,28,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getModelVarAccess().getColonKeyword_1());
            		
            // InternalQueryDsl.g:2737:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:2738:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:2738:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:2739:5: lv_exp_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getModelVarAccess().getExpExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelVarRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelVar"


    // $ANTLR start "entryRuleDslVar"
    // InternalQueryDsl.g:2760:1: entryRuleDslVar returns [EObject current=null] : iv_ruleDslVar= ruleDslVar EOF ;
    public final EObject entryRuleDslVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDslVar = null;


        try {
            // InternalQueryDsl.g:2760:47: (iv_ruleDslVar= ruleDslVar EOF )
            // InternalQueryDsl.g:2761:2: iv_ruleDslVar= ruleDslVar EOF
            {
             newCompositeNode(grammarAccess.getDslVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDslVar=ruleDslVar();

            state._fsp--;

             current =iv_ruleDslVar; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDslVar"


    // $ANTLR start "ruleDslVar"
    // InternalQueryDsl.g:2767:1: ruleDslVar returns [EObject current=null] : ( ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleDslVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:2773:2: ( ( ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:2774:2: ( ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:2774:2: ( ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) ) )
            // InternalQueryDsl.g:2775:3: ruleParam otherlv_1= ':' ( (lv_exp_2_0= ruleExpression ) )
            {

            			newCompositeNode(grammarAccess.getDslVarAccess().getParamParserRuleCall_0());
            		
            pushFollow(FOLLOW_32);
            ruleParam();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,28,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getDslVarAccess().getColonKeyword_1());
            		
            // InternalQueryDsl.g:2786:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalQueryDsl.g:2787:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalQueryDsl.g:2787:4: (lv_exp_2_0= ruleExpression )
            // InternalQueryDsl.g:2788:5: lv_exp_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDslVarAccess().getExpExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDslVarRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDslVar"


    // $ANTLR start "entryRuleUserField"
    // InternalQueryDsl.g:2809:1: entryRuleUserField returns [EObject current=null] : iv_ruleUserField= ruleUserField EOF ;
    public final EObject entryRuleUserField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserField = null;


        try {
            // InternalQueryDsl.g:2809:50: (iv_ruleUserField= ruleUserField EOF )
            // InternalQueryDsl.g:2810:2: iv_ruleUserField= ruleUserField EOF
            {
             newCompositeNode(grammarAccess.getUserFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUserField=ruleUserField();

            state._fsp--;

             current =iv_ruleUserField; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUserField"


    // $ANTLR start "ruleUserField"
    // InternalQueryDsl.g:2816:1: ruleUserField returns [EObject current=null] : ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'username' | lv_typeName_0_3= 'email' | lv_typeName_0_4= 'createdAt' | lv_typeName_0_5= 'updatedAt' ) ) ) ;
    public final EObject ruleUserField() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;
        Token lv_typeName_0_5=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:2822:2: ( ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'username' | lv_typeName_0_3= 'email' | lv_typeName_0_4= 'createdAt' | lv_typeName_0_5= 'updatedAt' ) ) ) )
            // InternalQueryDsl.g:2823:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'username' | lv_typeName_0_3= 'email' | lv_typeName_0_4= 'createdAt' | lv_typeName_0_5= 'updatedAt' ) ) )
            {
            // InternalQueryDsl.g:2823:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'username' | lv_typeName_0_3= 'email' | lv_typeName_0_4= 'createdAt' | lv_typeName_0_5= 'updatedAt' ) ) )
            // InternalQueryDsl.g:2824:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'username' | lv_typeName_0_3= 'email' | lv_typeName_0_4= 'createdAt' | lv_typeName_0_5= 'updatedAt' ) )
            {
            // InternalQueryDsl.g:2824:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'username' | lv_typeName_0_3= 'email' | lv_typeName_0_4= 'createdAt' | lv_typeName_0_5= 'updatedAt' ) )
            // InternalQueryDsl.g:2825:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'username' | lv_typeName_0_3= 'email' | lv_typeName_0_4= 'createdAt' | lv_typeName_0_5= 'updatedAt' )
            {
            // InternalQueryDsl.g:2825:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'username' | lv_typeName_0_3= 'email' | lv_typeName_0_4= 'createdAt' | lv_typeName_0_5= 'updatedAt' )
            int alt33=5;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt33=1;
                }
                break;
            case 74:
                {
                alt33=2;
                }
                break;
            case 75:
                {
                alt33=3;
                }
                break;
            case 76:
                {
                alt33=4;
                }
                break;
            case 77:
                {
                alt33=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalQueryDsl.g:2826:5: lv_typeName_0_1= 'id'
                    {
                    lv_typeName_0_1=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getUserFieldAccess().getTypeNameIdKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUserFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2837:5: lv_typeName_0_2= 'username'
                    {
                    lv_typeName_0_2=(Token)match(input,74,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getUserFieldAccess().getTypeNameUsernameKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUserFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2848:5: lv_typeName_0_3= 'email'
                    {
                    lv_typeName_0_3=(Token)match(input,75,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_3, grammarAccess.getUserFieldAccess().getTypeNameEmailKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUserFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:2859:5: lv_typeName_0_4= 'createdAt'
                    {
                    lv_typeName_0_4=(Token)match(input,76,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_4, grammarAccess.getUserFieldAccess().getTypeNameCreatedAtKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUserFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:2870:5: lv_typeName_0_5= 'updatedAt'
                    {
                    lv_typeName_0_5=(Token)match(input,77,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_5, grammarAccess.getUserFieldAccess().getTypeNameUpdatedAtKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUserFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_5, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUserField"


    // $ANTLR start "entryRuleWorkspaceField"
    // InternalQueryDsl.g:2886:1: entryRuleWorkspaceField returns [EObject current=null] : iv_ruleWorkspaceField= ruleWorkspaceField EOF ;
    public final EObject entryRuleWorkspaceField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkspaceField = null;


        try {
            // InternalQueryDsl.g:2886:55: (iv_ruleWorkspaceField= ruleWorkspaceField EOF )
            // InternalQueryDsl.g:2887:2: iv_ruleWorkspaceField= ruleWorkspaceField EOF
            {
             newCompositeNode(grammarAccess.getWorkspaceFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkspaceField=ruleWorkspaceField();

            state._fsp--;

             current =iv_ruleWorkspaceField; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleWorkspaceField"


    // $ANTLR start "ruleWorkspaceField"
    // InternalQueryDsl.g:2893:1: ruleWorkspaceField returns [EObject current=null] : ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'owner' | lv_typeName_0_5= 'projects' | lv_typeName_0_6= 'createdAt' | lv_typeName_0_7= 'updatedAt' ) ) ) ;
    public final EObject ruleWorkspaceField() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;
        Token lv_typeName_0_5=null;
        Token lv_typeName_0_6=null;
        Token lv_typeName_0_7=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:2899:2: ( ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'owner' | lv_typeName_0_5= 'projects' | lv_typeName_0_6= 'createdAt' | lv_typeName_0_7= 'updatedAt' ) ) ) )
            // InternalQueryDsl.g:2900:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'owner' | lv_typeName_0_5= 'projects' | lv_typeName_0_6= 'createdAt' | lv_typeName_0_7= 'updatedAt' ) ) )
            {
            // InternalQueryDsl.g:2900:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'owner' | lv_typeName_0_5= 'projects' | lv_typeName_0_6= 'createdAt' | lv_typeName_0_7= 'updatedAt' ) ) )
            // InternalQueryDsl.g:2901:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'owner' | lv_typeName_0_5= 'projects' | lv_typeName_0_6= 'createdAt' | lv_typeName_0_7= 'updatedAt' ) )
            {
            // InternalQueryDsl.g:2901:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'owner' | lv_typeName_0_5= 'projects' | lv_typeName_0_6= 'createdAt' | lv_typeName_0_7= 'updatedAt' ) )
            // InternalQueryDsl.g:2902:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'owner' | lv_typeName_0_5= 'projects' | lv_typeName_0_6= 'createdAt' | lv_typeName_0_7= 'updatedAt' )
            {
            // InternalQueryDsl.g:2902:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'owner' | lv_typeName_0_5= 'projects' | lv_typeName_0_6= 'createdAt' | lv_typeName_0_7= 'updatedAt' )
            int alt34=7;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt34=1;
                }
                break;
            case 37:
                {
                alt34=2;
                }
                break;
            case 78:
                {
                alt34=3;
                }
                break;
            case 79:
                {
                alt34=4;
                }
                break;
            case 80:
                {
                alt34=5;
                }
                break;
            case 76:
                {
                alt34=6;
                }
                break;
            case 77:
                {
                alt34=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalQueryDsl.g:2903:5: lv_typeName_0_1= 'id'
                    {
                    lv_typeName_0_1=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getWorkspaceFieldAccess().getTypeNameIdKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkspaceFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2914:5: lv_typeName_0_2= 'name'
                    {
                    lv_typeName_0_2=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getWorkspaceFieldAccess().getTypeNameNameKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkspaceFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2925:5: lv_typeName_0_3= 'description'
                    {
                    lv_typeName_0_3=(Token)match(input,78,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_3, grammarAccess.getWorkspaceFieldAccess().getTypeNameDescriptionKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkspaceFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:2936:5: lv_typeName_0_4= 'owner'
                    {
                    lv_typeName_0_4=(Token)match(input,79,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_4, grammarAccess.getWorkspaceFieldAccess().getTypeNameOwnerKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkspaceFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:2947:5: lv_typeName_0_5= 'projects'
                    {
                    lv_typeName_0_5=(Token)match(input,80,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_5, grammarAccess.getWorkspaceFieldAccess().getTypeNameProjectsKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkspaceFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:2958:5: lv_typeName_0_6= 'createdAt'
                    {
                    lv_typeName_0_6=(Token)match(input,76,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_6, grammarAccess.getWorkspaceFieldAccess().getTypeNameCreatedAtKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkspaceFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_6, null);
                    				

                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:2969:5: lv_typeName_0_7= 'updatedAt'
                    {
                    lv_typeName_0_7=(Token)match(input,77,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_7, grammarAccess.getWorkspaceFieldAccess().getTypeNameUpdatedAtKeyword_0_6());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkspaceFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_7, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkspaceField"


    // $ANTLR start "entryRuleProjectField"
    // InternalQueryDsl.g:2985:1: entryRuleProjectField returns [EObject current=null] : iv_ruleProjectField= ruleProjectField EOF ;
    public final EObject entryRuleProjectField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectField = null;


        try {
            // InternalQueryDsl.g:2985:53: (iv_ruleProjectField= ruleProjectField EOF )
            // InternalQueryDsl.g:2986:2: iv_ruleProjectField= ruleProjectField EOF
            {
             newCompositeNode(grammarAccess.getProjectFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProjectField=ruleProjectField();

            state._fsp--;

             current =iv_ruleProjectField; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleProjectField"


    // $ANTLR start "ruleProjectField"
    // InternalQueryDsl.g:2992:1: ruleProjectField returns [EObject current=null] : ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'user' | lv_typeName_0_5= 'workspace' | lv_typeName_0_6= 'sharedUser' | lv_typeName_0_7= 'comments' | lv_typeName_0_8= 'createdAt' | lv_typeName_0_9= 'updatedAt' ) ) ) ;
    public final EObject ruleProjectField() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;
        Token lv_typeName_0_5=null;
        Token lv_typeName_0_6=null;
        Token lv_typeName_0_7=null;
        Token lv_typeName_0_8=null;
        Token lv_typeName_0_9=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:2998:2: ( ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'user' | lv_typeName_0_5= 'workspace' | lv_typeName_0_6= 'sharedUser' | lv_typeName_0_7= 'comments' | lv_typeName_0_8= 'createdAt' | lv_typeName_0_9= 'updatedAt' ) ) ) )
            // InternalQueryDsl.g:2999:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'user' | lv_typeName_0_5= 'workspace' | lv_typeName_0_6= 'sharedUser' | lv_typeName_0_7= 'comments' | lv_typeName_0_8= 'createdAt' | lv_typeName_0_9= 'updatedAt' ) ) )
            {
            // InternalQueryDsl.g:2999:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'user' | lv_typeName_0_5= 'workspace' | lv_typeName_0_6= 'sharedUser' | lv_typeName_0_7= 'comments' | lv_typeName_0_8= 'createdAt' | lv_typeName_0_9= 'updatedAt' ) ) )
            // InternalQueryDsl.g:3000:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'user' | lv_typeName_0_5= 'workspace' | lv_typeName_0_6= 'sharedUser' | lv_typeName_0_7= 'comments' | lv_typeName_0_8= 'createdAt' | lv_typeName_0_9= 'updatedAt' ) )
            {
            // InternalQueryDsl.g:3000:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'user' | lv_typeName_0_5= 'workspace' | lv_typeName_0_6= 'sharedUser' | lv_typeName_0_7= 'comments' | lv_typeName_0_8= 'createdAt' | lv_typeName_0_9= 'updatedAt' ) )
            // InternalQueryDsl.g:3001:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'user' | lv_typeName_0_5= 'workspace' | lv_typeName_0_6= 'sharedUser' | lv_typeName_0_7= 'comments' | lv_typeName_0_8= 'createdAt' | lv_typeName_0_9= 'updatedAt' )
            {
            // InternalQueryDsl.g:3001:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'name' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'user' | lv_typeName_0_5= 'workspace' | lv_typeName_0_6= 'sharedUser' | lv_typeName_0_7= 'comments' | lv_typeName_0_8= 'createdAt' | lv_typeName_0_9= 'updatedAt' )
            int alt35=9;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt35=1;
                }
                break;
            case 37:
                {
                alt35=2;
                }
                break;
            case 78:
                {
                alt35=3;
                }
                break;
            case 81:
                {
                alt35=4;
                }
                break;
            case 82:
                {
                alt35=5;
                }
                break;
            case 83:
                {
                alt35=6;
                }
                break;
            case 84:
                {
                alt35=7;
                }
                break;
            case 76:
                {
                alt35=8;
                }
                break;
            case 77:
                {
                alt35=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalQueryDsl.g:3002:5: lv_typeName_0_1= 'id'
                    {
                    lv_typeName_0_1=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getProjectFieldAccess().getTypeNameIdKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3013:5: lv_typeName_0_2= 'name'
                    {
                    lv_typeName_0_2=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getProjectFieldAccess().getTypeNameNameKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:3024:5: lv_typeName_0_3= 'description'
                    {
                    lv_typeName_0_3=(Token)match(input,78,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_3, grammarAccess.getProjectFieldAccess().getTypeNameDescriptionKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:3035:5: lv_typeName_0_4= 'user'
                    {
                    lv_typeName_0_4=(Token)match(input,81,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_4, grammarAccess.getProjectFieldAccess().getTypeNameUserKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:3046:5: lv_typeName_0_5= 'workspace'
                    {
                    lv_typeName_0_5=(Token)match(input,82,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_5, grammarAccess.getProjectFieldAccess().getTypeNameWorkspaceKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:3057:5: lv_typeName_0_6= 'sharedUser'
                    {
                    lv_typeName_0_6=(Token)match(input,83,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_6, grammarAccess.getProjectFieldAccess().getTypeNameSharedUserKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_6, null);
                    				

                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:3068:5: lv_typeName_0_7= 'comments'
                    {
                    lv_typeName_0_7=(Token)match(input,84,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_7, grammarAccess.getProjectFieldAccess().getTypeNameCommentsKeyword_0_6());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_7, null);
                    				

                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:3079:5: lv_typeName_0_8= 'createdAt'
                    {
                    lv_typeName_0_8=(Token)match(input,76,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_8, grammarAccess.getProjectFieldAccess().getTypeNameCreatedAtKeyword_0_7());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_8, null);
                    				

                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:3090:5: lv_typeName_0_9= 'updatedAt'
                    {
                    lv_typeName_0_9=(Token)match(input,77,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_9, grammarAccess.getProjectFieldAccess().getTypeNameUpdatedAtKeyword_0_8());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_9, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectField"


    // $ANTLR start "entryRuleMetamodelField"
    // InternalQueryDsl.g:3106:1: entryRuleMetamodelField returns [EObject current=null] : iv_ruleMetamodelField= ruleMetamodelField EOF ;
    public final EObject entryRuleMetamodelField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetamodelField = null;


        try {
            // InternalQueryDsl.g:3106:55: (iv_ruleMetamodelField= ruleMetamodelField EOF )
            // InternalQueryDsl.g:3107:2: iv_ruleMetamodelField= ruleMetamodelField EOF
            {
             newCompositeNode(grammarAccess.getMetamodelFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetamodelField=ruleMetamodelField();

            state._fsp--;

             current =iv_ruleMetamodelField; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMetamodelField"


    // $ANTLR start "ruleMetamodelField"
    // InternalQueryDsl.g:3113:1: ruleMetamodelField returns [EObject current=null] : ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ePackage' | lv_typeName_0_5= 'ext' | lv_typeName_0_6= 'involvedOperations' | lv_typeName_0_7= 'metrics' | lv_typeName_0_8= 'models' | lv_typeName_0_9= 'license' | lv_typeName_0_10= 'metamodel' | lv_typeName_0_11= 'name' | lv_typeName_0_12= 'project' | lv_typeName_0_13= 'size' | lv_typeName_0_14= 'storageUrl' | lv_typeName_0_15= 'type' | lv_typeName_0_16= 'unique_name' | lv_typeName_0_17= 'createdAt' | lv_typeName_0_18= 'updatedAt' ) ) ) ;
    public final EObject ruleMetamodelField() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;
        Token lv_typeName_0_5=null;
        Token lv_typeName_0_6=null;
        Token lv_typeName_0_7=null;
        Token lv_typeName_0_8=null;
        Token lv_typeName_0_9=null;
        Token lv_typeName_0_10=null;
        Token lv_typeName_0_11=null;
        Token lv_typeName_0_12=null;
        Token lv_typeName_0_13=null;
        Token lv_typeName_0_14=null;
        Token lv_typeName_0_15=null;
        Token lv_typeName_0_16=null;
        Token lv_typeName_0_17=null;
        Token lv_typeName_0_18=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:3119:2: ( ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ePackage' | lv_typeName_0_5= 'ext' | lv_typeName_0_6= 'involvedOperations' | lv_typeName_0_7= 'metrics' | lv_typeName_0_8= 'models' | lv_typeName_0_9= 'license' | lv_typeName_0_10= 'metamodel' | lv_typeName_0_11= 'name' | lv_typeName_0_12= 'project' | lv_typeName_0_13= 'size' | lv_typeName_0_14= 'storageUrl' | lv_typeName_0_15= 'type' | lv_typeName_0_16= 'unique_name' | lv_typeName_0_17= 'createdAt' | lv_typeName_0_18= 'updatedAt' ) ) ) )
            // InternalQueryDsl.g:3120:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ePackage' | lv_typeName_0_5= 'ext' | lv_typeName_0_6= 'involvedOperations' | lv_typeName_0_7= 'metrics' | lv_typeName_0_8= 'models' | lv_typeName_0_9= 'license' | lv_typeName_0_10= 'metamodel' | lv_typeName_0_11= 'name' | lv_typeName_0_12= 'project' | lv_typeName_0_13= 'size' | lv_typeName_0_14= 'storageUrl' | lv_typeName_0_15= 'type' | lv_typeName_0_16= 'unique_name' | lv_typeName_0_17= 'createdAt' | lv_typeName_0_18= 'updatedAt' ) ) )
            {
            // InternalQueryDsl.g:3120:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ePackage' | lv_typeName_0_5= 'ext' | lv_typeName_0_6= 'involvedOperations' | lv_typeName_0_7= 'metrics' | lv_typeName_0_8= 'models' | lv_typeName_0_9= 'license' | lv_typeName_0_10= 'metamodel' | lv_typeName_0_11= 'name' | lv_typeName_0_12= 'project' | lv_typeName_0_13= 'size' | lv_typeName_0_14= 'storageUrl' | lv_typeName_0_15= 'type' | lv_typeName_0_16= 'unique_name' | lv_typeName_0_17= 'createdAt' | lv_typeName_0_18= 'updatedAt' ) ) )
            // InternalQueryDsl.g:3121:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ePackage' | lv_typeName_0_5= 'ext' | lv_typeName_0_6= 'involvedOperations' | lv_typeName_0_7= 'metrics' | lv_typeName_0_8= 'models' | lv_typeName_0_9= 'license' | lv_typeName_0_10= 'metamodel' | lv_typeName_0_11= 'name' | lv_typeName_0_12= 'project' | lv_typeName_0_13= 'size' | lv_typeName_0_14= 'storageUrl' | lv_typeName_0_15= 'type' | lv_typeName_0_16= 'unique_name' | lv_typeName_0_17= 'createdAt' | lv_typeName_0_18= 'updatedAt' ) )
            {
            // InternalQueryDsl.g:3121:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ePackage' | lv_typeName_0_5= 'ext' | lv_typeName_0_6= 'involvedOperations' | lv_typeName_0_7= 'metrics' | lv_typeName_0_8= 'models' | lv_typeName_0_9= 'license' | lv_typeName_0_10= 'metamodel' | lv_typeName_0_11= 'name' | lv_typeName_0_12= 'project' | lv_typeName_0_13= 'size' | lv_typeName_0_14= 'storageUrl' | lv_typeName_0_15= 'type' | lv_typeName_0_16= 'unique_name' | lv_typeName_0_17= 'createdAt' | lv_typeName_0_18= 'updatedAt' ) )
            // InternalQueryDsl.g:3122:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ePackage' | lv_typeName_0_5= 'ext' | lv_typeName_0_6= 'involvedOperations' | lv_typeName_0_7= 'metrics' | lv_typeName_0_8= 'models' | lv_typeName_0_9= 'license' | lv_typeName_0_10= 'metamodel' | lv_typeName_0_11= 'name' | lv_typeName_0_12= 'project' | lv_typeName_0_13= 'size' | lv_typeName_0_14= 'storageUrl' | lv_typeName_0_15= 'type' | lv_typeName_0_16= 'unique_name' | lv_typeName_0_17= 'createdAt' | lv_typeName_0_18= 'updatedAt' )
            {
            // InternalQueryDsl.g:3122:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ePackage' | lv_typeName_0_5= 'ext' | lv_typeName_0_6= 'involvedOperations' | lv_typeName_0_7= 'metrics' | lv_typeName_0_8= 'models' | lv_typeName_0_9= 'license' | lv_typeName_0_10= 'metamodel' | lv_typeName_0_11= 'name' | lv_typeName_0_12= 'project' | lv_typeName_0_13= 'size' | lv_typeName_0_14= 'storageUrl' | lv_typeName_0_15= 'type' | lv_typeName_0_16= 'unique_name' | lv_typeName_0_17= 'createdAt' | lv_typeName_0_18= 'updatedAt' )
            int alt36=18;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt36=1;
                }
                break;
            case 85:
                {
                alt36=2;
                }
                break;
            case 78:
                {
                alt36=3;
                }
                break;
            case 86:
                {
                alt36=4;
                }
                break;
            case 87:
                {
                alt36=5;
                }
                break;
            case 88:
                {
                alt36=6;
                }
                break;
            case 89:
                {
                alt36=7;
                }
                break;
            case 90:
                {
                alt36=8;
                }
                break;
            case 91:
                {
                alt36=9;
                }
                break;
            case 92:
                {
                alt36=10;
                }
                break;
            case 37:
                {
                alt36=11;
                }
                break;
            case 93:
                {
                alt36=12;
                }
                break;
            case 64:
                {
                alt36=13;
                }
                break;
            case 94:
                {
                alt36=14;
                }
                break;
            case 27:
                {
                alt36=15;
                }
                break;
            case 95:
                {
                alt36=16;
                }
                break;
            case 76:
                {
                alt36=17;
                }
                break;
            case 77:
                {
                alt36=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalQueryDsl.g:3123:5: lv_typeName_0_1= 'id'
                    {
                    lv_typeName_0_1=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getMetamodelFieldAccess().getTypeNameIdKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3134:5: lv_typeName_0_2= 'accessControl'
                    {
                    lv_typeName_0_2=(Token)match(input,85,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getMetamodelFieldAccess().getTypeNameAccessControlKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:3145:5: lv_typeName_0_3= 'description'
                    {
                    lv_typeName_0_3=(Token)match(input,78,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_3, grammarAccess.getMetamodelFieldAccess().getTypeNameDescriptionKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:3156:5: lv_typeName_0_4= 'ePackage'
                    {
                    lv_typeName_0_4=(Token)match(input,86,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_4, grammarAccess.getMetamodelFieldAccess().getTypeNameEPackageKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:3167:5: lv_typeName_0_5= 'ext'
                    {
                    lv_typeName_0_5=(Token)match(input,87,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_5, grammarAccess.getMetamodelFieldAccess().getTypeNameExtKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:3178:5: lv_typeName_0_6= 'involvedOperations'
                    {
                    lv_typeName_0_6=(Token)match(input,88,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_6, grammarAccess.getMetamodelFieldAccess().getTypeNameInvolvedOperationsKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_6, null);
                    				

                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:3189:5: lv_typeName_0_7= 'metrics'
                    {
                    lv_typeName_0_7=(Token)match(input,89,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_7, grammarAccess.getMetamodelFieldAccess().getTypeNameMetricsKeyword_0_6());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_7, null);
                    				

                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:3200:5: lv_typeName_0_8= 'models'
                    {
                    lv_typeName_0_8=(Token)match(input,90,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_8, grammarAccess.getMetamodelFieldAccess().getTypeNameModelsKeyword_0_7());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_8, null);
                    				

                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:3211:5: lv_typeName_0_9= 'license'
                    {
                    lv_typeName_0_9=(Token)match(input,91,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_9, grammarAccess.getMetamodelFieldAccess().getTypeNameLicenseKeyword_0_8());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_9, null);
                    				

                    }
                    break;
                case 10 :
                    // InternalQueryDsl.g:3222:5: lv_typeName_0_10= 'metamodel'
                    {
                    lv_typeName_0_10=(Token)match(input,92,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_10, grammarAccess.getMetamodelFieldAccess().getTypeNameMetamodelKeyword_0_9());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_10, null);
                    				

                    }
                    break;
                case 11 :
                    // InternalQueryDsl.g:3233:5: lv_typeName_0_11= 'name'
                    {
                    lv_typeName_0_11=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_11, grammarAccess.getMetamodelFieldAccess().getTypeNameNameKeyword_0_10());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_11, null);
                    				

                    }
                    break;
                case 12 :
                    // InternalQueryDsl.g:3244:5: lv_typeName_0_12= 'project'
                    {
                    lv_typeName_0_12=(Token)match(input,93,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_12, grammarAccess.getMetamodelFieldAccess().getTypeNameProjectKeyword_0_11());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_12, null);
                    				

                    }
                    break;
                case 13 :
                    // InternalQueryDsl.g:3255:5: lv_typeName_0_13= 'size'
                    {
                    lv_typeName_0_13=(Token)match(input,64,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_13, grammarAccess.getMetamodelFieldAccess().getTypeNameSizeKeyword_0_12());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_13, null);
                    				

                    }
                    break;
                case 14 :
                    // InternalQueryDsl.g:3266:5: lv_typeName_0_14= 'storageUrl'
                    {
                    lv_typeName_0_14=(Token)match(input,94,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_14, grammarAccess.getMetamodelFieldAccess().getTypeNameStorageUrlKeyword_0_13());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_14, null);
                    				

                    }
                    break;
                case 15 :
                    // InternalQueryDsl.g:3277:5: lv_typeName_0_15= 'type'
                    {
                    lv_typeName_0_15=(Token)match(input,27,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_15, grammarAccess.getMetamodelFieldAccess().getTypeNameTypeKeyword_0_14());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_15, null);
                    				

                    }
                    break;
                case 16 :
                    // InternalQueryDsl.g:3288:5: lv_typeName_0_16= 'unique_name'
                    {
                    lv_typeName_0_16=(Token)match(input,95,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_16, grammarAccess.getMetamodelFieldAccess().getTypeNameUnique_nameKeyword_0_15());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_16, null);
                    				

                    }
                    break;
                case 17 :
                    // InternalQueryDsl.g:3299:5: lv_typeName_0_17= 'createdAt'
                    {
                    lv_typeName_0_17=(Token)match(input,76,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_17, grammarAccess.getMetamodelFieldAccess().getTypeNameCreatedAtKeyword_0_16());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_17, null);
                    				

                    }
                    break;
                case 18 :
                    // InternalQueryDsl.g:3310:5: lv_typeName_0_18= 'updatedAt'
                    {
                    lv_typeName_0_18=(Token)match(input,77,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_18, grammarAccess.getMetamodelFieldAccess().getTypeNameUpdatedAtKeyword_0_17());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetamodelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_18, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetamodelField"


    // $ANTLR start "entryRuleModelField"
    // InternalQueryDsl.g:3326:1: entryRuleModelField returns [EObject current=null] : iv_ruleModelField= ruleModelField EOF ;
    public final EObject entryRuleModelField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelField = null;


        try {
            // InternalQueryDsl.g:3326:51: (iv_ruleModelField= ruleModelField EOF )
            // InternalQueryDsl.g:3327:2: iv_ruleModelField= ruleModelField EOF
            {
             newCompositeNode(grammarAccess.getModelFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModelField=ruleModelField();

            state._fsp--;

             current =iv_ruleModelField; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModelField"


    // $ANTLR start "ruleModelField"
    // InternalQueryDsl.g:3333:1: ruleModelField returns [EObject current=null] : ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'metamodel' | lv_typeName_0_8= 'name' | lv_typeName_0_9= 'project' | lv_typeName_0_10= 'size' | lv_typeName_0_11= 'storageUrl' | lv_typeName_0_12= 'type' | lv_typeName_0_13= 'unique_name' | lv_typeName_0_14= 'createdAt' | lv_typeName_0_15= 'updatedAt' ) ) ) ;
    public final EObject ruleModelField() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;
        Token lv_typeName_0_5=null;
        Token lv_typeName_0_6=null;
        Token lv_typeName_0_7=null;
        Token lv_typeName_0_8=null;
        Token lv_typeName_0_9=null;
        Token lv_typeName_0_10=null;
        Token lv_typeName_0_11=null;
        Token lv_typeName_0_12=null;
        Token lv_typeName_0_13=null;
        Token lv_typeName_0_14=null;
        Token lv_typeName_0_15=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:3339:2: ( ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'metamodel' | lv_typeName_0_8= 'name' | lv_typeName_0_9= 'project' | lv_typeName_0_10= 'size' | lv_typeName_0_11= 'storageUrl' | lv_typeName_0_12= 'type' | lv_typeName_0_13= 'unique_name' | lv_typeName_0_14= 'createdAt' | lv_typeName_0_15= 'updatedAt' ) ) ) )
            // InternalQueryDsl.g:3340:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'metamodel' | lv_typeName_0_8= 'name' | lv_typeName_0_9= 'project' | lv_typeName_0_10= 'size' | lv_typeName_0_11= 'storageUrl' | lv_typeName_0_12= 'type' | lv_typeName_0_13= 'unique_name' | lv_typeName_0_14= 'createdAt' | lv_typeName_0_15= 'updatedAt' ) ) )
            {
            // InternalQueryDsl.g:3340:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'metamodel' | lv_typeName_0_8= 'name' | lv_typeName_0_9= 'project' | lv_typeName_0_10= 'size' | lv_typeName_0_11= 'storageUrl' | lv_typeName_0_12= 'type' | lv_typeName_0_13= 'unique_name' | lv_typeName_0_14= 'createdAt' | lv_typeName_0_15= 'updatedAt' ) ) )
            // InternalQueryDsl.g:3341:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'metamodel' | lv_typeName_0_8= 'name' | lv_typeName_0_9= 'project' | lv_typeName_0_10= 'size' | lv_typeName_0_11= 'storageUrl' | lv_typeName_0_12= 'type' | lv_typeName_0_13= 'unique_name' | lv_typeName_0_14= 'createdAt' | lv_typeName_0_15= 'updatedAt' ) )
            {
            // InternalQueryDsl.g:3341:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'metamodel' | lv_typeName_0_8= 'name' | lv_typeName_0_9= 'project' | lv_typeName_0_10= 'size' | lv_typeName_0_11= 'storageUrl' | lv_typeName_0_12= 'type' | lv_typeName_0_13= 'unique_name' | lv_typeName_0_14= 'createdAt' | lv_typeName_0_15= 'updatedAt' ) )
            // InternalQueryDsl.g:3342:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'metamodel' | lv_typeName_0_8= 'name' | lv_typeName_0_9= 'project' | lv_typeName_0_10= 'size' | lv_typeName_0_11= 'storageUrl' | lv_typeName_0_12= 'type' | lv_typeName_0_13= 'unique_name' | lv_typeName_0_14= 'createdAt' | lv_typeName_0_15= 'updatedAt' )
            {
            // InternalQueryDsl.g:3342:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'metamodel' | lv_typeName_0_8= 'name' | lv_typeName_0_9= 'project' | lv_typeName_0_10= 'size' | lv_typeName_0_11= 'storageUrl' | lv_typeName_0_12= 'type' | lv_typeName_0_13= 'unique_name' | lv_typeName_0_14= 'createdAt' | lv_typeName_0_15= 'updatedAt' )
            int alt37=15;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt37=1;
                }
                break;
            case 85:
                {
                alt37=2;
                }
                break;
            case 78:
                {
                alt37=3;
                }
                break;
            case 87:
                {
                alt37=4;
                }
                break;
            case 88:
                {
                alt37=5;
                }
                break;
            case 91:
                {
                alt37=6;
                }
                break;
            case 92:
                {
                alt37=7;
                }
                break;
            case 37:
                {
                alt37=8;
                }
                break;
            case 93:
                {
                alt37=9;
                }
                break;
            case 64:
                {
                alt37=10;
                }
                break;
            case 94:
                {
                alt37=11;
                }
                break;
            case 27:
                {
                alt37=12;
                }
                break;
            case 95:
                {
                alt37=13;
                }
                break;
            case 76:
                {
                alt37=14;
                }
                break;
            case 77:
                {
                alt37=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalQueryDsl.g:3343:5: lv_typeName_0_1= 'id'
                    {
                    lv_typeName_0_1=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getModelFieldAccess().getTypeNameIdKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3354:5: lv_typeName_0_2= 'accessControl'
                    {
                    lv_typeName_0_2=(Token)match(input,85,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getModelFieldAccess().getTypeNameAccessControlKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:3365:5: lv_typeName_0_3= 'description'
                    {
                    lv_typeName_0_3=(Token)match(input,78,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_3, grammarAccess.getModelFieldAccess().getTypeNameDescriptionKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:3376:5: lv_typeName_0_4= 'ext'
                    {
                    lv_typeName_0_4=(Token)match(input,87,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_4, grammarAccess.getModelFieldAccess().getTypeNameExtKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:3387:5: lv_typeName_0_5= 'involvedOperations'
                    {
                    lv_typeName_0_5=(Token)match(input,88,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_5, grammarAccess.getModelFieldAccess().getTypeNameInvolvedOperationsKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:3398:5: lv_typeName_0_6= 'license'
                    {
                    lv_typeName_0_6=(Token)match(input,91,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_6, grammarAccess.getModelFieldAccess().getTypeNameLicenseKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_6, null);
                    				

                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:3409:5: lv_typeName_0_7= 'metamodel'
                    {
                    lv_typeName_0_7=(Token)match(input,92,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_7, grammarAccess.getModelFieldAccess().getTypeNameMetamodelKeyword_0_6());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_7, null);
                    				

                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:3420:5: lv_typeName_0_8= 'name'
                    {
                    lv_typeName_0_8=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_8, grammarAccess.getModelFieldAccess().getTypeNameNameKeyword_0_7());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_8, null);
                    				

                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:3431:5: lv_typeName_0_9= 'project'
                    {
                    lv_typeName_0_9=(Token)match(input,93,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_9, grammarAccess.getModelFieldAccess().getTypeNameProjectKeyword_0_8());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_9, null);
                    				

                    }
                    break;
                case 10 :
                    // InternalQueryDsl.g:3442:5: lv_typeName_0_10= 'size'
                    {
                    lv_typeName_0_10=(Token)match(input,64,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_10, grammarAccess.getModelFieldAccess().getTypeNameSizeKeyword_0_9());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_10, null);
                    				

                    }
                    break;
                case 11 :
                    // InternalQueryDsl.g:3453:5: lv_typeName_0_11= 'storageUrl'
                    {
                    lv_typeName_0_11=(Token)match(input,94,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_11, grammarAccess.getModelFieldAccess().getTypeNameStorageUrlKeyword_0_10());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_11, null);
                    				

                    }
                    break;
                case 12 :
                    // InternalQueryDsl.g:3464:5: lv_typeName_0_12= 'type'
                    {
                    lv_typeName_0_12=(Token)match(input,27,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_12, grammarAccess.getModelFieldAccess().getTypeNameTypeKeyword_0_11());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_12, null);
                    				

                    }
                    break;
                case 13 :
                    // InternalQueryDsl.g:3475:5: lv_typeName_0_13= 'unique_name'
                    {
                    lv_typeName_0_13=(Token)match(input,95,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_13, grammarAccess.getModelFieldAccess().getTypeNameUnique_nameKeyword_0_12());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_13, null);
                    				

                    }
                    break;
                case 14 :
                    // InternalQueryDsl.g:3486:5: lv_typeName_0_14= 'createdAt'
                    {
                    lv_typeName_0_14=(Token)match(input,76,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_14, grammarAccess.getModelFieldAccess().getTypeNameCreatedAtKeyword_0_13());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_14, null);
                    				

                    }
                    break;
                case 15 :
                    // InternalQueryDsl.g:3497:5: lv_typeName_0_15= 'updatedAt'
                    {
                    lv_typeName_0_15=(Token)match(input,77,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_15, grammarAccess.getModelFieldAccess().getTypeNameUpdatedAtKeyword_0_14());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_15, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelField"


    // $ANTLR start "entryRuleDslField"
    // InternalQueryDsl.g:3513:1: entryRuleDslField returns [EObject current=null] : iv_ruleDslField= ruleDslField EOF ;
    public final EObject entryRuleDslField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDslField = null;


        try {
            // InternalQueryDsl.g:3513:49: (iv_ruleDslField= ruleDslField EOF )
            // InternalQueryDsl.g:3514:2: iv_ruleDslField= ruleDslField EOF
            {
             newCompositeNode(grammarAccess.getDslFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDslField=ruleDslField();

            state._fsp--;

             current =iv_ruleDslField; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDslField"


    // $ANTLR start "ruleDslField"
    // InternalQueryDsl.g:3520:1: ruleDslField returns [EObject current=null] : ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'name' | lv_typeName_0_8= 'project' | lv_typeName_0_9= 'size' | lv_typeName_0_10= 'storageUrl' | lv_typeName_0_11= 'type' | lv_typeName_0_12= 'unique_name' | lv_typeName_0_13= 'createdAt' | lv_typeName_0_14= 'updatedAt' ) ) ) ;
    public final EObject ruleDslField() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;
        Token lv_typeName_0_5=null;
        Token lv_typeName_0_6=null;
        Token lv_typeName_0_7=null;
        Token lv_typeName_0_8=null;
        Token lv_typeName_0_9=null;
        Token lv_typeName_0_10=null;
        Token lv_typeName_0_11=null;
        Token lv_typeName_0_12=null;
        Token lv_typeName_0_13=null;
        Token lv_typeName_0_14=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:3526:2: ( ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'name' | lv_typeName_0_8= 'project' | lv_typeName_0_9= 'size' | lv_typeName_0_10= 'storageUrl' | lv_typeName_0_11= 'type' | lv_typeName_0_12= 'unique_name' | lv_typeName_0_13= 'createdAt' | lv_typeName_0_14= 'updatedAt' ) ) ) )
            // InternalQueryDsl.g:3527:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'name' | lv_typeName_0_8= 'project' | lv_typeName_0_9= 'size' | lv_typeName_0_10= 'storageUrl' | lv_typeName_0_11= 'type' | lv_typeName_0_12= 'unique_name' | lv_typeName_0_13= 'createdAt' | lv_typeName_0_14= 'updatedAt' ) ) )
            {
            // InternalQueryDsl.g:3527:2: ( ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'name' | lv_typeName_0_8= 'project' | lv_typeName_0_9= 'size' | lv_typeName_0_10= 'storageUrl' | lv_typeName_0_11= 'type' | lv_typeName_0_12= 'unique_name' | lv_typeName_0_13= 'createdAt' | lv_typeName_0_14= 'updatedAt' ) ) )
            // InternalQueryDsl.g:3528:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'name' | lv_typeName_0_8= 'project' | lv_typeName_0_9= 'size' | lv_typeName_0_10= 'storageUrl' | lv_typeName_0_11= 'type' | lv_typeName_0_12= 'unique_name' | lv_typeName_0_13= 'createdAt' | lv_typeName_0_14= 'updatedAt' ) )
            {
            // InternalQueryDsl.g:3528:3: ( (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'name' | lv_typeName_0_8= 'project' | lv_typeName_0_9= 'size' | lv_typeName_0_10= 'storageUrl' | lv_typeName_0_11= 'type' | lv_typeName_0_12= 'unique_name' | lv_typeName_0_13= 'createdAt' | lv_typeName_0_14= 'updatedAt' ) )
            // InternalQueryDsl.g:3529:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'name' | lv_typeName_0_8= 'project' | lv_typeName_0_9= 'size' | lv_typeName_0_10= 'storageUrl' | lv_typeName_0_11= 'type' | lv_typeName_0_12= 'unique_name' | lv_typeName_0_13= 'createdAt' | lv_typeName_0_14= 'updatedAt' )
            {
            // InternalQueryDsl.g:3529:4: (lv_typeName_0_1= 'id' | lv_typeName_0_2= 'accessControl' | lv_typeName_0_3= 'description' | lv_typeName_0_4= 'ext' | lv_typeName_0_5= 'involvedOperations' | lv_typeName_0_6= 'license' | lv_typeName_0_7= 'name' | lv_typeName_0_8= 'project' | lv_typeName_0_9= 'size' | lv_typeName_0_10= 'storageUrl' | lv_typeName_0_11= 'type' | lv_typeName_0_12= 'unique_name' | lv_typeName_0_13= 'createdAt' | lv_typeName_0_14= 'updatedAt' )
            int alt38=14;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt38=1;
                }
                break;
            case 85:
                {
                alt38=2;
                }
                break;
            case 78:
                {
                alt38=3;
                }
                break;
            case 87:
                {
                alt38=4;
                }
                break;
            case 88:
                {
                alt38=5;
                }
                break;
            case 91:
                {
                alt38=6;
                }
                break;
            case 37:
                {
                alt38=7;
                }
                break;
            case 93:
                {
                alt38=8;
                }
                break;
            case 64:
                {
                alt38=9;
                }
                break;
            case 94:
                {
                alt38=10;
                }
                break;
            case 27:
                {
                alt38=11;
                }
                break;
            case 95:
                {
                alt38=12;
                }
                break;
            case 76:
                {
                alt38=13;
                }
                break;
            case 77:
                {
                alt38=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalQueryDsl.g:3530:5: lv_typeName_0_1= 'id'
                    {
                    lv_typeName_0_1=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getDslFieldAccess().getTypeNameIdKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3541:5: lv_typeName_0_2= 'accessControl'
                    {
                    lv_typeName_0_2=(Token)match(input,85,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getDslFieldAccess().getTypeNameAccessControlKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:3552:5: lv_typeName_0_3= 'description'
                    {
                    lv_typeName_0_3=(Token)match(input,78,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_3, grammarAccess.getDslFieldAccess().getTypeNameDescriptionKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:3563:5: lv_typeName_0_4= 'ext'
                    {
                    lv_typeName_0_4=(Token)match(input,87,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_4, grammarAccess.getDslFieldAccess().getTypeNameExtKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:3574:5: lv_typeName_0_5= 'involvedOperations'
                    {
                    lv_typeName_0_5=(Token)match(input,88,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_5, grammarAccess.getDslFieldAccess().getTypeNameInvolvedOperationsKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:3585:5: lv_typeName_0_6= 'license'
                    {
                    lv_typeName_0_6=(Token)match(input,91,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_6, grammarAccess.getDslFieldAccess().getTypeNameLicenseKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_6, null);
                    				

                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:3596:5: lv_typeName_0_7= 'name'
                    {
                    lv_typeName_0_7=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_7, grammarAccess.getDslFieldAccess().getTypeNameNameKeyword_0_6());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_7, null);
                    				

                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:3607:5: lv_typeName_0_8= 'project'
                    {
                    lv_typeName_0_8=(Token)match(input,93,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_8, grammarAccess.getDslFieldAccess().getTypeNameProjectKeyword_0_7());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_8, null);
                    				

                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:3618:5: lv_typeName_0_9= 'size'
                    {
                    lv_typeName_0_9=(Token)match(input,64,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_9, grammarAccess.getDslFieldAccess().getTypeNameSizeKeyword_0_8());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_9, null);
                    				

                    }
                    break;
                case 10 :
                    // InternalQueryDsl.g:3629:5: lv_typeName_0_10= 'storageUrl'
                    {
                    lv_typeName_0_10=(Token)match(input,94,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_10, grammarAccess.getDslFieldAccess().getTypeNameStorageUrlKeyword_0_9());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_10, null);
                    				

                    }
                    break;
                case 11 :
                    // InternalQueryDsl.g:3640:5: lv_typeName_0_11= 'type'
                    {
                    lv_typeName_0_11=(Token)match(input,27,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_11, grammarAccess.getDslFieldAccess().getTypeNameTypeKeyword_0_10());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_11, null);
                    				

                    }
                    break;
                case 12 :
                    // InternalQueryDsl.g:3651:5: lv_typeName_0_12= 'unique_name'
                    {
                    lv_typeName_0_12=(Token)match(input,95,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_12, grammarAccess.getDslFieldAccess().getTypeNameUnique_nameKeyword_0_11());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_12, null);
                    				

                    }
                    break;
                case 13 :
                    // InternalQueryDsl.g:3662:5: lv_typeName_0_13= 'createdAt'
                    {
                    lv_typeName_0_13=(Token)match(input,76,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_13, grammarAccess.getDslFieldAccess().getTypeNameCreatedAtKeyword_0_12());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_13, null);
                    				

                    }
                    break;
                case 14 :
                    // InternalQueryDsl.g:3673:5: lv_typeName_0_14= 'updatedAt'
                    {
                    lv_typeName_0_14=(Token)match(input,77,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_14, grammarAccess.getDslFieldAccess().getTypeNameUpdatedAtKeyword_0_13());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDslFieldRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_14, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDslField"


    // $ANTLR start "entryRuleUserParam"
    // InternalQueryDsl.g:3689:1: entryRuleUserParam returns [EObject current=null] : iv_ruleUserParam= ruleUserParam EOF ;
    public final EObject entryRuleUserParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserParam = null;


        try {
            // InternalQueryDsl.g:3689:50: (iv_ruleUserParam= ruleUserParam EOF )
            // InternalQueryDsl.g:3690:2: iv_ruleUserParam= ruleUserParam EOF
            {
             newCompositeNode(grammarAccess.getUserParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUserParam=ruleUserParam();

            state._fsp--;

             current =iv_ruleUserParam; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUserParam"


    // $ANTLR start "ruleUserParam"
    // InternalQueryDsl.g:3696:1: ruleUserParam returns [EObject current=null] : ( ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'email' ) ) ) ;
    public final EObject ruleUserParam() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:3702:2: ( ( ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'email' ) ) ) )
            // InternalQueryDsl.g:3703:2: ( ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'email' ) ) )
            {
            // InternalQueryDsl.g:3703:2: ( ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'email' ) ) )
            // InternalQueryDsl.g:3704:3: ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'email' ) )
            {
            // InternalQueryDsl.g:3704:3: ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'email' ) )
            // InternalQueryDsl.g:3705:4: (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'email' )
            {
            // InternalQueryDsl.g:3705:4: (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'email' )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt39=1;
                }
                break;
            case 96:
                {
                alt39=2;
                }
                break;
            case 75:
                {
                alt39=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalQueryDsl.g:3706:5: lv_typeName_0_1= 'username'
                    {
                    lv_typeName_0_1=(Token)match(input,74,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getUserParamAccess().getTypeNameUsernameKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUserParamRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3717:5: lv_typeName_0_2= 'userId'
                    {
                    lv_typeName_0_2=(Token)match(input,96,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getUserParamAccess().getTypeNameUserIdKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUserParamRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:3728:5: lv_typeName_0_3= 'email'
                    {
                    lv_typeName_0_3=(Token)match(input,75,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_3, grammarAccess.getUserParamAccess().getTypeNameEmailKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUserParamRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUserParam"


    // $ANTLR start "entryRuleWorkspaceParam"
    // InternalQueryDsl.g:3744:1: entryRuleWorkspaceParam returns [EObject current=null] : iv_ruleWorkspaceParam= ruleWorkspaceParam EOF ;
    public final EObject entryRuleWorkspaceParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkspaceParam = null;


        try {
            // InternalQueryDsl.g:3744:55: (iv_ruleWorkspaceParam= ruleWorkspaceParam EOF )
            // InternalQueryDsl.g:3745:2: iv_ruleWorkspaceParam= ruleWorkspaceParam EOF
            {
             newCompositeNode(grammarAccess.getWorkspaceParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkspaceParam=ruleWorkspaceParam();

            state._fsp--;

             current =iv_ruleWorkspaceParam; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleWorkspaceParam"


    // $ANTLR start "ruleWorkspaceParam"
    // InternalQueryDsl.g:3751:1: ruleWorkspaceParam returns [EObject current=null] : ( ( (lv_typeName_0_1= 'owner' | lv_typeName_0_2= 'workspaceId' ) ) ) ;
    public final EObject ruleWorkspaceParam() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:3757:2: ( ( ( (lv_typeName_0_1= 'owner' | lv_typeName_0_2= 'workspaceId' ) ) ) )
            // InternalQueryDsl.g:3758:2: ( ( (lv_typeName_0_1= 'owner' | lv_typeName_0_2= 'workspaceId' ) ) )
            {
            // InternalQueryDsl.g:3758:2: ( ( (lv_typeName_0_1= 'owner' | lv_typeName_0_2= 'workspaceId' ) ) )
            // InternalQueryDsl.g:3759:3: ( (lv_typeName_0_1= 'owner' | lv_typeName_0_2= 'workspaceId' ) )
            {
            // InternalQueryDsl.g:3759:3: ( (lv_typeName_0_1= 'owner' | lv_typeName_0_2= 'workspaceId' ) )
            // InternalQueryDsl.g:3760:4: (lv_typeName_0_1= 'owner' | lv_typeName_0_2= 'workspaceId' )
            {
            // InternalQueryDsl.g:3760:4: (lv_typeName_0_1= 'owner' | lv_typeName_0_2= 'workspaceId' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==79) ) {
                alt40=1;
            }
            else if ( (LA40_0==97) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalQueryDsl.g:3761:5: lv_typeName_0_1= 'owner'
                    {
                    lv_typeName_0_1=(Token)match(input,79,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getWorkspaceParamAccess().getTypeNameOwnerKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkspaceParamRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3772:5: lv_typeName_0_2= 'workspaceId'
                    {
                    lv_typeName_0_2=(Token)match(input,97,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getWorkspaceParamAccess().getTypeNameWorkspaceIdKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkspaceParamRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkspaceParam"


    // $ANTLR start "entryRuleProjectParam"
    // InternalQueryDsl.g:3788:1: entryRuleProjectParam returns [EObject current=null] : iv_ruleProjectParam= ruleProjectParam EOF ;
    public final EObject entryRuleProjectParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectParam = null;


        try {
            // InternalQueryDsl.g:3788:53: (iv_ruleProjectParam= ruleProjectParam EOF )
            // InternalQueryDsl.g:3789:2: iv_ruleProjectParam= ruleProjectParam EOF
            {
             newCompositeNode(grammarAccess.getProjectParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProjectParam=ruleProjectParam();

            state._fsp--;

             current =iv_ruleProjectParam; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleProjectParam"


    // $ANTLR start "ruleProjectParam"
    // InternalQueryDsl.g:3795:1: ruleProjectParam returns [EObject current=null] : ( ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'workspaceId' | lv_typeName_0_4= 'projectId' ) ) ) ;
    public final EObject ruleProjectParam() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:3801:2: ( ( ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'workspaceId' | lv_typeName_0_4= 'projectId' ) ) ) )
            // InternalQueryDsl.g:3802:2: ( ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'workspaceId' | lv_typeName_0_4= 'projectId' ) ) )
            {
            // InternalQueryDsl.g:3802:2: ( ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'workspaceId' | lv_typeName_0_4= 'projectId' ) ) )
            // InternalQueryDsl.g:3803:3: ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'workspaceId' | lv_typeName_0_4= 'projectId' ) )
            {
            // InternalQueryDsl.g:3803:3: ( (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'workspaceId' | lv_typeName_0_4= 'projectId' ) )
            // InternalQueryDsl.g:3804:4: (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'workspaceId' | lv_typeName_0_4= 'projectId' )
            {
            // InternalQueryDsl.g:3804:4: (lv_typeName_0_1= 'username' | lv_typeName_0_2= 'userId' | lv_typeName_0_3= 'workspaceId' | lv_typeName_0_4= 'projectId' )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt41=1;
                }
                break;
            case 96:
                {
                alt41=2;
                }
                break;
            case 97:
                {
                alt41=3;
                }
                break;
            case 98:
                {
                alt41=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalQueryDsl.g:3805:5: lv_typeName_0_1= 'username'
                    {
                    lv_typeName_0_1=(Token)match(input,74,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_1, grammarAccess.getProjectParamAccess().getTypeNameUsernameKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectParamRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3816:5: lv_typeName_0_2= 'userId'
                    {
                    lv_typeName_0_2=(Token)match(input,96,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_2, grammarAccess.getProjectParamAccess().getTypeNameUserIdKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectParamRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:3827:5: lv_typeName_0_3= 'workspaceId'
                    {
                    lv_typeName_0_3=(Token)match(input,97,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_3, grammarAccess.getProjectParamAccess().getTypeNameWorkspaceIdKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectParamRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:3838:5: lv_typeName_0_4= 'projectId'
                    {
                    lv_typeName_0_4=(Token)match(input,98,FOLLOW_2); 

                    					newLeafNode(lv_typeName_0_4, grammarAccess.getProjectParamAccess().getTypeNameProjectIdKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProjectParamRule());
                    					}
                    					setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectParam"


    // $ANTLR start "entryRuleMetamodelParam"
    // InternalQueryDsl.g:3854:1: entryRuleMetamodelParam returns [String current=null] : iv_ruleMetamodelParam= ruleMetamodelParam EOF ;
    public final String entryRuleMetamodelParam() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMetamodelParam = null;


        try {
            // InternalQueryDsl.g:3854:54: (iv_ruleMetamodelParam= ruleMetamodelParam EOF )
            // InternalQueryDsl.g:3855:2: iv_ruleMetamodelParam= ruleMetamodelParam EOF
            {
             newCompositeNode(grammarAccess.getMetamodelParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetamodelParam=ruleMetamodelParam();

            state._fsp--;

             current =iv_ruleMetamodelParam.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMetamodelParam"


    // $ANTLR start "ruleMetamodelParam"
    // InternalQueryDsl.g:3861:1: ruleMetamodelParam returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MetaParam_0= ruleMetaParam | this_Param_1= ruleParam ) ;
    public final AntlrDatatypeRuleToken ruleMetamodelParam() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_MetaParam_0 = null;

        AntlrDatatypeRuleToken this_Param_1 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:3867:2: ( (this_MetaParam_0= ruleMetaParam | this_Param_1= ruleParam ) )
            // InternalQueryDsl.g:3868:2: (this_MetaParam_0= ruleMetaParam | this_Param_1= ruleParam )
            {
            // InternalQueryDsl.g:3868:2: (this_MetaParam_0= ruleMetaParam | this_Param_1= ruleParam )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=99 && LA42_0<=104)) ) {
                alt42=1;
            }
            else if ( ((LA42_0>=36 && LA42_0<=37)||LA42_0==64||LA42_0==78||LA42_0==85||LA42_0==93||(LA42_0>=105 && LA42_0<=107)) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalQueryDsl.g:3869:3: this_MetaParam_0= ruleMetaParam
                    {

                    			newCompositeNode(grammarAccess.getMetamodelParamAccess().getMetaParamParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MetaParam_0=ruleMetaParam();

                    state._fsp--;


                    			current.merge(this_MetaParam_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3880:3: this_Param_1= ruleParam
                    {

                    			newCompositeNode(grammarAccess.getMetamodelParamAccess().getParamParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Param_1=ruleParam();

                    state._fsp--;


                    			current.merge(this_Param_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetamodelParam"


    // $ANTLR start "entryRuleMetaParam"
    // InternalQueryDsl.g:3894:1: entryRuleMetaParam returns [String current=null] : iv_ruleMetaParam= ruleMetaParam EOF ;
    public final String entryRuleMetaParam() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMetaParam = null;


        try {
            // InternalQueryDsl.g:3894:49: (iv_ruleMetaParam= ruleMetaParam EOF )
            // InternalQueryDsl.g:3895:2: iv_ruleMetaParam= ruleMetaParam EOF
            {
             newCompositeNode(grammarAccess.getMetaParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetaParam=ruleMetaParam();

            state._fsp--;

             current =iv_ruleMetaParam.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMetaParam"


    // $ANTLR start "ruleMetaParam"
    // InternalQueryDsl.g:3901:1: ruleMetaParam returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'eClassifier' | kw= 'ePackageName' | kw= 'ePackageNsURI' | kw= 'ePackageNsPrefix' | kw= 'quality-metric' | kw= 'model' ) ;
    public final AntlrDatatypeRuleToken ruleMetaParam() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:3907:2: ( (kw= 'eClassifier' | kw= 'ePackageName' | kw= 'ePackageNsURI' | kw= 'ePackageNsPrefix' | kw= 'quality-metric' | kw= 'model' ) )
            // InternalQueryDsl.g:3908:2: (kw= 'eClassifier' | kw= 'ePackageName' | kw= 'ePackageNsURI' | kw= 'ePackageNsPrefix' | kw= 'quality-metric' | kw= 'model' )
            {
            // InternalQueryDsl.g:3908:2: (kw= 'eClassifier' | kw= 'ePackageName' | kw= 'ePackageNsURI' | kw= 'ePackageNsPrefix' | kw= 'quality-metric' | kw= 'model' )
            int alt43=6;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt43=1;
                }
                break;
            case 100:
                {
                alt43=2;
                }
                break;
            case 101:
                {
                alt43=3;
                }
                break;
            case 102:
                {
                alt43=4;
                }
                break;
            case 103:
                {
                alt43=5;
                }
                break;
            case 104:
                {
                alt43=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalQueryDsl.g:3909:3: kw= 'eClassifier'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMetaParamAccess().getEClassifierKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3915:3: kw= 'ePackageName'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMetaParamAccess().getEPackageNameKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:3921:3: kw= 'ePackageNsURI'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMetaParamAccess().getEPackageNsURIKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:3927:3: kw= 'ePackageNsPrefix'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMetaParamAccess().getEPackageNsPrefixKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:3933:3: kw= 'quality-metric'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMetaParamAccess().getQualityMetricKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:3939:3: kw= 'model'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMetaParamAccess().getModelKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetaParam"


    // $ANTLR start "entryRuleParam"
    // InternalQueryDsl.g:3948:1: entryRuleParam returns [String current=null] : iv_ruleParam= ruleParam EOF ;
    public final String entryRuleParam() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleParam = null;


        try {
            // InternalQueryDsl.g:3948:45: (iv_ruleParam= ruleParam EOF )
            // InternalQueryDsl.g:3949:2: iv_ruleParam= ruleParam EOF
            {
             newCompositeNode(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParam=ruleParam();

            state._fsp--;

             current =iv_ruleParam.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // InternalQueryDsl.g:3955:1: ruleParam returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'id' | kw= 'accessControl' | kw= 'description' | kw= 'extension' | kw= 'operation' | kw= 'name' | kw= 'unique-name' | kw= 'project' | kw= 'size' ) ;
    public final AntlrDatatypeRuleToken ruleParam() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:3961:2: ( (kw= 'id' | kw= 'accessControl' | kw= 'description' | kw= 'extension' | kw= 'operation' | kw= 'name' | kw= 'unique-name' | kw= 'project' | kw= 'size' ) )
            // InternalQueryDsl.g:3962:2: (kw= 'id' | kw= 'accessControl' | kw= 'description' | kw= 'extension' | kw= 'operation' | kw= 'name' | kw= 'unique-name' | kw= 'project' | kw= 'size' )
            {
            // InternalQueryDsl.g:3962:2: (kw= 'id' | kw= 'accessControl' | kw= 'description' | kw= 'extension' | kw= 'operation' | kw= 'name' | kw= 'unique-name' | kw= 'project' | kw= 'size' )
            int alt44=9;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt44=1;
                }
                break;
            case 85:
                {
                alt44=2;
                }
                break;
            case 78:
                {
                alt44=3;
                }
                break;
            case 105:
                {
                alt44=4;
                }
                break;
            case 106:
                {
                alt44=5;
                }
                break;
            case 37:
                {
                alt44=6;
                }
                break;
            case 107:
                {
                alt44=7;
                }
                break;
            case 93:
                {
                alt44=8;
                }
                break;
            case 64:
                {
                alt44=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalQueryDsl.g:3963:3: kw= 'id'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getParamAccess().getIdKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:3969:3: kw= 'accessControl'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getParamAccess().getAccessControlKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:3975:3: kw= 'description'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getParamAccess().getDescriptionKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:3981:3: kw= 'extension'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getParamAccess().getExtensionKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:3987:3: kw= 'operation'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getParamAccess().getOperationKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:3993:3: kw= 'name'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getParamAccess().getNameKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:3999:3: kw= 'unique-name'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getParamAccess().getUniqueNameKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:4005:3: kw= 'project'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getParamAccess().getProjectKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:4011:3: kw= 'size'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getParamAccess().getSizeKeyword_8());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleVariable"
    // InternalQueryDsl.g:4020:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalQueryDsl.g:4020:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalQueryDsl.g:4021:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalQueryDsl.g:4027:1: ruleVariable returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalQueryDsl.g:4033:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // InternalQueryDsl.g:4034:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // InternalQueryDsl.g:4034:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            // InternalQueryDsl.g:4035:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,108,FOLLOW_46); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getVarKeyword_0());
            		
            // InternalQueryDsl.g:4039:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQueryDsl.g:4040:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQueryDsl.g:4040:4: (lv_name_1_0= RULE_ID )
            // InternalQueryDsl.g:4041:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,109,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getEqualsSignKeyword_2());
            		
            // InternalQueryDsl.g:4061:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalQueryDsl.g:4062:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalQueryDsl.g:4062:4: (lv_expression_3_0= ruleExpression )
            // InternalQueryDsl.g:4063:5: lv_expression_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getVariableAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"com.arsene.query.QueryDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleExpression"
    // InternalQueryDsl.g:4084:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalQueryDsl.g:4084:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalQueryDsl.g:4085:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalQueryDsl.g:4091:1: ruleExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_5_1=null;
        Token lv_value_5_2=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalQueryDsl.g:4097:2: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalQueryDsl.g:4098:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalQueryDsl.g:4098:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            int alt46=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt46=1;
                }
                break;
            case RULE_STRING:
                {
                alt46=2;
                }
                break;
            case 110:
            case 111:
                {
                alt46=3;
                }
                break;
            case RULE_ID:
                {
                alt46=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalQueryDsl.g:4099:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalQueryDsl.g:4099:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalQueryDsl.g:4100:4: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalQueryDsl.g:4100:4: ()
                    // InternalQueryDsl.g:4101:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getExpressionAccess().getIntConstantAction_0_0(),
                    						current);
                    				

                    }

                    // InternalQueryDsl.g:4107:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalQueryDsl.g:4108:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalQueryDsl.g:4108:5: (lv_value_1_0= RULE_INT )
                    // InternalQueryDsl.g:4109:6: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getExpressionAccess().getValueINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:4127:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    {
                    // InternalQueryDsl.g:4127:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    // InternalQueryDsl.g:4128:4: () ( (lv_value_3_0= RULE_STRING ) )
                    {
                    // InternalQueryDsl.g:4128:4: ()
                    // InternalQueryDsl.g:4129:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getExpressionAccess().getStringConstantAction_1_0(),
                    						current);
                    				

                    }

                    // InternalQueryDsl.g:4135:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalQueryDsl.g:4136:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalQueryDsl.g:4136:5: (lv_value_3_0= RULE_STRING )
                    // InternalQueryDsl.g:4137:6: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:4155:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    {
                    // InternalQueryDsl.g:4155:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    // InternalQueryDsl.g:4156:4: () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    {
                    // InternalQueryDsl.g:4156:4: ()
                    // InternalQueryDsl.g:4157:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getExpressionAccess().getBoolConstantAction_2_0(),
                    						current);
                    				

                    }

                    // InternalQueryDsl.g:4163:4: ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    // InternalQueryDsl.g:4164:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    {
                    // InternalQueryDsl.g:4164:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    // InternalQueryDsl.g:4165:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    {
                    // InternalQueryDsl.g:4165:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==110) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==111) ) {
                        alt45=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalQueryDsl.g:4166:7: lv_value_5_1= 'true'
                            {
                            lv_value_5_1=(Token)match(input,110,FOLLOW_2); 

                            							newLeafNode(lv_value_5_1, grammarAccess.getExpressionAccess().getValueTrueKeyword_2_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getExpressionRule());
                            							}
                            							setWithLastConsumed(current, "value", lv_value_5_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalQueryDsl.g:4177:7: lv_value_5_2= 'false'
                            {
                            lv_value_5_2=(Token)match(input,111,FOLLOW_2); 

                            							newLeafNode(lv_value_5_2, grammarAccess.getExpressionAccess().getValueFalseKeyword_2_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getExpressionRule());
                            							}
                            							setWithLastConsumed(current, "value", lv_value_5_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:4192:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalQueryDsl.g:4192:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    // InternalQueryDsl.g:4193:4: () ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalQueryDsl.g:4193:4: ()
                    // InternalQueryDsl.g:4194:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getExpressionAccess().getVariableRefAction_3_0(),
                    						current);
                    				

                    }

                    // InternalQueryDsl.g:4200:4: ( (otherlv_7= RULE_ID ) )
                    // InternalQueryDsl.g:4201:5: (otherlv_7= RULE_ID )
                    {
                    // InternalQueryDsl.g:4201:5: (otherlv_7= RULE_ID )
                    // InternalQueryDsl.g:4202:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExpressionRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_7, grammarAccess.getExpressionAccess().getVariableVariableCrossReference_3_1_0());
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L,0x0000100000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000C00L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000001000000000L,0x0000000000003C00L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000200008000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000003000000000L,0x000000000001F000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000700000400L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000003000000000L,0x00000000001E7000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000003000000000L,0x00000FF820204001L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x8000000C82000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000003008000000L,0x00000000FFE07001L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x8000000086000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000003008000000L,0x00000000F9A07001L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x8000000082000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000003008000000L,0x00000000E9A07001L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000070L,0x0000C00000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x7000000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0FFFFFC000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x7000000000008000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x000000000000003EL});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000004000L,0x00000000000003C0L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x00000000000003C0L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});

}