package com.pb.ssn.hw7;

public class Atelier {
    public static void dressMan(Clothes[] clothes) {
        for (Clothes clothe : clothes) {
            if (clothe instanceof ManClothes) {
                ((ManClothes) clothe).dressMan();
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        for (Clothes clothe : clothes) {
            if (clothe instanceof WomenClothes) {
                ((WomenClothes) clothe).dressWomen();
            }
        }
    }


    public static void main(String[] args) {
        Tshirt manTShirt = new Tshirt(Size.L, "черный", 250);
        Tshirt womenTShirt = new Tshirt(Size.S, "желтый", 300);
        Pants manPants = new Pants(Size.L, "коричневый", 260);
        Pants womenPants = new Pants(Size.S, "синий", 260);
        Skirt skirt = new Skirt(Size.S, "красный", 200);
        Tie tie = new Tie(Size.L, "фиолетовый", 260);

        Clothes[] manClothes = {manTShirt, manPants, tie};
        Clothes[] womenClothes = {womenTShirt, womenPants, skirt};

        System.out.println("--==>> Одеваем мужчину");
        dressMan(manClothes);

        System.out.println("");
        System.out.println("--==>> Одеваем женщину");
        dressWomen(womenClothes);
    }
}
