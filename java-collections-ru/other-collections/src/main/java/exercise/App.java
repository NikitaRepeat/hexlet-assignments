package exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, ?> map1, Map<String, ?> map2) {
        TreeMap<String, String> resultMap = new TreeMap<>();
        //перебираем все ключи из двух словарей
        for (String key : concatKeys(map1, map2)) {
            //если ключ есть только во втором словаре, значит он был добавлен
            if (!map1.containsKey(key) && map2.containsKey(key)) {
                resultMap.put(key, "added");
                //если ключ есть только в первом словаре, значит он был удален
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                resultMap.put(key, "deleted");
                //если ключ есть и в первом и во втором словаре
                //и значения разные, то ключ был изменен
            } else if (map1.containsKey(key) && map2.containsKey(key) && !map1.get(key).equals(map2.get(key))) {
                resultMap.put(key, "changed");
                //если ключ есть и в первом и во втором словаре
                //и значения одинаковые, то ключ не был изменен
            } else {
                resultMap.put(key, "unchanged");
            }
        }
        return new LinkedHashMap<>(resultMap);
    }

    //метод для объединения ключей из двух словарей
    private static String[] concatKeys(Map<String, ?> map1, Map<String, ?> map2) {
        return Stream.concat(map1.keySet().stream(), map2.keySet().stream())
                .distinct()
                .sorted()
                .toArray(String[]::new);
    }
}

//END
