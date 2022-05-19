package Week11.Week11A.designpatternsexample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gdm1
 */
public abstract class DatabaseManager
{

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Java?useSSL=false";

    protected Connection getConnection() throws SQLException
    {


        return DriverManager.getConnection(DATABASE_URL,"root","mumin1999.");
    }

}
