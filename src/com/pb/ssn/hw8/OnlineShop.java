package com.pb.ssn.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String login;
            String passwd;
            String confirmPasswd;

            Auth auth = new Auth();

            System.out.println("Для начала, зарегистрируйтесь");
            System.out.println("-----------------------------");
            System.out.print("Введите новый логин: ");
            login = scan.nextLine();
            System.out.print("Введите новый пароль: ");
            passwd = scan.nextLine();
            System.out.print("Повторите ввод пароля: ");
            confirmPasswd = scan.nextLine();
            System.out.println("");
            auth.signUp(login, passwd, confirmPasswd);

            System.out.println("Теперь можно войти в магазин");
            System.out.println("----------------------------");
            System.out.print("Введите ваш логин: ");
            login = scan.nextLine();
            System.out.print("Введите ваш пароль: ");
            passwd = scan.nextLine();
            System.out.println("");
            auth.signIn(login, passwd);

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
