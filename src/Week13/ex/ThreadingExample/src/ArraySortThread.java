import java.util.Calendar;

public class ArraySortThread extends Thread
{
    private final int[] arrayToSort;
    private long timeToSort;
    private final String identifier;
    private int index = -1;
    private boolean finished = false;

    public ArraySortThread(int[] arrayToSort, int num)
    {
        this.arrayToSort = arrayToSort;
        this.timeToSort = -1;
        this.identifier = "Thread " + num;
    }

    @Override
    public void run()
    {
        Calendar startTime = Calendar.getInstance();

        sortArray();

        Calendar endTime = Calendar.getInstance();
        timeToSort = endTime.getTimeInMillis() - startTime.getTimeInMillis();
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

    public long getTimeToSort()
    {
        return timeToSort;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public boolean hasNext()
    {
        return !isAlive() && !finished && index < arrayToSort.length;
    }
    
    public boolean isFinished()
    {
        return finished;
    }
    
    public int peek() throws IllegalThreadStateException
    {
        if (hasNext())
        {
            return arrayToSort[index+1];
        }
        throw new IllegalThreadStateException("Cannot get next item");
    }

    public int next() throws IllegalThreadStateException
    {
        if (hasNext())
        {
            int n = arrayToSort[++index];
            if (index == arrayToSort.length - 1)
            {
                finished = true;
            }
            return n;
        }
        throw new IllegalThreadStateException("Cannot get next item: index=" + index + "  finished=" + finished);
    }
}
