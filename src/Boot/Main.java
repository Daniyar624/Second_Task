package Boot;
import Items.Text;
import Parser.Parser;
import Reader.Reader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        String sourceText = reader.read("src/text.txt");

        Parser parser = new Parser();
        Text text = parser.parseText(sourceText);
        System.out.println(text);
    }
}