package com.gdm1.designpatternsexample.database;

import com.gdm1.designpatternsexample.Club;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author gdm1
 */
public class ClubGateway
{

    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/sample";

    private static final String DELETE = "DELETE FROM Club WHERE clubName = ?";
    private static final String FIND_ALL = "SELECT * FROM Club";
    private static final String INSERT = "INSERT INTO Club(clubName) VALUES (?)";
    private static final String UPDATE = "UPDATE Club SET clubName = ? WHERE clubName = ?";

    protected Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(
                new org.apache.derby.jdbc.ClientDriver());

        return DriverManager.getConnection(DATABASE_URL, "app", "app");
    }

    public int delete(String clubName)
    {
        int rowCount = 0;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(DELETE))
        {
            stmt.setString(1, clubName);
            rowCount = stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace(System.out);
        }

        return rowCount;
    }

    public Collection<Club> findAll()
    {
        ArrayList<Club> clubs = new ArrayList<>();
        
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(FIND_ALL);
                ResultSet rs = stmt.executeQuery())
        {
            while (rs.next())
            {
                Club c
                        = new Club(
                                rs.getInt("club_id"),
                                rs.getString("clubName"));
                clubs.add(c);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
        
        return clubs;
    }

    public int insert(String clubName)
    {
        int rowCount = 0;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(INSERT))
        {
            stmt.setString(1, clubName);
            rowCount = stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace(System.out);
        }

        return rowCount;
    }

    public int update(String oldClubName, String newClubName)
    {
        int rowCount = 0;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(UPDATE))
        {
            stmt.setString(1, newClubName);
            stmt.setString(2, oldClubName);
            rowCount = stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace(System.out);
        }

        return rowCount;
    }
}
