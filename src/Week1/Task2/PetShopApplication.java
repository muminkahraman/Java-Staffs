package Week1.Task2;

public class PetShopApplication {

    public static void main(String[] args) {
        Cat cat1 = new Cat("cat1", "owner1", 1, 1);
        Cat cat2 = new Cat("cat2", "owner2", 2, 2);
        Cat cat3 = new Cat("cat3", "owner3", 3, 3);
        Budgie bird1 = new Budgie("bird1", "owner4", "red");
        Budgie bird2 = new Budgie("bird2", "owner5", "green");

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

        printCat(cat1);
        printCat(cat2);
        printCat(cat3);
        printBudgie(bird1);
        printBudgie(bird2);
    }

    private static void printCat(Cat cat){
        System.out.printf("%-15s", cat.getName());
        System.out.printf("%-15s", cat.getOwnerName());
        System.out.printf("%-15s", cat.getNumberOfTeeth());
        System.out.printf("%-15s", cat.getLengthOfTail());
        System.out.printf("%-15s \n", "-----");
    }

    private static void printBudgie(Budgie bird){
        System.out.printf("%-15s", bird.getName());
        System.out.printf("%-15s", bird.getOwnerName());
        System.out.printf("%-15s", "-----");
        System.out.printf("%-15s", "-----");
        System.out.printf("%-15s \n", bird.getColourOfFeathers());
    }
}
