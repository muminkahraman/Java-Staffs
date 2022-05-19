package Week1.Task2.Task2L;

import java.util.ArrayList;
import java.util.List;

public class PetShopApplication {

    public static void main(String[] args) {

        Cat C1 = new Cat("Cat 1","Owner 1",28,10);
        Cat C2 = new Cat("Cat 2","Owner 1",24,12);
        Cat C3 = new Cat("Cat 3","Owner 2",26,15);

        Budgie B1 = new Budgie("Bird 1","Owner 2","Blue");
        Budgie B2 = new Budgie("Bird 2","Owner 3","Yellow");


        System.out.println("All pets");
        System.out.printf("%-30s%-30s%-30s%-30s%s%n","Pet Name","Owner Name","Teeth","Tail lenght","Feather Colour");
        System.out.printf("%-30s%-30s%-30s%-30s%s%n","===========","===========","============","==========","=========");
        System.out.printf("%-30s%-30s%-30s%-30s%s%n",C1.getName(),C1.getOwnerName(),C1.getNumberOfTeeth(),C1.getLengthOfTail(),"=============");
        System.out.printf("%-30s%-30s%-30s%-30s%s%n",C2.getName(),C2.getOwnerName(),C2.getNumberOfTeeth(),C2.getLengthOfTail(),"=============");
        System.out.printf("%-30s%-30s%-30s%-30s%s%n",C3.getName(),C3.getOwnerName(),C3.getNumberOfTeeth(),C3.getLengthOfTail(),"=============");
        System.out.printf("%-30s%-30s%-30s%-30s%s%n",B1.getName(),B1.getOwnerName(),"===============","===============",B1.getColourOfFeathers());
        System.out.printf("%-30s%-30s%-30s%-30s%s%n",B2.getName(),B2.getOwnerName(),"===============","===============",B2.getColourOfFeathers());


    }



}