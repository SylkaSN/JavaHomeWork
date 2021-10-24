package com.pb.ssn.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        String firstString = getString();
        System.out.println("");

        String secondString = getString();
        System.out.println("");

        if (isAnagram(firstString, secondString)) {
            System.out.println("Строка является Анаграмой");
        } else {
            System.out.println("Строка не является Анаграмой");
        }
    }

    private static String getString() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        return scan.nextLine();
    }

    private static boolean isAnagram (String f_str, String s_str) {
        char[] arrFirst = f_str.replaceAll("[,.:;\\- ]", "").toLowerCase().toCharArray();
        char[] arrSecond = s_str.replaceAll("[,.:;\\- ]", "").toLowerCase().toCharArray();

        if (arrFirst.length != arrSecond.length) {
            return false;
        }

        Arrays.sort(arrFirst);
        Arrays.sort(arrSecond);

        return Arrays.equals(arrFirst, arrSecond);
    }
}
