package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        String result = "";
        StringBuilder sb = new StringBuilder();

        // Ищем строки с командой environment
        List<String> envStrings = Arrays.asList(content.split("\n"))
                .stream()
                .filter(s -> s.startsWith("environment="))
                .flatMap(s -> Arrays.stream(s.split("\"")))
                .collect(Collectors.toList());

        // Извлекаем переменные
        List<String> variables = envStrings.stream()
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replace("X_FORWARDED_", ""))
                .collect(Collectors.toList());

        // Конвертируем переменные в строку формата "имя1=значение1,имя2=значение2,имя3=значение3,..."
        for (String var : variables) {
            String[] parts = var.split("=");
            String str = sb.append(parts[0]).append("=").append(parts[1].trim()).toString();
            result += str;
        }
        // Удаляем последнюю запятую и возвращаем результат
        return result.substring(0, result.length() - 1);
    }
}
//END
