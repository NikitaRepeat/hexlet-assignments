package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(Objects::nonNull)
                .map(user -> user.get("name"))
                .sorted((user1, user2) -> user1.compareTo(user2))
                .collect(Collectors.toList());

    }
}
// END
