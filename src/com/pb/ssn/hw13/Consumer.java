package com.pb.ssn.hw13;

import java.util.LinkedList;

public class Consumer extends Thread {
    public static final String ANSI_YELLOW = "\u001B[33m";

    final private LinkedList<Integer> list;

    public Consumer(LinkedList<Integer> list) {
        System.out.println(ANSI_YELLOW + "--==>> Создаем Потребителя");

        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                while (list.size() == 0) {
                    System.out.println(ANSI_YELLOW + "--==>> list.size() = 0 --> переходим в режим ожидания");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int val = list.remove();
                System.out.println(ANSI_YELLOW + "--==>> Из буфера прочитанно -> " + val + ": list.size() = " + list.size());
                list.notify();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(ANSI_YELLOW + "--==>> Работа Потребителя остановлена");
                    break;
                }
            }
        }
    }

    @Override
    public synchronized void start() {
        System.out.println(ANSI_YELLOW + "--==>> Запускаем процесс Потребителя");
        super.start();
    }
}
