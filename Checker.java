/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package up.cmsc141.julia.mp4.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author juliam
 */
public class Checker {
    
    List<Token> tokens = new ArrayList<Token>();
    ArrayList<State> finalStates = new ArrayList<State>() {{
        add(State.SEMICOLONSTATE);
    }};
    
//    private State[][] table = {
//        //                                              CATEGORIES
//        //  *STATE*     OPENPARENS        CLOSEPARENS        OPENBRACKET        CLOSEBRACKET       COMMA             
//        /*  START */{   State.TYPEDEC,    State.TYPEDEC,     State.VARTEXTDEC,  State.INVALID,     State.INVALID },
//      /*  TYPEDEC */{   State.VARTEXTDEC, State.INVALID,     State.INVALID,     State.COMMASTATE,  State.INVALID },
//   /*  VARTEXTDEC */{   State.COMMASTATE, State.TYPEDEC,     State.INVALID,     State.TYPEDEC,     State.INVALID },
//   /*  COMMASTATE */{   State.TYPEDEC,    State.INVALID,     State.TYPEDEC,     State.TYPEDEC,     State.INVALID },
//    };
    
    //{   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,    State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID},
    private State[][] table = {
        //                                              CATEGORIES
        //  *STATE*     OPENPARENS                  CLOSEPARENS                 OPENBRACKET                 CLOSEBRACKET            COMMA               SEMICOLON               ASTERISK                SIGNED              UNSIGNED                CHAR                SHORT               INT             LONG                FLOAT               DOUBLE              VOID                NUMTEXT             VARTEXT             FUNCTEXT                INVALIDCATEG            
        /*  START */    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,          State.REGQUALI,     State.REGQUALI,         State.TYPEDEC,      State.SHORTTYPE,    State.TYPEDEC,  State.LONGFIRST,    State.TYPEDEC,      State.TYPEDEC,      State.TYPEDEC,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
      /*  TYPEDEC */    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.ASTERISKSTATE,    State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.VARTEXTDEC,   State.FUNCTEXTDEC,      State.INVALID},
   /*  VARTEXTDEC */    {   State.INVALID,          State.INVALID,              State.OPENBRACKETSTATE,     State.INVALID,          State.COMMASTATE,   State.SEMICOLONSTATE,   State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
   /*  COMMASTATE */    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.ASTERISKSTATE,    State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.VARTEXTDEC,   State.INVALID,          State.INVALID},
   /*ASTERISKSTATE*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.ASTERISKSTATE,    State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.VARTEXTDEC,   State.FUNCTEXTDEC,      State.INVALID},
        /*REGQUALI*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.TYPEDEC,      State.SHORTTYPE,    State.TYPEDEC,  State.LONGFIRST,    State.TYPEDEC,      State.TYPEDEC,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
       /*LONGFIRST*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.ASTERISKSTATE,    State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.TYPEDEC,  State.LONGSECOND,   State.INVALID,      State.TYPEDEC,      State.INVALID,      State.INVALID,      State.VARTEXTDEC,   State.FUNCTEXTDEC,      State.INVALID},
      /*LONGSECOND*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.ASTERISKSTATE,    State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.TYPEDEC,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.VARTEXTDEC,   State.FUNCTEXTDEC,      State.INVALID},
       /*SHORTTYPE*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.ASTERISKSTATE,    State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.TYPEDEC,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.VARTEXTDEC,   State.FUNCTEXTDEC,      State.INVALID},
        /*VOIDTYPE*/    {   State.INVALID,          State.CLOSEPARENSSTATE,     State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
  /*SEMICOLONSTATE*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
/*OPENBRACKETSTATE*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.CLOSEBRACKETSTATE,State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.NUMTEXTSTATE, State.INVALID,      State.INVALID,          State.INVALID},
    /*NUMTEXTSTATE*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.CLOSEBRACKETSTATE,State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
/*CLOSEBRACKETSTATE*/   {   State.INVALID,          State.INVALID,              State.OPENBRACKETSTATE,     State.INVALID,          State.INVALID,      State.SEMICOLONSTATE,   State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
     /*FUNCTEXTDEC*/    {   State.OPENPARENSSTATE,  State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
 /*OPENPARENSSTATE*/    {   State.INVALID,          State.CLOSEPARENSSTATE,     State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,          State.REGQUALIFUNC, State.REGQUALIFUNC,     State.TYPEFUNC,     State.SHORTTYPEFUNC,State.TYPEFUNC, State.LONGFIRSTFUNC,State.TYPEFUNC,     State.TYPEFUNC,     State.VOIDTYPE,     State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
        /*TYPEFUNC*/    {   State.INVALID,          State.CLOSEPARENSSTATE,     State.OPENBRACKETFUNC,      State.INVALID,          State.COMMAFUNC,    State.INVALID,          State.ASTERISKFUNC,     State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.VARTEXTFUNC,  State.INVALID,          State.INVALID},   
     /*VARTEXTFUNC*/    {   State.INVALID,          State.CLOSEPARENSSTATE,     State.OPENBRACKETFUNC,      State.INVALID,          State.COMMAFUNC,    State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
       /*COMMAFUNC*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.TYPEFUNC,     State.SHORTTYPEFUNC,State.TYPEFUNC, State.LONGFIRSTFUNC,State.TYPEFUNC,     State.TYPEFUNC,     State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
 /*OPENBRACKETFUNC*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.CLOSEBRACKETFUNC, State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.NUMTEXTFUNC,  State.INVALID,      State.INVALID,          State.INVALID},
     /*NUMTEXTFUNC*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.CLOSEBRACKETFUNC, State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
/*CLOSEBRACKETFUNC*/    {   State.INVALID,          State.CLOSEPARENSSTATE,     State.OPENBRACKETFUNC,      State.INVALID,          State.COMMAFUNC,    State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
    /*ASTERISKFUNC*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.COMMAFUNC,    State.INVALID,          State.ASTERISKFUNC,     State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.VARTEXTFUNC,  State.INVALID,          State.INVALID},
/*CLOSEPARENSSTATE*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.SEMICOLONSTATE,   State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
    /*REGQUALIFUNC*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.TYPEFUNC,     State.SHORTTYPEFUNC,State.TYPEFUNC, State.LONGFIRSTFUNC,State.TYPEFUNC,     State.TYPEFUNC,     State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID},
   /*LONGFIRSTFUNC*/    {   State.INVALID,          State.CLOSEPARENSSTATE,     State.OPENBRACKETFUNC,      State.INVALID,          State.COMMAFUNC,    State.INVALID,          State.ASTERISKFUNC,     State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.LONGSECONDFUNC,State.INVALID,     State.TYPEFUNC,     State.INVALID,      State.INVALID,      State.VARTEXTFUNC,  State.INVALID,          State.INVALID},
  /*LONGSECONDFUNC*/    {   State.INVALID,          State.CLOSEPARENSSTATE,     State.OPENBRACKETFUNC,      State.INVALID,          State.COMMAFUNC,    State.INVALID,          State.ASTERISKFUNC,     State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.TYPEFUNC, State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.VARTEXTFUNC,  State.INVALID,          State.INVALID},
   /*SHORTTYPEFUNC*/    {   State.INVALID,          State.CLOSEPARENSSTATE,     State.OPENBRACKETFUNC,      State.INVALID,          State.COMMAFUNC,    State.INVALID,          State.ASTERISKFUNC,     State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.TYPEFUNC, State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.VARTEXTFUNC,  State.INVALID,          State.INVALID},
    /*INVALIDSTATE*/    {   State.INVALID,          State.INVALID,              State.INVALID,              State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,          State.INVALID,      State.INVALID,          State.INVALID,      State.INVALID,      State.INVALID,  State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,      State.INVALID,          State.INVALID}
    };
    
    
    
    //METHODS
    
    public Checker(List<Token> tokens) {
        this.tokens = tokens;
    }
    
    
    public boolean check(){
        State currState = State.START;
        setFuncText();
        for(Token token: tokens) {
            int first = currState.getValue();
            int second = token.getCategory().getValue();
            
            System.out.println("past state " + currState.getLabel());
            
            currState = table[first][second];
            
            System.out.println("token read " + token.getCategory().getLabel());
            System.out.println("current state " + currState.getLabel());
            System.out.println("");
            if (currState == State.INVALID) {
                return false;
            }
        }
        if(finalStates.contains(currState)) {
            return true;
        } else {
            return false;
        }
    }
    
    //for checking purposes
    public void printFinalStates() {
        for(State state: finalStates) {
            System.out.println(state.getValue());
        }
    }
    
    public void setFuncText() {
        int size = tokens.size();
        for(int i=0; i<size; i++) {
            if(tokens.get(i).isOpenParens()) {
                if(i!=0) {
                    Token toSet = tokens.get(i-1);
                    if(toSet.getCategory() == Category.VARTEXT) {
                        tokens.get(i-1).setCategory(Category.FUNCTEXT);
                    }
                }
            }
        }
    }
    
}
