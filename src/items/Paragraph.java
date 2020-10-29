package items;

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
        for(Sentence sentence : sentences){
            sb.append(sentence.toString());
        }
        return sb.toString();
    }
    public void delete(int length){
        for (Sentence sentence : sentences){
            sentence.delete(length);
        }
    }
}