/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package up.cmsc141.julia.mp4.test2;

/**
 *
 * @author juliam
 */
public enum State {
    START(0, "START"),
    TYPEDEC(1, "TYPEDEC"),
    VARTEXTDEC(2, "VARTEXTDEC"),
    COMMASTATE(3, "COMMASTATE"),
    ASTERISKSTATE(4, "ASTERISKSTATE"),
    REGQUALI(5, "REGQUALI"),
    LONGFIRST(6, "LONGFIRST"),
    LONGSECOND(7, "LONGSECOND"),
    SHORTTYPE(8, "SHORTTYPE"),
    VOIDTYPE(9, "VOIDTYPE"),
    SEMICOLONSTATE(10, "SEMICOLONSTATE"),
    OPENBRACKETSTATE(11, "OPENBRACKETSTATE"),
    NUMTEXTSTATE(12, "NUMTEXTSTAE"),
    CLOSEBRACKETSTATE(13, "CLOSEBRACKETSTATE"),
    FUNCTEXTDEC(14, "FUNCTEXTDEC"),
    OPENPARENSSTATE(15, "OPENPARENSSTATE"),
    TYPEFUNC(16, "TYPEFUNC"),
    VARTEXTFUNC(17, "VARTEXTFUNC"),
    COMMAFUNC(18, "COMMAFUNC"),
    OPENBRACKETFUNC(19, "OPENBRACKETFUNC"),
    NUMTEXTFUNC(20, "NUMTEXTFUNC"),
    CLOSEBRACKETFUNC(21, "CLOSEBRACKETFUNC"),
    ASTERISKFUNC(22, "ASTERISKFUNC"),
    CLOSEPARENSSTATE(23, "CLOSEPARENSSTATE"),
    REGQUALIFUNC(24, "REGQUALIFUNC"),
    LONGFIRSTFUNC(25, "LONGFIRSTFUNC"),
    LONGSECONDFUNC(26, "LONGSECONDFUNC"),
    SHORTTYPEFUNC(27, "SHORTTYPEFUNC"),
    INVALID(28, "INVALID");
   
   private final int value;
   private final String label;
   State(int value, String label) {
       this.value = value;
       this.label = label;
   }
   
   public int getValue() {
       return value;
   }
   
   public String getLabel() {
       return label;
   }
}

