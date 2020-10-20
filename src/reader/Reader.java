package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public String read(String fileAddress) throws IOException {
        StringBuilder text = new StringBuilder();
        List<String> textArray = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
        String line;
        while ((line = reader.readLine()) != null) {
            textArray.add(line);
        }
        for (String s : textArray) {
            text.append(s).append("\n");
        }
        return text.toString();
    }
}