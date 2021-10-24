package com.pb.ssn.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        String in_str = getString();
        System.out.println("");

        capitaliseLetter(in_str);
    }

    private static String getString() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        return scan.nextLine();
    }

    private static void capitaliseLetter(String in_str) {
        StringBuilder sb = new StringBuilder();
        boolean flg = true;

        for (char ch : in_str.toCharArray()) {
            if (flg) {
                sb.append(Character.toUpperCase(ch));
                flg = false;
            } else {
                if (ch == ' ') {
                    flg = true;
                }
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
