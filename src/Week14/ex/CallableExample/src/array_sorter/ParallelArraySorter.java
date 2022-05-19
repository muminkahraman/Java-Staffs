package array_sorter;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author gdm1
 */
public abstract class ParallelArraySorter extends ArraySorter
{

    private long sortAndMergeDuration = -1;
    private String times = "";

    public ParallelArraySorter(int[] numbers, String sortType)
    {
        super(numbers, sortType);
    }

    public int[] sort()
    {
        Calendar startTime = Calendar.getInstance();

        ArrayList<int[]> arrays
                = new ArrayBreaker()
                        .breakArrayIntoSmallerArrays(numbers, 10);

        ArrayList<ArraySortInformation> info = sortAllSmallerArrays(arrays);

        Calendar endSortTime = Calendar.getInstance();

        // record sort times for output later
        times = info
                .stream()
                .map(t -> " " + t.getIdentifier() + ":" + t.getTimeToSort() + " ")
                .reduce("", String::concat);

        //merge the sorted smaller arrays into one large sorted array
        int[] b
                = new ArrayMerger()
                        .merge(info, numbers.length);

        Calendar endTime = Calendar.getInstance();

        this.sortDuration = endSortTime.getTimeInMillis() - startTime.getTimeInMillis();
        this.sortAndMergeDuration = endTime.getTimeInMillis() - startTime.getTimeInMillis();

        return b;
    }

    protected abstract ArrayList<ArraySortInformation> sortAllSmallerArrays(ArrayList<int[]> arrays);

    @Override
    public String toString()
    {

        return super.toString() 
                + "(" + times + ")" 
                + "\nSort & merge took " + sortAndMergeDuration + " milliseconds";
    }
    
}
