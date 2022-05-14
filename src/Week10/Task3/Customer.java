package Week10.Task3;

import java.io.Serializable;

public class Customer implements Serializable
{

    private final int idcustomer;
    private final String name;
    private final String lastname;

    public Customer(int idcustomer, String name, String lastname) throws EmptyStringException
    {
        String errorMsg = "";
        if (idcustomer == 0)
        {
            errorMsg += "idcustomer must have a value. ";
        }
        if (name == null || name.isEmpty())
        {
            errorMsg += "name must have a value. ";
        }
        if (lastname == null || lastname.isEmpty())
        {
            errorMsg += "lastname must have a value. ";
        }
        if (!errorMsg.isEmpty())
        {
            throw new EmptyStringException(errorMsg);
        }

        this.idcustomer = idcustomer;
        this.name = name;
        this.lastname = lastname;
    }

    public int getIdcustomer()
    {
        return idcustomer;
    }

    public String getName()
    {
        return name;
    }

    public String getLastname()
    {
        return lastname;
    }

    @Override
    public String toString() {
        return  "idcustomer=" + idcustomer +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'';
    }
}