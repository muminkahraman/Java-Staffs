package array_sorter;


import java.util.ArrayList;

/**
 *
 * @author gdm1
 */
public class ArrayMerger
{

    public int[] merge(ArrayList<ArraySortInformation> arrays, int totalLength)
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
