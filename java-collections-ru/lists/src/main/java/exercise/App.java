package exercise;

import java.util.ArrayList;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        symbols = symbols.toLowerCase();
        word = word.toLowerCase();
        ArrayList<Character> symbolArr = new ArrayList<>();
        for(char c : symbols.toCharArray()) {
            symbolArr.add((c));
        }
        for (char ch : word.toCharArray()) {
            int index = symbolArr.indexOf(ch);
            if (symbolArr.contains(ch)) {
                symbolArr.remove(index);
            } else {
                return false;
            }
        }
        return true;
    }
}

//END
