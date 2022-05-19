
/**
 *
 * @author gdm1
 */
public class StringQueue
{

    private final String[] queue;
    private int numberOfItems;

    public StringQueue()
    {
        queue = new String[10];
        numberOfItems = 0;
    }

    public void enqueue(String item) throws Exception
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

    public String dequeue() throws Exception
    {
        if (numberOfItems == 0)
        {
            throw new Exception("The queue is empty, there is nothing to dequeue");
        }

        String item = queue[0];
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
