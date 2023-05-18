package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {

        // Ищем строки с командой environment
        List<String> envStrings = Arrays.asList(content.split("\n"))
                .stream()
                .filter(s -> s.startsWith("environment="))
                .collect(Collectors.toList());

        // Извлекаем переменные
        List<String> variables = envStrings.stream()
                .flatMap(s -> Arrays.asList(s.split(",")).stream())
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replace("X_FORWARDED_", ""))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        // Конвертируем переменные в строку формата "имя1=значение1,имя2=значение2,имя3=значение3,..."
        for (String var : variables) {
            String[] parts = var.split("=");
            sb.append(parts[0]).append("=").append(parts[1]).append(",");
        }
        // Удаляем последнюю запятую и возвращаем результат
        return sb.toString();
    }
}
//END
