/**
 *
 * @author gdm1
 */
public class InnerclassApplication
{

    public static void main(String[] args)
    {
        Face face = new Face("blue", "brown");
        
        System.out.println("\n" + face);
        
        face.smile();
        System.out.println("\n" + face);
        
        face.frown();
        System.out.println("\n" + face);
        
        face.fallAsleep();
        System.out.println("\n" + face);
        
        face.smile();
        System.out.println("\n" + face);
        
        face.wakeUp();
        System.out.println("\n" + face);
        
        face.serious();
        System.out.println("\n" + face);
    }
    
}
