package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        StringBuilder res = new StringBuilder();
        String[] lines = content.split("\n");
        for (String line : lines) {
            if (line.contains("environment")) {
                String[] envs = line.split("\"")[1].split(",");
                for (String env : envs) {
                    if (env.startsWith("X_FORWARDED_")) {
                        env = env.replaceAll("X_FORWARDED_", "");
                        String name = env.split("=")[0];
                        String value = env.split("=")[1];
                        res.append(name);
                        res.append("=");
                        res.append(value);
                        res.append(",");
                    }
                }
            }
        }
        return res.toString().replaceAll(",$", "");
    }
}
//END
