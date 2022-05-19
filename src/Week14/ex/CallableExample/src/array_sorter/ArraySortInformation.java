package array_sorter;


public class ArraySortInformation
{
    private final int[] sortedArray;
    private final long timeToSort;
    private final String identifier;
    private int index = -1;
    private boolean finished = false;

    public ArraySortInformation(int[] sortedArray, String identifier, long timeToSort)
    {
        this.sortedArray = sortedArray;
        this.identifier = identifier;
        this.timeToSort = timeToSort;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public int[] getSortedArray()
    {
        return sortedArray;
    }

    public long getTimeToSort()
    {
        return timeToSort;
    }

    public boolean hasNext()
    {
        return !finished && index < sortedArray.length;
    }
    
    public boolean isFinished()
    {
        return finished;
    }
    
    public int peek() throws IllegalThreadStateException
    {
        if (hasNext())
        {
            return sortedArray[index+1];
        }
        throw new IllegalThreadStateException("Cannot get next item");
    }

    public int next() throws IllegalThreadStateException
    {
        if (hasNext())
        {
            int n = sortedArray[++index];
            if (index == sortedArray.length - 1)
            {
                finished = true;
            }
            return n;
        }
        throw new IllegalThreadStateException("Cannot get next item: index=" + index + "  finished=" + finished);
    }
}
