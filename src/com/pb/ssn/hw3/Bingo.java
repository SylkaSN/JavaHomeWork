package com.pb.ssn.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rnd_gen = new Random();

        int secret = rnd_gen.nextInt(101);

        System.out.println("-- Сыграем в угадайку !!!");
        System.out.println("-- Для выхода введите любое отрицательное число");
        System.out.println("");
        System.out.println("Угадайте число 0 до 100: ");
        int number = scan.nextInt();

        int count = 0;

        while (true) {
            if (number < 0) {
                System.out.println("Очень жаль, до свиданья");
                System.out.println("Количество попыток: " + count);
                return;
            }

            count++;
            if (secret == number) {
                System.out.println("Поздравляю! Вы угадали число");
                System.out.println("Количество попыток: " + count);
                return;
            } else if (secret < number) {
                System.out.println("Не угадали, введенное число больше загаданного");
            } else {
                System.out.println("Не угадали, введенное число меньше загаданного");
            }

            System.out.println("Повторите попытку введя число от 0 до 100: ");
            number = scan.nextInt();
        }
    }
}
