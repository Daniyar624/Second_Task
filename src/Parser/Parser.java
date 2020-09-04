package Parser;

import Items.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Parser {

    public List<Paragraph> parseToParagraphs(String sourceText) {
        return Arrays.stream(sourceText.split("\\n"))
                .map(t -> new Paragraph(t))
                .collect(Collectors.toList());
    }

    public String paragraphsToText(List<Paragraph> paragraphs, String sourceText) {
        StringBuilder sb = new StringBuilder();
        List<String> marks = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\n");
        Matcher matcher = pattern.matcher(sourceText);
        while (matcher.find()) {
            marks.add(sourceText.substring(matcher.start(), matcher.end()));
        }
        for (int i = 0; i < paragraphs.size(); i++) {
            sb.append(paragraphs.get(i).getText());
            sb.append(marks.get(i));
        }
        return sb.toString();
    }

    public List<Sentence> parseToSentences(String text) {
        return Arrays.stream(text.split("\\.\\s|!\\s|\\?\\s"))
                .map(t -> new Sentence(t))
                .collect(Collectors.toList());
    }

    public String sentencesToText(List<Sentence> sentences, String sourceText) {
        StringBuilder sb = new StringBuilder();
        List<String> marks = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\.\\s|!\\s|\\?\\s");
        Matcher matcher = pattern.matcher(sourceText);
        while (matcher.find()) {
            marks.add(sourceText.substring(matcher.start(), matcher.end()));
        }
        for (int i = 0; i < sentences.size(); i++) {
            sb.append(sentences.get(i).getText());
            sb.append(marks.get(i));
        }
        return sb.toString();
    }

    public List<Word> parseToWords(String text) {
        return Arrays.stream(text.split("[^a-zA-Z]+"))
                .map(t -> new Word(t))
                .collect(Collectors.toList());
    }

    public String wordsToText(List<Word> words, String sourceText) {
        StringBuilder sb = new StringBuilder();
        List<String> marks = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^a-zA-Z]+");
        Matcher matcher = pattern.matcher(sourceText);
        while (matcher.find()) {
            marks.add(sourceText.substring(matcher.start(), matcher.end()));
        }
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i).getText());
            sb.append(marks.get(i));
        }
        return sb.toString();
    }

    public List<Symbol> parseToSymbols(String sourceText) {
        return Arrays.stream(sourceText.split(""))
                .map(t -> new Symbol(t))
                .collect(Collectors.toList());
    }

    public String symbolsToText(List<Symbol> symbols) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < symbols.size(); i++) {
            sb.append(symbols.get(i).getText());
        }
        return sb.toString();
    }

    public String deleteConsonants(List<Word> words, int length, String sourceText) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (  !isVowel(words.get(i).getText()) && (words.get(i).getText().length() == length))  {
                words.get(i).setText("");
            }
        }
        List<String> marks = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^a-zA-Z]+");
        Matcher matcher = pattern.matcher(sourceText);
        while (matcher.find()) {
            marks.add(sourceText.substring(matcher.start(), matcher.end()));
        }
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i).getText());
            sb.append(marks.get(i));
        }
        return sb.toString();
    }

    private boolean isVowel(String sourceText) {
        switch (sourceText.charAt(0)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
            default:
                return false;
        }
    }
}