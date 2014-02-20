/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package up.cmsc141.julia.mp4.test3;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
  
  List<Token> tokens = new ArrayList<Token>();
  String line;
  
  //constructor
  public Tokenizer(String line) {
      this.line = line;
  }
 
  //tokenizes line and returns resulting list of tokens
  public List<Token> getTokens() {
      tokenize();
      return tokens;
  }
  
  //turns parts of the line into tokens and stores in tokens list
  public boolean tokenize() {
    StringBuilder builder = new StringBuilder();
    int length;
    
    char[] lineArray = line.toCharArray();
    //loops through characters in line
    for(int i=0; i<lineArray.length; i++) {
        //checks if valid character
        char ch = lineArray[i];
        if(isValidChar(ch)) {
            //if special character:
            if(isSpecialChar(ch)) {
                //System.out.println("GOT IN SPECIAL CHAR BECAUSE" + ch);
                boolean isSpacePrev = false;
                String tokenString = builder.toString();
                //if the string in the builder is not empty
                if(!tokenString.isEmpty()) {
                    //the string is added as a new token
                    Token token = new Token(tokenString);
                    tokens.add(token);
                } else {
                    isSpacePrev = true;
                }
                
                //deletes contents in builder
                length = builder.length();
                builder.delete(0, length);
                
                //character is added to builder and added as a new token
                builder.append(ch);
                tokenString = builder.toString();
                Token tokenNew = new Token(tokenString);
                if(isSpacePrev) {
                    tokenNew.setSpacePrev();
                }
                tokens.add(tokenNew);
                //after character is added as token, it is deleted from the builder
                builder.delete(0, 1);
            } else if(isCompChar(ch)) {
                //System.out.println("GOT IN COMPCHAR BECAUSE" + ch);
                String tokenString = builder.toString();
                if(!tokenString.isEmpty()) {
                    Token token = new Token(tokenString);
                    tokens.add(token);
                }

                length = builder.length();
                builder.delete(0, length);      
                builder.append(ch);
                tokenString  = builder.toString();
                Token token = new Token(tokenString);
                tokens.add(token);

                length = builder.length();
                builder.delete(0, length);   
            } else if(isPlusSign(ch)) {
                //System.out.println("GOT IN PLUS SIGN BECAUSE" +ch);
                char next = lineArray[i+1];  
                char prev = lineArray[i-1];
                
                if(isPlusSign(prev)) {
                    builder.append(ch);
                    String tokenString  = builder.toString();
                    Token token = new Token(tokenString);
                    tokens.add(token);
                    
                    length = builder.length();
                    builder.delete(0, length); 
                } else if(isPlusSign(next)) {
                    String tokenString = builder.toString();
                    if(!tokenString.isEmpty()) {
                        Token token = new Token(tokenString);
                        tokens.add(token);
                    }
                    
                    length = builder.length();
                    builder.delete(0, length);      
                    builder.append(ch);
                } else {
                    String tokenString = builder.toString();
                    if(!tokenString.isEmpty()) {
                        Token token = new Token(tokenString);
                        tokens.add(token);
                    }
                    length = builder.length();
                    builder.delete(0, length);

                    builder.append(ch);
                    tokenString  = builder.toString();
                    Token token = new Token(tokenString);
                    tokens.add(token);
                    
                    length = builder.length();
                    builder.delete(0, length);  
                } 
            } else if(isMinusSign(ch)) {
                //System.out.println("GOT IN MINUS SIGN BECAUSE" +ch);
                char next = lineArray[i+1];  
                char prev = lineArray[i-1];
                
                if(isMinusSign(prev)) {
                    builder.append(ch);
                    String tokenString  = builder.toString();
                    Token token = new Token(tokenString);
                    tokens.add(token);
                    
                    length = builder.length();
                    builder.delete(0, length); 
                } else if(isMinusSign(next)) {
                    String tokenString = builder.toString();
                    if(!tokenString.isEmpty()) {
                        Token token = new Token(tokenString);
                        tokens.add(token);
                    }
                    
                    length = builder.length();
                    builder.delete(0, length);      
                    builder.append(ch);
                } else {
                    String tokenString = builder.toString();
                    if(!tokenString.isEmpty()) {
                        Token token = new Token(tokenString);
                        tokens.add(token);
                    }
                    length = builder.length();
                    builder.delete(0, length);

                    builder.append(ch);
                    tokenString  = builder.toString();
                    Token token = new Token(tokenString);
                    tokens.add(token);
                    
                    length = builder.length();
                    builder.delete(0, length);  
                } 
            } else if(isEqualSign(ch)) {
                //System.out.println("GOT IN EQUALS SIGN BECAUSE" +ch);
                char next = lineArray[i+1];  
                char prev = lineArray[i-1];
                
                if(isEqualSign(prev) || isCompChar(prev)) {
                    builder.append(ch);
                    String tokenString  = builder.toString();
                    Token token = new Token(tokenString);
                    tokens.add(token);
                    
                    length = builder.length();
                    builder.delete(0, length); 
                } else if(isEqualSign(next)) {
                    String tokenString = builder.toString();
                    if(!tokenString.isEmpty()) {
                        Token token = new Token(tokenString);
                        tokens.add(token);
                    }
                    
                    length = builder.length();
                    builder.delete(0, length);      
                    builder.append(ch);
                } else {
                    String tokenString = builder.toString();
                    if(!tokenString.isEmpty()) {
                        Token token = new Token(tokenString);
                        tokens.add(token);
                    }
                    length = builder.length();
                    builder.delete(0, length);

                    builder.append(ch);
                    tokenString  = builder.toString();
                    Token token = new Token(tokenString);
                    tokens.add(token);
                    
                    length = builder.length();
                    builder.delete(0, length);  
                } 
            } else if(isAndOr(ch)) {
                //System.out.println("GOT IN ANDOR BECAUSE" +ch);
                char next = lineArray[i+1];  
                
                if(isOr(ch)) {
                    if(isOr(next)) {
                        String tokenString = builder.toString();
                        if(!tokenString.isEmpty()) {
                            Token token = new Token(tokenString);
                            tokens.add(token);
                        }

                        length = builder.length();
                        builder.delete(0, length);      
                        builder.append(ch);
                    } else {
                        builder.append(ch);
                        String tokenString  = builder.toString();
                        Token token = new Token(tokenString);
                        tokens.add(token);

                        length = builder.length();
                        builder.delete(0, length);  
                    }
                } else {
                    if(isAnd(next)) {
                        String tokenString = builder.toString();
                        if(!tokenString.isEmpty()) {
                            Token token = new Token(tokenString);
                            tokens.add(token);
                        }

                        length = builder.length();
                        builder.delete(0, length);      
                        builder.append(ch);
                    } else {
                        builder.append(ch);
                        String tokenString  = builder.toString();
                        Token token = new Token(tokenString);
                        tokens.add(token);

                        length = builder.length();
                        builder.delete(0, length);  
                    }                    
                }                 
            //if space:
            } else if(isSpace(ch)) {
                //ystem.out.println("GOT IN SPACE BECAUSE" +ch);
                String tokenString = builder.toString();
                //if string in the builder is not empty, string is added as token
                if(!tokenString.isEmpty()) {
                    Token token = new Token(tokenString);
                    tokens.add(token);
                }
                //string is deleted from builder
                length = builder.length();
                builder.delete(0, length);                    
            } else {
                //character is added to builder
                builder.append(ch);
                //System.out.println(ch);
            }
        } else {
            //invalid character
            System.out.println("GOT IN INVALID CHARACTER BECAUSE" +ch);
            return false;
        }
    }
    String tokenString = builder.toString();
    if(!tokenString.isEmpty()) {
        Token token = new Token(tokenString);
        tokens.add(token);
    }
    return true;
  }
  
  private boolean isValidChar(char c) {
      if(isRegChar(c) || isSpecialChar(c) || isSpace(c) || isEqualSign(c) || isCompChar(c) || isAndOr(c) || isOperator(c)){
          return true;
      } else {
          return false;
      }
  }
  
  private boolean isRegChar(char c) {
      if(Character.isLetterOrDigit(c) || c == '_' ) {
          return true;
      } else {
          return false;
      }    
  }
  
  private boolean isSpecialChar(char c) {
      if(c == '(' || 
         c == ')' ||
         c == '[' ||
         c == ']' ||
         c == ',' ||
         c == ';' ||
         c == '*' ||
         c == '{' ||
         c == '}'
      ) {
          return true;
      } else {
          return false;
      }
  }
  
  private boolean isSpace(char c) {
      if (c == ' ') {
          return true;
      } else if (c == ' ') {
          return true;   
      } else {
          return false;
      }
  }
  
  private boolean isEqualSign(char c) {
      if (c == '=') {
          return true;
      } else {
          return false;
      }
  }
  
  private boolean isOperator(char c) {
      if( isPlusSign(c) || isMinusSign(c) || isDivisionSign(c) || isModulo(c)) {
          return true;
      } else {
          return false;
      }
  }
  
  private boolean isPlusSign(char c) {
      if (c == '+') {
          return true;
      } else {
          return false;
      }
  }
  
  private boolean isMinusSign(char c) {
      if (c == '-') {
          return true;
      } else {
          return false;
      }
  }
  
  private boolean isDivisionSign(char c) {
      if (c == '/') {
          return true;
      } else {
          return false;
      }    
  }
  
  private boolean isModulo(char c) {
      if (c == '%') {
          return true;
      } else {
          return false;
      }    
  }
  
  private boolean isCompChar(char c) {
      if (c == '!') {
          return true;
      } else if (c == '>') {
          return true;
      } else if (c == '<') {
          return true;
      } else {
          return false;
      }
  }
  
  private boolean isAndOr(char c) {
      if (isOr(c) || isAnd(c)) {
          return true;
      } else {
          return false;
      }
  }
  
  private boolean isOr(char c) {
      if (c == '|') {
          return true;
      } else {
          return false;
      }
  }
  
  private boolean isAnd(char c) {
      if (c == '&') {
          return true;
      } else {
          return false;
      }
  }
}
