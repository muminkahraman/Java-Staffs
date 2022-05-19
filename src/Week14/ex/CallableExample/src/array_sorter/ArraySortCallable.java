package array_sorter;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraySortCallable implements Callable<ArraySortInformation>
{
    private final static AtomicInteger nextCallableNumber = new AtomicInteger(1);
    private final int[] arrayToSort;
    private final String identifier;

    public ArraySortCallable(int[] arrayToSort)
    {
        this.arrayToSort = arrayToSort;
        this.identifier = "Callable " + nextCallableNumber.getAndIncrement();
    }

    @Override
    public ArraySortInformation call()
    {
        Calendar startTime = Calendar.getInstance();

        sortArray();

        Calendar endTime = Calendar.getInstance();
        long timeToSort = endTime.getTimeInMillis() - startTime.getTimeInMillis();
        
        return new ArraySortInformation(arrayToSort, identifier, timeToSort);
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
}
