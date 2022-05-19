package array_sorter;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraySortThread extends Thread
{
    private final static AtomicInteger nextThreadNumber = new AtomicInteger(1);
    private final int[] arrayToSort;
    private final String identifier;
    private ArraySortInformation arraySortInformation;

    public ArraySortThread(int[] arrayToSort)
    {
        this.arrayToSort = arrayToSort;
        this.identifier = "Thread " + nextThreadNumber.getAndIncrement();
    }

    @Override
    public void run()
    {
        Calendar startTime = Calendar.getInstance();

        sortArray();

        Calendar endTime = Calendar.getInstance();
        long timeToSort = endTime.getTimeInMillis() - startTime.getTimeInMillis();
        
        arraySortInformation = new ArraySortInformation(arrayToSort, identifier, timeToSort);
    }

    private void sortArray()
    {
        for (int pass = 0; pass < arrayToSort.length - 1; pass++)
        {
            int smallest = findIndexOfSmallest(pass, arrayToSort.length);
            if (smallest != pass)
            {
                int temp = arrayToSort[pass];
                arrayToSort[pass] = arrayToSort[smallest];
                arrayToSort[smallest] = temp;
            }

        }
    }

    private int findIndexOfSmallest(int startIndex, int endIndex)
    {
        int indexOfSmallest = startIndex;

        for (int i = indexOfSmallest + 1; i < endIndex; i++)
        {
            if (arrayToSort[i] < arrayToSort[indexOfSmallest])
            {
                indexOfSmallest = i;
            }
        }

        return indexOfSmallest;
    }

    public ArraySortInformation getArraySortInformation()
    {
        return arraySortInformation;
    }

    public String getIdentifier()
    {
        return identifier;
    }
}
