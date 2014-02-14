/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package up.cmsc141.julia.mp4.test1;

import up.cmsc141.julia.mp3test4.*;
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
    
    //loops through characters in line
    for(char ch:line.toCharArray()) {
        //checks if valid character
        if(isValidChar(ch)) {
            //if special character:
            if(isSpecialChar(ch)) {
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
            //if space:
            } else if(isSpace(ch)) {
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
            }
        } else {
            //invalid character
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
      if(isRegChar(c) || isSpecialChar(c) || isSpace(c)) {
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
         c == '*'
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
      }else {
          return false;
      }
  }
}
