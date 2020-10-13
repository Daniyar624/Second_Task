package Items;

import java.util.List;

public class Paragraph {

    private List<Sentence> sentences;
    public Paragraph(List<Sentence> sentences){
        this.sentences = sentences;
    }
    public List<Sentence> getSentences() {
        return sentences;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(Sentence sentence : sentences){
            sb.append(sentence.toString());
            if(sentences.size()!=count) {
                sb.append("БЛЯТЬ ");
            }
            count++;
        }
        return sb.toString();
    }

}
