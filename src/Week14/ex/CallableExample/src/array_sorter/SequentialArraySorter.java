package array_sorter;


import java.util.Calendar;

/**
 *
 * @author gdm1
 */
public class SequentialArraySorter extends ArraySorter
{
    
    public SequentialArraySorter(int[] numbers)
    {
        super(numbers, "sequential");
    }
    
    @Override
    public int[] sort()
    {
        Calendar startTime = Calendar.getInstance();
        
        for (int pass = 0; pass < numbers.length - 1; pass++)
        {
            int smallest = findIndexOfSmallest(numbers, pass, numbers.length);
            if (smallest != pass)
            {
                int temp = numbers[pass];
                numbers[pass] = numbers[smallest];
                numbers[smallest] = temp;
            }

        }
        Calendar endTime = Calendar.getInstance();
        this.sortDuration = endTime.getTimeInMillis() - startTime.getTimeInMillis();
        
        return numbers;
    }
    
    private int findIndexOfSmallest(int[] a, int startIndex, int endIndex)
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
}
