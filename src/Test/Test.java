package Test;

public class Test {
    public String initiateTest(String textFromItems, String sourceText){
        String result;
        if (textFromItems.equals(sourceText)){
            result = "Nice, it works!";
        }
        else {
            result = "Not this time...";
        }
        return result;
    }
}