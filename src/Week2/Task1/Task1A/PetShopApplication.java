package Week2.Task1.Task1A;

import java.util.ArrayList;

public class PetShopApplication {
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();

        pets.add(new Cat("a", "n", 4, 5));
        pets.add(new Cat("a", "n", 4, 5));
        pets.add(new Cat("a", "n", 4, 5));

        pets.add(new Budgie("A", "B", "red"));
        pets.add(new Budgie("A", "B", "red"));

        Cat cat=new Cat("a", "n", 4, 5);

        printPetDetails(pets);
        printCatDetails(pets);

    }

    private static void printPetDetails(ArrayList<Pet> pets){
        System.out.println("name     overName     numberOfTeeth     lenghtOfTail     colourOfFeathers");
        System.out.println("_________________________________________________________________________");
        for (Pet pet: pets) {
             if (pet instanceof Pet)
            System.out.println(pet);

        }
    }
    private static void printCatDetails(ArrayList<Pet> pets){
        System.out.println("List of cats");
        System.out.println("name     overName     numberOfTeeth     lenghtOfTail     colourOfFeathers");
        System.out.println("_________________________________________________________________________");
        for (Pet pet: pets) {
            if (pet instanceof Cat)
                System.out.println(pet);

        }
    }



    }

