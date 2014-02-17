/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package up.cmsc141.julia.mp4.test2;

import java.util.List;

/**
 *
 * @author juliam
 */
public class RandomTester {
    public static void main(String[] args) {
        Tokenizer tokenizer =  new Tokenizer("for(int i=23; i>=5; i--)");
        List<Token> tokens = tokenizer.getTokens();
        for(Token token: tokens) {
            System.out.println(token.getContent());
            System.out.println(token.getCategory());
        }
    }
}
