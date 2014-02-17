
package up.cmsc141.julia.mp4.test2;

import java.util.ArrayList;
import java.util.List;

public class Token {
    
    String content; 
    Category category;
    boolean spacePrev;
    
    //constructor given content, calls categorize()
    public Token(String content) {
        this.content = content;
        categorize();
        this.spacePrev = false;
    }
    
    //constructor given content, category 
    public Token(String content, String category, boolean spacePrev) {
        this.content = content;
        //this.category = toEnum(category);
        this.spacePrev = spacePrev;
    }
    
    //categorizes content based on content
    private void categorize() {
        if(content.equals("(")) {
            category = Category.OPENPARENS;
        } else if (content.equals(")")) {
            category = Category.CLOSEPARENS;
        } else if (content.equals("[")) {
            category = Category.OPENBRACKET;
        } else if (content.equals("]")) {
            category = Category.CLOSEBRACKET;
        } else if (content.equals(",")) {
            category = Category.COMMA;
        } else if (content.equals(";")) {
            category = Category.SEMICOLON;
        } else if (content.equals("*")) {
            category = Category.ASTERISK;
        } else if (content.equals("||")) {
            category = Category.ANDOR;
        } else if (content.equals("&&")) {
            category = Category.ANDOR;
        } else if (content.equals("=")) {
            category = Category.EQUALS;
        } else if (content.equals("==")) {
            category = Category.COMPARATOR;
        } else if (content.equals("!=")) {
            category = Category.COMPARATOR;
        } else if (content.equals(">=")) {
            category = Category.COMPARATOR;
        } else if (content.equals("<=")) {
            category = Category.COMPARATOR;
        } else if (content.equals("+")) {
            category = Category.OPERATION;
        } else if (content.equals("-")) {
            category = Category.OPERATION;
        } else if (content.equals("/")) {
            category = Category.OPERATION;
        } else if (content.equals("++")) {
            category = Category.INCDEC;
        } else if (content.equals("--")) {
            category = Category.INCDEC;
        } else {
            //if conent is none of the special characters above, calls categorizeText((
            category = categorizeText();
        }
    }
    
    //categorizes text 
    private Category categorizeText() {
        List<String> types = new ArrayList<String>();
        types.add("signed");
        types.add("unsigned");
        types.add("char");
        types.add("short");
        types.add("int");
        types.add("long");
        types.add("float");
        types.add("double");
        types.add("void");
        
        //if it is any of the above types, categorizeType() is called
        if(types.contains(content)) {
            return categorizeType();
        } else {
        //if not, text is classified as 'regular' and is classified by categorizeRegText()
            return categorizeRegText();
        }
    }
    
    //categorizes text as either a number(integer) or a variable name
    private Category categorizeRegText() {
        if(isNum()) {
            return Category.NUMTEXT;
        } else {
            char[] contentArray = content.toCharArray();
            char firstChar = contentArray[0];
            
            if(content.equals("for")) {
                return Category.FOR;
            } else if(Character.isLetter(firstChar) || firstChar == '_') {
                return Category.VARTEXT;
            } else {
                return Category.INVALIDCATEG;
            }
        }
    }
    
    //checks if content is a number(integer)
    private boolean isNum() {
        try { 
            Integer.parseInt(content); 
        } catch(NumberFormatException e) { 
            return false; 
        } return true;
    }
    
    //categorizes content based on type
    private Category categorizeType() {
        if(content.equals("char")) {
            return Category.CHAR;
        } else if(content.equals("float")) {
            return Category.FLOAT;
        } else if(content.equals("long")) {
            return Category.LONG;
        } else if(content.equals("short")) {
            return Category.SHORT;
        } else if(content.equals("signed")) {
            return Category.SIGNED;
        } else if(content.equals("unsigned")) {
            return Category.UNSIGNED;
        } else if(content.equals("double")){
            return Category.DOUBLE;
        } else if(content.equals("void")) {
            return Category.VOID;
        } else {
            //int
            return Category.INT;
        }
    }
    
    //category checkers
    
    public boolean isVarText() {
        if(category == Category.VARTEXT) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFuncText() {
        if(category== Category.FUNCTEXT) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isRegType() {
        if((category== Category.CHAR ) || (category == Category.FLOAT) || (category == Category.DOUBLE ) || (category == Category.INT)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isRegQuali() {
        if((category == Category.SIGNED) || (category == Category.UNSIGNED)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isLongType() {
        if(category == Category.LONG) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isShortType() {
        if(category == Category.SHORT) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isDoubleType() {
        if(category== Category.DOUBLE) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isIntType() {
        if(category == category.INT) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isVoidType() {
        if(category == Category.VOID) {
            return true;
        } else {
            return false;
        }        
    }
    
    public boolean isNumText() {
        if(category == Category.NUMTEXT) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isOpenBracket() {
        if(category == Category.OPENBRACKET) {
            return true;
        } else {
            return false;
        }        
    }
    
    public boolean isCloseBracket() {
        if(getCategory().equals("closeBracket")) {
            return true;
        } else {
            return false;
        }        
    }
    
    public boolean isOpenParens() {
        if(category == Category.OPENPARENS) {
            return true;
        } else {
            return false;
        }        
    }
    
    public boolean isCloseParens() {
        if(category == Category.CLOSEPARENS) {
            return true;
        } else {
            return false;
        }        
    }
    
    public boolean isSemicolon() {
        if(category == Category.SEMICOLON) {
            return true;
        } else {
            return false;
        }        
    }
    
    public boolean isComma() {
         if(category == Category.COMMA) {
            return true;
        } else {
            return false;
        }         
    }
    
    public boolean isAsterisk() {
        if(category == Category.ASTERISK) {
            return true;
        } else {
            return false;
        }   
    }
    
    public String getContent() {
        return this.content;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public Category setCategory(Category newCategory) {
        return this.category = newCategory;
    }
    
    public boolean isSpacePrev() {
        return this.spacePrev;
    }
    
    public void setSpacePrev() {
        this.spacePrev = true;
    }
}
