package com.pb.ssn.hw6;

public class Animal {
    private String food;
    private String location;

    public Animal() { }

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String makeNoise() {
        return "Животное издает звуки";
    }

    public String eat() {
        return "Животное с удовольствием кушает";
    }

    public String sleep() {
        return "Животное спит в логове";
    }
}
