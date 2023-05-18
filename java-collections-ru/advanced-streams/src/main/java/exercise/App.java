package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("\n"))
                .filter(line -> line.startsWith("environment="))
                .flatMap(line -> Arrays.stream(line.split(",")))
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.replaceFirst("X_FORWARDED_", ""))
                .map(variable -> variable.split("="))
                .map(variableArr -> variableArr[0] + "" + variableArr[1])
                .collect(Collectors.joining(","));
    }
}
//END
