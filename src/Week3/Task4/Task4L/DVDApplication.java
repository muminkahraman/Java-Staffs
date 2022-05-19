package Week3.Task4.Task4L;

import java.util.Scanner;

public class DVDApplication {

    public static void main(String[] args) {

        Person P1=new Person("Eren","Jaeger");
        Person P2=new Person("San","Goku");
        Person P3=new Person("Mugiwara","Luffy");
        Person P4=new Person("Livai","Ackerman");

        DVD DVD1= new DVD("Shingeki no Kyojin",P4,3);
        DVD DVD2= new DVD("Drago Ball",P2,4);
        DVD DVD3= new DVD("One Piece",P3,5);

        modifyStars(DVD1,5);


        System.out.println(DVD2.getTitle());
        System.out.println(DVD1.getLeadActor().getFullName());
        System.out.println(DVD2.getNumberOfStars());

        System.out.println(DVD2.toString());

        DVD DVD1clone = null;

        System.out.println("\nBefore cloning");
        System.out.printf("\tP1: %s\n", P1.getFullName());
        System.out.printf("\tDVD1: title : %s, Lead Actor : %s, Number of stars : %s \n", DVD1.getTitle(), DVD1.getLeadActor().getFullName(), DVD1.getNumberOfStars());
        System.out.printf("\tcloneOfDVD1: %s\n", DVD1clone);

        try
        {
            DVD1clone = (DVD) DVD1.clone();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println("\nERROR: There was a problem with the clone");
        }

        System.out.println("\nAfter cloning");
        System.out.printf("\tP1: %s\n", P1.getFullName());
        System.out.printf("\tDVD1: title : %s, Lead Actor : %s, Number of stars : %s\n", DVD1.getTitle(), DVD1.getLeadActor().getFullName(), DVD1.getNumberOfStars());
        System.out.printf("\tCloneOfDVD1: title : %s, Lead Actor : %s, Number of stars : %s\n",DVD1clone.getTitle(), DVD1clone.getLeadActor().getFullName(), DVD1clone.getNumberOfStars());


    }

    private static void modifyStars(DVD D,int newNumofStar)
    {

        if(newNumofStar > 0 && newNumofStar <= 5)
        {
            D = new DVD(D.getTitle(),D.getLeadActor(),newNumofStar);
            System.out.println("Operation done");

        }
        else
        {
            System.out.println("Impossible to get this number of star");
        }

    }
}
