package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> query) {
        List<Map<String, String>> whichBooks = new ArrayList<>();
        for (Map<String, String> book : books) {
            boolean isMatch = true;
            for (String key : query.keySet()) {
                if (!book.containsKey(key) || !book.get(key).equals(query.get(key))) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                whichBooks.add(book);
            }
        }
        return whichBooks;
    }
}
//END
