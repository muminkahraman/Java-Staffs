
import array_sorter.ArraySorter;
import array_sorter.ArraySorterWithThreads;
import array_sorter.ArraySorterWithCallables;
import array_sorter.SequentialArraySorter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author gdm1
 */
public class CallableExample
{

    public static void main(String[] args)
    {
        System.out.println("This example adds use of the Callable interface and refactors the code from last week");

        int[] numbers1 = setUpArray();
        int[] numbers2 = duplicateArray(numbers1);
        int[] numbers3 = duplicateArray(numbers1);

        ArraySorter[] sorters = new ArraySorter[]
        {
            new SequentialArraySorter(numbers1),
            new ArraySorterWithThreads(numbers2),
            new ArraySorterWithCallables(numbers3)
        };

        int[][] sortedArrays
                = Arrays.stream(sorters)
                        .map(s -> s.sort())
                        .collect(ArrayList<int[]>::new, ArrayList::add, ArrayList::addAll)
                        .toArray(new int[][]
                        {
                });

        // print sort information for each sorter
        for (ArraySorter sorter : sorters)
        {
            System.out.println("\n" + sorter.toString());
        }

        // check all sorted arrays are equals
        boolean allArraysAreEqual
                = Arrays.stream(sortedArrays)
                        .map(a -> Arrays.equals(a, sortedArrays[0])) // every sorted array checked against the first sorted array
                        .reduce((b1, b2) -> b1 && b2)
                        .orElse(false);

        System.out.printf(
                "\n%s sorted arrays are equal\n",
                allArraysAreEqual ? "All" : "NOT all");

        boolean arraysAreStillEqual
                = Arrays.stream(sortedArrays)
                        .map(a -> Arrays.stream(a).mapToObj(i -> i + "").collect(Collectors.joining(", "))) //change the int[] to a string of values
                        .distinct()
                        .count() <= 1; // if 1, then all arrays are equal; if zero, there were no arrays; else some arrays were different
        System.out.printf(
                "\nAnother way for checking equality: %s sorted arrays are equal\n",
                arraysAreStillEqual ? "All" : "NOT all");
    }

    private static int[] setUpArray()
    {
        Calendar startTime = Calendar.getInstance();

        int[] a
                = IntStream
                        .rangeClosed(1, 100000)
                        .map((i) -> (int) (Math.random() * 10000) + 1)
                        .toArray();

        Calendar endTime = Calendar.getInstance();
        System.out.println("\nArray set-up took " + (endTime.getTimeInMillis() - startTime.getTimeInMillis()) + " milliseconds");

        return a;
    }

    private static int[] duplicateArray(int[] a)
    {
        Calendar startTime = Calendar.getInstance();

        int[] b = Arrays.stream(a).toArray();

        Calendar endTime = Calendar.getInstance();
        System.out.println("Array duplication took " + (endTime.getTimeInMillis() - startTime.getTimeInMillis()) + " milliseconds");
        return b;
    }
}
