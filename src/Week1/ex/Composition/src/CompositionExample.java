import java.util.ArrayList;
import java.util.Arrays;

public class CompositionExample
{
    public static void main(String args[])
    {
        ArrayList<University> uni = new ArrayList<University>(2);
        uni.add(new University("Staffordshire University"));
        uni.add(new University("Haughton University College"));
        
        uni.get(0).addFaculty("Computing, Engineering and Technology");
        uni.get(0).addFaculty("Arts, Media and Design");
        uni.get(0).addFaculty("Health");
        
        uni.get(1).addFaculty("Manual Labour");
        uni.get(1).addFaculty("Pen Pushing");
        uni.get(1).addFaculty("Blue-sky Thinking");
        
        for (University u : uni)
        {
            printUniversityDetails(u);
        }
        
        printAllFaculties(uni);
        
        uni.remove(1);
        
        printAllFaculties(uni);
    }
    
    private static void printUniversityDetails(University university)
    {
        System.out.println("\n" + university.getName());
        System.out.println("\tFaculties");
        System.out.println("\t=========");
        for (Faculty f : university.getFaculties())
        {
            System.out.println("\t\t" + f.getName());
        }
    }
    
    private static void printAllFaculties(ArrayList<University> university)
    {
        ArrayList<Faculty> allFaculties = new ArrayList<Faculty>();
        
        for (University u : university)
        {
            allFaculties.addAll(u.getFaculties());
        }
        
        sortFaculties(allFaculties);
        
        System.out.println("\nAll faculties");
        System.out.println("=============");
        for (Faculty f : allFaculties)
        {
            System.out.printf("\t%-40s  (%s)\n", f.getName(), f.getUniversity().getName());
        }
    }
    
    private static void sortFaculties(ArrayList<Faculty> faculties)
    {
        Faculty[] facs = faculties.toArray(new Faculty[0]);
        
        for (int i=0; i<facs.length-1; i++)
        {
            int indexOfSmallest=i;
            for (int index=indexOfSmallest+1; index<faculties.size(); index++)
            {
                if (facs[index].getName().compareToIgnoreCase(facs[indexOfSmallest].getName()) < 0)
                {
                    indexOfSmallest = index;
                }
            }
            if (indexOfSmallest != i)
            {
                Faculty f = facs[indexOfSmallest];
                facs[indexOfSmallest] = facs[i];
                facs[i] = f;
            }
        }
        
        faculties.clear();
        faculties.addAll(Arrays.asList(facs));
    }
}
