package com.gdm1.databaseexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseExample
{

    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        String url = "jdbc:derby://localhost:1527/sample";
        Connection con;

        try
        {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            con = DriverManager.getConnection(url, "app", "app");

            queryClub(con);
            
            System.out.println("\nInserting row...");
            insertClub(con);
            queryClub(con);
            
            System.out.println("\nUpdating row...");
            updateClub(con);
            queryClub(con);
            
            System.out.println("\nDeleting row...");
            deleteClub(con);
            queryClub(con);
            
            System.out.println("What is the new club name? > ");
            String clubName = kybd.nextLine();
            
            System.out.println("\nInserting your new club...");
            insertClub(con, clubName);
            queryClub(con);
            
            System.out.println("Update the club name to... > ");
            String clubName2 = kybd.nextLine();
            
            System.out.println("\nUpdating your new club...");
            updateClub(con, clubName, clubName2);
            queryClub(con);
            
            System.out.println("\nDeleting your new club...");
            deleteClub(con, clubName2);
            queryClub(con);

            con.close();
        }
        catch (SQLException e)
        {
            printException(e);
        }
    }

    private static void deleteClub(Connection con)
    {
        String sqlStr = "DELETE FROM Club WHERE clubName = 'Staffs Rovers'";
        int rowCount;

        try (PreparedStatement stmt = con.prepareStatement(sqlStr);)
        {
            rowCount = stmt.executeUpdate();
            System.out.println("Rows deleted: " + rowCount);
        }
        catch (Exception e)
        {
            printException(e);
        }
    }

    private static void deleteClub(Connection con, String clubName)
    {
        String sqlStr = "DELETE FROM Club WHERE clubName = ?";
        int rowCount;

        try (PreparedStatement stmt = con.prepareStatement(sqlStr))
        {
            stmt.setString(1, clubName);
            rowCount = stmt.executeUpdate();
            System.out.println("Rows deleted: " + rowCount);
        }
        catch (Exception e)
        {
            printException(e);
        }
    }

    private static void insertClub(Connection con)
    {
        String sqlStr = "INSERT INTO Club(clubName) VALUES ('Staffs United')";
        int rowCount;

        try (PreparedStatement stmt = con.prepareStatement(sqlStr))
        {
            rowCount = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowCount);
        }
        catch (Exception e)
        {
            printException(e);
        }

    }

    private static void insertClub(Connection con, String clubName)
    {
        String sqlStr = "INSERT INTO Club(clubName) VALUES (?)";
        int rowCount;

        try (PreparedStatement stmt = con.prepareStatement(sqlStr))
        {
            stmt.setString(1, clubName);
            rowCount = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowCount);
        }
        catch (Exception e)
        {
            printException(e);
        }

    }

    private static void queryClub(Connection con)
    {
        ResultSet rs;
        String sqlStr = "SELECT * FROM Club";

        try (PreparedStatement stmt = con.prepareStatement(sqlStr))
        {
            rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.printf("%4d\t%s\n",
                        rs.getInt("club_id"),
                        rs.getString("clubName"));
            }
            rs.close();
        }
        catch (Exception e)
        {
            printException(e);
        }
    }

    private static void updateClub(Connection con)
    {
        String sqlStr = "UPDATE Club SET clubName = 'Staffs Rovers' WHERE clubName = 'Staffs United'";
        int rowCount;

        try (PreparedStatement stmt = con.prepareStatement(sqlStr))
        {
            rowCount = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowCount);
        }
        catch (Exception e)
        {
            printException(e);
        }
    }

    private static void updateClub(Connection con, String oldClubName, String newClubName)
    {
        String sqlStr = "UPDATE Club SET clubName = ? WHERE clubName = ?";
        int rowCount;

        try (PreparedStatement stmt = con.prepareStatement(sqlStr))
        {
            stmt.setString(1, newClubName);
            stmt.setString(2, oldClubName);
            rowCount = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowCount);
        }
        catch (Exception e)
        {
            printException(e);
        }
    }
    
    private static void printException(Exception e)
    {
        e.printStackTrace(System.out);
    }
}
