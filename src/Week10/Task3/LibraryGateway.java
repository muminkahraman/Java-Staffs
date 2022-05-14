package Week10.Task3;

import java.sql.*;
import java.util.ArrayList;

public class LibraryGateway
{

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javaprogramming_efrei";
    private static final String INSERT_CUSTOMER = "INSERT INTO customer(idcustomer, name, lastname) Values (?, ?, ?)";
    private static final String DELETE_ALL_CUSTOMERS = "DELETE FROM customer";
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

    public void saveCustomers(ArrayList<Customer> customers)
    {
        try (Connection conn = getConnection())
        {
            deleteAllCustomers(conn);
            customers.forEach(b -> saveCustomer(b, conn));
        }
        catch (SQLException e)
        {
            throw new RuntimeException("There was a problem with the database when saving books", e);
        }
    }

    private void deleteAllCustomers(Connection conn) throws SQLException
    {

        PreparedStatement stmt = conn.prepareStatement(DELETE_ALL_CUSTOMERS);
        stmt.executeUpdate();
        stmt.close();
    }

    private void saveCustomer(Customer b, Connection conn)
    {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_CUSTOMER))
        {
            stmt.setInt(1, b.getIdcustomer());
            stmt.setString(2, b.getName());
            stmt.setString(3, b.getLastname());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Customer not inserted", e);
        }
    }

}