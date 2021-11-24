package com.pb.ssn.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Integer> intNumBox = new <Integer> NumBox<Integer>(4);
        NumBox<Float> floatNumBox = new <Float> NumBox<Float>(3);

        intNumBox.add(0, 10);
        intNumBox.add(1, 20);
        intNumBox.add(2, 30);
        intNumBox.add(3, 40);
        // Check Exception
        //intNumBox.add(4, 50);

        floatNumBox.add(0, (float) 10.12);
        floatNumBox.add(1, (float) 11.15);
        floatNumBox.add(2, (float) 12.17);

        System.out.println("---===>>> Integer array {10, 20, 30, 40}");
        System.out.println("intNumBox.length()  = " + intNumBox.length());
        System.out.println("intNumBox.get(2)    = " + intNumBox.get(2));
        System.out.println("intNumBox.sum()     = " + intNumBox.sum());
        System.out.println("intNumBox.average() = " + intNumBox.average());
        System.out.println("intNumBox.max()     = " + intNumBox.max());
        System.out.println(" ");

        System.out.println("---===>>> Float array {10.12, 11.15, 12.17}");
        System.out.println("floatNumBox.length()  = " + floatNumBox.length());
        System.out.println("floatNumBox.get(2)    = " + floatNumBox.get(2));
        System.out.println("floatNumBox.sum()     = " + floatNumBox.sum());
        System.out.println("floatNumBox.average() = " + floatNumBox.average());
        System.out.println("floatNumBox.max()     = " + floatNumBox.max());
        System.out.println(" ");
    }
}
