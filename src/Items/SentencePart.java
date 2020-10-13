package Items;

import java.util.List;

public class SentencePart {

    private List<Symbol> symbols;
    public SentencePart(List<Symbol> symbols){
        this.symbols=symbols;
    }

    public List<Symbol>  getSymbols(){
        return symbols;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Symbol symbol : symbols) {
            sb.append(symbol);
        }
        return sb.toString();
    }

}
