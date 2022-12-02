import java.util.Random; // для определения случайного числа
import java.util.Scanner;

public class Main {

    static String[] words = {"javalove", "netology", "developer"};      // <--- добавили массив

    static String word;

    // добавили метод выбора случайного слова из массива 
    private static String chooseWord(String[] arr) {
        return arr[new Random().nextInt(arr.length)];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        word = chooseWord(words);   // <-- выбираем слово

        System.out.println("Угадай слово");
        int lengthWord = word.length();
        String maskWord = "-".repeat(lengthWord); // в начале вместо каждой буквы в слове стоит знак «-», если буква будет угдана, то знак поменяется на нужную букву
        System.out.println(maskWord);

       do {
            System.out.println("Введите букву");
            char c = input.next().charAt(0); // считываем введенный символ
            
            if (word.indexOf(c) >= 0) { // проверяем есть ли введенная буква в слове
                System.out.println("Удача");
                for (char elem : word.toCharArray()) { // просматриваем все слово, чтобы заменить «-» на буквы
                    if (elem == c) {
                        maskWord = replaceMaskLetter(c, maskWord); // если буква есть, то вызываем метод replaceMaskLetter, который заменяет «-» в слове на найденную букву
                    }
                }
                System.out.println(maskWord); // выводим обновленное слово с добавленной отгаданной буквой
            } else {
                System.out.println("Промах, поробуй еще раз");
                System.out.println(maskWord); // если буквы нет, то просто выводим слово с «-» и ранее угаданными буквами
            }
        } while (maskWord.contains("-")); // повторяем действия пока в слове еще будут неотгаданные буквы, то есть будет хотя бы один символ «-»
        System.out.println("Поздравляем ты победил");
    }


    public static String replaceMaskLetter(char c, String maskWord) { // метод, который в строке maskWord заменяет «-» на символ «с» в соответствии с загаданным словом
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
