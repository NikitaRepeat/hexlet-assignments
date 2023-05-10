package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsCount = new HashMap<>();
        String[] wordsInSentence = sentence.split(" ").toLowerCase();
        int count = 1;
        for (int i = 0; i < wordsInSentence.length - 1; i++) {
            for (int j = i + 1; j < wordsInSentence; j++) {
                if (wordsInSentence[i] == wordsInSentence[j]) {
                    count += 1;
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
        return sb.toString()
    }
}
//END
