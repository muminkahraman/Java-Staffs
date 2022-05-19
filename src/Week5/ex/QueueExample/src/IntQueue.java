
/**
 *
 * @author gdm1
 */
public class IntQueue
{

    private final int[] queue;
    private int numberOfItems;

    public IntQueue()
    {
        queue = new int[10];
        numberOfItems = 0;
    }

    public void enqueue(int item) throws Exception
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
                            item));
        }
    }

    public int dequeue() throws Exception
    {
        if (numberOfItems == 0)
        {
            throw new Exception("The queue is empty, there is nothing to dequeue");
        }

        int item = queue[0];
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
