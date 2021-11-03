package com.pb.ssn.hw6;

public class Veterinarian {
    public Veterinarian() { }

    public void treatAnimal(Animal animal) {
        System.out.println(animal.toString() + " [" + animal.getFood() + "; " + animal.getLocation() + "]");
    }
}
