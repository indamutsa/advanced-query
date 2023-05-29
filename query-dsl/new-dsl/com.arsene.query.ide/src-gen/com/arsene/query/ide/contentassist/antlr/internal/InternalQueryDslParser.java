package com.arsene.query.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import com.arsene.query.services.QueryDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQueryDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'EOL'", "'OCL'", "'id'", "'name'", "'qa'", "'qb'", "'qc'", "'qd'", "'qe'", "'qf'", "'qg'", "'qh'", "'qi'", "'qj'", "'qk'", "'ql'", "'qm'", "'qn'", "'qo'", "'qp'", "'qq'", "'qr'", "'qs'", "'qt'", "'qu'", "'qv'", "'AND'", "'OR'", "'EXACT'", "'=='", "'>='", "'<='", "'<'", "'>'", "'gte'", "'lte'", "'lt'", "'gt'", "'username'", "'email'", "'createdAt'", "'updatedAt'", "'description'", "'owner'", "'projects'", "'user'", "'workspace'", "'sharedUser'", "'comments'", "'accessControl'", "'ePackage'", "'ext'", "'involvedOperations'", "'metrics'", "'models'", "'license'", "'metamodel'", "'project'", "'size'", "'storageUrl'", "'type'", "'unique_name'", "'userId'", "'workspaceId'", "'projectId'", "'eClassifier'", "'ePackageName'", "'ePackageNsURI'", "'ePackageNsPrefix'", "'quality-metric'", "'model'", "'extension'", "'operation'", "'unique-name'", "'true'", "'false'", "'Query'", "'User'", "'('", "')'", "'return'", "'['", "']'", "','", "'Workspace'", "'Project'", "'Metamodel'", "'=>'", "'Model'", "'Dsl'", "'microSyntax'", "'modelQuery'", "':'", "'fullTextSearch'", "'min_match'", "'operator'", "'qualityMetrics'", "'transformable'", "'filter'", "'var'", "'='"
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

    	public void setGrammarAccess(QueryDslGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleQueryModel"
    // InternalQueryDsl.g:53:1: entryRuleQueryModel : ruleQueryModel EOF ;
    public final void entryRuleQueryModel() throws RecognitionException {
        try {
            // InternalQueryDsl.g:54:1: ( ruleQueryModel EOF )
            // InternalQueryDsl.g:55:1: ruleQueryModel EOF
            {
             before(grammarAccess.getQueryModelRule()); 
            pushFollow(FOLLOW_1);
            ruleQueryModel();

            state._fsp--;

             after(grammarAccess.getQueryModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryModel"


    // $ANTLR start "ruleQueryModel"
    // InternalQueryDsl.g:62:1: ruleQueryModel : ( ( rule__QueryModel__ElementsAssignment )* ) ;
    public final void ruleQueryModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:66:2: ( ( ( rule__QueryModel__ElementsAssignment )* ) )
            // InternalQueryDsl.g:67:2: ( ( rule__QueryModel__ElementsAssignment )* )
            {
            // InternalQueryDsl.g:67:2: ( ( rule__QueryModel__ElementsAssignment )* )
            // InternalQueryDsl.g:68:3: ( rule__QueryModel__ElementsAssignment )*
            {
             before(grammarAccess.getQueryModelAccess().getElementsAssignment()); 
            // InternalQueryDsl.g:69:3: ( rule__QueryModel__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==87||LA1_0==110) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalQueryDsl.g:69:4: rule__QueryModel__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__QueryModel__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getQueryModelAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryModel"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalQueryDsl.g:78:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // InternalQueryDsl.g:79:1: ( ruleAbstractElement EOF )
            // InternalQueryDsl.g:80:1: ruleAbstractElement EOF
            {
             before(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getAbstractElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalQueryDsl.g:87:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:91:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // InternalQueryDsl.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            {
            // InternalQueryDsl.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            // InternalQueryDsl.g:93:3: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // InternalQueryDsl.g:94:3: ( rule__AbstractElement__Alternatives )
            // InternalQueryDsl.g:94:4: rule__AbstractElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AbstractElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleUser"
    // InternalQueryDsl.g:103:1: entryRuleUser : ruleUser EOF ;
    public final void entryRuleUser() throws RecognitionException {
        try {
            // InternalQueryDsl.g:104:1: ( ruleUser EOF )
            // InternalQueryDsl.g:105:1: ruleUser EOF
            {
             before(grammarAccess.getUserRule()); 
            pushFollow(FOLLOW_1);
            ruleUser();

            state._fsp--;

             after(grammarAccess.getUserRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUser"


    // $ANTLR start "ruleUser"
    // InternalQueryDsl.g:112:1: ruleUser : ( ( rule__User__Group__0 ) ) ;
    public final void ruleUser() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:116:2: ( ( ( rule__User__Group__0 ) ) )
            // InternalQueryDsl.g:117:2: ( ( rule__User__Group__0 ) )
            {
            // InternalQueryDsl.g:117:2: ( ( rule__User__Group__0 ) )
            // InternalQueryDsl.g:118:3: ( rule__User__Group__0 )
            {
             before(grammarAccess.getUserAccess().getGroup()); 
            // InternalQueryDsl.g:119:3: ( rule__User__Group__0 )
            // InternalQueryDsl.g:119:4: rule__User__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__User__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUser"


    // $ANTLR start "entryRuleWorkspace"
    // InternalQueryDsl.g:128:1: entryRuleWorkspace : ruleWorkspace EOF ;
    public final void entryRuleWorkspace() throws RecognitionException {
        try {
            // InternalQueryDsl.g:129:1: ( ruleWorkspace EOF )
            // InternalQueryDsl.g:130:1: ruleWorkspace EOF
            {
             before(grammarAccess.getWorkspaceRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkspace();

            state._fsp--;

             after(grammarAccess.getWorkspaceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkspace"


    // $ANTLR start "ruleWorkspace"
    // InternalQueryDsl.g:137:1: ruleWorkspace : ( ( rule__Workspace__Group__0 ) ) ;
    public final void ruleWorkspace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:141:2: ( ( ( rule__Workspace__Group__0 ) ) )
            // InternalQueryDsl.g:142:2: ( ( rule__Workspace__Group__0 ) )
            {
            // InternalQueryDsl.g:142:2: ( ( rule__Workspace__Group__0 ) )
            // InternalQueryDsl.g:143:3: ( rule__Workspace__Group__0 )
            {
             before(grammarAccess.getWorkspaceAccess().getGroup()); 
            // InternalQueryDsl.g:144:3: ( rule__Workspace__Group__0 )
            // InternalQueryDsl.g:144:4: rule__Workspace__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Workspace__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkspace"


    // $ANTLR start "entryRuleProject"
    // InternalQueryDsl.g:153:1: entryRuleProject : ruleProject EOF ;
    public final void entryRuleProject() throws RecognitionException {
        try {
            // InternalQueryDsl.g:154:1: ( ruleProject EOF )
            // InternalQueryDsl.g:155:1: ruleProject EOF
            {
             before(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            ruleProject();

            state._fsp--;

             after(grammarAccess.getProjectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalQueryDsl.g:162:1: ruleProject : ( ( rule__Project__Group__0 ) ) ;
    public final void ruleProject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:166:2: ( ( ( rule__Project__Group__0 ) ) )
            // InternalQueryDsl.g:167:2: ( ( rule__Project__Group__0 ) )
            {
            // InternalQueryDsl.g:167:2: ( ( rule__Project__Group__0 ) )
            // InternalQueryDsl.g:168:3: ( rule__Project__Group__0 )
            {
             before(grammarAccess.getProjectAccess().getGroup()); 
            // InternalQueryDsl.g:169:3: ( rule__Project__Group__0 )
            // InternalQueryDsl.g:169:4: rule__Project__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProjectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleMetamodel"
    // InternalQueryDsl.g:178:1: entryRuleMetamodel : ruleMetamodel EOF ;
    public final void entryRuleMetamodel() throws RecognitionException {
        try {
            // InternalQueryDsl.g:179:1: ( ruleMetamodel EOF )
            // InternalQueryDsl.g:180:1: ruleMetamodel EOF
            {
             before(grammarAccess.getMetamodelRule()); 
            pushFollow(FOLLOW_1);
            ruleMetamodel();

            state._fsp--;

             after(grammarAccess.getMetamodelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetamodel"


    // $ANTLR start "ruleMetamodel"
    // InternalQueryDsl.g:187:1: ruleMetamodel : ( ( rule__Metamodel__Group__0 ) ) ;
    public final void ruleMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:191:2: ( ( ( rule__Metamodel__Group__0 ) ) )
            // InternalQueryDsl.g:192:2: ( ( rule__Metamodel__Group__0 ) )
            {
            // InternalQueryDsl.g:192:2: ( ( rule__Metamodel__Group__0 ) )
            // InternalQueryDsl.g:193:3: ( rule__Metamodel__Group__0 )
            {
             before(grammarAccess.getMetamodelAccess().getGroup()); 
            // InternalQueryDsl.g:194:3: ( rule__Metamodel__Group__0 )
            // InternalQueryDsl.g:194:4: rule__Metamodel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetamodel"


    // $ANTLR start "entryRuleModel"
    // InternalQueryDsl.g:203:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalQueryDsl.g:204:1: ( ruleModel EOF )
            // InternalQueryDsl.g:205:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalQueryDsl.g:212:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:216:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalQueryDsl.g:217:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalQueryDsl.g:217:2: ( ( rule__Model__Group__0 ) )
            // InternalQueryDsl.g:218:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalQueryDsl.g:219:3: ( rule__Model__Group__0 )
            // InternalQueryDsl.g:219:4: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDsl"
    // InternalQueryDsl.g:228:1: entryRuleDsl : ruleDsl EOF ;
    public final void entryRuleDsl() throws RecognitionException {
        try {
            // InternalQueryDsl.g:229:1: ( ruleDsl EOF )
            // InternalQueryDsl.g:230:1: ruleDsl EOF
            {
             before(grammarAccess.getDslRule()); 
            pushFollow(FOLLOW_1);
            ruleDsl();

            state._fsp--;

             after(grammarAccess.getDslRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDsl"


    // $ANTLR start "ruleDsl"
    // InternalQueryDsl.g:237:1: ruleDsl : ( ( rule__Dsl__Group__0 ) ) ;
    public final void ruleDsl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:241:2: ( ( ( rule__Dsl__Group__0 ) ) )
            // InternalQueryDsl.g:242:2: ( ( rule__Dsl__Group__0 ) )
            {
            // InternalQueryDsl.g:242:2: ( ( rule__Dsl__Group__0 ) )
            // InternalQueryDsl.g:243:3: ( rule__Dsl__Group__0 )
            {
             before(grammarAccess.getDslAccess().getGroup()); 
            // InternalQueryDsl.g:244:3: ( rule__Dsl__Group__0 )
            // InternalQueryDsl.g:244:4: rule__Dsl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDslAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDsl"


    // $ANTLR start "entryRuleMicroSyntax"
    // InternalQueryDsl.g:253:1: entryRuleMicroSyntax : ruleMicroSyntax EOF ;
    public final void entryRuleMicroSyntax() throws RecognitionException {
        try {
            // InternalQueryDsl.g:254:1: ( ruleMicroSyntax EOF )
            // InternalQueryDsl.g:255:1: ruleMicroSyntax EOF
            {
             before(grammarAccess.getMicroSyntaxRule()); 
            pushFollow(FOLLOW_1);
            ruleMicroSyntax();

            state._fsp--;

             after(grammarAccess.getMicroSyntaxRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMicroSyntax"


    // $ANTLR start "ruleMicroSyntax"
    // InternalQueryDsl.g:262:1: ruleMicroSyntax : ( ( rule__MicroSyntax__Group__0 ) ) ;
    public final void ruleMicroSyntax() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:266:2: ( ( ( rule__MicroSyntax__Group__0 ) ) )
            // InternalQueryDsl.g:267:2: ( ( rule__MicroSyntax__Group__0 ) )
            {
            // InternalQueryDsl.g:267:2: ( ( rule__MicroSyntax__Group__0 ) )
            // InternalQueryDsl.g:268:3: ( rule__MicroSyntax__Group__0 )
            {
             before(grammarAccess.getMicroSyntaxAccess().getGroup()); 
            // InternalQueryDsl.g:269:3: ( rule__MicroSyntax__Group__0 )
            // InternalQueryDsl.g:269:4: rule__MicroSyntax__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MicroSyntax__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMicroSyntaxAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMicroSyntax"


    // $ANTLR start "entryRuleModelQuery"
    // InternalQueryDsl.g:278:1: entryRuleModelQuery : ruleModelQuery EOF ;
    public final void entryRuleModelQuery() throws RecognitionException {
        try {
            // InternalQueryDsl.g:279:1: ( ruleModelQuery EOF )
            // InternalQueryDsl.g:280:1: ruleModelQuery EOF
            {
             before(grammarAccess.getModelQueryRule()); 
            pushFollow(FOLLOW_1);
            ruleModelQuery();

            state._fsp--;

             after(grammarAccess.getModelQueryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelQuery"


    // $ANTLR start "ruleModelQuery"
    // InternalQueryDsl.g:287:1: ruleModelQuery : ( ( rule__ModelQuery__Group__0 ) ) ;
    public final void ruleModelQuery() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:291:2: ( ( ( rule__ModelQuery__Group__0 ) ) )
            // InternalQueryDsl.g:292:2: ( ( rule__ModelQuery__Group__0 ) )
            {
            // InternalQueryDsl.g:292:2: ( ( rule__ModelQuery__Group__0 ) )
            // InternalQueryDsl.g:293:3: ( rule__ModelQuery__Group__0 )
            {
             before(grammarAccess.getModelQueryAccess().getGroup()); 
            // InternalQueryDsl.g:294:3: ( rule__ModelQuery__Group__0 )
            // InternalQueryDsl.g:294:4: rule__ModelQuery__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ModelQuery__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelQueryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelQuery"


    // $ANTLR start "entryRuleQueryLang"
    // InternalQueryDsl.g:303:1: entryRuleQueryLang : ruleQueryLang EOF ;
    public final void entryRuleQueryLang() throws RecognitionException {
        try {
            // InternalQueryDsl.g:304:1: ( ruleQueryLang EOF )
            // InternalQueryDsl.g:305:1: ruleQueryLang EOF
            {
             before(grammarAccess.getQueryLangRule()); 
            pushFollow(FOLLOW_1);
            ruleQueryLang();

            state._fsp--;

             after(grammarAccess.getQueryLangRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryLang"


    // $ANTLR start "ruleQueryLang"
    // InternalQueryDsl.g:312:1: ruleQueryLang : ( ( rule__QueryLang__Alternatives ) ) ;
    public final void ruleQueryLang() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:316:2: ( ( ( rule__QueryLang__Alternatives ) ) )
            // InternalQueryDsl.g:317:2: ( ( rule__QueryLang__Alternatives ) )
            {
            // InternalQueryDsl.g:317:2: ( ( rule__QueryLang__Alternatives ) )
            // InternalQueryDsl.g:318:3: ( rule__QueryLang__Alternatives )
            {
             before(grammarAccess.getQueryLangAccess().getAlternatives()); 
            // InternalQueryDsl.g:319:3: ( rule__QueryLang__Alternatives )
            // InternalQueryDsl.g:319:4: rule__QueryLang__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__QueryLang__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getQueryLangAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryLang"


    // $ANTLR start "entryRuleFullTextSearch"
    // InternalQueryDsl.g:328:1: entryRuleFullTextSearch : ruleFullTextSearch EOF ;
    public final void entryRuleFullTextSearch() throws RecognitionException {
        try {
            // InternalQueryDsl.g:329:1: ( ruleFullTextSearch EOF )
            // InternalQueryDsl.g:330:1: ruleFullTextSearch EOF
            {
             before(grammarAccess.getFullTextSearchRule()); 
            pushFollow(FOLLOW_1);
            ruleFullTextSearch();

            state._fsp--;

             after(grammarAccess.getFullTextSearchRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFullTextSearch"


    // $ANTLR start "ruleFullTextSearch"
    // InternalQueryDsl.g:337:1: ruleFullTextSearch : ( ( rule__FullTextSearch__Group__0 ) ) ;
    public final void ruleFullTextSearch() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:341:2: ( ( ( rule__FullTextSearch__Group__0 ) ) )
            // InternalQueryDsl.g:342:2: ( ( rule__FullTextSearch__Group__0 ) )
            {
            // InternalQueryDsl.g:342:2: ( ( rule__FullTextSearch__Group__0 ) )
            // InternalQueryDsl.g:343:3: ( rule__FullTextSearch__Group__0 )
            {
             before(grammarAccess.getFullTextSearchAccess().getGroup()); 
            // InternalQueryDsl.g:344:3: ( rule__FullTextSearch__Group__0 )
            // InternalQueryDsl.g:344:4: rule__FullTextSearch__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFullTextSearchAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFullTextSearch"


    // $ANTLR start "entryRuleQualityMetric"
    // InternalQueryDsl.g:353:1: entryRuleQualityMetric : ruleQualityMetric EOF ;
    public final void entryRuleQualityMetric() throws RecognitionException {
        try {
            // InternalQueryDsl.g:354:1: ( ruleQualityMetric EOF )
            // InternalQueryDsl.g:355:1: ruleQualityMetric EOF
            {
             before(grammarAccess.getQualityMetricRule()); 
            pushFollow(FOLLOW_1);
            ruleQualityMetric();

            state._fsp--;

             after(grammarAccess.getQualityMetricRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualityMetric"


    // $ANTLR start "ruleQualityMetric"
    // InternalQueryDsl.g:362:1: ruleQualityMetric : ( ( rule__QualityMetric__Group__0 ) ) ;
    public final void ruleQualityMetric() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:366:2: ( ( ( rule__QualityMetric__Group__0 ) ) )
            // InternalQueryDsl.g:367:2: ( ( rule__QualityMetric__Group__0 ) )
            {
            // InternalQueryDsl.g:367:2: ( ( rule__QualityMetric__Group__0 ) )
            // InternalQueryDsl.g:368:3: ( rule__QualityMetric__Group__0 )
            {
             before(grammarAccess.getQualityMetricAccess().getGroup()); 
            // InternalQueryDsl.g:369:3: ( rule__QualityMetric__Group__0 )
            // InternalQueryDsl.g:369:4: rule__QualityMetric__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualityMetric__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualityMetricAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualityMetric"


    // $ANTLR start "entryRuleTransformable"
    // InternalQueryDsl.g:378:1: entryRuleTransformable : ruleTransformable EOF ;
    public final void entryRuleTransformable() throws RecognitionException {
        try {
            // InternalQueryDsl.g:379:1: ( ruleTransformable EOF )
            // InternalQueryDsl.g:380:1: ruleTransformable EOF
            {
             before(grammarAccess.getTransformableRule()); 
            pushFollow(FOLLOW_1);
            ruleTransformable();

            state._fsp--;

             after(grammarAccess.getTransformableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransformable"


    // $ANTLR start "ruleTransformable"
    // InternalQueryDsl.g:387:1: ruleTransformable : ( ( rule__Transformable__Group__0 ) ) ;
    public final void ruleTransformable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:391:2: ( ( ( rule__Transformable__Group__0 ) ) )
            // InternalQueryDsl.g:392:2: ( ( rule__Transformable__Group__0 ) )
            {
            // InternalQueryDsl.g:392:2: ( ( rule__Transformable__Group__0 ) )
            // InternalQueryDsl.g:393:3: ( rule__Transformable__Group__0 )
            {
             before(grammarAccess.getTransformableAccess().getGroup()); 
            // InternalQueryDsl.g:394:3: ( rule__Transformable__Group__0 )
            // InternalQueryDsl.g:394:4: rule__Transformable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Transformable__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransformableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransformable"


    // $ANTLR start "entryRuleTransParam"
    // InternalQueryDsl.g:403:1: entryRuleTransParam : ruleTransParam EOF ;
    public final void entryRuleTransParam() throws RecognitionException {
        try {
            // InternalQueryDsl.g:404:1: ( ruleTransParam EOF )
            // InternalQueryDsl.g:405:1: ruleTransParam EOF
            {
             before(grammarAccess.getTransParamRule()); 
            pushFollow(FOLLOW_1);
            ruleTransParam();

            state._fsp--;

             after(grammarAccess.getTransParamRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransParam"


    // $ANTLR start "ruleTransParam"
    // InternalQueryDsl.g:412:1: ruleTransParam : ( ( rule__TransParam__TypeAssignment ) ) ;
    public final void ruleTransParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:416:2: ( ( ( rule__TransParam__TypeAssignment ) ) )
            // InternalQueryDsl.g:417:2: ( ( rule__TransParam__TypeAssignment ) )
            {
            // InternalQueryDsl.g:417:2: ( ( rule__TransParam__TypeAssignment ) )
            // InternalQueryDsl.g:418:3: ( rule__TransParam__TypeAssignment )
            {
             before(grammarAccess.getTransParamAccess().getTypeAssignment()); 
            // InternalQueryDsl.g:419:3: ( rule__TransParam__TypeAssignment )
            // InternalQueryDsl.g:419:4: rule__TransParam__TypeAssignment
            {
            pushFollow(FOLLOW_2);
            rule__TransParam__TypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTransParamAccess().getTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransParam"


    // $ANTLR start "entryRuleQExp"
    // InternalQueryDsl.g:428:1: entryRuleQExp : ruleQExp EOF ;
    public final void entryRuleQExp() throws RecognitionException {
        try {
            // InternalQueryDsl.g:429:1: ( ruleQExp EOF )
            // InternalQueryDsl.g:430:1: ruleQExp EOF
            {
             before(grammarAccess.getQExpRule()); 
            pushFollow(FOLLOW_1);
            ruleQExp();

            state._fsp--;

             after(grammarAccess.getQExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQExp"


    // $ANTLR start "ruleQExp"
    // InternalQueryDsl.g:437:1: ruleQExp : ( ( rule__QExp__Group__0 ) ) ;
    public final void ruleQExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:441:2: ( ( ( rule__QExp__Group__0 ) ) )
            // InternalQueryDsl.g:442:2: ( ( rule__QExp__Group__0 ) )
            {
            // InternalQueryDsl.g:442:2: ( ( rule__QExp__Group__0 ) )
            // InternalQueryDsl.g:443:3: ( rule__QExp__Group__0 )
            {
             before(grammarAccess.getQExpAccess().getGroup()); 
            // InternalQueryDsl.g:444:3: ( rule__QExp__Group__0 )
            // InternalQueryDsl.g:444:4: rule__QExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQExp"


    // $ANTLR start "entryRuleQattribute"
    // InternalQueryDsl.g:453:1: entryRuleQattribute : ruleQattribute EOF ;
    public final void entryRuleQattribute() throws RecognitionException {
        try {
            // InternalQueryDsl.g:454:1: ( ruleQattribute EOF )
            // InternalQueryDsl.g:455:1: ruleQattribute EOF
            {
             before(grammarAccess.getQattributeRule()); 
            pushFollow(FOLLOW_1);
            ruleQattribute();

            state._fsp--;

             after(grammarAccess.getQattributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQattribute"


    // $ANTLR start "ruleQattribute"
    // InternalQueryDsl.g:462:1: ruleQattribute : ( ( rule__Qattribute__TypeAssignment ) ) ;
    public final void ruleQattribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:466:2: ( ( ( rule__Qattribute__TypeAssignment ) ) )
            // InternalQueryDsl.g:467:2: ( ( rule__Qattribute__TypeAssignment ) )
            {
            // InternalQueryDsl.g:467:2: ( ( rule__Qattribute__TypeAssignment ) )
            // InternalQueryDsl.g:468:3: ( rule__Qattribute__TypeAssignment )
            {
             before(grammarAccess.getQattributeAccess().getTypeAssignment()); 
            // InternalQueryDsl.g:469:3: ( rule__Qattribute__TypeAssignment )
            // InternalQueryDsl.g:469:4: rule__Qattribute__TypeAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Qattribute__TypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getQattributeAccess().getTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQattribute"


    // $ANTLR start "entryRuleOperator"
    // InternalQueryDsl.g:478:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalQueryDsl.g:479:1: ( ruleOperator EOF )
            // InternalQueryDsl.g:480:1: ruleOperator EOF
            {
             before(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalQueryDsl.g:487:1: ruleOperator : ( ( rule__Operator__OpAssignment ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:491:2: ( ( ( rule__Operator__OpAssignment ) ) )
            // InternalQueryDsl.g:492:2: ( ( rule__Operator__OpAssignment ) )
            {
            // InternalQueryDsl.g:492:2: ( ( rule__Operator__OpAssignment ) )
            // InternalQueryDsl.g:493:3: ( rule__Operator__OpAssignment )
            {
             before(grammarAccess.getOperatorAccess().getOpAssignment()); 
            // InternalQueryDsl.g:494:3: ( rule__Operator__OpAssignment )
            // InternalQueryDsl.g:494:4: rule__Operator__OpAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Operator__OpAssignment();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getOpAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleFilter"
    // InternalQueryDsl.g:503:1: entryRuleFilter : ruleFilter EOF ;
    public final void entryRuleFilter() throws RecognitionException {
        try {
            // InternalQueryDsl.g:504:1: ( ruleFilter EOF )
            // InternalQueryDsl.g:505:1: ruleFilter EOF
            {
             before(grammarAccess.getFilterRule()); 
            pushFollow(FOLLOW_1);
            ruleFilter();

            state._fsp--;

             after(grammarAccess.getFilterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFilter"


    // $ANTLR start "ruleFilter"
    // InternalQueryDsl.g:512:1: ruleFilter : ( ( rule__Filter__Group__0 ) ) ;
    public final void ruleFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:516:2: ( ( ( rule__Filter__Group__0 ) ) )
            // InternalQueryDsl.g:517:2: ( ( rule__Filter__Group__0 ) )
            {
            // InternalQueryDsl.g:517:2: ( ( rule__Filter__Group__0 ) )
            // InternalQueryDsl.g:518:3: ( rule__Filter__Group__0 )
            {
             before(grammarAccess.getFilterAccess().getGroup()); 
            // InternalQueryDsl.g:519:3: ( rule__Filter__Group__0 )
            // InternalQueryDsl.g:519:4: rule__Filter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFilter"


    // $ANTLR start "entryRuleFilterExp"
    // InternalQueryDsl.g:528:1: entryRuleFilterExp : ruleFilterExp EOF ;
    public final void entryRuleFilterExp() throws RecognitionException {
        try {
            // InternalQueryDsl.g:529:1: ( ruleFilterExp EOF )
            // InternalQueryDsl.g:530:1: ruleFilterExp EOF
            {
             before(grammarAccess.getFilterExpRule()); 
            pushFollow(FOLLOW_1);
            ruleFilterExp();

            state._fsp--;

             after(grammarAccess.getFilterExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFilterExp"


    // $ANTLR start "ruleFilterExp"
    // InternalQueryDsl.g:537:1: ruleFilterExp : ( ( rule__FilterExp__Group__0 ) ) ;
    public final void ruleFilterExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:541:2: ( ( ( rule__FilterExp__Group__0 ) ) )
            // InternalQueryDsl.g:542:2: ( ( rule__FilterExp__Group__0 ) )
            {
            // InternalQueryDsl.g:542:2: ( ( rule__FilterExp__Group__0 ) )
            // InternalQueryDsl.g:543:3: ( rule__FilterExp__Group__0 )
            {
             before(grammarAccess.getFilterExpAccess().getGroup()); 
            // InternalQueryDsl.g:544:3: ( rule__FilterExp__Group__0 )
            // InternalQueryDsl.g:544:4: rule__FilterExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FilterExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFilterExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFilterExp"


    // $ANTLR start "entryRuleComparison"
    // InternalQueryDsl.g:553:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // InternalQueryDsl.g:554:1: ( ruleComparison EOF )
            // InternalQueryDsl.g:555:1: ruleComparison EOF
            {
             before(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getComparisonRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalQueryDsl.g:562:1: ruleComparison : ( ( rule__Comparison__TypeAssignment ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:566:2: ( ( ( rule__Comparison__TypeAssignment ) ) )
            // InternalQueryDsl.g:567:2: ( ( rule__Comparison__TypeAssignment ) )
            {
            // InternalQueryDsl.g:567:2: ( ( rule__Comparison__TypeAssignment ) )
            // InternalQueryDsl.g:568:3: ( rule__Comparison__TypeAssignment )
            {
             before(grammarAccess.getComparisonAccess().getTypeAssignment()); 
            // InternalQueryDsl.g:569:3: ( rule__Comparison__TypeAssignment )
            // InternalQueryDsl.g:569:4: rule__Comparison__TypeAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__TypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleFilterKeyword"
    // InternalQueryDsl.g:578:1: entryRuleFilterKeyword : ruleFilterKeyword EOF ;
    public final void entryRuleFilterKeyword() throws RecognitionException {
        try {
            // InternalQueryDsl.g:579:1: ( ruleFilterKeyword EOF )
            // InternalQueryDsl.g:580:1: ruleFilterKeyword EOF
            {
             before(grammarAccess.getFilterKeywordRule()); 
            pushFollow(FOLLOW_1);
            ruleFilterKeyword();

            state._fsp--;

             after(grammarAccess.getFilterKeywordRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFilterKeyword"


    // $ANTLR start "ruleFilterKeyword"
    // InternalQueryDsl.g:587:1: ruleFilterKeyword : ( ( rule__FilterKeyword__TypeAssignment ) ) ;
    public final void ruleFilterKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:591:2: ( ( ( rule__FilterKeyword__TypeAssignment ) ) )
            // InternalQueryDsl.g:592:2: ( ( rule__FilterKeyword__TypeAssignment ) )
            {
            // InternalQueryDsl.g:592:2: ( ( rule__FilterKeyword__TypeAssignment ) )
            // InternalQueryDsl.g:593:3: ( rule__FilterKeyword__TypeAssignment )
            {
             before(grammarAccess.getFilterKeywordAccess().getTypeAssignment()); 
            // InternalQueryDsl.g:594:3: ( rule__FilterKeyword__TypeAssignment )
            // InternalQueryDsl.g:594:4: rule__FilterKeyword__TypeAssignment
            {
            pushFollow(FOLLOW_2);
            rule__FilterKeyword__TypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFilterKeywordAccess().getTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFilterKeyword"


    // $ANTLR start "entryRuleUserVar"
    // InternalQueryDsl.g:603:1: entryRuleUserVar : ruleUserVar EOF ;
    public final void entryRuleUserVar() throws RecognitionException {
        try {
            // InternalQueryDsl.g:604:1: ( ruleUserVar EOF )
            // InternalQueryDsl.g:605:1: ruleUserVar EOF
            {
             before(grammarAccess.getUserVarRule()); 
            pushFollow(FOLLOW_1);
            ruleUserVar();

            state._fsp--;

             after(grammarAccess.getUserVarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUserVar"


    // $ANTLR start "ruleUserVar"
    // InternalQueryDsl.g:612:1: ruleUserVar : ( ( rule__UserVar__Group__0 ) ) ;
    public final void ruleUserVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:616:2: ( ( ( rule__UserVar__Group__0 ) ) )
            // InternalQueryDsl.g:617:2: ( ( rule__UserVar__Group__0 ) )
            {
            // InternalQueryDsl.g:617:2: ( ( rule__UserVar__Group__0 ) )
            // InternalQueryDsl.g:618:3: ( rule__UserVar__Group__0 )
            {
             before(grammarAccess.getUserVarAccess().getGroup()); 
            // InternalQueryDsl.g:619:3: ( rule__UserVar__Group__0 )
            // InternalQueryDsl.g:619:4: rule__UserVar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UserVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUserVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUserVar"


    // $ANTLR start "entryRuleWorkspaceVar"
    // InternalQueryDsl.g:628:1: entryRuleWorkspaceVar : ruleWorkspaceVar EOF ;
    public final void entryRuleWorkspaceVar() throws RecognitionException {
        try {
            // InternalQueryDsl.g:629:1: ( ruleWorkspaceVar EOF )
            // InternalQueryDsl.g:630:1: ruleWorkspaceVar EOF
            {
             before(grammarAccess.getWorkspaceVarRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkspaceVar();

            state._fsp--;

             after(grammarAccess.getWorkspaceVarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkspaceVar"


    // $ANTLR start "ruleWorkspaceVar"
    // InternalQueryDsl.g:637:1: ruleWorkspaceVar : ( ( rule__WorkspaceVar__Group__0 ) ) ;
    public final void ruleWorkspaceVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:641:2: ( ( ( rule__WorkspaceVar__Group__0 ) ) )
            // InternalQueryDsl.g:642:2: ( ( rule__WorkspaceVar__Group__0 ) )
            {
            // InternalQueryDsl.g:642:2: ( ( rule__WorkspaceVar__Group__0 ) )
            // InternalQueryDsl.g:643:3: ( rule__WorkspaceVar__Group__0 )
            {
             before(grammarAccess.getWorkspaceVarAccess().getGroup()); 
            // InternalQueryDsl.g:644:3: ( rule__WorkspaceVar__Group__0 )
            // InternalQueryDsl.g:644:4: rule__WorkspaceVar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WorkspaceVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkspaceVar"


    // $ANTLR start "entryRuleProjectVar"
    // InternalQueryDsl.g:653:1: entryRuleProjectVar : ruleProjectVar EOF ;
    public final void entryRuleProjectVar() throws RecognitionException {
        try {
            // InternalQueryDsl.g:654:1: ( ruleProjectVar EOF )
            // InternalQueryDsl.g:655:1: ruleProjectVar EOF
            {
             before(grammarAccess.getProjectVarRule()); 
            pushFollow(FOLLOW_1);
            ruleProjectVar();

            state._fsp--;

             after(grammarAccess.getProjectVarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProjectVar"


    // $ANTLR start "ruleProjectVar"
    // InternalQueryDsl.g:662:1: ruleProjectVar : ( ( rule__ProjectVar__Group__0 ) ) ;
    public final void ruleProjectVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:666:2: ( ( ( rule__ProjectVar__Group__0 ) ) )
            // InternalQueryDsl.g:667:2: ( ( rule__ProjectVar__Group__0 ) )
            {
            // InternalQueryDsl.g:667:2: ( ( rule__ProjectVar__Group__0 ) )
            // InternalQueryDsl.g:668:3: ( rule__ProjectVar__Group__0 )
            {
             before(grammarAccess.getProjectVarAccess().getGroup()); 
            // InternalQueryDsl.g:669:3: ( rule__ProjectVar__Group__0 )
            // InternalQueryDsl.g:669:4: rule__ProjectVar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ProjectVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProjectVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProjectVar"


    // $ANTLR start "entryRuleMetamodelVar"
    // InternalQueryDsl.g:678:1: entryRuleMetamodelVar : ruleMetamodelVar EOF ;
    public final void entryRuleMetamodelVar() throws RecognitionException {
        try {
            // InternalQueryDsl.g:679:1: ( ruleMetamodelVar EOF )
            // InternalQueryDsl.g:680:1: ruleMetamodelVar EOF
            {
             before(grammarAccess.getMetamodelVarRule()); 
            pushFollow(FOLLOW_1);
            ruleMetamodelVar();

            state._fsp--;

             after(grammarAccess.getMetamodelVarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetamodelVar"


    // $ANTLR start "ruleMetamodelVar"
    // InternalQueryDsl.g:687:1: ruleMetamodelVar : ( ( rule__MetamodelVar__Group__0 ) ) ;
    public final void ruleMetamodelVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:691:2: ( ( ( rule__MetamodelVar__Group__0 ) ) )
            // InternalQueryDsl.g:692:2: ( ( rule__MetamodelVar__Group__0 ) )
            {
            // InternalQueryDsl.g:692:2: ( ( rule__MetamodelVar__Group__0 ) )
            // InternalQueryDsl.g:693:3: ( rule__MetamodelVar__Group__0 )
            {
             before(grammarAccess.getMetamodelVarAccess().getGroup()); 
            // InternalQueryDsl.g:694:3: ( rule__MetamodelVar__Group__0 )
            // InternalQueryDsl.g:694:4: rule__MetamodelVar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MetamodelVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetamodelVar"


    // $ANTLR start "entryRuleModelVar"
    // InternalQueryDsl.g:703:1: entryRuleModelVar : ruleModelVar EOF ;
    public final void entryRuleModelVar() throws RecognitionException {
        try {
            // InternalQueryDsl.g:704:1: ( ruleModelVar EOF )
            // InternalQueryDsl.g:705:1: ruleModelVar EOF
            {
             before(grammarAccess.getModelVarRule()); 
            pushFollow(FOLLOW_1);
            ruleModelVar();

            state._fsp--;

             after(grammarAccess.getModelVarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelVar"


    // $ANTLR start "ruleModelVar"
    // InternalQueryDsl.g:712:1: ruleModelVar : ( ( rule__ModelVar__Group__0 ) ) ;
    public final void ruleModelVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:716:2: ( ( ( rule__ModelVar__Group__0 ) ) )
            // InternalQueryDsl.g:717:2: ( ( rule__ModelVar__Group__0 ) )
            {
            // InternalQueryDsl.g:717:2: ( ( rule__ModelVar__Group__0 ) )
            // InternalQueryDsl.g:718:3: ( rule__ModelVar__Group__0 )
            {
             before(grammarAccess.getModelVarAccess().getGroup()); 
            // InternalQueryDsl.g:719:3: ( rule__ModelVar__Group__0 )
            // InternalQueryDsl.g:719:4: rule__ModelVar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ModelVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelVar"


    // $ANTLR start "entryRuleDslVar"
    // InternalQueryDsl.g:728:1: entryRuleDslVar : ruleDslVar EOF ;
    public final void entryRuleDslVar() throws RecognitionException {
        try {
            // InternalQueryDsl.g:729:1: ( ruleDslVar EOF )
            // InternalQueryDsl.g:730:1: ruleDslVar EOF
            {
             before(grammarAccess.getDslVarRule()); 
            pushFollow(FOLLOW_1);
            ruleDslVar();

            state._fsp--;

             after(grammarAccess.getDslVarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDslVar"


    // $ANTLR start "ruleDslVar"
    // InternalQueryDsl.g:737:1: ruleDslVar : ( ( rule__DslVar__Group__0 ) ) ;
    public final void ruleDslVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:741:2: ( ( ( rule__DslVar__Group__0 ) ) )
            // InternalQueryDsl.g:742:2: ( ( rule__DslVar__Group__0 ) )
            {
            // InternalQueryDsl.g:742:2: ( ( rule__DslVar__Group__0 ) )
            // InternalQueryDsl.g:743:3: ( rule__DslVar__Group__0 )
            {
             before(grammarAccess.getDslVarAccess().getGroup()); 
            // InternalQueryDsl.g:744:3: ( rule__DslVar__Group__0 )
            // InternalQueryDsl.g:744:4: rule__DslVar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DslVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDslVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDslVar"


    // $ANTLR start "entryRuleUserField"
    // InternalQueryDsl.g:753:1: entryRuleUserField : ruleUserField EOF ;
    public final void entryRuleUserField() throws RecognitionException {
        try {
            // InternalQueryDsl.g:754:1: ( ruleUserField EOF )
            // InternalQueryDsl.g:755:1: ruleUserField EOF
            {
             before(grammarAccess.getUserFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleUserField();

            state._fsp--;

             after(grammarAccess.getUserFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUserField"


    // $ANTLR start "ruleUserField"
    // InternalQueryDsl.g:762:1: ruleUserField : ( ( rule__UserField__TypeNameAssignment ) ) ;
    public final void ruleUserField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:766:2: ( ( ( rule__UserField__TypeNameAssignment ) ) )
            // InternalQueryDsl.g:767:2: ( ( rule__UserField__TypeNameAssignment ) )
            {
            // InternalQueryDsl.g:767:2: ( ( rule__UserField__TypeNameAssignment ) )
            // InternalQueryDsl.g:768:3: ( rule__UserField__TypeNameAssignment )
            {
             before(grammarAccess.getUserFieldAccess().getTypeNameAssignment()); 
            // InternalQueryDsl.g:769:3: ( rule__UserField__TypeNameAssignment )
            // InternalQueryDsl.g:769:4: rule__UserField__TypeNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__UserField__TypeNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getUserFieldAccess().getTypeNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUserField"


    // $ANTLR start "entryRuleWorkspaceField"
    // InternalQueryDsl.g:778:1: entryRuleWorkspaceField : ruleWorkspaceField EOF ;
    public final void entryRuleWorkspaceField() throws RecognitionException {
        try {
            // InternalQueryDsl.g:779:1: ( ruleWorkspaceField EOF )
            // InternalQueryDsl.g:780:1: ruleWorkspaceField EOF
            {
             before(grammarAccess.getWorkspaceFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkspaceField();

            state._fsp--;

             after(grammarAccess.getWorkspaceFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkspaceField"


    // $ANTLR start "ruleWorkspaceField"
    // InternalQueryDsl.g:787:1: ruleWorkspaceField : ( ( rule__WorkspaceField__TypeNameAssignment ) ) ;
    public final void ruleWorkspaceField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:791:2: ( ( ( rule__WorkspaceField__TypeNameAssignment ) ) )
            // InternalQueryDsl.g:792:2: ( ( rule__WorkspaceField__TypeNameAssignment ) )
            {
            // InternalQueryDsl.g:792:2: ( ( rule__WorkspaceField__TypeNameAssignment ) )
            // InternalQueryDsl.g:793:3: ( rule__WorkspaceField__TypeNameAssignment )
            {
             before(grammarAccess.getWorkspaceFieldAccess().getTypeNameAssignment()); 
            // InternalQueryDsl.g:794:3: ( rule__WorkspaceField__TypeNameAssignment )
            // InternalQueryDsl.g:794:4: rule__WorkspaceField__TypeNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__WorkspaceField__TypeNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceFieldAccess().getTypeNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkspaceField"


    // $ANTLR start "entryRuleProjectField"
    // InternalQueryDsl.g:803:1: entryRuleProjectField : ruleProjectField EOF ;
    public final void entryRuleProjectField() throws RecognitionException {
        try {
            // InternalQueryDsl.g:804:1: ( ruleProjectField EOF )
            // InternalQueryDsl.g:805:1: ruleProjectField EOF
            {
             before(grammarAccess.getProjectFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleProjectField();

            state._fsp--;

             after(grammarAccess.getProjectFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProjectField"


    // $ANTLR start "ruleProjectField"
    // InternalQueryDsl.g:812:1: ruleProjectField : ( ( rule__ProjectField__TypeNameAssignment ) ) ;
    public final void ruleProjectField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:816:2: ( ( ( rule__ProjectField__TypeNameAssignment ) ) )
            // InternalQueryDsl.g:817:2: ( ( rule__ProjectField__TypeNameAssignment ) )
            {
            // InternalQueryDsl.g:817:2: ( ( rule__ProjectField__TypeNameAssignment ) )
            // InternalQueryDsl.g:818:3: ( rule__ProjectField__TypeNameAssignment )
            {
             before(grammarAccess.getProjectFieldAccess().getTypeNameAssignment()); 
            // InternalQueryDsl.g:819:3: ( rule__ProjectField__TypeNameAssignment )
            // InternalQueryDsl.g:819:4: rule__ProjectField__TypeNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ProjectField__TypeNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getProjectFieldAccess().getTypeNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProjectField"


    // $ANTLR start "entryRuleMetamodelField"
    // InternalQueryDsl.g:828:1: entryRuleMetamodelField : ruleMetamodelField EOF ;
    public final void entryRuleMetamodelField() throws RecognitionException {
        try {
            // InternalQueryDsl.g:829:1: ( ruleMetamodelField EOF )
            // InternalQueryDsl.g:830:1: ruleMetamodelField EOF
            {
             before(grammarAccess.getMetamodelFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleMetamodelField();

            state._fsp--;

             after(grammarAccess.getMetamodelFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetamodelField"


    // $ANTLR start "ruleMetamodelField"
    // InternalQueryDsl.g:837:1: ruleMetamodelField : ( ( rule__MetamodelField__TypeNameAssignment ) ) ;
    public final void ruleMetamodelField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:841:2: ( ( ( rule__MetamodelField__TypeNameAssignment ) ) )
            // InternalQueryDsl.g:842:2: ( ( rule__MetamodelField__TypeNameAssignment ) )
            {
            // InternalQueryDsl.g:842:2: ( ( rule__MetamodelField__TypeNameAssignment ) )
            // InternalQueryDsl.g:843:3: ( rule__MetamodelField__TypeNameAssignment )
            {
             before(grammarAccess.getMetamodelFieldAccess().getTypeNameAssignment()); 
            // InternalQueryDsl.g:844:3: ( rule__MetamodelField__TypeNameAssignment )
            // InternalQueryDsl.g:844:4: rule__MetamodelField__TypeNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MetamodelField__TypeNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelFieldAccess().getTypeNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetamodelField"


    // $ANTLR start "entryRuleModelField"
    // InternalQueryDsl.g:853:1: entryRuleModelField : ruleModelField EOF ;
    public final void entryRuleModelField() throws RecognitionException {
        try {
            // InternalQueryDsl.g:854:1: ( ruleModelField EOF )
            // InternalQueryDsl.g:855:1: ruleModelField EOF
            {
             before(grammarAccess.getModelFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleModelField();

            state._fsp--;

             after(grammarAccess.getModelFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelField"


    // $ANTLR start "ruleModelField"
    // InternalQueryDsl.g:862:1: ruleModelField : ( ( rule__ModelField__TypeNameAssignment ) ) ;
    public final void ruleModelField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:866:2: ( ( ( rule__ModelField__TypeNameAssignment ) ) )
            // InternalQueryDsl.g:867:2: ( ( rule__ModelField__TypeNameAssignment ) )
            {
            // InternalQueryDsl.g:867:2: ( ( rule__ModelField__TypeNameAssignment ) )
            // InternalQueryDsl.g:868:3: ( rule__ModelField__TypeNameAssignment )
            {
             before(grammarAccess.getModelFieldAccess().getTypeNameAssignment()); 
            // InternalQueryDsl.g:869:3: ( rule__ModelField__TypeNameAssignment )
            // InternalQueryDsl.g:869:4: rule__ModelField__TypeNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ModelField__TypeNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getModelFieldAccess().getTypeNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelField"


    // $ANTLR start "entryRuleDslField"
    // InternalQueryDsl.g:878:1: entryRuleDslField : ruleDslField EOF ;
    public final void entryRuleDslField() throws RecognitionException {
        try {
            // InternalQueryDsl.g:879:1: ( ruleDslField EOF )
            // InternalQueryDsl.g:880:1: ruleDslField EOF
            {
             before(grammarAccess.getDslFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleDslField();

            state._fsp--;

             after(grammarAccess.getDslFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDslField"


    // $ANTLR start "ruleDslField"
    // InternalQueryDsl.g:887:1: ruleDslField : ( ( rule__DslField__TypeNameAssignment ) ) ;
    public final void ruleDslField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:891:2: ( ( ( rule__DslField__TypeNameAssignment ) ) )
            // InternalQueryDsl.g:892:2: ( ( rule__DslField__TypeNameAssignment ) )
            {
            // InternalQueryDsl.g:892:2: ( ( rule__DslField__TypeNameAssignment ) )
            // InternalQueryDsl.g:893:3: ( rule__DslField__TypeNameAssignment )
            {
             before(grammarAccess.getDslFieldAccess().getTypeNameAssignment()); 
            // InternalQueryDsl.g:894:3: ( rule__DslField__TypeNameAssignment )
            // InternalQueryDsl.g:894:4: rule__DslField__TypeNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DslField__TypeNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDslFieldAccess().getTypeNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDslField"


    // $ANTLR start "entryRuleUserParam"
    // InternalQueryDsl.g:903:1: entryRuleUserParam : ruleUserParam EOF ;
    public final void entryRuleUserParam() throws RecognitionException {
        try {
            // InternalQueryDsl.g:904:1: ( ruleUserParam EOF )
            // InternalQueryDsl.g:905:1: ruleUserParam EOF
            {
             before(grammarAccess.getUserParamRule()); 
            pushFollow(FOLLOW_1);
            ruleUserParam();

            state._fsp--;

             after(grammarAccess.getUserParamRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUserParam"


    // $ANTLR start "ruleUserParam"
    // InternalQueryDsl.g:912:1: ruleUserParam : ( ( rule__UserParam__TypeNameAssignment ) ) ;
    public final void ruleUserParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:916:2: ( ( ( rule__UserParam__TypeNameAssignment ) ) )
            // InternalQueryDsl.g:917:2: ( ( rule__UserParam__TypeNameAssignment ) )
            {
            // InternalQueryDsl.g:917:2: ( ( rule__UserParam__TypeNameAssignment ) )
            // InternalQueryDsl.g:918:3: ( rule__UserParam__TypeNameAssignment )
            {
             before(grammarAccess.getUserParamAccess().getTypeNameAssignment()); 
            // InternalQueryDsl.g:919:3: ( rule__UserParam__TypeNameAssignment )
            // InternalQueryDsl.g:919:4: rule__UserParam__TypeNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__UserParam__TypeNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getUserParamAccess().getTypeNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUserParam"


    // $ANTLR start "entryRuleWorkspaceParam"
    // InternalQueryDsl.g:928:1: entryRuleWorkspaceParam : ruleWorkspaceParam EOF ;
    public final void entryRuleWorkspaceParam() throws RecognitionException {
        try {
            // InternalQueryDsl.g:929:1: ( ruleWorkspaceParam EOF )
            // InternalQueryDsl.g:930:1: ruleWorkspaceParam EOF
            {
             before(grammarAccess.getWorkspaceParamRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkspaceParam();

            state._fsp--;

             after(grammarAccess.getWorkspaceParamRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkspaceParam"


    // $ANTLR start "ruleWorkspaceParam"
    // InternalQueryDsl.g:937:1: ruleWorkspaceParam : ( ( rule__WorkspaceParam__TypeNameAssignment ) ) ;
    public final void ruleWorkspaceParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:941:2: ( ( ( rule__WorkspaceParam__TypeNameAssignment ) ) )
            // InternalQueryDsl.g:942:2: ( ( rule__WorkspaceParam__TypeNameAssignment ) )
            {
            // InternalQueryDsl.g:942:2: ( ( rule__WorkspaceParam__TypeNameAssignment ) )
            // InternalQueryDsl.g:943:3: ( rule__WorkspaceParam__TypeNameAssignment )
            {
             before(grammarAccess.getWorkspaceParamAccess().getTypeNameAssignment()); 
            // InternalQueryDsl.g:944:3: ( rule__WorkspaceParam__TypeNameAssignment )
            // InternalQueryDsl.g:944:4: rule__WorkspaceParam__TypeNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__WorkspaceParam__TypeNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceParamAccess().getTypeNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkspaceParam"


    // $ANTLR start "entryRuleProjectParam"
    // InternalQueryDsl.g:953:1: entryRuleProjectParam : ruleProjectParam EOF ;
    public final void entryRuleProjectParam() throws RecognitionException {
        try {
            // InternalQueryDsl.g:954:1: ( ruleProjectParam EOF )
            // InternalQueryDsl.g:955:1: ruleProjectParam EOF
            {
             before(grammarAccess.getProjectParamRule()); 
            pushFollow(FOLLOW_1);
            ruleProjectParam();

            state._fsp--;

             after(grammarAccess.getProjectParamRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProjectParam"


    // $ANTLR start "ruleProjectParam"
    // InternalQueryDsl.g:962:1: ruleProjectParam : ( ( rule__ProjectParam__TypeNameAssignment ) ) ;
    public final void ruleProjectParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:966:2: ( ( ( rule__ProjectParam__TypeNameAssignment ) ) )
            // InternalQueryDsl.g:967:2: ( ( rule__ProjectParam__TypeNameAssignment ) )
            {
            // InternalQueryDsl.g:967:2: ( ( rule__ProjectParam__TypeNameAssignment ) )
            // InternalQueryDsl.g:968:3: ( rule__ProjectParam__TypeNameAssignment )
            {
             before(grammarAccess.getProjectParamAccess().getTypeNameAssignment()); 
            // InternalQueryDsl.g:969:3: ( rule__ProjectParam__TypeNameAssignment )
            // InternalQueryDsl.g:969:4: rule__ProjectParam__TypeNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ProjectParam__TypeNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getProjectParamAccess().getTypeNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProjectParam"


    // $ANTLR start "entryRuleMetamodelParam"
    // InternalQueryDsl.g:978:1: entryRuleMetamodelParam : ruleMetamodelParam EOF ;
    public final void entryRuleMetamodelParam() throws RecognitionException {
        try {
            // InternalQueryDsl.g:979:1: ( ruleMetamodelParam EOF )
            // InternalQueryDsl.g:980:1: ruleMetamodelParam EOF
            {
             before(grammarAccess.getMetamodelParamRule()); 
            pushFollow(FOLLOW_1);
            ruleMetamodelParam();

            state._fsp--;

             after(grammarAccess.getMetamodelParamRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetamodelParam"


    // $ANTLR start "ruleMetamodelParam"
    // InternalQueryDsl.g:987:1: ruleMetamodelParam : ( ( rule__MetamodelParam__Alternatives ) ) ;
    public final void ruleMetamodelParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:991:2: ( ( ( rule__MetamodelParam__Alternatives ) ) )
            // InternalQueryDsl.g:992:2: ( ( rule__MetamodelParam__Alternatives ) )
            {
            // InternalQueryDsl.g:992:2: ( ( rule__MetamodelParam__Alternatives ) )
            // InternalQueryDsl.g:993:3: ( rule__MetamodelParam__Alternatives )
            {
             before(grammarAccess.getMetamodelParamAccess().getAlternatives()); 
            // InternalQueryDsl.g:994:3: ( rule__MetamodelParam__Alternatives )
            // InternalQueryDsl.g:994:4: rule__MetamodelParam__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MetamodelParam__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelParamAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetamodelParam"


    // $ANTLR start "entryRuleMetaParam"
    // InternalQueryDsl.g:1003:1: entryRuleMetaParam : ruleMetaParam EOF ;
    public final void entryRuleMetaParam() throws RecognitionException {
        try {
            // InternalQueryDsl.g:1004:1: ( ruleMetaParam EOF )
            // InternalQueryDsl.g:1005:1: ruleMetaParam EOF
            {
             before(grammarAccess.getMetaParamRule()); 
            pushFollow(FOLLOW_1);
            ruleMetaParam();

            state._fsp--;

             after(grammarAccess.getMetaParamRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetaParam"


    // $ANTLR start "ruleMetaParam"
    // InternalQueryDsl.g:1012:1: ruleMetaParam : ( ( rule__MetaParam__Alternatives ) ) ;
    public final void ruleMetaParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1016:2: ( ( ( rule__MetaParam__Alternatives ) ) )
            // InternalQueryDsl.g:1017:2: ( ( rule__MetaParam__Alternatives ) )
            {
            // InternalQueryDsl.g:1017:2: ( ( rule__MetaParam__Alternatives ) )
            // InternalQueryDsl.g:1018:3: ( rule__MetaParam__Alternatives )
            {
             before(grammarAccess.getMetaParamAccess().getAlternatives()); 
            // InternalQueryDsl.g:1019:3: ( rule__MetaParam__Alternatives )
            // InternalQueryDsl.g:1019:4: rule__MetaParam__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MetaParam__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMetaParamAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetaParam"


    // $ANTLR start "entryRuleParam"
    // InternalQueryDsl.g:1028:1: entryRuleParam : ruleParam EOF ;
    public final void entryRuleParam() throws RecognitionException {
        try {
            // InternalQueryDsl.g:1029:1: ( ruleParam EOF )
            // InternalQueryDsl.g:1030:1: ruleParam EOF
            {
             before(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_1);
            ruleParam();

            state._fsp--;

             after(grammarAccess.getParamRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // InternalQueryDsl.g:1037:1: ruleParam : ( ( rule__Param__Alternatives ) ) ;
    public final void ruleParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1041:2: ( ( ( rule__Param__Alternatives ) ) )
            // InternalQueryDsl.g:1042:2: ( ( rule__Param__Alternatives ) )
            {
            // InternalQueryDsl.g:1042:2: ( ( rule__Param__Alternatives ) )
            // InternalQueryDsl.g:1043:3: ( rule__Param__Alternatives )
            {
             before(grammarAccess.getParamAccess().getAlternatives()); 
            // InternalQueryDsl.g:1044:3: ( rule__Param__Alternatives )
            // InternalQueryDsl.g:1044:4: rule__Param__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Param__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParamAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleVariable"
    // InternalQueryDsl.g:1053:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalQueryDsl.g:1054:1: ( ruleVariable EOF )
            // InternalQueryDsl.g:1055:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalQueryDsl.g:1062:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1066:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalQueryDsl.g:1067:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalQueryDsl.g:1067:2: ( ( rule__Variable__Group__0 ) )
            // InternalQueryDsl.g:1068:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalQueryDsl.g:1069:3: ( rule__Variable__Group__0 )
            // InternalQueryDsl.g:1069:4: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleExpression"
    // InternalQueryDsl.g:1078:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalQueryDsl.g:1079:1: ( ruleExpression EOF )
            // InternalQueryDsl.g:1080:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalQueryDsl.g:1087:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1091:2: ( ( ( rule__Expression__Alternatives ) ) )
            // InternalQueryDsl.g:1092:2: ( ( rule__Expression__Alternatives ) )
            {
            // InternalQueryDsl.g:1092:2: ( ( rule__Expression__Alternatives ) )
            // InternalQueryDsl.g:1093:3: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // InternalQueryDsl.g:1094:3: ( rule__Expression__Alternatives )
            // InternalQueryDsl.g:1094:4: rule__Expression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "rule__AbstractElement__Alternatives"
    // InternalQueryDsl.g:1102:1: rule__AbstractElement__Alternatives : ( ( ruleVariable ) | ( ruleUser ) | ( ruleWorkspace ) | ( ruleProject ) | ( ruleMetamodel ) | ( ruleModel ) | ( ruleDsl ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1106:1: ( ( ruleVariable ) | ( ruleUser ) | ( ruleWorkspace ) | ( ruleProject ) | ( ruleMetamodel ) | ( ruleModel ) | ( ruleDsl ) )
            int alt2=7;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==110) ) {
                alt2=1;
            }
            else if ( (LA2_0==87) ) {
                switch ( input.LA(2) ) {
                case 97:
                    {
                    alt2=5;
                    }
                    break;
                case 99:
                    {
                    alt2=6;
                    }
                    break;
                case 100:
                    {
                    alt2=7;
                    }
                    break;
                case 96:
                    {
                    alt2=4;
                    }
                    break;
                case 95:
                    {
                    alt2=3;
                    }
                    break;
                case 88:
                    {
                    alt2=2;
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
                    // InternalQueryDsl.g:1107:2: ( ruleVariable )
                    {
                    // InternalQueryDsl.g:1107:2: ( ruleVariable )
                    // InternalQueryDsl.g:1108:3: ruleVariable
                    {
                     before(grammarAccess.getAbstractElementAccess().getVariableParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getVariableParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1113:2: ( ruleUser )
                    {
                    // InternalQueryDsl.g:1113:2: ( ruleUser )
                    // InternalQueryDsl.g:1114:3: ruleUser
                    {
                     before(grammarAccess.getAbstractElementAccess().getUserParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleUser();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getUserParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1119:2: ( ruleWorkspace )
                    {
                    // InternalQueryDsl.g:1119:2: ( ruleWorkspace )
                    // InternalQueryDsl.g:1120:3: ruleWorkspace
                    {
                     before(grammarAccess.getAbstractElementAccess().getWorkspaceParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleWorkspace();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getWorkspaceParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1125:2: ( ruleProject )
                    {
                    // InternalQueryDsl.g:1125:2: ( ruleProject )
                    // InternalQueryDsl.g:1126:3: ruleProject
                    {
                     before(grammarAccess.getAbstractElementAccess().getProjectParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleProject();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getProjectParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1131:2: ( ruleMetamodel )
                    {
                    // InternalQueryDsl.g:1131:2: ( ruleMetamodel )
                    // InternalQueryDsl.g:1132:3: ruleMetamodel
                    {
                     before(grammarAccess.getAbstractElementAccess().getMetamodelParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleMetamodel();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getMetamodelParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:1137:2: ( ruleModel )
                    {
                    // InternalQueryDsl.g:1137:2: ( ruleModel )
                    // InternalQueryDsl.g:1138:3: ruleModel
                    {
                     before(grammarAccess.getAbstractElementAccess().getModelParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleModel();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getModelParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:1143:2: ( ruleDsl )
                    {
                    // InternalQueryDsl.g:1143:2: ( ruleDsl )
                    // InternalQueryDsl.g:1144:3: ruleDsl
                    {
                     before(grammarAccess.getAbstractElementAccess().getDslParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleDsl();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getDslParserRuleCall_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractElement__Alternatives"


    // $ANTLR start "rule__Metamodel__Alternatives_6_1"
    // InternalQueryDsl.g:1153:1: rule__Metamodel__Alternatives_6_1 : ( ( ( rule__Metamodel__SyntaxAssignment_6_1_0 ) ) | ( ( rule__Metamodel__TextSearchAssignment_6_1_1 ) ) | ( ( rule__Metamodel__FilterAssignment_6_1_2 ) ) | ( ( rule__Metamodel__QmAssignment_6_1_3 ) ) | ( ( rule__Metamodel__TransfoAssignment_6_1_4 ) ) );
    public final void rule__Metamodel__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1157:1: ( ( ( rule__Metamodel__SyntaxAssignment_6_1_0 ) ) | ( ( rule__Metamodel__TextSearchAssignment_6_1_1 ) ) | ( ( rule__Metamodel__FilterAssignment_6_1_2 ) ) | ( ( rule__Metamodel__QmAssignment_6_1_3 ) ) | ( ( rule__Metamodel__TransfoAssignment_6_1_4 ) ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt3=1;
                }
                break;
            case 104:
                {
                alt3=2;
                }
                break;
            case 109:
                {
                alt3=3;
                }
                break;
            case 107:
                {
                alt3=4;
                }
                break;
            case 108:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalQueryDsl.g:1158:2: ( ( rule__Metamodel__SyntaxAssignment_6_1_0 ) )
                    {
                    // InternalQueryDsl.g:1158:2: ( ( rule__Metamodel__SyntaxAssignment_6_1_0 ) )
                    // InternalQueryDsl.g:1159:3: ( rule__Metamodel__SyntaxAssignment_6_1_0 )
                    {
                     before(grammarAccess.getMetamodelAccess().getSyntaxAssignment_6_1_0()); 
                    // InternalQueryDsl.g:1160:3: ( rule__Metamodel__SyntaxAssignment_6_1_0 )
                    // InternalQueryDsl.g:1160:4: rule__Metamodel__SyntaxAssignment_6_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Metamodel__SyntaxAssignment_6_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMetamodelAccess().getSyntaxAssignment_6_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1164:2: ( ( rule__Metamodel__TextSearchAssignment_6_1_1 ) )
                    {
                    // InternalQueryDsl.g:1164:2: ( ( rule__Metamodel__TextSearchAssignment_6_1_1 ) )
                    // InternalQueryDsl.g:1165:3: ( rule__Metamodel__TextSearchAssignment_6_1_1 )
                    {
                     before(grammarAccess.getMetamodelAccess().getTextSearchAssignment_6_1_1()); 
                    // InternalQueryDsl.g:1166:3: ( rule__Metamodel__TextSearchAssignment_6_1_1 )
                    // InternalQueryDsl.g:1166:4: rule__Metamodel__TextSearchAssignment_6_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Metamodel__TextSearchAssignment_6_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getMetamodelAccess().getTextSearchAssignment_6_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1170:2: ( ( rule__Metamodel__FilterAssignment_6_1_2 ) )
                    {
                    // InternalQueryDsl.g:1170:2: ( ( rule__Metamodel__FilterAssignment_6_1_2 ) )
                    // InternalQueryDsl.g:1171:3: ( rule__Metamodel__FilterAssignment_6_1_2 )
                    {
                     before(grammarAccess.getMetamodelAccess().getFilterAssignment_6_1_2()); 
                    // InternalQueryDsl.g:1172:3: ( rule__Metamodel__FilterAssignment_6_1_2 )
                    // InternalQueryDsl.g:1172:4: rule__Metamodel__FilterAssignment_6_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Metamodel__FilterAssignment_6_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getMetamodelAccess().getFilterAssignment_6_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1176:2: ( ( rule__Metamodel__QmAssignment_6_1_3 ) )
                    {
                    // InternalQueryDsl.g:1176:2: ( ( rule__Metamodel__QmAssignment_6_1_3 ) )
                    // InternalQueryDsl.g:1177:3: ( rule__Metamodel__QmAssignment_6_1_3 )
                    {
                     before(grammarAccess.getMetamodelAccess().getQmAssignment_6_1_3()); 
                    // InternalQueryDsl.g:1178:3: ( rule__Metamodel__QmAssignment_6_1_3 )
                    // InternalQueryDsl.g:1178:4: rule__Metamodel__QmAssignment_6_1_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Metamodel__QmAssignment_6_1_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getMetamodelAccess().getQmAssignment_6_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1182:2: ( ( rule__Metamodel__TransfoAssignment_6_1_4 ) )
                    {
                    // InternalQueryDsl.g:1182:2: ( ( rule__Metamodel__TransfoAssignment_6_1_4 ) )
                    // InternalQueryDsl.g:1183:3: ( rule__Metamodel__TransfoAssignment_6_1_4 )
                    {
                     before(grammarAccess.getMetamodelAccess().getTransfoAssignment_6_1_4()); 
                    // InternalQueryDsl.g:1184:3: ( rule__Metamodel__TransfoAssignment_6_1_4 )
                    // InternalQueryDsl.g:1184:4: rule__Metamodel__TransfoAssignment_6_1_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Metamodel__TransfoAssignment_6_1_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getMetamodelAccess().getTransfoAssignment_6_1_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Alternatives_6_1"


    // $ANTLR start "rule__Model__Alternatives_6_1"
    // InternalQueryDsl.g:1192:1: rule__Model__Alternatives_6_1 : ( ( ( rule__Model__SyntaxAssignment_6_1_0 ) ) | ( ( rule__Model__TextSearchAssignment_6_1_1 ) ) | ( ( rule__Model__FilterAssignment_6_1_2 ) ) | ( ( rule__Model__QAssignment_6_1_3 ) ) );
    public final void rule__Model__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1196:1: ( ( ( rule__Model__SyntaxAssignment_6_1_0 ) ) | ( ( rule__Model__TextSearchAssignment_6_1_1 ) ) | ( ( rule__Model__FilterAssignment_6_1_2 ) ) | ( ( rule__Model__QAssignment_6_1_3 ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt4=1;
                }
                break;
            case 104:
                {
                alt4=2;
                }
                break;
            case 109:
                {
                alt4=3;
                }
                break;
            case 102:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalQueryDsl.g:1197:2: ( ( rule__Model__SyntaxAssignment_6_1_0 ) )
                    {
                    // InternalQueryDsl.g:1197:2: ( ( rule__Model__SyntaxAssignment_6_1_0 ) )
                    // InternalQueryDsl.g:1198:3: ( rule__Model__SyntaxAssignment_6_1_0 )
                    {
                     before(grammarAccess.getModelAccess().getSyntaxAssignment_6_1_0()); 
                    // InternalQueryDsl.g:1199:3: ( rule__Model__SyntaxAssignment_6_1_0 )
                    // InternalQueryDsl.g:1199:4: rule__Model__SyntaxAssignment_6_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__SyntaxAssignment_6_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getSyntaxAssignment_6_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1203:2: ( ( rule__Model__TextSearchAssignment_6_1_1 ) )
                    {
                    // InternalQueryDsl.g:1203:2: ( ( rule__Model__TextSearchAssignment_6_1_1 ) )
                    // InternalQueryDsl.g:1204:3: ( rule__Model__TextSearchAssignment_6_1_1 )
                    {
                     before(grammarAccess.getModelAccess().getTextSearchAssignment_6_1_1()); 
                    // InternalQueryDsl.g:1205:3: ( rule__Model__TextSearchAssignment_6_1_1 )
                    // InternalQueryDsl.g:1205:4: rule__Model__TextSearchAssignment_6_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__TextSearchAssignment_6_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getTextSearchAssignment_6_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1209:2: ( ( rule__Model__FilterAssignment_6_1_2 ) )
                    {
                    // InternalQueryDsl.g:1209:2: ( ( rule__Model__FilterAssignment_6_1_2 ) )
                    // InternalQueryDsl.g:1210:3: ( rule__Model__FilterAssignment_6_1_2 )
                    {
                     before(grammarAccess.getModelAccess().getFilterAssignment_6_1_2()); 
                    // InternalQueryDsl.g:1211:3: ( rule__Model__FilterAssignment_6_1_2 )
                    // InternalQueryDsl.g:1211:4: rule__Model__FilterAssignment_6_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__FilterAssignment_6_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getFilterAssignment_6_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1215:2: ( ( rule__Model__QAssignment_6_1_3 ) )
                    {
                    // InternalQueryDsl.g:1215:2: ( ( rule__Model__QAssignment_6_1_3 ) )
                    // InternalQueryDsl.g:1216:3: ( rule__Model__QAssignment_6_1_3 )
                    {
                     before(grammarAccess.getModelAccess().getQAssignment_6_1_3()); 
                    // InternalQueryDsl.g:1217:3: ( rule__Model__QAssignment_6_1_3 )
                    // InternalQueryDsl.g:1217:4: rule__Model__QAssignment_6_1_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__QAssignment_6_1_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getQAssignment_6_1_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Alternatives_6_1"


    // $ANTLR start "rule__Dsl__Alternatives_6_1"
    // InternalQueryDsl.g:1225:1: rule__Dsl__Alternatives_6_1 : ( ( ( rule__Dsl__SyntaxAssignment_6_1_0 ) ) | ( ( rule__Dsl__TextSearchAssignment_6_1_1 ) ) | ( ( rule__Dsl__FilterAssignment_6_1_2 ) ) );
    public final void rule__Dsl__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1229:1: ( ( ( rule__Dsl__SyntaxAssignment_6_1_0 ) ) | ( ( rule__Dsl__TextSearchAssignment_6_1_1 ) ) | ( ( rule__Dsl__FilterAssignment_6_1_2 ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt5=1;
                }
                break;
            case 104:
                {
                alt5=2;
                }
                break;
            case 109:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalQueryDsl.g:1230:2: ( ( rule__Dsl__SyntaxAssignment_6_1_0 ) )
                    {
                    // InternalQueryDsl.g:1230:2: ( ( rule__Dsl__SyntaxAssignment_6_1_0 ) )
                    // InternalQueryDsl.g:1231:3: ( rule__Dsl__SyntaxAssignment_6_1_0 )
                    {
                     before(grammarAccess.getDslAccess().getSyntaxAssignment_6_1_0()); 
                    // InternalQueryDsl.g:1232:3: ( rule__Dsl__SyntaxAssignment_6_1_0 )
                    // InternalQueryDsl.g:1232:4: rule__Dsl__SyntaxAssignment_6_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Dsl__SyntaxAssignment_6_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDslAccess().getSyntaxAssignment_6_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1236:2: ( ( rule__Dsl__TextSearchAssignment_6_1_1 ) )
                    {
                    // InternalQueryDsl.g:1236:2: ( ( rule__Dsl__TextSearchAssignment_6_1_1 ) )
                    // InternalQueryDsl.g:1237:3: ( rule__Dsl__TextSearchAssignment_6_1_1 )
                    {
                     before(grammarAccess.getDslAccess().getTextSearchAssignment_6_1_1()); 
                    // InternalQueryDsl.g:1238:3: ( rule__Dsl__TextSearchAssignment_6_1_1 )
                    // InternalQueryDsl.g:1238:4: rule__Dsl__TextSearchAssignment_6_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Dsl__TextSearchAssignment_6_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDslAccess().getTextSearchAssignment_6_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1242:2: ( ( rule__Dsl__FilterAssignment_6_1_2 ) )
                    {
                    // InternalQueryDsl.g:1242:2: ( ( rule__Dsl__FilterAssignment_6_1_2 ) )
                    // InternalQueryDsl.g:1243:3: ( rule__Dsl__FilterAssignment_6_1_2 )
                    {
                     before(grammarAccess.getDslAccess().getFilterAssignment_6_1_2()); 
                    // InternalQueryDsl.g:1244:3: ( rule__Dsl__FilterAssignment_6_1_2 )
                    // InternalQueryDsl.g:1244:4: rule__Dsl__FilterAssignment_6_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Dsl__FilterAssignment_6_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getDslAccess().getFilterAssignment_6_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Alternatives_6_1"


    // $ANTLR start "rule__QueryLang__Alternatives"
    // InternalQueryDsl.g:1252:1: rule__QueryLang__Alternatives : ( ( 'EOL' ) | ( 'OCL' ) );
    public final void rule__QueryLang__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1256:1: ( ( 'EOL' ) | ( 'OCL' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==11) ) {
                alt6=1;
            }
            else if ( (LA6_0==12) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalQueryDsl.g:1257:2: ( 'EOL' )
                    {
                    // InternalQueryDsl.g:1257:2: ( 'EOL' )
                    // InternalQueryDsl.g:1258:3: 'EOL'
                    {
                     before(grammarAccess.getQueryLangAccess().getEOLKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getQueryLangAccess().getEOLKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1263:2: ( 'OCL' )
                    {
                    // InternalQueryDsl.g:1263:2: ( 'OCL' )
                    // InternalQueryDsl.g:1264:3: 'OCL'
                    {
                     before(grammarAccess.getQueryLangAccess().getOCLKeyword_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getQueryLangAccess().getOCLKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryLang__Alternatives"


    // $ANTLR start "rule__FullTextSearch__Alternatives_4"
    // InternalQueryDsl.g:1273:1: rule__FullTextSearch__Alternatives_4 : ( ( ( rule__FullTextSearch__Group_4_0__0 ) ) | ( ( rule__FullTextSearch__Group_4_1__0 ) ) );
    public final void rule__FullTextSearch__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1277:1: ( ( ( rule__FullTextSearch__Group_4_0__0 ) ) | ( ( rule__FullTextSearch__Group_4_1__0 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==94) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==106) ) {
                    alt7=2;
                }
                else if ( (LA7_1==105) ) {
                    alt7=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalQueryDsl.g:1278:2: ( ( rule__FullTextSearch__Group_4_0__0 ) )
                    {
                    // InternalQueryDsl.g:1278:2: ( ( rule__FullTextSearch__Group_4_0__0 ) )
                    // InternalQueryDsl.g:1279:3: ( rule__FullTextSearch__Group_4_0__0 )
                    {
                     before(grammarAccess.getFullTextSearchAccess().getGroup_4_0()); 
                    // InternalQueryDsl.g:1280:3: ( rule__FullTextSearch__Group_4_0__0 )
                    // InternalQueryDsl.g:1280:4: rule__FullTextSearch__Group_4_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FullTextSearch__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFullTextSearchAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1284:2: ( ( rule__FullTextSearch__Group_4_1__0 ) )
                    {
                    // InternalQueryDsl.g:1284:2: ( ( rule__FullTextSearch__Group_4_1__0 ) )
                    // InternalQueryDsl.g:1285:3: ( rule__FullTextSearch__Group_4_1__0 )
                    {
                     before(grammarAccess.getFullTextSearchAccess().getGroup_4_1()); 
                    // InternalQueryDsl.g:1286:3: ( rule__FullTextSearch__Group_4_1__0 )
                    // InternalQueryDsl.g:1286:4: rule__FullTextSearch__Group_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FullTextSearch__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFullTextSearchAccess().getGroup_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Alternatives_4"


    // $ANTLR start "rule__TransParam__TypeAlternatives_0"
    // InternalQueryDsl.g:1294:1: rule__TransParam__TypeAlternatives_0 : ( ( 'id' ) | ( 'name' ) );
    public final void rule__TransParam__TypeAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1298:1: ( ( 'id' ) | ( 'name' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            else if ( (LA8_0==14) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalQueryDsl.g:1299:2: ( 'id' )
                    {
                    // InternalQueryDsl.g:1299:2: ( 'id' )
                    // InternalQueryDsl.g:1300:3: 'id'
                    {
                     before(grammarAccess.getTransParamAccess().getTypeIdKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getTransParamAccess().getTypeIdKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1305:2: ( 'name' )
                    {
                    // InternalQueryDsl.g:1305:2: ( 'name' )
                    // InternalQueryDsl.g:1306:3: 'name'
                    {
                     before(grammarAccess.getTransParamAccess().getTypeNameKeyword_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getTransParamAccess().getTypeNameKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransParam__TypeAlternatives_0"


    // $ANTLR start "rule__Qattribute__TypeAlternatives_0"
    // InternalQueryDsl.g:1315:1: rule__Qattribute__TypeAlternatives_0 : ( ( 'qa' ) | ( 'qb' ) | ( 'qc' ) | ( 'qd' ) | ( 'qe' ) | ( 'qf' ) | ( 'qg' ) | ( 'qh' ) | ( 'qi' ) | ( 'qj' ) | ( 'qk' ) | ( 'ql' ) | ( 'qm' ) | ( 'qn' ) | ( 'qo' ) | ( 'qp' ) | ( 'qq' ) | ( 'qr' ) | ( 'qs' ) | ( 'qt' ) | ( 'qu' ) | ( 'qv' ) );
    public final void rule__Qattribute__TypeAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1319:1: ( ( 'qa' ) | ( 'qb' ) | ( 'qc' ) | ( 'qd' ) | ( 'qe' ) | ( 'qf' ) | ( 'qg' ) | ( 'qh' ) | ( 'qi' ) | ( 'qj' ) | ( 'qk' ) | ( 'ql' ) | ( 'qm' ) | ( 'qn' ) | ( 'qo' ) | ( 'qp' ) | ( 'qq' ) | ( 'qr' ) | ( 'qs' ) | ( 'qt' ) | ( 'qu' ) | ( 'qv' ) )
            int alt9=22;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt9=1;
                }
                break;
            case 16:
                {
                alt9=2;
                }
                break;
            case 17:
                {
                alt9=3;
                }
                break;
            case 18:
                {
                alt9=4;
                }
                break;
            case 19:
                {
                alt9=5;
                }
                break;
            case 20:
                {
                alt9=6;
                }
                break;
            case 21:
                {
                alt9=7;
                }
                break;
            case 22:
                {
                alt9=8;
                }
                break;
            case 23:
                {
                alt9=9;
                }
                break;
            case 24:
                {
                alt9=10;
                }
                break;
            case 25:
                {
                alt9=11;
                }
                break;
            case 26:
                {
                alt9=12;
                }
                break;
            case 27:
                {
                alt9=13;
                }
                break;
            case 28:
                {
                alt9=14;
                }
                break;
            case 29:
                {
                alt9=15;
                }
                break;
            case 30:
                {
                alt9=16;
                }
                break;
            case 31:
                {
                alt9=17;
                }
                break;
            case 32:
                {
                alt9=18;
                }
                break;
            case 33:
                {
                alt9=19;
                }
                break;
            case 34:
                {
                alt9=20;
                }
                break;
            case 35:
                {
                alt9=21;
                }
                break;
            case 36:
                {
                alt9=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalQueryDsl.g:1320:2: ( 'qa' )
                    {
                    // InternalQueryDsl.g:1320:2: ( 'qa' )
                    // InternalQueryDsl.g:1321:3: 'qa'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQaKeyword_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQaKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1326:2: ( 'qb' )
                    {
                    // InternalQueryDsl.g:1326:2: ( 'qb' )
                    // InternalQueryDsl.g:1327:3: 'qb'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQbKeyword_0_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQbKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1332:2: ( 'qc' )
                    {
                    // InternalQueryDsl.g:1332:2: ( 'qc' )
                    // InternalQueryDsl.g:1333:3: 'qc'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQcKeyword_0_2()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQcKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1338:2: ( 'qd' )
                    {
                    // InternalQueryDsl.g:1338:2: ( 'qd' )
                    // InternalQueryDsl.g:1339:3: 'qd'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQdKeyword_0_3()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQdKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1344:2: ( 'qe' )
                    {
                    // InternalQueryDsl.g:1344:2: ( 'qe' )
                    // InternalQueryDsl.g:1345:3: 'qe'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQeKeyword_0_4()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQeKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:1350:2: ( 'qf' )
                    {
                    // InternalQueryDsl.g:1350:2: ( 'qf' )
                    // InternalQueryDsl.g:1351:3: 'qf'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQfKeyword_0_5()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQfKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:1356:2: ( 'qg' )
                    {
                    // InternalQueryDsl.g:1356:2: ( 'qg' )
                    // InternalQueryDsl.g:1357:3: 'qg'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQgKeyword_0_6()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQgKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:1362:2: ( 'qh' )
                    {
                    // InternalQueryDsl.g:1362:2: ( 'qh' )
                    // InternalQueryDsl.g:1363:3: 'qh'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQhKeyword_0_7()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQhKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:1368:2: ( 'qi' )
                    {
                    // InternalQueryDsl.g:1368:2: ( 'qi' )
                    // InternalQueryDsl.g:1369:3: 'qi'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQiKeyword_0_8()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQiKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalQueryDsl.g:1374:2: ( 'qj' )
                    {
                    // InternalQueryDsl.g:1374:2: ( 'qj' )
                    // InternalQueryDsl.g:1375:3: 'qj'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQjKeyword_0_9()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQjKeyword_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalQueryDsl.g:1380:2: ( 'qk' )
                    {
                    // InternalQueryDsl.g:1380:2: ( 'qk' )
                    // InternalQueryDsl.g:1381:3: 'qk'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQkKeyword_0_10()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQkKeyword_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalQueryDsl.g:1386:2: ( 'ql' )
                    {
                    // InternalQueryDsl.g:1386:2: ( 'ql' )
                    // InternalQueryDsl.g:1387:3: 'ql'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQlKeyword_0_11()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQlKeyword_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalQueryDsl.g:1392:2: ( 'qm' )
                    {
                    // InternalQueryDsl.g:1392:2: ( 'qm' )
                    // InternalQueryDsl.g:1393:3: 'qm'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQmKeyword_0_12()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQmKeyword_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalQueryDsl.g:1398:2: ( 'qn' )
                    {
                    // InternalQueryDsl.g:1398:2: ( 'qn' )
                    // InternalQueryDsl.g:1399:3: 'qn'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQnKeyword_0_13()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQnKeyword_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalQueryDsl.g:1404:2: ( 'qo' )
                    {
                    // InternalQueryDsl.g:1404:2: ( 'qo' )
                    // InternalQueryDsl.g:1405:3: 'qo'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQoKeyword_0_14()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQoKeyword_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalQueryDsl.g:1410:2: ( 'qp' )
                    {
                    // InternalQueryDsl.g:1410:2: ( 'qp' )
                    // InternalQueryDsl.g:1411:3: 'qp'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQpKeyword_0_15()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQpKeyword_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalQueryDsl.g:1416:2: ( 'qq' )
                    {
                    // InternalQueryDsl.g:1416:2: ( 'qq' )
                    // InternalQueryDsl.g:1417:3: 'qq'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQqKeyword_0_16()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQqKeyword_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalQueryDsl.g:1422:2: ( 'qr' )
                    {
                    // InternalQueryDsl.g:1422:2: ( 'qr' )
                    // InternalQueryDsl.g:1423:3: 'qr'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQrKeyword_0_17()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQrKeyword_0_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalQueryDsl.g:1428:2: ( 'qs' )
                    {
                    // InternalQueryDsl.g:1428:2: ( 'qs' )
                    // InternalQueryDsl.g:1429:3: 'qs'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQsKeyword_0_18()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQsKeyword_0_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalQueryDsl.g:1434:2: ( 'qt' )
                    {
                    // InternalQueryDsl.g:1434:2: ( 'qt' )
                    // InternalQueryDsl.g:1435:3: 'qt'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQtKeyword_0_19()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQtKeyword_0_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalQueryDsl.g:1440:2: ( 'qu' )
                    {
                    // InternalQueryDsl.g:1440:2: ( 'qu' )
                    // InternalQueryDsl.g:1441:3: 'qu'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQuKeyword_0_20()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQuKeyword_0_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalQueryDsl.g:1446:2: ( 'qv' )
                    {
                    // InternalQueryDsl.g:1446:2: ( 'qv' )
                    // InternalQueryDsl.g:1447:3: 'qv'
                    {
                     before(grammarAccess.getQattributeAccess().getTypeQvKeyword_0_21()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getQattributeAccess().getTypeQvKeyword_0_21()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qattribute__TypeAlternatives_0"


    // $ANTLR start "rule__Operator__OpAlternatives_0"
    // InternalQueryDsl.g:1456:1: rule__Operator__OpAlternatives_0 : ( ( 'AND' ) | ( 'OR' ) | ( 'EXACT' ) );
    public final void rule__Operator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1460:1: ( ( 'AND' ) | ( 'OR' ) | ( 'EXACT' ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt10=1;
                }
                break;
            case 38:
                {
                alt10=2;
                }
                break;
            case 39:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalQueryDsl.g:1461:2: ( 'AND' )
                    {
                    // InternalQueryDsl.g:1461:2: ( 'AND' )
                    // InternalQueryDsl.g:1462:3: 'AND'
                    {
                     before(grammarAccess.getOperatorAccess().getOpANDKeyword_0_0()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getOpANDKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1467:2: ( 'OR' )
                    {
                    // InternalQueryDsl.g:1467:2: ( 'OR' )
                    // InternalQueryDsl.g:1468:3: 'OR'
                    {
                     before(grammarAccess.getOperatorAccess().getOpORKeyword_0_1()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getOpORKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1473:2: ( 'EXACT' )
                    {
                    // InternalQueryDsl.g:1473:2: ( 'EXACT' )
                    // InternalQueryDsl.g:1474:3: 'EXACT'
                    {
                     before(grammarAccess.getOperatorAccess().getOpEXACTKeyword_0_2()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getOpEXACTKeyword_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__OpAlternatives_0"


    // $ANTLR start "rule__Comparison__TypeAlternatives_0"
    // InternalQueryDsl.g:1483:1: rule__Comparison__TypeAlternatives_0 : ( ( '==' ) | ( '>=' ) | ( '<=' ) | ( '<' ) | ( '>' ) );
    public final void rule__Comparison__TypeAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1487:1: ( ( '==' ) | ( '>=' ) | ( '<=' ) | ( '<' ) | ( '>' ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt11=1;
                }
                break;
            case 41:
                {
                alt11=2;
                }
                break;
            case 42:
                {
                alt11=3;
                }
                break;
            case 43:
                {
                alt11=4;
                }
                break;
            case 44:
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalQueryDsl.g:1488:2: ( '==' )
                    {
                    // InternalQueryDsl.g:1488:2: ( '==' )
                    // InternalQueryDsl.g:1489:3: '=='
                    {
                     before(grammarAccess.getComparisonAccess().getTypeEqualsSignEqualsSignKeyword_0_0()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getTypeEqualsSignEqualsSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1494:2: ( '>=' )
                    {
                    // InternalQueryDsl.g:1494:2: ( '>=' )
                    // InternalQueryDsl.g:1495:3: '>='
                    {
                     before(grammarAccess.getComparisonAccess().getTypeGreaterThanSignEqualsSignKeyword_0_1()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getTypeGreaterThanSignEqualsSignKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1500:2: ( '<=' )
                    {
                    // InternalQueryDsl.g:1500:2: ( '<=' )
                    // InternalQueryDsl.g:1501:3: '<='
                    {
                     before(grammarAccess.getComparisonAccess().getTypeLessThanSignEqualsSignKeyword_0_2()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getTypeLessThanSignEqualsSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1506:2: ( '<' )
                    {
                    // InternalQueryDsl.g:1506:2: ( '<' )
                    // InternalQueryDsl.g:1507:3: '<'
                    {
                     before(grammarAccess.getComparisonAccess().getTypeLessThanSignKeyword_0_3()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getTypeLessThanSignKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1512:2: ( '>' )
                    {
                    // InternalQueryDsl.g:1512:2: ( '>' )
                    // InternalQueryDsl.g:1513:3: '>'
                    {
                     before(grammarAccess.getComparisonAccess().getTypeGreaterThanSignKeyword_0_4()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getTypeGreaterThanSignKeyword_0_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__TypeAlternatives_0"


    // $ANTLR start "rule__FilterKeyword__TypeAlternatives_0"
    // InternalQueryDsl.g:1522:1: rule__FilterKeyword__TypeAlternatives_0 : ( ( 'gte' ) | ( 'lte' ) | ( 'lt' ) | ( 'gt' ) );
    public final void rule__FilterKeyword__TypeAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1526:1: ( ( 'gte' ) | ( 'lte' ) | ( 'lt' ) | ( 'gt' ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt12=1;
                }
                break;
            case 46:
                {
                alt12=2;
                }
                break;
            case 47:
                {
                alt12=3;
                }
                break;
            case 48:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalQueryDsl.g:1527:2: ( 'gte' )
                    {
                    // InternalQueryDsl.g:1527:2: ( 'gte' )
                    // InternalQueryDsl.g:1528:3: 'gte'
                    {
                     before(grammarAccess.getFilterKeywordAccess().getTypeGteKeyword_0_0()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getFilterKeywordAccess().getTypeGteKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1533:2: ( 'lte' )
                    {
                    // InternalQueryDsl.g:1533:2: ( 'lte' )
                    // InternalQueryDsl.g:1534:3: 'lte'
                    {
                     before(grammarAccess.getFilterKeywordAccess().getTypeLteKeyword_0_1()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getFilterKeywordAccess().getTypeLteKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1539:2: ( 'lt' )
                    {
                    // InternalQueryDsl.g:1539:2: ( 'lt' )
                    // InternalQueryDsl.g:1540:3: 'lt'
                    {
                     before(grammarAccess.getFilterKeywordAccess().getTypeLtKeyword_0_2()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getFilterKeywordAccess().getTypeLtKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1545:2: ( 'gt' )
                    {
                    // InternalQueryDsl.g:1545:2: ( 'gt' )
                    // InternalQueryDsl.g:1546:3: 'gt'
                    {
                     before(grammarAccess.getFilterKeywordAccess().getTypeGtKeyword_0_3()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getFilterKeywordAccess().getTypeGtKeyword_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterKeyword__TypeAlternatives_0"


    // $ANTLR start "rule__UserField__TypeNameAlternatives_0"
    // InternalQueryDsl.g:1555:1: rule__UserField__TypeNameAlternatives_0 : ( ( 'id' ) | ( 'username' ) | ( 'email' ) | ( 'createdAt' ) | ( 'updatedAt' ) );
    public final void rule__UserField__TypeNameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1559:1: ( ( 'id' ) | ( 'username' ) | ( 'email' ) | ( 'createdAt' ) | ( 'updatedAt' ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt13=1;
                }
                break;
            case 49:
                {
                alt13=2;
                }
                break;
            case 50:
                {
                alt13=3;
                }
                break;
            case 51:
                {
                alt13=4;
                }
                break;
            case 52:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalQueryDsl.g:1560:2: ( 'id' )
                    {
                    // InternalQueryDsl.g:1560:2: ( 'id' )
                    // InternalQueryDsl.g:1561:3: 'id'
                    {
                     before(grammarAccess.getUserFieldAccess().getTypeNameIdKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getUserFieldAccess().getTypeNameIdKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1566:2: ( 'username' )
                    {
                    // InternalQueryDsl.g:1566:2: ( 'username' )
                    // InternalQueryDsl.g:1567:3: 'username'
                    {
                     before(grammarAccess.getUserFieldAccess().getTypeNameUsernameKeyword_0_1()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getUserFieldAccess().getTypeNameUsernameKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1572:2: ( 'email' )
                    {
                    // InternalQueryDsl.g:1572:2: ( 'email' )
                    // InternalQueryDsl.g:1573:3: 'email'
                    {
                     before(grammarAccess.getUserFieldAccess().getTypeNameEmailKeyword_0_2()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getUserFieldAccess().getTypeNameEmailKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1578:2: ( 'createdAt' )
                    {
                    // InternalQueryDsl.g:1578:2: ( 'createdAt' )
                    // InternalQueryDsl.g:1579:3: 'createdAt'
                    {
                     before(grammarAccess.getUserFieldAccess().getTypeNameCreatedAtKeyword_0_3()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getUserFieldAccess().getTypeNameCreatedAtKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1584:2: ( 'updatedAt' )
                    {
                    // InternalQueryDsl.g:1584:2: ( 'updatedAt' )
                    // InternalQueryDsl.g:1585:3: 'updatedAt'
                    {
                     before(grammarAccess.getUserFieldAccess().getTypeNameUpdatedAtKeyword_0_4()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getUserFieldAccess().getTypeNameUpdatedAtKeyword_0_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserField__TypeNameAlternatives_0"


    // $ANTLR start "rule__WorkspaceField__TypeNameAlternatives_0"
    // InternalQueryDsl.g:1594:1: rule__WorkspaceField__TypeNameAlternatives_0 : ( ( 'id' ) | ( 'name' ) | ( 'description' ) | ( 'owner' ) | ( 'projects' ) | ( 'createdAt' ) | ( 'updatedAt' ) );
    public final void rule__WorkspaceField__TypeNameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1598:1: ( ( 'id' ) | ( 'name' ) | ( 'description' ) | ( 'owner' ) | ( 'projects' ) | ( 'createdAt' ) | ( 'updatedAt' ) )
            int alt14=7;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt14=1;
                }
                break;
            case 14:
                {
                alt14=2;
                }
                break;
            case 53:
                {
                alt14=3;
                }
                break;
            case 54:
                {
                alt14=4;
                }
                break;
            case 55:
                {
                alt14=5;
                }
                break;
            case 51:
                {
                alt14=6;
                }
                break;
            case 52:
                {
                alt14=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalQueryDsl.g:1599:2: ( 'id' )
                    {
                    // InternalQueryDsl.g:1599:2: ( 'id' )
                    // InternalQueryDsl.g:1600:3: 'id'
                    {
                     before(grammarAccess.getWorkspaceFieldAccess().getTypeNameIdKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getWorkspaceFieldAccess().getTypeNameIdKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1605:2: ( 'name' )
                    {
                    // InternalQueryDsl.g:1605:2: ( 'name' )
                    // InternalQueryDsl.g:1606:3: 'name'
                    {
                     before(grammarAccess.getWorkspaceFieldAccess().getTypeNameNameKeyword_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getWorkspaceFieldAccess().getTypeNameNameKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1611:2: ( 'description' )
                    {
                    // InternalQueryDsl.g:1611:2: ( 'description' )
                    // InternalQueryDsl.g:1612:3: 'description'
                    {
                     before(grammarAccess.getWorkspaceFieldAccess().getTypeNameDescriptionKeyword_0_2()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getWorkspaceFieldAccess().getTypeNameDescriptionKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1617:2: ( 'owner' )
                    {
                    // InternalQueryDsl.g:1617:2: ( 'owner' )
                    // InternalQueryDsl.g:1618:3: 'owner'
                    {
                     before(grammarAccess.getWorkspaceFieldAccess().getTypeNameOwnerKeyword_0_3()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getWorkspaceFieldAccess().getTypeNameOwnerKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1623:2: ( 'projects' )
                    {
                    // InternalQueryDsl.g:1623:2: ( 'projects' )
                    // InternalQueryDsl.g:1624:3: 'projects'
                    {
                     before(grammarAccess.getWorkspaceFieldAccess().getTypeNameProjectsKeyword_0_4()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getWorkspaceFieldAccess().getTypeNameProjectsKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:1629:2: ( 'createdAt' )
                    {
                    // InternalQueryDsl.g:1629:2: ( 'createdAt' )
                    // InternalQueryDsl.g:1630:3: 'createdAt'
                    {
                     before(grammarAccess.getWorkspaceFieldAccess().getTypeNameCreatedAtKeyword_0_5()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getWorkspaceFieldAccess().getTypeNameCreatedAtKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:1635:2: ( 'updatedAt' )
                    {
                    // InternalQueryDsl.g:1635:2: ( 'updatedAt' )
                    // InternalQueryDsl.g:1636:3: 'updatedAt'
                    {
                     before(grammarAccess.getWorkspaceFieldAccess().getTypeNameUpdatedAtKeyword_0_6()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getWorkspaceFieldAccess().getTypeNameUpdatedAtKeyword_0_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceField__TypeNameAlternatives_0"


    // $ANTLR start "rule__ProjectField__TypeNameAlternatives_0"
    // InternalQueryDsl.g:1645:1: rule__ProjectField__TypeNameAlternatives_0 : ( ( 'id' ) | ( 'name' ) | ( 'description' ) | ( 'user' ) | ( 'workspace' ) | ( 'sharedUser' ) | ( 'comments' ) | ( 'createdAt' ) | ( 'updatedAt' ) );
    public final void rule__ProjectField__TypeNameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1649:1: ( ( 'id' ) | ( 'name' ) | ( 'description' ) | ( 'user' ) | ( 'workspace' ) | ( 'sharedUser' ) | ( 'comments' ) | ( 'createdAt' ) | ( 'updatedAt' ) )
            int alt15=9;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt15=1;
                }
                break;
            case 14:
                {
                alt15=2;
                }
                break;
            case 53:
                {
                alt15=3;
                }
                break;
            case 56:
                {
                alt15=4;
                }
                break;
            case 57:
                {
                alt15=5;
                }
                break;
            case 58:
                {
                alt15=6;
                }
                break;
            case 59:
                {
                alt15=7;
                }
                break;
            case 51:
                {
                alt15=8;
                }
                break;
            case 52:
                {
                alt15=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalQueryDsl.g:1650:2: ( 'id' )
                    {
                    // InternalQueryDsl.g:1650:2: ( 'id' )
                    // InternalQueryDsl.g:1651:3: 'id'
                    {
                     before(grammarAccess.getProjectFieldAccess().getTypeNameIdKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getProjectFieldAccess().getTypeNameIdKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1656:2: ( 'name' )
                    {
                    // InternalQueryDsl.g:1656:2: ( 'name' )
                    // InternalQueryDsl.g:1657:3: 'name'
                    {
                     before(grammarAccess.getProjectFieldAccess().getTypeNameNameKeyword_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getProjectFieldAccess().getTypeNameNameKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1662:2: ( 'description' )
                    {
                    // InternalQueryDsl.g:1662:2: ( 'description' )
                    // InternalQueryDsl.g:1663:3: 'description'
                    {
                     before(grammarAccess.getProjectFieldAccess().getTypeNameDescriptionKeyword_0_2()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getProjectFieldAccess().getTypeNameDescriptionKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1668:2: ( 'user' )
                    {
                    // InternalQueryDsl.g:1668:2: ( 'user' )
                    // InternalQueryDsl.g:1669:3: 'user'
                    {
                     before(grammarAccess.getProjectFieldAccess().getTypeNameUserKeyword_0_3()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getProjectFieldAccess().getTypeNameUserKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1674:2: ( 'workspace' )
                    {
                    // InternalQueryDsl.g:1674:2: ( 'workspace' )
                    // InternalQueryDsl.g:1675:3: 'workspace'
                    {
                     before(grammarAccess.getProjectFieldAccess().getTypeNameWorkspaceKeyword_0_4()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getProjectFieldAccess().getTypeNameWorkspaceKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:1680:2: ( 'sharedUser' )
                    {
                    // InternalQueryDsl.g:1680:2: ( 'sharedUser' )
                    // InternalQueryDsl.g:1681:3: 'sharedUser'
                    {
                     before(grammarAccess.getProjectFieldAccess().getTypeNameSharedUserKeyword_0_5()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getProjectFieldAccess().getTypeNameSharedUserKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:1686:2: ( 'comments' )
                    {
                    // InternalQueryDsl.g:1686:2: ( 'comments' )
                    // InternalQueryDsl.g:1687:3: 'comments'
                    {
                     before(grammarAccess.getProjectFieldAccess().getTypeNameCommentsKeyword_0_6()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getProjectFieldAccess().getTypeNameCommentsKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:1692:2: ( 'createdAt' )
                    {
                    // InternalQueryDsl.g:1692:2: ( 'createdAt' )
                    // InternalQueryDsl.g:1693:3: 'createdAt'
                    {
                     before(grammarAccess.getProjectFieldAccess().getTypeNameCreatedAtKeyword_0_7()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getProjectFieldAccess().getTypeNameCreatedAtKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:1698:2: ( 'updatedAt' )
                    {
                    // InternalQueryDsl.g:1698:2: ( 'updatedAt' )
                    // InternalQueryDsl.g:1699:3: 'updatedAt'
                    {
                     before(grammarAccess.getProjectFieldAccess().getTypeNameUpdatedAtKeyword_0_8()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getProjectFieldAccess().getTypeNameUpdatedAtKeyword_0_8()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectField__TypeNameAlternatives_0"


    // $ANTLR start "rule__MetamodelField__TypeNameAlternatives_0"
    // InternalQueryDsl.g:1708:1: rule__MetamodelField__TypeNameAlternatives_0 : ( ( 'id' ) | ( 'accessControl' ) | ( 'description' ) | ( 'ePackage' ) | ( 'ext' ) | ( 'involvedOperations' ) | ( 'metrics' ) | ( 'models' ) | ( 'license' ) | ( 'metamodel' ) | ( 'name' ) | ( 'project' ) | ( 'size' ) | ( 'storageUrl' ) | ( 'type' ) | ( 'unique_name' ) | ( 'createdAt' ) | ( 'updatedAt' ) );
    public final void rule__MetamodelField__TypeNameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1712:1: ( ( 'id' ) | ( 'accessControl' ) | ( 'description' ) | ( 'ePackage' ) | ( 'ext' ) | ( 'involvedOperations' ) | ( 'metrics' ) | ( 'models' ) | ( 'license' ) | ( 'metamodel' ) | ( 'name' ) | ( 'project' ) | ( 'size' ) | ( 'storageUrl' ) | ( 'type' ) | ( 'unique_name' ) | ( 'createdAt' ) | ( 'updatedAt' ) )
            int alt16=18;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt16=1;
                }
                break;
            case 60:
                {
                alt16=2;
                }
                break;
            case 53:
                {
                alt16=3;
                }
                break;
            case 61:
                {
                alt16=4;
                }
                break;
            case 62:
                {
                alt16=5;
                }
                break;
            case 63:
                {
                alt16=6;
                }
                break;
            case 64:
                {
                alt16=7;
                }
                break;
            case 65:
                {
                alt16=8;
                }
                break;
            case 66:
                {
                alt16=9;
                }
                break;
            case 67:
                {
                alt16=10;
                }
                break;
            case 14:
                {
                alt16=11;
                }
                break;
            case 68:
                {
                alt16=12;
                }
                break;
            case 69:
                {
                alt16=13;
                }
                break;
            case 70:
                {
                alt16=14;
                }
                break;
            case 71:
                {
                alt16=15;
                }
                break;
            case 72:
                {
                alt16=16;
                }
                break;
            case 51:
                {
                alt16=17;
                }
                break;
            case 52:
                {
                alt16=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalQueryDsl.g:1713:2: ( 'id' )
                    {
                    // InternalQueryDsl.g:1713:2: ( 'id' )
                    // InternalQueryDsl.g:1714:3: 'id'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameIdKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameIdKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1719:2: ( 'accessControl' )
                    {
                    // InternalQueryDsl.g:1719:2: ( 'accessControl' )
                    // InternalQueryDsl.g:1720:3: 'accessControl'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameAccessControlKeyword_0_1()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameAccessControlKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1725:2: ( 'description' )
                    {
                    // InternalQueryDsl.g:1725:2: ( 'description' )
                    // InternalQueryDsl.g:1726:3: 'description'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameDescriptionKeyword_0_2()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameDescriptionKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1731:2: ( 'ePackage' )
                    {
                    // InternalQueryDsl.g:1731:2: ( 'ePackage' )
                    // InternalQueryDsl.g:1732:3: 'ePackage'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameEPackageKeyword_0_3()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameEPackageKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1737:2: ( 'ext' )
                    {
                    // InternalQueryDsl.g:1737:2: ( 'ext' )
                    // InternalQueryDsl.g:1738:3: 'ext'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameExtKeyword_0_4()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameExtKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:1743:2: ( 'involvedOperations' )
                    {
                    // InternalQueryDsl.g:1743:2: ( 'involvedOperations' )
                    // InternalQueryDsl.g:1744:3: 'involvedOperations'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameInvolvedOperationsKeyword_0_5()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameInvolvedOperationsKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:1749:2: ( 'metrics' )
                    {
                    // InternalQueryDsl.g:1749:2: ( 'metrics' )
                    // InternalQueryDsl.g:1750:3: 'metrics'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameMetricsKeyword_0_6()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameMetricsKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:1755:2: ( 'models' )
                    {
                    // InternalQueryDsl.g:1755:2: ( 'models' )
                    // InternalQueryDsl.g:1756:3: 'models'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameModelsKeyword_0_7()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameModelsKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:1761:2: ( 'license' )
                    {
                    // InternalQueryDsl.g:1761:2: ( 'license' )
                    // InternalQueryDsl.g:1762:3: 'license'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameLicenseKeyword_0_8()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameLicenseKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalQueryDsl.g:1767:2: ( 'metamodel' )
                    {
                    // InternalQueryDsl.g:1767:2: ( 'metamodel' )
                    // InternalQueryDsl.g:1768:3: 'metamodel'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameMetamodelKeyword_0_9()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameMetamodelKeyword_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalQueryDsl.g:1773:2: ( 'name' )
                    {
                    // InternalQueryDsl.g:1773:2: ( 'name' )
                    // InternalQueryDsl.g:1774:3: 'name'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameNameKeyword_0_10()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameNameKeyword_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalQueryDsl.g:1779:2: ( 'project' )
                    {
                    // InternalQueryDsl.g:1779:2: ( 'project' )
                    // InternalQueryDsl.g:1780:3: 'project'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameProjectKeyword_0_11()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameProjectKeyword_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalQueryDsl.g:1785:2: ( 'size' )
                    {
                    // InternalQueryDsl.g:1785:2: ( 'size' )
                    // InternalQueryDsl.g:1786:3: 'size'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameSizeKeyword_0_12()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameSizeKeyword_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalQueryDsl.g:1791:2: ( 'storageUrl' )
                    {
                    // InternalQueryDsl.g:1791:2: ( 'storageUrl' )
                    // InternalQueryDsl.g:1792:3: 'storageUrl'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameStorageUrlKeyword_0_13()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameStorageUrlKeyword_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalQueryDsl.g:1797:2: ( 'type' )
                    {
                    // InternalQueryDsl.g:1797:2: ( 'type' )
                    // InternalQueryDsl.g:1798:3: 'type'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameTypeKeyword_0_14()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameTypeKeyword_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalQueryDsl.g:1803:2: ( 'unique_name' )
                    {
                    // InternalQueryDsl.g:1803:2: ( 'unique_name' )
                    // InternalQueryDsl.g:1804:3: 'unique_name'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameUnique_nameKeyword_0_15()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameUnique_nameKeyword_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalQueryDsl.g:1809:2: ( 'createdAt' )
                    {
                    // InternalQueryDsl.g:1809:2: ( 'createdAt' )
                    // InternalQueryDsl.g:1810:3: 'createdAt'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameCreatedAtKeyword_0_16()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameCreatedAtKeyword_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalQueryDsl.g:1815:2: ( 'updatedAt' )
                    {
                    // InternalQueryDsl.g:1815:2: ( 'updatedAt' )
                    // InternalQueryDsl.g:1816:3: 'updatedAt'
                    {
                     before(grammarAccess.getMetamodelFieldAccess().getTypeNameUpdatedAtKeyword_0_17()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getMetamodelFieldAccess().getTypeNameUpdatedAtKeyword_0_17()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelField__TypeNameAlternatives_0"


    // $ANTLR start "rule__ModelField__TypeNameAlternatives_0"
    // InternalQueryDsl.g:1825:1: rule__ModelField__TypeNameAlternatives_0 : ( ( 'id' ) | ( 'accessControl' ) | ( 'description' ) | ( 'ext' ) | ( 'involvedOperations' ) | ( 'license' ) | ( 'metamodel' ) | ( 'name' ) | ( 'project' ) | ( 'size' ) | ( 'storageUrl' ) | ( 'type' ) | ( 'unique_name' ) | ( 'createdAt' ) | ( 'updatedAt' ) );
    public final void rule__ModelField__TypeNameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1829:1: ( ( 'id' ) | ( 'accessControl' ) | ( 'description' ) | ( 'ext' ) | ( 'involvedOperations' ) | ( 'license' ) | ( 'metamodel' ) | ( 'name' ) | ( 'project' ) | ( 'size' ) | ( 'storageUrl' ) | ( 'type' ) | ( 'unique_name' ) | ( 'createdAt' ) | ( 'updatedAt' ) )
            int alt17=15;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt17=1;
                }
                break;
            case 60:
                {
                alt17=2;
                }
                break;
            case 53:
                {
                alt17=3;
                }
                break;
            case 62:
                {
                alt17=4;
                }
                break;
            case 63:
                {
                alt17=5;
                }
                break;
            case 66:
                {
                alt17=6;
                }
                break;
            case 67:
                {
                alt17=7;
                }
                break;
            case 14:
                {
                alt17=8;
                }
                break;
            case 68:
                {
                alt17=9;
                }
                break;
            case 69:
                {
                alt17=10;
                }
                break;
            case 70:
                {
                alt17=11;
                }
                break;
            case 71:
                {
                alt17=12;
                }
                break;
            case 72:
                {
                alt17=13;
                }
                break;
            case 51:
                {
                alt17=14;
                }
                break;
            case 52:
                {
                alt17=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalQueryDsl.g:1830:2: ( 'id' )
                    {
                    // InternalQueryDsl.g:1830:2: ( 'id' )
                    // InternalQueryDsl.g:1831:3: 'id'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameIdKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameIdKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1836:2: ( 'accessControl' )
                    {
                    // InternalQueryDsl.g:1836:2: ( 'accessControl' )
                    // InternalQueryDsl.g:1837:3: 'accessControl'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameAccessControlKeyword_0_1()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameAccessControlKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1842:2: ( 'description' )
                    {
                    // InternalQueryDsl.g:1842:2: ( 'description' )
                    // InternalQueryDsl.g:1843:3: 'description'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameDescriptionKeyword_0_2()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameDescriptionKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1848:2: ( 'ext' )
                    {
                    // InternalQueryDsl.g:1848:2: ( 'ext' )
                    // InternalQueryDsl.g:1849:3: 'ext'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameExtKeyword_0_3()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameExtKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1854:2: ( 'involvedOperations' )
                    {
                    // InternalQueryDsl.g:1854:2: ( 'involvedOperations' )
                    // InternalQueryDsl.g:1855:3: 'involvedOperations'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameInvolvedOperationsKeyword_0_4()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameInvolvedOperationsKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:1860:2: ( 'license' )
                    {
                    // InternalQueryDsl.g:1860:2: ( 'license' )
                    // InternalQueryDsl.g:1861:3: 'license'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameLicenseKeyword_0_5()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameLicenseKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:1866:2: ( 'metamodel' )
                    {
                    // InternalQueryDsl.g:1866:2: ( 'metamodel' )
                    // InternalQueryDsl.g:1867:3: 'metamodel'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameMetamodelKeyword_0_6()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameMetamodelKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:1872:2: ( 'name' )
                    {
                    // InternalQueryDsl.g:1872:2: ( 'name' )
                    // InternalQueryDsl.g:1873:3: 'name'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameNameKeyword_0_7()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameNameKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:1878:2: ( 'project' )
                    {
                    // InternalQueryDsl.g:1878:2: ( 'project' )
                    // InternalQueryDsl.g:1879:3: 'project'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameProjectKeyword_0_8()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameProjectKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalQueryDsl.g:1884:2: ( 'size' )
                    {
                    // InternalQueryDsl.g:1884:2: ( 'size' )
                    // InternalQueryDsl.g:1885:3: 'size'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameSizeKeyword_0_9()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameSizeKeyword_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalQueryDsl.g:1890:2: ( 'storageUrl' )
                    {
                    // InternalQueryDsl.g:1890:2: ( 'storageUrl' )
                    // InternalQueryDsl.g:1891:3: 'storageUrl'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameStorageUrlKeyword_0_10()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameStorageUrlKeyword_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalQueryDsl.g:1896:2: ( 'type' )
                    {
                    // InternalQueryDsl.g:1896:2: ( 'type' )
                    // InternalQueryDsl.g:1897:3: 'type'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameTypeKeyword_0_11()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameTypeKeyword_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalQueryDsl.g:1902:2: ( 'unique_name' )
                    {
                    // InternalQueryDsl.g:1902:2: ( 'unique_name' )
                    // InternalQueryDsl.g:1903:3: 'unique_name'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameUnique_nameKeyword_0_12()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameUnique_nameKeyword_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalQueryDsl.g:1908:2: ( 'createdAt' )
                    {
                    // InternalQueryDsl.g:1908:2: ( 'createdAt' )
                    // InternalQueryDsl.g:1909:3: 'createdAt'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameCreatedAtKeyword_0_13()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameCreatedAtKeyword_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalQueryDsl.g:1914:2: ( 'updatedAt' )
                    {
                    // InternalQueryDsl.g:1914:2: ( 'updatedAt' )
                    // InternalQueryDsl.g:1915:3: 'updatedAt'
                    {
                     before(grammarAccess.getModelFieldAccess().getTypeNameUpdatedAtKeyword_0_14()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getModelFieldAccess().getTypeNameUpdatedAtKeyword_0_14()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelField__TypeNameAlternatives_0"


    // $ANTLR start "rule__DslField__TypeNameAlternatives_0"
    // InternalQueryDsl.g:1924:1: rule__DslField__TypeNameAlternatives_0 : ( ( 'id' ) | ( 'accessControl' ) | ( 'description' ) | ( 'ext' ) | ( 'involvedOperations' ) | ( 'license' ) | ( 'name' ) | ( 'project' ) | ( 'size' ) | ( 'storageUrl' ) | ( 'type' ) | ( 'unique_name' ) | ( 'createdAt' ) | ( 'updatedAt' ) );
    public final void rule__DslField__TypeNameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1928:1: ( ( 'id' ) | ( 'accessControl' ) | ( 'description' ) | ( 'ext' ) | ( 'involvedOperations' ) | ( 'license' ) | ( 'name' ) | ( 'project' ) | ( 'size' ) | ( 'storageUrl' ) | ( 'type' ) | ( 'unique_name' ) | ( 'createdAt' ) | ( 'updatedAt' ) )
            int alt18=14;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt18=1;
                }
                break;
            case 60:
                {
                alt18=2;
                }
                break;
            case 53:
                {
                alt18=3;
                }
                break;
            case 62:
                {
                alt18=4;
                }
                break;
            case 63:
                {
                alt18=5;
                }
                break;
            case 66:
                {
                alt18=6;
                }
                break;
            case 14:
                {
                alt18=7;
                }
                break;
            case 68:
                {
                alt18=8;
                }
                break;
            case 69:
                {
                alt18=9;
                }
                break;
            case 70:
                {
                alt18=10;
                }
                break;
            case 71:
                {
                alt18=11;
                }
                break;
            case 72:
                {
                alt18=12;
                }
                break;
            case 51:
                {
                alt18=13;
                }
                break;
            case 52:
                {
                alt18=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalQueryDsl.g:1929:2: ( 'id' )
                    {
                    // InternalQueryDsl.g:1929:2: ( 'id' )
                    // InternalQueryDsl.g:1930:3: 'id'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameIdKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameIdKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:1935:2: ( 'accessControl' )
                    {
                    // InternalQueryDsl.g:1935:2: ( 'accessControl' )
                    // InternalQueryDsl.g:1936:3: 'accessControl'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameAccessControlKeyword_0_1()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameAccessControlKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:1941:2: ( 'description' )
                    {
                    // InternalQueryDsl.g:1941:2: ( 'description' )
                    // InternalQueryDsl.g:1942:3: 'description'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameDescriptionKeyword_0_2()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameDescriptionKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:1947:2: ( 'ext' )
                    {
                    // InternalQueryDsl.g:1947:2: ( 'ext' )
                    // InternalQueryDsl.g:1948:3: 'ext'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameExtKeyword_0_3()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameExtKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:1953:2: ( 'involvedOperations' )
                    {
                    // InternalQueryDsl.g:1953:2: ( 'involvedOperations' )
                    // InternalQueryDsl.g:1954:3: 'involvedOperations'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameInvolvedOperationsKeyword_0_4()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameInvolvedOperationsKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:1959:2: ( 'license' )
                    {
                    // InternalQueryDsl.g:1959:2: ( 'license' )
                    // InternalQueryDsl.g:1960:3: 'license'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameLicenseKeyword_0_5()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameLicenseKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:1965:2: ( 'name' )
                    {
                    // InternalQueryDsl.g:1965:2: ( 'name' )
                    // InternalQueryDsl.g:1966:3: 'name'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameNameKeyword_0_6()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameNameKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:1971:2: ( 'project' )
                    {
                    // InternalQueryDsl.g:1971:2: ( 'project' )
                    // InternalQueryDsl.g:1972:3: 'project'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameProjectKeyword_0_7()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameProjectKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:1977:2: ( 'size' )
                    {
                    // InternalQueryDsl.g:1977:2: ( 'size' )
                    // InternalQueryDsl.g:1978:3: 'size'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameSizeKeyword_0_8()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameSizeKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalQueryDsl.g:1983:2: ( 'storageUrl' )
                    {
                    // InternalQueryDsl.g:1983:2: ( 'storageUrl' )
                    // InternalQueryDsl.g:1984:3: 'storageUrl'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameStorageUrlKeyword_0_9()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameStorageUrlKeyword_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalQueryDsl.g:1989:2: ( 'type' )
                    {
                    // InternalQueryDsl.g:1989:2: ( 'type' )
                    // InternalQueryDsl.g:1990:3: 'type'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameTypeKeyword_0_10()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameTypeKeyword_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalQueryDsl.g:1995:2: ( 'unique_name' )
                    {
                    // InternalQueryDsl.g:1995:2: ( 'unique_name' )
                    // InternalQueryDsl.g:1996:3: 'unique_name'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameUnique_nameKeyword_0_11()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameUnique_nameKeyword_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalQueryDsl.g:2001:2: ( 'createdAt' )
                    {
                    // InternalQueryDsl.g:2001:2: ( 'createdAt' )
                    // InternalQueryDsl.g:2002:3: 'createdAt'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameCreatedAtKeyword_0_12()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameCreatedAtKeyword_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalQueryDsl.g:2007:2: ( 'updatedAt' )
                    {
                    // InternalQueryDsl.g:2007:2: ( 'updatedAt' )
                    // InternalQueryDsl.g:2008:3: 'updatedAt'
                    {
                     before(grammarAccess.getDslFieldAccess().getTypeNameUpdatedAtKeyword_0_13()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getDslFieldAccess().getTypeNameUpdatedAtKeyword_0_13()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DslField__TypeNameAlternatives_0"


    // $ANTLR start "rule__UserParam__TypeNameAlternatives_0"
    // InternalQueryDsl.g:2017:1: rule__UserParam__TypeNameAlternatives_0 : ( ( 'username' ) | ( 'userId' ) | ( 'email' ) );
    public final void rule__UserParam__TypeNameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2021:1: ( ( 'username' ) | ( 'userId' ) | ( 'email' ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt19=1;
                }
                break;
            case 73:
                {
                alt19=2;
                }
                break;
            case 50:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalQueryDsl.g:2022:2: ( 'username' )
                    {
                    // InternalQueryDsl.g:2022:2: ( 'username' )
                    // InternalQueryDsl.g:2023:3: 'username'
                    {
                     before(grammarAccess.getUserParamAccess().getTypeNameUsernameKeyword_0_0()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getUserParamAccess().getTypeNameUsernameKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2028:2: ( 'userId' )
                    {
                    // InternalQueryDsl.g:2028:2: ( 'userId' )
                    // InternalQueryDsl.g:2029:3: 'userId'
                    {
                     before(grammarAccess.getUserParamAccess().getTypeNameUserIdKeyword_0_1()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getUserParamAccess().getTypeNameUserIdKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2034:2: ( 'email' )
                    {
                    // InternalQueryDsl.g:2034:2: ( 'email' )
                    // InternalQueryDsl.g:2035:3: 'email'
                    {
                     before(grammarAccess.getUserParamAccess().getTypeNameEmailKeyword_0_2()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getUserParamAccess().getTypeNameEmailKeyword_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserParam__TypeNameAlternatives_0"


    // $ANTLR start "rule__WorkspaceParam__TypeNameAlternatives_0"
    // InternalQueryDsl.g:2044:1: rule__WorkspaceParam__TypeNameAlternatives_0 : ( ( 'owner' ) | ( 'workspaceId' ) );
    public final void rule__WorkspaceParam__TypeNameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2048:1: ( ( 'owner' ) | ( 'workspaceId' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==54) ) {
                alt20=1;
            }
            else if ( (LA20_0==74) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalQueryDsl.g:2049:2: ( 'owner' )
                    {
                    // InternalQueryDsl.g:2049:2: ( 'owner' )
                    // InternalQueryDsl.g:2050:3: 'owner'
                    {
                     before(grammarAccess.getWorkspaceParamAccess().getTypeNameOwnerKeyword_0_0()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getWorkspaceParamAccess().getTypeNameOwnerKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2055:2: ( 'workspaceId' )
                    {
                    // InternalQueryDsl.g:2055:2: ( 'workspaceId' )
                    // InternalQueryDsl.g:2056:3: 'workspaceId'
                    {
                     before(grammarAccess.getWorkspaceParamAccess().getTypeNameWorkspaceIdKeyword_0_1()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getWorkspaceParamAccess().getTypeNameWorkspaceIdKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceParam__TypeNameAlternatives_0"


    // $ANTLR start "rule__ProjectParam__TypeNameAlternatives_0"
    // InternalQueryDsl.g:2065:1: rule__ProjectParam__TypeNameAlternatives_0 : ( ( 'username' ) | ( 'userId' ) | ( 'workspaceId' ) | ( 'projectId' ) );
    public final void rule__ProjectParam__TypeNameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2069:1: ( ( 'username' ) | ( 'userId' ) | ( 'workspaceId' ) | ( 'projectId' ) )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt21=1;
                }
                break;
            case 73:
                {
                alt21=2;
                }
                break;
            case 74:
                {
                alt21=3;
                }
                break;
            case 75:
                {
                alt21=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalQueryDsl.g:2070:2: ( 'username' )
                    {
                    // InternalQueryDsl.g:2070:2: ( 'username' )
                    // InternalQueryDsl.g:2071:3: 'username'
                    {
                     before(grammarAccess.getProjectParamAccess().getTypeNameUsernameKeyword_0_0()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getProjectParamAccess().getTypeNameUsernameKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2076:2: ( 'userId' )
                    {
                    // InternalQueryDsl.g:2076:2: ( 'userId' )
                    // InternalQueryDsl.g:2077:3: 'userId'
                    {
                     before(grammarAccess.getProjectParamAccess().getTypeNameUserIdKeyword_0_1()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getProjectParamAccess().getTypeNameUserIdKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2082:2: ( 'workspaceId' )
                    {
                    // InternalQueryDsl.g:2082:2: ( 'workspaceId' )
                    // InternalQueryDsl.g:2083:3: 'workspaceId'
                    {
                     before(grammarAccess.getProjectParamAccess().getTypeNameWorkspaceIdKeyword_0_2()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getProjectParamAccess().getTypeNameWorkspaceIdKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:2088:2: ( 'projectId' )
                    {
                    // InternalQueryDsl.g:2088:2: ( 'projectId' )
                    // InternalQueryDsl.g:2089:3: 'projectId'
                    {
                     before(grammarAccess.getProjectParamAccess().getTypeNameProjectIdKeyword_0_3()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getProjectParamAccess().getTypeNameProjectIdKeyword_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectParam__TypeNameAlternatives_0"


    // $ANTLR start "rule__MetamodelParam__Alternatives"
    // InternalQueryDsl.g:2098:1: rule__MetamodelParam__Alternatives : ( ( ruleMetaParam ) | ( ruleParam ) );
    public final void rule__MetamodelParam__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2102:1: ( ( ruleMetaParam ) | ( ruleParam ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=76 && LA22_0<=81)) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=13 && LA22_0<=14)||LA22_0==53||LA22_0==60||(LA22_0>=68 && LA22_0<=69)||(LA22_0>=82 && LA22_0<=84)) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalQueryDsl.g:2103:2: ( ruleMetaParam )
                    {
                    // InternalQueryDsl.g:2103:2: ( ruleMetaParam )
                    // InternalQueryDsl.g:2104:3: ruleMetaParam
                    {
                     before(grammarAccess.getMetamodelParamAccess().getMetaParamParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMetaParam();

                    state._fsp--;

                     after(grammarAccess.getMetamodelParamAccess().getMetaParamParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2109:2: ( ruleParam )
                    {
                    // InternalQueryDsl.g:2109:2: ( ruleParam )
                    // InternalQueryDsl.g:2110:3: ruleParam
                    {
                     before(grammarAccess.getMetamodelParamAccess().getParamParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParam();

                    state._fsp--;

                     after(grammarAccess.getMetamodelParamAccess().getParamParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelParam__Alternatives"


    // $ANTLR start "rule__MetaParam__Alternatives"
    // InternalQueryDsl.g:2119:1: rule__MetaParam__Alternatives : ( ( 'eClassifier' ) | ( 'ePackageName' ) | ( 'ePackageNsURI' ) | ( 'ePackageNsPrefix' ) | ( 'quality-metric' ) | ( 'model' ) );
    public final void rule__MetaParam__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2123:1: ( ( 'eClassifier' ) | ( 'ePackageName' ) | ( 'ePackageNsURI' ) | ( 'ePackageNsPrefix' ) | ( 'quality-metric' ) | ( 'model' ) )
            int alt23=6;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt23=1;
                }
                break;
            case 77:
                {
                alt23=2;
                }
                break;
            case 78:
                {
                alt23=3;
                }
                break;
            case 79:
                {
                alt23=4;
                }
                break;
            case 80:
                {
                alt23=5;
                }
                break;
            case 81:
                {
                alt23=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalQueryDsl.g:2124:2: ( 'eClassifier' )
                    {
                    // InternalQueryDsl.g:2124:2: ( 'eClassifier' )
                    // InternalQueryDsl.g:2125:3: 'eClassifier'
                    {
                     before(grammarAccess.getMetaParamAccess().getEClassifierKeyword_0()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getMetaParamAccess().getEClassifierKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2130:2: ( 'ePackageName' )
                    {
                    // InternalQueryDsl.g:2130:2: ( 'ePackageName' )
                    // InternalQueryDsl.g:2131:3: 'ePackageName'
                    {
                     before(grammarAccess.getMetaParamAccess().getEPackageNameKeyword_1()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getMetaParamAccess().getEPackageNameKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2136:2: ( 'ePackageNsURI' )
                    {
                    // InternalQueryDsl.g:2136:2: ( 'ePackageNsURI' )
                    // InternalQueryDsl.g:2137:3: 'ePackageNsURI'
                    {
                     before(grammarAccess.getMetaParamAccess().getEPackageNsURIKeyword_2()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getMetaParamAccess().getEPackageNsURIKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:2142:2: ( 'ePackageNsPrefix' )
                    {
                    // InternalQueryDsl.g:2142:2: ( 'ePackageNsPrefix' )
                    // InternalQueryDsl.g:2143:3: 'ePackageNsPrefix'
                    {
                     before(grammarAccess.getMetaParamAccess().getEPackageNsPrefixKeyword_3()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getMetaParamAccess().getEPackageNsPrefixKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:2148:2: ( 'quality-metric' )
                    {
                    // InternalQueryDsl.g:2148:2: ( 'quality-metric' )
                    // InternalQueryDsl.g:2149:3: 'quality-metric'
                    {
                     before(grammarAccess.getMetaParamAccess().getQualityMetricKeyword_4()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getMetaParamAccess().getQualityMetricKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:2154:2: ( 'model' )
                    {
                    // InternalQueryDsl.g:2154:2: ( 'model' )
                    // InternalQueryDsl.g:2155:3: 'model'
                    {
                     before(grammarAccess.getMetaParamAccess().getModelKeyword_5()); 
                    match(input,81,FOLLOW_2); 
                     after(grammarAccess.getMetaParamAccess().getModelKeyword_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaParam__Alternatives"


    // $ANTLR start "rule__Param__Alternatives"
    // InternalQueryDsl.g:2164:1: rule__Param__Alternatives : ( ( 'id' ) | ( 'accessControl' ) | ( 'description' ) | ( 'extension' ) | ( 'operation' ) | ( 'name' ) | ( 'unique-name' ) | ( 'project' ) | ( 'size' ) );
    public final void rule__Param__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2168:1: ( ( 'id' ) | ( 'accessControl' ) | ( 'description' ) | ( 'extension' ) | ( 'operation' ) | ( 'name' ) | ( 'unique-name' ) | ( 'project' ) | ( 'size' ) )
            int alt24=9;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt24=1;
                }
                break;
            case 60:
                {
                alt24=2;
                }
                break;
            case 53:
                {
                alt24=3;
                }
                break;
            case 82:
                {
                alt24=4;
                }
                break;
            case 83:
                {
                alt24=5;
                }
                break;
            case 14:
                {
                alt24=6;
                }
                break;
            case 84:
                {
                alt24=7;
                }
                break;
            case 68:
                {
                alt24=8;
                }
                break;
            case 69:
                {
                alt24=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalQueryDsl.g:2169:2: ( 'id' )
                    {
                    // InternalQueryDsl.g:2169:2: ( 'id' )
                    // InternalQueryDsl.g:2170:3: 'id'
                    {
                     before(grammarAccess.getParamAccess().getIdKeyword_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getParamAccess().getIdKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2175:2: ( 'accessControl' )
                    {
                    // InternalQueryDsl.g:2175:2: ( 'accessControl' )
                    // InternalQueryDsl.g:2176:3: 'accessControl'
                    {
                     before(grammarAccess.getParamAccess().getAccessControlKeyword_1()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getParamAccess().getAccessControlKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2181:2: ( 'description' )
                    {
                    // InternalQueryDsl.g:2181:2: ( 'description' )
                    // InternalQueryDsl.g:2182:3: 'description'
                    {
                     before(grammarAccess.getParamAccess().getDescriptionKeyword_2()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getParamAccess().getDescriptionKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:2187:2: ( 'extension' )
                    {
                    // InternalQueryDsl.g:2187:2: ( 'extension' )
                    // InternalQueryDsl.g:2188:3: 'extension'
                    {
                     before(grammarAccess.getParamAccess().getExtensionKeyword_3()); 
                    match(input,82,FOLLOW_2); 
                     after(grammarAccess.getParamAccess().getExtensionKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:2193:2: ( 'operation' )
                    {
                    // InternalQueryDsl.g:2193:2: ( 'operation' )
                    // InternalQueryDsl.g:2194:3: 'operation'
                    {
                     before(grammarAccess.getParamAccess().getOperationKeyword_4()); 
                    match(input,83,FOLLOW_2); 
                     after(grammarAccess.getParamAccess().getOperationKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalQueryDsl.g:2199:2: ( 'name' )
                    {
                    // InternalQueryDsl.g:2199:2: ( 'name' )
                    // InternalQueryDsl.g:2200:3: 'name'
                    {
                     before(grammarAccess.getParamAccess().getNameKeyword_5()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getParamAccess().getNameKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalQueryDsl.g:2205:2: ( 'unique-name' )
                    {
                    // InternalQueryDsl.g:2205:2: ( 'unique-name' )
                    // InternalQueryDsl.g:2206:3: 'unique-name'
                    {
                     before(grammarAccess.getParamAccess().getUniqueNameKeyword_6()); 
                    match(input,84,FOLLOW_2); 
                     after(grammarAccess.getParamAccess().getUniqueNameKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalQueryDsl.g:2211:2: ( 'project' )
                    {
                    // InternalQueryDsl.g:2211:2: ( 'project' )
                    // InternalQueryDsl.g:2212:3: 'project'
                    {
                     before(grammarAccess.getParamAccess().getProjectKeyword_7()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getParamAccess().getProjectKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalQueryDsl.g:2217:2: ( 'size' )
                    {
                    // InternalQueryDsl.g:2217:2: ( 'size' )
                    // InternalQueryDsl.g:2218:3: 'size'
                    {
                     before(grammarAccess.getParamAccess().getSizeKeyword_8()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getParamAccess().getSizeKeyword_8()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Alternatives"


    // $ANTLR start "rule__Expression__Alternatives"
    // InternalQueryDsl.g:2227:1: rule__Expression__Alternatives : ( ( ( rule__Expression__Group_0__0 ) ) | ( ( rule__Expression__Group_1__0 ) ) | ( ( rule__Expression__Group_2__0 ) ) | ( ( rule__Expression__Group_3__0 ) ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2231:1: ( ( ( rule__Expression__Group_0__0 ) ) | ( ( rule__Expression__Group_1__0 ) ) | ( ( rule__Expression__Group_2__0 ) ) | ( ( rule__Expression__Group_3__0 ) ) )
            int alt25=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt25=1;
                }
                break;
            case RULE_STRING:
                {
                alt25=2;
                }
                break;
            case 85:
            case 86:
                {
                alt25=3;
                }
                break;
            case RULE_ID:
                {
                alt25=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalQueryDsl.g:2232:2: ( ( rule__Expression__Group_0__0 ) )
                    {
                    // InternalQueryDsl.g:2232:2: ( ( rule__Expression__Group_0__0 ) )
                    // InternalQueryDsl.g:2233:3: ( rule__Expression__Group_0__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_0()); 
                    // InternalQueryDsl.g:2234:3: ( rule__Expression__Group_0__0 )
                    // InternalQueryDsl.g:2234:4: rule__Expression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2238:2: ( ( rule__Expression__Group_1__0 ) )
                    {
                    // InternalQueryDsl.g:2238:2: ( ( rule__Expression__Group_1__0 ) )
                    // InternalQueryDsl.g:2239:3: ( rule__Expression__Group_1__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_1()); 
                    // InternalQueryDsl.g:2240:3: ( rule__Expression__Group_1__0 )
                    // InternalQueryDsl.g:2240:4: rule__Expression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:2244:2: ( ( rule__Expression__Group_2__0 ) )
                    {
                    // InternalQueryDsl.g:2244:2: ( ( rule__Expression__Group_2__0 ) )
                    // InternalQueryDsl.g:2245:3: ( rule__Expression__Group_2__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_2()); 
                    // InternalQueryDsl.g:2246:3: ( rule__Expression__Group_2__0 )
                    // InternalQueryDsl.g:2246:4: rule__Expression__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:2250:2: ( ( rule__Expression__Group_3__0 ) )
                    {
                    // InternalQueryDsl.g:2250:2: ( ( rule__Expression__Group_3__0 ) )
                    // InternalQueryDsl.g:2251:3: ( rule__Expression__Group_3__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_3()); 
                    // InternalQueryDsl.g:2252:3: ( rule__Expression__Group_3__0 )
                    // InternalQueryDsl.g:2252:4: rule__Expression__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getGroup_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Alternatives"


    // $ANTLR start "rule__Expression__ValueAlternatives_2_1_0"
    // InternalQueryDsl.g:2260:1: rule__Expression__ValueAlternatives_2_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Expression__ValueAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2264:1: ( ( 'true' ) | ( 'false' ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==85) ) {
                alt26=1;
            }
            else if ( (LA26_0==86) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalQueryDsl.g:2265:2: ( 'true' )
                    {
                    // InternalQueryDsl.g:2265:2: ( 'true' )
                    // InternalQueryDsl.g:2266:3: 'true'
                    {
                     before(grammarAccess.getExpressionAccess().getValueTrueKeyword_2_1_0_0()); 
                    match(input,85,FOLLOW_2); 
                     after(grammarAccess.getExpressionAccess().getValueTrueKeyword_2_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:2271:2: ( 'false' )
                    {
                    // InternalQueryDsl.g:2271:2: ( 'false' )
                    // InternalQueryDsl.g:2272:3: 'false'
                    {
                     before(grammarAccess.getExpressionAccess().getValueFalseKeyword_2_1_0_1()); 
                    match(input,86,FOLLOW_2); 
                     after(grammarAccess.getExpressionAccess().getValueFalseKeyword_2_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__ValueAlternatives_2_1_0"


    // $ANTLR start "rule__User__Group__0"
    // InternalQueryDsl.g:2281:1: rule__User__Group__0 : rule__User__Group__0__Impl rule__User__Group__1 ;
    public final void rule__User__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2285:1: ( rule__User__Group__0__Impl rule__User__Group__1 )
            // InternalQueryDsl.g:2286:2: rule__User__Group__0__Impl rule__User__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__User__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__0"


    // $ANTLR start "rule__User__Group__0__Impl"
    // InternalQueryDsl.g:2293:1: rule__User__Group__0__Impl : ( 'Query' ) ;
    public final void rule__User__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2297:1: ( ( 'Query' ) )
            // InternalQueryDsl.g:2298:1: ( 'Query' )
            {
            // InternalQueryDsl.g:2298:1: ( 'Query' )
            // InternalQueryDsl.g:2299:2: 'Query'
            {
             before(grammarAccess.getUserAccess().getQueryKeyword_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getQueryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__0__Impl"


    // $ANTLR start "rule__User__Group__1"
    // InternalQueryDsl.g:2308:1: rule__User__Group__1 : rule__User__Group__1__Impl rule__User__Group__2 ;
    public final void rule__User__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2312:1: ( rule__User__Group__1__Impl rule__User__Group__2 )
            // InternalQueryDsl.g:2313:2: rule__User__Group__1__Impl rule__User__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__User__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__1"


    // $ANTLR start "rule__User__Group__1__Impl"
    // InternalQueryDsl.g:2320:1: rule__User__Group__1__Impl : ( 'User' ) ;
    public final void rule__User__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2324:1: ( ( 'User' ) )
            // InternalQueryDsl.g:2325:1: ( 'User' )
            {
            // InternalQueryDsl.g:2325:1: ( 'User' )
            // InternalQueryDsl.g:2326:2: 'User'
            {
             before(grammarAccess.getUserAccess().getUserKeyword_1()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getUserKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__1__Impl"


    // $ANTLR start "rule__User__Group__2"
    // InternalQueryDsl.g:2335:1: rule__User__Group__2 : rule__User__Group__2__Impl rule__User__Group__3 ;
    public final void rule__User__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2339:1: ( rule__User__Group__2__Impl rule__User__Group__3 )
            // InternalQueryDsl.g:2340:2: rule__User__Group__2__Impl rule__User__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__User__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__2"


    // $ANTLR start "rule__User__Group__2__Impl"
    // InternalQueryDsl.g:2347:1: rule__User__Group__2__Impl : ( '(' ) ;
    public final void rule__User__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2351:1: ( ( '(' ) )
            // InternalQueryDsl.g:2352:1: ( '(' )
            {
            // InternalQueryDsl.g:2352:1: ( '(' )
            // InternalQueryDsl.g:2353:2: '('
            {
             before(grammarAccess.getUserAccess().getLeftParenthesisKeyword_2()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__2__Impl"


    // $ANTLR start "rule__User__Group__3"
    // InternalQueryDsl.g:2362:1: rule__User__Group__3 : rule__User__Group__3__Impl rule__User__Group__4 ;
    public final void rule__User__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2366:1: ( rule__User__Group__3__Impl rule__User__Group__4 )
            // InternalQueryDsl.g:2367:2: rule__User__Group__3__Impl rule__User__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__User__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__3"


    // $ANTLR start "rule__User__Group__3__Impl"
    // InternalQueryDsl.g:2374:1: rule__User__Group__3__Impl : ( ( rule__User__UservarAssignment_3 ) ) ;
    public final void rule__User__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2378:1: ( ( ( rule__User__UservarAssignment_3 ) ) )
            // InternalQueryDsl.g:2379:1: ( ( rule__User__UservarAssignment_3 ) )
            {
            // InternalQueryDsl.g:2379:1: ( ( rule__User__UservarAssignment_3 ) )
            // InternalQueryDsl.g:2380:2: ( rule__User__UservarAssignment_3 )
            {
             before(grammarAccess.getUserAccess().getUservarAssignment_3()); 
            // InternalQueryDsl.g:2381:2: ( rule__User__UservarAssignment_3 )
            // InternalQueryDsl.g:2381:3: rule__User__UservarAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__User__UservarAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getUservarAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__3__Impl"


    // $ANTLR start "rule__User__Group__4"
    // InternalQueryDsl.g:2389:1: rule__User__Group__4 : rule__User__Group__4__Impl rule__User__Group__5 ;
    public final void rule__User__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2393:1: ( rule__User__Group__4__Impl rule__User__Group__5 )
            // InternalQueryDsl.g:2394:2: rule__User__Group__4__Impl rule__User__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__User__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__4"


    // $ANTLR start "rule__User__Group__4__Impl"
    // InternalQueryDsl.g:2401:1: rule__User__Group__4__Impl : ( ( rule__User__Group_4__0 )* ) ;
    public final void rule__User__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2405:1: ( ( ( rule__User__Group_4__0 )* ) )
            // InternalQueryDsl.g:2406:1: ( ( rule__User__Group_4__0 )* )
            {
            // InternalQueryDsl.g:2406:1: ( ( rule__User__Group_4__0 )* )
            // InternalQueryDsl.g:2407:2: ( rule__User__Group_4__0 )*
            {
             before(grammarAccess.getUserAccess().getGroup_4()); 
            // InternalQueryDsl.g:2408:2: ( rule__User__Group_4__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==94) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalQueryDsl.g:2408:3: rule__User__Group_4__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__User__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getUserAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__4__Impl"


    // $ANTLR start "rule__User__Group__5"
    // InternalQueryDsl.g:2416:1: rule__User__Group__5 : rule__User__Group__5__Impl rule__User__Group__6 ;
    public final void rule__User__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2420:1: ( rule__User__Group__5__Impl rule__User__Group__6 )
            // InternalQueryDsl.g:2421:2: rule__User__Group__5__Impl rule__User__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__User__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__5"


    // $ANTLR start "rule__User__Group__5__Impl"
    // InternalQueryDsl.g:2428:1: rule__User__Group__5__Impl : ( ')' ) ;
    public final void rule__User__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2432:1: ( ( ')' ) )
            // InternalQueryDsl.g:2433:1: ( ')' )
            {
            // InternalQueryDsl.g:2433:1: ( ')' )
            // InternalQueryDsl.g:2434:2: ')'
            {
             before(grammarAccess.getUserAccess().getRightParenthesisKeyword_5()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__5__Impl"


    // $ANTLR start "rule__User__Group__6"
    // InternalQueryDsl.g:2443:1: rule__User__Group__6 : rule__User__Group__6__Impl rule__User__Group__7 ;
    public final void rule__User__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2447:1: ( rule__User__Group__6__Impl rule__User__Group__7 )
            // InternalQueryDsl.g:2448:2: rule__User__Group__6__Impl rule__User__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__User__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__6"


    // $ANTLR start "rule__User__Group__6__Impl"
    // InternalQueryDsl.g:2455:1: rule__User__Group__6__Impl : ( 'return' ) ;
    public final void rule__User__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2459:1: ( ( 'return' ) )
            // InternalQueryDsl.g:2460:1: ( 'return' )
            {
            // InternalQueryDsl.g:2460:1: ( 'return' )
            // InternalQueryDsl.g:2461:2: 'return'
            {
             before(grammarAccess.getUserAccess().getReturnKeyword_6()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getReturnKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__6__Impl"


    // $ANTLR start "rule__User__Group__7"
    // InternalQueryDsl.g:2470:1: rule__User__Group__7 : rule__User__Group__7__Impl rule__User__Group__8 ;
    public final void rule__User__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2474:1: ( rule__User__Group__7__Impl rule__User__Group__8 )
            // InternalQueryDsl.g:2475:2: rule__User__Group__7__Impl rule__User__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__User__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__7"


    // $ANTLR start "rule__User__Group__7__Impl"
    // InternalQueryDsl.g:2482:1: rule__User__Group__7__Impl : ( '[' ) ;
    public final void rule__User__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2486:1: ( ( '[' ) )
            // InternalQueryDsl.g:2487:1: ( '[' )
            {
            // InternalQueryDsl.g:2487:1: ( '[' )
            // InternalQueryDsl.g:2488:2: '['
            {
             before(grammarAccess.getUserAccess().getLeftSquareBracketKeyword_7()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getLeftSquareBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__7__Impl"


    // $ANTLR start "rule__User__Group__8"
    // InternalQueryDsl.g:2497:1: rule__User__Group__8 : rule__User__Group__8__Impl rule__User__Group__9 ;
    public final void rule__User__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2501:1: ( rule__User__Group__8__Impl rule__User__Group__9 )
            // InternalQueryDsl.g:2502:2: rule__User__Group__8__Impl rule__User__Group__9
            {
            pushFollow(FOLLOW_12);
            rule__User__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__8"


    // $ANTLR start "rule__User__Group__8__Impl"
    // InternalQueryDsl.g:2509:1: rule__User__Group__8__Impl : ( ( rule__User__FieldAssignment_8 ) ) ;
    public final void rule__User__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2513:1: ( ( ( rule__User__FieldAssignment_8 ) ) )
            // InternalQueryDsl.g:2514:1: ( ( rule__User__FieldAssignment_8 ) )
            {
            // InternalQueryDsl.g:2514:1: ( ( rule__User__FieldAssignment_8 ) )
            // InternalQueryDsl.g:2515:2: ( rule__User__FieldAssignment_8 )
            {
             before(grammarAccess.getUserAccess().getFieldAssignment_8()); 
            // InternalQueryDsl.g:2516:2: ( rule__User__FieldAssignment_8 )
            // InternalQueryDsl.g:2516:3: rule__User__FieldAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__User__FieldAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getFieldAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__8__Impl"


    // $ANTLR start "rule__User__Group__9"
    // InternalQueryDsl.g:2524:1: rule__User__Group__9 : rule__User__Group__9__Impl rule__User__Group__10 ;
    public final void rule__User__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2528:1: ( rule__User__Group__9__Impl rule__User__Group__10 )
            // InternalQueryDsl.g:2529:2: rule__User__Group__9__Impl rule__User__Group__10
            {
            pushFollow(FOLLOW_12);
            rule__User__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__9"


    // $ANTLR start "rule__User__Group__9__Impl"
    // InternalQueryDsl.g:2536:1: rule__User__Group__9__Impl : ( ( rule__User__Group_9__0 )* ) ;
    public final void rule__User__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2540:1: ( ( ( rule__User__Group_9__0 )* ) )
            // InternalQueryDsl.g:2541:1: ( ( rule__User__Group_9__0 )* )
            {
            // InternalQueryDsl.g:2541:1: ( ( rule__User__Group_9__0 )* )
            // InternalQueryDsl.g:2542:2: ( rule__User__Group_9__0 )*
            {
             before(grammarAccess.getUserAccess().getGroup_9()); 
            // InternalQueryDsl.g:2543:2: ( rule__User__Group_9__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==94) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalQueryDsl.g:2543:3: rule__User__Group_9__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__User__Group_9__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getUserAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__9__Impl"


    // $ANTLR start "rule__User__Group__10"
    // InternalQueryDsl.g:2551:1: rule__User__Group__10 : rule__User__Group__10__Impl ;
    public final void rule__User__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2555:1: ( rule__User__Group__10__Impl )
            // InternalQueryDsl.g:2556:2: rule__User__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__User__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__10"


    // $ANTLR start "rule__User__Group__10__Impl"
    // InternalQueryDsl.g:2562:1: rule__User__Group__10__Impl : ( ']' ) ;
    public final void rule__User__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2566:1: ( ( ']' ) )
            // InternalQueryDsl.g:2567:1: ( ']' )
            {
            // InternalQueryDsl.g:2567:1: ( ']' )
            // InternalQueryDsl.g:2568:2: ']'
            {
             before(grammarAccess.getUserAccess().getRightSquareBracketKeyword_10()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getRightSquareBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__10__Impl"


    // $ANTLR start "rule__User__Group_4__0"
    // InternalQueryDsl.g:2578:1: rule__User__Group_4__0 : rule__User__Group_4__0__Impl rule__User__Group_4__1 ;
    public final void rule__User__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2582:1: ( rule__User__Group_4__0__Impl rule__User__Group_4__1 )
            // InternalQueryDsl.g:2583:2: rule__User__Group_4__0__Impl rule__User__Group_4__1
            {
            pushFollow(FOLLOW_6);
            rule__User__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group_4__0"


    // $ANTLR start "rule__User__Group_4__0__Impl"
    // InternalQueryDsl.g:2590:1: rule__User__Group_4__0__Impl : ( ',' ) ;
    public final void rule__User__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2594:1: ( ( ',' ) )
            // InternalQueryDsl.g:2595:1: ( ',' )
            {
            // InternalQueryDsl.g:2595:1: ( ',' )
            // InternalQueryDsl.g:2596:2: ','
            {
             before(grammarAccess.getUserAccess().getCommaKeyword_4_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group_4__0__Impl"


    // $ANTLR start "rule__User__Group_4__1"
    // InternalQueryDsl.g:2605:1: rule__User__Group_4__1 : rule__User__Group_4__1__Impl ;
    public final void rule__User__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2609:1: ( rule__User__Group_4__1__Impl )
            // InternalQueryDsl.g:2610:2: rule__User__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__User__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group_4__1"


    // $ANTLR start "rule__User__Group_4__1__Impl"
    // InternalQueryDsl.g:2616:1: rule__User__Group_4__1__Impl : ( ( rule__User__UservarsAssignment_4_1 ) ) ;
    public final void rule__User__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2620:1: ( ( ( rule__User__UservarsAssignment_4_1 ) ) )
            // InternalQueryDsl.g:2621:1: ( ( rule__User__UservarsAssignment_4_1 ) )
            {
            // InternalQueryDsl.g:2621:1: ( ( rule__User__UservarsAssignment_4_1 ) )
            // InternalQueryDsl.g:2622:2: ( rule__User__UservarsAssignment_4_1 )
            {
             before(grammarAccess.getUserAccess().getUservarsAssignment_4_1()); 
            // InternalQueryDsl.g:2623:2: ( rule__User__UservarsAssignment_4_1 )
            // InternalQueryDsl.g:2623:3: rule__User__UservarsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__User__UservarsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getUservarsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group_4__1__Impl"


    // $ANTLR start "rule__User__Group_9__0"
    // InternalQueryDsl.g:2632:1: rule__User__Group_9__0 : rule__User__Group_9__0__Impl rule__User__Group_9__1 ;
    public final void rule__User__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2636:1: ( rule__User__Group_9__0__Impl rule__User__Group_9__1 )
            // InternalQueryDsl.g:2637:2: rule__User__Group_9__0__Impl rule__User__Group_9__1
            {
            pushFollow(FOLLOW_11);
            rule__User__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group_9__0"


    // $ANTLR start "rule__User__Group_9__0__Impl"
    // InternalQueryDsl.g:2644:1: rule__User__Group_9__0__Impl : ( ',' ) ;
    public final void rule__User__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2648:1: ( ( ',' ) )
            // InternalQueryDsl.g:2649:1: ( ',' )
            {
            // InternalQueryDsl.g:2649:1: ( ',' )
            // InternalQueryDsl.g:2650:2: ','
            {
             before(grammarAccess.getUserAccess().getCommaKeyword_9_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getCommaKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group_9__0__Impl"


    // $ANTLR start "rule__User__Group_9__1"
    // InternalQueryDsl.g:2659:1: rule__User__Group_9__1 : rule__User__Group_9__1__Impl ;
    public final void rule__User__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2663:1: ( rule__User__Group_9__1__Impl )
            // InternalQueryDsl.g:2664:2: rule__User__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__User__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group_9__1"


    // $ANTLR start "rule__User__Group_9__1__Impl"
    // InternalQueryDsl.g:2670:1: rule__User__Group_9__1__Impl : ( ( rule__User__FieldsAssignment_9_1 ) ) ;
    public final void rule__User__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2674:1: ( ( ( rule__User__FieldsAssignment_9_1 ) ) )
            // InternalQueryDsl.g:2675:1: ( ( rule__User__FieldsAssignment_9_1 ) )
            {
            // InternalQueryDsl.g:2675:1: ( ( rule__User__FieldsAssignment_9_1 ) )
            // InternalQueryDsl.g:2676:2: ( rule__User__FieldsAssignment_9_1 )
            {
             before(grammarAccess.getUserAccess().getFieldsAssignment_9_1()); 
            // InternalQueryDsl.g:2677:2: ( rule__User__FieldsAssignment_9_1 )
            // InternalQueryDsl.g:2677:3: rule__User__FieldsAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__User__FieldsAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getFieldsAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group_9__1__Impl"


    // $ANTLR start "rule__Workspace__Group__0"
    // InternalQueryDsl.g:2686:1: rule__Workspace__Group__0 : rule__Workspace__Group__0__Impl rule__Workspace__Group__1 ;
    public final void rule__Workspace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2690:1: ( rule__Workspace__Group__0__Impl rule__Workspace__Group__1 )
            // InternalQueryDsl.g:2691:2: rule__Workspace__Group__0__Impl rule__Workspace__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__Workspace__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__0"


    // $ANTLR start "rule__Workspace__Group__0__Impl"
    // InternalQueryDsl.g:2698:1: rule__Workspace__Group__0__Impl : ( 'Query' ) ;
    public final void rule__Workspace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2702:1: ( ( 'Query' ) )
            // InternalQueryDsl.g:2703:1: ( 'Query' )
            {
            // InternalQueryDsl.g:2703:1: ( 'Query' )
            // InternalQueryDsl.g:2704:2: 'Query'
            {
             before(grammarAccess.getWorkspaceAccess().getQueryKeyword_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getWorkspaceAccess().getQueryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__0__Impl"


    // $ANTLR start "rule__Workspace__Group__1"
    // InternalQueryDsl.g:2713:1: rule__Workspace__Group__1 : rule__Workspace__Group__1__Impl rule__Workspace__Group__2 ;
    public final void rule__Workspace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2717:1: ( rule__Workspace__Group__1__Impl rule__Workspace__Group__2 )
            // InternalQueryDsl.g:2718:2: rule__Workspace__Group__1__Impl rule__Workspace__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Workspace__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__1"


    // $ANTLR start "rule__Workspace__Group__1__Impl"
    // InternalQueryDsl.g:2725:1: rule__Workspace__Group__1__Impl : ( 'Workspace' ) ;
    public final void rule__Workspace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2729:1: ( ( 'Workspace' ) )
            // InternalQueryDsl.g:2730:1: ( 'Workspace' )
            {
            // InternalQueryDsl.g:2730:1: ( 'Workspace' )
            // InternalQueryDsl.g:2731:2: 'Workspace'
            {
             before(grammarAccess.getWorkspaceAccess().getWorkspaceKeyword_1()); 
            match(input,95,FOLLOW_2); 
             after(grammarAccess.getWorkspaceAccess().getWorkspaceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__1__Impl"


    // $ANTLR start "rule__Workspace__Group__2"
    // InternalQueryDsl.g:2740:1: rule__Workspace__Group__2 : rule__Workspace__Group__2__Impl rule__Workspace__Group__3 ;
    public final void rule__Workspace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2744:1: ( rule__Workspace__Group__2__Impl rule__Workspace__Group__3 )
            // InternalQueryDsl.g:2745:2: rule__Workspace__Group__2__Impl rule__Workspace__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__Workspace__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__2"


    // $ANTLR start "rule__Workspace__Group__2__Impl"
    // InternalQueryDsl.g:2752:1: rule__Workspace__Group__2__Impl : ( '(' ) ;
    public final void rule__Workspace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2756:1: ( ( '(' ) )
            // InternalQueryDsl.g:2757:1: ( '(' )
            {
            // InternalQueryDsl.g:2757:1: ( '(' )
            // InternalQueryDsl.g:2758:2: '('
            {
             before(grammarAccess.getWorkspaceAccess().getLeftParenthesisKeyword_2()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getWorkspaceAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__2__Impl"


    // $ANTLR start "rule__Workspace__Group__3"
    // InternalQueryDsl.g:2767:1: rule__Workspace__Group__3 : rule__Workspace__Group__3__Impl rule__Workspace__Group__4 ;
    public final void rule__Workspace__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2771:1: ( rule__Workspace__Group__3__Impl rule__Workspace__Group__4 )
            // InternalQueryDsl.g:2772:2: rule__Workspace__Group__3__Impl rule__Workspace__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Workspace__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__3"


    // $ANTLR start "rule__Workspace__Group__3__Impl"
    // InternalQueryDsl.g:2779:1: rule__Workspace__Group__3__Impl : ( ( rule__Workspace__SpacevarAssignment_3 ) ) ;
    public final void rule__Workspace__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2783:1: ( ( ( rule__Workspace__SpacevarAssignment_3 ) ) )
            // InternalQueryDsl.g:2784:1: ( ( rule__Workspace__SpacevarAssignment_3 ) )
            {
            // InternalQueryDsl.g:2784:1: ( ( rule__Workspace__SpacevarAssignment_3 ) )
            // InternalQueryDsl.g:2785:2: ( rule__Workspace__SpacevarAssignment_3 )
            {
             before(grammarAccess.getWorkspaceAccess().getSpacevarAssignment_3()); 
            // InternalQueryDsl.g:2786:2: ( rule__Workspace__SpacevarAssignment_3 )
            // InternalQueryDsl.g:2786:3: rule__Workspace__SpacevarAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Workspace__SpacevarAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceAccess().getSpacevarAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__3__Impl"


    // $ANTLR start "rule__Workspace__Group__4"
    // InternalQueryDsl.g:2794:1: rule__Workspace__Group__4 : rule__Workspace__Group__4__Impl rule__Workspace__Group__5 ;
    public final void rule__Workspace__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2798:1: ( rule__Workspace__Group__4__Impl rule__Workspace__Group__5 )
            // InternalQueryDsl.g:2799:2: rule__Workspace__Group__4__Impl rule__Workspace__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Workspace__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__4"


    // $ANTLR start "rule__Workspace__Group__4__Impl"
    // InternalQueryDsl.g:2806:1: rule__Workspace__Group__4__Impl : ( ( rule__Workspace__Group_4__0 )* ) ;
    public final void rule__Workspace__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2810:1: ( ( ( rule__Workspace__Group_4__0 )* ) )
            // InternalQueryDsl.g:2811:1: ( ( rule__Workspace__Group_4__0 )* )
            {
            // InternalQueryDsl.g:2811:1: ( ( rule__Workspace__Group_4__0 )* )
            // InternalQueryDsl.g:2812:2: ( rule__Workspace__Group_4__0 )*
            {
             before(grammarAccess.getWorkspaceAccess().getGroup_4()); 
            // InternalQueryDsl.g:2813:2: ( rule__Workspace__Group_4__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==94) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalQueryDsl.g:2813:3: rule__Workspace__Group_4__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Workspace__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getWorkspaceAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__4__Impl"


    // $ANTLR start "rule__Workspace__Group__5"
    // InternalQueryDsl.g:2821:1: rule__Workspace__Group__5 : rule__Workspace__Group__5__Impl rule__Workspace__Group__6 ;
    public final void rule__Workspace__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2825:1: ( rule__Workspace__Group__5__Impl rule__Workspace__Group__6 )
            // InternalQueryDsl.g:2826:2: rule__Workspace__Group__5__Impl rule__Workspace__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Workspace__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__5"


    // $ANTLR start "rule__Workspace__Group__5__Impl"
    // InternalQueryDsl.g:2833:1: rule__Workspace__Group__5__Impl : ( ')' ) ;
    public final void rule__Workspace__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2837:1: ( ( ')' ) )
            // InternalQueryDsl.g:2838:1: ( ')' )
            {
            // InternalQueryDsl.g:2838:1: ( ')' )
            // InternalQueryDsl.g:2839:2: ')'
            {
             before(grammarAccess.getWorkspaceAccess().getRightParenthesisKeyword_5()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getWorkspaceAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__5__Impl"


    // $ANTLR start "rule__Workspace__Group__6"
    // InternalQueryDsl.g:2848:1: rule__Workspace__Group__6 : rule__Workspace__Group__6__Impl rule__Workspace__Group__7 ;
    public final void rule__Workspace__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2852:1: ( rule__Workspace__Group__6__Impl rule__Workspace__Group__7 )
            // InternalQueryDsl.g:2853:2: rule__Workspace__Group__6__Impl rule__Workspace__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__Workspace__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__6"


    // $ANTLR start "rule__Workspace__Group__6__Impl"
    // InternalQueryDsl.g:2860:1: rule__Workspace__Group__6__Impl : ( 'return' ) ;
    public final void rule__Workspace__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2864:1: ( ( 'return' ) )
            // InternalQueryDsl.g:2865:1: ( 'return' )
            {
            // InternalQueryDsl.g:2865:1: ( 'return' )
            // InternalQueryDsl.g:2866:2: 'return'
            {
             before(grammarAccess.getWorkspaceAccess().getReturnKeyword_6()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getWorkspaceAccess().getReturnKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__6__Impl"


    // $ANTLR start "rule__Workspace__Group__7"
    // InternalQueryDsl.g:2875:1: rule__Workspace__Group__7 : rule__Workspace__Group__7__Impl rule__Workspace__Group__8 ;
    public final void rule__Workspace__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2879:1: ( rule__Workspace__Group__7__Impl rule__Workspace__Group__8 )
            // InternalQueryDsl.g:2880:2: rule__Workspace__Group__7__Impl rule__Workspace__Group__8
            {
            pushFollow(FOLLOW_15);
            rule__Workspace__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__7"


    // $ANTLR start "rule__Workspace__Group__7__Impl"
    // InternalQueryDsl.g:2887:1: rule__Workspace__Group__7__Impl : ( '[' ) ;
    public final void rule__Workspace__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2891:1: ( ( '[' ) )
            // InternalQueryDsl.g:2892:1: ( '[' )
            {
            // InternalQueryDsl.g:2892:1: ( '[' )
            // InternalQueryDsl.g:2893:2: '['
            {
             before(grammarAccess.getWorkspaceAccess().getLeftSquareBracketKeyword_7()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getWorkspaceAccess().getLeftSquareBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__7__Impl"


    // $ANTLR start "rule__Workspace__Group__8"
    // InternalQueryDsl.g:2902:1: rule__Workspace__Group__8 : rule__Workspace__Group__8__Impl rule__Workspace__Group__9 ;
    public final void rule__Workspace__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2906:1: ( rule__Workspace__Group__8__Impl rule__Workspace__Group__9 )
            // InternalQueryDsl.g:2907:2: rule__Workspace__Group__8__Impl rule__Workspace__Group__9
            {
            pushFollow(FOLLOW_12);
            rule__Workspace__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__8"


    // $ANTLR start "rule__Workspace__Group__8__Impl"
    // InternalQueryDsl.g:2914:1: rule__Workspace__Group__8__Impl : ( ( rule__Workspace__FieldAssignment_8 ) ) ;
    public final void rule__Workspace__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2918:1: ( ( ( rule__Workspace__FieldAssignment_8 ) ) )
            // InternalQueryDsl.g:2919:1: ( ( rule__Workspace__FieldAssignment_8 ) )
            {
            // InternalQueryDsl.g:2919:1: ( ( rule__Workspace__FieldAssignment_8 ) )
            // InternalQueryDsl.g:2920:2: ( rule__Workspace__FieldAssignment_8 )
            {
             before(grammarAccess.getWorkspaceAccess().getFieldAssignment_8()); 
            // InternalQueryDsl.g:2921:2: ( rule__Workspace__FieldAssignment_8 )
            // InternalQueryDsl.g:2921:3: rule__Workspace__FieldAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Workspace__FieldAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceAccess().getFieldAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__8__Impl"


    // $ANTLR start "rule__Workspace__Group__9"
    // InternalQueryDsl.g:2929:1: rule__Workspace__Group__9 : rule__Workspace__Group__9__Impl rule__Workspace__Group__10 ;
    public final void rule__Workspace__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2933:1: ( rule__Workspace__Group__9__Impl rule__Workspace__Group__10 )
            // InternalQueryDsl.g:2934:2: rule__Workspace__Group__9__Impl rule__Workspace__Group__10
            {
            pushFollow(FOLLOW_12);
            rule__Workspace__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__9"


    // $ANTLR start "rule__Workspace__Group__9__Impl"
    // InternalQueryDsl.g:2941:1: rule__Workspace__Group__9__Impl : ( ( rule__Workspace__Group_9__0 )* ) ;
    public final void rule__Workspace__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2945:1: ( ( ( rule__Workspace__Group_9__0 )* ) )
            // InternalQueryDsl.g:2946:1: ( ( rule__Workspace__Group_9__0 )* )
            {
            // InternalQueryDsl.g:2946:1: ( ( rule__Workspace__Group_9__0 )* )
            // InternalQueryDsl.g:2947:2: ( rule__Workspace__Group_9__0 )*
            {
             before(grammarAccess.getWorkspaceAccess().getGroup_9()); 
            // InternalQueryDsl.g:2948:2: ( rule__Workspace__Group_9__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==94) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalQueryDsl.g:2948:3: rule__Workspace__Group_9__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Workspace__Group_9__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getWorkspaceAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__9__Impl"


    // $ANTLR start "rule__Workspace__Group__10"
    // InternalQueryDsl.g:2956:1: rule__Workspace__Group__10 : rule__Workspace__Group__10__Impl ;
    public final void rule__Workspace__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2960:1: ( rule__Workspace__Group__10__Impl )
            // InternalQueryDsl.g:2961:2: rule__Workspace__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Workspace__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__10"


    // $ANTLR start "rule__Workspace__Group__10__Impl"
    // InternalQueryDsl.g:2967:1: rule__Workspace__Group__10__Impl : ( ']' ) ;
    public final void rule__Workspace__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2971:1: ( ( ']' ) )
            // InternalQueryDsl.g:2972:1: ( ']' )
            {
            // InternalQueryDsl.g:2972:1: ( ']' )
            // InternalQueryDsl.g:2973:2: ']'
            {
             before(grammarAccess.getWorkspaceAccess().getRightSquareBracketKeyword_10()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getWorkspaceAccess().getRightSquareBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group__10__Impl"


    // $ANTLR start "rule__Workspace__Group_4__0"
    // InternalQueryDsl.g:2983:1: rule__Workspace__Group_4__0 : rule__Workspace__Group_4__0__Impl rule__Workspace__Group_4__1 ;
    public final void rule__Workspace__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2987:1: ( rule__Workspace__Group_4__0__Impl rule__Workspace__Group_4__1 )
            // InternalQueryDsl.g:2988:2: rule__Workspace__Group_4__0__Impl rule__Workspace__Group_4__1
            {
            pushFollow(FOLLOW_14);
            rule__Workspace__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group_4__0"


    // $ANTLR start "rule__Workspace__Group_4__0__Impl"
    // InternalQueryDsl.g:2995:1: rule__Workspace__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Workspace__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2999:1: ( ( ',' ) )
            // InternalQueryDsl.g:3000:1: ( ',' )
            {
            // InternalQueryDsl.g:3000:1: ( ',' )
            // InternalQueryDsl.g:3001:2: ','
            {
             before(grammarAccess.getWorkspaceAccess().getCommaKeyword_4_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getWorkspaceAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group_4__0__Impl"


    // $ANTLR start "rule__Workspace__Group_4__1"
    // InternalQueryDsl.g:3010:1: rule__Workspace__Group_4__1 : rule__Workspace__Group_4__1__Impl ;
    public final void rule__Workspace__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3014:1: ( rule__Workspace__Group_4__1__Impl )
            // InternalQueryDsl.g:3015:2: rule__Workspace__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Workspace__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group_4__1"


    // $ANTLR start "rule__Workspace__Group_4__1__Impl"
    // InternalQueryDsl.g:3021:1: rule__Workspace__Group_4__1__Impl : ( ( rule__Workspace__SpacevarsAssignment_4_1 ) ) ;
    public final void rule__Workspace__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3025:1: ( ( ( rule__Workspace__SpacevarsAssignment_4_1 ) ) )
            // InternalQueryDsl.g:3026:1: ( ( rule__Workspace__SpacevarsAssignment_4_1 ) )
            {
            // InternalQueryDsl.g:3026:1: ( ( rule__Workspace__SpacevarsAssignment_4_1 ) )
            // InternalQueryDsl.g:3027:2: ( rule__Workspace__SpacevarsAssignment_4_1 )
            {
             before(grammarAccess.getWorkspaceAccess().getSpacevarsAssignment_4_1()); 
            // InternalQueryDsl.g:3028:2: ( rule__Workspace__SpacevarsAssignment_4_1 )
            // InternalQueryDsl.g:3028:3: rule__Workspace__SpacevarsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Workspace__SpacevarsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceAccess().getSpacevarsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group_4__1__Impl"


    // $ANTLR start "rule__Workspace__Group_9__0"
    // InternalQueryDsl.g:3037:1: rule__Workspace__Group_9__0 : rule__Workspace__Group_9__0__Impl rule__Workspace__Group_9__1 ;
    public final void rule__Workspace__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3041:1: ( rule__Workspace__Group_9__0__Impl rule__Workspace__Group_9__1 )
            // InternalQueryDsl.g:3042:2: rule__Workspace__Group_9__0__Impl rule__Workspace__Group_9__1
            {
            pushFollow(FOLLOW_15);
            rule__Workspace__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Workspace__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group_9__0"


    // $ANTLR start "rule__Workspace__Group_9__0__Impl"
    // InternalQueryDsl.g:3049:1: rule__Workspace__Group_9__0__Impl : ( ',' ) ;
    public final void rule__Workspace__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3053:1: ( ( ',' ) )
            // InternalQueryDsl.g:3054:1: ( ',' )
            {
            // InternalQueryDsl.g:3054:1: ( ',' )
            // InternalQueryDsl.g:3055:2: ','
            {
             before(grammarAccess.getWorkspaceAccess().getCommaKeyword_9_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getWorkspaceAccess().getCommaKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group_9__0__Impl"


    // $ANTLR start "rule__Workspace__Group_9__1"
    // InternalQueryDsl.g:3064:1: rule__Workspace__Group_9__1 : rule__Workspace__Group_9__1__Impl ;
    public final void rule__Workspace__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3068:1: ( rule__Workspace__Group_9__1__Impl )
            // InternalQueryDsl.g:3069:2: rule__Workspace__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Workspace__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group_9__1"


    // $ANTLR start "rule__Workspace__Group_9__1__Impl"
    // InternalQueryDsl.g:3075:1: rule__Workspace__Group_9__1__Impl : ( ( rule__Workspace__FieldsAssignment_9_1 ) ) ;
    public final void rule__Workspace__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3079:1: ( ( ( rule__Workspace__FieldsAssignment_9_1 ) ) )
            // InternalQueryDsl.g:3080:1: ( ( rule__Workspace__FieldsAssignment_9_1 ) )
            {
            // InternalQueryDsl.g:3080:1: ( ( rule__Workspace__FieldsAssignment_9_1 ) )
            // InternalQueryDsl.g:3081:2: ( rule__Workspace__FieldsAssignment_9_1 )
            {
             before(grammarAccess.getWorkspaceAccess().getFieldsAssignment_9_1()); 
            // InternalQueryDsl.g:3082:2: ( rule__Workspace__FieldsAssignment_9_1 )
            // InternalQueryDsl.g:3082:3: rule__Workspace__FieldsAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__Workspace__FieldsAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceAccess().getFieldsAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__Group_9__1__Impl"


    // $ANTLR start "rule__Project__Group__0"
    // InternalQueryDsl.g:3091:1: rule__Project__Group__0 : rule__Project__Group__0__Impl rule__Project__Group__1 ;
    public final void rule__Project__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3095:1: ( rule__Project__Group__0__Impl rule__Project__Group__1 )
            // InternalQueryDsl.g:3096:2: rule__Project__Group__0__Impl rule__Project__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Project__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__0"


    // $ANTLR start "rule__Project__Group__0__Impl"
    // InternalQueryDsl.g:3103:1: rule__Project__Group__0__Impl : ( 'Query' ) ;
    public final void rule__Project__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3107:1: ( ( 'Query' ) )
            // InternalQueryDsl.g:3108:1: ( 'Query' )
            {
            // InternalQueryDsl.g:3108:1: ( 'Query' )
            // InternalQueryDsl.g:3109:2: 'Query'
            {
             before(grammarAccess.getProjectAccess().getQueryKeyword_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getQueryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__0__Impl"


    // $ANTLR start "rule__Project__Group__1"
    // InternalQueryDsl.g:3118:1: rule__Project__Group__1 : rule__Project__Group__1__Impl rule__Project__Group__2 ;
    public final void rule__Project__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3122:1: ( rule__Project__Group__1__Impl rule__Project__Group__2 )
            // InternalQueryDsl.g:3123:2: rule__Project__Group__1__Impl rule__Project__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Project__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__1"


    // $ANTLR start "rule__Project__Group__1__Impl"
    // InternalQueryDsl.g:3130:1: rule__Project__Group__1__Impl : ( 'Project' ) ;
    public final void rule__Project__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3134:1: ( ( 'Project' ) )
            // InternalQueryDsl.g:3135:1: ( 'Project' )
            {
            // InternalQueryDsl.g:3135:1: ( 'Project' )
            // InternalQueryDsl.g:3136:2: 'Project'
            {
             before(grammarAccess.getProjectAccess().getProjectKeyword_1()); 
            match(input,96,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getProjectKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__1__Impl"


    // $ANTLR start "rule__Project__Group__2"
    // InternalQueryDsl.g:3145:1: rule__Project__Group__2 : rule__Project__Group__2__Impl rule__Project__Group__3 ;
    public final void rule__Project__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3149:1: ( rule__Project__Group__2__Impl rule__Project__Group__3 )
            // InternalQueryDsl.g:3150:2: rule__Project__Group__2__Impl rule__Project__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__Project__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__2"


    // $ANTLR start "rule__Project__Group__2__Impl"
    // InternalQueryDsl.g:3157:1: rule__Project__Group__2__Impl : ( '(' ) ;
    public final void rule__Project__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3161:1: ( ( '(' ) )
            // InternalQueryDsl.g:3162:1: ( '(' )
            {
            // InternalQueryDsl.g:3162:1: ( '(' )
            // InternalQueryDsl.g:3163:2: '('
            {
             before(grammarAccess.getProjectAccess().getLeftParenthesisKeyword_2()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__2__Impl"


    // $ANTLR start "rule__Project__Group__3"
    // InternalQueryDsl.g:3172:1: rule__Project__Group__3 : rule__Project__Group__3__Impl rule__Project__Group__4 ;
    public final void rule__Project__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3176:1: ( rule__Project__Group__3__Impl rule__Project__Group__4 )
            // InternalQueryDsl.g:3177:2: rule__Project__Group__3__Impl rule__Project__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Project__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__3"


    // $ANTLR start "rule__Project__Group__3__Impl"
    // InternalQueryDsl.g:3184:1: rule__Project__Group__3__Impl : ( ( rule__Project__ProjectvarAssignment_3 ) ) ;
    public final void rule__Project__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3188:1: ( ( ( rule__Project__ProjectvarAssignment_3 ) ) )
            // InternalQueryDsl.g:3189:1: ( ( rule__Project__ProjectvarAssignment_3 ) )
            {
            // InternalQueryDsl.g:3189:1: ( ( rule__Project__ProjectvarAssignment_3 ) )
            // InternalQueryDsl.g:3190:2: ( rule__Project__ProjectvarAssignment_3 )
            {
             before(grammarAccess.getProjectAccess().getProjectvarAssignment_3()); 
            // InternalQueryDsl.g:3191:2: ( rule__Project__ProjectvarAssignment_3 )
            // InternalQueryDsl.g:3191:3: rule__Project__ProjectvarAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Project__ProjectvarAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getProjectAccess().getProjectvarAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__3__Impl"


    // $ANTLR start "rule__Project__Group__4"
    // InternalQueryDsl.g:3199:1: rule__Project__Group__4 : rule__Project__Group__4__Impl rule__Project__Group__5 ;
    public final void rule__Project__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3203:1: ( rule__Project__Group__4__Impl rule__Project__Group__5 )
            // InternalQueryDsl.g:3204:2: rule__Project__Group__4__Impl rule__Project__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Project__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__4"


    // $ANTLR start "rule__Project__Group__4__Impl"
    // InternalQueryDsl.g:3211:1: rule__Project__Group__4__Impl : ( ( rule__Project__Group_4__0 )* ) ;
    public final void rule__Project__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3215:1: ( ( ( rule__Project__Group_4__0 )* ) )
            // InternalQueryDsl.g:3216:1: ( ( rule__Project__Group_4__0 )* )
            {
            // InternalQueryDsl.g:3216:1: ( ( rule__Project__Group_4__0 )* )
            // InternalQueryDsl.g:3217:2: ( rule__Project__Group_4__0 )*
            {
             before(grammarAccess.getProjectAccess().getGroup_4()); 
            // InternalQueryDsl.g:3218:2: ( rule__Project__Group_4__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==94) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalQueryDsl.g:3218:3: rule__Project__Group_4__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Project__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getProjectAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__4__Impl"


    // $ANTLR start "rule__Project__Group__5"
    // InternalQueryDsl.g:3226:1: rule__Project__Group__5 : rule__Project__Group__5__Impl rule__Project__Group__6 ;
    public final void rule__Project__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3230:1: ( rule__Project__Group__5__Impl rule__Project__Group__6 )
            // InternalQueryDsl.g:3231:2: rule__Project__Group__5__Impl rule__Project__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Project__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__5"


    // $ANTLR start "rule__Project__Group__5__Impl"
    // InternalQueryDsl.g:3238:1: rule__Project__Group__5__Impl : ( ')' ) ;
    public final void rule__Project__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3242:1: ( ( ')' ) )
            // InternalQueryDsl.g:3243:1: ( ')' )
            {
            // InternalQueryDsl.g:3243:1: ( ')' )
            // InternalQueryDsl.g:3244:2: ')'
            {
             before(grammarAccess.getProjectAccess().getRightParenthesisKeyword_5()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__5__Impl"


    // $ANTLR start "rule__Project__Group__6"
    // InternalQueryDsl.g:3253:1: rule__Project__Group__6 : rule__Project__Group__6__Impl rule__Project__Group__7 ;
    public final void rule__Project__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3257:1: ( rule__Project__Group__6__Impl rule__Project__Group__7 )
            // InternalQueryDsl.g:3258:2: rule__Project__Group__6__Impl rule__Project__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__Project__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__6"


    // $ANTLR start "rule__Project__Group__6__Impl"
    // InternalQueryDsl.g:3265:1: rule__Project__Group__6__Impl : ( 'return' ) ;
    public final void rule__Project__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3269:1: ( ( 'return' ) )
            // InternalQueryDsl.g:3270:1: ( 'return' )
            {
            // InternalQueryDsl.g:3270:1: ( 'return' )
            // InternalQueryDsl.g:3271:2: 'return'
            {
             before(grammarAccess.getProjectAccess().getReturnKeyword_6()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getReturnKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__6__Impl"


    // $ANTLR start "rule__Project__Group__7"
    // InternalQueryDsl.g:3280:1: rule__Project__Group__7 : rule__Project__Group__7__Impl rule__Project__Group__8 ;
    public final void rule__Project__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3284:1: ( rule__Project__Group__7__Impl rule__Project__Group__8 )
            // InternalQueryDsl.g:3285:2: rule__Project__Group__7__Impl rule__Project__Group__8
            {
            pushFollow(FOLLOW_18);
            rule__Project__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__7"


    // $ANTLR start "rule__Project__Group__7__Impl"
    // InternalQueryDsl.g:3292:1: rule__Project__Group__7__Impl : ( '[' ) ;
    public final void rule__Project__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3296:1: ( ( '[' ) )
            // InternalQueryDsl.g:3297:1: ( '[' )
            {
            // InternalQueryDsl.g:3297:1: ( '[' )
            // InternalQueryDsl.g:3298:2: '['
            {
             before(grammarAccess.getProjectAccess().getLeftSquareBracketKeyword_7()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getLeftSquareBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__7__Impl"


    // $ANTLR start "rule__Project__Group__8"
    // InternalQueryDsl.g:3307:1: rule__Project__Group__8 : rule__Project__Group__8__Impl rule__Project__Group__9 ;
    public final void rule__Project__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3311:1: ( rule__Project__Group__8__Impl rule__Project__Group__9 )
            // InternalQueryDsl.g:3312:2: rule__Project__Group__8__Impl rule__Project__Group__9
            {
            pushFollow(FOLLOW_12);
            rule__Project__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__8"


    // $ANTLR start "rule__Project__Group__8__Impl"
    // InternalQueryDsl.g:3319:1: rule__Project__Group__8__Impl : ( ( rule__Project__FieldAssignment_8 ) ) ;
    public final void rule__Project__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3323:1: ( ( ( rule__Project__FieldAssignment_8 ) ) )
            // InternalQueryDsl.g:3324:1: ( ( rule__Project__FieldAssignment_8 ) )
            {
            // InternalQueryDsl.g:3324:1: ( ( rule__Project__FieldAssignment_8 ) )
            // InternalQueryDsl.g:3325:2: ( rule__Project__FieldAssignment_8 )
            {
             before(grammarAccess.getProjectAccess().getFieldAssignment_8()); 
            // InternalQueryDsl.g:3326:2: ( rule__Project__FieldAssignment_8 )
            // InternalQueryDsl.g:3326:3: rule__Project__FieldAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Project__FieldAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getProjectAccess().getFieldAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__8__Impl"


    // $ANTLR start "rule__Project__Group__9"
    // InternalQueryDsl.g:3334:1: rule__Project__Group__9 : rule__Project__Group__9__Impl rule__Project__Group__10 ;
    public final void rule__Project__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3338:1: ( rule__Project__Group__9__Impl rule__Project__Group__10 )
            // InternalQueryDsl.g:3339:2: rule__Project__Group__9__Impl rule__Project__Group__10
            {
            pushFollow(FOLLOW_12);
            rule__Project__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__9"


    // $ANTLR start "rule__Project__Group__9__Impl"
    // InternalQueryDsl.g:3346:1: rule__Project__Group__9__Impl : ( ( rule__Project__Group_9__0 )* ) ;
    public final void rule__Project__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3350:1: ( ( ( rule__Project__Group_9__0 )* ) )
            // InternalQueryDsl.g:3351:1: ( ( rule__Project__Group_9__0 )* )
            {
            // InternalQueryDsl.g:3351:1: ( ( rule__Project__Group_9__0 )* )
            // InternalQueryDsl.g:3352:2: ( rule__Project__Group_9__0 )*
            {
             before(grammarAccess.getProjectAccess().getGroup_9()); 
            // InternalQueryDsl.g:3353:2: ( rule__Project__Group_9__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==94) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalQueryDsl.g:3353:3: rule__Project__Group_9__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Project__Group_9__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getProjectAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__9__Impl"


    // $ANTLR start "rule__Project__Group__10"
    // InternalQueryDsl.g:3361:1: rule__Project__Group__10 : rule__Project__Group__10__Impl ;
    public final void rule__Project__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3365:1: ( rule__Project__Group__10__Impl )
            // InternalQueryDsl.g:3366:2: rule__Project__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__10"


    // $ANTLR start "rule__Project__Group__10__Impl"
    // InternalQueryDsl.g:3372:1: rule__Project__Group__10__Impl : ( ']' ) ;
    public final void rule__Project__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3376:1: ( ( ']' ) )
            // InternalQueryDsl.g:3377:1: ( ']' )
            {
            // InternalQueryDsl.g:3377:1: ( ']' )
            // InternalQueryDsl.g:3378:2: ']'
            {
             before(grammarAccess.getProjectAccess().getRightSquareBracketKeyword_10()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getRightSquareBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__10__Impl"


    // $ANTLR start "rule__Project__Group_4__0"
    // InternalQueryDsl.g:3388:1: rule__Project__Group_4__0 : rule__Project__Group_4__0__Impl rule__Project__Group_4__1 ;
    public final void rule__Project__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3392:1: ( rule__Project__Group_4__0__Impl rule__Project__Group_4__1 )
            // InternalQueryDsl.g:3393:2: rule__Project__Group_4__0__Impl rule__Project__Group_4__1
            {
            pushFollow(FOLLOW_17);
            rule__Project__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_4__0"


    // $ANTLR start "rule__Project__Group_4__0__Impl"
    // InternalQueryDsl.g:3400:1: rule__Project__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Project__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3404:1: ( ( ',' ) )
            // InternalQueryDsl.g:3405:1: ( ',' )
            {
            // InternalQueryDsl.g:3405:1: ( ',' )
            // InternalQueryDsl.g:3406:2: ','
            {
             before(grammarAccess.getProjectAccess().getCommaKeyword_4_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_4__0__Impl"


    // $ANTLR start "rule__Project__Group_4__1"
    // InternalQueryDsl.g:3415:1: rule__Project__Group_4__1 : rule__Project__Group_4__1__Impl ;
    public final void rule__Project__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3419:1: ( rule__Project__Group_4__1__Impl )
            // InternalQueryDsl.g:3420:2: rule__Project__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_4__1"


    // $ANTLR start "rule__Project__Group_4__1__Impl"
    // InternalQueryDsl.g:3426:1: rule__Project__Group_4__1__Impl : ( ( rule__Project__ProjectvarsAssignment_4_1 ) ) ;
    public final void rule__Project__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3430:1: ( ( ( rule__Project__ProjectvarsAssignment_4_1 ) ) )
            // InternalQueryDsl.g:3431:1: ( ( rule__Project__ProjectvarsAssignment_4_1 ) )
            {
            // InternalQueryDsl.g:3431:1: ( ( rule__Project__ProjectvarsAssignment_4_1 ) )
            // InternalQueryDsl.g:3432:2: ( rule__Project__ProjectvarsAssignment_4_1 )
            {
             before(grammarAccess.getProjectAccess().getProjectvarsAssignment_4_1()); 
            // InternalQueryDsl.g:3433:2: ( rule__Project__ProjectvarsAssignment_4_1 )
            // InternalQueryDsl.g:3433:3: rule__Project__ProjectvarsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Project__ProjectvarsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getProjectAccess().getProjectvarsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_4__1__Impl"


    // $ANTLR start "rule__Project__Group_9__0"
    // InternalQueryDsl.g:3442:1: rule__Project__Group_9__0 : rule__Project__Group_9__0__Impl rule__Project__Group_9__1 ;
    public final void rule__Project__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3446:1: ( rule__Project__Group_9__0__Impl rule__Project__Group_9__1 )
            // InternalQueryDsl.g:3447:2: rule__Project__Group_9__0__Impl rule__Project__Group_9__1
            {
            pushFollow(FOLLOW_18);
            rule__Project__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_9__0"


    // $ANTLR start "rule__Project__Group_9__0__Impl"
    // InternalQueryDsl.g:3454:1: rule__Project__Group_9__0__Impl : ( ',' ) ;
    public final void rule__Project__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3458:1: ( ( ',' ) )
            // InternalQueryDsl.g:3459:1: ( ',' )
            {
            // InternalQueryDsl.g:3459:1: ( ',' )
            // InternalQueryDsl.g:3460:2: ','
            {
             before(grammarAccess.getProjectAccess().getCommaKeyword_9_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getCommaKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_9__0__Impl"


    // $ANTLR start "rule__Project__Group_9__1"
    // InternalQueryDsl.g:3469:1: rule__Project__Group_9__1 : rule__Project__Group_9__1__Impl ;
    public final void rule__Project__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3473:1: ( rule__Project__Group_9__1__Impl )
            // InternalQueryDsl.g:3474:2: rule__Project__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_9__1"


    // $ANTLR start "rule__Project__Group_9__1__Impl"
    // InternalQueryDsl.g:3480:1: rule__Project__Group_9__1__Impl : ( ( rule__Project__FieldsAssignment_9_1 ) ) ;
    public final void rule__Project__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3484:1: ( ( ( rule__Project__FieldsAssignment_9_1 ) ) )
            // InternalQueryDsl.g:3485:1: ( ( rule__Project__FieldsAssignment_9_1 ) )
            {
            // InternalQueryDsl.g:3485:1: ( ( rule__Project__FieldsAssignment_9_1 ) )
            // InternalQueryDsl.g:3486:2: ( rule__Project__FieldsAssignment_9_1 )
            {
             before(grammarAccess.getProjectAccess().getFieldsAssignment_9_1()); 
            // InternalQueryDsl.g:3487:2: ( rule__Project__FieldsAssignment_9_1 )
            // InternalQueryDsl.g:3487:3: rule__Project__FieldsAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__Project__FieldsAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getProjectAccess().getFieldsAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_9__1__Impl"


    // $ANTLR start "rule__Metamodel__Group__0"
    // InternalQueryDsl.g:3496:1: rule__Metamodel__Group__0 : rule__Metamodel__Group__0__Impl rule__Metamodel__Group__1 ;
    public final void rule__Metamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3500:1: ( rule__Metamodel__Group__0__Impl rule__Metamodel__Group__1 )
            // InternalQueryDsl.g:3501:2: rule__Metamodel__Group__0__Impl rule__Metamodel__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Metamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__0"


    // $ANTLR start "rule__Metamodel__Group__0__Impl"
    // InternalQueryDsl.g:3508:1: rule__Metamodel__Group__0__Impl : ( 'Query' ) ;
    public final void rule__Metamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3512:1: ( ( 'Query' ) )
            // InternalQueryDsl.g:3513:1: ( 'Query' )
            {
            // InternalQueryDsl.g:3513:1: ( 'Query' )
            // InternalQueryDsl.g:3514:2: 'Query'
            {
             before(grammarAccess.getMetamodelAccess().getQueryKeyword_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getQueryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__0__Impl"


    // $ANTLR start "rule__Metamodel__Group__1"
    // InternalQueryDsl.g:3523:1: rule__Metamodel__Group__1 : rule__Metamodel__Group__1__Impl rule__Metamodel__Group__2 ;
    public final void rule__Metamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3527:1: ( rule__Metamodel__Group__1__Impl rule__Metamodel__Group__2 )
            // InternalQueryDsl.g:3528:2: rule__Metamodel__Group__1__Impl rule__Metamodel__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Metamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__1"


    // $ANTLR start "rule__Metamodel__Group__1__Impl"
    // InternalQueryDsl.g:3535:1: rule__Metamodel__Group__1__Impl : ( 'Metamodel' ) ;
    public final void rule__Metamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3539:1: ( ( 'Metamodel' ) )
            // InternalQueryDsl.g:3540:1: ( 'Metamodel' )
            {
            // InternalQueryDsl.g:3540:1: ( 'Metamodel' )
            // InternalQueryDsl.g:3541:2: 'Metamodel'
            {
             before(grammarAccess.getMetamodelAccess().getMetamodelKeyword_1()); 
            match(input,97,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getMetamodelKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__1__Impl"


    // $ANTLR start "rule__Metamodel__Group__2"
    // InternalQueryDsl.g:3550:1: rule__Metamodel__Group__2 : rule__Metamodel__Group__2__Impl rule__Metamodel__Group__3 ;
    public final void rule__Metamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3554:1: ( rule__Metamodel__Group__2__Impl rule__Metamodel__Group__3 )
            // InternalQueryDsl.g:3555:2: rule__Metamodel__Group__2__Impl rule__Metamodel__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Metamodel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__2"


    // $ANTLR start "rule__Metamodel__Group__2__Impl"
    // InternalQueryDsl.g:3562:1: rule__Metamodel__Group__2__Impl : ( '(' ) ;
    public final void rule__Metamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3566:1: ( ( '(' ) )
            // InternalQueryDsl.g:3567:1: ( '(' )
            {
            // InternalQueryDsl.g:3567:1: ( '(' )
            // InternalQueryDsl.g:3568:2: '('
            {
             before(grammarAccess.getMetamodelAccess().getLeftParenthesisKeyword_2()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__2__Impl"


    // $ANTLR start "rule__Metamodel__Group__3"
    // InternalQueryDsl.g:3577:1: rule__Metamodel__Group__3 : rule__Metamodel__Group__3__Impl rule__Metamodel__Group__4 ;
    public final void rule__Metamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3581:1: ( rule__Metamodel__Group__3__Impl rule__Metamodel__Group__4 )
            // InternalQueryDsl.g:3582:2: rule__Metamodel__Group__3__Impl rule__Metamodel__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Metamodel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__3"


    // $ANTLR start "rule__Metamodel__Group__3__Impl"
    // InternalQueryDsl.g:3589:1: rule__Metamodel__Group__3__Impl : ( ( rule__Metamodel__MetamodelVarAssignment_3 ) ) ;
    public final void rule__Metamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3593:1: ( ( ( rule__Metamodel__MetamodelVarAssignment_3 ) ) )
            // InternalQueryDsl.g:3594:1: ( ( rule__Metamodel__MetamodelVarAssignment_3 ) )
            {
            // InternalQueryDsl.g:3594:1: ( ( rule__Metamodel__MetamodelVarAssignment_3 ) )
            // InternalQueryDsl.g:3595:2: ( rule__Metamodel__MetamodelVarAssignment_3 )
            {
             before(grammarAccess.getMetamodelAccess().getMetamodelVarAssignment_3()); 
            // InternalQueryDsl.g:3596:2: ( rule__Metamodel__MetamodelVarAssignment_3 )
            // InternalQueryDsl.g:3596:3: rule__Metamodel__MetamodelVarAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__MetamodelVarAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelAccess().getMetamodelVarAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__3__Impl"


    // $ANTLR start "rule__Metamodel__Group__4"
    // InternalQueryDsl.g:3604:1: rule__Metamodel__Group__4 : rule__Metamodel__Group__4__Impl rule__Metamodel__Group__5 ;
    public final void rule__Metamodel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3608:1: ( rule__Metamodel__Group__4__Impl rule__Metamodel__Group__5 )
            // InternalQueryDsl.g:3609:2: rule__Metamodel__Group__4__Impl rule__Metamodel__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Metamodel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__4"


    // $ANTLR start "rule__Metamodel__Group__4__Impl"
    // InternalQueryDsl.g:3616:1: rule__Metamodel__Group__4__Impl : ( ( rule__Metamodel__Group_4__0 )* ) ;
    public final void rule__Metamodel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3620:1: ( ( ( rule__Metamodel__Group_4__0 )* ) )
            // InternalQueryDsl.g:3621:1: ( ( rule__Metamodel__Group_4__0 )* )
            {
            // InternalQueryDsl.g:3621:1: ( ( rule__Metamodel__Group_4__0 )* )
            // InternalQueryDsl.g:3622:2: ( rule__Metamodel__Group_4__0 )*
            {
             before(grammarAccess.getMetamodelAccess().getGroup_4()); 
            // InternalQueryDsl.g:3623:2: ( rule__Metamodel__Group_4__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==94) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalQueryDsl.g:3623:3: rule__Metamodel__Group_4__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Metamodel__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getMetamodelAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__4__Impl"


    // $ANTLR start "rule__Metamodel__Group__5"
    // InternalQueryDsl.g:3631:1: rule__Metamodel__Group__5 : rule__Metamodel__Group__5__Impl rule__Metamodel__Group__6 ;
    public final void rule__Metamodel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3635:1: ( rule__Metamodel__Group__5__Impl rule__Metamodel__Group__6 )
            // InternalQueryDsl.g:3636:2: rule__Metamodel__Group__5__Impl rule__Metamodel__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__Metamodel__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__5"


    // $ANTLR start "rule__Metamodel__Group__5__Impl"
    // InternalQueryDsl.g:3643:1: rule__Metamodel__Group__5__Impl : ( ')' ) ;
    public final void rule__Metamodel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3647:1: ( ( ')' ) )
            // InternalQueryDsl.g:3648:1: ( ')' )
            {
            // InternalQueryDsl.g:3648:1: ( ')' )
            // InternalQueryDsl.g:3649:2: ')'
            {
             before(grammarAccess.getMetamodelAccess().getRightParenthesisKeyword_5()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__5__Impl"


    // $ANTLR start "rule__Metamodel__Group__6"
    // InternalQueryDsl.g:3658:1: rule__Metamodel__Group__6 : rule__Metamodel__Group__6__Impl rule__Metamodel__Group__7 ;
    public final void rule__Metamodel__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3662:1: ( rule__Metamodel__Group__6__Impl rule__Metamodel__Group__7 )
            // InternalQueryDsl.g:3663:2: rule__Metamodel__Group__6__Impl rule__Metamodel__Group__7
            {
            pushFollow(FOLLOW_21);
            rule__Metamodel__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__6"


    // $ANTLR start "rule__Metamodel__Group__6__Impl"
    // InternalQueryDsl.g:3670:1: rule__Metamodel__Group__6__Impl : ( ( rule__Metamodel__Group_6__0 )* ) ;
    public final void rule__Metamodel__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3674:1: ( ( ( rule__Metamodel__Group_6__0 )* ) )
            // InternalQueryDsl.g:3675:1: ( ( rule__Metamodel__Group_6__0 )* )
            {
            // InternalQueryDsl.g:3675:1: ( ( rule__Metamodel__Group_6__0 )* )
            // InternalQueryDsl.g:3676:2: ( rule__Metamodel__Group_6__0 )*
            {
             before(grammarAccess.getMetamodelAccess().getGroup_6()); 
            // InternalQueryDsl.g:3677:2: ( rule__Metamodel__Group_6__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==98) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalQueryDsl.g:3677:3: rule__Metamodel__Group_6__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Metamodel__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getMetamodelAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__6__Impl"


    // $ANTLR start "rule__Metamodel__Group__7"
    // InternalQueryDsl.g:3685:1: rule__Metamodel__Group__7 : rule__Metamodel__Group__7__Impl rule__Metamodel__Group__8 ;
    public final void rule__Metamodel__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3689:1: ( rule__Metamodel__Group__7__Impl rule__Metamodel__Group__8 )
            // InternalQueryDsl.g:3690:2: rule__Metamodel__Group__7__Impl rule__Metamodel__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__Metamodel__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__7"


    // $ANTLR start "rule__Metamodel__Group__7__Impl"
    // InternalQueryDsl.g:3697:1: rule__Metamodel__Group__7__Impl : ( 'return' ) ;
    public final void rule__Metamodel__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3701:1: ( ( 'return' ) )
            // InternalQueryDsl.g:3702:1: ( 'return' )
            {
            // InternalQueryDsl.g:3702:1: ( 'return' )
            // InternalQueryDsl.g:3703:2: 'return'
            {
             before(grammarAccess.getMetamodelAccess().getReturnKeyword_7()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getReturnKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__7__Impl"


    // $ANTLR start "rule__Metamodel__Group__8"
    // InternalQueryDsl.g:3712:1: rule__Metamodel__Group__8 : rule__Metamodel__Group__8__Impl rule__Metamodel__Group__9 ;
    public final void rule__Metamodel__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3716:1: ( rule__Metamodel__Group__8__Impl rule__Metamodel__Group__9 )
            // InternalQueryDsl.g:3717:2: rule__Metamodel__Group__8__Impl rule__Metamodel__Group__9
            {
            pushFollow(FOLLOW_23);
            rule__Metamodel__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__8"


    // $ANTLR start "rule__Metamodel__Group__8__Impl"
    // InternalQueryDsl.g:3724:1: rule__Metamodel__Group__8__Impl : ( '[' ) ;
    public final void rule__Metamodel__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3728:1: ( ( '[' ) )
            // InternalQueryDsl.g:3729:1: ( '[' )
            {
            // InternalQueryDsl.g:3729:1: ( '[' )
            // InternalQueryDsl.g:3730:2: '['
            {
             before(grammarAccess.getMetamodelAccess().getLeftSquareBracketKeyword_8()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getLeftSquareBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__8__Impl"


    // $ANTLR start "rule__Metamodel__Group__9"
    // InternalQueryDsl.g:3739:1: rule__Metamodel__Group__9 : rule__Metamodel__Group__9__Impl rule__Metamodel__Group__10 ;
    public final void rule__Metamodel__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3743:1: ( rule__Metamodel__Group__9__Impl rule__Metamodel__Group__10 )
            // InternalQueryDsl.g:3744:2: rule__Metamodel__Group__9__Impl rule__Metamodel__Group__10
            {
            pushFollow(FOLLOW_12);
            rule__Metamodel__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__9"


    // $ANTLR start "rule__Metamodel__Group__9__Impl"
    // InternalQueryDsl.g:3751:1: rule__Metamodel__Group__9__Impl : ( ( rule__Metamodel__FieldAssignment_9 ) ) ;
    public final void rule__Metamodel__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3755:1: ( ( ( rule__Metamodel__FieldAssignment_9 ) ) )
            // InternalQueryDsl.g:3756:1: ( ( rule__Metamodel__FieldAssignment_9 ) )
            {
            // InternalQueryDsl.g:3756:1: ( ( rule__Metamodel__FieldAssignment_9 ) )
            // InternalQueryDsl.g:3757:2: ( rule__Metamodel__FieldAssignment_9 )
            {
             before(grammarAccess.getMetamodelAccess().getFieldAssignment_9()); 
            // InternalQueryDsl.g:3758:2: ( rule__Metamodel__FieldAssignment_9 )
            // InternalQueryDsl.g:3758:3: rule__Metamodel__FieldAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__FieldAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelAccess().getFieldAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__9__Impl"


    // $ANTLR start "rule__Metamodel__Group__10"
    // InternalQueryDsl.g:3766:1: rule__Metamodel__Group__10 : rule__Metamodel__Group__10__Impl rule__Metamodel__Group__11 ;
    public final void rule__Metamodel__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3770:1: ( rule__Metamodel__Group__10__Impl rule__Metamodel__Group__11 )
            // InternalQueryDsl.g:3771:2: rule__Metamodel__Group__10__Impl rule__Metamodel__Group__11
            {
            pushFollow(FOLLOW_12);
            rule__Metamodel__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__10"


    // $ANTLR start "rule__Metamodel__Group__10__Impl"
    // InternalQueryDsl.g:3778:1: rule__Metamodel__Group__10__Impl : ( ( rule__Metamodel__Group_10__0 )* ) ;
    public final void rule__Metamodel__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3782:1: ( ( ( rule__Metamodel__Group_10__0 )* ) )
            // InternalQueryDsl.g:3783:1: ( ( rule__Metamodel__Group_10__0 )* )
            {
            // InternalQueryDsl.g:3783:1: ( ( rule__Metamodel__Group_10__0 )* )
            // InternalQueryDsl.g:3784:2: ( rule__Metamodel__Group_10__0 )*
            {
             before(grammarAccess.getMetamodelAccess().getGroup_10()); 
            // InternalQueryDsl.g:3785:2: ( rule__Metamodel__Group_10__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==94) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalQueryDsl.g:3785:3: rule__Metamodel__Group_10__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Metamodel__Group_10__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getMetamodelAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__10__Impl"


    // $ANTLR start "rule__Metamodel__Group__11"
    // InternalQueryDsl.g:3793:1: rule__Metamodel__Group__11 : rule__Metamodel__Group__11__Impl ;
    public final void rule__Metamodel__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3797:1: ( rule__Metamodel__Group__11__Impl )
            // InternalQueryDsl.g:3798:2: rule__Metamodel__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__11"


    // $ANTLR start "rule__Metamodel__Group__11__Impl"
    // InternalQueryDsl.g:3804:1: rule__Metamodel__Group__11__Impl : ( ']' ) ;
    public final void rule__Metamodel__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3808:1: ( ( ']' ) )
            // InternalQueryDsl.g:3809:1: ( ']' )
            {
            // InternalQueryDsl.g:3809:1: ( ']' )
            // InternalQueryDsl.g:3810:2: ']'
            {
             before(grammarAccess.getMetamodelAccess().getRightSquareBracketKeyword_11()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getRightSquareBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group__11__Impl"


    // $ANTLR start "rule__Metamodel__Group_4__0"
    // InternalQueryDsl.g:3820:1: rule__Metamodel__Group_4__0 : rule__Metamodel__Group_4__0__Impl rule__Metamodel__Group_4__1 ;
    public final void rule__Metamodel__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3824:1: ( rule__Metamodel__Group_4__0__Impl rule__Metamodel__Group_4__1 )
            // InternalQueryDsl.g:3825:2: rule__Metamodel__Group_4__0__Impl rule__Metamodel__Group_4__1
            {
            pushFollow(FOLLOW_20);
            rule__Metamodel__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_4__0"


    // $ANTLR start "rule__Metamodel__Group_4__0__Impl"
    // InternalQueryDsl.g:3832:1: rule__Metamodel__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Metamodel__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3836:1: ( ( ',' ) )
            // InternalQueryDsl.g:3837:1: ( ',' )
            {
            // InternalQueryDsl.g:3837:1: ( ',' )
            // InternalQueryDsl.g:3838:2: ','
            {
             before(grammarAccess.getMetamodelAccess().getCommaKeyword_4_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_4__0__Impl"


    // $ANTLR start "rule__Metamodel__Group_4__1"
    // InternalQueryDsl.g:3847:1: rule__Metamodel__Group_4__1 : rule__Metamodel__Group_4__1__Impl ;
    public final void rule__Metamodel__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3851:1: ( rule__Metamodel__Group_4__1__Impl )
            // InternalQueryDsl.g:3852:2: rule__Metamodel__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_4__1"


    // $ANTLR start "rule__Metamodel__Group_4__1__Impl"
    // InternalQueryDsl.g:3858:1: rule__Metamodel__Group_4__1__Impl : ( ( rule__Metamodel__MetamodelVarsAssignment_4_1 ) ) ;
    public final void rule__Metamodel__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3862:1: ( ( ( rule__Metamodel__MetamodelVarsAssignment_4_1 ) ) )
            // InternalQueryDsl.g:3863:1: ( ( rule__Metamodel__MetamodelVarsAssignment_4_1 ) )
            {
            // InternalQueryDsl.g:3863:1: ( ( rule__Metamodel__MetamodelVarsAssignment_4_1 ) )
            // InternalQueryDsl.g:3864:2: ( rule__Metamodel__MetamodelVarsAssignment_4_1 )
            {
             before(grammarAccess.getMetamodelAccess().getMetamodelVarsAssignment_4_1()); 
            // InternalQueryDsl.g:3865:2: ( rule__Metamodel__MetamodelVarsAssignment_4_1 )
            // InternalQueryDsl.g:3865:3: rule__Metamodel__MetamodelVarsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__MetamodelVarsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelAccess().getMetamodelVarsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_4__1__Impl"


    // $ANTLR start "rule__Metamodel__Group_6__0"
    // InternalQueryDsl.g:3874:1: rule__Metamodel__Group_6__0 : rule__Metamodel__Group_6__0__Impl rule__Metamodel__Group_6__1 ;
    public final void rule__Metamodel__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3878:1: ( rule__Metamodel__Group_6__0__Impl rule__Metamodel__Group_6__1 )
            // InternalQueryDsl.g:3879:2: rule__Metamodel__Group_6__0__Impl rule__Metamodel__Group_6__1
            {
            pushFollow(FOLLOW_24);
            rule__Metamodel__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_6__0"


    // $ANTLR start "rule__Metamodel__Group_6__0__Impl"
    // InternalQueryDsl.g:3886:1: rule__Metamodel__Group_6__0__Impl : ( '=>' ) ;
    public final void rule__Metamodel__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3890:1: ( ( '=>' ) )
            // InternalQueryDsl.g:3891:1: ( '=>' )
            {
            // InternalQueryDsl.g:3891:1: ( '=>' )
            // InternalQueryDsl.g:3892:2: '=>'
            {
             before(grammarAccess.getMetamodelAccess().getEqualsSignGreaterThanSignKeyword_6_0()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getEqualsSignGreaterThanSignKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_6__0__Impl"


    // $ANTLR start "rule__Metamodel__Group_6__1"
    // InternalQueryDsl.g:3901:1: rule__Metamodel__Group_6__1 : rule__Metamodel__Group_6__1__Impl ;
    public final void rule__Metamodel__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3905:1: ( rule__Metamodel__Group_6__1__Impl )
            // InternalQueryDsl.g:3906:2: rule__Metamodel__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_6__1"


    // $ANTLR start "rule__Metamodel__Group_6__1__Impl"
    // InternalQueryDsl.g:3912:1: rule__Metamodel__Group_6__1__Impl : ( ( rule__Metamodel__Alternatives_6_1 ) ) ;
    public final void rule__Metamodel__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3916:1: ( ( ( rule__Metamodel__Alternatives_6_1 ) ) )
            // InternalQueryDsl.g:3917:1: ( ( rule__Metamodel__Alternatives_6_1 ) )
            {
            // InternalQueryDsl.g:3917:1: ( ( rule__Metamodel__Alternatives_6_1 ) )
            // InternalQueryDsl.g:3918:2: ( rule__Metamodel__Alternatives_6_1 )
            {
             before(grammarAccess.getMetamodelAccess().getAlternatives_6_1()); 
            // InternalQueryDsl.g:3919:2: ( rule__Metamodel__Alternatives_6_1 )
            // InternalQueryDsl.g:3919:3: rule__Metamodel__Alternatives_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__Alternatives_6_1();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelAccess().getAlternatives_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_6__1__Impl"


    // $ANTLR start "rule__Metamodel__Group_10__0"
    // InternalQueryDsl.g:3928:1: rule__Metamodel__Group_10__0 : rule__Metamodel__Group_10__0__Impl rule__Metamodel__Group_10__1 ;
    public final void rule__Metamodel__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3932:1: ( rule__Metamodel__Group_10__0__Impl rule__Metamodel__Group_10__1 )
            // InternalQueryDsl.g:3933:2: rule__Metamodel__Group_10__0__Impl rule__Metamodel__Group_10__1
            {
            pushFollow(FOLLOW_23);
            rule__Metamodel__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metamodel__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_10__0"


    // $ANTLR start "rule__Metamodel__Group_10__0__Impl"
    // InternalQueryDsl.g:3940:1: rule__Metamodel__Group_10__0__Impl : ( ',' ) ;
    public final void rule__Metamodel__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3944:1: ( ( ',' ) )
            // InternalQueryDsl.g:3945:1: ( ',' )
            {
            // InternalQueryDsl.g:3945:1: ( ',' )
            // InternalQueryDsl.g:3946:2: ','
            {
             before(grammarAccess.getMetamodelAccess().getCommaKeyword_10_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getMetamodelAccess().getCommaKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_10__0__Impl"


    // $ANTLR start "rule__Metamodel__Group_10__1"
    // InternalQueryDsl.g:3955:1: rule__Metamodel__Group_10__1 : rule__Metamodel__Group_10__1__Impl ;
    public final void rule__Metamodel__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3959:1: ( rule__Metamodel__Group_10__1__Impl )
            // InternalQueryDsl.g:3960:2: rule__Metamodel__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_10__1"


    // $ANTLR start "rule__Metamodel__Group_10__1__Impl"
    // InternalQueryDsl.g:3966:1: rule__Metamodel__Group_10__1__Impl : ( ( rule__Metamodel__FieldsAssignment_10_1 ) ) ;
    public final void rule__Metamodel__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3970:1: ( ( ( rule__Metamodel__FieldsAssignment_10_1 ) ) )
            // InternalQueryDsl.g:3971:1: ( ( rule__Metamodel__FieldsAssignment_10_1 ) )
            {
            // InternalQueryDsl.g:3971:1: ( ( rule__Metamodel__FieldsAssignment_10_1 ) )
            // InternalQueryDsl.g:3972:2: ( rule__Metamodel__FieldsAssignment_10_1 )
            {
             before(grammarAccess.getMetamodelAccess().getFieldsAssignment_10_1()); 
            // InternalQueryDsl.g:3973:2: ( rule__Metamodel__FieldsAssignment_10_1 )
            // InternalQueryDsl.g:3973:3: rule__Metamodel__FieldsAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Metamodel__FieldsAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelAccess().getFieldsAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__Group_10__1__Impl"


    // $ANTLR start "rule__Model__Group__0"
    // InternalQueryDsl.g:3982:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3986:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalQueryDsl.g:3987:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalQueryDsl.g:3994:1: rule__Model__Group__0__Impl : ( 'Query' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3998:1: ( ( 'Query' ) )
            // InternalQueryDsl.g:3999:1: ( 'Query' )
            {
            // InternalQueryDsl.g:3999:1: ( 'Query' )
            // InternalQueryDsl.g:4000:2: 'Query'
            {
             before(grammarAccess.getModelAccess().getQueryKeyword_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getQueryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalQueryDsl.g:4009:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4013:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalQueryDsl.g:4014:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalQueryDsl.g:4021:1: rule__Model__Group__1__Impl : ( 'Model' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4025:1: ( ( 'Model' ) )
            // InternalQueryDsl.g:4026:1: ( 'Model' )
            {
            // InternalQueryDsl.g:4026:1: ( 'Model' )
            // InternalQueryDsl.g:4027:2: 'Model'
            {
             before(grammarAccess.getModelAccess().getModelKeyword_1()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getModelKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalQueryDsl.g:4036:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4040:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalQueryDsl.g:4041:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalQueryDsl.g:4048:1: rule__Model__Group__2__Impl : ( '(' ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4052:1: ( ( '(' ) )
            // InternalQueryDsl.g:4053:1: ( '(' )
            {
            // InternalQueryDsl.g:4053:1: ( '(' )
            // InternalQueryDsl.g:4054:2: '('
            {
             before(grammarAccess.getModelAccess().getLeftParenthesisKeyword_2()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // InternalQueryDsl.g:4063:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4067:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalQueryDsl.g:4068:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // InternalQueryDsl.g:4075:1: rule__Model__Group__3__Impl : ( ( rule__Model__ModelVarAssignment_3 ) ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4079:1: ( ( ( rule__Model__ModelVarAssignment_3 ) ) )
            // InternalQueryDsl.g:4080:1: ( ( rule__Model__ModelVarAssignment_3 ) )
            {
            // InternalQueryDsl.g:4080:1: ( ( rule__Model__ModelVarAssignment_3 ) )
            // InternalQueryDsl.g:4081:2: ( rule__Model__ModelVarAssignment_3 )
            {
             before(grammarAccess.getModelAccess().getModelVarAssignment_3()); 
            // InternalQueryDsl.g:4082:2: ( rule__Model__ModelVarAssignment_3 )
            // InternalQueryDsl.g:4082:3: rule__Model__ModelVarAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Model__ModelVarAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getModelVarAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // InternalQueryDsl.g:4090:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4094:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // InternalQueryDsl.g:4095:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // InternalQueryDsl.g:4102:1: rule__Model__Group__4__Impl : ( ( rule__Model__Group_4__0 )* ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4106:1: ( ( ( rule__Model__Group_4__0 )* ) )
            // InternalQueryDsl.g:4107:1: ( ( rule__Model__Group_4__0 )* )
            {
            // InternalQueryDsl.g:4107:1: ( ( rule__Model__Group_4__0 )* )
            // InternalQueryDsl.g:4108:2: ( rule__Model__Group_4__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_4()); 
            // InternalQueryDsl.g:4109:2: ( rule__Model__Group_4__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==94) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalQueryDsl.g:4109:3: rule__Model__Group_4__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Model__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Model__Group__5"
    // InternalQueryDsl.g:4117:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4121:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // InternalQueryDsl.g:4122:2: rule__Model__Group__5__Impl rule__Model__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__Model__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5"


    // $ANTLR start "rule__Model__Group__5__Impl"
    // InternalQueryDsl.g:4129:1: rule__Model__Group__5__Impl : ( ')' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4133:1: ( ( ')' ) )
            // InternalQueryDsl.g:4134:1: ( ')' )
            {
            // InternalQueryDsl.g:4134:1: ( ')' )
            // InternalQueryDsl.g:4135:2: ')'
            {
             before(grammarAccess.getModelAccess().getRightParenthesisKeyword_5()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5__Impl"


    // $ANTLR start "rule__Model__Group__6"
    // InternalQueryDsl.g:4144:1: rule__Model__Group__6 : rule__Model__Group__6__Impl rule__Model__Group__7 ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4148:1: ( rule__Model__Group__6__Impl rule__Model__Group__7 )
            // InternalQueryDsl.g:4149:2: rule__Model__Group__6__Impl rule__Model__Group__7
            {
            pushFollow(FOLLOW_21);
            rule__Model__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__6"


    // $ANTLR start "rule__Model__Group__6__Impl"
    // InternalQueryDsl.g:4156:1: rule__Model__Group__6__Impl : ( ( rule__Model__Group_6__0 )* ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4160:1: ( ( ( rule__Model__Group_6__0 )* ) )
            // InternalQueryDsl.g:4161:1: ( ( rule__Model__Group_6__0 )* )
            {
            // InternalQueryDsl.g:4161:1: ( ( rule__Model__Group_6__0 )* )
            // InternalQueryDsl.g:4162:2: ( rule__Model__Group_6__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_6()); 
            // InternalQueryDsl.g:4163:2: ( rule__Model__Group_6__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==98) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalQueryDsl.g:4163:3: rule__Model__Group_6__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Model__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__6__Impl"


    // $ANTLR start "rule__Model__Group__7"
    // InternalQueryDsl.g:4171:1: rule__Model__Group__7 : rule__Model__Group__7__Impl rule__Model__Group__8 ;
    public final void rule__Model__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4175:1: ( rule__Model__Group__7__Impl rule__Model__Group__8 )
            // InternalQueryDsl.g:4176:2: rule__Model__Group__7__Impl rule__Model__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__Model__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__7"


    // $ANTLR start "rule__Model__Group__7__Impl"
    // InternalQueryDsl.g:4183:1: rule__Model__Group__7__Impl : ( 'return' ) ;
    public final void rule__Model__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4187:1: ( ( 'return' ) )
            // InternalQueryDsl.g:4188:1: ( 'return' )
            {
            // InternalQueryDsl.g:4188:1: ( 'return' )
            // InternalQueryDsl.g:4189:2: 'return'
            {
             before(grammarAccess.getModelAccess().getReturnKeyword_7()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getReturnKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__7__Impl"


    // $ANTLR start "rule__Model__Group__8"
    // InternalQueryDsl.g:4198:1: rule__Model__Group__8 : rule__Model__Group__8__Impl rule__Model__Group__9 ;
    public final void rule__Model__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4202:1: ( rule__Model__Group__8__Impl rule__Model__Group__9 )
            // InternalQueryDsl.g:4203:2: rule__Model__Group__8__Impl rule__Model__Group__9
            {
            pushFollow(FOLLOW_26);
            rule__Model__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__8"


    // $ANTLR start "rule__Model__Group__8__Impl"
    // InternalQueryDsl.g:4210:1: rule__Model__Group__8__Impl : ( '[' ) ;
    public final void rule__Model__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4214:1: ( ( '[' ) )
            // InternalQueryDsl.g:4215:1: ( '[' )
            {
            // InternalQueryDsl.g:4215:1: ( '[' )
            // InternalQueryDsl.g:4216:2: '['
            {
             before(grammarAccess.getModelAccess().getLeftSquareBracketKeyword_8()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getLeftSquareBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__8__Impl"


    // $ANTLR start "rule__Model__Group__9"
    // InternalQueryDsl.g:4225:1: rule__Model__Group__9 : rule__Model__Group__9__Impl rule__Model__Group__10 ;
    public final void rule__Model__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4229:1: ( rule__Model__Group__9__Impl rule__Model__Group__10 )
            // InternalQueryDsl.g:4230:2: rule__Model__Group__9__Impl rule__Model__Group__10
            {
            pushFollow(FOLLOW_12);
            rule__Model__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__9"


    // $ANTLR start "rule__Model__Group__9__Impl"
    // InternalQueryDsl.g:4237:1: rule__Model__Group__9__Impl : ( ( rule__Model__FieldAssignment_9 ) ) ;
    public final void rule__Model__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4241:1: ( ( ( rule__Model__FieldAssignment_9 ) ) )
            // InternalQueryDsl.g:4242:1: ( ( rule__Model__FieldAssignment_9 ) )
            {
            // InternalQueryDsl.g:4242:1: ( ( rule__Model__FieldAssignment_9 ) )
            // InternalQueryDsl.g:4243:2: ( rule__Model__FieldAssignment_9 )
            {
             before(grammarAccess.getModelAccess().getFieldAssignment_9()); 
            // InternalQueryDsl.g:4244:2: ( rule__Model__FieldAssignment_9 )
            // InternalQueryDsl.g:4244:3: rule__Model__FieldAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Model__FieldAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getFieldAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__9__Impl"


    // $ANTLR start "rule__Model__Group__10"
    // InternalQueryDsl.g:4252:1: rule__Model__Group__10 : rule__Model__Group__10__Impl rule__Model__Group__11 ;
    public final void rule__Model__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4256:1: ( rule__Model__Group__10__Impl rule__Model__Group__11 )
            // InternalQueryDsl.g:4257:2: rule__Model__Group__10__Impl rule__Model__Group__11
            {
            pushFollow(FOLLOW_12);
            rule__Model__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__10"


    // $ANTLR start "rule__Model__Group__10__Impl"
    // InternalQueryDsl.g:4264:1: rule__Model__Group__10__Impl : ( ( rule__Model__Group_10__0 )* ) ;
    public final void rule__Model__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4268:1: ( ( ( rule__Model__Group_10__0 )* ) )
            // InternalQueryDsl.g:4269:1: ( ( rule__Model__Group_10__0 )* )
            {
            // InternalQueryDsl.g:4269:1: ( ( rule__Model__Group_10__0 )* )
            // InternalQueryDsl.g:4270:2: ( rule__Model__Group_10__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_10()); 
            // InternalQueryDsl.g:4271:2: ( rule__Model__Group_10__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==94) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalQueryDsl.g:4271:3: rule__Model__Group_10__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Model__Group_10__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__10__Impl"


    // $ANTLR start "rule__Model__Group__11"
    // InternalQueryDsl.g:4279:1: rule__Model__Group__11 : rule__Model__Group__11__Impl ;
    public final void rule__Model__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4283:1: ( rule__Model__Group__11__Impl )
            // InternalQueryDsl.g:4284:2: rule__Model__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__11"


    // $ANTLR start "rule__Model__Group__11__Impl"
    // InternalQueryDsl.g:4290:1: rule__Model__Group__11__Impl : ( ']' ) ;
    public final void rule__Model__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4294:1: ( ( ']' ) )
            // InternalQueryDsl.g:4295:1: ( ']' )
            {
            // InternalQueryDsl.g:4295:1: ( ']' )
            // InternalQueryDsl.g:4296:2: ']'
            {
             before(grammarAccess.getModelAccess().getRightSquareBracketKeyword_11()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getRightSquareBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__11__Impl"


    // $ANTLR start "rule__Model__Group_4__0"
    // InternalQueryDsl.g:4306:1: rule__Model__Group_4__0 : rule__Model__Group_4__0__Impl rule__Model__Group_4__1 ;
    public final void rule__Model__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4310:1: ( rule__Model__Group_4__0__Impl rule__Model__Group_4__1 )
            // InternalQueryDsl.g:4311:2: rule__Model__Group_4__0__Impl rule__Model__Group_4__1
            {
            pushFollow(FOLLOW_20);
            rule__Model__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__0"


    // $ANTLR start "rule__Model__Group_4__0__Impl"
    // InternalQueryDsl.g:4318:1: rule__Model__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Model__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4322:1: ( ( ',' ) )
            // InternalQueryDsl.g:4323:1: ( ',' )
            {
            // InternalQueryDsl.g:4323:1: ( ',' )
            // InternalQueryDsl.g:4324:2: ','
            {
             before(grammarAccess.getModelAccess().getCommaKeyword_4_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__0__Impl"


    // $ANTLR start "rule__Model__Group_4__1"
    // InternalQueryDsl.g:4333:1: rule__Model__Group_4__1 : rule__Model__Group_4__1__Impl ;
    public final void rule__Model__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4337:1: ( rule__Model__Group_4__1__Impl )
            // InternalQueryDsl.g:4338:2: rule__Model__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__1"


    // $ANTLR start "rule__Model__Group_4__1__Impl"
    // InternalQueryDsl.g:4344:1: rule__Model__Group_4__1__Impl : ( ( rule__Model__ModelVarsAssignment_4_1 ) ) ;
    public final void rule__Model__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4348:1: ( ( ( rule__Model__ModelVarsAssignment_4_1 ) ) )
            // InternalQueryDsl.g:4349:1: ( ( rule__Model__ModelVarsAssignment_4_1 ) )
            {
            // InternalQueryDsl.g:4349:1: ( ( rule__Model__ModelVarsAssignment_4_1 ) )
            // InternalQueryDsl.g:4350:2: ( rule__Model__ModelVarsAssignment_4_1 )
            {
             before(grammarAccess.getModelAccess().getModelVarsAssignment_4_1()); 
            // InternalQueryDsl.g:4351:2: ( rule__Model__ModelVarsAssignment_4_1 )
            // InternalQueryDsl.g:4351:3: rule__Model__ModelVarsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__ModelVarsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getModelVarsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__1__Impl"


    // $ANTLR start "rule__Model__Group_6__0"
    // InternalQueryDsl.g:4360:1: rule__Model__Group_6__0 : rule__Model__Group_6__0__Impl rule__Model__Group_6__1 ;
    public final void rule__Model__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4364:1: ( rule__Model__Group_6__0__Impl rule__Model__Group_6__1 )
            // InternalQueryDsl.g:4365:2: rule__Model__Group_6__0__Impl rule__Model__Group_6__1
            {
            pushFollow(FOLLOW_27);
            rule__Model__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_6__0"


    // $ANTLR start "rule__Model__Group_6__0__Impl"
    // InternalQueryDsl.g:4372:1: rule__Model__Group_6__0__Impl : ( '=>' ) ;
    public final void rule__Model__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4376:1: ( ( '=>' ) )
            // InternalQueryDsl.g:4377:1: ( '=>' )
            {
            // InternalQueryDsl.g:4377:1: ( '=>' )
            // InternalQueryDsl.g:4378:2: '=>'
            {
             before(grammarAccess.getModelAccess().getEqualsSignGreaterThanSignKeyword_6_0()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getEqualsSignGreaterThanSignKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_6__0__Impl"


    // $ANTLR start "rule__Model__Group_6__1"
    // InternalQueryDsl.g:4387:1: rule__Model__Group_6__1 : rule__Model__Group_6__1__Impl ;
    public final void rule__Model__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4391:1: ( rule__Model__Group_6__1__Impl )
            // InternalQueryDsl.g:4392:2: rule__Model__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_6__1"


    // $ANTLR start "rule__Model__Group_6__1__Impl"
    // InternalQueryDsl.g:4398:1: rule__Model__Group_6__1__Impl : ( ( rule__Model__Alternatives_6_1 ) ) ;
    public final void rule__Model__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4402:1: ( ( ( rule__Model__Alternatives_6_1 ) ) )
            // InternalQueryDsl.g:4403:1: ( ( rule__Model__Alternatives_6_1 ) )
            {
            // InternalQueryDsl.g:4403:1: ( ( rule__Model__Alternatives_6_1 ) )
            // InternalQueryDsl.g:4404:2: ( rule__Model__Alternatives_6_1 )
            {
             before(grammarAccess.getModelAccess().getAlternatives_6_1()); 
            // InternalQueryDsl.g:4405:2: ( rule__Model__Alternatives_6_1 )
            // InternalQueryDsl.g:4405:3: rule__Model__Alternatives_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__Alternatives_6_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_6__1__Impl"


    // $ANTLR start "rule__Model__Group_10__0"
    // InternalQueryDsl.g:4414:1: rule__Model__Group_10__0 : rule__Model__Group_10__0__Impl rule__Model__Group_10__1 ;
    public final void rule__Model__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4418:1: ( rule__Model__Group_10__0__Impl rule__Model__Group_10__1 )
            // InternalQueryDsl.g:4419:2: rule__Model__Group_10__0__Impl rule__Model__Group_10__1
            {
            pushFollow(FOLLOW_26);
            rule__Model__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__0"


    // $ANTLR start "rule__Model__Group_10__0__Impl"
    // InternalQueryDsl.g:4426:1: rule__Model__Group_10__0__Impl : ( ',' ) ;
    public final void rule__Model__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4430:1: ( ( ',' ) )
            // InternalQueryDsl.g:4431:1: ( ',' )
            {
            // InternalQueryDsl.g:4431:1: ( ',' )
            // InternalQueryDsl.g:4432:2: ','
            {
             before(grammarAccess.getModelAccess().getCommaKeyword_10_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getCommaKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__0__Impl"


    // $ANTLR start "rule__Model__Group_10__1"
    // InternalQueryDsl.g:4441:1: rule__Model__Group_10__1 : rule__Model__Group_10__1__Impl ;
    public final void rule__Model__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4445:1: ( rule__Model__Group_10__1__Impl )
            // InternalQueryDsl.g:4446:2: rule__Model__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__1"


    // $ANTLR start "rule__Model__Group_10__1__Impl"
    // InternalQueryDsl.g:4452:1: rule__Model__Group_10__1__Impl : ( ( rule__Model__FieldsAssignment_10_1 ) ) ;
    public final void rule__Model__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4456:1: ( ( ( rule__Model__FieldsAssignment_10_1 ) ) )
            // InternalQueryDsl.g:4457:1: ( ( rule__Model__FieldsAssignment_10_1 ) )
            {
            // InternalQueryDsl.g:4457:1: ( ( rule__Model__FieldsAssignment_10_1 ) )
            // InternalQueryDsl.g:4458:2: ( rule__Model__FieldsAssignment_10_1 )
            {
             before(grammarAccess.getModelAccess().getFieldsAssignment_10_1()); 
            // InternalQueryDsl.g:4459:2: ( rule__Model__FieldsAssignment_10_1 )
            // InternalQueryDsl.g:4459:3: rule__Model__FieldsAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__FieldsAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getFieldsAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__1__Impl"


    // $ANTLR start "rule__Dsl__Group__0"
    // InternalQueryDsl.g:4468:1: rule__Dsl__Group__0 : rule__Dsl__Group__0__Impl rule__Dsl__Group__1 ;
    public final void rule__Dsl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4472:1: ( rule__Dsl__Group__0__Impl rule__Dsl__Group__1 )
            // InternalQueryDsl.g:4473:2: rule__Dsl__Group__0__Impl rule__Dsl__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__Dsl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__0"


    // $ANTLR start "rule__Dsl__Group__0__Impl"
    // InternalQueryDsl.g:4480:1: rule__Dsl__Group__0__Impl : ( 'Query' ) ;
    public final void rule__Dsl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4484:1: ( ( 'Query' ) )
            // InternalQueryDsl.g:4485:1: ( 'Query' )
            {
            // InternalQueryDsl.g:4485:1: ( 'Query' )
            // InternalQueryDsl.g:4486:2: 'Query'
            {
             before(grammarAccess.getDslAccess().getQueryKeyword_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getQueryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__0__Impl"


    // $ANTLR start "rule__Dsl__Group__1"
    // InternalQueryDsl.g:4495:1: rule__Dsl__Group__1 : rule__Dsl__Group__1__Impl rule__Dsl__Group__2 ;
    public final void rule__Dsl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4499:1: ( rule__Dsl__Group__1__Impl rule__Dsl__Group__2 )
            // InternalQueryDsl.g:4500:2: rule__Dsl__Group__1__Impl rule__Dsl__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Dsl__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__1"


    // $ANTLR start "rule__Dsl__Group__1__Impl"
    // InternalQueryDsl.g:4507:1: rule__Dsl__Group__1__Impl : ( 'Dsl' ) ;
    public final void rule__Dsl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4511:1: ( ( 'Dsl' ) )
            // InternalQueryDsl.g:4512:1: ( 'Dsl' )
            {
            // InternalQueryDsl.g:4512:1: ( 'Dsl' )
            // InternalQueryDsl.g:4513:2: 'Dsl'
            {
             before(grammarAccess.getDslAccess().getDslKeyword_1()); 
            match(input,100,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getDslKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__1__Impl"


    // $ANTLR start "rule__Dsl__Group__2"
    // InternalQueryDsl.g:4522:1: rule__Dsl__Group__2 : rule__Dsl__Group__2__Impl rule__Dsl__Group__3 ;
    public final void rule__Dsl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4526:1: ( rule__Dsl__Group__2__Impl rule__Dsl__Group__3 )
            // InternalQueryDsl.g:4527:2: rule__Dsl__Group__2__Impl rule__Dsl__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Dsl__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__2"


    // $ANTLR start "rule__Dsl__Group__2__Impl"
    // InternalQueryDsl.g:4534:1: rule__Dsl__Group__2__Impl : ( '(' ) ;
    public final void rule__Dsl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4538:1: ( ( '(' ) )
            // InternalQueryDsl.g:4539:1: ( '(' )
            {
            // InternalQueryDsl.g:4539:1: ( '(' )
            // InternalQueryDsl.g:4540:2: '('
            {
             before(grammarAccess.getDslAccess().getLeftParenthesisKeyword_2()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__2__Impl"


    // $ANTLR start "rule__Dsl__Group__3"
    // InternalQueryDsl.g:4549:1: rule__Dsl__Group__3 : rule__Dsl__Group__3__Impl rule__Dsl__Group__4 ;
    public final void rule__Dsl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4553:1: ( rule__Dsl__Group__3__Impl rule__Dsl__Group__4 )
            // InternalQueryDsl.g:4554:2: rule__Dsl__Group__3__Impl rule__Dsl__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Dsl__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__3"


    // $ANTLR start "rule__Dsl__Group__3__Impl"
    // InternalQueryDsl.g:4561:1: rule__Dsl__Group__3__Impl : ( ( rule__Dsl__DslVarAssignment_3 ) ) ;
    public final void rule__Dsl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4565:1: ( ( ( rule__Dsl__DslVarAssignment_3 ) ) )
            // InternalQueryDsl.g:4566:1: ( ( rule__Dsl__DslVarAssignment_3 ) )
            {
            // InternalQueryDsl.g:4566:1: ( ( rule__Dsl__DslVarAssignment_3 ) )
            // InternalQueryDsl.g:4567:2: ( rule__Dsl__DslVarAssignment_3 )
            {
             before(grammarAccess.getDslAccess().getDslVarAssignment_3()); 
            // InternalQueryDsl.g:4568:2: ( rule__Dsl__DslVarAssignment_3 )
            // InternalQueryDsl.g:4568:3: rule__Dsl__DslVarAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__DslVarAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDslAccess().getDslVarAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__3__Impl"


    // $ANTLR start "rule__Dsl__Group__4"
    // InternalQueryDsl.g:4576:1: rule__Dsl__Group__4 : rule__Dsl__Group__4__Impl rule__Dsl__Group__5 ;
    public final void rule__Dsl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4580:1: ( rule__Dsl__Group__4__Impl rule__Dsl__Group__5 )
            // InternalQueryDsl.g:4581:2: rule__Dsl__Group__4__Impl rule__Dsl__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Dsl__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__4"


    // $ANTLR start "rule__Dsl__Group__4__Impl"
    // InternalQueryDsl.g:4588:1: rule__Dsl__Group__4__Impl : ( ( rule__Dsl__Group_4__0 )* ) ;
    public final void rule__Dsl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4592:1: ( ( ( rule__Dsl__Group_4__0 )* ) )
            // InternalQueryDsl.g:4593:1: ( ( rule__Dsl__Group_4__0 )* )
            {
            // InternalQueryDsl.g:4593:1: ( ( rule__Dsl__Group_4__0 )* )
            // InternalQueryDsl.g:4594:2: ( rule__Dsl__Group_4__0 )*
            {
             before(grammarAccess.getDslAccess().getGroup_4()); 
            // InternalQueryDsl.g:4595:2: ( rule__Dsl__Group_4__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==94) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalQueryDsl.g:4595:3: rule__Dsl__Group_4__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Dsl__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getDslAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__4__Impl"


    // $ANTLR start "rule__Dsl__Group__5"
    // InternalQueryDsl.g:4603:1: rule__Dsl__Group__5 : rule__Dsl__Group__5__Impl rule__Dsl__Group__6 ;
    public final void rule__Dsl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4607:1: ( rule__Dsl__Group__5__Impl rule__Dsl__Group__6 )
            // InternalQueryDsl.g:4608:2: rule__Dsl__Group__5__Impl rule__Dsl__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__Dsl__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__5"


    // $ANTLR start "rule__Dsl__Group__5__Impl"
    // InternalQueryDsl.g:4615:1: rule__Dsl__Group__5__Impl : ( ')' ) ;
    public final void rule__Dsl__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4619:1: ( ( ')' ) )
            // InternalQueryDsl.g:4620:1: ( ')' )
            {
            // InternalQueryDsl.g:4620:1: ( ')' )
            // InternalQueryDsl.g:4621:2: ')'
            {
             before(grammarAccess.getDslAccess().getRightParenthesisKeyword_5()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__5__Impl"


    // $ANTLR start "rule__Dsl__Group__6"
    // InternalQueryDsl.g:4630:1: rule__Dsl__Group__6 : rule__Dsl__Group__6__Impl rule__Dsl__Group__7 ;
    public final void rule__Dsl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4634:1: ( rule__Dsl__Group__6__Impl rule__Dsl__Group__7 )
            // InternalQueryDsl.g:4635:2: rule__Dsl__Group__6__Impl rule__Dsl__Group__7
            {
            pushFollow(FOLLOW_21);
            rule__Dsl__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__6"


    // $ANTLR start "rule__Dsl__Group__6__Impl"
    // InternalQueryDsl.g:4642:1: rule__Dsl__Group__6__Impl : ( ( rule__Dsl__Group_6__0 )* ) ;
    public final void rule__Dsl__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4646:1: ( ( ( rule__Dsl__Group_6__0 )* ) )
            // InternalQueryDsl.g:4647:1: ( ( rule__Dsl__Group_6__0 )* )
            {
            // InternalQueryDsl.g:4647:1: ( ( rule__Dsl__Group_6__0 )* )
            // InternalQueryDsl.g:4648:2: ( rule__Dsl__Group_6__0 )*
            {
             before(grammarAccess.getDslAccess().getGroup_6()); 
            // InternalQueryDsl.g:4649:2: ( rule__Dsl__Group_6__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==98) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalQueryDsl.g:4649:3: rule__Dsl__Group_6__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Dsl__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getDslAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__6__Impl"


    // $ANTLR start "rule__Dsl__Group__7"
    // InternalQueryDsl.g:4657:1: rule__Dsl__Group__7 : rule__Dsl__Group__7__Impl rule__Dsl__Group__8 ;
    public final void rule__Dsl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4661:1: ( rule__Dsl__Group__7__Impl rule__Dsl__Group__8 )
            // InternalQueryDsl.g:4662:2: rule__Dsl__Group__7__Impl rule__Dsl__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__Dsl__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__7"


    // $ANTLR start "rule__Dsl__Group__7__Impl"
    // InternalQueryDsl.g:4669:1: rule__Dsl__Group__7__Impl : ( 'return' ) ;
    public final void rule__Dsl__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4673:1: ( ( 'return' ) )
            // InternalQueryDsl.g:4674:1: ( 'return' )
            {
            // InternalQueryDsl.g:4674:1: ( 'return' )
            // InternalQueryDsl.g:4675:2: 'return'
            {
             before(grammarAccess.getDslAccess().getReturnKeyword_7()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getReturnKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__7__Impl"


    // $ANTLR start "rule__Dsl__Group__8"
    // InternalQueryDsl.g:4684:1: rule__Dsl__Group__8 : rule__Dsl__Group__8__Impl rule__Dsl__Group__9 ;
    public final void rule__Dsl__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4688:1: ( rule__Dsl__Group__8__Impl rule__Dsl__Group__9 )
            // InternalQueryDsl.g:4689:2: rule__Dsl__Group__8__Impl rule__Dsl__Group__9
            {
            pushFollow(FOLLOW_29);
            rule__Dsl__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__8"


    // $ANTLR start "rule__Dsl__Group__8__Impl"
    // InternalQueryDsl.g:4696:1: rule__Dsl__Group__8__Impl : ( '[' ) ;
    public final void rule__Dsl__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4700:1: ( ( '[' ) )
            // InternalQueryDsl.g:4701:1: ( '[' )
            {
            // InternalQueryDsl.g:4701:1: ( '[' )
            // InternalQueryDsl.g:4702:2: '['
            {
             before(grammarAccess.getDslAccess().getLeftSquareBracketKeyword_8()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getLeftSquareBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__8__Impl"


    // $ANTLR start "rule__Dsl__Group__9"
    // InternalQueryDsl.g:4711:1: rule__Dsl__Group__9 : rule__Dsl__Group__9__Impl rule__Dsl__Group__10 ;
    public final void rule__Dsl__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4715:1: ( rule__Dsl__Group__9__Impl rule__Dsl__Group__10 )
            // InternalQueryDsl.g:4716:2: rule__Dsl__Group__9__Impl rule__Dsl__Group__10
            {
            pushFollow(FOLLOW_12);
            rule__Dsl__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__9"


    // $ANTLR start "rule__Dsl__Group__9__Impl"
    // InternalQueryDsl.g:4723:1: rule__Dsl__Group__9__Impl : ( ( rule__Dsl__FieldAssignment_9 ) ) ;
    public final void rule__Dsl__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4727:1: ( ( ( rule__Dsl__FieldAssignment_9 ) ) )
            // InternalQueryDsl.g:4728:1: ( ( rule__Dsl__FieldAssignment_9 ) )
            {
            // InternalQueryDsl.g:4728:1: ( ( rule__Dsl__FieldAssignment_9 ) )
            // InternalQueryDsl.g:4729:2: ( rule__Dsl__FieldAssignment_9 )
            {
             before(grammarAccess.getDslAccess().getFieldAssignment_9()); 
            // InternalQueryDsl.g:4730:2: ( rule__Dsl__FieldAssignment_9 )
            // InternalQueryDsl.g:4730:3: rule__Dsl__FieldAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__FieldAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getDslAccess().getFieldAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__9__Impl"


    // $ANTLR start "rule__Dsl__Group__10"
    // InternalQueryDsl.g:4738:1: rule__Dsl__Group__10 : rule__Dsl__Group__10__Impl rule__Dsl__Group__11 ;
    public final void rule__Dsl__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4742:1: ( rule__Dsl__Group__10__Impl rule__Dsl__Group__11 )
            // InternalQueryDsl.g:4743:2: rule__Dsl__Group__10__Impl rule__Dsl__Group__11
            {
            pushFollow(FOLLOW_12);
            rule__Dsl__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__10"


    // $ANTLR start "rule__Dsl__Group__10__Impl"
    // InternalQueryDsl.g:4750:1: rule__Dsl__Group__10__Impl : ( ( rule__Dsl__Group_10__0 )* ) ;
    public final void rule__Dsl__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4754:1: ( ( ( rule__Dsl__Group_10__0 )* ) )
            // InternalQueryDsl.g:4755:1: ( ( rule__Dsl__Group_10__0 )* )
            {
            // InternalQueryDsl.g:4755:1: ( ( rule__Dsl__Group_10__0 )* )
            // InternalQueryDsl.g:4756:2: ( rule__Dsl__Group_10__0 )*
            {
             before(grammarAccess.getDslAccess().getGroup_10()); 
            // InternalQueryDsl.g:4757:2: ( rule__Dsl__Group_10__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==94) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalQueryDsl.g:4757:3: rule__Dsl__Group_10__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Dsl__Group_10__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getDslAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__10__Impl"


    // $ANTLR start "rule__Dsl__Group__11"
    // InternalQueryDsl.g:4765:1: rule__Dsl__Group__11 : rule__Dsl__Group__11__Impl ;
    public final void rule__Dsl__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4769:1: ( rule__Dsl__Group__11__Impl )
            // InternalQueryDsl.g:4770:2: rule__Dsl__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__11"


    // $ANTLR start "rule__Dsl__Group__11__Impl"
    // InternalQueryDsl.g:4776:1: rule__Dsl__Group__11__Impl : ( ']' ) ;
    public final void rule__Dsl__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4780:1: ( ( ']' ) )
            // InternalQueryDsl.g:4781:1: ( ']' )
            {
            // InternalQueryDsl.g:4781:1: ( ']' )
            // InternalQueryDsl.g:4782:2: ']'
            {
             before(grammarAccess.getDslAccess().getRightSquareBracketKeyword_11()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getRightSquareBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group__11__Impl"


    // $ANTLR start "rule__Dsl__Group_4__0"
    // InternalQueryDsl.g:4792:1: rule__Dsl__Group_4__0 : rule__Dsl__Group_4__0__Impl rule__Dsl__Group_4__1 ;
    public final void rule__Dsl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4796:1: ( rule__Dsl__Group_4__0__Impl rule__Dsl__Group_4__1 )
            // InternalQueryDsl.g:4797:2: rule__Dsl__Group_4__0__Impl rule__Dsl__Group_4__1
            {
            pushFollow(FOLLOW_20);
            rule__Dsl__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_4__0"


    // $ANTLR start "rule__Dsl__Group_4__0__Impl"
    // InternalQueryDsl.g:4804:1: rule__Dsl__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Dsl__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4808:1: ( ( ',' ) )
            // InternalQueryDsl.g:4809:1: ( ',' )
            {
            // InternalQueryDsl.g:4809:1: ( ',' )
            // InternalQueryDsl.g:4810:2: ','
            {
             before(grammarAccess.getDslAccess().getCommaKeyword_4_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_4__0__Impl"


    // $ANTLR start "rule__Dsl__Group_4__1"
    // InternalQueryDsl.g:4819:1: rule__Dsl__Group_4__1 : rule__Dsl__Group_4__1__Impl ;
    public final void rule__Dsl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4823:1: ( rule__Dsl__Group_4__1__Impl )
            // InternalQueryDsl.g:4824:2: rule__Dsl__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_4__1"


    // $ANTLR start "rule__Dsl__Group_4__1__Impl"
    // InternalQueryDsl.g:4830:1: rule__Dsl__Group_4__1__Impl : ( ( rule__Dsl__DslVarsAssignment_4_1 ) ) ;
    public final void rule__Dsl__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4834:1: ( ( ( rule__Dsl__DslVarsAssignment_4_1 ) ) )
            // InternalQueryDsl.g:4835:1: ( ( rule__Dsl__DslVarsAssignment_4_1 ) )
            {
            // InternalQueryDsl.g:4835:1: ( ( rule__Dsl__DslVarsAssignment_4_1 ) )
            // InternalQueryDsl.g:4836:2: ( rule__Dsl__DslVarsAssignment_4_1 )
            {
             before(grammarAccess.getDslAccess().getDslVarsAssignment_4_1()); 
            // InternalQueryDsl.g:4837:2: ( rule__Dsl__DslVarsAssignment_4_1 )
            // InternalQueryDsl.g:4837:3: rule__Dsl__DslVarsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__DslVarsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDslAccess().getDslVarsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_4__1__Impl"


    // $ANTLR start "rule__Dsl__Group_6__0"
    // InternalQueryDsl.g:4846:1: rule__Dsl__Group_6__0 : rule__Dsl__Group_6__0__Impl rule__Dsl__Group_6__1 ;
    public final void rule__Dsl__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4850:1: ( rule__Dsl__Group_6__0__Impl rule__Dsl__Group_6__1 )
            // InternalQueryDsl.g:4851:2: rule__Dsl__Group_6__0__Impl rule__Dsl__Group_6__1
            {
            pushFollow(FOLLOW_30);
            rule__Dsl__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_6__0"


    // $ANTLR start "rule__Dsl__Group_6__0__Impl"
    // InternalQueryDsl.g:4858:1: rule__Dsl__Group_6__0__Impl : ( '=>' ) ;
    public final void rule__Dsl__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4862:1: ( ( '=>' ) )
            // InternalQueryDsl.g:4863:1: ( '=>' )
            {
            // InternalQueryDsl.g:4863:1: ( '=>' )
            // InternalQueryDsl.g:4864:2: '=>'
            {
             before(grammarAccess.getDslAccess().getEqualsSignGreaterThanSignKeyword_6_0()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getEqualsSignGreaterThanSignKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_6__0__Impl"


    // $ANTLR start "rule__Dsl__Group_6__1"
    // InternalQueryDsl.g:4873:1: rule__Dsl__Group_6__1 : rule__Dsl__Group_6__1__Impl ;
    public final void rule__Dsl__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4877:1: ( rule__Dsl__Group_6__1__Impl )
            // InternalQueryDsl.g:4878:2: rule__Dsl__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_6__1"


    // $ANTLR start "rule__Dsl__Group_6__1__Impl"
    // InternalQueryDsl.g:4884:1: rule__Dsl__Group_6__1__Impl : ( ( rule__Dsl__Alternatives_6_1 ) ) ;
    public final void rule__Dsl__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4888:1: ( ( ( rule__Dsl__Alternatives_6_1 ) ) )
            // InternalQueryDsl.g:4889:1: ( ( rule__Dsl__Alternatives_6_1 ) )
            {
            // InternalQueryDsl.g:4889:1: ( ( rule__Dsl__Alternatives_6_1 ) )
            // InternalQueryDsl.g:4890:2: ( rule__Dsl__Alternatives_6_1 )
            {
             before(grammarAccess.getDslAccess().getAlternatives_6_1()); 
            // InternalQueryDsl.g:4891:2: ( rule__Dsl__Alternatives_6_1 )
            // InternalQueryDsl.g:4891:3: rule__Dsl__Alternatives_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__Alternatives_6_1();

            state._fsp--;


            }

             after(grammarAccess.getDslAccess().getAlternatives_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_6__1__Impl"


    // $ANTLR start "rule__Dsl__Group_10__0"
    // InternalQueryDsl.g:4900:1: rule__Dsl__Group_10__0 : rule__Dsl__Group_10__0__Impl rule__Dsl__Group_10__1 ;
    public final void rule__Dsl__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4904:1: ( rule__Dsl__Group_10__0__Impl rule__Dsl__Group_10__1 )
            // InternalQueryDsl.g:4905:2: rule__Dsl__Group_10__0__Impl rule__Dsl__Group_10__1
            {
            pushFollow(FOLLOW_29);
            rule__Dsl__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dsl__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_10__0"


    // $ANTLR start "rule__Dsl__Group_10__0__Impl"
    // InternalQueryDsl.g:4912:1: rule__Dsl__Group_10__0__Impl : ( ',' ) ;
    public final void rule__Dsl__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4916:1: ( ( ',' ) )
            // InternalQueryDsl.g:4917:1: ( ',' )
            {
            // InternalQueryDsl.g:4917:1: ( ',' )
            // InternalQueryDsl.g:4918:2: ','
            {
             before(grammarAccess.getDslAccess().getCommaKeyword_10_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getDslAccess().getCommaKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_10__0__Impl"


    // $ANTLR start "rule__Dsl__Group_10__1"
    // InternalQueryDsl.g:4927:1: rule__Dsl__Group_10__1 : rule__Dsl__Group_10__1__Impl ;
    public final void rule__Dsl__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4931:1: ( rule__Dsl__Group_10__1__Impl )
            // InternalQueryDsl.g:4932:2: rule__Dsl__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_10__1"


    // $ANTLR start "rule__Dsl__Group_10__1__Impl"
    // InternalQueryDsl.g:4938:1: rule__Dsl__Group_10__1__Impl : ( ( rule__Dsl__FieldsAssignment_10_1 ) ) ;
    public final void rule__Dsl__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4942:1: ( ( ( rule__Dsl__FieldsAssignment_10_1 ) ) )
            // InternalQueryDsl.g:4943:1: ( ( rule__Dsl__FieldsAssignment_10_1 ) )
            {
            // InternalQueryDsl.g:4943:1: ( ( rule__Dsl__FieldsAssignment_10_1 ) )
            // InternalQueryDsl.g:4944:2: ( rule__Dsl__FieldsAssignment_10_1 )
            {
             before(grammarAccess.getDslAccess().getFieldsAssignment_10_1()); 
            // InternalQueryDsl.g:4945:2: ( rule__Dsl__FieldsAssignment_10_1 )
            // InternalQueryDsl.g:4945:3: rule__Dsl__FieldsAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Dsl__FieldsAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getDslAccess().getFieldsAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__Group_10__1__Impl"


    // $ANTLR start "rule__MicroSyntax__Group__0"
    // InternalQueryDsl.g:4954:1: rule__MicroSyntax__Group__0 : rule__MicroSyntax__Group__0__Impl rule__MicroSyntax__Group__1 ;
    public final void rule__MicroSyntax__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4958:1: ( rule__MicroSyntax__Group__0__Impl rule__MicroSyntax__Group__1 )
            // InternalQueryDsl.g:4959:2: rule__MicroSyntax__Group__0__Impl rule__MicroSyntax__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__MicroSyntax__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MicroSyntax__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MicroSyntax__Group__0"


    // $ANTLR start "rule__MicroSyntax__Group__0__Impl"
    // InternalQueryDsl.g:4966:1: rule__MicroSyntax__Group__0__Impl : ( 'microSyntax' ) ;
    public final void rule__MicroSyntax__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4970:1: ( ( 'microSyntax' ) )
            // InternalQueryDsl.g:4971:1: ( 'microSyntax' )
            {
            // InternalQueryDsl.g:4971:1: ( 'microSyntax' )
            // InternalQueryDsl.g:4972:2: 'microSyntax'
            {
             before(grammarAccess.getMicroSyntaxAccess().getMicroSyntaxKeyword_0()); 
            match(input,101,FOLLOW_2); 
             after(grammarAccess.getMicroSyntaxAccess().getMicroSyntaxKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MicroSyntax__Group__0__Impl"


    // $ANTLR start "rule__MicroSyntax__Group__1"
    // InternalQueryDsl.g:4981:1: rule__MicroSyntax__Group__1 : rule__MicroSyntax__Group__1__Impl rule__MicroSyntax__Group__2 ;
    public final void rule__MicroSyntax__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4985:1: ( rule__MicroSyntax__Group__1__Impl rule__MicroSyntax__Group__2 )
            // InternalQueryDsl.g:4986:2: rule__MicroSyntax__Group__1__Impl rule__MicroSyntax__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__MicroSyntax__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MicroSyntax__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MicroSyntax__Group__1"


    // $ANTLR start "rule__MicroSyntax__Group__1__Impl"
    // InternalQueryDsl.g:4993:1: rule__MicroSyntax__Group__1__Impl : ( '(' ) ;
    public final void rule__MicroSyntax__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:4997:1: ( ( '(' ) )
            // InternalQueryDsl.g:4998:1: ( '(' )
            {
            // InternalQueryDsl.g:4998:1: ( '(' )
            // InternalQueryDsl.g:4999:2: '('
            {
             before(grammarAccess.getMicroSyntaxAccess().getLeftParenthesisKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getMicroSyntaxAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MicroSyntax__Group__1__Impl"


    // $ANTLR start "rule__MicroSyntax__Group__2"
    // InternalQueryDsl.g:5008:1: rule__MicroSyntax__Group__2 : rule__MicroSyntax__Group__2__Impl rule__MicroSyntax__Group__3 ;
    public final void rule__MicroSyntax__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5012:1: ( rule__MicroSyntax__Group__2__Impl rule__MicroSyntax__Group__3 )
            // InternalQueryDsl.g:5013:2: rule__MicroSyntax__Group__2__Impl rule__MicroSyntax__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__MicroSyntax__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MicroSyntax__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MicroSyntax__Group__2"


    // $ANTLR start "rule__MicroSyntax__Group__2__Impl"
    // InternalQueryDsl.g:5020:1: rule__MicroSyntax__Group__2__Impl : ( ( rule__MicroSyntax__ExpAssignment_2 ) ) ;
    public final void rule__MicroSyntax__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5024:1: ( ( ( rule__MicroSyntax__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:5025:1: ( ( rule__MicroSyntax__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:5025:1: ( ( rule__MicroSyntax__ExpAssignment_2 ) )
            // InternalQueryDsl.g:5026:2: ( rule__MicroSyntax__ExpAssignment_2 )
            {
             before(grammarAccess.getMicroSyntaxAccess().getExpAssignment_2()); 
            // InternalQueryDsl.g:5027:2: ( rule__MicroSyntax__ExpAssignment_2 )
            // InternalQueryDsl.g:5027:3: rule__MicroSyntax__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__MicroSyntax__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMicroSyntaxAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MicroSyntax__Group__2__Impl"


    // $ANTLR start "rule__MicroSyntax__Group__3"
    // InternalQueryDsl.g:5035:1: rule__MicroSyntax__Group__3 : rule__MicroSyntax__Group__3__Impl ;
    public final void rule__MicroSyntax__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5039:1: ( rule__MicroSyntax__Group__3__Impl )
            // InternalQueryDsl.g:5040:2: rule__MicroSyntax__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MicroSyntax__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MicroSyntax__Group__3"


    // $ANTLR start "rule__MicroSyntax__Group__3__Impl"
    // InternalQueryDsl.g:5046:1: rule__MicroSyntax__Group__3__Impl : ( ')' ) ;
    public final void rule__MicroSyntax__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5050:1: ( ( ')' ) )
            // InternalQueryDsl.g:5051:1: ( ')' )
            {
            // InternalQueryDsl.g:5051:1: ( ')' )
            // InternalQueryDsl.g:5052:2: ')'
            {
             before(grammarAccess.getMicroSyntaxAccess().getRightParenthesisKeyword_3()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getMicroSyntaxAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MicroSyntax__Group__3__Impl"


    // $ANTLR start "rule__ModelQuery__Group__0"
    // InternalQueryDsl.g:5062:1: rule__ModelQuery__Group__0 : rule__ModelQuery__Group__0__Impl rule__ModelQuery__Group__1 ;
    public final void rule__ModelQuery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5066:1: ( rule__ModelQuery__Group__0__Impl rule__ModelQuery__Group__1 )
            // InternalQueryDsl.g:5067:2: rule__ModelQuery__Group__0__Impl rule__ModelQuery__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ModelQuery__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelQuery__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__0"


    // $ANTLR start "rule__ModelQuery__Group__0__Impl"
    // InternalQueryDsl.g:5074:1: rule__ModelQuery__Group__0__Impl : ( 'modelQuery' ) ;
    public final void rule__ModelQuery__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5078:1: ( ( 'modelQuery' ) )
            // InternalQueryDsl.g:5079:1: ( 'modelQuery' )
            {
            // InternalQueryDsl.g:5079:1: ( 'modelQuery' )
            // InternalQueryDsl.g:5080:2: 'modelQuery'
            {
             before(grammarAccess.getModelQueryAccess().getModelQueryKeyword_0()); 
            match(input,102,FOLLOW_2); 
             after(grammarAccess.getModelQueryAccess().getModelQueryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__0__Impl"


    // $ANTLR start "rule__ModelQuery__Group__1"
    // InternalQueryDsl.g:5089:1: rule__ModelQuery__Group__1 : rule__ModelQuery__Group__1__Impl rule__ModelQuery__Group__2 ;
    public final void rule__ModelQuery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5093:1: ( rule__ModelQuery__Group__1__Impl rule__ModelQuery__Group__2 )
            // InternalQueryDsl.g:5094:2: rule__ModelQuery__Group__1__Impl rule__ModelQuery__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__ModelQuery__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelQuery__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__1"


    // $ANTLR start "rule__ModelQuery__Group__1__Impl"
    // InternalQueryDsl.g:5101:1: rule__ModelQuery__Group__1__Impl : ( '(' ) ;
    public final void rule__ModelQuery__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5105:1: ( ( '(' ) )
            // InternalQueryDsl.g:5106:1: ( '(' )
            {
            // InternalQueryDsl.g:5106:1: ( '(' )
            // InternalQueryDsl.g:5107:2: '('
            {
             before(grammarAccess.getModelQueryAccess().getLeftParenthesisKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getModelQueryAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__1__Impl"


    // $ANTLR start "rule__ModelQuery__Group__2"
    // InternalQueryDsl.g:5116:1: rule__ModelQuery__Group__2 : rule__ModelQuery__Group__2__Impl rule__ModelQuery__Group__3 ;
    public final void rule__ModelQuery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5120:1: ( rule__ModelQuery__Group__2__Impl rule__ModelQuery__Group__3 )
            // InternalQueryDsl.g:5121:2: rule__ModelQuery__Group__2__Impl rule__ModelQuery__Group__3
            {
            pushFollow(FOLLOW_34);
            rule__ModelQuery__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelQuery__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__2"


    // $ANTLR start "rule__ModelQuery__Group__2__Impl"
    // InternalQueryDsl.g:5128:1: rule__ModelQuery__Group__2__Impl : ( 'type' ) ;
    public final void rule__ModelQuery__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5132:1: ( ( 'type' ) )
            // InternalQueryDsl.g:5133:1: ( 'type' )
            {
            // InternalQueryDsl.g:5133:1: ( 'type' )
            // InternalQueryDsl.g:5134:2: 'type'
            {
             before(grammarAccess.getModelQueryAccess().getTypeKeyword_2()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getModelQueryAccess().getTypeKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__2__Impl"


    // $ANTLR start "rule__ModelQuery__Group__3"
    // InternalQueryDsl.g:5143:1: rule__ModelQuery__Group__3 : rule__ModelQuery__Group__3__Impl rule__ModelQuery__Group__4 ;
    public final void rule__ModelQuery__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5147:1: ( rule__ModelQuery__Group__3__Impl rule__ModelQuery__Group__4 )
            // InternalQueryDsl.g:5148:2: rule__ModelQuery__Group__3__Impl rule__ModelQuery__Group__4
            {
            pushFollow(FOLLOW_35);
            rule__ModelQuery__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelQuery__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__3"


    // $ANTLR start "rule__ModelQuery__Group__3__Impl"
    // InternalQueryDsl.g:5155:1: rule__ModelQuery__Group__3__Impl : ( ':' ) ;
    public final void rule__ModelQuery__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5159:1: ( ( ':' ) )
            // InternalQueryDsl.g:5160:1: ( ':' )
            {
            // InternalQueryDsl.g:5160:1: ( ':' )
            // InternalQueryDsl.g:5161:2: ':'
            {
             before(grammarAccess.getModelQueryAccess().getColonKeyword_3()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getModelQueryAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__3__Impl"


    // $ANTLR start "rule__ModelQuery__Group__4"
    // InternalQueryDsl.g:5170:1: rule__ModelQuery__Group__4 : rule__ModelQuery__Group__4__Impl rule__ModelQuery__Group__5 ;
    public final void rule__ModelQuery__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5174:1: ( rule__ModelQuery__Group__4__Impl rule__ModelQuery__Group__5 )
            // InternalQueryDsl.g:5175:2: rule__ModelQuery__Group__4__Impl rule__ModelQuery__Group__5
            {
            pushFollow(FOLLOW_36);
            rule__ModelQuery__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelQuery__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__4"


    // $ANTLR start "rule__ModelQuery__Group__4__Impl"
    // InternalQueryDsl.g:5182:1: rule__ModelQuery__Group__4__Impl : ( ruleQueryLang ) ;
    public final void rule__ModelQuery__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5186:1: ( ( ruleQueryLang ) )
            // InternalQueryDsl.g:5187:1: ( ruleQueryLang )
            {
            // InternalQueryDsl.g:5187:1: ( ruleQueryLang )
            // InternalQueryDsl.g:5188:2: ruleQueryLang
            {
             before(grammarAccess.getModelQueryAccess().getQueryLangParserRuleCall_4()); 
            pushFollow(FOLLOW_2);
            ruleQueryLang();

            state._fsp--;

             after(grammarAccess.getModelQueryAccess().getQueryLangParserRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__4__Impl"


    // $ANTLR start "rule__ModelQuery__Group__5"
    // InternalQueryDsl.g:5197:1: rule__ModelQuery__Group__5 : rule__ModelQuery__Group__5__Impl rule__ModelQuery__Group__6 ;
    public final void rule__ModelQuery__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5201:1: ( rule__ModelQuery__Group__5__Impl rule__ModelQuery__Group__6 )
            // InternalQueryDsl.g:5202:2: rule__ModelQuery__Group__5__Impl rule__ModelQuery__Group__6
            {
            pushFollow(FOLLOW_31);
            rule__ModelQuery__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelQuery__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__5"


    // $ANTLR start "rule__ModelQuery__Group__5__Impl"
    // InternalQueryDsl.g:5209:1: rule__ModelQuery__Group__5__Impl : ( ',' ) ;
    public final void rule__ModelQuery__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5213:1: ( ( ',' ) )
            // InternalQueryDsl.g:5214:1: ( ',' )
            {
            // InternalQueryDsl.g:5214:1: ( ',' )
            // InternalQueryDsl.g:5215:2: ','
            {
             before(grammarAccess.getModelQueryAccess().getCommaKeyword_5()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getModelQueryAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__5__Impl"


    // $ANTLR start "rule__ModelQuery__Group__6"
    // InternalQueryDsl.g:5224:1: rule__ModelQuery__Group__6 : rule__ModelQuery__Group__6__Impl rule__ModelQuery__Group__7 ;
    public final void rule__ModelQuery__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5228:1: ( rule__ModelQuery__Group__6__Impl rule__ModelQuery__Group__7 )
            // InternalQueryDsl.g:5229:2: rule__ModelQuery__Group__6__Impl rule__ModelQuery__Group__7
            {
            pushFollow(FOLLOW_32);
            rule__ModelQuery__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelQuery__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__6"


    // $ANTLR start "rule__ModelQuery__Group__6__Impl"
    // InternalQueryDsl.g:5236:1: rule__ModelQuery__Group__6__Impl : ( ( rule__ModelQuery__ExprAssignment_6 ) ) ;
    public final void rule__ModelQuery__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5240:1: ( ( ( rule__ModelQuery__ExprAssignment_6 ) ) )
            // InternalQueryDsl.g:5241:1: ( ( rule__ModelQuery__ExprAssignment_6 ) )
            {
            // InternalQueryDsl.g:5241:1: ( ( rule__ModelQuery__ExprAssignment_6 ) )
            // InternalQueryDsl.g:5242:2: ( rule__ModelQuery__ExprAssignment_6 )
            {
             before(grammarAccess.getModelQueryAccess().getExprAssignment_6()); 
            // InternalQueryDsl.g:5243:2: ( rule__ModelQuery__ExprAssignment_6 )
            // InternalQueryDsl.g:5243:3: rule__ModelQuery__ExprAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__ModelQuery__ExprAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getModelQueryAccess().getExprAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__6__Impl"


    // $ANTLR start "rule__ModelQuery__Group__7"
    // InternalQueryDsl.g:5251:1: rule__ModelQuery__Group__7 : rule__ModelQuery__Group__7__Impl ;
    public final void rule__ModelQuery__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5255:1: ( rule__ModelQuery__Group__7__Impl )
            // InternalQueryDsl.g:5256:2: rule__ModelQuery__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelQuery__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__7"


    // $ANTLR start "rule__ModelQuery__Group__7__Impl"
    // InternalQueryDsl.g:5262:1: rule__ModelQuery__Group__7__Impl : ( ')' ) ;
    public final void rule__ModelQuery__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5266:1: ( ( ')' ) )
            // InternalQueryDsl.g:5267:1: ( ')' )
            {
            // InternalQueryDsl.g:5267:1: ( ')' )
            // InternalQueryDsl.g:5268:2: ')'
            {
             before(grammarAccess.getModelQueryAccess().getRightParenthesisKeyword_7()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getModelQueryAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__Group__7__Impl"


    // $ANTLR start "rule__FullTextSearch__Group__0"
    // InternalQueryDsl.g:5278:1: rule__FullTextSearch__Group__0 : rule__FullTextSearch__Group__0__Impl rule__FullTextSearch__Group__1 ;
    public final void rule__FullTextSearch__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5282:1: ( rule__FullTextSearch__Group__0__Impl rule__FullTextSearch__Group__1 )
            // InternalQueryDsl.g:5283:2: rule__FullTextSearch__Group__0__Impl rule__FullTextSearch__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__FullTextSearch__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__0"


    // $ANTLR start "rule__FullTextSearch__Group__0__Impl"
    // InternalQueryDsl.g:5290:1: rule__FullTextSearch__Group__0__Impl : ( 'fullTextSearch' ) ;
    public final void rule__FullTextSearch__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5294:1: ( ( 'fullTextSearch' ) )
            // InternalQueryDsl.g:5295:1: ( 'fullTextSearch' )
            {
            // InternalQueryDsl.g:5295:1: ( 'fullTextSearch' )
            // InternalQueryDsl.g:5296:2: 'fullTextSearch'
            {
             before(grammarAccess.getFullTextSearchAccess().getFullTextSearchKeyword_0()); 
            match(input,104,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getFullTextSearchKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__0__Impl"


    // $ANTLR start "rule__FullTextSearch__Group__1"
    // InternalQueryDsl.g:5305:1: rule__FullTextSearch__Group__1 : rule__FullTextSearch__Group__1__Impl rule__FullTextSearch__Group__2 ;
    public final void rule__FullTextSearch__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5309:1: ( rule__FullTextSearch__Group__1__Impl rule__FullTextSearch__Group__2 )
            // InternalQueryDsl.g:5310:2: rule__FullTextSearch__Group__1__Impl rule__FullTextSearch__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__FullTextSearch__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__1"


    // $ANTLR start "rule__FullTextSearch__Group__1__Impl"
    // InternalQueryDsl.g:5317:1: rule__FullTextSearch__Group__1__Impl : ( '(' ) ;
    public final void rule__FullTextSearch__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5321:1: ( ( '(' ) )
            // InternalQueryDsl.g:5322:1: ( '(' )
            {
            // InternalQueryDsl.g:5322:1: ( '(' )
            // InternalQueryDsl.g:5323:2: '('
            {
             before(grammarAccess.getFullTextSearchAccess().getLeftParenthesisKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__1__Impl"


    // $ANTLR start "rule__FullTextSearch__Group__2"
    // InternalQueryDsl.g:5332:1: rule__FullTextSearch__Group__2 : rule__FullTextSearch__Group__2__Impl rule__FullTextSearch__Group__3 ;
    public final void rule__FullTextSearch__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5336:1: ( rule__FullTextSearch__Group__2__Impl rule__FullTextSearch__Group__3 )
            // InternalQueryDsl.g:5337:2: rule__FullTextSearch__Group__2__Impl rule__FullTextSearch__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__FullTextSearch__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__2"


    // $ANTLR start "rule__FullTextSearch__Group__2__Impl"
    // InternalQueryDsl.g:5344:1: rule__FullTextSearch__Group__2__Impl : ( ( rule__FullTextSearch__ExpAssignment_2 ) ) ;
    public final void rule__FullTextSearch__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5348:1: ( ( ( rule__FullTextSearch__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:5349:1: ( ( rule__FullTextSearch__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:5349:1: ( ( rule__FullTextSearch__ExpAssignment_2 ) )
            // InternalQueryDsl.g:5350:2: ( rule__FullTextSearch__ExpAssignment_2 )
            {
             before(grammarAccess.getFullTextSearchAccess().getExpAssignment_2()); 
            // InternalQueryDsl.g:5351:2: ( rule__FullTextSearch__ExpAssignment_2 )
            // InternalQueryDsl.g:5351:3: rule__FullTextSearch__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FullTextSearch__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFullTextSearchAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__2__Impl"


    // $ANTLR start "rule__FullTextSearch__Group__3"
    // InternalQueryDsl.g:5359:1: rule__FullTextSearch__Group__3 : rule__FullTextSearch__Group__3__Impl rule__FullTextSearch__Group__4 ;
    public final void rule__FullTextSearch__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5363:1: ( rule__FullTextSearch__Group__3__Impl rule__FullTextSearch__Group__4 )
            // InternalQueryDsl.g:5364:2: rule__FullTextSearch__Group__3__Impl rule__FullTextSearch__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__FullTextSearch__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__3"


    // $ANTLR start "rule__FullTextSearch__Group__3__Impl"
    // InternalQueryDsl.g:5371:1: rule__FullTextSearch__Group__3__Impl : ( ( rule__FullTextSearch__Group_3__0 )* ) ;
    public final void rule__FullTextSearch__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5375:1: ( ( ( rule__FullTextSearch__Group_3__0 )* ) )
            // InternalQueryDsl.g:5376:1: ( ( rule__FullTextSearch__Group_3__0 )* )
            {
            // InternalQueryDsl.g:5376:1: ( ( rule__FullTextSearch__Group_3__0 )* )
            // InternalQueryDsl.g:5377:2: ( rule__FullTextSearch__Group_3__0 )*
            {
             before(grammarAccess.getFullTextSearchAccess().getGroup_3()); 
            // InternalQueryDsl.g:5378:2: ( rule__FullTextSearch__Group_3__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==94) ) {
                    int LA42_1 = input.LA(2);

                    if ( ((LA42_1>=RULE_INT && LA42_1<=RULE_STRING)||(LA42_1>=85 && LA42_1<=86)) ) {
                        alt42=1;
                    }


                }


                switch (alt42) {
            	case 1 :
            	    // InternalQueryDsl.g:5378:3: rule__FullTextSearch__Group_3__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__FullTextSearch__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getFullTextSearchAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__3__Impl"


    // $ANTLR start "rule__FullTextSearch__Group__4"
    // InternalQueryDsl.g:5386:1: rule__FullTextSearch__Group__4 : rule__FullTextSearch__Group__4__Impl rule__FullTextSearch__Group__5 ;
    public final void rule__FullTextSearch__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5390:1: ( rule__FullTextSearch__Group__4__Impl rule__FullTextSearch__Group__5 )
            // InternalQueryDsl.g:5391:2: rule__FullTextSearch__Group__4__Impl rule__FullTextSearch__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__FullTextSearch__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__4"


    // $ANTLR start "rule__FullTextSearch__Group__4__Impl"
    // InternalQueryDsl.g:5398:1: rule__FullTextSearch__Group__4__Impl : ( ( rule__FullTextSearch__Alternatives_4 )? ) ;
    public final void rule__FullTextSearch__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5402:1: ( ( ( rule__FullTextSearch__Alternatives_4 )? ) )
            // InternalQueryDsl.g:5403:1: ( ( rule__FullTextSearch__Alternatives_4 )? )
            {
            // InternalQueryDsl.g:5403:1: ( ( rule__FullTextSearch__Alternatives_4 )? )
            // InternalQueryDsl.g:5404:2: ( rule__FullTextSearch__Alternatives_4 )?
            {
             before(grammarAccess.getFullTextSearchAccess().getAlternatives_4()); 
            // InternalQueryDsl.g:5405:2: ( rule__FullTextSearch__Alternatives_4 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==94) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalQueryDsl.g:5405:3: rule__FullTextSearch__Alternatives_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__FullTextSearch__Alternatives_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFullTextSearchAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__4__Impl"


    // $ANTLR start "rule__FullTextSearch__Group__5"
    // InternalQueryDsl.g:5413:1: rule__FullTextSearch__Group__5 : rule__FullTextSearch__Group__5__Impl ;
    public final void rule__FullTextSearch__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5417:1: ( rule__FullTextSearch__Group__5__Impl )
            // InternalQueryDsl.g:5418:2: rule__FullTextSearch__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__5"


    // $ANTLR start "rule__FullTextSearch__Group__5__Impl"
    // InternalQueryDsl.g:5424:1: rule__FullTextSearch__Group__5__Impl : ( ')' ) ;
    public final void rule__FullTextSearch__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5428:1: ( ( ')' ) )
            // InternalQueryDsl.g:5429:1: ( ')' )
            {
            // InternalQueryDsl.g:5429:1: ( ')' )
            // InternalQueryDsl.g:5430:2: ')'
            {
             before(grammarAccess.getFullTextSearchAccess().getRightParenthesisKeyword_5()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group__5__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_3__0"
    // InternalQueryDsl.g:5440:1: rule__FullTextSearch__Group_3__0 : rule__FullTextSearch__Group_3__0__Impl rule__FullTextSearch__Group_3__1 ;
    public final void rule__FullTextSearch__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5444:1: ( rule__FullTextSearch__Group_3__0__Impl rule__FullTextSearch__Group_3__1 )
            // InternalQueryDsl.g:5445:2: rule__FullTextSearch__Group_3__0__Impl rule__FullTextSearch__Group_3__1
            {
            pushFollow(FOLLOW_31);
            rule__FullTextSearch__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_3__0"


    // $ANTLR start "rule__FullTextSearch__Group_3__0__Impl"
    // InternalQueryDsl.g:5452:1: rule__FullTextSearch__Group_3__0__Impl : ( ',' ) ;
    public final void rule__FullTextSearch__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5456:1: ( ( ',' ) )
            // InternalQueryDsl.g:5457:1: ( ',' )
            {
            // InternalQueryDsl.g:5457:1: ( ',' )
            // InternalQueryDsl.g:5458:2: ','
            {
             before(grammarAccess.getFullTextSearchAccess().getCommaKeyword_3_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_3__0__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_3__1"
    // InternalQueryDsl.g:5467:1: rule__FullTextSearch__Group_3__1 : rule__FullTextSearch__Group_3__1__Impl ;
    public final void rule__FullTextSearch__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5471:1: ( rule__FullTextSearch__Group_3__1__Impl )
            // InternalQueryDsl.g:5472:2: rule__FullTextSearch__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_3__1"


    // $ANTLR start "rule__FullTextSearch__Group_3__1__Impl"
    // InternalQueryDsl.g:5478:1: rule__FullTextSearch__Group_3__1__Impl : ( ( rule__FullTextSearch__ExpsAssignment_3_1 ) ) ;
    public final void rule__FullTextSearch__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5482:1: ( ( ( rule__FullTextSearch__ExpsAssignment_3_1 ) ) )
            // InternalQueryDsl.g:5483:1: ( ( rule__FullTextSearch__ExpsAssignment_3_1 ) )
            {
            // InternalQueryDsl.g:5483:1: ( ( rule__FullTextSearch__ExpsAssignment_3_1 ) )
            // InternalQueryDsl.g:5484:2: ( rule__FullTextSearch__ExpsAssignment_3_1 )
            {
             before(grammarAccess.getFullTextSearchAccess().getExpsAssignment_3_1()); 
            // InternalQueryDsl.g:5485:2: ( rule__FullTextSearch__ExpsAssignment_3_1 )
            // InternalQueryDsl.g:5485:3: rule__FullTextSearch__ExpsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__FullTextSearch__ExpsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getFullTextSearchAccess().getExpsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_3__1__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_4_0__0"
    // InternalQueryDsl.g:5494:1: rule__FullTextSearch__Group_4_0__0 : rule__FullTextSearch__Group_4_0__0__Impl rule__FullTextSearch__Group_4_0__1 ;
    public final void rule__FullTextSearch__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5498:1: ( rule__FullTextSearch__Group_4_0__0__Impl rule__FullTextSearch__Group_4_0__1 )
            // InternalQueryDsl.g:5499:2: rule__FullTextSearch__Group_4_0__0__Impl rule__FullTextSearch__Group_4_0__1
            {
            pushFollow(FOLLOW_37);
            rule__FullTextSearch__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_0__0"


    // $ANTLR start "rule__FullTextSearch__Group_4_0__0__Impl"
    // InternalQueryDsl.g:5506:1: rule__FullTextSearch__Group_4_0__0__Impl : ( ',' ) ;
    public final void rule__FullTextSearch__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5510:1: ( ( ',' ) )
            // InternalQueryDsl.g:5511:1: ( ',' )
            {
            // InternalQueryDsl.g:5511:1: ( ',' )
            // InternalQueryDsl.g:5512:2: ','
            {
             before(grammarAccess.getFullTextSearchAccess().getCommaKeyword_4_0_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getCommaKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_0__0__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_4_0__1"
    // InternalQueryDsl.g:5521:1: rule__FullTextSearch__Group_4_0__1 : rule__FullTextSearch__Group_4_0__1__Impl rule__FullTextSearch__Group_4_0__2 ;
    public final void rule__FullTextSearch__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5525:1: ( rule__FullTextSearch__Group_4_0__1__Impl rule__FullTextSearch__Group_4_0__2 )
            // InternalQueryDsl.g:5526:2: rule__FullTextSearch__Group_4_0__1__Impl rule__FullTextSearch__Group_4_0__2
            {
            pushFollow(FOLLOW_34);
            rule__FullTextSearch__Group_4_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_4_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_0__1"


    // $ANTLR start "rule__FullTextSearch__Group_4_0__1__Impl"
    // InternalQueryDsl.g:5533:1: rule__FullTextSearch__Group_4_0__1__Impl : ( 'min_match' ) ;
    public final void rule__FullTextSearch__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5537:1: ( ( 'min_match' ) )
            // InternalQueryDsl.g:5538:1: ( 'min_match' )
            {
            // InternalQueryDsl.g:5538:1: ( 'min_match' )
            // InternalQueryDsl.g:5539:2: 'min_match'
            {
             before(grammarAccess.getFullTextSearchAccess().getMin_matchKeyword_4_0_1()); 
            match(input,105,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getMin_matchKeyword_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_0__1__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_4_0__2"
    // InternalQueryDsl.g:5548:1: rule__FullTextSearch__Group_4_0__2 : rule__FullTextSearch__Group_4_0__2__Impl rule__FullTextSearch__Group_4_0__3 ;
    public final void rule__FullTextSearch__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5552:1: ( rule__FullTextSearch__Group_4_0__2__Impl rule__FullTextSearch__Group_4_0__3 )
            // InternalQueryDsl.g:5553:2: rule__FullTextSearch__Group_4_0__2__Impl rule__FullTextSearch__Group_4_0__3
            {
            pushFollow(FOLLOW_38);
            rule__FullTextSearch__Group_4_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_4_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_0__2"


    // $ANTLR start "rule__FullTextSearch__Group_4_0__2__Impl"
    // InternalQueryDsl.g:5560:1: rule__FullTextSearch__Group_4_0__2__Impl : ( ':' ) ;
    public final void rule__FullTextSearch__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5564:1: ( ( ':' ) )
            // InternalQueryDsl.g:5565:1: ( ':' )
            {
            // InternalQueryDsl.g:5565:1: ( ':' )
            // InternalQueryDsl.g:5566:2: ':'
            {
             before(grammarAccess.getFullTextSearchAccess().getColonKeyword_4_0_2()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getColonKeyword_4_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_0__2__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_4_0__3"
    // InternalQueryDsl.g:5575:1: rule__FullTextSearch__Group_4_0__3 : rule__FullTextSearch__Group_4_0__3__Impl ;
    public final void rule__FullTextSearch__Group_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5579:1: ( rule__FullTextSearch__Group_4_0__3__Impl )
            // InternalQueryDsl.g:5580:2: rule__FullTextSearch__Group_4_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_4_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_0__3"


    // $ANTLR start "rule__FullTextSearch__Group_4_0__3__Impl"
    // InternalQueryDsl.g:5586:1: rule__FullTextSearch__Group_4_0__3__Impl : ( RULE_INT ) ;
    public final void rule__FullTextSearch__Group_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5590:1: ( ( RULE_INT ) )
            // InternalQueryDsl.g:5591:1: ( RULE_INT )
            {
            // InternalQueryDsl.g:5591:1: ( RULE_INT )
            // InternalQueryDsl.g:5592:2: RULE_INT
            {
             before(grammarAccess.getFullTextSearchAccess().getINTTerminalRuleCall_4_0_3()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getINTTerminalRuleCall_4_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_0__3__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_4_1__0"
    // InternalQueryDsl.g:5602:1: rule__FullTextSearch__Group_4_1__0 : rule__FullTextSearch__Group_4_1__0__Impl rule__FullTextSearch__Group_4_1__1 ;
    public final void rule__FullTextSearch__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5606:1: ( rule__FullTextSearch__Group_4_1__0__Impl rule__FullTextSearch__Group_4_1__1 )
            // InternalQueryDsl.g:5607:2: rule__FullTextSearch__Group_4_1__0__Impl rule__FullTextSearch__Group_4_1__1
            {
            pushFollow(FOLLOW_39);
            rule__FullTextSearch__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_1__0"


    // $ANTLR start "rule__FullTextSearch__Group_4_1__0__Impl"
    // InternalQueryDsl.g:5614:1: rule__FullTextSearch__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__FullTextSearch__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5618:1: ( ( ',' ) )
            // InternalQueryDsl.g:5619:1: ( ',' )
            {
            // InternalQueryDsl.g:5619:1: ( ',' )
            // InternalQueryDsl.g:5620:2: ','
            {
             before(grammarAccess.getFullTextSearchAccess().getCommaKeyword_4_1_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getCommaKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_1__0__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_4_1__1"
    // InternalQueryDsl.g:5629:1: rule__FullTextSearch__Group_4_1__1 : rule__FullTextSearch__Group_4_1__1__Impl rule__FullTextSearch__Group_4_1__2 ;
    public final void rule__FullTextSearch__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5633:1: ( rule__FullTextSearch__Group_4_1__1__Impl rule__FullTextSearch__Group_4_1__2 )
            // InternalQueryDsl.g:5634:2: rule__FullTextSearch__Group_4_1__1__Impl rule__FullTextSearch__Group_4_1__2
            {
            pushFollow(FOLLOW_34);
            rule__FullTextSearch__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_1__1"


    // $ANTLR start "rule__FullTextSearch__Group_4_1__1__Impl"
    // InternalQueryDsl.g:5641:1: rule__FullTextSearch__Group_4_1__1__Impl : ( 'operator' ) ;
    public final void rule__FullTextSearch__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5645:1: ( ( 'operator' ) )
            // InternalQueryDsl.g:5646:1: ( 'operator' )
            {
            // InternalQueryDsl.g:5646:1: ( 'operator' )
            // InternalQueryDsl.g:5647:2: 'operator'
            {
             before(grammarAccess.getFullTextSearchAccess().getOperatorKeyword_4_1_1()); 
            match(input,106,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getOperatorKeyword_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_1__1__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_4_1__2"
    // InternalQueryDsl.g:5656:1: rule__FullTextSearch__Group_4_1__2 : rule__FullTextSearch__Group_4_1__2__Impl rule__FullTextSearch__Group_4_1__3 ;
    public final void rule__FullTextSearch__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5660:1: ( rule__FullTextSearch__Group_4_1__2__Impl rule__FullTextSearch__Group_4_1__3 )
            // InternalQueryDsl.g:5661:2: rule__FullTextSearch__Group_4_1__2__Impl rule__FullTextSearch__Group_4_1__3
            {
            pushFollow(FOLLOW_40);
            rule__FullTextSearch__Group_4_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_4_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_1__2"


    // $ANTLR start "rule__FullTextSearch__Group_4_1__2__Impl"
    // InternalQueryDsl.g:5668:1: rule__FullTextSearch__Group_4_1__2__Impl : ( ':' ) ;
    public final void rule__FullTextSearch__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5672:1: ( ( ':' ) )
            // InternalQueryDsl.g:5673:1: ( ':' )
            {
            // InternalQueryDsl.g:5673:1: ( ':' )
            // InternalQueryDsl.g:5674:2: ':'
            {
             before(grammarAccess.getFullTextSearchAccess().getColonKeyword_4_1_2()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getFullTextSearchAccess().getColonKeyword_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_1__2__Impl"


    // $ANTLR start "rule__FullTextSearch__Group_4_1__3"
    // InternalQueryDsl.g:5683:1: rule__FullTextSearch__Group_4_1__3 : rule__FullTextSearch__Group_4_1__3__Impl ;
    public final void rule__FullTextSearch__Group_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5687:1: ( rule__FullTextSearch__Group_4_1__3__Impl )
            // InternalQueryDsl.g:5688:2: rule__FullTextSearch__Group_4_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FullTextSearch__Group_4_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_1__3"


    // $ANTLR start "rule__FullTextSearch__Group_4_1__3__Impl"
    // InternalQueryDsl.g:5694:1: rule__FullTextSearch__Group_4_1__3__Impl : ( ( rule__FullTextSearch__OpAssignment_4_1_3 ) ) ;
    public final void rule__FullTextSearch__Group_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5698:1: ( ( ( rule__FullTextSearch__OpAssignment_4_1_3 ) ) )
            // InternalQueryDsl.g:5699:1: ( ( rule__FullTextSearch__OpAssignment_4_1_3 ) )
            {
            // InternalQueryDsl.g:5699:1: ( ( rule__FullTextSearch__OpAssignment_4_1_3 ) )
            // InternalQueryDsl.g:5700:2: ( rule__FullTextSearch__OpAssignment_4_1_3 )
            {
             before(grammarAccess.getFullTextSearchAccess().getOpAssignment_4_1_3()); 
            // InternalQueryDsl.g:5701:2: ( rule__FullTextSearch__OpAssignment_4_1_3 )
            // InternalQueryDsl.g:5701:3: rule__FullTextSearch__OpAssignment_4_1_3
            {
            pushFollow(FOLLOW_2);
            rule__FullTextSearch__OpAssignment_4_1_3();

            state._fsp--;


            }

             after(grammarAccess.getFullTextSearchAccess().getOpAssignment_4_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__Group_4_1__3__Impl"


    // $ANTLR start "rule__QualityMetric__Group__0"
    // InternalQueryDsl.g:5710:1: rule__QualityMetric__Group__0 : rule__QualityMetric__Group__0__Impl rule__QualityMetric__Group__1 ;
    public final void rule__QualityMetric__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5714:1: ( rule__QualityMetric__Group__0__Impl rule__QualityMetric__Group__1 )
            // InternalQueryDsl.g:5715:2: rule__QualityMetric__Group__0__Impl rule__QualityMetric__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__QualityMetric__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualityMetric__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__0"


    // $ANTLR start "rule__QualityMetric__Group__0__Impl"
    // InternalQueryDsl.g:5722:1: rule__QualityMetric__Group__0__Impl : ( 'qualityMetrics' ) ;
    public final void rule__QualityMetric__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5726:1: ( ( 'qualityMetrics' ) )
            // InternalQueryDsl.g:5727:1: ( 'qualityMetrics' )
            {
            // InternalQueryDsl.g:5727:1: ( 'qualityMetrics' )
            // InternalQueryDsl.g:5728:2: 'qualityMetrics'
            {
             before(grammarAccess.getQualityMetricAccess().getQualityMetricsKeyword_0()); 
            match(input,107,FOLLOW_2); 
             after(grammarAccess.getQualityMetricAccess().getQualityMetricsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__0__Impl"


    // $ANTLR start "rule__QualityMetric__Group__1"
    // InternalQueryDsl.g:5737:1: rule__QualityMetric__Group__1 : rule__QualityMetric__Group__1__Impl rule__QualityMetric__Group__2 ;
    public final void rule__QualityMetric__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5741:1: ( rule__QualityMetric__Group__1__Impl rule__QualityMetric__Group__2 )
            // InternalQueryDsl.g:5742:2: rule__QualityMetric__Group__1__Impl rule__QualityMetric__Group__2
            {
            pushFollow(FOLLOW_41);
            rule__QualityMetric__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualityMetric__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__1"


    // $ANTLR start "rule__QualityMetric__Group__1__Impl"
    // InternalQueryDsl.g:5749:1: rule__QualityMetric__Group__1__Impl : ( '(' ) ;
    public final void rule__QualityMetric__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5753:1: ( ( '(' ) )
            // InternalQueryDsl.g:5754:1: ( '(' )
            {
            // InternalQueryDsl.g:5754:1: ( '(' )
            // InternalQueryDsl.g:5755:2: '('
            {
             before(grammarAccess.getQualityMetricAccess().getLeftParenthesisKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getQualityMetricAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__1__Impl"


    // $ANTLR start "rule__QualityMetric__Group__2"
    // InternalQueryDsl.g:5764:1: rule__QualityMetric__Group__2 : rule__QualityMetric__Group__2__Impl rule__QualityMetric__Group__3 ;
    public final void rule__QualityMetric__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5768:1: ( rule__QualityMetric__Group__2__Impl rule__QualityMetric__Group__3 )
            // InternalQueryDsl.g:5769:2: rule__QualityMetric__Group__2__Impl rule__QualityMetric__Group__3
            {
            pushFollow(FOLLOW_42);
            rule__QualityMetric__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualityMetric__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__2"


    // $ANTLR start "rule__QualityMetric__Group__2__Impl"
    // InternalQueryDsl.g:5776:1: rule__QualityMetric__Group__2__Impl : ( ( rule__QualityMetric__QExpAssignment_2 ) ) ;
    public final void rule__QualityMetric__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5780:1: ( ( ( rule__QualityMetric__QExpAssignment_2 ) ) )
            // InternalQueryDsl.g:5781:1: ( ( rule__QualityMetric__QExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:5781:1: ( ( rule__QualityMetric__QExpAssignment_2 ) )
            // InternalQueryDsl.g:5782:2: ( rule__QualityMetric__QExpAssignment_2 )
            {
             before(grammarAccess.getQualityMetricAccess().getQExpAssignment_2()); 
            // InternalQueryDsl.g:5783:2: ( rule__QualityMetric__QExpAssignment_2 )
            // InternalQueryDsl.g:5783:3: rule__QualityMetric__QExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__QualityMetric__QExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getQualityMetricAccess().getQExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__2__Impl"


    // $ANTLR start "rule__QualityMetric__Group__3"
    // InternalQueryDsl.g:5791:1: rule__QualityMetric__Group__3 : rule__QualityMetric__Group__3__Impl rule__QualityMetric__Group__4 ;
    public final void rule__QualityMetric__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5795:1: ( rule__QualityMetric__Group__3__Impl rule__QualityMetric__Group__4 )
            // InternalQueryDsl.g:5796:2: rule__QualityMetric__Group__3__Impl rule__QualityMetric__Group__4
            {
            pushFollow(FOLLOW_42);
            rule__QualityMetric__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualityMetric__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__3"


    // $ANTLR start "rule__QualityMetric__Group__3__Impl"
    // InternalQueryDsl.g:5803:1: rule__QualityMetric__Group__3__Impl : ( ( rule__QualityMetric__Group_3__0 )* ) ;
    public final void rule__QualityMetric__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5807:1: ( ( ( rule__QualityMetric__Group_3__0 )* ) )
            // InternalQueryDsl.g:5808:1: ( ( rule__QualityMetric__Group_3__0 )* )
            {
            // InternalQueryDsl.g:5808:1: ( ( rule__QualityMetric__Group_3__0 )* )
            // InternalQueryDsl.g:5809:2: ( rule__QualityMetric__Group_3__0 )*
            {
             before(grammarAccess.getQualityMetricAccess().getGroup_3()); 
            // InternalQueryDsl.g:5810:2: ( rule__QualityMetric__Group_3__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=37 && LA44_0<=39)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalQueryDsl.g:5810:3: rule__QualityMetric__Group_3__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__QualityMetric__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getQualityMetricAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__3__Impl"


    // $ANTLR start "rule__QualityMetric__Group__4"
    // InternalQueryDsl.g:5818:1: rule__QualityMetric__Group__4 : rule__QualityMetric__Group__4__Impl ;
    public final void rule__QualityMetric__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5822:1: ( rule__QualityMetric__Group__4__Impl )
            // InternalQueryDsl.g:5823:2: rule__QualityMetric__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualityMetric__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__4"


    // $ANTLR start "rule__QualityMetric__Group__4__Impl"
    // InternalQueryDsl.g:5829:1: rule__QualityMetric__Group__4__Impl : ( ')' ) ;
    public final void rule__QualityMetric__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5833:1: ( ( ')' ) )
            // InternalQueryDsl.g:5834:1: ( ')' )
            {
            // InternalQueryDsl.g:5834:1: ( ')' )
            // InternalQueryDsl.g:5835:2: ')'
            {
             before(grammarAccess.getQualityMetricAccess().getRightParenthesisKeyword_4()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getQualityMetricAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group__4__Impl"


    // $ANTLR start "rule__QualityMetric__Group_3__0"
    // InternalQueryDsl.g:5845:1: rule__QualityMetric__Group_3__0 : rule__QualityMetric__Group_3__0__Impl rule__QualityMetric__Group_3__1 ;
    public final void rule__QualityMetric__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5849:1: ( rule__QualityMetric__Group_3__0__Impl rule__QualityMetric__Group_3__1 )
            // InternalQueryDsl.g:5850:2: rule__QualityMetric__Group_3__0__Impl rule__QualityMetric__Group_3__1
            {
            pushFollow(FOLLOW_41);
            rule__QualityMetric__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualityMetric__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group_3__0"


    // $ANTLR start "rule__QualityMetric__Group_3__0__Impl"
    // InternalQueryDsl.g:5857:1: rule__QualityMetric__Group_3__0__Impl : ( ( rule__QualityMetric__OperatorAssignment_3_0 ) ) ;
    public final void rule__QualityMetric__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5861:1: ( ( ( rule__QualityMetric__OperatorAssignment_3_0 ) ) )
            // InternalQueryDsl.g:5862:1: ( ( rule__QualityMetric__OperatorAssignment_3_0 ) )
            {
            // InternalQueryDsl.g:5862:1: ( ( rule__QualityMetric__OperatorAssignment_3_0 ) )
            // InternalQueryDsl.g:5863:2: ( rule__QualityMetric__OperatorAssignment_3_0 )
            {
             before(grammarAccess.getQualityMetricAccess().getOperatorAssignment_3_0()); 
            // InternalQueryDsl.g:5864:2: ( rule__QualityMetric__OperatorAssignment_3_0 )
            // InternalQueryDsl.g:5864:3: rule__QualityMetric__OperatorAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__QualityMetric__OperatorAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getQualityMetricAccess().getOperatorAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group_3__0__Impl"


    // $ANTLR start "rule__QualityMetric__Group_3__1"
    // InternalQueryDsl.g:5872:1: rule__QualityMetric__Group_3__1 : rule__QualityMetric__Group_3__1__Impl ;
    public final void rule__QualityMetric__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5876:1: ( rule__QualityMetric__Group_3__1__Impl )
            // InternalQueryDsl.g:5877:2: rule__QualityMetric__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualityMetric__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group_3__1"


    // $ANTLR start "rule__QualityMetric__Group_3__1__Impl"
    // InternalQueryDsl.g:5883:1: rule__QualityMetric__Group_3__1__Impl : ( ( rule__QualityMetric__QExpsAssignment_3_1 ) ) ;
    public final void rule__QualityMetric__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5887:1: ( ( ( rule__QualityMetric__QExpsAssignment_3_1 ) ) )
            // InternalQueryDsl.g:5888:1: ( ( rule__QualityMetric__QExpsAssignment_3_1 ) )
            {
            // InternalQueryDsl.g:5888:1: ( ( rule__QualityMetric__QExpsAssignment_3_1 ) )
            // InternalQueryDsl.g:5889:2: ( rule__QualityMetric__QExpsAssignment_3_1 )
            {
             before(grammarAccess.getQualityMetricAccess().getQExpsAssignment_3_1()); 
            // InternalQueryDsl.g:5890:2: ( rule__QualityMetric__QExpsAssignment_3_1 )
            // InternalQueryDsl.g:5890:3: rule__QualityMetric__QExpsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__QualityMetric__QExpsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getQualityMetricAccess().getQExpsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__Group_3__1__Impl"


    // $ANTLR start "rule__Transformable__Group__0"
    // InternalQueryDsl.g:5899:1: rule__Transformable__Group__0 : rule__Transformable__Group__0__Impl rule__Transformable__Group__1 ;
    public final void rule__Transformable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5903:1: ( rule__Transformable__Group__0__Impl rule__Transformable__Group__1 )
            // InternalQueryDsl.g:5904:2: rule__Transformable__Group__0__Impl rule__Transformable__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Transformable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transformable__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__0"


    // $ANTLR start "rule__Transformable__Group__0__Impl"
    // InternalQueryDsl.g:5911:1: rule__Transformable__Group__0__Impl : ( 'transformable' ) ;
    public final void rule__Transformable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5915:1: ( ( 'transformable' ) )
            // InternalQueryDsl.g:5916:1: ( 'transformable' )
            {
            // InternalQueryDsl.g:5916:1: ( 'transformable' )
            // InternalQueryDsl.g:5917:2: 'transformable'
            {
             before(grammarAccess.getTransformableAccess().getTransformableKeyword_0()); 
            match(input,108,FOLLOW_2); 
             after(grammarAccess.getTransformableAccess().getTransformableKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__0__Impl"


    // $ANTLR start "rule__Transformable__Group__1"
    // InternalQueryDsl.g:5926:1: rule__Transformable__Group__1 : rule__Transformable__Group__1__Impl rule__Transformable__Group__2 ;
    public final void rule__Transformable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5930:1: ( rule__Transformable__Group__1__Impl rule__Transformable__Group__2 )
            // InternalQueryDsl.g:5931:2: rule__Transformable__Group__1__Impl rule__Transformable__Group__2
            {
            pushFollow(FOLLOW_44);
            rule__Transformable__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transformable__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__1"


    // $ANTLR start "rule__Transformable__Group__1__Impl"
    // InternalQueryDsl.g:5938:1: rule__Transformable__Group__1__Impl : ( '(' ) ;
    public final void rule__Transformable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5942:1: ( ( '(' ) )
            // InternalQueryDsl.g:5943:1: ( '(' )
            {
            // InternalQueryDsl.g:5943:1: ( '(' )
            // InternalQueryDsl.g:5944:2: '('
            {
             before(grammarAccess.getTransformableAccess().getLeftParenthesisKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getTransformableAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__1__Impl"


    // $ANTLR start "rule__Transformable__Group__2"
    // InternalQueryDsl.g:5953:1: rule__Transformable__Group__2 : rule__Transformable__Group__2__Impl rule__Transformable__Group__3 ;
    public final void rule__Transformable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5957:1: ( rule__Transformable__Group__2__Impl rule__Transformable__Group__3 )
            // InternalQueryDsl.g:5958:2: rule__Transformable__Group__2__Impl rule__Transformable__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Transformable__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transformable__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__2"


    // $ANTLR start "rule__Transformable__Group__2__Impl"
    // InternalQueryDsl.g:5965:1: rule__Transformable__Group__2__Impl : ( ( rule__Transformable__Group_2__0 ) ) ;
    public final void rule__Transformable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5969:1: ( ( ( rule__Transformable__Group_2__0 ) ) )
            // InternalQueryDsl.g:5970:1: ( ( rule__Transformable__Group_2__0 ) )
            {
            // InternalQueryDsl.g:5970:1: ( ( rule__Transformable__Group_2__0 ) )
            // InternalQueryDsl.g:5971:2: ( rule__Transformable__Group_2__0 )
            {
             before(grammarAccess.getTransformableAccess().getGroup_2()); 
            // InternalQueryDsl.g:5972:2: ( rule__Transformable__Group_2__0 )
            // InternalQueryDsl.g:5972:3: rule__Transformable__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__Transformable__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getTransformableAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__2__Impl"


    // $ANTLR start "rule__Transformable__Group__3"
    // InternalQueryDsl.g:5980:1: rule__Transformable__Group__3 : rule__Transformable__Group__3__Impl rule__Transformable__Group__4 ;
    public final void rule__Transformable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5984:1: ( rule__Transformable__Group__3__Impl rule__Transformable__Group__4 )
            // InternalQueryDsl.g:5985:2: rule__Transformable__Group__3__Impl rule__Transformable__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Transformable__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transformable__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__3"


    // $ANTLR start "rule__Transformable__Group__3__Impl"
    // InternalQueryDsl.g:5992:1: rule__Transformable__Group__3__Impl : ( ( rule__Transformable__Group_3__0 )? ) ;
    public final void rule__Transformable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:5996:1: ( ( ( rule__Transformable__Group_3__0 )? ) )
            // InternalQueryDsl.g:5997:1: ( ( rule__Transformable__Group_3__0 )? )
            {
            // InternalQueryDsl.g:5997:1: ( ( rule__Transformable__Group_3__0 )? )
            // InternalQueryDsl.g:5998:2: ( rule__Transformable__Group_3__0 )?
            {
             before(grammarAccess.getTransformableAccess().getGroup_3()); 
            // InternalQueryDsl.g:5999:2: ( rule__Transformable__Group_3__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==94) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalQueryDsl.g:5999:3: rule__Transformable__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transformable__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransformableAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__3__Impl"


    // $ANTLR start "rule__Transformable__Group__4"
    // InternalQueryDsl.g:6007:1: rule__Transformable__Group__4 : rule__Transformable__Group__4__Impl ;
    public final void rule__Transformable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6011:1: ( rule__Transformable__Group__4__Impl )
            // InternalQueryDsl.g:6012:2: rule__Transformable__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transformable__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__4"


    // $ANTLR start "rule__Transformable__Group__4__Impl"
    // InternalQueryDsl.g:6018:1: rule__Transformable__Group__4__Impl : ( ')' ) ;
    public final void rule__Transformable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6022:1: ( ( ')' ) )
            // InternalQueryDsl.g:6023:1: ( ')' )
            {
            // InternalQueryDsl.g:6023:1: ( ')' )
            // InternalQueryDsl.g:6024:2: ')'
            {
             before(grammarAccess.getTransformableAccess().getRightParenthesisKeyword_4()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getTransformableAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group__4__Impl"


    // $ANTLR start "rule__Transformable__Group_2__0"
    // InternalQueryDsl.g:6034:1: rule__Transformable__Group_2__0 : rule__Transformable__Group_2__0__Impl rule__Transformable__Group_2__1 ;
    public final void rule__Transformable__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6038:1: ( rule__Transformable__Group_2__0__Impl rule__Transformable__Group_2__1 )
            // InternalQueryDsl.g:6039:2: rule__Transformable__Group_2__0__Impl rule__Transformable__Group_2__1
            {
            pushFollow(FOLLOW_34);
            rule__Transformable__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transformable__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_2__0"


    // $ANTLR start "rule__Transformable__Group_2__0__Impl"
    // InternalQueryDsl.g:6046:1: rule__Transformable__Group_2__0__Impl : ( ( rule__Transformable__ParamAssignment_2_0 ) ) ;
    public final void rule__Transformable__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6050:1: ( ( ( rule__Transformable__ParamAssignment_2_0 ) ) )
            // InternalQueryDsl.g:6051:1: ( ( rule__Transformable__ParamAssignment_2_0 ) )
            {
            // InternalQueryDsl.g:6051:1: ( ( rule__Transformable__ParamAssignment_2_0 ) )
            // InternalQueryDsl.g:6052:2: ( rule__Transformable__ParamAssignment_2_0 )
            {
             before(grammarAccess.getTransformableAccess().getParamAssignment_2_0()); 
            // InternalQueryDsl.g:6053:2: ( rule__Transformable__ParamAssignment_2_0 )
            // InternalQueryDsl.g:6053:3: rule__Transformable__ParamAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Transformable__ParamAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getTransformableAccess().getParamAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_2__0__Impl"


    // $ANTLR start "rule__Transformable__Group_2__1"
    // InternalQueryDsl.g:6061:1: rule__Transformable__Group_2__1 : rule__Transformable__Group_2__1__Impl rule__Transformable__Group_2__2 ;
    public final void rule__Transformable__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6065:1: ( rule__Transformable__Group_2__1__Impl rule__Transformable__Group_2__2 )
            // InternalQueryDsl.g:6066:2: rule__Transformable__Group_2__1__Impl rule__Transformable__Group_2__2
            {
            pushFollow(FOLLOW_31);
            rule__Transformable__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transformable__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_2__1"


    // $ANTLR start "rule__Transformable__Group_2__1__Impl"
    // InternalQueryDsl.g:6073:1: rule__Transformable__Group_2__1__Impl : ( ':' ) ;
    public final void rule__Transformable__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6077:1: ( ( ':' ) )
            // InternalQueryDsl.g:6078:1: ( ':' )
            {
            // InternalQueryDsl.g:6078:1: ( ':' )
            // InternalQueryDsl.g:6079:2: ':'
            {
             before(grammarAccess.getTransformableAccess().getColonKeyword_2_1()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getTransformableAccess().getColonKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_2__1__Impl"


    // $ANTLR start "rule__Transformable__Group_2__2"
    // InternalQueryDsl.g:6088:1: rule__Transformable__Group_2__2 : rule__Transformable__Group_2__2__Impl ;
    public final void rule__Transformable__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6092:1: ( rule__Transformable__Group_2__2__Impl )
            // InternalQueryDsl.g:6093:2: rule__Transformable__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transformable__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_2__2"


    // $ANTLR start "rule__Transformable__Group_2__2__Impl"
    // InternalQueryDsl.g:6099:1: rule__Transformable__Group_2__2__Impl : ( ( rule__Transformable__ExpAssignment_2_2 ) ) ;
    public final void rule__Transformable__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6103:1: ( ( ( rule__Transformable__ExpAssignment_2_2 ) ) )
            // InternalQueryDsl.g:6104:1: ( ( rule__Transformable__ExpAssignment_2_2 ) )
            {
            // InternalQueryDsl.g:6104:1: ( ( rule__Transformable__ExpAssignment_2_2 ) )
            // InternalQueryDsl.g:6105:2: ( rule__Transformable__ExpAssignment_2_2 )
            {
             before(grammarAccess.getTransformableAccess().getExpAssignment_2_2()); 
            // InternalQueryDsl.g:6106:2: ( rule__Transformable__ExpAssignment_2_2 )
            // InternalQueryDsl.g:6106:3: rule__Transformable__ExpAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Transformable__ExpAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getTransformableAccess().getExpAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_2__2__Impl"


    // $ANTLR start "rule__Transformable__Group_3__0"
    // InternalQueryDsl.g:6115:1: rule__Transformable__Group_3__0 : rule__Transformable__Group_3__0__Impl rule__Transformable__Group_3__1 ;
    public final void rule__Transformable__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6119:1: ( rule__Transformable__Group_3__0__Impl rule__Transformable__Group_3__1 )
            // InternalQueryDsl.g:6120:2: rule__Transformable__Group_3__0__Impl rule__Transformable__Group_3__1
            {
            pushFollow(FOLLOW_44);
            rule__Transformable__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transformable__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_3__0"


    // $ANTLR start "rule__Transformable__Group_3__0__Impl"
    // InternalQueryDsl.g:6127:1: rule__Transformable__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Transformable__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6131:1: ( ( ',' ) )
            // InternalQueryDsl.g:6132:1: ( ',' )
            {
            // InternalQueryDsl.g:6132:1: ( ',' )
            // InternalQueryDsl.g:6133:2: ','
            {
             before(grammarAccess.getTransformableAccess().getCommaKeyword_3_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getTransformableAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_3__0__Impl"


    // $ANTLR start "rule__Transformable__Group_3__1"
    // InternalQueryDsl.g:6142:1: rule__Transformable__Group_3__1 : rule__Transformable__Group_3__1__Impl rule__Transformable__Group_3__2 ;
    public final void rule__Transformable__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6146:1: ( rule__Transformable__Group_3__1__Impl rule__Transformable__Group_3__2 )
            // InternalQueryDsl.g:6147:2: rule__Transformable__Group_3__1__Impl rule__Transformable__Group_3__2
            {
            pushFollow(FOLLOW_34);
            rule__Transformable__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transformable__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_3__1"


    // $ANTLR start "rule__Transformable__Group_3__1__Impl"
    // InternalQueryDsl.g:6154:1: rule__Transformable__Group_3__1__Impl : ( ( rule__Transformable__ParamAssignment_3_1 ) ) ;
    public final void rule__Transformable__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6158:1: ( ( ( rule__Transformable__ParamAssignment_3_1 ) ) )
            // InternalQueryDsl.g:6159:1: ( ( rule__Transformable__ParamAssignment_3_1 ) )
            {
            // InternalQueryDsl.g:6159:1: ( ( rule__Transformable__ParamAssignment_3_1 ) )
            // InternalQueryDsl.g:6160:2: ( rule__Transformable__ParamAssignment_3_1 )
            {
             before(grammarAccess.getTransformableAccess().getParamAssignment_3_1()); 
            // InternalQueryDsl.g:6161:2: ( rule__Transformable__ParamAssignment_3_1 )
            // InternalQueryDsl.g:6161:3: rule__Transformable__ParamAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Transformable__ParamAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTransformableAccess().getParamAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_3__1__Impl"


    // $ANTLR start "rule__Transformable__Group_3__2"
    // InternalQueryDsl.g:6169:1: rule__Transformable__Group_3__2 : rule__Transformable__Group_3__2__Impl rule__Transformable__Group_3__3 ;
    public final void rule__Transformable__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6173:1: ( rule__Transformable__Group_3__2__Impl rule__Transformable__Group_3__3 )
            // InternalQueryDsl.g:6174:2: rule__Transformable__Group_3__2__Impl rule__Transformable__Group_3__3
            {
            pushFollow(FOLLOW_31);
            rule__Transformable__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transformable__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_3__2"


    // $ANTLR start "rule__Transformable__Group_3__2__Impl"
    // InternalQueryDsl.g:6181:1: rule__Transformable__Group_3__2__Impl : ( ':' ) ;
    public final void rule__Transformable__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6185:1: ( ( ':' ) )
            // InternalQueryDsl.g:6186:1: ( ':' )
            {
            // InternalQueryDsl.g:6186:1: ( ':' )
            // InternalQueryDsl.g:6187:2: ':'
            {
             before(grammarAccess.getTransformableAccess().getColonKeyword_3_2()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getTransformableAccess().getColonKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_3__2__Impl"


    // $ANTLR start "rule__Transformable__Group_3__3"
    // InternalQueryDsl.g:6196:1: rule__Transformable__Group_3__3 : rule__Transformable__Group_3__3__Impl ;
    public final void rule__Transformable__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6200:1: ( rule__Transformable__Group_3__3__Impl )
            // InternalQueryDsl.g:6201:2: rule__Transformable__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transformable__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_3__3"


    // $ANTLR start "rule__Transformable__Group_3__3__Impl"
    // InternalQueryDsl.g:6207:1: rule__Transformable__Group_3__3__Impl : ( ( rule__Transformable__ExpAssignment_3_3 ) ) ;
    public final void rule__Transformable__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6211:1: ( ( ( rule__Transformable__ExpAssignment_3_3 ) ) )
            // InternalQueryDsl.g:6212:1: ( ( rule__Transformable__ExpAssignment_3_3 ) )
            {
            // InternalQueryDsl.g:6212:1: ( ( rule__Transformable__ExpAssignment_3_3 ) )
            // InternalQueryDsl.g:6213:2: ( rule__Transformable__ExpAssignment_3_3 )
            {
             before(grammarAccess.getTransformableAccess().getExpAssignment_3_3()); 
            // InternalQueryDsl.g:6214:2: ( rule__Transformable__ExpAssignment_3_3 )
            // InternalQueryDsl.g:6214:3: rule__Transformable__ExpAssignment_3_3
            {
            pushFollow(FOLLOW_2);
            rule__Transformable__ExpAssignment_3_3();

            state._fsp--;


            }

             after(grammarAccess.getTransformableAccess().getExpAssignment_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__Group_3__3__Impl"


    // $ANTLR start "rule__QExp__Group__0"
    // InternalQueryDsl.g:6223:1: rule__QExp__Group__0 : rule__QExp__Group__0__Impl rule__QExp__Group__1 ;
    public final void rule__QExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6227:1: ( rule__QExp__Group__0__Impl rule__QExp__Group__1 )
            // InternalQueryDsl.g:6228:2: rule__QExp__Group__0__Impl rule__QExp__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__QExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QExp__Group__0"


    // $ANTLR start "rule__QExp__Group__0__Impl"
    // InternalQueryDsl.g:6235:1: rule__QExp__Group__0__Impl : ( ( rule__QExp__QAttrAssignment_0 ) ) ;
    public final void rule__QExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6239:1: ( ( ( rule__QExp__QAttrAssignment_0 ) ) )
            // InternalQueryDsl.g:6240:1: ( ( rule__QExp__QAttrAssignment_0 ) )
            {
            // InternalQueryDsl.g:6240:1: ( ( rule__QExp__QAttrAssignment_0 ) )
            // InternalQueryDsl.g:6241:2: ( rule__QExp__QAttrAssignment_0 )
            {
             before(grammarAccess.getQExpAccess().getQAttrAssignment_0()); 
            // InternalQueryDsl.g:6242:2: ( rule__QExp__QAttrAssignment_0 )
            // InternalQueryDsl.g:6242:3: rule__QExp__QAttrAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__QExp__QAttrAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getQExpAccess().getQAttrAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QExp__Group__0__Impl"


    // $ANTLR start "rule__QExp__Group__1"
    // InternalQueryDsl.g:6250:1: rule__QExp__Group__1 : rule__QExp__Group__1__Impl rule__QExp__Group__2 ;
    public final void rule__QExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6254:1: ( rule__QExp__Group__1__Impl rule__QExp__Group__2 )
            // InternalQueryDsl.g:6255:2: rule__QExp__Group__1__Impl rule__QExp__Group__2
            {
            pushFollow(FOLLOW_38);
            rule__QExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QExp__Group__1"


    // $ANTLR start "rule__QExp__Group__1__Impl"
    // InternalQueryDsl.g:6262:1: rule__QExp__Group__1__Impl : ( ( rule__QExp__CompAssignment_1 ) ) ;
    public final void rule__QExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6266:1: ( ( ( rule__QExp__CompAssignment_1 ) ) )
            // InternalQueryDsl.g:6267:1: ( ( rule__QExp__CompAssignment_1 ) )
            {
            // InternalQueryDsl.g:6267:1: ( ( rule__QExp__CompAssignment_1 ) )
            // InternalQueryDsl.g:6268:2: ( rule__QExp__CompAssignment_1 )
            {
             before(grammarAccess.getQExpAccess().getCompAssignment_1()); 
            // InternalQueryDsl.g:6269:2: ( rule__QExp__CompAssignment_1 )
            // InternalQueryDsl.g:6269:3: rule__QExp__CompAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__QExp__CompAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQExpAccess().getCompAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QExp__Group__1__Impl"


    // $ANTLR start "rule__QExp__Group__2"
    // InternalQueryDsl.g:6277:1: rule__QExp__Group__2 : rule__QExp__Group__2__Impl ;
    public final void rule__QExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6281:1: ( rule__QExp__Group__2__Impl )
            // InternalQueryDsl.g:6282:2: rule__QExp__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QExp__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QExp__Group__2"


    // $ANTLR start "rule__QExp__Group__2__Impl"
    // InternalQueryDsl.g:6288:1: rule__QExp__Group__2__Impl : ( ( rule__QExp__NAssignment_2 ) ) ;
    public final void rule__QExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6292:1: ( ( ( rule__QExp__NAssignment_2 ) ) )
            // InternalQueryDsl.g:6293:1: ( ( rule__QExp__NAssignment_2 ) )
            {
            // InternalQueryDsl.g:6293:1: ( ( rule__QExp__NAssignment_2 ) )
            // InternalQueryDsl.g:6294:2: ( rule__QExp__NAssignment_2 )
            {
             before(grammarAccess.getQExpAccess().getNAssignment_2()); 
            // InternalQueryDsl.g:6295:2: ( rule__QExp__NAssignment_2 )
            // InternalQueryDsl.g:6295:3: rule__QExp__NAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__QExp__NAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getQExpAccess().getNAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QExp__Group__2__Impl"


    // $ANTLR start "rule__Filter__Group__0"
    // InternalQueryDsl.g:6304:1: rule__Filter__Group__0 : rule__Filter__Group__0__Impl rule__Filter__Group__1 ;
    public final void rule__Filter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6308:1: ( rule__Filter__Group__0__Impl rule__Filter__Group__1 )
            // InternalQueryDsl.g:6309:2: rule__Filter__Group__0__Impl rule__Filter__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Filter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__0"


    // $ANTLR start "rule__Filter__Group__0__Impl"
    // InternalQueryDsl.g:6316:1: rule__Filter__Group__0__Impl : ( 'filter' ) ;
    public final void rule__Filter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6320:1: ( ( 'filter' ) )
            // InternalQueryDsl.g:6321:1: ( 'filter' )
            {
            // InternalQueryDsl.g:6321:1: ( 'filter' )
            // InternalQueryDsl.g:6322:2: 'filter'
            {
             before(grammarAccess.getFilterAccess().getFilterKeyword_0()); 
            match(input,109,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getFilterKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__0__Impl"


    // $ANTLR start "rule__Filter__Group__1"
    // InternalQueryDsl.g:6331:1: rule__Filter__Group__1 : rule__Filter__Group__1__Impl rule__Filter__Group__2 ;
    public final void rule__Filter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6335:1: ( rule__Filter__Group__1__Impl rule__Filter__Group__2 )
            // InternalQueryDsl.g:6336:2: rule__Filter__Group__1__Impl rule__Filter__Group__2
            {
            pushFollow(FOLLOW_46);
            rule__Filter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__1"


    // $ANTLR start "rule__Filter__Group__1__Impl"
    // InternalQueryDsl.g:6343:1: rule__Filter__Group__1__Impl : ( '(' ) ;
    public final void rule__Filter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6347:1: ( ( '(' ) )
            // InternalQueryDsl.g:6348:1: ( '(' )
            {
            // InternalQueryDsl.g:6348:1: ( '(' )
            // InternalQueryDsl.g:6349:2: '('
            {
             before(grammarAccess.getFilterAccess().getLeftParenthesisKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__1__Impl"


    // $ANTLR start "rule__Filter__Group__2"
    // InternalQueryDsl.g:6358:1: rule__Filter__Group__2 : rule__Filter__Group__2__Impl rule__Filter__Group__3 ;
    public final void rule__Filter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6362:1: ( rule__Filter__Group__2__Impl rule__Filter__Group__3 )
            // InternalQueryDsl.g:6363:2: rule__Filter__Group__2__Impl rule__Filter__Group__3
            {
            pushFollow(FOLLOW_46);
            rule__Filter__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__2"


    // $ANTLR start "rule__Filter__Group__2__Impl"
    // InternalQueryDsl.g:6370:1: rule__Filter__Group__2__Impl : ( ( rule__Filter__FilterExpAssignment_2 )? ) ;
    public final void rule__Filter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6374:1: ( ( ( rule__Filter__FilterExpAssignment_2 )? ) )
            // InternalQueryDsl.g:6375:1: ( ( rule__Filter__FilterExpAssignment_2 )? )
            {
            // InternalQueryDsl.g:6375:1: ( ( rule__Filter__FilterExpAssignment_2 )? )
            // InternalQueryDsl.g:6376:2: ( rule__Filter__FilterExpAssignment_2 )?
            {
             before(grammarAccess.getFilterAccess().getFilterExpAssignment_2()); 
            // InternalQueryDsl.g:6377:2: ( rule__Filter__FilterExpAssignment_2 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=45 && LA46_0<=48)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalQueryDsl.g:6377:3: rule__Filter__FilterExpAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Filter__FilterExpAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFilterAccess().getFilterExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__2__Impl"


    // $ANTLR start "rule__Filter__Group__3"
    // InternalQueryDsl.g:6385:1: rule__Filter__Group__3 : rule__Filter__Group__3__Impl rule__Filter__Group__4 ;
    public final void rule__Filter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6389:1: ( rule__Filter__Group__3__Impl rule__Filter__Group__4 )
            // InternalQueryDsl.g:6390:2: rule__Filter__Group__3__Impl rule__Filter__Group__4
            {
            pushFollow(FOLLOW_46);
            rule__Filter__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__3"


    // $ANTLR start "rule__Filter__Group__3__Impl"
    // InternalQueryDsl.g:6397:1: rule__Filter__Group__3__Impl : ( ( rule__Filter__Group_3__0 )? ) ;
    public final void rule__Filter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6401:1: ( ( ( rule__Filter__Group_3__0 )? ) )
            // InternalQueryDsl.g:6402:1: ( ( rule__Filter__Group_3__0 )? )
            {
            // InternalQueryDsl.g:6402:1: ( ( rule__Filter__Group_3__0 )? )
            // InternalQueryDsl.g:6403:2: ( rule__Filter__Group_3__0 )?
            {
             before(grammarAccess.getFilterAccess().getGroup_3()); 
            // InternalQueryDsl.g:6404:2: ( rule__Filter__Group_3__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==94) ) {
                int LA47_1 = input.LA(2);

                if ( ((LA47_1>=45 && LA47_1<=48)) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // InternalQueryDsl.g:6404:3: rule__Filter__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Filter__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFilterAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__3__Impl"


    // $ANTLR start "rule__Filter__Group__4"
    // InternalQueryDsl.g:6412:1: rule__Filter__Group__4 : rule__Filter__Group__4__Impl rule__Filter__Group__5 ;
    public final void rule__Filter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6416:1: ( rule__Filter__Group__4__Impl rule__Filter__Group__5 )
            // InternalQueryDsl.g:6417:2: rule__Filter__Group__4__Impl rule__Filter__Group__5
            {
            pushFollow(FOLLOW_32);
            rule__Filter__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__4"


    // $ANTLR start "rule__Filter__Group__4__Impl"
    // InternalQueryDsl.g:6424:1: rule__Filter__Group__4__Impl : ( ( rule__Filter__Group_4__0 ) ) ;
    public final void rule__Filter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6428:1: ( ( ( rule__Filter__Group_4__0 ) ) )
            // InternalQueryDsl.g:6429:1: ( ( rule__Filter__Group_4__0 ) )
            {
            // InternalQueryDsl.g:6429:1: ( ( rule__Filter__Group_4__0 ) )
            // InternalQueryDsl.g:6430:2: ( rule__Filter__Group_4__0 )
            {
             before(grammarAccess.getFilterAccess().getGroup_4()); 
            // InternalQueryDsl.g:6431:2: ( rule__Filter__Group_4__0 )
            // InternalQueryDsl.g:6431:3: rule__Filter__Group_4__0
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group_4__0();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__4__Impl"


    // $ANTLR start "rule__Filter__Group__5"
    // InternalQueryDsl.g:6439:1: rule__Filter__Group__5 : rule__Filter__Group__5__Impl ;
    public final void rule__Filter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6443:1: ( rule__Filter__Group__5__Impl )
            // InternalQueryDsl.g:6444:2: rule__Filter__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__5"


    // $ANTLR start "rule__Filter__Group__5__Impl"
    // InternalQueryDsl.g:6450:1: rule__Filter__Group__5__Impl : ( ')' ) ;
    public final void rule__Filter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6454:1: ( ( ')' ) )
            // InternalQueryDsl.g:6455:1: ( ')' )
            {
            // InternalQueryDsl.g:6455:1: ( ')' )
            // InternalQueryDsl.g:6456:2: ')'
            {
             before(grammarAccess.getFilterAccess().getRightParenthesisKeyword_5()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__5__Impl"


    // $ANTLR start "rule__Filter__Group_3__0"
    // InternalQueryDsl.g:6466:1: rule__Filter__Group_3__0 : rule__Filter__Group_3__0__Impl rule__Filter__Group_3__1 ;
    public final void rule__Filter__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6470:1: ( rule__Filter__Group_3__0__Impl rule__Filter__Group_3__1 )
            // InternalQueryDsl.g:6471:2: rule__Filter__Group_3__0__Impl rule__Filter__Group_3__1
            {
            pushFollow(FOLLOW_47);
            rule__Filter__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_3__0"


    // $ANTLR start "rule__Filter__Group_3__0__Impl"
    // InternalQueryDsl.g:6478:1: rule__Filter__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Filter__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6482:1: ( ( ',' ) )
            // InternalQueryDsl.g:6483:1: ( ',' )
            {
            // InternalQueryDsl.g:6483:1: ( ',' )
            // InternalQueryDsl.g:6484:2: ','
            {
             before(grammarAccess.getFilterAccess().getCommaKeyword_3_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_3__0__Impl"


    // $ANTLR start "rule__Filter__Group_3__1"
    // InternalQueryDsl.g:6493:1: rule__Filter__Group_3__1 : rule__Filter__Group_3__1__Impl ;
    public final void rule__Filter__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6497:1: ( rule__Filter__Group_3__1__Impl )
            // InternalQueryDsl.g:6498:2: rule__Filter__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_3__1"


    // $ANTLR start "rule__Filter__Group_3__1__Impl"
    // InternalQueryDsl.g:6504:1: rule__Filter__Group_3__1__Impl : ( ( rule__Filter__FilterExpsAssignment_3_1 ) ) ;
    public final void rule__Filter__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6508:1: ( ( ( rule__Filter__FilterExpsAssignment_3_1 ) ) )
            // InternalQueryDsl.g:6509:1: ( ( rule__Filter__FilterExpsAssignment_3_1 ) )
            {
            // InternalQueryDsl.g:6509:1: ( ( rule__Filter__FilterExpsAssignment_3_1 ) )
            // InternalQueryDsl.g:6510:2: ( rule__Filter__FilterExpsAssignment_3_1 )
            {
             before(grammarAccess.getFilterAccess().getFilterExpsAssignment_3_1()); 
            // InternalQueryDsl.g:6511:2: ( rule__Filter__FilterExpsAssignment_3_1 )
            // InternalQueryDsl.g:6511:3: rule__Filter__FilterExpsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Filter__FilterExpsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getFilterExpsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_3__1__Impl"


    // $ANTLR start "rule__Filter__Group_4__0"
    // InternalQueryDsl.g:6520:1: rule__Filter__Group_4__0 : rule__Filter__Group_4__0__Impl rule__Filter__Group_4__1 ;
    public final void rule__Filter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6524:1: ( rule__Filter__Group_4__0__Impl rule__Filter__Group_4__1 )
            // InternalQueryDsl.g:6525:2: rule__Filter__Group_4__0__Impl rule__Filter__Group_4__1
            {
            pushFollow(FOLLOW_48);
            rule__Filter__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__0"


    // $ANTLR start "rule__Filter__Group_4__0__Impl"
    // InternalQueryDsl.g:6532:1: rule__Filter__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Filter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6536:1: ( ( ',' ) )
            // InternalQueryDsl.g:6537:1: ( ',' )
            {
            // InternalQueryDsl.g:6537:1: ( ',' )
            // InternalQueryDsl.g:6538:2: ','
            {
             before(grammarAccess.getFilterAccess().getCommaKeyword_4_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__0__Impl"


    // $ANTLR start "rule__Filter__Group_4__1"
    // InternalQueryDsl.g:6547:1: rule__Filter__Group_4__1 : rule__Filter__Group_4__1__Impl rule__Filter__Group_4__2 ;
    public final void rule__Filter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6551:1: ( rule__Filter__Group_4__1__Impl rule__Filter__Group_4__2 )
            // InternalQueryDsl.g:6552:2: rule__Filter__Group_4__1__Impl rule__Filter__Group_4__2
            {
            pushFollow(FOLLOW_34);
            rule__Filter__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__1"


    // $ANTLR start "rule__Filter__Group_4__1__Impl"
    // InternalQueryDsl.g:6559:1: rule__Filter__Group_4__1__Impl : ( 'size' ) ;
    public final void rule__Filter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6563:1: ( ( 'size' ) )
            // InternalQueryDsl.g:6564:1: ( 'size' )
            {
            // InternalQueryDsl.g:6564:1: ( 'size' )
            // InternalQueryDsl.g:6565:2: 'size'
            {
             before(grammarAccess.getFilterAccess().getSizeKeyword_4_1()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getSizeKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__1__Impl"


    // $ANTLR start "rule__Filter__Group_4__2"
    // InternalQueryDsl.g:6574:1: rule__Filter__Group_4__2 : rule__Filter__Group_4__2__Impl rule__Filter__Group_4__3 ;
    public final void rule__Filter__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6578:1: ( rule__Filter__Group_4__2__Impl rule__Filter__Group_4__3 )
            // InternalQueryDsl.g:6579:2: rule__Filter__Group_4__2__Impl rule__Filter__Group_4__3
            {
            pushFollow(FOLLOW_45);
            rule__Filter__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__2"


    // $ANTLR start "rule__Filter__Group_4__2__Impl"
    // InternalQueryDsl.g:6586:1: rule__Filter__Group_4__2__Impl : ( ':' ) ;
    public final void rule__Filter__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6590:1: ( ( ':' ) )
            // InternalQueryDsl.g:6591:1: ( ':' )
            {
            // InternalQueryDsl.g:6591:1: ( ':' )
            // InternalQueryDsl.g:6592:2: ':'
            {
             before(grammarAccess.getFilterAccess().getColonKeyword_4_2()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getColonKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__2__Impl"


    // $ANTLR start "rule__Filter__Group_4__3"
    // InternalQueryDsl.g:6601:1: rule__Filter__Group_4__3 : rule__Filter__Group_4__3__Impl rule__Filter__Group_4__4 ;
    public final void rule__Filter__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6605:1: ( rule__Filter__Group_4__3__Impl rule__Filter__Group_4__4 )
            // InternalQueryDsl.g:6606:2: rule__Filter__Group_4__3__Impl rule__Filter__Group_4__4
            {
            pushFollow(FOLLOW_31);
            rule__Filter__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group_4__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__3"


    // $ANTLR start "rule__Filter__Group_4__3__Impl"
    // InternalQueryDsl.g:6613:1: rule__Filter__Group_4__3__Impl : ( ( rule__Filter__CompAssignment_4_3 ) ) ;
    public final void rule__Filter__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6617:1: ( ( ( rule__Filter__CompAssignment_4_3 ) ) )
            // InternalQueryDsl.g:6618:1: ( ( rule__Filter__CompAssignment_4_3 ) )
            {
            // InternalQueryDsl.g:6618:1: ( ( rule__Filter__CompAssignment_4_3 ) )
            // InternalQueryDsl.g:6619:2: ( rule__Filter__CompAssignment_4_3 )
            {
             before(grammarAccess.getFilterAccess().getCompAssignment_4_3()); 
            // InternalQueryDsl.g:6620:2: ( rule__Filter__CompAssignment_4_3 )
            // InternalQueryDsl.g:6620:3: rule__Filter__CompAssignment_4_3
            {
            pushFollow(FOLLOW_2);
            rule__Filter__CompAssignment_4_3();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getCompAssignment_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__3__Impl"


    // $ANTLR start "rule__Filter__Group_4__4"
    // InternalQueryDsl.g:6628:1: rule__Filter__Group_4__4 : rule__Filter__Group_4__4__Impl ;
    public final void rule__Filter__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6632:1: ( rule__Filter__Group_4__4__Impl )
            // InternalQueryDsl.g:6633:2: rule__Filter__Group_4__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group_4__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__4"


    // $ANTLR start "rule__Filter__Group_4__4__Impl"
    // InternalQueryDsl.g:6639:1: rule__Filter__Group_4__4__Impl : ( ( rule__Filter__ExpAssignment_4_4 ) ) ;
    public final void rule__Filter__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6643:1: ( ( ( rule__Filter__ExpAssignment_4_4 ) ) )
            // InternalQueryDsl.g:6644:1: ( ( rule__Filter__ExpAssignment_4_4 ) )
            {
            // InternalQueryDsl.g:6644:1: ( ( rule__Filter__ExpAssignment_4_4 ) )
            // InternalQueryDsl.g:6645:2: ( rule__Filter__ExpAssignment_4_4 )
            {
             before(grammarAccess.getFilterAccess().getExpAssignment_4_4()); 
            // InternalQueryDsl.g:6646:2: ( rule__Filter__ExpAssignment_4_4 )
            // InternalQueryDsl.g:6646:3: rule__Filter__ExpAssignment_4_4
            {
            pushFollow(FOLLOW_2);
            rule__Filter__ExpAssignment_4_4();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getExpAssignment_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_4__4__Impl"


    // $ANTLR start "rule__FilterExp__Group__0"
    // InternalQueryDsl.g:6655:1: rule__FilterExp__Group__0 : rule__FilterExp__Group__0__Impl rule__FilterExp__Group__1 ;
    public final void rule__FilterExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6659:1: ( rule__FilterExp__Group__0__Impl rule__FilterExp__Group__1 )
            // InternalQueryDsl.g:6660:2: rule__FilterExp__Group__0__Impl rule__FilterExp__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__FilterExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FilterExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterExp__Group__0"


    // $ANTLR start "rule__FilterExp__Group__0__Impl"
    // InternalQueryDsl.g:6667:1: rule__FilterExp__Group__0__Impl : ( ( rule__FilterExp__FilterkeyAssignment_0 ) ) ;
    public final void rule__FilterExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6671:1: ( ( ( rule__FilterExp__FilterkeyAssignment_0 ) ) )
            // InternalQueryDsl.g:6672:1: ( ( rule__FilterExp__FilterkeyAssignment_0 ) )
            {
            // InternalQueryDsl.g:6672:1: ( ( rule__FilterExp__FilterkeyAssignment_0 ) )
            // InternalQueryDsl.g:6673:2: ( rule__FilterExp__FilterkeyAssignment_0 )
            {
             before(grammarAccess.getFilterExpAccess().getFilterkeyAssignment_0()); 
            // InternalQueryDsl.g:6674:2: ( rule__FilterExp__FilterkeyAssignment_0 )
            // InternalQueryDsl.g:6674:3: rule__FilterExp__FilterkeyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__FilterExp__FilterkeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFilterExpAccess().getFilterkeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterExp__Group__0__Impl"


    // $ANTLR start "rule__FilterExp__Group__1"
    // InternalQueryDsl.g:6682:1: rule__FilterExp__Group__1 : rule__FilterExp__Group__1__Impl rule__FilterExp__Group__2 ;
    public final void rule__FilterExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6686:1: ( rule__FilterExp__Group__1__Impl rule__FilterExp__Group__2 )
            // InternalQueryDsl.g:6687:2: rule__FilterExp__Group__1__Impl rule__FilterExp__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__FilterExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FilterExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterExp__Group__1"


    // $ANTLR start "rule__FilterExp__Group__1__Impl"
    // InternalQueryDsl.g:6694:1: rule__FilterExp__Group__1__Impl : ( ':' ) ;
    public final void rule__FilterExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6698:1: ( ( ':' ) )
            // InternalQueryDsl.g:6699:1: ( ':' )
            {
            // InternalQueryDsl.g:6699:1: ( ':' )
            // InternalQueryDsl.g:6700:2: ':'
            {
             before(grammarAccess.getFilterExpAccess().getColonKeyword_1()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getFilterExpAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterExp__Group__1__Impl"


    // $ANTLR start "rule__FilterExp__Group__2"
    // InternalQueryDsl.g:6709:1: rule__FilterExp__Group__2 : rule__FilterExp__Group__2__Impl ;
    public final void rule__FilterExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6713:1: ( rule__FilterExp__Group__2__Impl )
            // InternalQueryDsl.g:6714:2: rule__FilterExp__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FilterExp__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterExp__Group__2"


    // $ANTLR start "rule__FilterExp__Group__2__Impl"
    // InternalQueryDsl.g:6720:1: rule__FilterExp__Group__2__Impl : ( ( rule__FilterExp__ExpAssignment_2 ) ) ;
    public final void rule__FilterExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6724:1: ( ( ( rule__FilterExp__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:6725:1: ( ( rule__FilterExp__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:6725:1: ( ( rule__FilterExp__ExpAssignment_2 ) )
            // InternalQueryDsl.g:6726:2: ( rule__FilterExp__ExpAssignment_2 )
            {
             before(grammarAccess.getFilterExpAccess().getExpAssignment_2()); 
            // InternalQueryDsl.g:6727:2: ( rule__FilterExp__ExpAssignment_2 )
            // InternalQueryDsl.g:6727:3: rule__FilterExp__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FilterExp__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFilterExpAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterExp__Group__2__Impl"


    // $ANTLR start "rule__UserVar__Group__0"
    // InternalQueryDsl.g:6736:1: rule__UserVar__Group__0 : rule__UserVar__Group__0__Impl rule__UserVar__Group__1 ;
    public final void rule__UserVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6740:1: ( rule__UserVar__Group__0__Impl rule__UserVar__Group__1 )
            // InternalQueryDsl.g:6741:2: rule__UserVar__Group__0__Impl rule__UserVar__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__UserVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UserVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserVar__Group__0"


    // $ANTLR start "rule__UserVar__Group__0__Impl"
    // InternalQueryDsl.g:6748:1: rule__UserVar__Group__0__Impl : ( ruleUserParam ) ;
    public final void rule__UserVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6752:1: ( ( ruleUserParam ) )
            // InternalQueryDsl.g:6753:1: ( ruleUserParam )
            {
            // InternalQueryDsl.g:6753:1: ( ruleUserParam )
            // InternalQueryDsl.g:6754:2: ruleUserParam
            {
             before(grammarAccess.getUserVarAccess().getUserParamParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleUserParam();

            state._fsp--;

             after(grammarAccess.getUserVarAccess().getUserParamParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserVar__Group__0__Impl"


    // $ANTLR start "rule__UserVar__Group__1"
    // InternalQueryDsl.g:6763:1: rule__UserVar__Group__1 : rule__UserVar__Group__1__Impl rule__UserVar__Group__2 ;
    public final void rule__UserVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6767:1: ( rule__UserVar__Group__1__Impl rule__UserVar__Group__2 )
            // InternalQueryDsl.g:6768:2: rule__UserVar__Group__1__Impl rule__UserVar__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__UserVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UserVar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserVar__Group__1"


    // $ANTLR start "rule__UserVar__Group__1__Impl"
    // InternalQueryDsl.g:6775:1: rule__UserVar__Group__1__Impl : ( ':' ) ;
    public final void rule__UserVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6779:1: ( ( ':' ) )
            // InternalQueryDsl.g:6780:1: ( ':' )
            {
            // InternalQueryDsl.g:6780:1: ( ':' )
            // InternalQueryDsl.g:6781:2: ':'
            {
             before(grammarAccess.getUserVarAccess().getColonKeyword_1()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getUserVarAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserVar__Group__1__Impl"


    // $ANTLR start "rule__UserVar__Group__2"
    // InternalQueryDsl.g:6790:1: rule__UserVar__Group__2 : rule__UserVar__Group__2__Impl ;
    public final void rule__UserVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6794:1: ( rule__UserVar__Group__2__Impl )
            // InternalQueryDsl.g:6795:2: rule__UserVar__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UserVar__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserVar__Group__2"


    // $ANTLR start "rule__UserVar__Group__2__Impl"
    // InternalQueryDsl.g:6801:1: rule__UserVar__Group__2__Impl : ( ( rule__UserVar__ExpAssignment_2 ) ) ;
    public final void rule__UserVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6805:1: ( ( ( rule__UserVar__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:6806:1: ( ( rule__UserVar__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:6806:1: ( ( rule__UserVar__ExpAssignment_2 ) )
            // InternalQueryDsl.g:6807:2: ( rule__UserVar__ExpAssignment_2 )
            {
             before(grammarAccess.getUserVarAccess().getExpAssignment_2()); 
            // InternalQueryDsl.g:6808:2: ( rule__UserVar__ExpAssignment_2 )
            // InternalQueryDsl.g:6808:3: rule__UserVar__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__UserVar__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getUserVarAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserVar__Group__2__Impl"


    // $ANTLR start "rule__WorkspaceVar__Group__0"
    // InternalQueryDsl.g:6817:1: rule__WorkspaceVar__Group__0 : rule__WorkspaceVar__Group__0__Impl rule__WorkspaceVar__Group__1 ;
    public final void rule__WorkspaceVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6821:1: ( rule__WorkspaceVar__Group__0__Impl rule__WorkspaceVar__Group__1 )
            // InternalQueryDsl.g:6822:2: rule__WorkspaceVar__Group__0__Impl rule__WorkspaceVar__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__WorkspaceVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkspaceVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceVar__Group__0"


    // $ANTLR start "rule__WorkspaceVar__Group__0__Impl"
    // InternalQueryDsl.g:6829:1: rule__WorkspaceVar__Group__0__Impl : ( ruleWorkspaceParam ) ;
    public final void rule__WorkspaceVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6833:1: ( ( ruleWorkspaceParam ) )
            // InternalQueryDsl.g:6834:1: ( ruleWorkspaceParam )
            {
            // InternalQueryDsl.g:6834:1: ( ruleWorkspaceParam )
            // InternalQueryDsl.g:6835:2: ruleWorkspaceParam
            {
             before(grammarAccess.getWorkspaceVarAccess().getWorkspaceParamParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkspaceParam();

            state._fsp--;

             after(grammarAccess.getWorkspaceVarAccess().getWorkspaceParamParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceVar__Group__0__Impl"


    // $ANTLR start "rule__WorkspaceVar__Group__1"
    // InternalQueryDsl.g:6844:1: rule__WorkspaceVar__Group__1 : rule__WorkspaceVar__Group__1__Impl rule__WorkspaceVar__Group__2 ;
    public final void rule__WorkspaceVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6848:1: ( rule__WorkspaceVar__Group__1__Impl rule__WorkspaceVar__Group__2 )
            // InternalQueryDsl.g:6849:2: rule__WorkspaceVar__Group__1__Impl rule__WorkspaceVar__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__WorkspaceVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkspaceVar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceVar__Group__1"


    // $ANTLR start "rule__WorkspaceVar__Group__1__Impl"
    // InternalQueryDsl.g:6856:1: rule__WorkspaceVar__Group__1__Impl : ( ':' ) ;
    public final void rule__WorkspaceVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6860:1: ( ( ':' ) )
            // InternalQueryDsl.g:6861:1: ( ':' )
            {
            // InternalQueryDsl.g:6861:1: ( ':' )
            // InternalQueryDsl.g:6862:2: ':'
            {
             before(grammarAccess.getWorkspaceVarAccess().getColonKeyword_1()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getWorkspaceVarAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceVar__Group__1__Impl"


    // $ANTLR start "rule__WorkspaceVar__Group__2"
    // InternalQueryDsl.g:6871:1: rule__WorkspaceVar__Group__2 : rule__WorkspaceVar__Group__2__Impl ;
    public final void rule__WorkspaceVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6875:1: ( rule__WorkspaceVar__Group__2__Impl )
            // InternalQueryDsl.g:6876:2: rule__WorkspaceVar__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkspaceVar__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceVar__Group__2"


    // $ANTLR start "rule__WorkspaceVar__Group__2__Impl"
    // InternalQueryDsl.g:6882:1: rule__WorkspaceVar__Group__2__Impl : ( ( rule__WorkspaceVar__ExpAssignment_2 ) ) ;
    public final void rule__WorkspaceVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6886:1: ( ( ( rule__WorkspaceVar__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:6887:1: ( ( rule__WorkspaceVar__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:6887:1: ( ( rule__WorkspaceVar__ExpAssignment_2 ) )
            // InternalQueryDsl.g:6888:2: ( rule__WorkspaceVar__ExpAssignment_2 )
            {
             before(grammarAccess.getWorkspaceVarAccess().getExpAssignment_2()); 
            // InternalQueryDsl.g:6889:2: ( rule__WorkspaceVar__ExpAssignment_2 )
            // InternalQueryDsl.g:6889:3: rule__WorkspaceVar__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__WorkspaceVar__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceVarAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceVar__Group__2__Impl"


    // $ANTLR start "rule__ProjectVar__Group__0"
    // InternalQueryDsl.g:6898:1: rule__ProjectVar__Group__0 : rule__ProjectVar__Group__0__Impl rule__ProjectVar__Group__1 ;
    public final void rule__ProjectVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6902:1: ( rule__ProjectVar__Group__0__Impl rule__ProjectVar__Group__1 )
            // InternalQueryDsl.g:6903:2: rule__ProjectVar__Group__0__Impl rule__ProjectVar__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__ProjectVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProjectVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectVar__Group__0"


    // $ANTLR start "rule__ProjectVar__Group__0__Impl"
    // InternalQueryDsl.g:6910:1: rule__ProjectVar__Group__0__Impl : ( ruleProjectParam ) ;
    public final void rule__ProjectVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6914:1: ( ( ruleProjectParam ) )
            // InternalQueryDsl.g:6915:1: ( ruleProjectParam )
            {
            // InternalQueryDsl.g:6915:1: ( ruleProjectParam )
            // InternalQueryDsl.g:6916:2: ruleProjectParam
            {
             before(grammarAccess.getProjectVarAccess().getProjectParamParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleProjectParam();

            state._fsp--;

             after(grammarAccess.getProjectVarAccess().getProjectParamParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectVar__Group__0__Impl"


    // $ANTLR start "rule__ProjectVar__Group__1"
    // InternalQueryDsl.g:6925:1: rule__ProjectVar__Group__1 : rule__ProjectVar__Group__1__Impl rule__ProjectVar__Group__2 ;
    public final void rule__ProjectVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6929:1: ( rule__ProjectVar__Group__1__Impl rule__ProjectVar__Group__2 )
            // InternalQueryDsl.g:6930:2: rule__ProjectVar__Group__1__Impl rule__ProjectVar__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__ProjectVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProjectVar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectVar__Group__1"


    // $ANTLR start "rule__ProjectVar__Group__1__Impl"
    // InternalQueryDsl.g:6937:1: rule__ProjectVar__Group__1__Impl : ( ':' ) ;
    public final void rule__ProjectVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6941:1: ( ( ':' ) )
            // InternalQueryDsl.g:6942:1: ( ':' )
            {
            // InternalQueryDsl.g:6942:1: ( ':' )
            // InternalQueryDsl.g:6943:2: ':'
            {
             before(grammarAccess.getProjectVarAccess().getColonKeyword_1()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getProjectVarAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectVar__Group__1__Impl"


    // $ANTLR start "rule__ProjectVar__Group__2"
    // InternalQueryDsl.g:6952:1: rule__ProjectVar__Group__2 : rule__ProjectVar__Group__2__Impl ;
    public final void rule__ProjectVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6956:1: ( rule__ProjectVar__Group__2__Impl )
            // InternalQueryDsl.g:6957:2: rule__ProjectVar__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProjectVar__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectVar__Group__2"


    // $ANTLR start "rule__ProjectVar__Group__2__Impl"
    // InternalQueryDsl.g:6963:1: rule__ProjectVar__Group__2__Impl : ( ( rule__ProjectVar__ExpAssignment_2 ) ) ;
    public final void rule__ProjectVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6967:1: ( ( ( rule__ProjectVar__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:6968:1: ( ( rule__ProjectVar__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:6968:1: ( ( rule__ProjectVar__ExpAssignment_2 ) )
            // InternalQueryDsl.g:6969:2: ( rule__ProjectVar__ExpAssignment_2 )
            {
             before(grammarAccess.getProjectVarAccess().getExpAssignment_2()); 
            // InternalQueryDsl.g:6970:2: ( rule__ProjectVar__ExpAssignment_2 )
            // InternalQueryDsl.g:6970:3: rule__ProjectVar__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ProjectVar__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getProjectVarAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectVar__Group__2__Impl"


    // $ANTLR start "rule__MetamodelVar__Group__0"
    // InternalQueryDsl.g:6979:1: rule__MetamodelVar__Group__0 : rule__MetamodelVar__Group__0__Impl rule__MetamodelVar__Group__1 ;
    public final void rule__MetamodelVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6983:1: ( rule__MetamodelVar__Group__0__Impl rule__MetamodelVar__Group__1 )
            // InternalQueryDsl.g:6984:2: rule__MetamodelVar__Group__0__Impl rule__MetamodelVar__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__MetamodelVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MetamodelVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelVar__Group__0"


    // $ANTLR start "rule__MetamodelVar__Group__0__Impl"
    // InternalQueryDsl.g:6991:1: rule__MetamodelVar__Group__0__Impl : ( ruleMetamodelParam ) ;
    public final void rule__MetamodelVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:6995:1: ( ( ruleMetamodelParam ) )
            // InternalQueryDsl.g:6996:1: ( ruleMetamodelParam )
            {
            // InternalQueryDsl.g:6996:1: ( ruleMetamodelParam )
            // InternalQueryDsl.g:6997:2: ruleMetamodelParam
            {
             before(grammarAccess.getMetamodelVarAccess().getMetamodelParamParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMetamodelParam();

            state._fsp--;

             after(grammarAccess.getMetamodelVarAccess().getMetamodelParamParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelVar__Group__0__Impl"


    // $ANTLR start "rule__MetamodelVar__Group__1"
    // InternalQueryDsl.g:7006:1: rule__MetamodelVar__Group__1 : rule__MetamodelVar__Group__1__Impl rule__MetamodelVar__Group__2 ;
    public final void rule__MetamodelVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7010:1: ( rule__MetamodelVar__Group__1__Impl rule__MetamodelVar__Group__2 )
            // InternalQueryDsl.g:7011:2: rule__MetamodelVar__Group__1__Impl rule__MetamodelVar__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__MetamodelVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MetamodelVar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelVar__Group__1"


    // $ANTLR start "rule__MetamodelVar__Group__1__Impl"
    // InternalQueryDsl.g:7018:1: rule__MetamodelVar__Group__1__Impl : ( ':' ) ;
    public final void rule__MetamodelVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7022:1: ( ( ':' ) )
            // InternalQueryDsl.g:7023:1: ( ':' )
            {
            // InternalQueryDsl.g:7023:1: ( ':' )
            // InternalQueryDsl.g:7024:2: ':'
            {
             before(grammarAccess.getMetamodelVarAccess().getColonKeyword_1()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getMetamodelVarAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelVar__Group__1__Impl"


    // $ANTLR start "rule__MetamodelVar__Group__2"
    // InternalQueryDsl.g:7033:1: rule__MetamodelVar__Group__2 : rule__MetamodelVar__Group__2__Impl ;
    public final void rule__MetamodelVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7037:1: ( rule__MetamodelVar__Group__2__Impl )
            // InternalQueryDsl.g:7038:2: rule__MetamodelVar__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MetamodelVar__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelVar__Group__2"


    // $ANTLR start "rule__MetamodelVar__Group__2__Impl"
    // InternalQueryDsl.g:7044:1: rule__MetamodelVar__Group__2__Impl : ( ( rule__MetamodelVar__ExpAssignment_2 ) ) ;
    public final void rule__MetamodelVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7048:1: ( ( ( rule__MetamodelVar__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:7049:1: ( ( rule__MetamodelVar__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:7049:1: ( ( rule__MetamodelVar__ExpAssignment_2 ) )
            // InternalQueryDsl.g:7050:2: ( rule__MetamodelVar__ExpAssignment_2 )
            {
             before(grammarAccess.getMetamodelVarAccess().getExpAssignment_2()); 
            // InternalQueryDsl.g:7051:2: ( rule__MetamodelVar__ExpAssignment_2 )
            // InternalQueryDsl.g:7051:3: rule__MetamodelVar__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__MetamodelVar__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelVarAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelVar__Group__2__Impl"


    // $ANTLR start "rule__ModelVar__Group__0"
    // InternalQueryDsl.g:7060:1: rule__ModelVar__Group__0 : rule__ModelVar__Group__0__Impl rule__ModelVar__Group__1 ;
    public final void rule__ModelVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7064:1: ( rule__ModelVar__Group__0__Impl rule__ModelVar__Group__1 )
            // InternalQueryDsl.g:7065:2: rule__ModelVar__Group__0__Impl rule__ModelVar__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__ModelVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelVar__Group__0"


    // $ANTLR start "rule__ModelVar__Group__0__Impl"
    // InternalQueryDsl.g:7072:1: rule__ModelVar__Group__0__Impl : ( ruleParam ) ;
    public final void rule__ModelVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7076:1: ( ( ruleParam ) )
            // InternalQueryDsl.g:7077:1: ( ruleParam )
            {
            // InternalQueryDsl.g:7077:1: ( ruleParam )
            // InternalQueryDsl.g:7078:2: ruleParam
            {
             before(grammarAccess.getModelVarAccess().getParamParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleParam();

            state._fsp--;

             after(grammarAccess.getModelVarAccess().getParamParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelVar__Group__0__Impl"


    // $ANTLR start "rule__ModelVar__Group__1"
    // InternalQueryDsl.g:7087:1: rule__ModelVar__Group__1 : rule__ModelVar__Group__1__Impl rule__ModelVar__Group__2 ;
    public final void rule__ModelVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7091:1: ( rule__ModelVar__Group__1__Impl rule__ModelVar__Group__2 )
            // InternalQueryDsl.g:7092:2: rule__ModelVar__Group__1__Impl rule__ModelVar__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__ModelVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelVar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelVar__Group__1"


    // $ANTLR start "rule__ModelVar__Group__1__Impl"
    // InternalQueryDsl.g:7099:1: rule__ModelVar__Group__1__Impl : ( ':' ) ;
    public final void rule__ModelVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7103:1: ( ( ':' ) )
            // InternalQueryDsl.g:7104:1: ( ':' )
            {
            // InternalQueryDsl.g:7104:1: ( ':' )
            // InternalQueryDsl.g:7105:2: ':'
            {
             before(grammarAccess.getModelVarAccess().getColonKeyword_1()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getModelVarAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelVar__Group__1__Impl"


    // $ANTLR start "rule__ModelVar__Group__2"
    // InternalQueryDsl.g:7114:1: rule__ModelVar__Group__2 : rule__ModelVar__Group__2__Impl ;
    public final void rule__ModelVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7118:1: ( rule__ModelVar__Group__2__Impl )
            // InternalQueryDsl.g:7119:2: rule__ModelVar__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelVar__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelVar__Group__2"


    // $ANTLR start "rule__ModelVar__Group__2__Impl"
    // InternalQueryDsl.g:7125:1: rule__ModelVar__Group__2__Impl : ( ( rule__ModelVar__ExpAssignment_2 ) ) ;
    public final void rule__ModelVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7129:1: ( ( ( rule__ModelVar__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:7130:1: ( ( rule__ModelVar__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:7130:1: ( ( rule__ModelVar__ExpAssignment_2 ) )
            // InternalQueryDsl.g:7131:2: ( rule__ModelVar__ExpAssignment_2 )
            {
             before(grammarAccess.getModelVarAccess().getExpAssignment_2()); 
            // InternalQueryDsl.g:7132:2: ( rule__ModelVar__ExpAssignment_2 )
            // InternalQueryDsl.g:7132:3: rule__ModelVar__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ModelVar__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelVarAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelVar__Group__2__Impl"


    // $ANTLR start "rule__DslVar__Group__0"
    // InternalQueryDsl.g:7141:1: rule__DslVar__Group__0 : rule__DslVar__Group__0__Impl rule__DslVar__Group__1 ;
    public final void rule__DslVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7145:1: ( rule__DslVar__Group__0__Impl rule__DslVar__Group__1 )
            // InternalQueryDsl.g:7146:2: rule__DslVar__Group__0__Impl rule__DslVar__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__DslVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DslVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DslVar__Group__0"


    // $ANTLR start "rule__DslVar__Group__0__Impl"
    // InternalQueryDsl.g:7153:1: rule__DslVar__Group__0__Impl : ( ruleParam ) ;
    public final void rule__DslVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7157:1: ( ( ruleParam ) )
            // InternalQueryDsl.g:7158:1: ( ruleParam )
            {
            // InternalQueryDsl.g:7158:1: ( ruleParam )
            // InternalQueryDsl.g:7159:2: ruleParam
            {
             before(grammarAccess.getDslVarAccess().getParamParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleParam();

            state._fsp--;

             after(grammarAccess.getDslVarAccess().getParamParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DslVar__Group__0__Impl"


    // $ANTLR start "rule__DslVar__Group__1"
    // InternalQueryDsl.g:7168:1: rule__DslVar__Group__1 : rule__DslVar__Group__1__Impl rule__DslVar__Group__2 ;
    public final void rule__DslVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7172:1: ( rule__DslVar__Group__1__Impl rule__DslVar__Group__2 )
            // InternalQueryDsl.g:7173:2: rule__DslVar__Group__1__Impl rule__DslVar__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__DslVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DslVar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DslVar__Group__1"


    // $ANTLR start "rule__DslVar__Group__1__Impl"
    // InternalQueryDsl.g:7180:1: rule__DslVar__Group__1__Impl : ( ':' ) ;
    public final void rule__DslVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7184:1: ( ( ':' ) )
            // InternalQueryDsl.g:7185:1: ( ':' )
            {
            // InternalQueryDsl.g:7185:1: ( ':' )
            // InternalQueryDsl.g:7186:2: ':'
            {
             before(grammarAccess.getDslVarAccess().getColonKeyword_1()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getDslVarAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DslVar__Group__1__Impl"


    // $ANTLR start "rule__DslVar__Group__2"
    // InternalQueryDsl.g:7195:1: rule__DslVar__Group__2 : rule__DslVar__Group__2__Impl ;
    public final void rule__DslVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7199:1: ( rule__DslVar__Group__2__Impl )
            // InternalQueryDsl.g:7200:2: rule__DslVar__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DslVar__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DslVar__Group__2"


    // $ANTLR start "rule__DslVar__Group__2__Impl"
    // InternalQueryDsl.g:7206:1: rule__DslVar__Group__2__Impl : ( ( rule__DslVar__ExpAssignment_2 ) ) ;
    public final void rule__DslVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7210:1: ( ( ( rule__DslVar__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:7211:1: ( ( rule__DslVar__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:7211:1: ( ( rule__DslVar__ExpAssignment_2 ) )
            // InternalQueryDsl.g:7212:2: ( rule__DslVar__ExpAssignment_2 )
            {
             before(grammarAccess.getDslVarAccess().getExpAssignment_2()); 
            // InternalQueryDsl.g:7213:2: ( rule__DslVar__ExpAssignment_2 )
            // InternalQueryDsl.g:7213:3: rule__DslVar__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DslVar__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDslVarAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DslVar__Group__2__Impl"


    // $ANTLR start "rule__Variable__Group__0"
    // InternalQueryDsl.g:7222:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7226:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalQueryDsl.g:7227:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0"


    // $ANTLR start "rule__Variable__Group__0__Impl"
    // InternalQueryDsl.g:7234:1: rule__Variable__Group__0__Impl : ( 'var' ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7238:1: ( ( 'var' ) )
            // InternalQueryDsl.g:7239:1: ( 'var' )
            {
            // InternalQueryDsl.g:7239:1: ( 'var' )
            // InternalQueryDsl.g:7240:2: 'var'
            {
             before(grammarAccess.getVariableAccess().getVarKeyword_0()); 
            match(input,110,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getVarKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0__Impl"


    // $ANTLR start "rule__Variable__Group__1"
    // InternalQueryDsl.g:7249:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7253:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalQueryDsl.g:7254:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_50);
            rule__Variable__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1"


    // $ANTLR start "rule__Variable__Group__1__Impl"
    // InternalQueryDsl.g:7261:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7265:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalQueryDsl.g:7266:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalQueryDsl.g:7266:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalQueryDsl.g:7267:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalQueryDsl.g:7268:2: ( rule__Variable__NameAssignment_1 )
            // InternalQueryDsl.g:7268:3: rule__Variable__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Variable__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1__Impl"


    // $ANTLR start "rule__Variable__Group__2"
    // InternalQueryDsl.g:7276:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7280:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalQueryDsl.g:7281:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__Variable__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__2"


    // $ANTLR start "rule__Variable__Group__2__Impl"
    // InternalQueryDsl.g:7288:1: rule__Variable__Group__2__Impl : ( '=' ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7292:1: ( ( '=' ) )
            // InternalQueryDsl.g:7293:1: ( '=' )
            {
            // InternalQueryDsl.g:7293:1: ( '=' )
            // InternalQueryDsl.g:7294:2: '='
            {
             before(grammarAccess.getVariableAccess().getEqualsSignKeyword_2()); 
            match(input,111,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__2__Impl"


    // $ANTLR start "rule__Variable__Group__3"
    // InternalQueryDsl.g:7303:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7307:1: ( rule__Variable__Group__3__Impl )
            // InternalQueryDsl.g:7308:2: rule__Variable__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__3"


    // $ANTLR start "rule__Variable__Group__3__Impl"
    // InternalQueryDsl.g:7314:1: rule__Variable__Group__3__Impl : ( ( rule__Variable__ExpressionAssignment_3 ) ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7318:1: ( ( ( rule__Variable__ExpressionAssignment_3 ) ) )
            // InternalQueryDsl.g:7319:1: ( ( rule__Variable__ExpressionAssignment_3 ) )
            {
            // InternalQueryDsl.g:7319:1: ( ( rule__Variable__ExpressionAssignment_3 ) )
            // InternalQueryDsl.g:7320:2: ( rule__Variable__ExpressionAssignment_3 )
            {
             before(grammarAccess.getVariableAccess().getExpressionAssignment_3()); 
            // InternalQueryDsl.g:7321:2: ( rule__Variable__ExpressionAssignment_3 )
            // InternalQueryDsl.g:7321:3: rule__Variable__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Variable__ExpressionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getExpressionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__3__Impl"


    // $ANTLR start "rule__Expression__Group_0__0"
    // InternalQueryDsl.g:7330:1: rule__Expression__Group_0__0 : rule__Expression__Group_0__0__Impl rule__Expression__Group_0__1 ;
    public final void rule__Expression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7334:1: ( rule__Expression__Group_0__0__Impl rule__Expression__Group_0__1 )
            // InternalQueryDsl.g:7335:2: rule__Expression__Group_0__0__Impl rule__Expression__Group_0__1
            {
            pushFollow(FOLLOW_38);
            rule__Expression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_0__0"


    // $ANTLR start "rule__Expression__Group_0__0__Impl"
    // InternalQueryDsl.g:7342:1: rule__Expression__Group_0__0__Impl : ( () ) ;
    public final void rule__Expression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7346:1: ( ( () ) )
            // InternalQueryDsl.g:7347:1: ( () )
            {
            // InternalQueryDsl.g:7347:1: ( () )
            // InternalQueryDsl.g:7348:2: ()
            {
             before(grammarAccess.getExpressionAccess().getIntConstantAction_0_0()); 
            // InternalQueryDsl.g:7349:2: ()
            // InternalQueryDsl.g:7349:3: 
            {
            }

             after(grammarAccess.getExpressionAccess().getIntConstantAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_0__0__Impl"


    // $ANTLR start "rule__Expression__Group_0__1"
    // InternalQueryDsl.g:7357:1: rule__Expression__Group_0__1 : rule__Expression__Group_0__1__Impl ;
    public final void rule__Expression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7361:1: ( rule__Expression__Group_0__1__Impl )
            // InternalQueryDsl.g:7362:2: rule__Expression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_0__1"


    // $ANTLR start "rule__Expression__Group_0__1__Impl"
    // InternalQueryDsl.g:7368:1: rule__Expression__Group_0__1__Impl : ( ( rule__Expression__ValueAssignment_0_1 ) ) ;
    public final void rule__Expression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7372:1: ( ( ( rule__Expression__ValueAssignment_0_1 ) ) )
            // InternalQueryDsl.g:7373:1: ( ( rule__Expression__ValueAssignment_0_1 ) )
            {
            // InternalQueryDsl.g:7373:1: ( ( rule__Expression__ValueAssignment_0_1 ) )
            // InternalQueryDsl.g:7374:2: ( rule__Expression__ValueAssignment_0_1 )
            {
             before(grammarAccess.getExpressionAccess().getValueAssignment_0_1()); 
            // InternalQueryDsl.g:7375:2: ( rule__Expression__ValueAssignment_0_1 )
            // InternalQueryDsl.g:7375:3: rule__Expression__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Expression__ValueAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getValueAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_0__1__Impl"


    // $ANTLR start "rule__Expression__Group_1__0"
    // InternalQueryDsl.g:7384:1: rule__Expression__Group_1__0 : rule__Expression__Group_1__0__Impl rule__Expression__Group_1__1 ;
    public final void rule__Expression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7388:1: ( rule__Expression__Group_1__0__Impl rule__Expression__Group_1__1 )
            // InternalQueryDsl.g:7389:2: rule__Expression__Group_1__0__Impl rule__Expression__Group_1__1
            {
            pushFollow(FOLLOW_51);
            rule__Expression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__0"


    // $ANTLR start "rule__Expression__Group_1__0__Impl"
    // InternalQueryDsl.g:7396:1: rule__Expression__Group_1__0__Impl : ( () ) ;
    public final void rule__Expression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7400:1: ( ( () ) )
            // InternalQueryDsl.g:7401:1: ( () )
            {
            // InternalQueryDsl.g:7401:1: ( () )
            // InternalQueryDsl.g:7402:2: ()
            {
             before(grammarAccess.getExpressionAccess().getStringConstantAction_1_0()); 
            // InternalQueryDsl.g:7403:2: ()
            // InternalQueryDsl.g:7403:3: 
            {
            }

             after(grammarAccess.getExpressionAccess().getStringConstantAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__0__Impl"


    // $ANTLR start "rule__Expression__Group_1__1"
    // InternalQueryDsl.g:7411:1: rule__Expression__Group_1__1 : rule__Expression__Group_1__1__Impl ;
    public final void rule__Expression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7415:1: ( rule__Expression__Group_1__1__Impl )
            // InternalQueryDsl.g:7416:2: rule__Expression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__1"


    // $ANTLR start "rule__Expression__Group_1__1__Impl"
    // InternalQueryDsl.g:7422:1: rule__Expression__Group_1__1__Impl : ( ( rule__Expression__ValueAssignment_1_1 ) ) ;
    public final void rule__Expression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7426:1: ( ( ( rule__Expression__ValueAssignment_1_1 ) ) )
            // InternalQueryDsl.g:7427:1: ( ( rule__Expression__ValueAssignment_1_1 ) )
            {
            // InternalQueryDsl.g:7427:1: ( ( rule__Expression__ValueAssignment_1_1 ) )
            // InternalQueryDsl.g:7428:2: ( rule__Expression__ValueAssignment_1_1 )
            {
             before(grammarAccess.getExpressionAccess().getValueAssignment_1_1()); 
            // InternalQueryDsl.g:7429:2: ( rule__Expression__ValueAssignment_1_1 )
            // InternalQueryDsl.g:7429:3: rule__Expression__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Expression__ValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getValueAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__1__Impl"


    // $ANTLR start "rule__Expression__Group_2__0"
    // InternalQueryDsl.g:7438:1: rule__Expression__Group_2__0 : rule__Expression__Group_2__0__Impl rule__Expression__Group_2__1 ;
    public final void rule__Expression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7442:1: ( rule__Expression__Group_2__0__Impl rule__Expression__Group_2__1 )
            // InternalQueryDsl.g:7443:2: rule__Expression__Group_2__0__Impl rule__Expression__Group_2__1
            {
            pushFollow(FOLLOW_52);
            rule__Expression__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__0"


    // $ANTLR start "rule__Expression__Group_2__0__Impl"
    // InternalQueryDsl.g:7450:1: rule__Expression__Group_2__0__Impl : ( () ) ;
    public final void rule__Expression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7454:1: ( ( () ) )
            // InternalQueryDsl.g:7455:1: ( () )
            {
            // InternalQueryDsl.g:7455:1: ( () )
            // InternalQueryDsl.g:7456:2: ()
            {
             before(grammarAccess.getExpressionAccess().getBoolConstantAction_2_0()); 
            // InternalQueryDsl.g:7457:2: ()
            // InternalQueryDsl.g:7457:3: 
            {
            }

             after(grammarAccess.getExpressionAccess().getBoolConstantAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__0__Impl"


    // $ANTLR start "rule__Expression__Group_2__1"
    // InternalQueryDsl.g:7465:1: rule__Expression__Group_2__1 : rule__Expression__Group_2__1__Impl ;
    public final void rule__Expression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7469:1: ( rule__Expression__Group_2__1__Impl )
            // InternalQueryDsl.g:7470:2: rule__Expression__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__1"


    // $ANTLR start "rule__Expression__Group_2__1__Impl"
    // InternalQueryDsl.g:7476:1: rule__Expression__Group_2__1__Impl : ( ( rule__Expression__ValueAssignment_2_1 ) ) ;
    public final void rule__Expression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7480:1: ( ( ( rule__Expression__ValueAssignment_2_1 ) ) )
            // InternalQueryDsl.g:7481:1: ( ( rule__Expression__ValueAssignment_2_1 ) )
            {
            // InternalQueryDsl.g:7481:1: ( ( rule__Expression__ValueAssignment_2_1 ) )
            // InternalQueryDsl.g:7482:2: ( rule__Expression__ValueAssignment_2_1 )
            {
             before(grammarAccess.getExpressionAccess().getValueAssignment_2_1()); 
            // InternalQueryDsl.g:7483:2: ( rule__Expression__ValueAssignment_2_1 )
            // InternalQueryDsl.g:7483:3: rule__Expression__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Expression__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__1__Impl"


    // $ANTLR start "rule__Expression__Group_3__0"
    // InternalQueryDsl.g:7492:1: rule__Expression__Group_3__0 : rule__Expression__Group_3__0__Impl rule__Expression__Group_3__1 ;
    public final void rule__Expression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7496:1: ( rule__Expression__Group_3__0__Impl rule__Expression__Group_3__1 )
            // InternalQueryDsl.g:7497:2: rule__Expression__Group_3__0__Impl rule__Expression__Group_3__1
            {
            pushFollow(FOLLOW_31);
            rule__Expression__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_3__0"


    // $ANTLR start "rule__Expression__Group_3__0__Impl"
    // InternalQueryDsl.g:7504:1: rule__Expression__Group_3__0__Impl : ( () ) ;
    public final void rule__Expression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7508:1: ( ( () ) )
            // InternalQueryDsl.g:7509:1: ( () )
            {
            // InternalQueryDsl.g:7509:1: ( () )
            // InternalQueryDsl.g:7510:2: ()
            {
             before(grammarAccess.getExpressionAccess().getVariableRefAction_3_0()); 
            // InternalQueryDsl.g:7511:2: ()
            // InternalQueryDsl.g:7511:3: 
            {
            }

             after(grammarAccess.getExpressionAccess().getVariableRefAction_3_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_3__0__Impl"


    // $ANTLR start "rule__Expression__Group_3__1"
    // InternalQueryDsl.g:7519:1: rule__Expression__Group_3__1 : rule__Expression__Group_3__1__Impl ;
    public final void rule__Expression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7523:1: ( rule__Expression__Group_3__1__Impl )
            // InternalQueryDsl.g:7524:2: rule__Expression__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_3__1"


    // $ANTLR start "rule__Expression__Group_3__1__Impl"
    // InternalQueryDsl.g:7530:1: rule__Expression__Group_3__1__Impl : ( ( rule__Expression__VariableAssignment_3_1 ) ) ;
    public final void rule__Expression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7534:1: ( ( ( rule__Expression__VariableAssignment_3_1 ) ) )
            // InternalQueryDsl.g:7535:1: ( ( rule__Expression__VariableAssignment_3_1 ) )
            {
            // InternalQueryDsl.g:7535:1: ( ( rule__Expression__VariableAssignment_3_1 ) )
            // InternalQueryDsl.g:7536:2: ( rule__Expression__VariableAssignment_3_1 )
            {
             before(grammarAccess.getExpressionAccess().getVariableAssignment_3_1()); 
            // InternalQueryDsl.g:7537:2: ( rule__Expression__VariableAssignment_3_1 )
            // InternalQueryDsl.g:7537:3: rule__Expression__VariableAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Expression__VariableAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getVariableAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_3__1__Impl"


    // $ANTLR start "rule__QueryModel__ElementsAssignment"
    // InternalQueryDsl.g:7546:1: rule__QueryModel__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__QueryModel__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7550:1: ( ( ruleAbstractElement ) )
            // InternalQueryDsl.g:7551:2: ( ruleAbstractElement )
            {
            // InternalQueryDsl.g:7551:2: ( ruleAbstractElement )
            // InternalQueryDsl.g:7552:3: ruleAbstractElement
            {
             before(grammarAccess.getQueryModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getQueryModelAccess().getElementsAbstractElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryModel__ElementsAssignment"


    // $ANTLR start "rule__User__UservarAssignment_3"
    // InternalQueryDsl.g:7561:1: rule__User__UservarAssignment_3 : ( ruleUserVar ) ;
    public final void rule__User__UservarAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7565:1: ( ( ruleUserVar ) )
            // InternalQueryDsl.g:7566:2: ( ruleUserVar )
            {
            // InternalQueryDsl.g:7566:2: ( ruleUserVar )
            // InternalQueryDsl.g:7567:3: ruleUserVar
            {
             before(grammarAccess.getUserAccess().getUservarUserVarParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleUserVar();

            state._fsp--;

             after(grammarAccess.getUserAccess().getUservarUserVarParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__UservarAssignment_3"


    // $ANTLR start "rule__User__UservarsAssignment_4_1"
    // InternalQueryDsl.g:7576:1: rule__User__UservarsAssignment_4_1 : ( ruleUserVar ) ;
    public final void rule__User__UservarsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7580:1: ( ( ruleUserVar ) )
            // InternalQueryDsl.g:7581:2: ( ruleUserVar )
            {
            // InternalQueryDsl.g:7581:2: ( ruleUserVar )
            // InternalQueryDsl.g:7582:3: ruleUserVar
            {
             before(grammarAccess.getUserAccess().getUservarsUserVarParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUserVar();

            state._fsp--;

             after(grammarAccess.getUserAccess().getUservarsUserVarParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__UservarsAssignment_4_1"


    // $ANTLR start "rule__User__FieldAssignment_8"
    // InternalQueryDsl.g:7591:1: rule__User__FieldAssignment_8 : ( ruleUserField ) ;
    public final void rule__User__FieldAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7595:1: ( ( ruleUserField ) )
            // InternalQueryDsl.g:7596:2: ( ruleUserField )
            {
            // InternalQueryDsl.g:7596:2: ( ruleUserField )
            // InternalQueryDsl.g:7597:3: ruleUserField
            {
             before(grammarAccess.getUserAccess().getFieldUserFieldParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleUserField();

            state._fsp--;

             after(grammarAccess.getUserAccess().getFieldUserFieldParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__FieldAssignment_8"


    // $ANTLR start "rule__User__FieldsAssignment_9_1"
    // InternalQueryDsl.g:7606:1: rule__User__FieldsAssignment_9_1 : ( ruleUserField ) ;
    public final void rule__User__FieldsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7610:1: ( ( ruleUserField ) )
            // InternalQueryDsl.g:7611:2: ( ruleUserField )
            {
            // InternalQueryDsl.g:7611:2: ( ruleUserField )
            // InternalQueryDsl.g:7612:3: ruleUserField
            {
             before(grammarAccess.getUserAccess().getFieldsUserFieldParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUserField();

            state._fsp--;

             after(grammarAccess.getUserAccess().getFieldsUserFieldParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__FieldsAssignment_9_1"


    // $ANTLR start "rule__Workspace__SpacevarAssignment_3"
    // InternalQueryDsl.g:7621:1: rule__Workspace__SpacevarAssignment_3 : ( ruleWorkspaceVar ) ;
    public final void rule__Workspace__SpacevarAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7625:1: ( ( ruleWorkspaceVar ) )
            // InternalQueryDsl.g:7626:2: ( ruleWorkspaceVar )
            {
            // InternalQueryDsl.g:7626:2: ( ruleWorkspaceVar )
            // InternalQueryDsl.g:7627:3: ruleWorkspaceVar
            {
             before(grammarAccess.getWorkspaceAccess().getSpacevarWorkspaceVarParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkspaceVar();

            state._fsp--;

             after(grammarAccess.getWorkspaceAccess().getSpacevarWorkspaceVarParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__SpacevarAssignment_3"


    // $ANTLR start "rule__Workspace__SpacevarsAssignment_4_1"
    // InternalQueryDsl.g:7636:1: rule__Workspace__SpacevarsAssignment_4_1 : ( ruleWorkspaceVar ) ;
    public final void rule__Workspace__SpacevarsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7640:1: ( ( ruleWorkspaceVar ) )
            // InternalQueryDsl.g:7641:2: ( ruleWorkspaceVar )
            {
            // InternalQueryDsl.g:7641:2: ( ruleWorkspaceVar )
            // InternalQueryDsl.g:7642:3: ruleWorkspaceVar
            {
             before(grammarAccess.getWorkspaceAccess().getSpacevarsWorkspaceVarParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkspaceVar();

            state._fsp--;

             after(grammarAccess.getWorkspaceAccess().getSpacevarsWorkspaceVarParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__SpacevarsAssignment_4_1"


    // $ANTLR start "rule__Workspace__FieldAssignment_8"
    // InternalQueryDsl.g:7651:1: rule__Workspace__FieldAssignment_8 : ( ruleWorkspaceField ) ;
    public final void rule__Workspace__FieldAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7655:1: ( ( ruleWorkspaceField ) )
            // InternalQueryDsl.g:7656:2: ( ruleWorkspaceField )
            {
            // InternalQueryDsl.g:7656:2: ( ruleWorkspaceField )
            // InternalQueryDsl.g:7657:3: ruleWorkspaceField
            {
             before(grammarAccess.getWorkspaceAccess().getFieldWorkspaceFieldParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkspaceField();

            state._fsp--;

             after(grammarAccess.getWorkspaceAccess().getFieldWorkspaceFieldParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__FieldAssignment_8"


    // $ANTLR start "rule__Workspace__FieldsAssignment_9_1"
    // InternalQueryDsl.g:7666:1: rule__Workspace__FieldsAssignment_9_1 : ( ruleWorkspaceField ) ;
    public final void rule__Workspace__FieldsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7670:1: ( ( ruleWorkspaceField ) )
            // InternalQueryDsl.g:7671:2: ( ruleWorkspaceField )
            {
            // InternalQueryDsl.g:7671:2: ( ruleWorkspaceField )
            // InternalQueryDsl.g:7672:3: ruleWorkspaceField
            {
             before(grammarAccess.getWorkspaceAccess().getFieldsWorkspaceFieldParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkspaceField();

            state._fsp--;

             after(grammarAccess.getWorkspaceAccess().getFieldsWorkspaceFieldParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workspace__FieldsAssignment_9_1"


    // $ANTLR start "rule__Project__ProjectvarAssignment_3"
    // InternalQueryDsl.g:7681:1: rule__Project__ProjectvarAssignment_3 : ( ruleProjectVar ) ;
    public final void rule__Project__ProjectvarAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7685:1: ( ( ruleProjectVar ) )
            // InternalQueryDsl.g:7686:2: ( ruleProjectVar )
            {
            // InternalQueryDsl.g:7686:2: ( ruleProjectVar )
            // InternalQueryDsl.g:7687:3: ruleProjectVar
            {
             before(grammarAccess.getProjectAccess().getProjectvarProjectVarParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleProjectVar();

            state._fsp--;

             after(grammarAccess.getProjectAccess().getProjectvarProjectVarParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__ProjectvarAssignment_3"


    // $ANTLR start "rule__Project__ProjectvarsAssignment_4_1"
    // InternalQueryDsl.g:7696:1: rule__Project__ProjectvarsAssignment_4_1 : ( ruleProjectVar ) ;
    public final void rule__Project__ProjectvarsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7700:1: ( ( ruleProjectVar ) )
            // InternalQueryDsl.g:7701:2: ( ruleProjectVar )
            {
            // InternalQueryDsl.g:7701:2: ( ruleProjectVar )
            // InternalQueryDsl.g:7702:3: ruleProjectVar
            {
             before(grammarAccess.getProjectAccess().getProjectvarsProjectVarParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleProjectVar();

            state._fsp--;

             after(grammarAccess.getProjectAccess().getProjectvarsProjectVarParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__ProjectvarsAssignment_4_1"


    // $ANTLR start "rule__Project__FieldAssignment_8"
    // InternalQueryDsl.g:7711:1: rule__Project__FieldAssignment_8 : ( ruleProjectField ) ;
    public final void rule__Project__FieldAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7715:1: ( ( ruleProjectField ) )
            // InternalQueryDsl.g:7716:2: ( ruleProjectField )
            {
            // InternalQueryDsl.g:7716:2: ( ruleProjectField )
            // InternalQueryDsl.g:7717:3: ruleProjectField
            {
             before(grammarAccess.getProjectAccess().getFieldProjectFieldParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleProjectField();

            state._fsp--;

             after(grammarAccess.getProjectAccess().getFieldProjectFieldParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__FieldAssignment_8"


    // $ANTLR start "rule__Project__FieldsAssignment_9_1"
    // InternalQueryDsl.g:7726:1: rule__Project__FieldsAssignment_9_1 : ( ruleProjectField ) ;
    public final void rule__Project__FieldsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7730:1: ( ( ruleProjectField ) )
            // InternalQueryDsl.g:7731:2: ( ruleProjectField )
            {
            // InternalQueryDsl.g:7731:2: ( ruleProjectField )
            // InternalQueryDsl.g:7732:3: ruleProjectField
            {
             before(grammarAccess.getProjectAccess().getFieldsProjectFieldParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleProjectField();

            state._fsp--;

             after(grammarAccess.getProjectAccess().getFieldsProjectFieldParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__FieldsAssignment_9_1"


    // $ANTLR start "rule__Metamodel__MetamodelVarAssignment_3"
    // InternalQueryDsl.g:7741:1: rule__Metamodel__MetamodelVarAssignment_3 : ( ruleMetamodelVar ) ;
    public final void rule__Metamodel__MetamodelVarAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7745:1: ( ( ruleMetamodelVar ) )
            // InternalQueryDsl.g:7746:2: ( ruleMetamodelVar )
            {
            // InternalQueryDsl.g:7746:2: ( ruleMetamodelVar )
            // InternalQueryDsl.g:7747:3: ruleMetamodelVar
            {
             before(grammarAccess.getMetamodelAccess().getMetamodelVarMetamodelVarParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMetamodelVar();

            state._fsp--;

             after(grammarAccess.getMetamodelAccess().getMetamodelVarMetamodelVarParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__MetamodelVarAssignment_3"


    // $ANTLR start "rule__Metamodel__MetamodelVarsAssignment_4_1"
    // InternalQueryDsl.g:7756:1: rule__Metamodel__MetamodelVarsAssignment_4_1 : ( ruleMetamodelVar ) ;
    public final void rule__Metamodel__MetamodelVarsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7760:1: ( ( ruleMetamodelVar ) )
            // InternalQueryDsl.g:7761:2: ( ruleMetamodelVar )
            {
            // InternalQueryDsl.g:7761:2: ( ruleMetamodelVar )
            // InternalQueryDsl.g:7762:3: ruleMetamodelVar
            {
             before(grammarAccess.getMetamodelAccess().getMetamodelVarsMetamodelVarParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMetamodelVar();

            state._fsp--;

             after(grammarAccess.getMetamodelAccess().getMetamodelVarsMetamodelVarParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__MetamodelVarsAssignment_4_1"


    // $ANTLR start "rule__Metamodel__SyntaxAssignment_6_1_0"
    // InternalQueryDsl.g:7771:1: rule__Metamodel__SyntaxAssignment_6_1_0 : ( ruleMicroSyntax ) ;
    public final void rule__Metamodel__SyntaxAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7775:1: ( ( ruleMicroSyntax ) )
            // InternalQueryDsl.g:7776:2: ( ruleMicroSyntax )
            {
            // InternalQueryDsl.g:7776:2: ( ruleMicroSyntax )
            // InternalQueryDsl.g:7777:3: ruleMicroSyntax
            {
             before(grammarAccess.getMetamodelAccess().getSyntaxMicroSyntaxParserRuleCall_6_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMicroSyntax();

            state._fsp--;

             after(grammarAccess.getMetamodelAccess().getSyntaxMicroSyntaxParserRuleCall_6_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__SyntaxAssignment_6_1_0"


    // $ANTLR start "rule__Metamodel__TextSearchAssignment_6_1_1"
    // InternalQueryDsl.g:7786:1: rule__Metamodel__TextSearchAssignment_6_1_1 : ( ruleFullTextSearch ) ;
    public final void rule__Metamodel__TextSearchAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7790:1: ( ( ruleFullTextSearch ) )
            // InternalQueryDsl.g:7791:2: ( ruleFullTextSearch )
            {
            // InternalQueryDsl.g:7791:2: ( ruleFullTextSearch )
            // InternalQueryDsl.g:7792:3: ruleFullTextSearch
            {
             before(grammarAccess.getMetamodelAccess().getTextSearchFullTextSearchParserRuleCall_6_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFullTextSearch();

            state._fsp--;

             after(grammarAccess.getMetamodelAccess().getTextSearchFullTextSearchParserRuleCall_6_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__TextSearchAssignment_6_1_1"


    // $ANTLR start "rule__Metamodel__FilterAssignment_6_1_2"
    // InternalQueryDsl.g:7801:1: rule__Metamodel__FilterAssignment_6_1_2 : ( ruleFilter ) ;
    public final void rule__Metamodel__FilterAssignment_6_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7805:1: ( ( ruleFilter ) )
            // InternalQueryDsl.g:7806:2: ( ruleFilter )
            {
            // InternalQueryDsl.g:7806:2: ( ruleFilter )
            // InternalQueryDsl.g:7807:3: ruleFilter
            {
             before(grammarAccess.getMetamodelAccess().getFilterFilterParserRuleCall_6_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFilter();

            state._fsp--;

             after(grammarAccess.getMetamodelAccess().getFilterFilterParserRuleCall_6_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__FilterAssignment_6_1_2"


    // $ANTLR start "rule__Metamodel__QmAssignment_6_1_3"
    // InternalQueryDsl.g:7816:1: rule__Metamodel__QmAssignment_6_1_3 : ( ruleQualityMetric ) ;
    public final void rule__Metamodel__QmAssignment_6_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7820:1: ( ( ruleQualityMetric ) )
            // InternalQueryDsl.g:7821:2: ( ruleQualityMetric )
            {
            // InternalQueryDsl.g:7821:2: ( ruleQualityMetric )
            // InternalQueryDsl.g:7822:3: ruleQualityMetric
            {
             before(grammarAccess.getMetamodelAccess().getQmQualityMetricParserRuleCall_6_1_3_0()); 
            pushFollow(FOLLOW_2);
            ruleQualityMetric();

            state._fsp--;

             after(grammarAccess.getMetamodelAccess().getQmQualityMetricParserRuleCall_6_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__QmAssignment_6_1_3"


    // $ANTLR start "rule__Metamodel__TransfoAssignment_6_1_4"
    // InternalQueryDsl.g:7831:1: rule__Metamodel__TransfoAssignment_6_1_4 : ( ruleTransformable ) ;
    public final void rule__Metamodel__TransfoAssignment_6_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7835:1: ( ( ruleTransformable ) )
            // InternalQueryDsl.g:7836:2: ( ruleTransformable )
            {
            // InternalQueryDsl.g:7836:2: ( ruleTransformable )
            // InternalQueryDsl.g:7837:3: ruleTransformable
            {
             before(grammarAccess.getMetamodelAccess().getTransfoTransformableParserRuleCall_6_1_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTransformable();

            state._fsp--;

             after(grammarAccess.getMetamodelAccess().getTransfoTransformableParserRuleCall_6_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__TransfoAssignment_6_1_4"


    // $ANTLR start "rule__Metamodel__FieldAssignment_9"
    // InternalQueryDsl.g:7846:1: rule__Metamodel__FieldAssignment_9 : ( ruleMetamodelField ) ;
    public final void rule__Metamodel__FieldAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7850:1: ( ( ruleMetamodelField ) )
            // InternalQueryDsl.g:7851:2: ( ruleMetamodelField )
            {
            // InternalQueryDsl.g:7851:2: ( ruleMetamodelField )
            // InternalQueryDsl.g:7852:3: ruleMetamodelField
            {
             before(grammarAccess.getMetamodelAccess().getFieldMetamodelFieldParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleMetamodelField();

            state._fsp--;

             after(grammarAccess.getMetamodelAccess().getFieldMetamodelFieldParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__FieldAssignment_9"


    // $ANTLR start "rule__Metamodel__FieldsAssignment_10_1"
    // InternalQueryDsl.g:7861:1: rule__Metamodel__FieldsAssignment_10_1 : ( ruleMetamodelField ) ;
    public final void rule__Metamodel__FieldsAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7865:1: ( ( ruleMetamodelField ) )
            // InternalQueryDsl.g:7866:2: ( ruleMetamodelField )
            {
            // InternalQueryDsl.g:7866:2: ( ruleMetamodelField )
            // InternalQueryDsl.g:7867:3: ruleMetamodelField
            {
             before(grammarAccess.getMetamodelAccess().getFieldsMetamodelFieldParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMetamodelField();

            state._fsp--;

             after(grammarAccess.getMetamodelAccess().getFieldsMetamodelFieldParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metamodel__FieldsAssignment_10_1"


    // $ANTLR start "rule__Model__ModelVarAssignment_3"
    // InternalQueryDsl.g:7876:1: rule__Model__ModelVarAssignment_3 : ( ruleModelVar ) ;
    public final void rule__Model__ModelVarAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7880:1: ( ( ruleModelVar ) )
            // InternalQueryDsl.g:7881:2: ( ruleModelVar )
            {
            // InternalQueryDsl.g:7881:2: ( ruleModelVar )
            // InternalQueryDsl.g:7882:3: ruleModelVar
            {
             before(grammarAccess.getModelAccess().getModelVarModelVarParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleModelVar();

            state._fsp--;

             after(grammarAccess.getModelAccess().getModelVarModelVarParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ModelVarAssignment_3"


    // $ANTLR start "rule__Model__ModelVarsAssignment_4_1"
    // InternalQueryDsl.g:7891:1: rule__Model__ModelVarsAssignment_4_1 : ( ruleModelVar ) ;
    public final void rule__Model__ModelVarsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7895:1: ( ( ruleModelVar ) )
            // InternalQueryDsl.g:7896:2: ( ruleModelVar )
            {
            // InternalQueryDsl.g:7896:2: ( ruleModelVar )
            // InternalQueryDsl.g:7897:3: ruleModelVar
            {
             before(grammarAccess.getModelAccess().getModelVarsModelVarParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleModelVar();

            state._fsp--;

             after(grammarAccess.getModelAccess().getModelVarsModelVarParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ModelVarsAssignment_4_1"


    // $ANTLR start "rule__Model__SyntaxAssignment_6_1_0"
    // InternalQueryDsl.g:7906:1: rule__Model__SyntaxAssignment_6_1_0 : ( ruleMicroSyntax ) ;
    public final void rule__Model__SyntaxAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7910:1: ( ( ruleMicroSyntax ) )
            // InternalQueryDsl.g:7911:2: ( ruleMicroSyntax )
            {
            // InternalQueryDsl.g:7911:2: ( ruleMicroSyntax )
            // InternalQueryDsl.g:7912:3: ruleMicroSyntax
            {
             before(grammarAccess.getModelAccess().getSyntaxMicroSyntaxParserRuleCall_6_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMicroSyntax();

            state._fsp--;

             after(grammarAccess.getModelAccess().getSyntaxMicroSyntaxParserRuleCall_6_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__SyntaxAssignment_6_1_0"


    // $ANTLR start "rule__Model__TextSearchAssignment_6_1_1"
    // InternalQueryDsl.g:7921:1: rule__Model__TextSearchAssignment_6_1_1 : ( ruleFullTextSearch ) ;
    public final void rule__Model__TextSearchAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7925:1: ( ( ruleFullTextSearch ) )
            // InternalQueryDsl.g:7926:2: ( ruleFullTextSearch )
            {
            // InternalQueryDsl.g:7926:2: ( ruleFullTextSearch )
            // InternalQueryDsl.g:7927:3: ruleFullTextSearch
            {
             before(grammarAccess.getModelAccess().getTextSearchFullTextSearchParserRuleCall_6_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFullTextSearch();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTextSearchFullTextSearchParserRuleCall_6_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__TextSearchAssignment_6_1_1"


    // $ANTLR start "rule__Model__FilterAssignment_6_1_2"
    // InternalQueryDsl.g:7936:1: rule__Model__FilterAssignment_6_1_2 : ( ruleFilter ) ;
    public final void rule__Model__FilterAssignment_6_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7940:1: ( ( ruleFilter ) )
            // InternalQueryDsl.g:7941:2: ( ruleFilter )
            {
            // InternalQueryDsl.g:7941:2: ( ruleFilter )
            // InternalQueryDsl.g:7942:3: ruleFilter
            {
             before(grammarAccess.getModelAccess().getFilterFilterParserRuleCall_6_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFilter();

            state._fsp--;

             after(grammarAccess.getModelAccess().getFilterFilterParserRuleCall_6_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__FilterAssignment_6_1_2"


    // $ANTLR start "rule__Model__QAssignment_6_1_3"
    // InternalQueryDsl.g:7951:1: rule__Model__QAssignment_6_1_3 : ( ruleModelQuery ) ;
    public final void rule__Model__QAssignment_6_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7955:1: ( ( ruleModelQuery ) )
            // InternalQueryDsl.g:7956:2: ( ruleModelQuery )
            {
            // InternalQueryDsl.g:7956:2: ( ruleModelQuery )
            // InternalQueryDsl.g:7957:3: ruleModelQuery
            {
             before(grammarAccess.getModelAccess().getQModelQueryParserRuleCall_6_1_3_0()); 
            pushFollow(FOLLOW_2);
            ruleModelQuery();

            state._fsp--;

             after(grammarAccess.getModelAccess().getQModelQueryParserRuleCall_6_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__QAssignment_6_1_3"


    // $ANTLR start "rule__Model__FieldAssignment_9"
    // InternalQueryDsl.g:7966:1: rule__Model__FieldAssignment_9 : ( ruleModelField ) ;
    public final void rule__Model__FieldAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7970:1: ( ( ruleModelField ) )
            // InternalQueryDsl.g:7971:2: ( ruleModelField )
            {
            // InternalQueryDsl.g:7971:2: ( ruleModelField )
            // InternalQueryDsl.g:7972:3: ruleModelField
            {
             before(grammarAccess.getModelAccess().getFieldModelFieldParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleModelField();

            state._fsp--;

             after(grammarAccess.getModelAccess().getFieldModelFieldParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__FieldAssignment_9"


    // $ANTLR start "rule__Model__FieldsAssignment_10_1"
    // InternalQueryDsl.g:7981:1: rule__Model__FieldsAssignment_10_1 : ( ruleModelField ) ;
    public final void rule__Model__FieldsAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:7985:1: ( ( ruleModelField ) )
            // InternalQueryDsl.g:7986:2: ( ruleModelField )
            {
            // InternalQueryDsl.g:7986:2: ( ruleModelField )
            // InternalQueryDsl.g:7987:3: ruleModelField
            {
             before(grammarAccess.getModelAccess().getFieldsModelFieldParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleModelField();

            state._fsp--;

             after(grammarAccess.getModelAccess().getFieldsModelFieldParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__FieldsAssignment_10_1"


    // $ANTLR start "rule__Dsl__DslVarAssignment_3"
    // InternalQueryDsl.g:7996:1: rule__Dsl__DslVarAssignment_3 : ( ruleDslVar ) ;
    public final void rule__Dsl__DslVarAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8000:1: ( ( ruleDslVar ) )
            // InternalQueryDsl.g:8001:2: ( ruleDslVar )
            {
            // InternalQueryDsl.g:8001:2: ( ruleDslVar )
            // InternalQueryDsl.g:8002:3: ruleDslVar
            {
             before(grammarAccess.getDslAccess().getDslVarDslVarParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDslVar();

            state._fsp--;

             after(grammarAccess.getDslAccess().getDslVarDslVarParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__DslVarAssignment_3"


    // $ANTLR start "rule__Dsl__DslVarsAssignment_4_1"
    // InternalQueryDsl.g:8011:1: rule__Dsl__DslVarsAssignment_4_1 : ( ruleDslVar ) ;
    public final void rule__Dsl__DslVarsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8015:1: ( ( ruleDslVar ) )
            // InternalQueryDsl.g:8016:2: ( ruleDslVar )
            {
            // InternalQueryDsl.g:8016:2: ( ruleDslVar )
            // InternalQueryDsl.g:8017:3: ruleDslVar
            {
             before(grammarAccess.getDslAccess().getDslVarsDslVarParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDslVar();

            state._fsp--;

             after(grammarAccess.getDslAccess().getDslVarsDslVarParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__DslVarsAssignment_4_1"


    // $ANTLR start "rule__Dsl__SyntaxAssignment_6_1_0"
    // InternalQueryDsl.g:8026:1: rule__Dsl__SyntaxAssignment_6_1_0 : ( ruleMicroSyntax ) ;
    public final void rule__Dsl__SyntaxAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8030:1: ( ( ruleMicroSyntax ) )
            // InternalQueryDsl.g:8031:2: ( ruleMicroSyntax )
            {
            // InternalQueryDsl.g:8031:2: ( ruleMicroSyntax )
            // InternalQueryDsl.g:8032:3: ruleMicroSyntax
            {
             before(grammarAccess.getDslAccess().getSyntaxMicroSyntaxParserRuleCall_6_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMicroSyntax();

            state._fsp--;

             after(grammarAccess.getDslAccess().getSyntaxMicroSyntaxParserRuleCall_6_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__SyntaxAssignment_6_1_0"


    // $ANTLR start "rule__Dsl__TextSearchAssignment_6_1_1"
    // InternalQueryDsl.g:8041:1: rule__Dsl__TextSearchAssignment_6_1_1 : ( ruleFullTextSearch ) ;
    public final void rule__Dsl__TextSearchAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8045:1: ( ( ruleFullTextSearch ) )
            // InternalQueryDsl.g:8046:2: ( ruleFullTextSearch )
            {
            // InternalQueryDsl.g:8046:2: ( ruleFullTextSearch )
            // InternalQueryDsl.g:8047:3: ruleFullTextSearch
            {
             before(grammarAccess.getDslAccess().getTextSearchFullTextSearchParserRuleCall_6_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFullTextSearch();

            state._fsp--;

             after(grammarAccess.getDslAccess().getTextSearchFullTextSearchParserRuleCall_6_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__TextSearchAssignment_6_1_1"


    // $ANTLR start "rule__Dsl__FilterAssignment_6_1_2"
    // InternalQueryDsl.g:8056:1: rule__Dsl__FilterAssignment_6_1_2 : ( ruleFilter ) ;
    public final void rule__Dsl__FilterAssignment_6_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8060:1: ( ( ruleFilter ) )
            // InternalQueryDsl.g:8061:2: ( ruleFilter )
            {
            // InternalQueryDsl.g:8061:2: ( ruleFilter )
            // InternalQueryDsl.g:8062:3: ruleFilter
            {
             before(grammarAccess.getDslAccess().getFilterFilterParserRuleCall_6_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFilter();

            state._fsp--;

             after(grammarAccess.getDslAccess().getFilterFilterParserRuleCall_6_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__FilterAssignment_6_1_2"


    // $ANTLR start "rule__Dsl__FieldAssignment_9"
    // InternalQueryDsl.g:8071:1: rule__Dsl__FieldAssignment_9 : ( ruleDslField ) ;
    public final void rule__Dsl__FieldAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8075:1: ( ( ruleDslField ) )
            // InternalQueryDsl.g:8076:2: ( ruleDslField )
            {
            // InternalQueryDsl.g:8076:2: ( ruleDslField )
            // InternalQueryDsl.g:8077:3: ruleDslField
            {
             before(grammarAccess.getDslAccess().getFieldDslFieldParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleDslField();

            state._fsp--;

             after(grammarAccess.getDslAccess().getFieldDslFieldParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__FieldAssignment_9"


    // $ANTLR start "rule__Dsl__FieldsAssignment_10_1"
    // InternalQueryDsl.g:8086:1: rule__Dsl__FieldsAssignment_10_1 : ( ruleDslField ) ;
    public final void rule__Dsl__FieldsAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8090:1: ( ( ruleDslField ) )
            // InternalQueryDsl.g:8091:2: ( ruleDslField )
            {
            // InternalQueryDsl.g:8091:2: ( ruleDslField )
            // InternalQueryDsl.g:8092:3: ruleDslField
            {
             before(grammarAccess.getDslAccess().getFieldsDslFieldParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDslField();

            state._fsp--;

             after(grammarAccess.getDslAccess().getFieldsDslFieldParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dsl__FieldsAssignment_10_1"


    // $ANTLR start "rule__MicroSyntax__ExpAssignment_2"
    // InternalQueryDsl.g:8101:1: rule__MicroSyntax__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__MicroSyntax__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8105:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8106:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8106:2: ( ruleExpression )
            // InternalQueryDsl.g:8107:3: ruleExpression
            {
             before(grammarAccess.getMicroSyntaxAccess().getExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getMicroSyntaxAccess().getExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MicroSyntax__ExpAssignment_2"


    // $ANTLR start "rule__ModelQuery__ExprAssignment_6"
    // InternalQueryDsl.g:8116:1: rule__ModelQuery__ExprAssignment_6 : ( ruleExpression ) ;
    public final void rule__ModelQuery__ExprAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8120:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8121:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8121:2: ( ruleExpression )
            // InternalQueryDsl.g:8122:3: ruleExpression
            {
             before(grammarAccess.getModelQueryAccess().getExprExpressionParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getModelQueryAccess().getExprExpressionParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelQuery__ExprAssignment_6"


    // $ANTLR start "rule__FullTextSearch__ExpAssignment_2"
    // InternalQueryDsl.g:8131:1: rule__FullTextSearch__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__FullTextSearch__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8135:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8136:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8136:2: ( ruleExpression )
            // InternalQueryDsl.g:8137:3: ruleExpression
            {
             before(grammarAccess.getFullTextSearchAccess().getExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getFullTextSearchAccess().getExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__ExpAssignment_2"


    // $ANTLR start "rule__FullTextSearch__ExpsAssignment_3_1"
    // InternalQueryDsl.g:8146:1: rule__FullTextSearch__ExpsAssignment_3_1 : ( ruleExpression ) ;
    public final void rule__FullTextSearch__ExpsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8150:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8151:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8151:2: ( ruleExpression )
            // InternalQueryDsl.g:8152:3: ruleExpression
            {
             before(grammarAccess.getFullTextSearchAccess().getExpsExpressionParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getFullTextSearchAccess().getExpsExpressionParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__ExpsAssignment_3_1"


    // $ANTLR start "rule__FullTextSearch__OpAssignment_4_1_3"
    // InternalQueryDsl.g:8161:1: rule__FullTextSearch__OpAssignment_4_1_3 : ( ruleOperator ) ;
    public final void rule__FullTextSearch__OpAssignment_4_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8165:1: ( ( ruleOperator ) )
            // InternalQueryDsl.g:8166:2: ( ruleOperator )
            {
            // InternalQueryDsl.g:8166:2: ( ruleOperator )
            // InternalQueryDsl.g:8167:3: ruleOperator
            {
             before(grammarAccess.getFullTextSearchAccess().getOpOperatorParserRuleCall_4_1_3_0()); 
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getFullTextSearchAccess().getOpOperatorParserRuleCall_4_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FullTextSearch__OpAssignment_4_1_3"


    // $ANTLR start "rule__QualityMetric__QExpAssignment_2"
    // InternalQueryDsl.g:8176:1: rule__QualityMetric__QExpAssignment_2 : ( ruleQExp ) ;
    public final void rule__QualityMetric__QExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8180:1: ( ( ruleQExp ) )
            // InternalQueryDsl.g:8181:2: ( ruleQExp )
            {
            // InternalQueryDsl.g:8181:2: ( ruleQExp )
            // InternalQueryDsl.g:8182:3: ruleQExp
            {
             before(grammarAccess.getQualityMetricAccess().getQExpQExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleQExp();

            state._fsp--;

             after(grammarAccess.getQualityMetricAccess().getQExpQExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__QExpAssignment_2"


    // $ANTLR start "rule__QualityMetric__OperatorAssignment_3_0"
    // InternalQueryDsl.g:8191:1: rule__QualityMetric__OperatorAssignment_3_0 : ( ruleOperator ) ;
    public final void rule__QualityMetric__OperatorAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8195:1: ( ( ruleOperator ) )
            // InternalQueryDsl.g:8196:2: ( ruleOperator )
            {
            // InternalQueryDsl.g:8196:2: ( ruleOperator )
            // InternalQueryDsl.g:8197:3: ruleOperator
            {
             before(grammarAccess.getQualityMetricAccess().getOperatorOperatorParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getQualityMetricAccess().getOperatorOperatorParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__OperatorAssignment_3_0"


    // $ANTLR start "rule__QualityMetric__QExpsAssignment_3_1"
    // InternalQueryDsl.g:8206:1: rule__QualityMetric__QExpsAssignment_3_1 : ( ruleQExp ) ;
    public final void rule__QualityMetric__QExpsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8210:1: ( ( ruleQExp ) )
            // InternalQueryDsl.g:8211:2: ( ruleQExp )
            {
            // InternalQueryDsl.g:8211:2: ( ruleQExp )
            // InternalQueryDsl.g:8212:3: ruleQExp
            {
             before(grammarAccess.getQualityMetricAccess().getQExpsQExpParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQExp();

            state._fsp--;

             after(grammarAccess.getQualityMetricAccess().getQExpsQExpParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityMetric__QExpsAssignment_3_1"


    // $ANTLR start "rule__Transformable__ParamAssignment_2_0"
    // InternalQueryDsl.g:8221:1: rule__Transformable__ParamAssignment_2_0 : ( ruleTransParam ) ;
    public final void rule__Transformable__ParamAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8225:1: ( ( ruleTransParam ) )
            // InternalQueryDsl.g:8226:2: ( ruleTransParam )
            {
            // InternalQueryDsl.g:8226:2: ( ruleTransParam )
            // InternalQueryDsl.g:8227:3: ruleTransParam
            {
             before(grammarAccess.getTransformableAccess().getParamTransParamParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTransParam();

            state._fsp--;

             after(grammarAccess.getTransformableAccess().getParamTransParamParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__ParamAssignment_2_0"


    // $ANTLR start "rule__Transformable__ExpAssignment_2_2"
    // InternalQueryDsl.g:8236:1: rule__Transformable__ExpAssignment_2_2 : ( ruleExpression ) ;
    public final void rule__Transformable__ExpAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8240:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8241:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8241:2: ( ruleExpression )
            // InternalQueryDsl.g:8242:3: ruleExpression
            {
             before(grammarAccess.getTransformableAccess().getExpExpressionParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getTransformableAccess().getExpExpressionParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__ExpAssignment_2_2"


    // $ANTLR start "rule__Transformable__ParamAssignment_3_1"
    // InternalQueryDsl.g:8251:1: rule__Transformable__ParamAssignment_3_1 : ( ruleTransParam ) ;
    public final void rule__Transformable__ParamAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8255:1: ( ( ruleTransParam ) )
            // InternalQueryDsl.g:8256:2: ( ruleTransParam )
            {
            // InternalQueryDsl.g:8256:2: ( ruleTransParam )
            // InternalQueryDsl.g:8257:3: ruleTransParam
            {
             before(grammarAccess.getTransformableAccess().getParamTransParamParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransParam();

            state._fsp--;

             after(grammarAccess.getTransformableAccess().getParamTransParamParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__ParamAssignment_3_1"


    // $ANTLR start "rule__Transformable__ExpAssignment_3_3"
    // InternalQueryDsl.g:8266:1: rule__Transformable__ExpAssignment_3_3 : ( ruleExpression ) ;
    public final void rule__Transformable__ExpAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8270:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8271:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8271:2: ( ruleExpression )
            // InternalQueryDsl.g:8272:3: ruleExpression
            {
             before(grammarAccess.getTransformableAccess().getExpExpressionParserRuleCall_3_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getTransformableAccess().getExpExpressionParserRuleCall_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformable__ExpAssignment_3_3"


    // $ANTLR start "rule__TransParam__TypeAssignment"
    // InternalQueryDsl.g:8281:1: rule__TransParam__TypeAssignment : ( ( rule__TransParam__TypeAlternatives_0 ) ) ;
    public final void rule__TransParam__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8285:1: ( ( ( rule__TransParam__TypeAlternatives_0 ) ) )
            // InternalQueryDsl.g:8286:2: ( ( rule__TransParam__TypeAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8286:2: ( ( rule__TransParam__TypeAlternatives_0 ) )
            // InternalQueryDsl.g:8287:3: ( rule__TransParam__TypeAlternatives_0 )
            {
             before(grammarAccess.getTransParamAccess().getTypeAlternatives_0()); 
            // InternalQueryDsl.g:8288:3: ( rule__TransParam__TypeAlternatives_0 )
            // InternalQueryDsl.g:8288:4: rule__TransParam__TypeAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__TransParam__TypeAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTransParamAccess().getTypeAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransParam__TypeAssignment"


    // $ANTLR start "rule__QExp__QAttrAssignment_0"
    // InternalQueryDsl.g:8296:1: rule__QExp__QAttrAssignment_0 : ( ruleQattribute ) ;
    public final void rule__QExp__QAttrAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8300:1: ( ( ruleQattribute ) )
            // InternalQueryDsl.g:8301:2: ( ruleQattribute )
            {
            // InternalQueryDsl.g:8301:2: ( ruleQattribute )
            // InternalQueryDsl.g:8302:3: ruleQattribute
            {
             before(grammarAccess.getQExpAccess().getQAttrQattributeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleQattribute();

            state._fsp--;

             after(grammarAccess.getQExpAccess().getQAttrQattributeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QExp__QAttrAssignment_0"


    // $ANTLR start "rule__QExp__CompAssignment_1"
    // InternalQueryDsl.g:8311:1: rule__QExp__CompAssignment_1 : ( ruleComparison ) ;
    public final void rule__QExp__CompAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8315:1: ( ( ruleComparison ) )
            // InternalQueryDsl.g:8316:2: ( ruleComparison )
            {
            // InternalQueryDsl.g:8316:2: ( ruleComparison )
            // InternalQueryDsl.g:8317:3: ruleComparison
            {
             before(grammarAccess.getQExpAccess().getCompComparisonParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getQExpAccess().getCompComparisonParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QExp__CompAssignment_1"


    // $ANTLR start "rule__QExp__NAssignment_2"
    // InternalQueryDsl.g:8326:1: rule__QExp__NAssignment_2 : ( RULE_INT ) ;
    public final void rule__QExp__NAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8330:1: ( ( RULE_INT ) )
            // InternalQueryDsl.g:8331:2: ( RULE_INT )
            {
            // InternalQueryDsl.g:8331:2: ( RULE_INT )
            // InternalQueryDsl.g:8332:3: RULE_INT
            {
             before(grammarAccess.getQExpAccess().getNINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getQExpAccess().getNINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QExp__NAssignment_2"


    // $ANTLR start "rule__Qattribute__TypeAssignment"
    // InternalQueryDsl.g:8341:1: rule__Qattribute__TypeAssignment : ( ( rule__Qattribute__TypeAlternatives_0 ) ) ;
    public final void rule__Qattribute__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8345:1: ( ( ( rule__Qattribute__TypeAlternatives_0 ) ) )
            // InternalQueryDsl.g:8346:2: ( ( rule__Qattribute__TypeAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8346:2: ( ( rule__Qattribute__TypeAlternatives_0 ) )
            // InternalQueryDsl.g:8347:3: ( rule__Qattribute__TypeAlternatives_0 )
            {
             before(grammarAccess.getQattributeAccess().getTypeAlternatives_0()); 
            // InternalQueryDsl.g:8348:3: ( rule__Qattribute__TypeAlternatives_0 )
            // InternalQueryDsl.g:8348:4: rule__Qattribute__TypeAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Qattribute__TypeAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getQattributeAccess().getTypeAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qattribute__TypeAssignment"


    // $ANTLR start "rule__Operator__OpAssignment"
    // InternalQueryDsl.g:8356:1: rule__Operator__OpAssignment : ( ( rule__Operator__OpAlternatives_0 ) ) ;
    public final void rule__Operator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8360:1: ( ( ( rule__Operator__OpAlternatives_0 ) ) )
            // InternalQueryDsl.g:8361:2: ( ( rule__Operator__OpAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8361:2: ( ( rule__Operator__OpAlternatives_0 ) )
            // InternalQueryDsl.g:8362:3: ( rule__Operator__OpAlternatives_0 )
            {
             before(grammarAccess.getOperatorAccess().getOpAlternatives_0()); 
            // InternalQueryDsl.g:8363:3: ( rule__Operator__OpAlternatives_0 )
            // InternalQueryDsl.g:8363:4: rule__Operator__OpAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Operator__OpAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getOpAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__OpAssignment"


    // $ANTLR start "rule__Filter__FilterExpAssignment_2"
    // InternalQueryDsl.g:8371:1: rule__Filter__FilterExpAssignment_2 : ( ruleFilterExp ) ;
    public final void rule__Filter__FilterExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8375:1: ( ( ruleFilterExp ) )
            // InternalQueryDsl.g:8376:2: ( ruleFilterExp )
            {
            // InternalQueryDsl.g:8376:2: ( ruleFilterExp )
            // InternalQueryDsl.g:8377:3: ruleFilterExp
            {
             before(grammarAccess.getFilterAccess().getFilterExpFilterExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFilterExp();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getFilterExpFilterExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__FilterExpAssignment_2"


    // $ANTLR start "rule__Filter__FilterExpsAssignment_3_1"
    // InternalQueryDsl.g:8386:1: rule__Filter__FilterExpsAssignment_3_1 : ( ruleFilterExp ) ;
    public final void rule__Filter__FilterExpsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8390:1: ( ( ruleFilterExp ) )
            // InternalQueryDsl.g:8391:2: ( ruleFilterExp )
            {
            // InternalQueryDsl.g:8391:2: ( ruleFilterExp )
            // InternalQueryDsl.g:8392:3: ruleFilterExp
            {
             before(grammarAccess.getFilterAccess().getFilterExpsFilterExpParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFilterExp();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getFilterExpsFilterExpParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__FilterExpsAssignment_3_1"


    // $ANTLR start "rule__Filter__CompAssignment_4_3"
    // InternalQueryDsl.g:8401:1: rule__Filter__CompAssignment_4_3 : ( ruleComparison ) ;
    public final void rule__Filter__CompAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8405:1: ( ( ruleComparison ) )
            // InternalQueryDsl.g:8406:2: ( ruleComparison )
            {
            // InternalQueryDsl.g:8406:2: ( ruleComparison )
            // InternalQueryDsl.g:8407:3: ruleComparison
            {
             before(grammarAccess.getFilterAccess().getCompComparisonParserRuleCall_4_3_0()); 
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getCompComparisonParserRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__CompAssignment_4_3"


    // $ANTLR start "rule__Filter__ExpAssignment_4_4"
    // InternalQueryDsl.g:8416:1: rule__Filter__ExpAssignment_4_4 : ( ruleExpression ) ;
    public final void rule__Filter__ExpAssignment_4_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8420:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8421:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8421:2: ( ruleExpression )
            // InternalQueryDsl.g:8422:3: ruleExpression
            {
             before(grammarAccess.getFilterAccess().getExpExpressionParserRuleCall_4_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getExpExpressionParserRuleCall_4_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__ExpAssignment_4_4"


    // $ANTLR start "rule__FilterExp__FilterkeyAssignment_0"
    // InternalQueryDsl.g:8431:1: rule__FilterExp__FilterkeyAssignment_0 : ( ruleFilterKeyword ) ;
    public final void rule__FilterExp__FilterkeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8435:1: ( ( ruleFilterKeyword ) )
            // InternalQueryDsl.g:8436:2: ( ruleFilterKeyword )
            {
            // InternalQueryDsl.g:8436:2: ( ruleFilterKeyword )
            // InternalQueryDsl.g:8437:3: ruleFilterKeyword
            {
             before(grammarAccess.getFilterExpAccess().getFilterkeyFilterKeywordParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleFilterKeyword();

            state._fsp--;

             after(grammarAccess.getFilterExpAccess().getFilterkeyFilterKeywordParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterExp__FilterkeyAssignment_0"


    // $ANTLR start "rule__FilterExp__ExpAssignment_2"
    // InternalQueryDsl.g:8446:1: rule__FilterExp__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__FilterExp__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8450:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8451:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8451:2: ( ruleExpression )
            // InternalQueryDsl.g:8452:3: ruleExpression
            {
             before(grammarAccess.getFilterExpAccess().getExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getFilterExpAccess().getExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterExp__ExpAssignment_2"


    // $ANTLR start "rule__Comparison__TypeAssignment"
    // InternalQueryDsl.g:8461:1: rule__Comparison__TypeAssignment : ( ( rule__Comparison__TypeAlternatives_0 ) ) ;
    public final void rule__Comparison__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8465:1: ( ( ( rule__Comparison__TypeAlternatives_0 ) ) )
            // InternalQueryDsl.g:8466:2: ( ( rule__Comparison__TypeAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8466:2: ( ( rule__Comparison__TypeAlternatives_0 ) )
            // InternalQueryDsl.g:8467:3: ( rule__Comparison__TypeAlternatives_0 )
            {
             before(grammarAccess.getComparisonAccess().getTypeAlternatives_0()); 
            // InternalQueryDsl.g:8468:3: ( rule__Comparison__TypeAlternatives_0 )
            // InternalQueryDsl.g:8468:4: rule__Comparison__TypeAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__TypeAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getTypeAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__TypeAssignment"


    // $ANTLR start "rule__FilterKeyword__TypeAssignment"
    // InternalQueryDsl.g:8476:1: rule__FilterKeyword__TypeAssignment : ( ( rule__FilterKeyword__TypeAlternatives_0 ) ) ;
    public final void rule__FilterKeyword__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8480:1: ( ( ( rule__FilterKeyword__TypeAlternatives_0 ) ) )
            // InternalQueryDsl.g:8481:2: ( ( rule__FilterKeyword__TypeAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8481:2: ( ( rule__FilterKeyword__TypeAlternatives_0 ) )
            // InternalQueryDsl.g:8482:3: ( rule__FilterKeyword__TypeAlternatives_0 )
            {
             before(grammarAccess.getFilterKeywordAccess().getTypeAlternatives_0()); 
            // InternalQueryDsl.g:8483:3: ( rule__FilterKeyword__TypeAlternatives_0 )
            // InternalQueryDsl.g:8483:4: rule__FilterKeyword__TypeAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__FilterKeyword__TypeAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getFilterKeywordAccess().getTypeAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterKeyword__TypeAssignment"


    // $ANTLR start "rule__UserVar__ExpAssignment_2"
    // InternalQueryDsl.g:8491:1: rule__UserVar__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__UserVar__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8495:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8496:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8496:2: ( ruleExpression )
            // InternalQueryDsl.g:8497:3: ruleExpression
            {
             before(grammarAccess.getUserVarAccess().getExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getUserVarAccess().getExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserVar__ExpAssignment_2"


    // $ANTLR start "rule__WorkspaceVar__ExpAssignment_2"
    // InternalQueryDsl.g:8506:1: rule__WorkspaceVar__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__WorkspaceVar__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8510:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8511:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8511:2: ( ruleExpression )
            // InternalQueryDsl.g:8512:3: ruleExpression
            {
             before(grammarAccess.getWorkspaceVarAccess().getExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getWorkspaceVarAccess().getExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceVar__ExpAssignment_2"


    // $ANTLR start "rule__ProjectVar__ExpAssignment_2"
    // InternalQueryDsl.g:8521:1: rule__ProjectVar__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__ProjectVar__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8525:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8526:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8526:2: ( ruleExpression )
            // InternalQueryDsl.g:8527:3: ruleExpression
            {
             before(grammarAccess.getProjectVarAccess().getExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getProjectVarAccess().getExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectVar__ExpAssignment_2"


    // $ANTLR start "rule__MetamodelVar__ExpAssignment_2"
    // InternalQueryDsl.g:8536:1: rule__MetamodelVar__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__MetamodelVar__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8540:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8541:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8541:2: ( ruleExpression )
            // InternalQueryDsl.g:8542:3: ruleExpression
            {
             before(grammarAccess.getMetamodelVarAccess().getExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getMetamodelVarAccess().getExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelVar__ExpAssignment_2"


    // $ANTLR start "rule__ModelVar__ExpAssignment_2"
    // InternalQueryDsl.g:8551:1: rule__ModelVar__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__ModelVar__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8555:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8556:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8556:2: ( ruleExpression )
            // InternalQueryDsl.g:8557:3: ruleExpression
            {
             before(grammarAccess.getModelVarAccess().getExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getModelVarAccess().getExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelVar__ExpAssignment_2"


    // $ANTLR start "rule__DslVar__ExpAssignment_2"
    // InternalQueryDsl.g:8566:1: rule__DslVar__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__DslVar__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8570:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8571:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8571:2: ( ruleExpression )
            // InternalQueryDsl.g:8572:3: ruleExpression
            {
             before(grammarAccess.getDslVarAccess().getExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getDslVarAccess().getExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DslVar__ExpAssignment_2"


    // $ANTLR start "rule__UserField__TypeNameAssignment"
    // InternalQueryDsl.g:8581:1: rule__UserField__TypeNameAssignment : ( ( rule__UserField__TypeNameAlternatives_0 ) ) ;
    public final void rule__UserField__TypeNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8585:1: ( ( ( rule__UserField__TypeNameAlternatives_0 ) ) )
            // InternalQueryDsl.g:8586:2: ( ( rule__UserField__TypeNameAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8586:2: ( ( rule__UserField__TypeNameAlternatives_0 ) )
            // InternalQueryDsl.g:8587:3: ( rule__UserField__TypeNameAlternatives_0 )
            {
             before(grammarAccess.getUserFieldAccess().getTypeNameAlternatives_0()); 
            // InternalQueryDsl.g:8588:3: ( rule__UserField__TypeNameAlternatives_0 )
            // InternalQueryDsl.g:8588:4: rule__UserField__TypeNameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__UserField__TypeNameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getUserFieldAccess().getTypeNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserField__TypeNameAssignment"


    // $ANTLR start "rule__WorkspaceField__TypeNameAssignment"
    // InternalQueryDsl.g:8596:1: rule__WorkspaceField__TypeNameAssignment : ( ( rule__WorkspaceField__TypeNameAlternatives_0 ) ) ;
    public final void rule__WorkspaceField__TypeNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8600:1: ( ( ( rule__WorkspaceField__TypeNameAlternatives_0 ) ) )
            // InternalQueryDsl.g:8601:2: ( ( rule__WorkspaceField__TypeNameAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8601:2: ( ( rule__WorkspaceField__TypeNameAlternatives_0 ) )
            // InternalQueryDsl.g:8602:3: ( rule__WorkspaceField__TypeNameAlternatives_0 )
            {
             before(grammarAccess.getWorkspaceFieldAccess().getTypeNameAlternatives_0()); 
            // InternalQueryDsl.g:8603:3: ( rule__WorkspaceField__TypeNameAlternatives_0 )
            // InternalQueryDsl.g:8603:4: rule__WorkspaceField__TypeNameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__WorkspaceField__TypeNameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceFieldAccess().getTypeNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceField__TypeNameAssignment"


    // $ANTLR start "rule__ProjectField__TypeNameAssignment"
    // InternalQueryDsl.g:8611:1: rule__ProjectField__TypeNameAssignment : ( ( rule__ProjectField__TypeNameAlternatives_0 ) ) ;
    public final void rule__ProjectField__TypeNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8615:1: ( ( ( rule__ProjectField__TypeNameAlternatives_0 ) ) )
            // InternalQueryDsl.g:8616:2: ( ( rule__ProjectField__TypeNameAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8616:2: ( ( rule__ProjectField__TypeNameAlternatives_0 ) )
            // InternalQueryDsl.g:8617:3: ( rule__ProjectField__TypeNameAlternatives_0 )
            {
             before(grammarAccess.getProjectFieldAccess().getTypeNameAlternatives_0()); 
            // InternalQueryDsl.g:8618:3: ( rule__ProjectField__TypeNameAlternatives_0 )
            // InternalQueryDsl.g:8618:4: rule__ProjectField__TypeNameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ProjectField__TypeNameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getProjectFieldAccess().getTypeNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectField__TypeNameAssignment"


    // $ANTLR start "rule__MetamodelField__TypeNameAssignment"
    // InternalQueryDsl.g:8626:1: rule__MetamodelField__TypeNameAssignment : ( ( rule__MetamodelField__TypeNameAlternatives_0 ) ) ;
    public final void rule__MetamodelField__TypeNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8630:1: ( ( ( rule__MetamodelField__TypeNameAlternatives_0 ) ) )
            // InternalQueryDsl.g:8631:2: ( ( rule__MetamodelField__TypeNameAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8631:2: ( ( rule__MetamodelField__TypeNameAlternatives_0 ) )
            // InternalQueryDsl.g:8632:3: ( rule__MetamodelField__TypeNameAlternatives_0 )
            {
             before(grammarAccess.getMetamodelFieldAccess().getTypeNameAlternatives_0()); 
            // InternalQueryDsl.g:8633:3: ( rule__MetamodelField__TypeNameAlternatives_0 )
            // InternalQueryDsl.g:8633:4: rule__MetamodelField__TypeNameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__MetamodelField__TypeNameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getMetamodelFieldAccess().getTypeNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetamodelField__TypeNameAssignment"


    // $ANTLR start "rule__ModelField__TypeNameAssignment"
    // InternalQueryDsl.g:8641:1: rule__ModelField__TypeNameAssignment : ( ( rule__ModelField__TypeNameAlternatives_0 ) ) ;
    public final void rule__ModelField__TypeNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8645:1: ( ( ( rule__ModelField__TypeNameAlternatives_0 ) ) )
            // InternalQueryDsl.g:8646:2: ( ( rule__ModelField__TypeNameAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8646:2: ( ( rule__ModelField__TypeNameAlternatives_0 ) )
            // InternalQueryDsl.g:8647:3: ( rule__ModelField__TypeNameAlternatives_0 )
            {
             before(grammarAccess.getModelFieldAccess().getTypeNameAlternatives_0()); 
            // InternalQueryDsl.g:8648:3: ( rule__ModelField__TypeNameAlternatives_0 )
            // InternalQueryDsl.g:8648:4: rule__ModelField__TypeNameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ModelField__TypeNameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getModelFieldAccess().getTypeNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelField__TypeNameAssignment"


    // $ANTLR start "rule__DslField__TypeNameAssignment"
    // InternalQueryDsl.g:8656:1: rule__DslField__TypeNameAssignment : ( ( rule__DslField__TypeNameAlternatives_0 ) ) ;
    public final void rule__DslField__TypeNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8660:1: ( ( ( rule__DslField__TypeNameAlternatives_0 ) ) )
            // InternalQueryDsl.g:8661:2: ( ( rule__DslField__TypeNameAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8661:2: ( ( rule__DslField__TypeNameAlternatives_0 ) )
            // InternalQueryDsl.g:8662:3: ( rule__DslField__TypeNameAlternatives_0 )
            {
             before(grammarAccess.getDslFieldAccess().getTypeNameAlternatives_0()); 
            // InternalQueryDsl.g:8663:3: ( rule__DslField__TypeNameAlternatives_0 )
            // InternalQueryDsl.g:8663:4: rule__DslField__TypeNameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__DslField__TypeNameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getDslFieldAccess().getTypeNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DslField__TypeNameAssignment"


    // $ANTLR start "rule__UserParam__TypeNameAssignment"
    // InternalQueryDsl.g:8671:1: rule__UserParam__TypeNameAssignment : ( ( rule__UserParam__TypeNameAlternatives_0 ) ) ;
    public final void rule__UserParam__TypeNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8675:1: ( ( ( rule__UserParam__TypeNameAlternatives_0 ) ) )
            // InternalQueryDsl.g:8676:2: ( ( rule__UserParam__TypeNameAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8676:2: ( ( rule__UserParam__TypeNameAlternatives_0 ) )
            // InternalQueryDsl.g:8677:3: ( rule__UserParam__TypeNameAlternatives_0 )
            {
             before(grammarAccess.getUserParamAccess().getTypeNameAlternatives_0()); 
            // InternalQueryDsl.g:8678:3: ( rule__UserParam__TypeNameAlternatives_0 )
            // InternalQueryDsl.g:8678:4: rule__UserParam__TypeNameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__UserParam__TypeNameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getUserParamAccess().getTypeNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserParam__TypeNameAssignment"


    // $ANTLR start "rule__WorkspaceParam__TypeNameAssignment"
    // InternalQueryDsl.g:8686:1: rule__WorkspaceParam__TypeNameAssignment : ( ( rule__WorkspaceParam__TypeNameAlternatives_0 ) ) ;
    public final void rule__WorkspaceParam__TypeNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8690:1: ( ( ( rule__WorkspaceParam__TypeNameAlternatives_0 ) ) )
            // InternalQueryDsl.g:8691:2: ( ( rule__WorkspaceParam__TypeNameAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8691:2: ( ( rule__WorkspaceParam__TypeNameAlternatives_0 ) )
            // InternalQueryDsl.g:8692:3: ( rule__WorkspaceParam__TypeNameAlternatives_0 )
            {
             before(grammarAccess.getWorkspaceParamAccess().getTypeNameAlternatives_0()); 
            // InternalQueryDsl.g:8693:3: ( rule__WorkspaceParam__TypeNameAlternatives_0 )
            // InternalQueryDsl.g:8693:4: rule__WorkspaceParam__TypeNameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__WorkspaceParam__TypeNameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getWorkspaceParamAccess().getTypeNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkspaceParam__TypeNameAssignment"


    // $ANTLR start "rule__ProjectParam__TypeNameAssignment"
    // InternalQueryDsl.g:8701:1: rule__ProjectParam__TypeNameAssignment : ( ( rule__ProjectParam__TypeNameAlternatives_0 ) ) ;
    public final void rule__ProjectParam__TypeNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8705:1: ( ( ( rule__ProjectParam__TypeNameAlternatives_0 ) ) )
            // InternalQueryDsl.g:8706:2: ( ( rule__ProjectParam__TypeNameAlternatives_0 ) )
            {
            // InternalQueryDsl.g:8706:2: ( ( rule__ProjectParam__TypeNameAlternatives_0 ) )
            // InternalQueryDsl.g:8707:3: ( rule__ProjectParam__TypeNameAlternatives_0 )
            {
             before(grammarAccess.getProjectParamAccess().getTypeNameAlternatives_0()); 
            // InternalQueryDsl.g:8708:3: ( rule__ProjectParam__TypeNameAlternatives_0 )
            // InternalQueryDsl.g:8708:4: rule__ProjectParam__TypeNameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ProjectParam__TypeNameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getProjectParamAccess().getTypeNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProjectParam__TypeNameAssignment"


    // $ANTLR start "rule__Variable__NameAssignment_1"
    // InternalQueryDsl.g:8716:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8720:1: ( ( RULE_ID ) )
            // InternalQueryDsl.g:8721:2: ( RULE_ID )
            {
            // InternalQueryDsl.g:8721:2: ( RULE_ID )
            // InternalQueryDsl.g:8722:3: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment_1"


    // $ANTLR start "rule__Variable__ExpressionAssignment_3"
    // InternalQueryDsl.g:8731:1: rule__Variable__ExpressionAssignment_3 : ( ruleExpression ) ;
    public final void rule__Variable__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8735:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:8736:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:8736:2: ( ruleExpression )
            // InternalQueryDsl.g:8737:3: ruleExpression
            {
             before(grammarAccess.getVariableAccess().getExpressionExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getVariableAccess().getExpressionExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__ExpressionAssignment_3"


    // $ANTLR start "rule__Expression__ValueAssignment_0_1"
    // InternalQueryDsl.g:8746:1: rule__Expression__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__Expression__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8750:1: ( ( RULE_INT ) )
            // InternalQueryDsl.g:8751:2: ( RULE_INT )
            {
            // InternalQueryDsl.g:8751:2: ( RULE_INT )
            // InternalQueryDsl.g:8752:3: RULE_INT
            {
             before(grammarAccess.getExpressionAccess().getValueINTTerminalRuleCall_0_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getValueINTTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__ValueAssignment_0_1"


    // $ANTLR start "rule__Expression__ValueAssignment_1_1"
    // InternalQueryDsl.g:8761:1: rule__Expression__ValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Expression__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8765:1: ( ( RULE_STRING ) )
            // InternalQueryDsl.g:8766:2: ( RULE_STRING )
            {
            // InternalQueryDsl.g:8766:2: ( RULE_STRING )
            // InternalQueryDsl.g:8767:3: RULE_STRING
            {
             before(grammarAccess.getExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__ValueAssignment_1_1"


    // $ANTLR start "rule__Expression__ValueAssignment_2_1"
    // InternalQueryDsl.g:8776:1: rule__Expression__ValueAssignment_2_1 : ( ( rule__Expression__ValueAlternatives_2_1_0 ) ) ;
    public final void rule__Expression__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8780:1: ( ( ( rule__Expression__ValueAlternatives_2_1_0 ) ) )
            // InternalQueryDsl.g:8781:2: ( ( rule__Expression__ValueAlternatives_2_1_0 ) )
            {
            // InternalQueryDsl.g:8781:2: ( ( rule__Expression__ValueAlternatives_2_1_0 ) )
            // InternalQueryDsl.g:8782:3: ( rule__Expression__ValueAlternatives_2_1_0 )
            {
             before(grammarAccess.getExpressionAccess().getValueAlternatives_2_1_0()); 
            // InternalQueryDsl.g:8783:3: ( rule__Expression__ValueAlternatives_2_1_0 )
            // InternalQueryDsl.g:8783:4: rule__Expression__ValueAlternatives_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Expression__ValueAlternatives_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getValueAlternatives_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__ValueAssignment_2_1"


    // $ANTLR start "rule__Expression__VariableAssignment_3_1"
    // InternalQueryDsl.g:8791:1: rule__Expression__VariableAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Expression__VariableAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:8795:1: ( ( ( RULE_ID ) ) )
            // InternalQueryDsl.g:8796:2: ( ( RULE_ID ) )
            {
            // InternalQueryDsl.g:8796:2: ( ( RULE_ID ) )
            // InternalQueryDsl.g:8797:3: ( RULE_ID )
            {
             before(grammarAccess.getExpressionAccess().getVariableVariableCrossReference_3_1_0()); 
            // InternalQueryDsl.g:8798:3: ( RULE_ID )
            // InternalQueryDsl.g:8799:4: RULE_ID
            {
             before(grammarAccess.getExpressionAccess().getVariableVariableIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getVariableVariableIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getExpressionAccess().getVariableVariableCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__VariableAssignment_3_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x0000400000800000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0006000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000044000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x001E000000002000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00F8000000006000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0F38000000006000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x1020000000006000L,0x00000000001FF030L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000408000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xF038000000006000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000392000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0xD038000000006000L,0x00000000000001FCL});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000216000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xD038000000006000L,0x00000000000001F4L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000212000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000070L,0x0000000000600000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x000000E000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000001FFFFF8000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x000000E000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x000000E000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00001F0000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0001E00000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0001E00000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000600000L});

}