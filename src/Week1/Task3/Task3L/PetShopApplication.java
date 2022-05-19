package Week1.Task3.Task3L;

import java.util.ArrayList;
import java.util.List;

public class PetShopApplication {

    public static void main(String[] args) {


        Cat C1 = new Cat("Cat 1", "Owner 10", 28, 2);
        Cat C2 = new Cat("Cat 2", "Owner 11", 27, 4);
        Cat C3 = new Cat("Cat 3", "Owner 12", 26, 6);
        Cat C4 = new Cat("Cat 4", "Owner 13", 25, 8);
        Cat C5 = new Cat("Cat 5", "Owner 14", 24, 10);
        Cat C6 = new Cat("Cat 6", "Owner 15", 23, 12);

        Budgie B1 = new Budgie("Bird 1", "Owner 21", "Blue");
        Budgie B2 = new Budgie("Bird 2", "Owner 23", "Yellow");
        Budgie B3 = new Budgie("Bird 3", "Owner 24", "Green");
        Budgie B4 = new Budgie("Bird 4", "Owner 25", "White");


        List<Pet> PetList = new ArrayList<Pet>();

        PetList.add(C1);
        PetList.add(C2);
        PetList.add(C3);
        PetList.add(C4);
        PetList.add(C5);
        PetList.add(C6);
        PetList.add(B1);
        PetList.add(B2);
        PetList.add(B3);
        PetList.add(B4);

        printPetDetails(PetList);


    }

    public static void printPetDetails(List<Pet> PetList)
    {


        System.out.println("All pets");
        System.out.printf("%-30s%-30s%-30s%-30s%s%n","Pet Name","Owner Name","Teeth","Tail lenght","Feather Colour");
        System.out.printf("%-30s%-30s%-30s%-30s%s%n","===========","===========","============","==========","=========");

        for (int i = 0 ;i<PetList.size();i++)
        {

            if(PetList.get(i) instanceof Cat)
            {
                Cat C =(Cat) PetList.get(i);
                System.out.printf("%-30s%-30s%-30s%-30s%s%n",C.getName(),C.getOwnerName(),C.getNumberOfTeeth(),C.getLengthOfTail(),"=============");
            }
            else
            {
                Budgie B =(Budgie) PetList.get(i);
                System.out.printf("%-30s%-30s%-30s%-30s%s%n",B.getName(),B.getOwnerName(),"===============","===============",B.getColourOfFeathers());
            }

        }

    }
}
