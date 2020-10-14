package Parser;

import Items.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        String[] list = text.split("\\b");
        List<SentencePart> sentenceParts = new ArrayList<>();
        for (String text1 : list) {
            sentenceParts.add(parseSentencePart(text1));
        }
        return new Sentence(sentenceParts);
    }

     public SentencePart parseSentencePart(String sentencePart){
        return new SentencePart(sentencePart.chars()
            .mapToObj(c -> (char) c)
            .map(Symbol::new)
            .collect(Collectors.toList()));
   }


}
