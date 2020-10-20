package parser;

import items.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    public Text parseText (String sourceText){
        String[] paragraphList = sourceText.split("\n");
        List<Paragraph> paragraphs = new ArrayList<>();
        for (String paragraph : paragraphList) {
            paragraphs.add(parseParagraph(paragraph));
        }
        return new Text(paragraphs);
    }

    public Paragraph parseParagraph (String text){
        List<Sentence> sentences = new ArrayList<>();
        List<String> punctuation_marks = new ArrayList<>();
        String[] sentenceList = text.split("\\.\\s|!\\s|\\?\\s");
        Pattern pattern = Pattern.compile("\\.\\s|!\\s|\\?\\s");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            punctuation_marks.add(matcher.group().substring(0, 1));
        }
        int amount = 1;
        for (String sentence : sentenceList) {
            StringBuilder sb = new StringBuilder();
            sb.append(sentence);
            if (sentenceList.length != amount) {
                sb.append(punctuation_marks.get(amount - 1)).append(" ");
            }
            amount++;
            String result = sb.toString();
            sentences.add(parseSentence(result));
        }
        return new Paragraph(sentences);
    }

    public Sentence parseSentence (String text){
        String[] sentencePartList = text.split("\\b");
        List<SentencePart> sentenceParts = new ArrayList<>();
        for (String sentencePart : sentencePartList) {
            sentenceParts.add(parseSentencePart(sentencePart));
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