package com.pb.ssn.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    public Pants(Size size, String color, float cost) {
        super(size, color, cost);
    }

    @Override
    public void dressMan() {
        System.out.println("Одеть мужские штаны, размер (" + super.getSize().getEuroSize()
                + "), цвет (" + super.getColor() + "), стоимость (" + super.getCost() + ")");
    }

    @Override
    public void dressWomen() {
        System.out.println("Одеть женские штаны, размер (" + super.getSize().getEuroSize()
                + "), цвет (" + super.getColor() + "), стоимость (" + super.getCost() + ")");
    }
}
