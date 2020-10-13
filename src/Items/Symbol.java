package Items;

import java.util.List;

public class Symbol {

    private Character character;

    public Symbol (Character character){
        this.character = character;
    }

    public Character getCharacter(){
        return character;
    }

    public String toString() {
        return String.valueOf(character);
    }


}
