
/**
 *
 * @author gdm1
 */
public class GenericQueueExample
{

    public static void main(String[] args)
    {
        GenericQueueWithArrayList<String> strQ = new GenericQueueWithArrayList<>();
        GenericQueueWithArrayList<Integer> intQ = new GenericQueueWithArrayList<>();

        for (int i = 0; i < 11; i++)
        {
            try
            {
                strQ.enqueue("Item " + (i + 1));
            }
            catch (Exception e)
            {
                System.out.println("ERROR (String queue): " + e.getMessage());
            }
            try
            {
                intQ.enqueue(i + 1);
            }
            catch (Exception e)
            {
                System.out.println("ERROR (Integer queue): " + e.getMessage());
            }
        }

        for (int i = 0; i < 12; i++)
        {
            try
            {
                System.out.println(strQ.dequeue() + " was dequeued");
            }
            catch (Exception e)
            {
                System.out.println("ERROR (String queue): " + e.getMessage());
            }
            try
            {
                System.out.println(intQ.dequeue() + " was dequeued");
            }
            catch (Exception e)
            {
                System.out.println("ERROR (Integer queue): " + e.getMessage());
            }
        }
    }

}
