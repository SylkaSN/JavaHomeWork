package com.pb.ssn.hw15;

import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
    private DataInputStream dis;
    private boolean flag = true;
    private final TextArea textArea;

    private void closeDataInputStream() {
        try {
            dis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Receive(Socket client, TextArea textArea) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            flag = false;
            closeDataInputStream();
            e.printStackTrace();
        }
        this.textArea = textArea;
    }

    // Получаем данные
    public String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            flag = false;
            closeDataInputStream();
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public void run() {
        while(flag){
            String msg = receive();
            if (msg.equals("exit")) {
                flag = false;
                closeDataInputStream();
            } else {
                textArea.appendText(msg + "\n");
            }
        }
        closeDataInputStream();
    }
}
