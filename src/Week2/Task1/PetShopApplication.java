package Week2.Task1;

public class PetShopApplication {

    public static void main(String[] args) {
        Pet[] pets = new Pet[5];


        pets[0] = new Cat("cat1", "owner1", 1, 1);
        pets[1] = new Cat("cat2", "owner2", 2, 2);
        pets[2] = new Cat("cat3", "owner3", 3, 3);
        pets[3] = new Budgie("bird1", "owner4", "red");
        pets[4] = new Budgie("bird2", "owner5", "green");

        System.out.printf("All pets \n");
        System.out.printf("%-15s","Pet name");
        System.out.printf("%-15s","Owner name");
        System.out.printf("%-15s","Teeth");
        System.out.printf("%-15s","Tail length");
        System.out.printf("%-15s \n","Feather colour");
        System.out.printf("%-15s","========");
        System.out.printf("%-15s","==========");
        System.out.printf("%-15s","=====");
        System.out.printf("%-15s","===========");
        System.out.printf("%-15s \n","==============");

        printAnimals(pets);

    }

    private static void printAnimals(Pet[] pets) {
        for (Pet pet : pets) {

            if (pet instanceof Cat){
                System.out.print( pet.toString());
            } else if (pet instanceof Budgie) {
                System.out.print(pet.toString());
            }
        }
    }
}
