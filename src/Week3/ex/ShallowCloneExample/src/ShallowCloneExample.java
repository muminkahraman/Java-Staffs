
/**
 *
 * @author gdm1
 */
public class ShallowCloneExample
{

    public static void main(String[] args)
    {
        Person graham = new Person("Graham", "Somewhere in England");
        Pet titch = new Pet("Titch");
        graham.setPet(titch);
        
        Person cloneOfGraham = null;
        
        System.out.println("\nBefore cloning");
        System.out.printf("\ttitch: %s (%s)\n", titch, titch.getName());
        System.out.printf("\tgraham: %s (%s, %s) with pet: %s (%s)\n", graham, graham.getName(), graham.getAddress(), graham.getPet(), graham.getPet().getName());
        System.out.printf("\tcloneOfGraham: %s\n", cloneOfGraham);

        try
        {
            cloneOfGraham = (Person) graham.clone();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println("\nERROR: There was a problem with the clone");
        }
        
        System.out.println("\nAfter cloning");
        System.out.printf("\ttitch: %s (%s)\n", titch, titch.getName());
        System.out.printf("\tgraham: %s (%s, %s) with pet: %s (%s)\n", graham, graham.getName(), graham.getAddress(), graham.getPet(), graham.getPet().getName());
        System.out.printf("\tcloneOfGraham: %s (%s, %s) with pet: %s (%s)\n", cloneOfGraham, cloneOfGraham.getName(), cloneOfGraham.getAddress(), cloneOfGraham.getPet(), cloneOfGraham.getPet().getName());
    }

}
