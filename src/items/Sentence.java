package items;

import java.util.List;

public class Sentence {

    private List<SentencePart> sentenceParts;

    public Sentence(List<SentencePart> sentenceParts){
        this.sentenceParts = sentenceParts;
    }

    public List<SentencePart> getSentenceParts(){
        return sentenceParts;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(SentencePart sentencePart : sentenceParts){
            sb.append(sentencePart.toString());
        }
        return sb.toString();
    }

    public void deleteWordsGivenLengthStartingConsonants(int length){
        sentenceParts.removeIf(sentencePart -> sentencePart.toString().length()==length && !(isVowel(sentencePart.toString())));
    }

    private boolean isVowel (String word) {
        switch(word.toLowerCase().charAt(0)) {
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