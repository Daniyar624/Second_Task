package Items;

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

}
