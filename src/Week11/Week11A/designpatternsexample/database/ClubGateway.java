package Week11.Week11A.designpatternsexample.database;

import Week11.Week11A.designpatternsexample.Club;
import Week11.Week11A.designpatternsexample.Player;
import Week11.Week11A.designpatternsexample.builder.ClubBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author gdm1
 */
public class ClubGateway extends DatabaseManager
{

    private static final String DELETE = "DELETE FROM Club WHERE clubName = ?";
    private static final String FIND_ALL = "SELECT * FROM Club";
    private static final String FIND_BY_NAME = "SELECT * FROM Club WHERE clubName = ?";
    private static final String FIND_CLUB_PLAYERS = "SELECT * FROM Player WHERE club_Id = ?";
    private static final String INSERT = "INSERT INTO Club(clubName) VALUES (?)";
    private static final String UPDATE = "UPDATE Club SET clubName = ? WHERE clubName = ?";

    private static final ClubGateway INSTANCE = new ClubGateway();

    public static ClubGateway getInstance()
    {
        return INSTANCE;
    }

    private ClubGateway()
    {
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

    public Club findClubByName(String clubName)
    {
        ClubBuilder builder = new ClubBuilder();

        try (Connection conn = getConnection();
                PreparedStatement clubStmt = conn.prepareStatement(FIND_BY_NAME);
                PreparedStatement playerStmt = conn.prepareStatement(FIND_CLUB_PLAYERS))
        {
            clubStmt.setString(1, clubName);
            ResultSet club_rs = clubStmt.executeQuery();
            if (club_rs.next())
            {
                int clubId = club_rs.getInt("club_id");

                builder.withClubId(clubId)
                        .withClubName(club_rs.getString("clubName"));

                playerStmt.setInt(1, clubId);
                ResultSet player_rs = playerStmt.executeQuery();
                while (player_rs.next())
                {
                    Player p = new Player(player_rs.getInt("Player_Id"), player_rs.getString("PlayerName"));
                    builder.withPlayer(p);
                }

                return builder.build();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
        return null;
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
