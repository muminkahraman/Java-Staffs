package array_sorter;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gdm1
 */
public class ArraySorterWithThreads extends ParallelArraySorter
{

    public ArraySorterWithThreads(int[] numbers)
    {
        super(numbers, "threads");
    }

    @Override
    protected ArrayList<ArraySortInformation> sortAllSmallerArrays(ArrayList<int[]> arrays)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //use threads to sort each of the smaller arrays
        ArrayList<ArraySortThread> threads = new ArrayList<>(arrays.size());
        for (int[] array : arrays)
        {
            ArraySortThread ast = new ArraySortThread(array);
            threads.add(ast);
        }

        try
        {
            threads.forEach(t -> executorService.execute(t));

            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.SECONDS);

            return threads
                    .stream()
                    .map(a -> a.getArraySortInformation())
                    .collect(ArrayList<ArraySortInformation>::new, ArrayList::add, ArrayList::addAll);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
