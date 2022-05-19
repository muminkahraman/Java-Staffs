package com.gdm1.designpatternsexample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gdm1
 */
public abstract class DatabaseManager
{

    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/sample";

    protected Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(
                new org.apache.derby.jdbc.ClientDriver());

        return DriverManager.getConnection(DATABASE_URL, "app", "app");
    }

}
