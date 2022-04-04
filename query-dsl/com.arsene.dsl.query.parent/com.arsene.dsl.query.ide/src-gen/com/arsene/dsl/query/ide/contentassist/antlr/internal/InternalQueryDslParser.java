package com.arsene.dsl.query.ide.contentassist.antlr.internal;

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
import com.arsene.dsl.query.services.QueryDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalQueryDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'*'", "'/'", "'true'", "'false'", "'var'", "'='", "'print'", "'||'", "'&&'", "'+'", "'-'", "'!'", "'('", "')'", "'mod'", "'^'"
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



    // $ANTLR start "entryRuleModel"
    // InternalQueryDsl.g:54:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalQueryDsl.g:55:1: ( ruleModel EOF )
            // InternalQueryDsl.g:56:1: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalQueryDsl.g:63:1: ruleModel : ( ( rule__Model__InstructionsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:67:2: ( ( ( rule__Model__InstructionsAssignment )* ) )
            // InternalQueryDsl.g:68:2: ( ( rule__Model__InstructionsAssignment )* )
            {
            // InternalQueryDsl.g:68:2: ( ( rule__Model__InstructionsAssignment )* )
            // InternalQueryDsl.g:69:3: ( rule__Model__InstructionsAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getInstructionsAssignment()); 
            }
            // InternalQueryDsl.g:70:3: ( rule__Model__InstructionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==21||LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalQueryDsl.g:70:4: rule__Model__InstructionsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__InstructionsAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getInstructionsAssignment()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleInstruction"
    // InternalQueryDsl.g:79:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // InternalQueryDsl.g:80:1: ( ruleInstruction EOF )
            // InternalQueryDsl.g:81:1: ruleInstruction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleInstruction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstructionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalQueryDsl.g:88:1: ruleInstruction : ( ( rule__Instruction__Alternatives ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:92:2: ( ( ( rule__Instruction__Alternatives ) ) )
            // InternalQueryDsl.g:93:2: ( ( rule__Instruction__Alternatives ) )
            {
            // InternalQueryDsl.g:93:2: ( ( rule__Instruction__Alternatives ) )
            // InternalQueryDsl.g:94:3: ( rule__Instruction__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInstructionAccess().getAlternatives()); 
            }
            // InternalQueryDsl.g:95:3: ( rule__Instruction__Alternatives )
            // InternalQueryDsl.g:95:4: rule__Instruction__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Instruction__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInstructionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalQueryDsl.g:104:1: entryRuleVariableDeclaration : ruleVariableDeclaration EOF ;
    public final void entryRuleVariableDeclaration() throws RecognitionException {
        try {
            // InternalQueryDsl.g:105:1: ( ruleVariableDeclaration EOF )
            // InternalQueryDsl.g:106:1: ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalQueryDsl.g:113:1: ruleVariableDeclaration : ( ( rule__VariableDeclaration__Group__0 ) ) ;
    public final void ruleVariableDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:117:2: ( ( ( rule__VariableDeclaration__Group__0 ) ) )
            // InternalQueryDsl.g:118:2: ( ( rule__VariableDeclaration__Group__0 ) )
            {
            // InternalQueryDsl.g:118:2: ( ( rule__VariableDeclaration__Group__0 ) )
            // InternalQueryDsl.g:119:3: ( rule__VariableDeclaration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getGroup()); 
            }
            // InternalQueryDsl.g:120:3: ( rule__VariableDeclaration__Group__0 )
            // InternalQueryDsl.g:120:4: rule__VariableDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleVarRef"
    // InternalQueryDsl.g:129:1: entryRuleVarRef : ruleVarRef EOF ;
    public final void entryRuleVarRef() throws RecognitionException {
        try {
            // InternalQueryDsl.g:130:1: ( ruleVarRef EOF )
            // InternalQueryDsl.g:131:1: ruleVarRef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleVarRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarRefRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleVarRef"


    // $ANTLR start "ruleVarRef"
    // InternalQueryDsl.g:138:1: ruleVarRef : ( ( rule__VarRef__RefAssignment ) ) ;
    public final void ruleVarRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:142:2: ( ( ( rule__VarRef__RefAssignment ) ) )
            // InternalQueryDsl.g:143:2: ( ( rule__VarRef__RefAssignment ) )
            {
            // InternalQueryDsl.g:143:2: ( ( rule__VarRef__RefAssignment ) )
            // InternalQueryDsl.g:144:3: ( rule__VarRef__RefAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefAccess().getRefAssignment()); 
            }
            // InternalQueryDsl.g:145:3: ( rule__VarRef__RefAssignment )
            // InternalQueryDsl.g:145:4: rule__VarRef__RefAssignment
            {
            pushFollow(FOLLOW_2);
            rule__VarRef__RefAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarRefAccess().getRefAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVarRef"


    // $ANTLR start "entryRuleAssignment"
    // InternalQueryDsl.g:154:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalQueryDsl.g:155:1: ( ruleAssignment EOF )
            // InternalQueryDsl.g:156:1: ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalQueryDsl.g:163:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:167:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalQueryDsl.g:168:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalQueryDsl.g:168:2: ( ( rule__Assignment__Group__0 ) )
            // InternalQueryDsl.g:169:3: ( rule__Assignment__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getGroup()); 
            }
            // InternalQueryDsl.g:170:3: ( rule__Assignment__Group__0 )
            // InternalQueryDsl.g:170:4: rule__Assignment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleGlobalCommand"
    // InternalQueryDsl.g:179:1: entryRuleGlobalCommand : ruleGlobalCommand EOF ;
    public final void entryRuleGlobalCommand() throws RecognitionException {
        try {
            // InternalQueryDsl.g:180:1: ( ruleGlobalCommand EOF )
            // InternalQueryDsl.g:181:1: ruleGlobalCommand EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGlobalCommandRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleGlobalCommand();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGlobalCommandRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleGlobalCommand"


    // $ANTLR start "ruleGlobalCommand"
    // InternalQueryDsl.g:188:1: ruleGlobalCommand : ( ( rule__GlobalCommand__Group__0 ) ) ;
    public final void ruleGlobalCommand() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:192:2: ( ( ( rule__GlobalCommand__Group__0 ) ) )
            // InternalQueryDsl.g:193:2: ( ( rule__GlobalCommand__Group__0 ) )
            {
            // InternalQueryDsl.g:193:2: ( ( rule__GlobalCommand__Group__0 ) )
            // InternalQueryDsl.g:194:3: ( rule__GlobalCommand__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGlobalCommandAccess().getGroup()); 
            }
            // InternalQueryDsl.g:195:3: ( rule__GlobalCommand__Group__0 )
            // InternalQueryDsl.g:195:4: rule__GlobalCommand__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GlobalCommand__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGlobalCommandAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGlobalCommand"


    // $ANTLR start "entryRuleExpression"
    // InternalQueryDsl.g:204:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalQueryDsl.g:205:1: ( ruleExpression EOF )
            // InternalQueryDsl.g:206:1: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalQueryDsl.g:213:1: ruleExpression : ( ruleOr ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:217:2: ( ( ruleOr ) )
            // InternalQueryDsl.g:218:2: ( ruleOr )
            {
            // InternalQueryDsl.g:218:2: ( ruleOr )
            // InternalQueryDsl.g:219:3: ruleOr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getOrParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getOrParserRuleCall()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleOr"
    // InternalQueryDsl.g:229:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalQueryDsl.g:230:1: ( ruleOr EOF )
            // InternalQueryDsl.g:231:1: ruleOr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalQueryDsl.g:238:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:242:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalQueryDsl.g:243:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalQueryDsl.g:243:2: ( ( rule__Or__Group__0 ) )
            // InternalQueryDsl.g:244:3: ( rule__Or__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getGroup()); 
            }
            // InternalQueryDsl.g:245:3: ( rule__Or__Group__0 )
            // InternalQueryDsl.g:245:4: rule__Or__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalQueryDsl.g:254:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalQueryDsl.g:255:1: ( ruleAnd EOF )
            // InternalQueryDsl.g:256:1: ruleAnd EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalQueryDsl.g:263:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:267:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalQueryDsl.g:268:2: ( ( rule__And__Group__0 ) )
            {
            // InternalQueryDsl.g:268:2: ( ( rule__And__Group__0 ) )
            // InternalQueryDsl.g:269:3: ( rule__And__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getGroup()); 
            }
            // InternalQueryDsl.g:270:3: ( rule__And__Group__0 )
            // InternalQueryDsl.g:270:4: rule__And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleEquality"
    // InternalQueryDsl.g:279:1: entryRuleEquality : ruleEquality EOF ;
    public final void entryRuleEquality() throws RecognitionException {
        try {
            // InternalQueryDsl.g:280:1: ( ruleEquality EOF )
            // InternalQueryDsl.g:281:1: ruleEquality EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalQueryDsl.g:288:1: ruleEquality : ( ( rule__Equality__Group__0 ) ) ;
    public final void ruleEquality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:292:2: ( ( ( rule__Equality__Group__0 ) ) )
            // InternalQueryDsl.g:293:2: ( ( rule__Equality__Group__0 ) )
            {
            // InternalQueryDsl.g:293:2: ( ( rule__Equality__Group__0 ) )
            // InternalQueryDsl.g:294:3: ( rule__Equality__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getGroup()); 
            }
            // InternalQueryDsl.g:295:3: ( rule__Equality__Group__0 )
            // InternalQueryDsl.g:295:4: rule__Equality__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // InternalQueryDsl.g:304:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // InternalQueryDsl.g:305:1: ( ruleComparison EOF )
            // InternalQueryDsl.g:306:1: ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalQueryDsl.g:313:1: ruleComparison : ( ( rule__Comparison__Group__0 ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:317:2: ( ( ( rule__Comparison__Group__0 ) ) )
            // InternalQueryDsl.g:318:2: ( ( rule__Comparison__Group__0 ) )
            {
            // InternalQueryDsl.g:318:2: ( ( rule__Comparison__Group__0 ) )
            // InternalQueryDsl.g:319:3: ( rule__Comparison__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup()); 
            }
            // InternalQueryDsl.g:320:3: ( rule__Comparison__Group__0 )
            // InternalQueryDsl.g:320:4: rule__Comparison__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRulePlusOrMinus"
    // InternalQueryDsl.g:329:1: entryRulePlusOrMinus : rulePlusOrMinus EOF ;
    public final void entryRulePlusOrMinus() throws RecognitionException {
        try {
            // InternalQueryDsl.g:330:1: ( rulePlusOrMinus EOF )
            // InternalQueryDsl.g:331:1: rulePlusOrMinus EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePlusOrMinus"


    // $ANTLR start "rulePlusOrMinus"
    // InternalQueryDsl.g:338:1: rulePlusOrMinus : ( ( rule__PlusOrMinus__Group__0 ) ) ;
    public final void rulePlusOrMinus() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:342:2: ( ( ( rule__PlusOrMinus__Group__0 ) ) )
            // InternalQueryDsl.g:343:2: ( ( rule__PlusOrMinus__Group__0 ) )
            {
            // InternalQueryDsl.g:343:2: ( ( rule__PlusOrMinus__Group__0 ) )
            // InternalQueryDsl.g:344:3: ( rule__PlusOrMinus__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getGroup()); 
            }
            // InternalQueryDsl.g:345:3: ( rule__PlusOrMinus__Group__0 )
            // InternalQueryDsl.g:345:4: rule__PlusOrMinus__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePlusOrMinus"


    // $ANTLR start "entryRuleMod"
    // InternalQueryDsl.g:354:1: entryRuleMod : ruleMod EOF ;
    public final void entryRuleMod() throws RecognitionException {
        try {
            // InternalQueryDsl.g:355:1: ( ruleMod EOF )
            // InternalQueryDsl.g:356:1: ruleMod EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMod();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMod"


    // $ANTLR start "ruleMod"
    // InternalQueryDsl.g:363:1: ruleMod : ( ( rule__Mod__Group__0 ) ) ;
    public final void ruleMod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:367:2: ( ( ( rule__Mod__Group__0 ) ) )
            // InternalQueryDsl.g:368:2: ( ( rule__Mod__Group__0 ) )
            {
            // InternalQueryDsl.g:368:2: ( ( rule__Mod__Group__0 ) )
            // InternalQueryDsl.g:369:3: ( rule__Mod__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getGroup()); 
            }
            // InternalQueryDsl.g:370:3: ( rule__Mod__Group__0 )
            // InternalQueryDsl.g:370:4: rule__Mod__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Mod__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMod"


    // $ANTLR start "entryRuleMulOrDiv"
    // InternalQueryDsl.g:379:1: entryRuleMulOrDiv : ruleMulOrDiv EOF ;
    public final void entryRuleMulOrDiv() throws RecognitionException {
        try {
            // InternalQueryDsl.g:380:1: ( ruleMulOrDiv EOF )
            // InternalQueryDsl.g:381:1: ruleMulOrDiv EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMulOrDiv"


    // $ANTLR start "ruleMulOrDiv"
    // InternalQueryDsl.g:388:1: ruleMulOrDiv : ( ( rule__MulOrDiv__Group__0 ) ) ;
    public final void ruleMulOrDiv() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:392:2: ( ( ( rule__MulOrDiv__Group__0 ) ) )
            // InternalQueryDsl.g:393:2: ( ( rule__MulOrDiv__Group__0 ) )
            {
            // InternalQueryDsl.g:393:2: ( ( rule__MulOrDiv__Group__0 ) )
            // InternalQueryDsl.g:394:3: ( rule__MulOrDiv__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getGroup()); 
            }
            // InternalQueryDsl.g:395:3: ( rule__MulOrDiv__Group__0 )
            // InternalQueryDsl.g:395:4: rule__MulOrDiv__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMulOrDiv"


    // $ANTLR start "entryRuleExpo"
    // InternalQueryDsl.g:404:1: entryRuleExpo : ruleExpo EOF ;
    public final void entryRuleExpo() throws RecognitionException {
        try {
            // InternalQueryDsl.g:405:1: ( ruleExpo EOF )
            // InternalQueryDsl.g:406:1: ruleExpo EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExpo();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleExpo"


    // $ANTLR start "ruleExpo"
    // InternalQueryDsl.g:413:1: ruleExpo : ( ( rule__Expo__Group__0 ) ) ;
    public final void ruleExpo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:417:2: ( ( ( rule__Expo__Group__0 ) ) )
            // InternalQueryDsl.g:418:2: ( ( rule__Expo__Group__0 ) )
            {
            // InternalQueryDsl.g:418:2: ( ( rule__Expo__Group__0 ) )
            // InternalQueryDsl.g:419:3: ( rule__Expo__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getGroup()); 
            }
            // InternalQueryDsl.g:420:3: ( rule__Expo__Group__0 )
            // InternalQueryDsl.g:420:4: rule__Expo__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Expo__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpo"


    // $ANTLR start "entryRulePrefixed"
    // InternalQueryDsl.g:429:1: entryRulePrefixed : rulePrefixed EOF ;
    public final void entryRulePrefixed() throws RecognitionException {
        try {
            // InternalQueryDsl.g:430:1: ( rulePrefixed EOF )
            // InternalQueryDsl.g:431:1: rulePrefixed EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrefixed();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePrefixed"


    // $ANTLR start "rulePrefixed"
    // InternalQueryDsl.g:438:1: rulePrefixed : ( ( rule__Prefixed__Alternatives ) ) ;
    public final void rulePrefixed() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:442:2: ( ( ( rule__Prefixed__Alternatives ) ) )
            // InternalQueryDsl.g:443:2: ( ( rule__Prefixed__Alternatives ) )
            {
            // InternalQueryDsl.g:443:2: ( ( rule__Prefixed__Alternatives ) )
            // InternalQueryDsl.g:444:3: ( rule__Prefixed__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getAlternatives()); 
            }
            // InternalQueryDsl.g:445:3: ( rule__Prefixed__Alternatives )
            // InternalQueryDsl.g:445:4: rule__Prefixed__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Prefixed__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrefixed"


    // $ANTLR start "entryRuleAtomic"
    // InternalQueryDsl.g:454:1: entryRuleAtomic : ruleAtomic EOF ;
    public final void entryRuleAtomic() throws RecognitionException {
        try {
            // InternalQueryDsl.g:455:1: ( ruleAtomic EOF )
            // InternalQueryDsl.g:456:1: ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // InternalQueryDsl.g:463:1: ruleAtomic : ( ( rule__Atomic__Alternatives ) ) ;
    public final void ruleAtomic() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:467:2: ( ( ( rule__Atomic__Alternatives ) ) )
            // InternalQueryDsl.g:468:2: ( ( rule__Atomic__Alternatives ) )
            {
            // InternalQueryDsl.g:468:2: ( ( rule__Atomic__Alternatives ) )
            // InternalQueryDsl.g:469:3: ( rule__Atomic__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getAlternatives()); 
            }
            // InternalQueryDsl.g:470:3: ( rule__Atomic__Alternatives )
            // InternalQueryDsl.g:470:4: rule__Atomic__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "rule__Instruction__Alternatives"
    // InternalQueryDsl.g:478:1: rule__Instruction__Alternatives : ( ( ruleVariableDeclaration ) | ( ruleAssignment ) | ( ruleGlobalCommand ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:482:1: ( ( ruleVariableDeclaration ) | ( ruleAssignment ) | ( ruleGlobalCommand ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                alt2=2;
                }
                break;
            case 23:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalQueryDsl.g:483:2: ( ruleVariableDeclaration )
                    {
                    // InternalQueryDsl.g:483:2: ( ruleVariableDeclaration )
                    // InternalQueryDsl.g:484:3: ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getInstructionAccess().getVariableDeclarationParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getInstructionAccess().getVariableDeclarationParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:489:2: ( ruleAssignment )
                    {
                    // InternalQueryDsl.g:489:2: ( ruleAssignment )
                    // InternalQueryDsl.g:490:3: ruleAssignment
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getInstructionAccess().getAssignmentParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleAssignment();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getInstructionAccess().getAssignmentParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:495:2: ( ruleGlobalCommand )
                    {
                    // InternalQueryDsl.g:495:2: ( ruleGlobalCommand )
                    // InternalQueryDsl.g:496:3: ruleGlobalCommand
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getInstructionAccess().getGlobalCommandParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleGlobalCommand();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getInstructionAccess().getGlobalCommandParserRuleCall_2()); 
                    }

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
    // $ANTLR end "rule__Instruction__Alternatives"


    // $ANTLR start "rule__Equality__OpAlternatives_1_1_0"
    // InternalQueryDsl.g:505:1: rule__Equality__OpAlternatives_1_1_0 : ( ( '==' ) | ( '!=' ) );
    public final void rule__Equality__OpAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:509:1: ( ( '==' ) | ( '!=' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalQueryDsl.g:510:2: ( '==' )
                    {
                    // InternalQueryDsl.g:510:2: ( '==' )
                    // InternalQueryDsl.g:511:3: '=='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0()); 
                    }
                    match(input,11,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:516:2: ( '!=' )
                    {
                    // InternalQueryDsl.g:516:2: ( '!=' )
                    // InternalQueryDsl.g:517:3: '!='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1()); 
                    }
                    match(input,12,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1()); 
                    }

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
    // $ANTLR end "rule__Equality__OpAlternatives_1_1_0"


    // $ANTLR start "rule__Comparison__OpAlternatives_1_1_0"
    // InternalQueryDsl.g:526:1: rule__Comparison__OpAlternatives_1_1_0 : ( ( '>=' ) | ( '<=' ) | ( '>' ) | ( '<' ) );
    public final void rule__Comparison__OpAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:530:1: ( ( '>=' ) | ( '<=' ) | ( '>' ) | ( '<' ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 15:
                {
                alt4=3;
                }
                break;
            case 16:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalQueryDsl.g:531:2: ( '>=' )
                    {
                    // InternalQueryDsl.g:531:2: ( '>=' )
                    // InternalQueryDsl.g:532:3: '>='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0()); 
                    }
                    match(input,13,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:537:2: ( '<=' )
                    {
                    // InternalQueryDsl.g:537:2: ( '<=' )
                    // InternalQueryDsl.g:538:3: '<='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1()); 
                    }
                    match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:543:2: ( '>' )
                    {
                    // InternalQueryDsl.g:543:2: ( '>' )
                    // InternalQueryDsl.g:544:3: '>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:549:2: ( '<' )
                    {
                    // InternalQueryDsl.g:549:2: ( '<' )
                    // InternalQueryDsl.g:550:3: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3()); 
                    }
                    match(input,16,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3()); 
                    }

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
    // $ANTLR end "rule__Comparison__OpAlternatives_1_1_0"


    // $ANTLR start "rule__PlusOrMinus__Alternatives_1_0"
    // InternalQueryDsl.g:559:1: rule__PlusOrMinus__Alternatives_1_0 : ( ( ( rule__PlusOrMinus__Group_1_0_0__0 ) ) | ( ( rule__PlusOrMinus__Group_1_0_1__0 ) ) );
    public final void rule__PlusOrMinus__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:563:1: ( ( ( rule__PlusOrMinus__Group_1_0_0__0 ) ) | ( ( rule__PlusOrMinus__Group_1_0_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==26) ) {
                alt5=1;
            }
            else if ( (LA5_0==27) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalQueryDsl.g:564:2: ( ( rule__PlusOrMinus__Group_1_0_0__0 ) )
                    {
                    // InternalQueryDsl.g:564:2: ( ( rule__PlusOrMinus__Group_1_0_0__0 ) )
                    // InternalQueryDsl.g:565:3: ( rule__PlusOrMinus__Group_1_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_0()); 
                    }
                    // InternalQueryDsl.g:566:3: ( rule__PlusOrMinus__Group_1_0_0__0 )
                    // InternalQueryDsl.g:566:4: rule__PlusOrMinus__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PlusOrMinus__Group_1_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:570:2: ( ( rule__PlusOrMinus__Group_1_0_1__0 ) )
                    {
                    // InternalQueryDsl.g:570:2: ( ( rule__PlusOrMinus__Group_1_0_1__0 ) )
                    // InternalQueryDsl.g:571:3: ( rule__PlusOrMinus__Group_1_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_1()); 
                    }
                    // InternalQueryDsl.g:572:3: ( rule__PlusOrMinus__Group_1_0_1__0 )
                    // InternalQueryDsl.g:572:4: rule__PlusOrMinus__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PlusOrMinus__Group_1_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_1()); 
                    }

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
    // $ANTLR end "rule__PlusOrMinus__Alternatives_1_0"


    // $ANTLR start "rule__MulOrDiv__OpAlternatives_1_0_1_0"
    // InternalQueryDsl.g:580:1: rule__MulOrDiv__OpAlternatives_1_0_1_0 : ( ( '*' ) | ( '/' ) );
    public final void rule__MulOrDiv__OpAlternatives_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:584:1: ( ( '*' ) | ( '/' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            else if ( (LA6_0==18) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalQueryDsl.g:585:2: ( '*' )
                    {
                    // InternalQueryDsl.g:585:2: ( '*' )
                    // InternalQueryDsl.g:586:3: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMulOrDivAccess().getOpAsteriskKeyword_1_0_1_0_0()); 
                    }
                    match(input,17,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMulOrDivAccess().getOpAsteriskKeyword_1_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:591:2: ( '/' )
                    {
                    // InternalQueryDsl.g:591:2: ( '/' )
                    // InternalQueryDsl.g:592:3: '/'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMulOrDivAccess().getOpSolidusKeyword_1_0_1_0_1()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMulOrDivAccess().getOpSolidusKeyword_1_0_1_0_1()); 
                    }

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
    // $ANTLR end "rule__MulOrDiv__OpAlternatives_1_0_1_0"


    // $ANTLR start "rule__Prefixed__Alternatives"
    // InternalQueryDsl.g:601:1: rule__Prefixed__Alternatives : ( ( ( rule__Prefixed__Group_0__0 ) ) | ( ( rule__Prefixed__Group_1__0 ) ) | ( ruleAtomic ) );
    public final void rule__Prefixed__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:605:1: ( ( ( rule__Prefixed__Group_0__0 ) ) | ( ( rule__Prefixed__Group_1__0 ) ) | ( ruleAtomic ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt7=1;
                }
                break;
            case 27:
                {
                alt7=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 19:
            case 20:
            case 29:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalQueryDsl.g:606:2: ( ( rule__Prefixed__Group_0__0 ) )
                    {
                    // InternalQueryDsl.g:606:2: ( ( rule__Prefixed__Group_0__0 ) )
                    // InternalQueryDsl.g:607:3: ( rule__Prefixed__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrefixedAccess().getGroup_0()); 
                    }
                    // InternalQueryDsl.g:608:3: ( rule__Prefixed__Group_0__0 )
                    // InternalQueryDsl.g:608:4: rule__Prefixed__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Prefixed__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrefixedAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:612:2: ( ( rule__Prefixed__Group_1__0 ) )
                    {
                    // InternalQueryDsl.g:612:2: ( ( rule__Prefixed__Group_1__0 ) )
                    // InternalQueryDsl.g:613:3: ( rule__Prefixed__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrefixedAccess().getGroup_1()); 
                    }
                    // InternalQueryDsl.g:614:3: ( rule__Prefixed__Group_1__0 )
                    // InternalQueryDsl.g:614:4: rule__Prefixed__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Prefixed__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrefixedAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:618:2: ( ruleAtomic )
                    {
                    // InternalQueryDsl.g:618:2: ( ruleAtomic )
                    // InternalQueryDsl.g:619:3: ruleAtomic
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrefixedAccess().getAtomicParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleAtomic();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrefixedAccess().getAtomicParserRuleCall_2()); 
                    }

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
    // $ANTLR end "rule__Prefixed__Alternatives"


    // $ANTLR start "rule__Atomic__Alternatives"
    // InternalQueryDsl.g:628:1: rule__Atomic__Alternatives : ( ( ( rule__Atomic__Group_0__0 ) ) | ( ( rule__Atomic__Group_1__0 ) ) | ( ( rule__Atomic__Group_2__0 ) ) | ( ( rule__Atomic__Group_3__0 ) ) | ( ruleVarRef ) );
    public final void rule__Atomic__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:632:1: ( ( ( rule__Atomic__Group_0__0 ) ) | ( ( rule__Atomic__Group_1__0 ) ) | ( ( rule__Atomic__Group_2__0 ) ) | ( ( rule__Atomic__Group_3__0 ) ) | ( ruleVarRef ) )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt8=1;
                }
                break;
            case RULE_INT:
                {
                alt8=2;
                }
                break;
            case 19:
            case 20:
                {
                alt8=3;
                }
                break;
            case RULE_STRING:
                {
                alt8=4;
                }
                break;
            case RULE_ID:
                {
                alt8=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalQueryDsl.g:633:2: ( ( rule__Atomic__Group_0__0 ) )
                    {
                    // InternalQueryDsl.g:633:2: ( ( rule__Atomic__Group_0__0 ) )
                    // InternalQueryDsl.g:634:3: ( rule__Atomic__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_0()); 
                    }
                    // InternalQueryDsl.g:635:3: ( rule__Atomic__Group_0__0 )
                    // InternalQueryDsl.g:635:4: rule__Atomic__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atomic__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:639:2: ( ( rule__Atomic__Group_1__0 ) )
                    {
                    // InternalQueryDsl.g:639:2: ( ( rule__Atomic__Group_1__0 ) )
                    // InternalQueryDsl.g:640:3: ( rule__Atomic__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_1()); 
                    }
                    // InternalQueryDsl.g:641:3: ( rule__Atomic__Group_1__0 )
                    // InternalQueryDsl.g:641:4: rule__Atomic__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atomic__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalQueryDsl.g:645:2: ( ( rule__Atomic__Group_2__0 ) )
                    {
                    // InternalQueryDsl.g:645:2: ( ( rule__Atomic__Group_2__0 ) )
                    // InternalQueryDsl.g:646:3: ( rule__Atomic__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_2()); 
                    }
                    // InternalQueryDsl.g:647:3: ( rule__Atomic__Group_2__0 )
                    // InternalQueryDsl.g:647:4: rule__Atomic__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atomic__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalQueryDsl.g:651:2: ( ( rule__Atomic__Group_3__0 ) )
                    {
                    // InternalQueryDsl.g:651:2: ( ( rule__Atomic__Group_3__0 ) )
                    // InternalQueryDsl.g:652:3: ( rule__Atomic__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_3()); 
                    }
                    // InternalQueryDsl.g:653:3: ( rule__Atomic__Group_3__0 )
                    // InternalQueryDsl.g:653:4: rule__Atomic__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atomic__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalQueryDsl.g:657:2: ( ruleVarRef )
                    {
                    // InternalQueryDsl.g:657:2: ( ruleVarRef )
                    // InternalQueryDsl.g:658:3: ruleVarRef
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getVarRefParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleVarRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getVarRefParserRuleCall_4()); 
                    }

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
    // $ANTLR end "rule__Atomic__Alternatives"


    // $ANTLR start "rule__Atomic__ValueAlternatives_2_1_0"
    // InternalQueryDsl.g:667:1: rule__Atomic__ValueAlternatives_2_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Atomic__ValueAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:671:1: ( ( 'true' ) | ( 'false' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            else if ( (LA9_0==20) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalQueryDsl.g:672:2: ( 'true' )
                    {
                    // InternalQueryDsl.g:672:2: ( 'true' )
                    // InternalQueryDsl.g:673:3: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getValueTrueKeyword_2_1_0_0()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getValueTrueKeyword_2_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalQueryDsl.g:678:2: ( 'false' )
                    {
                    // InternalQueryDsl.g:678:2: ( 'false' )
                    // InternalQueryDsl.g:679:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getValueFalseKeyword_2_1_0_1()); 
                    }
                    match(input,20,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getValueFalseKeyword_2_1_0_1()); 
                    }

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
    // $ANTLR end "rule__Atomic__ValueAlternatives_2_1_0"


    // $ANTLR start "rule__VariableDeclaration__Group__0"
    // InternalQueryDsl.g:688:1: rule__VariableDeclaration__Group__0 : rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 ;
    public final void rule__VariableDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:692:1: ( rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 )
            // InternalQueryDsl.g:693:2: rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__VariableDeclaration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__0"


    // $ANTLR start "rule__VariableDeclaration__Group__0__Impl"
    // InternalQueryDsl.g:700:1: rule__VariableDeclaration__Group__0__Impl : ( 'var' ) ;
    public final void rule__VariableDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:704:1: ( ( 'var' ) )
            // InternalQueryDsl.g:705:1: ( 'var' )
            {
            // InternalQueryDsl.g:705:1: ( 'var' )
            // InternalQueryDsl.g:706:2: 'var'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getVarKeyword_0()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getVarKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__0__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group__1"
    // InternalQueryDsl.g:715:1: rule__VariableDeclaration__Group__1 : rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2 ;
    public final void rule__VariableDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:719:1: ( rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2 )
            // InternalQueryDsl.g:720:2: rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__VariableDeclaration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__1"


    // $ANTLR start "rule__VariableDeclaration__Group__1__Impl"
    // InternalQueryDsl.g:727:1: rule__VariableDeclaration__Group__1__Impl : ( ( rule__VariableDeclaration__NameAssignment_1 ) ) ;
    public final void rule__VariableDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:731:1: ( ( ( rule__VariableDeclaration__NameAssignment_1 ) ) )
            // InternalQueryDsl.g:732:1: ( ( rule__VariableDeclaration__NameAssignment_1 ) )
            {
            // InternalQueryDsl.g:732:1: ( ( rule__VariableDeclaration__NameAssignment_1 ) )
            // InternalQueryDsl.g:733:2: ( rule__VariableDeclaration__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getNameAssignment_1()); 
            }
            // InternalQueryDsl.g:734:2: ( rule__VariableDeclaration__NameAssignment_1 )
            // InternalQueryDsl.g:734:3: rule__VariableDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__1__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group__2"
    // InternalQueryDsl.g:742:1: rule__VariableDeclaration__Group__2 : rule__VariableDeclaration__Group__2__Impl ;
    public final void rule__VariableDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:746:1: ( rule__VariableDeclaration__Group__2__Impl )
            // InternalQueryDsl.g:747:2: rule__VariableDeclaration__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__2"


    // $ANTLR start "rule__VariableDeclaration__Group__2__Impl"
    // InternalQueryDsl.g:753:1: rule__VariableDeclaration__Group__2__Impl : ( ( rule__VariableDeclaration__Group_2__0 )? ) ;
    public final void rule__VariableDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:757:1: ( ( ( rule__VariableDeclaration__Group_2__0 )? ) )
            // InternalQueryDsl.g:758:1: ( ( rule__VariableDeclaration__Group_2__0 )? )
            {
            // InternalQueryDsl.g:758:1: ( ( rule__VariableDeclaration__Group_2__0 )? )
            // InternalQueryDsl.g:759:2: ( rule__VariableDeclaration__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getGroup_2()); 
            }
            // InternalQueryDsl.g:760:2: ( rule__VariableDeclaration__Group_2__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalQueryDsl.g:760:3: rule__VariableDeclaration__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VariableDeclaration__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__2__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_2__0"
    // InternalQueryDsl.g:769:1: rule__VariableDeclaration__Group_2__0 : rule__VariableDeclaration__Group_2__0__Impl rule__VariableDeclaration__Group_2__1 ;
    public final void rule__VariableDeclaration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:773:1: ( rule__VariableDeclaration__Group_2__0__Impl rule__VariableDeclaration__Group_2__1 )
            // InternalQueryDsl.g:774:2: rule__VariableDeclaration__Group_2__0__Impl rule__VariableDeclaration__Group_2__1
            {
            pushFollow(FOLLOW_6);
            rule__VariableDeclaration__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_2__0"


    // $ANTLR start "rule__VariableDeclaration__Group_2__0__Impl"
    // InternalQueryDsl.g:781:1: rule__VariableDeclaration__Group_2__0__Impl : ( '=' ) ;
    public final void rule__VariableDeclaration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:785:1: ( ( '=' ) )
            // InternalQueryDsl.g:786:1: ( '=' )
            {
            // InternalQueryDsl.g:786:1: ( '=' )
            // InternalQueryDsl.g:787:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_2_0()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_2__0__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_2__1"
    // InternalQueryDsl.g:796:1: rule__VariableDeclaration__Group_2__1 : rule__VariableDeclaration__Group_2__1__Impl ;
    public final void rule__VariableDeclaration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:800:1: ( rule__VariableDeclaration__Group_2__1__Impl )
            // InternalQueryDsl.g:801:2: rule__VariableDeclaration__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_2__1"


    // $ANTLR start "rule__VariableDeclaration__Group_2__1__Impl"
    // InternalQueryDsl.g:807:1: rule__VariableDeclaration__Group_2__1__Impl : ( ( rule__VariableDeclaration__InitExpAssignment_2_1 ) ) ;
    public final void rule__VariableDeclaration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:811:1: ( ( ( rule__VariableDeclaration__InitExpAssignment_2_1 ) ) )
            // InternalQueryDsl.g:812:1: ( ( rule__VariableDeclaration__InitExpAssignment_2_1 ) )
            {
            // InternalQueryDsl.g:812:1: ( ( rule__VariableDeclaration__InitExpAssignment_2_1 ) )
            // InternalQueryDsl.g:813:2: ( rule__VariableDeclaration__InitExpAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getInitExpAssignment_2_1()); 
            }
            // InternalQueryDsl.g:814:2: ( rule__VariableDeclaration__InitExpAssignment_2_1 )
            // InternalQueryDsl.g:814:3: rule__VariableDeclaration__InitExpAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__VariableDeclaration__InitExpAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getInitExpAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_2__1__Impl"


    // $ANTLR start "rule__Assignment__Group__0"
    // InternalQueryDsl.g:823:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:827:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalQueryDsl.g:828:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Assignment__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0"


    // $ANTLR start "rule__Assignment__Group__0__Impl"
    // InternalQueryDsl.g:835:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__VAssignment_0 ) ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:839:1: ( ( ( rule__Assignment__VAssignment_0 ) ) )
            // InternalQueryDsl.g:840:1: ( ( rule__Assignment__VAssignment_0 ) )
            {
            // InternalQueryDsl.g:840:1: ( ( rule__Assignment__VAssignment_0 ) )
            // InternalQueryDsl.g:841:2: ( rule__Assignment__VAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getVAssignment_0()); 
            }
            // InternalQueryDsl.g:842:2: ( rule__Assignment__VAssignment_0 )
            // InternalQueryDsl.g:842:3: rule__Assignment__VAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__VAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getVAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0__Impl"


    // $ANTLR start "rule__Assignment__Group__1"
    // InternalQueryDsl.g:850:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:854:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalQueryDsl.g:855:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Assignment__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1"


    // $ANTLR start "rule__Assignment__Group__1__Impl"
    // InternalQueryDsl.g:862:1: rule__Assignment__Group__1__Impl : ( '=' ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:866:1: ( ( '=' ) )
            // InternalQueryDsl.g:867:1: ( '=' )
            {
            // InternalQueryDsl.g:867:1: ( '=' )
            // InternalQueryDsl.g:868:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__2"
    // InternalQueryDsl.g:877:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:881:1: ( rule__Assignment__Group__2__Impl )
            // InternalQueryDsl.g:882:2: rule__Assignment__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2"


    // $ANTLR start "rule__Assignment__Group__2__Impl"
    // InternalQueryDsl.g:888:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__ExpAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:892:1: ( ( ( rule__Assignment__ExpAssignment_2 ) ) )
            // InternalQueryDsl.g:893:1: ( ( rule__Assignment__ExpAssignment_2 ) )
            {
            // InternalQueryDsl.g:893:1: ( ( rule__Assignment__ExpAssignment_2 ) )
            // InternalQueryDsl.g:894:2: ( rule__Assignment__ExpAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getExpAssignment_2()); 
            }
            // InternalQueryDsl.g:895:2: ( rule__Assignment__ExpAssignment_2 )
            // InternalQueryDsl.g:895:3: rule__Assignment__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__ExpAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getExpAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2__Impl"


    // $ANTLR start "rule__GlobalCommand__Group__0"
    // InternalQueryDsl.g:904:1: rule__GlobalCommand__Group__0 : rule__GlobalCommand__Group__0__Impl rule__GlobalCommand__Group__1 ;
    public final void rule__GlobalCommand__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:908:1: ( rule__GlobalCommand__Group__0__Impl rule__GlobalCommand__Group__1 )
            // InternalQueryDsl.g:909:2: rule__GlobalCommand__Group__0__Impl rule__GlobalCommand__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__GlobalCommand__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__GlobalCommand__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalCommand__Group__0"


    // $ANTLR start "rule__GlobalCommand__Group__0__Impl"
    // InternalQueryDsl.g:916:1: rule__GlobalCommand__Group__0__Impl : ( () ) ;
    public final void rule__GlobalCommand__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:920:1: ( ( () ) )
            // InternalQueryDsl.g:921:1: ( () )
            {
            // InternalQueryDsl.g:921:1: ( () )
            // InternalQueryDsl.g:922:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGlobalCommandAccess().getPrintCommandAction_0()); 
            }
            // InternalQueryDsl.g:923:2: ()
            // InternalQueryDsl.g:923:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGlobalCommandAccess().getPrintCommandAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalCommand__Group__0__Impl"


    // $ANTLR start "rule__GlobalCommand__Group__1"
    // InternalQueryDsl.g:931:1: rule__GlobalCommand__Group__1 : rule__GlobalCommand__Group__1__Impl rule__GlobalCommand__Group__2 ;
    public final void rule__GlobalCommand__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:935:1: ( rule__GlobalCommand__Group__1__Impl rule__GlobalCommand__Group__2 )
            // InternalQueryDsl.g:936:2: rule__GlobalCommand__Group__1__Impl rule__GlobalCommand__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__GlobalCommand__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__GlobalCommand__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalCommand__Group__1"


    // $ANTLR start "rule__GlobalCommand__Group__1__Impl"
    // InternalQueryDsl.g:943:1: rule__GlobalCommand__Group__1__Impl : ( 'print' ) ;
    public final void rule__GlobalCommand__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:947:1: ( ( 'print' ) )
            // InternalQueryDsl.g:948:1: ( 'print' )
            {
            // InternalQueryDsl.g:948:1: ( 'print' )
            // InternalQueryDsl.g:949:2: 'print'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGlobalCommandAccess().getPrintKeyword_1()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGlobalCommandAccess().getPrintKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalCommand__Group__1__Impl"


    // $ANTLR start "rule__GlobalCommand__Group__2"
    // InternalQueryDsl.g:958:1: rule__GlobalCommand__Group__2 : rule__GlobalCommand__Group__2__Impl ;
    public final void rule__GlobalCommand__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:962:1: ( rule__GlobalCommand__Group__2__Impl )
            // InternalQueryDsl.g:963:2: rule__GlobalCommand__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GlobalCommand__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalCommand__Group__2"


    // $ANTLR start "rule__GlobalCommand__Group__2__Impl"
    // InternalQueryDsl.g:969:1: rule__GlobalCommand__Group__2__Impl : ( ( rule__GlobalCommand__ParamsAssignment_2 ) ) ;
    public final void rule__GlobalCommand__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:973:1: ( ( ( rule__GlobalCommand__ParamsAssignment_2 ) ) )
            // InternalQueryDsl.g:974:1: ( ( rule__GlobalCommand__ParamsAssignment_2 ) )
            {
            // InternalQueryDsl.g:974:1: ( ( rule__GlobalCommand__ParamsAssignment_2 ) )
            // InternalQueryDsl.g:975:2: ( rule__GlobalCommand__ParamsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGlobalCommandAccess().getParamsAssignment_2()); 
            }
            // InternalQueryDsl.g:976:2: ( rule__GlobalCommand__ParamsAssignment_2 )
            // InternalQueryDsl.g:976:3: rule__GlobalCommand__ParamsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__GlobalCommand__ParamsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGlobalCommandAccess().getParamsAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalCommand__Group__2__Impl"


    // $ANTLR start "rule__Or__Group__0"
    // InternalQueryDsl.g:985:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:989:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalQueryDsl.g:990:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Or__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Or__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0"


    // $ANTLR start "rule__Or__Group__0__Impl"
    // InternalQueryDsl.g:997:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1001:1: ( ( ruleAnd ) )
            // InternalQueryDsl.g:1002:1: ( ruleAnd )
            {
            // InternalQueryDsl.g:1002:1: ( ruleAnd )
            // InternalQueryDsl.g:1003:2: ruleAnd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0__Impl"


    // $ANTLR start "rule__Or__Group__1"
    // InternalQueryDsl.g:1012:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1016:1: ( rule__Or__Group__1__Impl )
            // InternalQueryDsl.g:1017:2: rule__Or__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1"


    // $ANTLR start "rule__Or__Group__1__Impl"
    // InternalQueryDsl.g:1023:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1027:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalQueryDsl.g:1028:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalQueryDsl.g:1028:1: ( ( rule__Or__Group_1__0 )* )
            // InternalQueryDsl.g:1029:2: ( rule__Or__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getGroup_1()); 
            }
            // InternalQueryDsl.g:1030:2: ( rule__Or__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==24) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalQueryDsl.g:1030:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Or__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1__Impl"


    // $ANTLR start "rule__Or__Group_1__0"
    // InternalQueryDsl.g:1039:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1043:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalQueryDsl.g:1044:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Or__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0"


    // $ANTLR start "rule__Or__Group_1__0__Impl"
    // InternalQueryDsl.g:1051:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1055:1: ( ( () ) )
            // InternalQueryDsl.g:1056:1: ( () )
            {
            // InternalQueryDsl.g:1056:1: ( () )
            // InternalQueryDsl.g:1057:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            }
            // InternalQueryDsl.g:1058:2: ()
            // InternalQueryDsl.g:1058:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0__Impl"


    // $ANTLR start "rule__Or__Group_1__1"
    // InternalQueryDsl.g:1066:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1070:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalQueryDsl.g:1071:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__Or__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1"


    // $ANTLR start "rule__Or__Group_1__1__Impl"
    // InternalQueryDsl.g:1078:1: rule__Or__Group_1__1__Impl : ( '||' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1082:1: ( ( '||' ) )
            // InternalQueryDsl.g:1083:1: ( '||' )
            {
            // InternalQueryDsl.g:1083:1: ( '||' )
            // InternalQueryDsl.g:1084:2: '||'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1__Impl"


    // $ANTLR start "rule__Or__Group_1__2"
    // InternalQueryDsl.g:1093:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1097:1: ( rule__Or__Group_1__2__Impl )
            // InternalQueryDsl.g:1098:2: rule__Or__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2"


    // $ANTLR start "rule__Or__Group_1__2__Impl"
    // InternalQueryDsl.g:1104:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1108:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalQueryDsl.g:1109:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalQueryDsl.g:1109:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalQueryDsl.g:1110:2: ( rule__Or__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            }
            // InternalQueryDsl.g:1111:2: ( rule__Or__RightAssignment_1_2 )
            // InternalQueryDsl.g:1111:3: rule__Or__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Or__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2__Impl"


    // $ANTLR start "rule__And__Group__0"
    // InternalQueryDsl.g:1120:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1124:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalQueryDsl.g:1125:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__And__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__And__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0"


    // $ANTLR start "rule__And__Group__0__Impl"
    // InternalQueryDsl.g:1132:1: rule__And__Group__0__Impl : ( ruleEquality ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1136:1: ( ( ruleEquality ) )
            // InternalQueryDsl.g:1137:1: ( ruleEquality )
            {
            // InternalQueryDsl.g:1137:1: ( ruleEquality )
            // InternalQueryDsl.g:1138:2: ruleEquality
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getEqualityParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getEqualityParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0__Impl"


    // $ANTLR start "rule__And__Group__1"
    // InternalQueryDsl.g:1147:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1151:1: ( rule__And__Group__1__Impl )
            // InternalQueryDsl.g:1152:2: rule__And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1"


    // $ANTLR start "rule__And__Group__1__Impl"
    // InternalQueryDsl.g:1158:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1162:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalQueryDsl.g:1163:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalQueryDsl.g:1163:1: ( ( rule__And__Group_1__0 )* )
            // InternalQueryDsl.g:1164:2: ( rule__And__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getGroup_1()); 
            }
            // InternalQueryDsl.g:1165:2: ( rule__And__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalQueryDsl.g:1165:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__And__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1__Impl"


    // $ANTLR start "rule__And__Group_1__0"
    // InternalQueryDsl.g:1174:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1178:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalQueryDsl.g:1179:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__And__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__And__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0"


    // $ANTLR start "rule__And__Group_1__0__Impl"
    // InternalQueryDsl.g:1186:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1190:1: ( ( () ) )
            // InternalQueryDsl.g:1191:1: ( () )
            {
            // InternalQueryDsl.g:1191:1: ( () )
            // InternalQueryDsl.g:1192:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            }
            // InternalQueryDsl.g:1193:2: ()
            // InternalQueryDsl.g:1193:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0__Impl"


    // $ANTLR start "rule__And__Group_1__1"
    // InternalQueryDsl.g:1201:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1205:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalQueryDsl.g:1206:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__And__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1"


    // $ANTLR start "rule__And__Group_1__1__Impl"
    // InternalQueryDsl.g:1213:1: rule__And__Group_1__1__Impl : ( '&&' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1217:1: ( ( '&&' ) )
            // InternalQueryDsl.g:1218:1: ( '&&' )
            {
            // InternalQueryDsl.g:1218:1: ( '&&' )
            // InternalQueryDsl.g:1219:2: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1__Impl"


    // $ANTLR start "rule__And__Group_1__2"
    // InternalQueryDsl.g:1228:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1232:1: ( rule__And__Group_1__2__Impl )
            // InternalQueryDsl.g:1233:2: rule__And__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2"


    // $ANTLR start "rule__And__Group_1__2__Impl"
    // InternalQueryDsl.g:1239:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1243:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalQueryDsl.g:1244:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalQueryDsl.g:1244:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalQueryDsl.g:1245:2: ( rule__And__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            }
            // InternalQueryDsl.g:1246:2: ( rule__And__RightAssignment_1_2 )
            // InternalQueryDsl.g:1246:3: rule__And__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__And__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2__Impl"


    // $ANTLR start "rule__Equality__Group__0"
    // InternalQueryDsl.g:1255:1: rule__Equality__Group__0 : rule__Equality__Group__0__Impl rule__Equality__Group__1 ;
    public final void rule__Equality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1259:1: ( rule__Equality__Group__0__Impl rule__Equality__Group__1 )
            // InternalQueryDsl.g:1260:2: rule__Equality__Group__0__Impl rule__Equality__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Equality__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Equality__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__0"


    // $ANTLR start "rule__Equality__Group__0__Impl"
    // InternalQueryDsl.g:1267:1: rule__Equality__Group__0__Impl : ( ruleComparison ) ;
    public final void rule__Equality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1271:1: ( ( ruleComparison ) )
            // InternalQueryDsl.g:1272:1: ( ruleComparison )
            {
            // InternalQueryDsl.g:1272:1: ( ruleComparison )
            // InternalQueryDsl.g:1273:2: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__0__Impl"


    // $ANTLR start "rule__Equality__Group__1"
    // InternalQueryDsl.g:1282:1: rule__Equality__Group__1 : rule__Equality__Group__1__Impl ;
    public final void rule__Equality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1286:1: ( rule__Equality__Group__1__Impl )
            // InternalQueryDsl.g:1287:2: rule__Equality__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__1"


    // $ANTLR start "rule__Equality__Group__1__Impl"
    // InternalQueryDsl.g:1293:1: rule__Equality__Group__1__Impl : ( ( rule__Equality__Group_1__0 )* ) ;
    public final void rule__Equality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1297:1: ( ( ( rule__Equality__Group_1__0 )* ) )
            // InternalQueryDsl.g:1298:1: ( ( rule__Equality__Group_1__0 )* )
            {
            // InternalQueryDsl.g:1298:1: ( ( rule__Equality__Group_1__0 )* )
            // InternalQueryDsl.g:1299:2: ( rule__Equality__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getGroup_1()); 
            }
            // InternalQueryDsl.g:1300:2: ( rule__Equality__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=11 && LA13_0<=12)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalQueryDsl.g:1300:3: rule__Equality__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Equality__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__1__Impl"


    // $ANTLR start "rule__Equality__Group_1__0"
    // InternalQueryDsl.g:1309:1: rule__Equality__Group_1__0 : rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 ;
    public final void rule__Equality__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1313:1: ( rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 )
            // InternalQueryDsl.g:1314:2: rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Equality__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__0"


    // $ANTLR start "rule__Equality__Group_1__0__Impl"
    // InternalQueryDsl.g:1321:1: rule__Equality__Group_1__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1325:1: ( ( () ) )
            // InternalQueryDsl.g:1326:1: ( () )
            {
            // InternalQueryDsl.g:1326:1: ( () )
            // InternalQueryDsl.g:1327:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0()); 
            }
            // InternalQueryDsl.g:1328:2: ()
            // InternalQueryDsl.g:1328:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__0__Impl"


    // $ANTLR start "rule__Equality__Group_1__1"
    // InternalQueryDsl.g:1336:1: rule__Equality__Group_1__1 : rule__Equality__Group_1__1__Impl rule__Equality__Group_1__2 ;
    public final void rule__Equality__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1340:1: ( rule__Equality__Group_1__1__Impl rule__Equality__Group_1__2 )
            // InternalQueryDsl.g:1341:2: rule__Equality__Group_1__1__Impl rule__Equality__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__Equality__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__1"


    // $ANTLR start "rule__Equality__Group_1__1__Impl"
    // InternalQueryDsl.g:1348:1: rule__Equality__Group_1__1__Impl : ( ( rule__Equality__OpAssignment_1_1 ) ) ;
    public final void rule__Equality__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1352:1: ( ( ( rule__Equality__OpAssignment_1_1 ) ) )
            // InternalQueryDsl.g:1353:1: ( ( rule__Equality__OpAssignment_1_1 ) )
            {
            // InternalQueryDsl.g:1353:1: ( ( rule__Equality__OpAssignment_1_1 ) )
            // InternalQueryDsl.g:1354:2: ( rule__Equality__OpAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getOpAssignment_1_1()); 
            }
            // InternalQueryDsl.g:1355:2: ( rule__Equality__OpAssignment_1_1 )
            // InternalQueryDsl.g:1355:3: rule__Equality__OpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Equality__OpAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getOpAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__1__Impl"


    // $ANTLR start "rule__Equality__Group_1__2"
    // InternalQueryDsl.g:1363:1: rule__Equality__Group_1__2 : rule__Equality__Group_1__2__Impl ;
    public final void rule__Equality__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1367:1: ( rule__Equality__Group_1__2__Impl )
            // InternalQueryDsl.g:1368:2: rule__Equality__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__2"


    // $ANTLR start "rule__Equality__Group_1__2__Impl"
    // InternalQueryDsl.g:1374:1: rule__Equality__Group_1__2__Impl : ( ( rule__Equality__RightAssignment_1_2 ) ) ;
    public final void rule__Equality__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1378:1: ( ( ( rule__Equality__RightAssignment_1_2 ) ) )
            // InternalQueryDsl.g:1379:1: ( ( rule__Equality__RightAssignment_1_2 ) )
            {
            // InternalQueryDsl.g:1379:1: ( ( rule__Equality__RightAssignment_1_2 ) )
            // InternalQueryDsl.g:1380:2: ( rule__Equality__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getRightAssignment_1_2()); 
            }
            // InternalQueryDsl.g:1381:2: ( rule__Equality__RightAssignment_1_2 )
            // InternalQueryDsl.g:1381:3: rule__Equality__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Equality__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__2__Impl"


    // $ANTLR start "rule__Comparison__Group__0"
    // InternalQueryDsl.g:1390:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1394:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // InternalQueryDsl.g:1395:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Comparison__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0"


    // $ANTLR start "rule__Comparison__Group__0__Impl"
    // InternalQueryDsl.g:1402:1: rule__Comparison__Group__0__Impl : ( rulePlusOrMinus ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1406:1: ( ( rulePlusOrMinus ) )
            // InternalQueryDsl.g:1407:1: ( rulePlusOrMinus )
            {
            // InternalQueryDsl.g:1407:1: ( rulePlusOrMinus )
            // InternalQueryDsl.g:1408:2: rulePlusOrMinus
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getPlusOrMinusParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getPlusOrMinusParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0__Impl"


    // $ANTLR start "rule__Comparison__Group__1"
    // InternalQueryDsl.g:1417:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1421:1: ( rule__Comparison__Group__1__Impl )
            // InternalQueryDsl.g:1422:2: rule__Comparison__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1"


    // $ANTLR start "rule__Comparison__Group__1__Impl"
    // InternalQueryDsl.g:1428:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__Group_1__0 )* ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1432:1: ( ( ( rule__Comparison__Group_1__0 )* ) )
            // InternalQueryDsl.g:1433:1: ( ( rule__Comparison__Group_1__0 )* )
            {
            // InternalQueryDsl.g:1433:1: ( ( rule__Comparison__Group_1__0 )* )
            // InternalQueryDsl.g:1434:2: ( rule__Comparison__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup_1()); 
            }
            // InternalQueryDsl.g:1435:2: ( rule__Comparison__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=13 && LA14_0<=16)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalQueryDsl.g:1435:3: rule__Comparison__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Comparison__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1__0"
    // InternalQueryDsl.g:1444:1: rule__Comparison__Group_1__0 : rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 ;
    public final void rule__Comparison__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1448:1: ( rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 )
            // InternalQueryDsl.g:1449:2: rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__Comparison__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__0"


    // $ANTLR start "rule__Comparison__Group_1__0__Impl"
    // InternalQueryDsl.g:1456:1: rule__Comparison__Group_1__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1460:1: ( ( () ) )
            // InternalQueryDsl.g:1461:1: ( () )
            {
            // InternalQueryDsl.g:1461:1: ( () )
            // InternalQueryDsl.g:1462:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0()); 
            }
            // InternalQueryDsl.g:1463:2: ()
            // InternalQueryDsl.g:1463:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1__1"
    // InternalQueryDsl.g:1471:1: rule__Comparison__Group_1__1 : rule__Comparison__Group_1__1__Impl rule__Comparison__Group_1__2 ;
    public final void rule__Comparison__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1475:1: ( rule__Comparison__Group_1__1__Impl rule__Comparison__Group_1__2 )
            // InternalQueryDsl.g:1476:2: rule__Comparison__Group_1__1__Impl rule__Comparison__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__Comparison__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__1"


    // $ANTLR start "rule__Comparison__Group_1__1__Impl"
    // InternalQueryDsl.g:1483:1: rule__Comparison__Group_1__1__Impl : ( ( rule__Comparison__OpAssignment_1_1 ) ) ;
    public final void rule__Comparison__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1487:1: ( ( ( rule__Comparison__OpAssignment_1_1 ) ) )
            // InternalQueryDsl.g:1488:1: ( ( rule__Comparison__OpAssignment_1_1 ) )
            {
            // InternalQueryDsl.g:1488:1: ( ( rule__Comparison__OpAssignment_1_1 ) )
            // InternalQueryDsl.g:1489:2: ( rule__Comparison__OpAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getOpAssignment_1_1()); 
            }
            // InternalQueryDsl.g:1490:2: ( rule__Comparison__OpAssignment_1_1 )
            // InternalQueryDsl.g:1490:3: rule__Comparison__OpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__OpAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getOpAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1__2"
    // InternalQueryDsl.g:1498:1: rule__Comparison__Group_1__2 : rule__Comparison__Group_1__2__Impl ;
    public final void rule__Comparison__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1502:1: ( rule__Comparison__Group_1__2__Impl )
            // InternalQueryDsl.g:1503:2: rule__Comparison__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__2"


    // $ANTLR start "rule__Comparison__Group_1__2__Impl"
    // InternalQueryDsl.g:1509:1: rule__Comparison__Group_1__2__Impl : ( ( rule__Comparison__RightAssignment_1_2 ) ) ;
    public final void rule__Comparison__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1513:1: ( ( ( rule__Comparison__RightAssignment_1_2 ) ) )
            // InternalQueryDsl.g:1514:1: ( ( rule__Comparison__RightAssignment_1_2 ) )
            {
            // InternalQueryDsl.g:1514:1: ( ( rule__Comparison__RightAssignment_1_2 ) )
            // InternalQueryDsl.g:1515:2: ( rule__Comparison__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightAssignment_1_2()); 
            }
            // InternalQueryDsl.g:1516:2: ( rule__Comparison__RightAssignment_1_2 )
            // InternalQueryDsl.g:1516:3: rule__Comparison__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__2__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group__0"
    // InternalQueryDsl.g:1525:1: rule__PlusOrMinus__Group__0 : rule__PlusOrMinus__Group__0__Impl rule__PlusOrMinus__Group__1 ;
    public final void rule__PlusOrMinus__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1529:1: ( rule__PlusOrMinus__Group__0__Impl rule__PlusOrMinus__Group__1 )
            // InternalQueryDsl.g:1530:2: rule__PlusOrMinus__Group__0__Impl rule__PlusOrMinus__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__PlusOrMinus__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__0"


    // $ANTLR start "rule__PlusOrMinus__Group__0__Impl"
    // InternalQueryDsl.g:1537:1: rule__PlusOrMinus__Group__0__Impl : ( ruleMod ) ;
    public final void rule__PlusOrMinus__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1541:1: ( ( ruleMod ) )
            // InternalQueryDsl.g:1542:1: ( ruleMod )
            {
            // InternalQueryDsl.g:1542:1: ( ruleMod )
            // InternalQueryDsl.g:1543:2: ruleMod
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getModParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMod();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getModParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group__1"
    // InternalQueryDsl.g:1552:1: rule__PlusOrMinus__Group__1 : rule__PlusOrMinus__Group__1__Impl ;
    public final void rule__PlusOrMinus__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1556:1: ( rule__PlusOrMinus__Group__1__Impl )
            // InternalQueryDsl.g:1557:2: rule__PlusOrMinus__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__1"


    // $ANTLR start "rule__PlusOrMinus__Group__1__Impl"
    // InternalQueryDsl.g:1563:1: rule__PlusOrMinus__Group__1__Impl : ( ( rule__PlusOrMinus__Group_1__0 )* ) ;
    public final void rule__PlusOrMinus__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1567:1: ( ( ( rule__PlusOrMinus__Group_1__0 )* ) )
            // InternalQueryDsl.g:1568:1: ( ( rule__PlusOrMinus__Group_1__0 )* )
            {
            // InternalQueryDsl.g:1568:1: ( ( rule__PlusOrMinus__Group_1__0 )* )
            // InternalQueryDsl.g:1569:2: ( rule__PlusOrMinus__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getGroup_1()); 
            }
            // InternalQueryDsl.g:1570:2: ( rule__PlusOrMinus__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=26 && LA15_0<=27)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalQueryDsl.g:1570:3: rule__PlusOrMinus__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__PlusOrMinus__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1__0"
    // InternalQueryDsl.g:1579:1: rule__PlusOrMinus__Group_1__0 : rule__PlusOrMinus__Group_1__0__Impl rule__PlusOrMinus__Group_1__1 ;
    public final void rule__PlusOrMinus__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1583:1: ( rule__PlusOrMinus__Group_1__0__Impl rule__PlusOrMinus__Group_1__1 )
            // InternalQueryDsl.g:1584:2: rule__PlusOrMinus__Group_1__0__Impl rule__PlusOrMinus__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__PlusOrMinus__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__0"


    // $ANTLR start "rule__PlusOrMinus__Group_1__0__Impl"
    // InternalQueryDsl.g:1591:1: rule__PlusOrMinus__Group_1__0__Impl : ( ( rule__PlusOrMinus__Alternatives_1_0 ) ) ;
    public final void rule__PlusOrMinus__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1595:1: ( ( ( rule__PlusOrMinus__Alternatives_1_0 ) ) )
            // InternalQueryDsl.g:1596:1: ( ( rule__PlusOrMinus__Alternatives_1_0 ) )
            {
            // InternalQueryDsl.g:1596:1: ( ( rule__PlusOrMinus__Alternatives_1_0 ) )
            // InternalQueryDsl.g:1597:2: ( rule__PlusOrMinus__Alternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getAlternatives_1_0()); 
            }
            // InternalQueryDsl.g:1598:2: ( rule__PlusOrMinus__Alternatives_1_0 )
            // InternalQueryDsl.g:1598:3: rule__PlusOrMinus__Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Alternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1__1"
    // InternalQueryDsl.g:1606:1: rule__PlusOrMinus__Group_1__1 : rule__PlusOrMinus__Group_1__1__Impl ;
    public final void rule__PlusOrMinus__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1610:1: ( rule__PlusOrMinus__Group_1__1__Impl )
            // InternalQueryDsl.g:1611:2: rule__PlusOrMinus__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__1"


    // $ANTLR start "rule__PlusOrMinus__Group_1__1__Impl"
    // InternalQueryDsl.g:1617:1: rule__PlusOrMinus__Group_1__1__Impl : ( ( rule__PlusOrMinus__RightAssignment_1_1 ) ) ;
    public final void rule__PlusOrMinus__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1621:1: ( ( ( rule__PlusOrMinus__RightAssignment_1_1 ) ) )
            // InternalQueryDsl.g:1622:1: ( ( rule__PlusOrMinus__RightAssignment_1_1 ) )
            {
            // InternalQueryDsl.g:1622:1: ( ( rule__PlusOrMinus__RightAssignment_1_1 ) )
            // InternalQueryDsl.g:1623:2: ( rule__PlusOrMinus__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getRightAssignment_1_1()); 
            }
            // InternalQueryDsl.g:1624:2: ( rule__PlusOrMinus__RightAssignment_1_1 )
            // InternalQueryDsl.g:1624:3: rule__PlusOrMinus__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__0"
    // InternalQueryDsl.g:1633:1: rule__PlusOrMinus__Group_1_0_0__0 : rule__PlusOrMinus__Group_1_0_0__0__Impl rule__PlusOrMinus__Group_1_0_0__1 ;
    public final void rule__PlusOrMinus__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1637:1: ( rule__PlusOrMinus__Group_1_0_0__0__Impl rule__PlusOrMinus__Group_1_0_0__1 )
            // InternalQueryDsl.g:1638:2: rule__PlusOrMinus__Group_1_0_0__0__Impl rule__PlusOrMinus__Group_1_0_0__1
            {
            pushFollow(FOLLOW_18);
            rule__PlusOrMinus__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__0"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__0__Impl"
    // InternalQueryDsl.g:1645:1: rule__PlusOrMinus__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PlusOrMinus__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1649:1: ( ( () ) )
            // InternalQueryDsl.g:1650:1: ( () )
            {
            // InternalQueryDsl.g:1650:1: ( () )
            // InternalQueryDsl.g:1651:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0()); 
            }
            // InternalQueryDsl.g:1652:2: ()
            // InternalQueryDsl.g:1652:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__1"
    // InternalQueryDsl.g:1660:1: rule__PlusOrMinus__Group_1_0_0__1 : rule__PlusOrMinus__Group_1_0_0__1__Impl ;
    public final void rule__PlusOrMinus__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1664:1: ( rule__PlusOrMinus__Group_1_0_0__1__Impl )
            // InternalQueryDsl.g:1665:2: rule__PlusOrMinus__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__1"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__1__Impl"
    // InternalQueryDsl.g:1671:1: rule__PlusOrMinus__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__PlusOrMinus__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1675:1: ( ( '+' ) )
            // InternalQueryDsl.g:1676:1: ( '+' )
            {
            // InternalQueryDsl.g:1676:1: ( '+' )
            // InternalQueryDsl.g:1677:2: '+'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__0"
    // InternalQueryDsl.g:1687:1: rule__PlusOrMinus__Group_1_0_1__0 : rule__PlusOrMinus__Group_1_0_1__0__Impl rule__PlusOrMinus__Group_1_0_1__1 ;
    public final void rule__PlusOrMinus__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1691:1: ( rule__PlusOrMinus__Group_1_0_1__0__Impl rule__PlusOrMinus__Group_1_0_1__1 )
            // InternalQueryDsl.g:1692:2: rule__PlusOrMinus__Group_1_0_1__0__Impl rule__PlusOrMinus__Group_1_0_1__1
            {
            pushFollow(FOLLOW_16);
            rule__PlusOrMinus__Group_1_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__0"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__0__Impl"
    // InternalQueryDsl.g:1699:1: rule__PlusOrMinus__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__PlusOrMinus__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1703:1: ( ( () ) )
            // InternalQueryDsl.g:1704:1: ( () )
            {
            // InternalQueryDsl.g:1704:1: ( () )
            // InternalQueryDsl.g:1705:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0()); 
            }
            // InternalQueryDsl.g:1706:2: ()
            // InternalQueryDsl.g:1706:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__1"
    // InternalQueryDsl.g:1714:1: rule__PlusOrMinus__Group_1_0_1__1 : rule__PlusOrMinus__Group_1_0_1__1__Impl ;
    public final void rule__PlusOrMinus__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1718:1: ( rule__PlusOrMinus__Group_1_0_1__1__Impl )
            // InternalQueryDsl.g:1719:2: rule__PlusOrMinus__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__1"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__1__Impl"
    // InternalQueryDsl.g:1725:1: rule__PlusOrMinus__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__PlusOrMinus__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1729:1: ( ( '-' ) )
            // InternalQueryDsl.g:1730:1: ( '-' )
            {
            // InternalQueryDsl.g:1730:1: ( '-' )
            // InternalQueryDsl.g:1731:2: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Mod__Group__0"
    // InternalQueryDsl.g:1741:1: rule__Mod__Group__0 : rule__Mod__Group__0__Impl rule__Mod__Group__1 ;
    public final void rule__Mod__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1745:1: ( rule__Mod__Group__0__Impl rule__Mod__Group__1 )
            // InternalQueryDsl.g:1746:2: rule__Mod__Group__0__Impl rule__Mod__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Mod__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Mod__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group__0"


    // $ANTLR start "rule__Mod__Group__0__Impl"
    // InternalQueryDsl.g:1753:1: rule__Mod__Group__0__Impl : ( ruleMulOrDiv ) ;
    public final void rule__Mod__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1757:1: ( ( ruleMulOrDiv ) )
            // InternalQueryDsl.g:1758:1: ( ruleMulOrDiv )
            {
            // InternalQueryDsl.g:1758:1: ( ruleMulOrDiv )
            // InternalQueryDsl.g:1759:2: ruleMulOrDiv
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getMulOrDivParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getMulOrDivParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group__0__Impl"


    // $ANTLR start "rule__Mod__Group__1"
    // InternalQueryDsl.g:1768:1: rule__Mod__Group__1 : rule__Mod__Group__1__Impl ;
    public final void rule__Mod__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1772:1: ( rule__Mod__Group__1__Impl )
            // InternalQueryDsl.g:1773:2: rule__Mod__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mod__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group__1"


    // $ANTLR start "rule__Mod__Group__1__Impl"
    // InternalQueryDsl.g:1779:1: rule__Mod__Group__1__Impl : ( ( rule__Mod__Group_1__0 )* ) ;
    public final void rule__Mod__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1783:1: ( ( ( rule__Mod__Group_1__0 )* ) )
            // InternalQueryDsl.g:1784:1: ( ( rule__Mod__Group_1__0 )* )
            {
            // InternalQueryDsl.g:1784:1: ( ( rule__Mod__Group_1__0 )* )
            // InternalQueryDsl.g:1785:2: ( rule__Mod__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getGroup_1()); 
            }
            // InternalQueryDsl.g:1786:2: ( rule__Mod__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==31) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalQueryDsl.g:1786:3: rule__Mod__Group_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__Mod__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group__1__Impl"


    // $ANTLR start "rule__Mod__Group_1__0"
    // InternalQueryDsl.g:1795:1: rule__Mod__Group_1__0 : rule__Mod__Group_1__0__Impl rule__Mod__Group_1__1 ;
    public final void rule__Mod__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1799:1: ( rule__Mod__Group_1__0__Impl rule__Mod__Group_1__1 )
            // InternalQueryDsl.g:1800:2: rule__Mod__Group_1__0__Impl rule__Mod__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__Mod__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Mod__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_1__0"


    // $ANTLR start "rule__Mod__Group_1__0__Impl"
    // InternalQueryDsl.g:1807:1: rule__Mod__Group_1__0__Impl : ( ( rule__Mod__Group_1_0__0 ) ) ;
    public final void rule__Mod__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1811:1: ( ( ( rule__Mod__Group_1_0__0 ) ) )
            // InternalQueryDsl.g:1812:1: ( ( rule__Mod__Group_1_0__0 ) )
            {
            // InternalQueryDsl.g:1812:1: ( ( rule__Mod__Group_1_0__0 ) )
            // InternalQueryDsl.g:1813:2: ( rule__Mod__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getGroup_1_0()); 
            }
            // InternalQueryDsl.g:1814:2: ( rule__Mod__Group_1_0__0 )
            // InternalQueryDsl.g:1814:3: rule__Mod__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__Mod__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_1__0__Impl"


    // $ANTLR start "rule__Mod__Group_1__1"
    // InternalQueryDsl.g:1822:1: rule__Mod__Group_1__1 : rule__Mod__Group_1__1__Impl ;
    public final void rule__Mod__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1826:1: ( rule__Mod__Group_1__1__Impl )
            // InternalQueryDsl.g:1827:2: rule__Mod__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mod__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_1__1"


    // $ANTLR start "rule__Mod__Group_1__1__Impl"
    // InternalQueryDsl.g:1833:1: rule__Mod__Group_1__1__Impl : ( ( rule__Mod__RightAssignment_1_1 ) ) ;
    public final void rule__Mod__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1837:1: ( ( ( rule__Mod__RightAssignment_1_1 ) ) )
            // InternalQueryDsl.g:1838:1: ( ( rule__Mod__RightAssignment_1_1 ) )
            {
            // InternalQueryDsl.g:1838:1: ( ( rule__Mod__RightAssignment_1_1 ) )
            // InternalQueryDsl.g:1839:2: ( rule__Mod__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getRightAssignment_1_1()); 
            }
            // InternalQueryDsl.g:1840:2: ( rule__Mod__RightAssignment_1_1 )
            // InternalQueryDsl.g:1840:3: rule__Mod__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Mod__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_1__1__Impl"


    // $ANTLR start "rule__Mod__Group_1_0__0"
    // InternalQueryDsl.g:1849:1: rule__Mod__Group_1_0__0 : rule__Mod__Group_1_0__0__Impl rule__Mod__Group_1_0__1 ;
    public final void rule__Mod__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1853:1: ( rule__Mod__Group_1_0__0__Impl rule__Mod__Group_1_0__1 )
            // InternalQueryDsl.g:1854:2: rule__Mod__Group_1_0__0__Impl rule__Mod__Group_1_0__1
            {
            pushFollow(FOLLOW_19);
            rule__Mod__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Mod__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_1_0__0"


    // $ANTLR start "rule__Mod__Group_1_0__0__Impl"
    // InternalQueryDsl.g:1861:1: rule__Mod__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Mod__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1865:1: ( ( () ) )
            // InternalQueryDsl.g:1866:1: ( () )
            {
            // InternalQueryDsl.g:1866:1: ( () )
            // InternalQueryDsl.g:1867:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getModLeftAction_1_0_0()); 
            }
            // InternalQueryDsl.g:1868:2: ()
            // InternalQueryDsl.g:1868:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getModLeftAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_1_0__0__Impl"


    // $ANTLR start "rule__Mod__Group_1_0__1"
    // InternalQueryDsl.g:1876:1: rule__Mod__Group_1_0__1 : rule__Mod__Group_1_0__1__Impl ;
    public final void rule__Mod__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1880:1: ( rule__Mod__Group_1_0__1__Impl )
            // InternalQueryDsl.g:1881:2: rule__Mod__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mod__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_1_0__1"


    // $ANTLR start "rule__Mod__Group_1_0__1__Impl"
    // InternalQueryDsl.g:1887:1: rule__Mod__Group_1_0__1__Impl : ( ( rule__Mod__OpAssignment_1_0_1 ) ) ;
    public final void rule__Mod__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1891:1: ( ( ( rule__Mod__OpAssignment_1_0_1 ) ) )
            // InternalQueryDsl.g:1892:1: ( ( rule__Mod__OpAssignment_1_0_1 ) )
            {
            // InternalQueryDsl.g:1892:1: ( ( rule__Mod__OpAssignment_1_0_1 ) )
            // InternalQueryDsl.g:1893:2: ( rule__Mod__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getOpAssignment_1_0_1()); 
            }
            // InternalQueryDsl.g:1894:2: ( rule__Mod__OpAssignment_1_0_1 )
            // InternalQueryDsl.g:1894:3: rule__Mod__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Mod__OpAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getOpAssignment_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_1_0__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group__0"
    // InternalQueryDsl.g:1903:1: rule__MulOrDiv__Group__0 : rule__MulOrDiv__Group__0__Impl rule__MulOrDiv__Group__1 ;
    public final void rule__MulOrDiv__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1907:1: ( rule__MulOrDiv__Group__0__Impl rule__MulOrDiv__Group__1 )
            // InternalQueryDsl.g:1908:2: rule__MulOrDiv__Group__0__Impl rule__MulOrDiv__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__MulOrDiv__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__0"


    // $ANTLR start "rule__MulOrDiv__Group__0__Impl"
    // InternalQueryDsl.g:1915:1: rule__MulOrDiv__Group__0__Impl : ( ruleExpo ) ;
    public final void rule__MulOrDiv__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1919:1: ( ( ruleExpo ) )
            // InternalQueryDsl.g:1920:1: ( ruleExpo )
            {
            // InternalQueryDsl.g:1920:1: ( ruleExpo )
            // InternalQueryDsl.g:1921:2: ruleExpo
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getExpoParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpo();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getExpoParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__0__Impl"


    // $ANTLR start "rule__MulOrDiv__Group__1"
    // InternalQueryDsl.g:1930:1: rule__MulOrDiv__Group__1 : rule__MulOrDiv__Group__1__Impl ;
    public final void rule__MulOrDiv__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1934:1: ( rule__MulOrDiv__Group__1__Impl )
            // InternalQueryDsl.g:1935:2: rule__MulOrDiv__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__1"


    // $ANTLR start "rule__MulOrDiv__Group__1__Impl"
    // InternalQueryDsl.g:1941:1: rule__MulOrDiv__Group__1__Impl : ( ( rule__MulOrDiv__Group_1__0 )* ) ;
    public final void rule__MulOrDiv__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1945:1: ( ( ( rule__MulOrDiv__Group_1__0 )* ) )
            // InternalQueryDsl.g:1946:1: ( ( rule__MulOrDiv__Group_1__0 )* )
            {
            // InternalQueryDsl.g:1946:1: ( ( rule__MulOrDiv__Group_1__0 )* )
            // InternalQueryDsl.g:1947:2: ( rule__MulOrDiv__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getGroup_1()); 
            }
            // InternalQueryDsl.g:1948:2: ( rule__MulOrDiv__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=17 && LA17_0<=18)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalQueryDsl.g:1948:3: rule__MulOrDiv__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__MulOrDiv__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1__0"
    // InternalQueryDsl.g:1957:1: rule__MulOrDiv__Group_1__0 : rule__MulOrDiv__Group_1__0__Impl rule__MulOrDiv__Group_1__1 ;
    public final void rule__MulOrDiv__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1961:1: ( rule__MulOrDiv__Group_1__0__Impl rule__MulOrDiv__Group_1__1 )
            // InternalQueryDsl.g:1962:2: rule__MulOrDiv__Group_1__0__Impl rule__MulOrDiv__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__MulOrDiv__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__0"


    // $ANTLR start "rule__MulOrDiv__Group_1__0__Impl"
    // InternalQueryDsl.g:1969:1: rule__MulOrDiv__Group_1__0__Impl : ( ( rule__MulOrDiv__Group_1_0__0 ) ) ;
    public final void rule__MulOrDiv__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1973:1: ( ( ( rule__MulOrDiv__Group_1_0__0 ) ) )
            // InternalQueryDsl.g:1974:1: ( ( rule__MulOrDiv__Group_1_0__0 ) )
            {
            // InternalQueryDsl.g:1974:1: ( ( rule__MulOrDiv__Group_1_0__0 ) )
            // InternalQueryDsl.g:1975:2: ( rule__MulOrDiv__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getGroup_1_0()); 
            }
            // InternalQueryDsl.g:1976:2: ( rule__MulOrDiv__Group_1_0__0 )
            // InternalQueryDsl.g:1976:3: rule__MulOrDiv__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__0__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1__1"
    // InternalQueryDsl.g:1984:1: rule__MulOrDiv__Group_1__1 : rule__MulOrDiv__Group_1__1__Impl ;
    public final void rule__MulOrDiv__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1988:1: ( rule__MulOrDiv__Group_1__1__Impl )
            // InternalQueryDsl.g:1989:2: rule__MulOrDiv__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__1"


    // $ANTLR start "rule__MulOrDiv__Group_1__1__Impl"
    // InternalQueryDsl.g:1995:1: rule__MulOrDiv__Group_1__1__Impl : ( ( rule__MulOrDiv__RightAssignment_1_1 ) ) ;
    public final void rule__MulOrDiv__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:1999:1: ( ( ( rule__MulOrDiv__RightAssignment_1_1 ) ) )
            // InternalQueryDsl.g:2000:1: ( ( rule__MulOrDiv__RightAssignment_1_1 ) )
            {
            // InternalQueryDsl.g:2000:1: ( ( rule__MulOrDiv__RightAssignment_1_1 ) )
            // InternalQueryDsl.g:2001:2: ( rule__MulOrDiv__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getRightAssignment_1_1()); 
            }
            // InternalQueryDsl.g:2002:2: ( rule__MulOrDiv__RightAssignment_1_1 )
            // InternalQueryDsl.g:2002:3: rule__MulOrDiv__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1_0__0"
    // InternalQueryDsl.g:2011:1: rule__MulOrDiv__Group_1_0__0 : rule__MulOrDiv__Group_1_0__0__Impl rule__MulOrDiv__Group_1_0__1 ;
    public final void rule__MulOrDiv__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2015:1: ( rule__MulOrDiv__Group_1_0__0__Impl rule__MulOrDiv__Group_1_0__1 )
            // InternalQueryDsl.g:2016:2: rule__MulOrDiv__Group_1_0__0__Impl rule__MulOrDiv__Group_1_0__1
            {
            pushFollow(FOLLOW_21);
            rule__MulOrDiv__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0__0"


    // $ANTLR start "rule__MulOrDiv__Group_1_0__0__Impl"
    // InternalQueryDsl.g:2023:1: rule__MulOrDiv__Group_1_0__0__Impl : ( () ) ;
    public final void rule__MulOrDiv__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2027:1: ( ( () ) )
            // InternalQueryDsl.g:2028:1: ( () )
            {
            // InternalQueryDsl.g:2028:1: ( () )
            // InternalQueryDsl.g:2029:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getMulOrDivLeftAction_1_0_0()); 
            }
            // InternalQueryDsl.g:2030:2: ()
            // InternalQueryDsl.g:2030:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getMulOrDivLeftAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0__0__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1_0__1"
    // InternalQueryDsl.g:2038:1: rule__MulOrDiv__Group_1_0__1 : rule__MulOrDiv__Group_1_0__1__Impl ;
    public final void rule__MulOrDiv__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2042:1: ( rule__MulOrDiv__Group_1_0__1__Impl )
            // InternalQueryDsl.g:2043:2: rule__MulOrDiv__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0__1"


    // $ANTLR start "rule__MulOrDiv__Group_1_0__1__Impl"
    // InternalQueryDsl.g:2049:1: rule__MulOrDiv__Group_1_0__1__Impl : ( ( rule__MulOrDiv__OpAssignment_1_0_1 ) ) ;
    public final void rule__MulOrDiv__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2053:1: ( ( ( rule__MulOrDiv__OpAssignment_1_0_1 ) ) )
            // InternalQueryDsl.g:2054:1: ( ( rule__MulOrDiv__OpAssignment_1_0_1 ) )
            {
            // InternalQueryDsl.g:2054:1: ( ( rule__MulOrDiv__OpAssignment_1_0_1 ) )
            // InternalQueryDsl.g:2055:2: ( rule__MulOrDiv__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getOpAssignment_1_0_1()); 
            }
            // InternalQueryDsl.g:2056:2: ( rule__MulOrDiv__OpAssignment_1_0_1 )
            // InternalQueryDsl.g:2056:3: rule__MulOrDiv__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__OpAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getOpAssignment_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1_0__1__Impl"


    // $ANTLR start "rule__Expo__Group__0"
    // InternalQueryDsl.g:2065:1: rule__Expo__Group__0 : rule__Expo__Group__0__Impl rule__Expo__Group__1 ;
    public final void rule__Expo__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2069:1: ( rule__Expo__Group__0__Impl rule__Expo__Group__1 )
            // InternalQueryDsl.g:2070:2: rule__Expo__Group__0__Impl rule__Expo__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Expo__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Expo__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group__0"


    // $ANTLR start "rule__Expo__Group__0__Impl"
    // InternalQueryDsl.g:2077:1: rule__Expo__Group__0__Impl : ( rulePrefixed ) ;
    public final void rule__Expo__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2081:1: ( ( rulePrefixed ) )
            // InternalQueryDsl.g:2082:1: ( rulePrefixed )
            {
            // InternalQueryDsl.g:2082:1: ( rulePrefixed )
            // InternalQueryDsl.g:2083:2: rulePrefixed
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getPrefixedParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrefixed();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getPrefixedParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group__0__Impl"


    // $ANTLR start "rule__Expo__Group__1"
    // InternalQueryDsl.g:2092:1: rule__Expo__Group__1 : rule__Expo__Group__1__Impl ;
    public final void rule__Expo__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2096:1: ( rule__Expo__Group__1__Impl )
            // InternalQueryDsl.g:2097:2: rule__Expo__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expo__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group__1"


    // $ANTLR start "rule__Expo__Group__1__Impl"
    // InternalQueryDsl.g:2103:1: rule__Expo__Group__1__Impl : ( ( rule__Expo__Group_1__0 )* ) ;
    public final void rule__Expo__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2107:1: ( ( ( rule__Expo__Group_1__0 )* ) )
            // InternalQueryDsl.g:2108:1: ( ( rule__Expo__Group_1__0 )* )
            {
            // InternalQueryDsl.g:2108:1: ( ( rule__Expo__Group_1__0 )* )
            // InternalQueryDsl.g:2109:2: ( rule__Expo__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getGroup_1()); 
            }
            // InternalQueryDsl.g:2110:2: ( rule__Expo__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==32) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalQueryDsl.g:2110:3: rule__Expo__Group_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__Expo__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group__1__Impl"


    // $ANTLR start "rule__Expo__Group_1__0"
    // InternalQueryDsl.g:2119:1: rule__Expo__Group_1__0 : rule__Expo__Group_1__0__Impl rule__Expo__Group_1__1 ;
    public final void rule__Expo__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2123:1: ( rule__Expo__Group_1__0__Impl rule__Expo__Group_1__1 )
            // InternalQueryDsl.g:2124:2: rule__Expo__Group_1__0__Impl rule__Expo__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__Expo__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Expo__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group_1__0"


    // $ANTLR start "rule__Expo__Group_1__0__Impl"
    // InternalQueryDsl.g:2131:1: rule__Expo__Group_1__0__Impl : ( ( rule__Expo__Group_1_0__0 ) ) ;
    public final void rule__Expo__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2135:1: ( ( ( rule__Expo__Group_1_0__0 ) ) )
            // InternalQueryDsl.g:2136:1: ( ( rule__Expo__Group_1_0__0 ) )
            {
            // InternalQueryDsl.g:2136:1: ( ( rule__Expo__Group_1_0__0 ) )
            // InternalQueryDsl.g:2137:2: ( rule__Expo__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getGroup_1_0()); 
            }
            // InternalQueryDsl.g:2138:2: ( rule__Expo__Group_1_0__0 )
            // InternalQueryDsl.g:2138:3: rule__Expo__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__Expo__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group_1__0__Impl"


    // $ANTLR start "rule__Expo__Group_1__1"
    // InternalQueryDsl.g:2146:1: rule__Expo__Group_1__1 : rule__Expo__Group_1__1__Impl ;
    public final void rule__Expo__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2150:1: ( rule__Expo__Group_1__1__Impl )
            // InternalQueryDsl.g:2151:2: rule__Expo__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expo__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group_1__1"


    // $ANTLR start "rule__Expo__Group_1__1__Impl"
    // InternalQueryDsl.g:2157:1: rule__Expo__Group_1__1__Impl : ( ( rule__Expo__RightAssignment_1_1 ) ) ;
    public final void rule__Expo__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2161:1: ( ( ( rule__Expo__RightAssignment_1_1 ) ) )
            // InternalQueryDsl.g:2162:1: ( ( rule__Expo__RightAssignment_1_1 ) )
            {
            // InternalQueryDsl.g:2162:1: ( ( rule__Expo__RightAssignment_1_1 ) )
            // InternalQueryDsl.g:2163:2: ( rule__Expo__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getRightAssignment_1_1()); 
            }
            // InternalQueryDsl.g:2164:2: ( rule__Expo__RightAssignment_1_1 )
            // InternalQueryDsl.g:2164:3: rule__Expo__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Expo__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group_1__1__Impl"


    // $ANTLR start "rule__Expo__Group_1_0__0"
    // InternalQueryDsl.g:2173:1: rule__Expo__Group_1_0__0 : rule__Expo__Group_1_0__0__Impl rule__Expo__Group_1_0__1 ;
    public final void rule__Expo__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2177:1: ( rule__Expo__Group_1_0__0__Impl rule__Expo__Group_1_0__1 )
            // InternalQueryDsl.g:2178:2: rule__Expo__Group_1_0__0__Impl rule__Expo__Group_1_0__1
            {
            pushFollow(FOLLOW_23);
            rule__Expo__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Expo__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group_1_0__0"


    // $ANTLR start "rule__Expo__Group_1_0__0__Impl"
    // InternalQueryDsl.g:2185:1: rule__Expo__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Expo__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2189:1: ( ( () ) )
            // InternalQueryDsl.g:2190:1: ( () )
            {
            // InternalQueryDsl.g:2190:1: ( () )
            // InternalQueryDsl.g:2191:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getExpoLeftAction_1_0_0()); 
            }
            // InternalQueryDsl.g:2192:2: ()
            // InternalQueryDsl.g:2192:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getExpoLeftAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group_1_0__0__Impl"


    // $ANTLR start "rule__Expo__Group_1_0__1"
    // InternalQueryDsl.g:2200:1: rule__Expo__Group_1_0__1 : rule__Expo__Group_1_0__1__Impl ;
    public final void rule__Expo__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2204:1: ( rule__Expo__Group_1_0__1__Impl )
            // InternalQueryDsl.g:2205:2: rule__Expo__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expo__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group_1_0__1"


    // $ANTLR start "rule__Expo__Group_1_0__1__Impl"
    // InternalQueryDsl.g:2211:1: rule__Expo__Group_1_0__1__Impl : ( ( rule__Expo__OpAssignment_1_0_1 ) ) ;
    public final void rule__Expo__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2215:1: ( ( ( rule__Expo__OpAssignment_1_0_1 ) ) )
            // InternalQueryDsl.g:2216:1: ( ( rule__Expo__OpAssignment_1_0_1 ) )
            {
            // InternalQueryDsl.g:2216:1: ( ( rule__Expo__OpAssignment_1_0_1 ) )
            // InternalQueryDsl.g:2217:2: ( rule__Expo__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getOpAssignment_1_0_1()); 
            }
            // InternalQueryDsl.g:2218:2: ( rule__Expo__OpAssignment_1_0_1 )
            // InternalQueryDsl.g:2218:3: rule__Expo__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Expo__OpAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getOpAssignment_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__Group_1_0__1__Impl"


    // $ANTLR start "rule__Prefixed__Group_0__0"
    // InternalQueryDsl.g:2227:1: rule__Prefixed__Group_0__0 : rule__Prefixed__Group_0__0__Impl rule__Prefixed__Group_0__1 ;
    public final void rule__Prefixed__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2231:1: ( rule__Prefixed__Group_0__0__Impl rule__Prefixed__Group_0__1 )
            // InternalQueryDsl.g:2232:2: rule__Prefixed__Group_0__0__Impl rule__Prefixed__Group_0__1
            {
            pushFollow(FOLLOW_25);
            rule__Prefixed__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Prefixed__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_0__0"


    // $ANTLR start "rule__Prefixed__Group_0__0__Impl"
    // InternalQueryDsl.g:2239:1: rule__Prefixed__Group_0__0__Impl : ( () ) ;
    public final void rule__Prefixed__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2243:1: ( ( () ) )
            // InternalQueryDsl.g:2244:1: ( () )
            {
            // InternalQueryDsl.g:2244:1: ( () )
            // InternalQueryDsl.g:2245:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getNotAction_0_0()); 
            }
            // InternalQueryDsl.g:2246:2: ()
            // InternalQueryDsl.g:2246:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getNotAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_0__0__Impl"


    // $ANTLR start "rule__Prefixed__Group_0__1"
    // InternalQueryDsl.g:2254:1: rule__Prefixed__Group_0__1 : rule__Prefixed__Group_0__1__Impl rule__Prefixed__Group_0__2 ;
    public final void rule__Prefixed__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2258:1: ( rule__Prefixed__Group_0__1__Impl rule__Prefixed__Group_0__2 )
            // InternalQueryDsl.g:2259:2: rule__Prefixed__Group_0__1__Impl rule__Prefixed__Group_0__2
            {
            pushFollow(FOLLOW_6);
            rule__Prefixed__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Prefixed__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_0__1"


    // $ANTLR start "rule__Prefixed__Group_0__1__Impl"
    // InternalQueryDsl.g:2266:1: rule__Prefixed__Group_0__1__Impl : ( ( '!' ) ) ;
    public final void rule__Prefixed__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2270:1: ( ( ( '!' ) ) )
            // InternalQueryDsl.g:2271:1: ( ( '!' ) )
            {
            // InternalQueryDsl.g:2271:1: ( ( '!' ) )
            // InternalQueryDsl.g:2272:2: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1()); 
            }
            // InternalQueryDsl.g:2273:2: ( '!' )
            // InternalQueryDsl.g:2273:3: '!'
            {
            match(input,28,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_0__1__Impl"


    // $ANTLR start "rule__Prefixed__Group_0__2"
    // InternalQueryDsl.g:2281:1: rule__Prefixed__Group_0__2 : rule__Prefixed__Group_0__2__Impl ;
    public final void rule__Prefixed__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2285:1: ( rule__Prefixed__Group_0__2__Impl )
            // InternalQueryDsl.g:2286:2: rule__Prefixed__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Prefixed__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_0__2"


    // $ANTLR start "rule__Prefixed__Group_0__2__Impl"
    // InternalQueryDsl.g:2292:1: rule__Prefixed__Group_0__2__Impl : ( ( rule__Prefixed__ExpressionAssignment_0_2 ) ) ;
    public final void rule__Prefixed__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2296:1: ( ( ( rule__Prefixed__ExpressionAssignment_0_2 ) ) )
            // InternalQueryDsl.g:2297:1: ( ( rule__Prefixed__ExpressionAssignment_0_2 ) )
            {
            // InternalQueryDsl.g:2297:1: ( ( rule__Prefixed__ExpressionAssignment_0_2 ) )
            // InternalQueryDsl.g:2298:2: ( rule__Prefixed__ExpressionAssignment_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAssignment_0_2()); 
            }
            // InternalQueryDsl.g:2299:2: ( rule__Prefixed__ExpressionAssignment_0_2 )
            // InternalQueryDsl.g:2299:3: rule__Prefixed__ExpressionAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__Prefixed__ExpressionAssignment_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExpressionAssignment_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_0__2__Impl"


    // $ANTLR start "rule__Prefixed__Group_1__0"
    // InternalQueryDsl.g:2308:1: rule__Prefixed__Group_1__0 : rule__Prefixed__Group_1__0__Impl rule__Prefixed__Group_1__1 ;
    public final void rule__Prefixed__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2312:1: ( rule__Prefixed__Group_1__0__Impl rule__Prefixed__Group_1__1 )
            // InternalQueryDsl.g:2313:2: rule__Prefixed__Group_1__0__Impl rule__Prefixed__Group_1__1
            {
            pushFollow(FOLLOW_26);
            rule__Prefixed__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Prefixed__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_1__0"


    // $ANTLR start "rule__Prefixed__Group_1__0__Impl"
    // InternalQueryDsl.g:2320:1: rule__Prefixed__Group_1__0__Impl : ( () ) ;
    public final void rule__Prefixed__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2324:1: ( ( () ) )
            // InternalQueryDsl.g:2325:1: ( () )
            {
            // InternalQueryDsl.g:2325:1: ( () )
            // InternalQueryDsl.g:2326:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0()); 
            }
            // InternalQueryDsl.g:2327:2: ()
            // InternalQueryDsl.g:2327:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_1__0__Impl"


    // $ANTLR start "rule__Prefixed__Group_1__1"
    // InternalQueryDsl.g:2335:1: rule__Prefixed__Group_1__1 : rule__Prefixed__Group_1__1__Impl rule__Prefixed__Group_1__2 ;
    public final void rule__Prefixed__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2339:1: ( rule__Prefixed__Group_1__1__Impl rule__Prefixed__Group_1__2 )
            // InternalQueryDsl.g:2340:2: rule__Prefixed__Group_1__1__Impl rule__Prefixed__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__Prefixed__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Prefixed__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_1__1"


    // $ANTLR start "rule__Prefixed__Group_1__1__Impl"
    // InternalQueryDsl.g:2347:1: rule__Prefixed__Group_1__1__Impl : ( ( '-' ) ) ;
    public final void rule__Prefixed__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2351:1: ( ( ( '-' ) ) )
            // InternalQueryDsl.g:2352:1: ( ( '-' ) )
            {
            // InternalQueryDsl.g:2352:1: ( ( '-' ) )
            // InternalQueryDsl.g:2353:2: ( '-' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1()); 
            }
            // InternalQueryDsl.g:2354:2: ( '-' )
            // InternalQueryDsl.g:2354:3: '-'
            {
            match(input,27,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_1__1__Impl"


    // $ANTLR start "rule__Prefixed__Group_1__2"
    // InternalQueryDsl.g:2362:1: rule__Prefixed__Group_1__2 : rule__Prefixed__Group_1__2__Impl ;
    public final void rule__Prefixed__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2366:1: ( rule__Prefixed__Group_1__2__Impl )
            // InternalQueryDsl.g:2367:2: rule__Prefixed__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Prefixed__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_1__2"


    // $ANTLR start "rule__Prefixed__Group_1__2__Impl"
    // InternalQueryDsl.g:2373:1: rule__Prefixed__Group_1__2__Impl : ( ( rule__Prefixed__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Prefixed__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2377:1: ( ( ( rule__Prefixed__ExpressionAssignment_1_2 ) ) )
            // InternalQueryDsl.g:2378:1: ( ( rule__Prefixed__ExpressionAssignment_1_2 ) )
            {
            // InternalQueryDsl.g:2378:1: ( ( rule__Prefixed__ExpressionAssignment_1_2 ) )
            // InternalQueryDsl.g:2379:2: ( rule__Prefixed__ExpressionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAssignment_1_2()); 
            }
            // InternalQueryDsl.g:2380:2: ( rule__Prefixed__ExpressionAssignment_1_2 )
            // InternalQueryDsl.g:2380:3: rule__Prefixed__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Prefixed__ExpressionAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExpressionAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_1__2__Impl"


    // $ANTLR start "rule__Atomic__Group_0__0"
    // InternalQueryDsl.g:2389:1: rule__Atomic__Group_0__0 : rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1 ;
    public final void rule__Atomic__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2393:1: ( rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1 )
            // InternalQueryDsl.g:2394:2: rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1
            {
            pushFollow(FOLLOW_27);
            rule__Atomic__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__0"


    // $ANTLR start "rule__Atomic__Group_0__0__Impl"
    // InternalQueryDsl.g:2401:1: rule__Atomic__Group_0__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2405:1: ( ( () ) )
            // InternalQueryDsl.g:2406:1: ( () )
            {
            // InternalQueryDsl.g:2406:1: ( () )
            // InternalQueryDsl.g:2407:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getPrimaryAction_0_0()); 
            }
            // InternalQueryDsl.g:2408:2: ()
            // InternalQueryDsl.g:2408:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getPrimaryAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__0__Impl"


    // $ANTLR start "rule__Atomic__Group_0__1"
    // InternalQueryDsl.g:2416:1: rule__Atomic__Group_0__1 : rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2 ;
    public final void rule__Atomic__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2420:1: ( rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2 )
            // InternalQueryDsl.g:2421:2: rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2
            {
            pushFollow(FOLLOW_6);
            rule__Atomic__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__1"


    // $ANTLR start "rule__Atomic__Group_0__1__Impl"
    // InternalQueryDsl.g:2428:1: rule__Atomic__Group_0__1__Impl : ( '(' ) ;
    public final void rule__Atomic__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2432:1: ( ( '(' ) )
            // InternalQueryDsl.g:2433:1: ( '(' )
            {
            // InternalQueryDsl.g:2433:1: ( '(' )
            // InternalQueryDsl.g:2434:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_1()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__1__Impl"


    // $ANTLR start "rule__Atomic__Group_0__2"
    // InternalQueryDsl.g:2443:1: rule__Atomic__Group_0__2 : rule__Atomic__Group_0__2__Impl rule__Atomic__Group_0__3 ;
    public final void rule__Atomic__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2447:1: ( rule__Atomic__Group_0__2__Impl rule__Atomic__Group_0__3 )
            // InternalQueryDsl.g:2448:2: rule__Atomic__Group_0__2__Impl rule__Atomic__Group_0__3
            {
            pushFollow(FOLLOW_28);
            rule__Atomic__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_0__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__2"


    // $ANTLR start "rule__Atomic__Group_0__2__Impl"
    // InternalQueryDsl.g:2455:1: rule__Atomic__Group_0__2__Impl : ( ( rule__Atomic__ExprAssignment_0_2 ) ) ;
    public final void rule__Atomic__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2459:1: ( ( ( rule__Atomic__ExprAssignment_0_2 ) ) )
            // InternalQueryDsl.g:2460:1: ( ( rule__Atomic__ExprAssignment_0_2 ) )
            {
            // InternalQueryDsl.g:2460:1: ( ( rule__Atomic__ExprAssignment_0_2 ) )
            // InternalQueryDsl.g:2461:2: ( rule__Atomic__ExprAssignment_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExprAssignment_0_2()); 
            }
            // InternalQueryDsl.g:2462:2: ( rule__Atomic__ExprAssignment_0_2 )
            // InternalQueryDsl.g:2462:3: rule__Atomic__ExprAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__ExprAssignment_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getExprAssignment_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__2__Impl"


    // $ANTLR start "rule__Atomic__Group_0__3"
    // InternalQueryDsl.g:2470:1: rule__Atomic__Group_0__3 : rule__Atomic__Group_0__3__Impl ;
    public final void rule__Atomic__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2474:1: ( rule__Atomic__Group_0__3__Impl )
            // InternalQueryDsl.g:2475:2: rule__Atomic__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__3"


    // $ANTLR start "rule__Atomic__Group_0__3__Impl"
    // InternalQueryDsl.g:2481:1: rule__Atomic__Group_0__3__Impl : ( ')' ) ;
    public final void rule__Atomic__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2485:1: ( ( ')' ) )
            // InternalQueryDsl.g:2486:1: ( ')' )
            {
            // InternalQueryDsl.g:2486:1: ( ')' )
            // InternalQueryDsl.g:2487:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_3()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__3__Impl"


    // $ANTLR start "rule__Atomic__Group_1__0"
    // InternalQueryDsl.g:2497:1: rule__Atomic__Group_1__0 : rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1 ;
    public final void rule__Atomic__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2501:1: ( rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1 )
            // InternalQueryDsl.g:2502:2: rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1
            {
            pushFollow(FOLLOW_29);
            rule__Atomic__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__0"


    // $ANTLR start "rule__Atomic__Group_1__0__Impl"
    // InternalQueryDsl.g:2509:1: rule__Atomic__Group_1__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2513:1: ( ( () ) )
            // InternalQueryDsl.g:2514:1: ( () )
            {
            // InternalQueryDsl.g:2514:1: ( () )
            // InternalQueryDsl.g:2515:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getIntConstantAction_1_0()); 
            }
            // InternalQueryDsl.g:2516:2: ()
            // InternalQueryDsl.g:2516:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getIntConstantAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__0__Impl"


    // $ANTLR start "rule__Atomic__Group_1__1"
    // InternalQueryDsl.g:2524:1: rule__Atomic__Group_1__1 : rule__Atomic__Group_1__1__Impl ;
    public final void rule__Atomic__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2528:1: ( rule__Atomic__Group_1__1__Impl )
            // InternalQueryDsl.g:2529:2: rule__Atomic__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__1"


    // $ANTLR start "rule__Atomic__Group_1__1__Impl"
    // InternalQueryDsl.g:2535:1: rule__Atomic__Group_1__1__Impl : ( ( rule__Atomic__ValueAssignment_1_1 ) ) ;
    public final void rule__Atomic__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2539:1: ( ( ( rule__Atomic__ValueAssignment_1_1 ) ) )
            // InternalQueryDsl.g:2540:1: ( ( rule__Atomic__ValueAssignment_1_1 ) )
            {
            // InternalQueryDsl.g:2540:1: ( ( rule__Atomic__ValueAssignment_1_1 ) )
            // InternalQueryDsl.g:2541:2: ( rule__Atomic__ValueAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_1_1()); 
            }
            // InternalQueryDsl.g:2542:2: ( rule__Atomic__ValueAssignment_1_1 )
            // InternalQueryDsl.g:2542:3: rule__Atomic__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__ValueAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__1__Impl"


    // $ANTLR start "rule__Atomic__Group_2__0"
    // InternalQueryDsl.g:2551:1: rule__Atomic__Group_2__0 : rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1 ;
    public final void rule__Atomic__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2555:1: ( rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1 )
            // InternalQueryDsl.g:2556:2: rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1
            {
            pushFollow(FOLLOW_30);
            rule__Atomic__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__0"


    // $ANTLR start "rule__Atomic__Group_2__0__Impl"
    // InternalQueryDsl.g:2563:1: rule__Atomic__Group_2__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2567:1: ( ( () ) )
            // InternalQueryDsl.g:2568:1: ( () )
            {
            // InternalQueryDsl.g:2568:1: ( () )
            // InternalQueryDsl.g:2569:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getBoolConstantAction_2_0()); 
            }
            // InternalQueryDsl.g:2570:2: ()
            // InternalQueryDsl.g:2570:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getBoolConstantAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__0__Impl"


    // $ANTLR start "rule__Atomic__Group_2__1"
    // InternalQueryDsl.g:2578:1: rule__Atomic__Group_2__1 : rule__Atomic__Group_2__1__Impl ;
    public final void rule__Atomic__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2582:1: ( rule__Atomic__Group_2__1__Impl )
            // InternalQueryDsl.g:2583:2: rule__Atomic__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__1"


    // $ANTLR start "rule__Atomic__Group_2__1__Impl"
    // InternalQueryDsl.g:2589:1: rule__Atomic__Group_2__1__Impl : ( ( rule__Atomic__ValueAssignment_2_1 ) ) ;
    public final void rule__Atomic__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2593:1: ( ( ( rule__Atomic__ValueAssignment_2_1 ) ) )
            // InternalQueryDsl.g:2594:1: ( ( rule__Atomic__ValueAssignment_2_1 ) )
            {
            // InternalQueryDsl.g:2594:1: ( ( rule__Atomic__ValueAssignment_2_1 ) )
            // InternalQueryDsl.g:2595:2: ( rule__Atomic__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_2_1()); 
            }
            // InternalQueryDsl.g:2596:2: ( rule__Atomic__ValueAssignment_2_1 )
            // InternalQueryDsl.g:2596:3: rule__Atomic__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__ValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__1__Impl"


    // $ANTLR start "rule__Atomic__Group_3__0"
    // InternalQueryDsl.g:2605:1: rule__Atomic__Group_3__0 : rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1 ;
    public final void rule__Atomic__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2609:1: ( rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1 )
            // InternalQueryDsl.g:2610:2: rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1
            {
            pushFollow(FOLLOW_31);
            rule__Atomic__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_3__0"


    // $ANTLR start "rule__Atomic__Group_3__0__Impl"
    // InternalQueryDsl.g:2617:1: rule__Atomic__Group_3__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2621:1: ( ( () ) )
            // InternalQueryDsl.g:2622:1: ( () )
            {
            // InternalQueryDsl.g:2622:1: ( () )
            // InternalQueryDsl.g:2623:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getStringConstantAction_3_0()); 
            }
            // InternalQueryDsl.g:2624:2: ()
            // InternalQueryDsl.g:2624:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getStringConstantAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_3__0__Impl"


    // $ANTLR start "rule__Atomic__Group_3__1"
    // InternalQueryDsl.g:2632:1: rule__Atomic__Group_3__1 : rule__Atomic__Group_3__1__Impl ;
    public final void rule__Atomic__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2636:1: ( rule__Atomic__Group_3__1__Impl )
            // InternalQueryDsl.g:2637:2: rule__Atomic__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_3__1"


    // $ANTLR start "rule__Atomic__Group_3__1__Impl"
    // InternalQueryDsl.g:2643:1: rule__Atomic__Group_3__1__Impl : ( ( rule__Atomic__ValueAssignment_3_1 ) ) ;
    public final void rule__Atomic__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2647:1: ( ( ( rule__Atomic__ValueAssignment_3_1 ) ) )
            // InternalQueryDsl.g:2648:1: ( ( rule__Atomic__ValueAssignment_3_1 ) )
            {
            // InternalQueryDsl.g:2648:1: ( ( rule__Atomic__ValueAssignment_3_1 ) )
            // InternalQueryDsl.g:2649:2: ( rule__Atomic__ValueAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_3_1()); 
            }
            // InternalQueryDsl.g:2650:2: ( rule__Atomic__ValueAssignment_3_1 )
            // InternalQueryDsl.g:2650:3: rule__Atomic__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__ValueAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_3__1__Impl"


    // $ANTLR start "rule__Model__InstructionsAssignment"
    // InternalQueryDsl.g:2659:1: rule__Model__InstructionsAssignment : ( ruleInstruction ) ;
    public final void rule__Model__InstructionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2663:1: ( ( ruleInstruction ) )
            // InternalQueryDsl.g:2664:2: ( ruleInstruction )
            {
            // InternalQueryDsl.g:2664:2: ( ruleInstruction )
            // InternalQueryDsl.g:2665:3: ruleInstruction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getInstructionsInstructionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleInstruction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getInstructionsInstructionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__InstructionsAssignment"


    // $ANTLR start "rule__VariableDeclaration__NameAssignment_1"
    // InternalQueryDsl.g:2674:1: rule__VariableDeclaration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__VariableDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2678:1: ( ( RULE_ID ) )
            // InternalQueryDsl.g:2679:2: ( RULE_ID )
            {
            // InternalQueryDsl.g:2679:2: ( RULE_ID )
            // InternalQueryDsl.g:2680:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__NameAssignment_1"


    // $ANTLR start "rule__VariableDeclaration__InitExpAssignment_2_1"
    // InternalQueryDsl.g:2689:1: rule__VariableDeclaration__InitExpAssignment_2_1 : ( ruleExpression ) ;
    public final void rule__VariableDeclaration__InitExpAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2693:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:2694:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:2694:2: ( ruleExpression )
            // InternalQueryDsl.g:2695:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDeclarationAccess().getInitExpExpressionParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDeclarationAccess().getInitExpExpressionParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__InitExpAssignment_2_1"


    // $ANTLR start "rule__VarRef__RefAssignment"
    // InternalQueryDsl.g:2704:1: rule__VarRef__RefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VarRef__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2708:1: ( ( ( RULE_ID ) ) )
            // InternalQueryDsl.g:2709:2: ( ( RULE_ID ) )
            {
            // InternalQueryDsl.g:2709:2: ( ( RULE_ID ) )
            // InternalQueryDsl.g:2710:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefAccess().getRefVariableDeclarationCrossReference_0()); 
            }
            // InternalQueryDsl.g:2711:3: ( RULE_ID )
            // InternalQueryDsl.g:2712:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefAccess().getRefVariableDeclarationIDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarRefAccess().getRefVariableDeclarationIDTerminalRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarRefAccess().getRefVariableDeclarationCrossReference_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarRef__RefAssignment"


    // $ANTLR start "rule__Assignment__VAssignment_0"
    // InternalQueryDsl.g:2723:1: rule__Assignment__VAssignment_0 : ( ruleVarRef ) ;
    public final void rule__Assignment__VAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2727:1: ( ( ruleVarRef ) )
            // InternalQueryDsl.g:2728:2: ( ruleVarRef )
            {
            // InternalQueryDsl.g:2728:2: ( ruleVarRef )
            // InternalQueryDsl.g:2729:3: ruleVarRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getVVarRefParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleVarRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getVVarRefParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__VAssignment_0"


    // $ANTLR start "rule__Assignment__ExpAssignment_2"
    // InternalQueryDsl.g:2738:1: rule__Assignment__ExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__Assignment__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2742:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:2743:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:2743:2: ( ruleExpression )
            // InternalQueryDsl.g:2744:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getExpExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getExpExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__ExpAssignment_2"


    // $ANTLR start "rule__GlobalCommand__ParamsAssignment_2"
    // InternalQueryDsl.g:2753:1: rule__GlobalCommand__ParamsAssignment_2 : ( ruleExpression ) ;
    public final void rule__GlobalCommand__ParamsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2757:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:2758:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:2758:2: ( ruleExpression )
            // InternalQueryDsl.g:2759:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGlobalCommandAccess().getParamsExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGlobalCommandAccess().getParamsExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalCommand__ParamsAssignment_2"


    // $ANTLR start "rule__Or__RightAssignment_1_2"
    // InternalQueryDsl.g:2768:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2772:1: ( ( ruleAnd ) )
            // InternalQueryDsl.g:2773:2: ( ruleAnd )
            {
            // InternalQueryDsl.g:2773:2: ( ruleAnd )
            // InternalQueryDsl.g:2774:3: ruleAnd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__RightAssignment_1_2"


    // $ANTLR start "rule__And__RightAssignment_1_2"
    // InternalQueryDsl.g:2783:1: rule__And__RightAssignment_1_2 : ( ruleEquality ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2787:1: ( ( ruleEquality ) )
            // InternalQueryDsl.g:2788:2: ( ruleEquality )
            {
            // InternalQueryDsl.g:2788:2: ( ruleEquality )
            // InternalQueryDsl.g:2789:3: ruleEquality
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__RightAssignment_1_2"


    // $ANTLR start "rule__Equality__OpAssignment_1_1"
    // InternalQueryDsl.g:2798:1: rule__Equality__OpAssignment_1_1 : ( ( rule__Equality__OpAlternatives_1_1_0 ) ) ;
    public final void rule__Equality__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2802:1: ( ( ( rule__Equality__OpAlternatives_1_1_0 ) ) )
            // InternalQueryDsl.g:2803:2: ( ( rule__Equality__OpAlternatives_1_1_0 ) )
            {
            // InternalQueryDsl.g:2803:2: ( ( rule__Equality__OpAlternatives_1_1_0 ) )
            // InternalQueryDsl.g:2804:3: ( rule__Equality__OpAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getOpAlternatives_1_1_0()); 
            }
            // InternalQueryDsl.g:2805:3: ( rule__Equality__OpAlternatives_1_1_0 )
            // InternalQueryDsl.g:2805:4: rule__Equality__OpAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Equality__OpAlternatives_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getOpAlternatives_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__OpAssignment_1_1"


    // $ANTLR start "rule__Equality__RightAssignment_1_2"
    // InternalQueryDsl.g:2813:1: rule__Equality__RightAssignment_1_2 : ( ruleComparison ) ;
    public final void rule__Equality__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2817:1: ( ( ruleComparison ) )
            // InternalQueryDsl.g:2818:2: ( ruleComparison )
            {
            // InternalQueryDsl.g:2818:2: ( ruleComparison )
            // InternalQueryDsl.g:2819:3: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__RightAssignment_1_2"


    // $ANTLR start "rule__Comparison__OpAssignment_1_1"
    // InternalQueryDsl.g:2828:1: rule__Comparison__OpAssignment_1_1 : ( ( rule__Comparison__OpAlternatives_1_1_0 ) ) ;
    public final void rule__Comparison__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2832:1: ( ( ( rule__Comparison__OpAlternatives_1_1_0 ) ) )
            // InternalQueryDsl.g:2833:2: ( ( rule__Comparison__OpAlternatives_1_1_0 ) )
            {
            // InternalQueryDsl.g:2833:2: ( ( rule__Comparison__OpAlternatives_1_1_0 ) )
            // InternalQueryDsl.g:2834:3: ( rule__Comparison__OpAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getOpAlternatives_1_1_0()); 
            }
            // InternalQueryDsl.g:2835:3: ( rule__Comparison__OpAlternatives_1_1_0 )
            // InternalQueryDsl.g:2835:4: rule__Comparison__OpAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__OpAlternatives_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getOpAlternatives_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__OpAssignment_1_1"


    // $ANTLR start "rule__Comparison__RightAssignment_1_2"
    // InternalQueryDsl.g:2843:1: rule__Comparison__RightAssignment_1_2 : ( rulePlusOrMinus ) ;
    public final void rule__Comparison__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2847:1: ( ( rulePlusOrMinus ) )
            // InternalQueryDsl.g:2848:2: ( rulePlusOrMinus )
            {
            // InternalQueryDsl.g:2848:2: ( rulePlusOrMinus )
            // InternalQueryDsl.g:2849:3: rulePlusOrMinus
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightPlusOrMinusParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getRightPlusOrMinusParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__RightAssignment_1_2"


    // $ANTLR start "rule__PlusOrMinus__RightAssignment_1_1"
    // InternalQueryDsl.g:2858:1: rule__PlusOrMinus__RightAssignment_1_1 : ( ruleMod ) ;
    public final void rule__PlusOrMinus__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2862:1: ( ( ruleMod ) )
            // InternalQueryDsl.g:2863:2: ( ruleMod )
            {
            // InternalQueryDsl.g:2863:2: ( ruleMod )
            // InternalQueryDsl.g:2864:3: ruleMod
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPlusOrMinusAccess().getRightModParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMod();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPlusOrMinusAccess().getRightModParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__RightAssignment_1_1"


    // $ANTLR start "rule__Mod__OpAssignment_1_0_1"
    // InternalQueryDsl.g:2873:1: rule__Mod__OpAssignment_1_0_1 : ( ( 'mod' ) ) ;
    public final void rule__Mod__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2877:1: ( ( ( 'mod' ) ) )
            // InternalQueryDsl.g:2878:2: ( ( 'mod' ) )
            {
            // InternalQueryDsl.g:2878:2: ( ( 'mod' ) )
            // InternalQueryDsl.g:2879:3: ( 'mod' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getOpModKeyword_1_0_1_0()); 
            }
            // InternalQueryDsl.g:2880:3: ( 'mod' )
            // InternalQueryDsl.g:2881:4: 'mod'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getOpModKeyword_1_0_1_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getOpModKeyword_1_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getOpModKeyword_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__OpAssignment_1_0_1"


    // $ANTLR start "rule__Mod__RightAssignment_1_1"
    // InternalQueryDsl.g:2892:1: rule__Mod__RightAssignment_1_1 : ( ruleMulOrDiv ) ;
    public final void rule__Mod__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2896:1: ( ( ruleMulOrDiv ) )
            // InternalQueryDsl.g:2897:2: ( ruleMulOrDiv )
            {
            // InternalQueryDsl.g:2897:2: ( ruleMulOrDiv )
            // InternalQueryDsl.g:2898:3: ruleMulOrDiv
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModAccess().getRightMulOrDivParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModAccess().getRightMulOrDivParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__RightAssignment_1_1"


    // $ANTLR start "rule__MulOrDiv__OpAssignment_1_0_1"
    // InternalQueryDsl.g:2907:1: rule__MulOrDiv__OpAssignment_1_0_1 : ( ( rule__MulOrDiv__OpAlternatives_1_0_1_0 ) ) ;
    public final void rule__MulOrDiv__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2911:1: ( ( ( rule__MulOrDiv__OpAlternatives_1_0_1_0 ) ) )
            // InternalQueryDsl.g:2912:2: ( ( rule__MulOrDiv__OpAlternatives_1_0_1_0 ) )
            {
            // InternalQueryDsl.g:2912:2: ( ( rule__MulOrDiv__OpAlternatives_1_0_1_0 ) )
            // InternalQueryDsl.g:2913:3: ( rule__MulOrDiv__OpAlternatives_1_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getOpAlternatives_1_0_1_0()); 
            }
            // InternalQueryDsl.g:2914:3: ( rule__MulOrDiv__OpAlternatives_1_0_1_0 )
            // InternalQueryDsl.g:2914:4: rule__MulOrDiv__OpAlternatives_1_0_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__OpAlternatives_1_0_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getOpAlternatives_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__OpAssignment_1_0_1"


    // $ANTLR start "rule__MulOrDiv__RightAssignment_1_1"
    // InternalQueryDsl.g:2922:1: rule__MulOrDiv__RightAssignment_1_1 : ( ruleExpo ) ;
    public final void rule__MulOrDiv__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2926:1: ( ( ruleExpo ) )
            // InternalQueryDsl.g:2927:2: ( ruleExpo )
            {
            // InternalQueryDsl.g:2927:2: ( ruleExpo )
            // InternalQueryDsl.g:2928:3: ruleExpo
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMulOrDivAccess().getRightExpoParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpo();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMulOrDivAccess().getRightExpoParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__RightAssignment_1_1"


    // $ANTLR start "rule__Expo__OpAssignment_1_0_1"
    // InternalQueryDsl.g:2937:1: rule__Expo__OpAssignment_1_0_1 : ( ( '^' ) ) ;
    public final void rule__Expo__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2941:1: ( ( ( '^' ) ) )
            // InternalQueryDsl.g:2942:2: ( ( '^' ) )
            {
            // InternalQueryDsl.g:2942:2: ( ( '^' ) )
            // InternalQueryDsl.g:2943:3: ( '^' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getOpCircumflexAccentKeyword_1_0_1_0()); 
            }
            // InternalQueryDsl.g:2944:3: ( '^' )
            // InternalQueryDsl.g:2945:4: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getOpCircumflexAccentKeyword_1_0_1_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getOpCircumflexAccentKeyword_1_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getOpCircumflexAccentKeyword_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__OpAssignment_1_0_1"


    // $ANTLR start "rule__Expo__RightAssignment_1_1"
    // InternalQueryDsl.g:2956:1: rule__Expo__RightAssignment_1_1 : ( rulePrefixed ) ;
    public final void rule__Expo__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2960:1: ( ( rulePrefixed ) )
            // InternalQueryDsl.g:2961:2: ( rulePrefixed )
            {
            // InternalQueryDsl.g:2961:2: ( rulePrefixed )
            // InternalQueryDsl.g:2962:3: rulePrefixed
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpoAccess().getRightPrefixedParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrefixed();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpoAccess().getRightPrefixedParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expo__RightAssignment_1_1"


    // $ANTLR start "rule__Prefixed__ExpressionAssignment_0_2"
    // InternalQueryDsl.g:2971:1: rule__Prefixed__ExpressionAssignment_0_2 : ( ruleAtomic ) ;
    public final void rule__Prefixed__ExpressionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2975:1: ( ( ruleAtomic ) )
            // InternalQueryDsl.g:2976:2: ( ruleAtomic )
            {
            // InternalQueryDsl.g:2976:2: ( ruleAtomic )
            // InternalQueryDsl.g:2977:3: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__ExpressionAssignment_0_2"


    // $ANTLR start "rule__Prefixed__ExpressionAssignment_1_2"
    // InternalQueryDsl.g:2986:1: rule__Prefixed__ExpressionAssignment_1_2 : ( ruleAtomic ) ;
    public final void rule__Prefixed__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:2990:1: ( ( ruleAtomic ) )
            // InternalQueryDsl.g:2991:2: ( ruleAtomic )
            {
            // InternalQueryDsl.g:2991:2: ( ruleAtomic )
            // InternalQueryDsl.g:2992:3: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__ExpressionAssignment_1_2"


    // $ANTLR start "rule__Atomic__ExprAssignment_0_2"
    // InternalQueryDsl.g:3001:1: rule__Atomic__ExprAssignment_0_2 : ( ruleExpression ) ;
    public final void rule__Atomic__ExprAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3005:1: ( ( ruleExpression ) )
            // InternalQueryDsl.g:3006:2: ( ruleExpression )
            {
            // InternalQueryDsl.g:3006:2: ( ruleExpression )
            // InternalQueryDsl.g:3007:3: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExprExpressionParserRuleCall_0_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getExprExpressionParserRuleCall_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ExprAssignment_0_2"


    // $ANTLR start "rule__Atomic__ValueAssignment_1_1"
    // InternalQueryDsl.g:3016:1: rule__Atomic__ValueAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__Atomic__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3020:1: ( ( RULE_INT ) )
            // InternalQueryDsl.g:3021:2: ( RULE_INT )
            {
            // InternalQueryDsl.g:3021:2: ( RULE_INT )
            // InternalQueryDsl.g:3022:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ValueAssignment_1_1"


    // $ANTLR start "rule__Atomic__ValueAssignment_2_1"
    // InternalQueryDsl.g:3031:1: rule__Atomic__ValueAssignment_2_1 : ( ( rule__Atomic__ValueAlternatives_2_1_0 ) ) ;
    public final void rule__Atomic__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3035:1: ( ( ( rule__Atomic__ValueAlternatives_2_1_0 ) ) )
            // InternalQueryDsl.g:3036:2: ( ( rule__Atomic__ValueAlternatives_2_1_0 ) )
            {
            // InternalQueryDsl.g:3036:2: ( ( rule__Atomic__ValueAlternatives_2_1_0 ) )
            // InternalQueryDsl.g:3037:3: ( rule__Atomic__ValueAlternatives_2_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAlternatives_2_1_0()); 
            }
            // InternalQueryDsl.g:3038:3: ( rule__Atomic__ValueAlternatives_2_1_0 )
            // InternalQueryDsl.g:3038:4: rule__Atomic__ValueAlternatives_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__ValueAlternatives_2_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAlternatives_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ValueAssignment_2_1"


    // $ANTLR start "rule__Atomic__ValueAssignment_3_1"
    // InternalQueryDsl.g:3046:1: rule__Atomic__ValueAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Atomic__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQueryDsl.g:3050:1: ( ( RULE_STRING ) )
            // InternalQueryDsl.g:3051:2: ( RULE_STRING )
            {
            // InternalQueryDsl.g:3051:2: ( RULE_STRING )
            // InternalQueryDsl.g:3052:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ValueAssignment_3_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000A00012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000038180070L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000A00010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});

}