package com.pb.ssn.hw14;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
    private DataInputStream dis;
    private boolean flag = true;

    private void closeDataInputStream() {
        try {
            dis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Receive(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            flag = false;
            closeDataInputStream();
            e.printStackTrace();
        }
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
                System.out.println(msg);
            }
        }

        closeDataInputStream();
    }
}
