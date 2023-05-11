package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.Objects;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> inputEmails) {
        long emailList = inputEmails.stream()
                .filter(Objects::nonNull)
                .filter(email -> !email.isEmpty() && email.contains("gmail.com") || email.contains("yandex.ru") || email.contains("hotmail.com"))
                .count();
        return emailList;
    }
}
// END
