import java.util.Random; // для определения случайного числа
import java.util.Scanner;

public class Main {

    static String[] words = {"javalove", "netology", "developer"};

    // private static String word   <--- отcюда поле убрали

    private static String chooseWord(String[] arr) {
        return arr[new Random().nextInt(arr.length)];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String word = chooseWord(words);    // <-- объявили переменную внутри метода main

        System.out.println("Угадай слово");
        int lengthWord = word.length();
        String maskWord = "-".repeat(lengthWord); // в начале вместо каждой буквы в слове стоит знак «-», если буква будет угдана, то знак поменяется на нужную букву
        System.out.println(maskWord);

        do {
            System.out.println("Введите букву"); // считываем введенный символ
            char c = input.next().charAt(0);

            if (word.indexOf(c) >= 0) { // проверяем есть ли введенная буква в слове
                System.out.println("Удача");
                for (char elem : word.toCharArray()) { // просматриваем все слово, чтобы заменить «-» на буквы
                    if (elem == c) {
                        maskWord = replaceMaskLetter(c, maskWord, word);             // <-- в этот метод передаем слово дополнительным параметром
                    }
                }
                System.out.println(maskWord); // выводим обновленное слово с добавленной отгаданной буквой
            } else {
                System.out.println("Промах, поробуй еще раз");
                System.out.println(maskWord); // если буквы нет, то просто выводим слово с «-» и ранее угаданными буквами
            }
        } while (maskWord.contains("-")); // повторяем действия пока в слове еще будут неотгаданные буквы, то есть будет хотя бы один символ «-»
        System.out.println("Поздравляем ты выйграл");
    }

    public static String replaceMaskLetter(char c, String maskWord, String word) {          // <-- в метод добавили дополнительный параметр - слово
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) { // в цикле по порядку перебираем каждую букву из слова
            if (word.charAt(i) == c) {
                stringBuilder.append(c);
            } else if (maskWord.charAt(i) != '-') {
                stringBuilder.append(maskWord.charAt(i));
            } else {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }
}
