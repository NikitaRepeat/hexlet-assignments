package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("\n"))
                .filter(line -> line.contains("environment"))
                .flatMap(line -> Arrays.stream(line.split("\"")))
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.replace("X_FORWARDED_", ""))
                .map(variable -> {
                    String[] variableValue = variable.split("=");
                    String name = variableValue[0];
                    String value = variableValue[1].trim();
                    return name + "=" + value;
                })
                .collect(Collectors.joining(","));
    }
}
//END
