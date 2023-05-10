package exercise;

import java.util.ArrayList;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        symbols = symbols.toLowerCase();
        word = word.toLowerCase();
        ArrayList<Character> letters = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            letters.add(ch);
            int index = symbols.indexOf(ch);
            if (letters.contains(ch)) {
                letters.remove(ch);
            } else {
                return false;
            }
        }
        return true;
    }
}

//END
