package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        sentence = sentence.toLowerCase();
        Map<String, Integer> wordsCount = new HashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 1);
            } else {
                int count = wordsCount.get(word);
                wordsCount.put(word, count + 1);
            }
        }
        return wordsCount;
    }
    public static String toString(Map<String, Integer> wordsCount) {
        StringBuilder sb = new StringBuilder("{\n");
        for (String word : wordsCount.keySet()) {
            sb.append("  ").append(word).append(": ").append(wordsCount.get(word)).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
//END
