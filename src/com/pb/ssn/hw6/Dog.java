package com.pb.ssn.hw6;

import java.util.Objects;

public class Dog extends Animal {
    int learning_ability;  // Learning ability - rate from 1 no 10

    public Dog() {
        super("royal canin", "будка");
        learning_ability = 8;
    }

    public int getLearning_ability() {
        return learning_ability;
    }

    public void setLearning_ability(int learning_ability) {
        this.learning_ability = learning_ability;
    }

    @Override
    public String makeNoise() {
        return "Собака лает";
    }

    @Override
    public String eat() {
        return "Собака ест " + getFood();
    }

    @Override
    public String sleep() {
        return "Собака спит в будке";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFood(), getLocation(), learning_ability);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dog dog = (Dog) obj;
        return Objects.equals(getFood(), dog.getFood())
                && Objects.equals(getLocation(), dog.getLocation())
                && learning_ability == dog.learning_ability;
    }

    @Override
    public String toString() {
        return "Собака";
    }
}
