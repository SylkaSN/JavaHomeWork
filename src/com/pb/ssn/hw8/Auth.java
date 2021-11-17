package com.pb.ssn.hw8;

public class Auth {
    private String login;
    private String password;

    public Auth() {
    }

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        // verification login
        if (login.length()>=5 && login.length()<=20 && login.matches("[a-zA-Z0-9]+")) {
            this.login = login;
        } else {
            throw new WrongLoginException("ОШИБКА!!! Введенный логин не соответсвует требованиям");
        }

        // verification password
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("ОШИБКА!!! Введенный пароль не совпадает с контрольным вводом");
        }

        if (password.length()>=5 && password.matches("[a-zA-Z0-9_]+")) {
            this.password = password;
        } else {
            throw new WrongPasswordException("ОШИБКА!!! Введенный пароль не соответсвует требованиям");
        }
    }

    public void signIn(String login, String password) throws WrongLoginException {
        if (this.login.equals(login) && this.password.equals(password)) {
            System.out.println("Вход в систему одобрен! Приветствуем в нашем магазине!");
        } else {
            throw new WrongLoginException("ОШИБКА!!! Неправильный логин или пароль");
        }
    }
}
