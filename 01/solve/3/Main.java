package org.example.first;

import java.util.Random;
import java.util.Scanner;

    /*
        2. Сделать поле word переменной внутри метода main. Чтобы код при этом не поломался, везде, где сейчас
           word используется, как поле класса, передавать вновь созданную переменную как параметр.
     */

public class Main1 {

    static String[] words = {"javalove", "netology", "developer"};

    // private static String word   <--- отcюда поле убрали

    private static String chooseWord(String[] arr) {
        return arr[new Random().nextInt(arr.length)];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String word = chooseWord(words);    // <-- объявили переменную внутри метода main

        // javalove --------
        System.out.println("Угадай слово");
        int lengthWord = word.length();
        String maskWord = "-".repeat(lengthWord);
        System.out.println(maskWord);

        // --------
        // a
        // -a-a----
        // o
        // -a-a-o--
        do {
            System.out.println("Введите букву");
            char c = input.next().charAt(0);
            // a 2
            // w -1
            if (word.indexOf(c) >= 0) {
                System.out.println("Удача");
                for (char elem : word.toCharArray()) {
                    if (elem == c) {
                        maskWord = replaceMaskLetter(c, maskWord, word);             // <-- в этот метод передаем слово дополнительным параметром
                    }
                }
                System.out.println(maskWord);
            } else {
                System.out.println("Промах, поробуй еще раз");
                System.out.println(maskWord);
            }
        } while (maskWord.contains("-"));
        System.out.println("Поздравляем ты выйграл");
    }

    /*
    -a-a---- j
    ja-a----
     */
    public static String replaceMaskLetter(char c, String maskWord, String word) {          // <-- в метод добавили дополнительный параметр - слово
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
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