package com.pb.ssn.hw15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    private static final int SERVER_PORT = 9876;

    private final ArrayList<ClientHandler> all = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new ChatServer().start();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);
        System.out.println("--==>> Сервер запущен на порту: " + SERVER_PORT);

        System.out.println("--==>> Ждем подключения ...");
        while (true) {
            Socket client = server.accept();
            ClientHandler channel = new ClientHandler(client, this);
            all.add(channel);
            new Thread(channel).start();
        }
    }

    public ArrayList<ClientHandler> getAll() {
        return this.all;
    }
}
