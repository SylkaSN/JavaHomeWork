package com.pb.ssn.hw15;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private DataInputStream dis;
    private DataOutputStream dos;
    private ChatServer server;
    private boolean flag = true;

    private void closeDataInputStream() {
        try {
            dis.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void closeDataOutputStream() {
        try {
            dos.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public ClientHandler(Socket client, ChatServer server) {
        try {
            this.server = server;

            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            flag = false;
            closeDataInputStream();
            closeDataOutputStream();
            e.printStackTrace();
        }
    }

    private String receive() {
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            flag = false;
            server.getAll().remove(this);
            closeDataInputStream();
            e.printStackTrace();
        }
        return msg;
    }

    private void send(String msg) {
        if (msg == null || msg.equals("")) {
            return;
        }

        try {
            dos.writeUTF(msg);
        } catch (IOException e) {
            flag = false;
            server.getAll().remove(this);
            closeDataOutputStream();
            e.printStackTrace();
        }
    }

    private void sendOthers(String msg) {
        for (ClientHandler other : server.getAll()) {
            other.send(msg);
        }
        System.out.println(msg);
    }

    @Override
    public void run () {
        send("--==>> Добро пожаловать в групповой чат");

        String nameClient = receive();
        sendOthers("--==>> К нам на огонек зашел - " + nameClient + ". Всего - " + server.getAll().size());

        while (flag) {
            String msg = receive();

            if (msg.equals("exit")) {
                flag = false;
                send(msg);
            } else {
                sendOthers(msg);
            }
        }

        closeDataOutputStream();
        closeDataInputStream();
        server.getAll().remove(this);

        sendOthers("--==>> " + nameClient + " покинул чат. Осталось - " + server.getAll().size());
    }
}
