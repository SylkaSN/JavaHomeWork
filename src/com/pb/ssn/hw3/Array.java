package com.pb.ssn.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите 10 целых чисел");
        System.out.println("----------------------");

        // Fill array
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i+1) + " число: ");
            arr[i] = scan.nextInt();
        }
        System.out.println("");

        // Print array
        int sum = 0;
        int sum_positive = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);

            sum = sum + arr[i];

            if (arr[i] > 0) {
                sum_positive = sum_positive + 1;
            }
        }
        System.out.print("\n");
        System.out.println("Сумма всех элементов массива      : " + sum);
        System.out.println("Количество положительных элементов: " + sum_positive);

        // Sort array
        boolean flg_next_step;
        do {
            flg_next_step = false;

            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i+1] < arr[i]) {
                    int min = arr[i+1];
                    int max = arr[i];

                    arr[i] = min;
                    arr[i+1] = max;

                    flg_next_step = true;
                }
            }
        } while (flg_next_step);

        // Print sorted array
        System.out.println("");
        System.out.println("Отсортированный массив:");
        System.out.println("-----------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
