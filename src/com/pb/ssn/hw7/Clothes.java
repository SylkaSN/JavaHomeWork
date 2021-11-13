package com.pb.ssn.hw7;

public abstract class Clothes {
    private Size size;
    private float cost;
    private String color;

    public Clothes(Size size, String color, float cost) {
        this.size = size;
        this.color = color;
        this.cost = cost;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
