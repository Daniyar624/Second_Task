package Boot;
import Parser.Parser;
import Reader.Reader;
import Items.*;
import Test.Test;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        String sourceText = reader.read("src/text.txt");


        Parser parser = new Parser();
        List<Word> words = parser.parseToWords(sourceText);


         for (int i=0; i<words.size(); i++){
            System.out.println(words.get(i).getText());
        }

         System.out.println(parser.wordsToText(words, sourceText));

         String text = parser.wordsToText(words, sourceText);

         Test test = new Test();
         System.out.println(test.initiateTest(text, sourceText));

         System.out.println(parser.deleteConsonants(words, 9, sourceText));

    }
}