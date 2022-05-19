
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.IntStream;

/**
 *
 * @author gdm1
 */
public class ThreadingExample
{

    public static void main(String[] args)
    {
        System.out.println("This example demonstrates the benefits of multi-threading.");
        System.out.println(
                "Two identical copies of an array of 100,000 random integers "
                + "are sorted, one without threading, the other with threading.");
        System.out.println("The time taken for each sort operation is reported.");
        
        int[] numbers1 = setUpArray();
        int[] numbers2 = duplicateArray(numbers1);

        sortArrayWithoutThreading(numbers1);

        numbers2 = sortArrayWithThreading(numbers2);

        System.out.printf("\n\nSorted arrays %s equal\n", Arrays.equals(numbers1, numbers2) ? "are" : "are not");
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

    private static void sortArrayWithoutThreading(int[] a)
    {
        Calendar startTime = Calendar.getInstance();
        
        for (int pass = 0; pass < a.length - 1; pass++)
        {
            int smallest = findIndexOfSmallest(a, pass, a.length);
            if (smallest != pass)
            {
                int temp = a[pass];
                a[pass] = a[smallest];
                a[smallest] = temp;
            }

        }
        Calendar endTime = Calendar.getInstance();
        System.out.println("\nUnthreaded sort took " + (endTime.getTimeInMillis() - startTime.getTimeInMillis()) + " milliseconds\n");
    }

    private static int findIndexOfSmallest(int[] a, int startIndex, int endIndex)
    {
        int index = startIndex;

        for (int i = index + 1; i < endIndex; i++)
        {
            if (a[i] < a[index])
            {
                index = i;
            }
        }

        return index;
    }

    private static int[] sortArrayWithThreading(int[] a)
    {
        Calendar startTime = Calendar.getInstance();

        ArrayList<int[]> arrays = breakArrayIntoSmallerArrays(a, 10);

        ArrayList<ArraySortThread> threads = sortAllSmallerArrays(arrays);

        Calendar endSortTime = Calendar.getInstance();

        // record sort times for output later
        String times
                = threads
                        .stream()
                        .map(t -> " " + t.getIdentifier() + ":" + t.getTimeToSort() + " ")
                        .reduce("", String::concat);

        //merge the sorted smaller arrays into one large sorted array
        int[] b = mergeSmallerArraysIntoOneLargeArray(threads, a.length);

        Calendar endTime = Calendar.getInstance();

        System.out.print("Threaded sort took " + (endSortTime.getTimeInMillis() - startTime.getTimeInMillis()) + " milliseconds "
                + "(" + times + ")"
                + "\nSort & merge took " + (endTime.getTimeInMillis() - startTime.getTimeInMillis()) + " milliseconds");

        return b;
    }

    private static ArrayList<int[]> breakArrayIntoSmallerArrays(int[] a, int numberOfArrays)
    {
        int interval = a.length / numberOfArrays;
        int startIndex = 0;
        ArrayList<int[]> arrays = new ArrayList<>(numberOfArrays);

        //divide the array into smaller arrays
        for (int i = 0; i < numberOfArrays - 1; i++)
        {
            int[] arr = new int[interval];
            System.arraycopy(a, startIndex, arr, 0, arr.length);
            arrays.add(arr);
            startIndex += interval;
        }
        int[] arr = new int[a.length - startIndex];
        System.arraycopy(a, startIndex, arr, 0, arr.length);
        arrays.add(arr);

        //check array lengths total length of original array
        int combinedLength 
                = arrays
                        .stream()
                        .map(b -> b.length)
                        .reduce(0, Integer::sum);
        
        if (combinedLength != a.length)
        {
            throw new RuntimeException("Combined length of split arrays does not match the length of the original array");
        }

        return arrays;
    }

    private static ArrayList<ArraySortThread> sortAllSmallerArrays(ArrayList<int[]> arrays)
    {
        //use threads to sort each of the smaller arrays
        ArrayList<ArraySortThread> threads = new ArrayList<>(arrays.size());
        for (int i = 0; i < arrays.size(); i++)
        {
            ArraySortThread ast = new ArraySortThread(arrays.get(i), (i + 1));
            threads.add(ast);
            ast.start();
        }

        //wait for all sorting to finish
        while (stillSorting(threads))
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException ie)
            {
            }
        }

        return threads;
    }

    private static boolean stillSorting(ArrayList<ArraySortThread> threads)
    {
        boolean stillSorting = false;

        for (ArraySortThread t : threads)
        {
            stillSorting = stillSorting || t.isAlive();
        }

        return stillSorting;
    }

    private static int[] mergeSmallerArraysIntoOneLargeArray(ArrayList<ArraySortThread> arrays, int totalLength)
    {
        int[] a = new int[totalLength];

        for (int i = 0; i < a.length; i++)
        {
            //find smallest value across all sorted arrays
            int indexOfArrayWithSmallestValue = 0;
            for (int j = 1; j < arrays.size(); j++)
            {
                if (arrays.get(j).hasNext())
                {
                    if (arrays.get(j).peek() < arrays.get(indexOfArrayWithSmallestValue).peek())
                    {
                        indexOfArrayWithSmallestValue = j;
                    }
                }
            }
            a[i] = arrays.get(indexOfArrayWithSmallestValue).next();

            if (arrays.get(indexOfArrayWithSmallestValue).isFinished())
            {
                arrays.remove(indexOfArrayWithSmallestValue);
            }
        }

        return a;
    }
}
