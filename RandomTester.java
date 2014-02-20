/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package up.cmsc141.julia.mp4.test3;

import java.util.List;

/**
 *
 * @author juliam
 */
public class RandomTester {
    public static void main(String[] args) {
        Tokenizer tokenizer =  new Tokenizer("for(x=9,y=4;x>5&&y;x--){x++;y++;ten+=45;}");
        List<Token> tokens = tokenizer.getTokens();
        for(Token token: tokens) {
            System.out.println(token.getContent());
            System.out.println(token.getCategory());
        }
    }
}
