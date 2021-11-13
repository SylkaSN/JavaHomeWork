package com.pb.ssn.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes  {

    public Tshirt(Size size, String color, float cost) {
        super(size, color, cost);
    }

    @Override
    public void dressMan() {
        System.out.println("Одеть мужскую футболку, размер (" + super.getSize().getEuroSize()
                            + "), цвет (" + super.getColor() + "), стоимость (" + super.getCost() + ")");
    }

    @Override
    public void dressWomen() {
        System.out.println("Одеть женскую футболку, размер (" + super.getSize().getEuroSize()
                + "), цвет (" + super.getColor() + "), стоимость (" + super.getCost() + ")");
    }
}
