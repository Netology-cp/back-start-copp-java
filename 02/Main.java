import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main {
    public static final int WORK = 1;
    public static final int BREAK = 1;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Привет! Я тайм-менеджер Pomodoro!\nВведите количество задач на сегодня:");

        int count = new Scanner(System.in).nextInt();

        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= count; i++) {
            timer(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Pomodoro таймер истек: " + (endTime - startTime) / (1000 * 60) + " min");
    }

    public static void timer(int count) throws InterruptedException {
        System.out.println("Задача №" + count);
        printProgress("Work Progress::  ", WORK);
        printProgress("Break Progress:: ", BREAK);
    }

    private static void printProgress(String process, int time) throws InterruptedException {
        int length;
        int rep;
        length = 60 * time / 30;
        rep = 60 * time / length;
        int stretch = 30 / (3 * time);
        for (int i = 1; i <= rep; i++) {
            double x = i;
            x = 1.0 / 3.0 * x;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            double w = time * stretch;
            double percent = (x / w) * 1000;
            x /= stretch;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            percent = Math.round(percent);
            percent /= 10;
            System.out.print(process + percent + "% " + (" ")
                    .repeat(5 - (String.valueOf(percent).length())) + "[" + ("#")
                    .repeat(i) + ("-").repeat(rep - i) + "]    ( " + x + "min / " + time + "min )" + "\r");
            TimeUnit.SECONDS.sleep(length);
        }
        System.out.println();
    }
}
