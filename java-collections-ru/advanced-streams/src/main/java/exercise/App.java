package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        String[] lines = content.split("\n");
        return Arrays.stream(lines)
                .flatMap(line -> {
                    if (line.startsWith("environment=")) {
                        String[] envVars = line.substring(12, line.length() - 1).split(",");
                        return Arrays.stream(envVars)
                                .filter(envVar -> envVar.startsWith("X_FORWARDED_"))
                                .map(envVar -> envVar.substring(12))
                                .map(envVar -> {
                                    String[] parts = envVar.split("=");
                                    return parts[0] + "=" + parts[1];
                                });
                    } else {
                        return Stream.empty();
                    }
                })
                .collect(Collectors.joining(","));
    }
}
//END
