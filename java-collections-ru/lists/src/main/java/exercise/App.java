package exercise;

// BEGIN
public class App {
    public static boolean scrabble(String tiles, String word) {
        tiles = tiles.toLowerCase();
        word = word.toLowerCase();
        // Преобразуем строку с плитками в массив символов
        char[] tilesArr = tiles.toCharArray();
        // Проходим по буквам слова и ищем каждую букву в массиве с плитками
        for (char ch : word.toCharArray()) {
            int index = tiles.indexOf(ch);
            if (index == -1) {
                // Если буква не найдена, то слово нельзя составить
                return false;
            }
            // Удаляем букву из массива плиток, чтобы она никогда не была использована снова
            tilesArr[index] = ' ';
        }
        // Если мы прошли цикл полностью, то слово можно составить
        return true;
    }
}

//END
