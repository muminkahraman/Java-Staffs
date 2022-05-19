package Week1.Task2.Task2A;

import java.util.ArrayList;

public class PetShopApplication {
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();

        pets.add(new Cat("a", "n", 4, 5));
        pets.add(new Cat("a", "n", 4, 5));
        pets.add(new Cat("a", "n", 4, 5));

        pets.add(new Budgie("A", "B", "red"));
        pets.add(new Budgie("A", "B", "red"));

        System.out.println("name     overName     numberOfTeeth     lenghtOfTail     colourOfFeathers");
        for (Pet pet: pets) {
            System.out.println(pet);
        }
    }

    }

