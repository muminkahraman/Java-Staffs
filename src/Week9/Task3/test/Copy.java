package Week9.Task3.test;


import java.io.Serializable;

/**
 *
 * @author gdm1
 */
public class Copy implements Serializable
{

    private static int nextId = 1;

    protected static final String AVAILABLE = "Available";
    protected static final String ON_LOAN = "On loan";

    private final int id;
    private String state;

    public Copy()
    {
        this(nextId, AVAILABLE);
    }

    public Copy(int id, String state)
    {
        this.id = id;
        if (id >= nextId)
        {
            nextId = id + 1;
        }
        this.state = state;
    }

    public int getId()
    {
        return id;
    }

    public String getState()
    {
        return state;
    }

    public void borrowCopy()
    {
        if (this.state.equals(ON_LOAN))
        {
            throw new CopyAlreadyOnLoanException(this.id);
        }
        this.state = ON_LOAN;
    }

    public void returnCopy()
    {
        if (this.state.equals(AVAILABLE))
        {
            throw new CopyNotOnLoanException(this.id);
        }
        this.state = AVAILABLE;
    }

    @Override
    public String toString()
    {
        return super.toString() + " (" + "id=" + id + ", state=" + state + ')';
    }

}