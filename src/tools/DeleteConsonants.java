package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteConsonants {

public List<String> initiate_deletion (String sourceText, int wordLength) {
    List<String> words = new ArrayList<>();
    Pattern pattern = Pattern.compile("\\b[a-zA-Z\\-'.]+\\b");
    Matcher matcher = pattern.matcher(sourceText);
    while (matcher.find()) {
        words.add(sourceText.substring(matcher.start(), matcher.end()));
    }
    for (int i = 0; i< words.size(); i++ ){
        if (!(isVowel(words.get(i))) & words.get(i).length()==wordLength){
            words.remove(i);
            i--;
        }
    }
    return words;
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
