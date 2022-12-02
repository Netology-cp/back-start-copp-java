import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        CycleParams cycleParams = new CycleParams(); // создали экземпляр класса
        
        System.out.println("Привет! Я тайм-менеджер Pomodoro!\nВведите количество задач на сегодня:");
        cycleParams.setCount(new Scanner(System.in).nextInt()); //задали значение полю count

        System.out.println("Введите длительность промежутка работы (в минутах):");
        cycleParams.setWork(new Scanner(System.in).nextInt()); //задали значение полю work

        System.out.println("Введите длительность промежутка отдыха (в минутах):");
        cycleParams.setBreake(new Scanner(System.in).nextInt()); //задали значение полю breake

        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= cycleParams.getCount(); i++) {
            timer(cycleParams.getCount(), cycleParams.getWork(), cycleParams.getBreake()); //передали нужные значения
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Pomodoro таймер истек: " + (endTime - startTime) / (1000 * 60) + " min");
    }

    public static void timer(int count, int work, int breake) throws InterruptedException {
        System.out.println("Задача №" + count);
        printProgress("Work Progress::  ", work);
        printProgress("Break Progress:: ", breake);
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