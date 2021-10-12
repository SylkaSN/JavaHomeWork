package com.pb.ssn.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите число от 0 до 100: ");
        int number = scan.nextInt();

        if (number>=0 && number<=14) {
            System.out.println("Введенное число попадает в интервал [0 - 14]");
        } else if (number>=15 && number<=35) {
            System.out.println("Введенное число попадает в интервал [15 - 35]");
        } else if (number>=36 && number<=50) {
            System.out.println("Введенное число попадает в интервал [36 - 50]");
        } else if (number>=51 && number<=100) {
            System.out.println("Введенное число попадает в интервал [51 - 100]");
        } else {
            System.out.println("Введеное число не попало ни в один из интервалов");
        }
    }
}
