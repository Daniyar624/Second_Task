package boot;
import items.Text;
import parser.Parser;
import reader.Reader;
import java.io.IOException;
import tools.DeleteConsonants;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        String sourceText = reader.read("src/text.txt");

        Parser parser = new Parser();
        Text text = parser.parseText(sourceText);
        System.out.println(text);

        DeleteConsonants deleteConsonants = new DeleteConsonants();
        System.out.println(deleteConsonants.initiate_deletion(sourceText, 3));
    }
}