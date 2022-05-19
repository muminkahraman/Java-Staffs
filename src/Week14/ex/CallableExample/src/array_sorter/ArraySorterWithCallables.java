package array_sorter;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gdm1
 */
public class ArraySorterWithCallables extends ParallelArraySorter
{

    public ArraySorterWithCallables(int[] numbers)
    {
        super(numbers, "callables");
    }

    @Override
    protected ArrayList<ArraySortInformation> sortAllSmallerArrays(ArrayList<int[]> arrays)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //use callables to sort each of the smaller arrays
        ArrayList<ArraySortCallable> callables = new ArrayList<>(arrays.size());
        for (int[] array : arrays)
        {
            ArraySortCallable asc = new ArraySortCallable(array);
            callables.add(asc);
        }

        try
        {
            List<Future<ArraySortInformation>> info = executorService.invokeAll(callables);

            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.SECONDS);

            return info.
                    stream()
                    .map(f -> getArraySortInformation(f))
                    .collect(ArrayList<ArraySortInformation>::new, List::add, List::addAll);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private ArraySortInformation getArraySortInformation(Future<ArraySortInformation> future)
    {
        try
        {
            return future.get();
        }
        catch (InterruptedException | ExecutionException ex)
        {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
