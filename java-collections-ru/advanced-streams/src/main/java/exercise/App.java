package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        String result = "";

        // Ищем строки с командой environment
        List<String> envStrings = Arrays.asList(content.split("\n"))
                .stream()
                .filter(s -> s.startsWith("environment="))
                .collect(Collectors.toList());

        // Извлекаем переменные
        List<String> variables = envStrings.stream()
                .flatMap(s -> Arrays.asList(s.split(",")).stream())
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .collect(Collectors.toList());

        // Конвертируем переменные в строку формата "имя1=значение1,имя2=значение2,имя3=значение3,..."
        for (String var : variables) {
            String[] parts = var.split("=");
            if (parts.length == 2) {
                String name = parts[0].replace("X_FORWARDED_", "");
                String value = parts[1].trim();
                result += name + "=" + value + ",";
            }
        }
        // Удаляем последнюю запятую и возвращаем результат
        return result.substring(0, result.length() - 1);
    }
}
//END
