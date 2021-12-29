package com.pb.ssn.hw14;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Send implements Runnable {
    private final BufferedReader console;
    private DataOutputStream dos;
    private boolean flag = true;
    private final String name;

    public Send(Socket client, String name) {
        console = new BufferedReader(new InputStreamReader(System.in));

        this.name = name;
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        }
    }

    // Получаем данные из консоли
    private String getMsgFromConsole() {
        String msg = "";
        try {
            msg = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    // отправить данные
    public void send(String msg) {
        String fmtMsg = this.name + " (" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) + "): ";

        if (msg != null && !msg.equals("")){
            if (msg.equals("exit")) {
                fmtMsg = msg;
                flag = false;
            } else{
                fmtMsg = fmtMsg + msg;
            }
        } else {
            fmtMsg = name;
        }

        try {
            dos.writeUTF(fmtMsg);
            dos.flush();
        } catch (IOException ex) {
            flag = false;
            try {
                console.close();
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        send("");

        while (flag) {
            send(getMsgFromConsole());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            console.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
