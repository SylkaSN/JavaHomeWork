package com.pb.ssn.hw6;

import java.lang.reflect.Constructor;

public class VetClinic {
    public static void main(String[] args) throws Exception {
        Animal[] animals = {new Dog(), new Cat(), new Horse()} ;

        Class veterinarianClazz = Class.forName("com.pb.ssn.hw6.Veterinarian");
        Constructor constr = veterinarianClazz.getConstructor();
        Object obj = constr.newInstance();

        if (obj instanceof Veterinarian) {
            for (Animal animal: animals) {
                ((Veterinarian)obj).treatAnimal(animal);
            }
        }
    }
}
