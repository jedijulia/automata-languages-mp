/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package up.cmsc141.julia.mp4.test2;

/**
 *
 * @author juliam
 */
public enum Category {
   OPENPARENS(0, "OPENPARENS"), 
   CLOSEPARENS(1, "CLOSEPARENS"), 
   OPENBRACKET(2, "OPENBRACKET"), 
   CLOSEBRACKET(3, "CLOSEBRACKET"), 
   COMMA(4, "COMMA"), 
   SEMICOLON(5, "SEMICOLON"),
   ASTERISK(6, "ASTERISK"), 
   SIGNED(7, "SIGNED"), 
   UNSIGNED(8, "UNSIGNED"), 
   CHAR(9, "CHAR"), 
   SHORT(10, "SHORT"),
   INT(11, "INT"), 
   LONG(12, "LONG"), 
   FLOAT(13, "FLOAT"), 
   DOUBLE(14, "DOUBLE"), 
   VOID(15, "VOID"), 
   NUMTEXT(16, "NUMTEXT"), 
   VARTEXT(17, "VARTEXT"), 
   FUNCTEXT(18, "FUNCTEXT"),
   INVALIDCATEG(19, "INVALIDCATEG"),
   ANDOR(20, "ANDOR"),
   COMPARATOR(21, "COMPARATOR"),
   OPERATION(22, "OPERATION"),
   EQUALS(23, "EQUALS"),
   INCDEC(24, "INCDEC"),
   FOR(25, "FOR");
   
   private final int value;
   private final String label;
   
   Category(int value, String label) {
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
