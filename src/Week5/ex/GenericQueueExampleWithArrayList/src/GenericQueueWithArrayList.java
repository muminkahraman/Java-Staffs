
import java.util.ArrayList;

/**
 *
 * @author gdm1
 */
public class GenericQueueWithArrayList<T>
{

    private ArrayList<T> queue;

    public GenericQueueWithArrayList()
    {
        queue = new ArrayList<>(10);
    }

    public void enqueue(T item) throws Exception
    {
        queue.add(item);
    }

    public T dequeue() throws Exception
    {
        if (queue.isEmpty())
        {
            throw new Exception("The queue is empty, there is nothing to dequeue");
        }

        return queue.remove(0);
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
}
