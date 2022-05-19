/**
 *
 * @author gdm1
 */
public class Pet implements Cloneable
{

    private String name;

    public Pet()
    {
        this("???");
    }

    public Pet(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return new Pet(name);
    }
}
