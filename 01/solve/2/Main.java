package org.example.first;

import java.util.Random;
import java.util.Scanner;

    /*
        1. Вместо одного заданного слова сделать массив слов и метод, возвращающий случайным образом выбранное слово
     */

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
                        maskWord = replaceMaskLetter(c, maskWord);
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
    public static String replaceMaskLetter(char c, String maskWord) {
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