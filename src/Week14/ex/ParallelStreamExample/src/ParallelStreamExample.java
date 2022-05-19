
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author gdm1
 */
public class ParallelStreamExample
{

    public static void main(String[] args)
    {
        Random r = new Random();

        System.out.println("\nSort an IntStream\n=================");
        int[] ints
                = r.ints(10000000, 1, 100)
                    .toArray();
        
        System.out.printf(
                "\tNumber of integers to sort: %,d\n", 
                ints.length);
        
        Calendar startTime1 = Calendar.getInstance();
        int[] sortedInts1
                = Arrays.stream(ints)
                        .sorted()
                        .toArray();
        Calendar endTime1 = Calendar.getInstance();
        long timeToSort1 = endTime1.getTimeInMillis() - startTime1.getTimeInMillis();
        
        System.out.printf(
                "\n\tSequential sort: %d milliseconds\n", 
                timeToSort1);
        
        Calendar startTime2 = Calendar.getInstance();
        int[] sortedInts2
                = Arrays.stream(ints)
                        .parallel()
                        .sorted()
                        .toArray();
        Calendar endTime2 = Calendar.getInstance();
        long timeToSort2 = endTime2.getTimeInMillis() - startTime2.getTimeInMillis();
        
        System.out.printf(
                "\tParallel Sort:   %d milliseconds\n", 
                timeToSort2);
        
        System.out.printf(
                "\n\tSorted arrays equal?: %b\n\n", 
                Arrays.equals(sortedInts1, sortedInts2));
    }
}
