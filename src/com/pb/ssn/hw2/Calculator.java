package com.pb.ssn.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1;
        int operand2;
        int result;
        String sign;

        System.out.println("Введите первое число: ");
        operand1 = scan.nextInt();

        System.out.println("Введите второе число:");
        operand2 = scan.nextInt();

        System.out.println("Введите знак арифметического действия (+, -, *, /):");
        sign = scan.next();

        switch (sign) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    System.out.println("Деление на ноль");
                    return;
                }
                else {
                    result = operand1 / operand2;
                }
                break;
            default:
                System.out.println("Неподдерживаемое арифметическое действие");
                return;
        }

        System.out.println(operand1 + " " + sign + " " + operand2 + " = " + result);
    }
}
