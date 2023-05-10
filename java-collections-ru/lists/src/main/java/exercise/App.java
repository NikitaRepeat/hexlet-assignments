package exercise;

import java.util.ArrayList;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        symbols = symbols.toLowerCase();
        word = word.toLowerCase();
        ArrayList<Character> letter = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            letter.add(ch);
            int index = symbols.indexOf(ch);
            if (letter.contains(ch)) {
                letter.remove(ch);
            } else {
                return false;
            }
        }
        return true;
    }
}

//END
