
import java.util.Scanner;

public class MonthDriver
{
    public static void main(String args[])
    {
        
        System.out.println("\nSeptember has " + Month.SEPTEMBER.getNumDays() + " days");

        Scanner kybd = new Scanner(System.in);
        System.out.print("What month? > ");
        String month = kybd.nextLine();
        
        Month thisMonth = Month.valueOf(month.toUpperCase());
        
        System.out.println("\n" + thisMonth.toString() + " has " + thisMonth.getNumDays() + " days");
        
        if (thisMonth == Month.OCTOBER)
        {
            System.out.println("It is my favourite month.");
        }
    }
}
