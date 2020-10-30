package boot;
import items.Text;
import parser.Parser;
import reader.Reader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        String sourceText = reader.read("src/text.txt");

        Parser parser = new Parser();
        Text text = parser.parseText(sourceText);
        System.out.println(text);
        System.out.println(text.toString().equals(sourceText) ? "Parsed text equals to the original one. Po kaifu." : "Parsed text does not equal to the original one. Otstoy:(");
        text.deleteWordsGivenLengthStartingConsonants(9);
        System.out.println("\n" + text);

    }
}