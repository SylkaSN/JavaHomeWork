package com.pb.ssn.hw13;

import java.util.LinkedList;

public class Producer extends Thread {
    public static final String ANSI_GREEN = "\u001B[32m";
    final private LinkedList<Integer> list;

    public Producer(LinkedList<Integer> list)  {
        System.out.println(ANSI_GREEN + "--==>> Создаем Производителя");
        this.list = list;
    }

    @Override
    public void run() {
        boolean get_next_val = true;
        int val = 0;

        while (get_next_val) {
            val++;
            if (val == 100) get_next_val = false;

            synchronized (list) {
                while (list.size() == 5) {
                    System.out.println(ANSI_GREEN + "--==>> list.size() = " + list.size() + " --> переходим в режим ожидания");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                list.add(val);
                System.out.println(ANSI_GREEN + "--==>> В буфер вставленно -> " + val + ": list.size() = " + list.size());
                list.notify();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public synchronized void start() {
        System.out.println(ANSI_GREEN + "--==>> Запускаем процесс Производителя");
        super.start();
    }
}
