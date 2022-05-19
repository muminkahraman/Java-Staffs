package array_sorter;


import java.util.ArrayList;

/**
 *
 * @author gdm1
 */
public class ArrayBreaker
{

    public ArrayList<int[]> breakArrayIntoSmallerArrays(int[] a, int numberOfArrays)
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
}
