package com.pb.ssn.hw6;

import java.util.Objects;

public class Cat extends Animal {
    int mustache_length; // Mustache length in centimeters

    public Cat() {
        super("whiskas", "кресло");
        mustache_length = 10;
    }

    public int getMustache_length() {
        return mustache_length;
    }

    public void setMustache_length(int mustache_length) {
        this.mustache_length = mustache_length;
    }

    @Override
    public String makeNoise() {
        return "Кот урчит";
    }

    @Override
    public String eat() {
        return "Кот ест " + getFood();
    }

    @Override
    public String sleep() {
        return "Кот спит на кресле";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFood(), getLocation(), mustache_length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cat cat = (Cat) obj;
        return Objects.equals(getFood(), cat.getFood())
                && Objects.equals(getLocation(), cat.getLocation())
                && mustache_length == cat.mustache_length;
    }

    @Override
    public String toString() {
        return "Кот";
    }
}
