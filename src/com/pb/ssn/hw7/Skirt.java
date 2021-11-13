package com.pb.ssn.hw7;

public class Skirt extends Clothes implements WomenClothes {
    public Skirt(Size size, String color, float cost) {
        super(size, color, cost);
    }

    @Override
    public void dressWomen() {
        System.out.println("Одеть юбку, размер (" + super.getSize().getEuroSize()
                + "), цвет (" + super.getColor() + "), стоимость (" + super.getCost() + ")");
    }
}
