package Items;

import java.util.List;

public class Text {

    private List<Paragraph> paragraphs;

    public Text (List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<Paragraph> getParagraphs(){
        return paragraphs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Paragraph paragraph : paragraphs){
            sb.append(paragraph.toString());
            sb.append("\n");
        }
        return sb.toString();
    }


}
