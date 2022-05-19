
import java.util.Iterator;

/**
 *
 * @author gdm1
 */
public class LocalClassApplication
{

    public static void main(String[] args)
    {
        Crowd crowd = new Crowd();
        
        Face f1 = new Face("Green", "Green");
        f1.frown();
        Face f2 = new Face("Blue", "Blue");
        f2.smile();
        Face f3 = new Face("Blue", "Brown");
        f3.fallAsleep();
        
        crowd.addFace(f1);
        crowd.addFace(f2);
        crowd.addFace(f3);
        
        Iterator iterator = crowd.crowdIterator();
        
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
    
}
