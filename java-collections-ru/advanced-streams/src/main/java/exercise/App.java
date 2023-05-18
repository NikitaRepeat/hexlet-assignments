package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("\n"))
                .filter(line -> line.contains("environment"))
                .flatMap(line -> Arrays.stream(line.split("")))
                .filter(variables -> variables.startsWith("X_FORWARDED_"))
                .map(variables -> variables.replace("X_FORWARDED_", ""))
                .map(variables -> {
                    String[] variablesValue = variables.split("=");
                    return variablesValue[0] + "=" + variablesValue[1];
                })
                .collect(Collectors.joining(""));

    }
}
//END
