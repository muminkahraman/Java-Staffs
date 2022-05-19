import java.util.ArrayList;

public class University
{
    private String name;
    private ArrayList<Faculty> faculties;

    public University(String name)
    {
        this.name = name;
        faculties = new ArrayList<Faculty>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public boolean addFaculty(String name)
    {
        boolean facultyAdded = false;
        
        if (getFaculty(name) == null)
        {
            facultyAdded = faculties.add(new Faculty(name, this));
        }
        
        return facultyAdded;
    }
    
    public void removeFaculty(String name)
    {
        Faculty fac = getFaculty(name);
        
        if (fac != null)
        {
            faculties.remove(fac);
        }
    }
    
    public Faculty getFaculty(String name)
    {
        Faculty fac = null;
        
        for (int i=0; fac == null && i<faculties.size(); i++)
        {
            Faculty f = faculties.get(i);
            if (f.getName().equalsIgnoreCase(name))
            {
                fac = f;
            }
        }
        
        return fac;
    }
    
    public ArrayList<Faculty> getFaculties()
    {
        return faculties;
    }
}
