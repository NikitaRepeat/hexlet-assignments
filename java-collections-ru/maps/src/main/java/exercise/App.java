package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsCount = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();
        for(String w : sentence.split(" ")) {
            words.add(w);
        }
        int count = 1;

        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (wordsInSentence[i].equals(wordsInSentence[j])) {
                    count += 1;
                    words.remove(j);
                }
            }
            wordsCount.put(wordsInSentence[i], count);
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
