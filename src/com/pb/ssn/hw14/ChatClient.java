package com.pb.ssn.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) throws IOException {
        System.out.println("Пожалуйста, введите ник");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        Socket client = new Socket(SERVER_IP, SERVER_PORT);

        // отправляем на сервер
        new Thread(new Send(client, name)).start();

        // получаем от сервера
        new Thread(new Receive(client)).start();
    }
}
