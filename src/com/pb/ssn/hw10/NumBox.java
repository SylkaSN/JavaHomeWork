package com.pb.ssn.hw10;

public class NumBox <T extends Number> {
    private final T[] numbers;

    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public void add(int index, T number) {
        try {
            this.numbers[index] = number;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString() + " индекс выходит за границы массива");
            throw e;
        }
    }

    public T get(int index) {
        return numbers[index];
    }

    public int length() {
        return numbers.length;
    }

    public double average() {
        double sm = 0;
        int cnt   = 0;

        for (Number num : numbers) {
           cnt++;
           sm = sm + num.doubleValue();
        }
        return sm / cnt;
    }

    public double sum() {
        double sm = 0;

        for (Number num : numbers) {
            sm = sm + num.doubleValue();
        }
        return sm;
    }

    public T max() {
        Number maxNum = 0;

        for (Number num : numbers) {
            if (maxNum.doubleValue() < num.doubleValue()) {
                maxNum = num;
            }
        }
        return (T) maxNum;
    }
}
