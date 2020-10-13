package Parser;

import Items.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public Text parseText (String sourceText){
        String[] list = sourceText.split("\n");
        List<Paragraph> paragraphs = new ArrayList<>();
        for (String text1 : list) {
            paragraphs.add(parseParagraph(text1));
        }
        return new Text(paragraphs);
    }

    public Paragraph parseParagraph (String text){
        String[] list = text.split("\\.\\s|!\\s|\\?\\s");
        List<Sentence> sentences = new ArrayList<>();
        for (String text1 : list) {
            sentences.add(parseSentence(text1));
        }
        return new Paragraph(sentences);
    }

    public Sentence parseSentence (String text){
        String[] list = text.split("\\s");
        List<SentencePart> sentenceParts = new ArrayList<>();
        for (String text1 : list) {
            sentenceParts.add(parseSentencePart(text1));
        }
        return new Sentence(sentenceParts);
    }

     public SentencePart parseSentencePart(String text1){
        String[] listStr = text1.split("");

        char[] listChar = new char[listStr.length];

           for (int i=0; i< listStr.length; i++){
             listChar[i] = listStr[i].charAt(0);
         }


        List<Symbol> symbols = new ArrayList<>();
        for (int i=0; i< listChar.length; i++){
            symbols.add(new Symbol(listChar[i]));
        }

        return new SentencePart(symbols);
   }


}
