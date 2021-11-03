package com.pb.ssn.hw6;

import java.util.Objects;

public class Horse extends Animal {
    int mane_length; // Mane length in centimeters

    public Horse() {
        super("овес", "конюшня");
        mane_length = 50;
    }

    public int getMane_length() {
        return mane_length;
    }

    public void setMane_length(int mane_length) {
        this.mane_length = mane_length;
    }

    @Override
    public String makeNoise() {
        return "Лошадь ржет";
    }

    @Override
    public String eat() {
        return "Лошадь ест " + getFood();
    }

    @Override
    public String sleep() {
        return "Лошадь спит в конюшне";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFood(), getLocation(), mane_length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Horse horse = (Horse) obj;
        return Objects.equals(getFood(), horse.getFood())
                && Objects.equals(getLocation(), horse.getLocation())
                && mane_length == horse.mane_length;
    }

    @Override
    public String toString() {
        return "Лошадь";
    }
}
