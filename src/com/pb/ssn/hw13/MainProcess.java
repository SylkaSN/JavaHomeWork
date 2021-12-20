package com.pb.ssn.hw13;

import java.util.LinkedList;

public class MainProcess {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    final private static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {

        Producer producer = new Producer(list);
        Consumer consumer = new Consumer(list);

        producer.start();
        consumer.start();

        try {
            producer.join();
            System.out.println(ANSI_GREEN + "--==>> Производитель закончил работу");

            while (list.size() != 0) {
                System.out.println(ANSI_YELLOW + "--==>> list.size() != 0 -->> " + list.size());
            }
            System.out.println(ANSI_YELLOW + "--==>> Останавливаем работу Потребителя");
            consumer.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
