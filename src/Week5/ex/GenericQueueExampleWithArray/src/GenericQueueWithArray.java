
import java.lang.reflect.Array;

/**
 *
 * @author gdm1
 */
public class GenericQueueWithArray<T>
{

    private final T[] queue;
    private int numberOfItems;

    public GenericQueueWithArray(Class<T> typeOfData)
    {
        queue = (T[]) Array.newInstance(typeOfData, 10);
        numberOfItems = 0;
    }

    public void enqueue(T item) throws Exception
    {
        try
        {
            queue[numberOfItems++] = item;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new Exception(
                    String.format(
                            "The queue is full, %s was not added",
                            item.toString()));
        }
    }

    public T dequeue() throws Exception
    {
        if (numberOfItems == 0)
        {
            throw new Exception("The queue is empty, there is nothing to dequeue");
        }

        T item = queue[0];
        for (int i = 0; i < queue.length - 1; i++)
        {
            queue[i] = queue[i + 1];
        }
        numberOfItems--;
        return item;
    }

    public boolean isEmpty()
    {
        return numberOfItems == 0;
    }
}
