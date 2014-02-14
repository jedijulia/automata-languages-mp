
package up.cmsc141.julia.mp4.test1;

import up.cmsc141.julia.mp3test4.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSyntaxChecker {
    
    public void checkSyntax() {
        FileWriter fw = null;
        
        try {
            Filereader fileReader = new Filereader();
            List<String> lines = new ArrayList<String>();
            
            File file = new File("testoutput2.out");
            file.createNewFile();
            fw = new java.io.FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(new FileWriter("testoutput2.out"));
            
            try {
              lines = fileReader.readLines("mp3.in");
            } catch (Exception ex) {
              System.out.println("error");
            }

            for(String line:lines) {
                Tokenizer tokenizer = new Tokenizer(line);
                List<Token> tokens = tokenizer.getTokens();
                Checker checker = new Checker(tokens);

                boolean result = checker.check();
                if(result) {
                    bw.write("valid");
                    bw.newLine();
                } else {
                    bw.write("invalid");
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException ex) {        
            Logger.getLogger(CSyntaxChecker.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
