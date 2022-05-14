package Week10.Task1;

import java.sql.*;
import java.util.ArrayList;

public class LibraryGateway
{

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javaprogramming_efrei";
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customer";


    private Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(
                new org.apache.derby.jdbc.ClientDriver());

        return DriverManager.getConnection(DATABASE_URL, "root", "mumin1999.");
    }

    public ArrayList<Customer> loadCustomers()
    {
        try (Connection conn = getConnection())
        {
            ArrayList<Customer> books = selectAllCustomers(conn);

            return books;
        }
        catch (SQLException e)
        {
            throw new RuntimeException("There was a problem with the database when loading customers", e);
        }
    }

    private ArrayList<Customer> selectAllCustomers(Connection conn)
    {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_CUSTOMERS))
        {
            ArrayList<Customer> customers = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Customer b
                        = new Customer(
                        rs.getInt("idcustomer"),
                        rs.getString("name"),
                        rs.getString("lastname"));

                customers.add(b);
            }
            return customers;
        }
        catch (SQLException | EmptyStringException e)
        {
            throw new RuntimeException("Problem loading customers", e);
        }
    }
}