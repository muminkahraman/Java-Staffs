package Week10.Task4;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gdm1
 */
public class VowelTallyGateway
{

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javaprogramming_efrei";
    private static final String INCREMENT_VOWEL = "UPDATE voweltally SET tally = tally+ ? WHERE vowel = ?";
    private static final String SELECT_ALL_VOWELS = "SELECT * FROM voweltally";

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(
                new org.apache.derby.jdbc.ClientDriver());

        return DriverManager.getConnection(DATABASE_URL, "root", "mumin1999.");
    }

    /*
     * This method gets the data from all rows of the VowelTally table
     * in your database and returns them as a Map
     */
    public Map<Character, Long> getVowelTallies() throws SQLException {
        Connection conn = getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_VOWELS))
        {
            ResultSet rs = stmt.executeQuery();
            Map<Character, Long> tally = new HashMap<Character, Long>();
            while (rs.next())
            {
                System.out.println(rs.getString("vowel") + rs.getInt("tally"));
                tally.put((Character) rs.getString("vowel").charAt(0), Long.valueOf(rs.getInt("tally")));
            }
            return tally;
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Problem loading vowels", e);
        }
    }

    /*
     * This method uses the vowelCounts map to update the relevant rows
     * in the VowelTally table in your database
     */
    public void updateVowelTally(Map<Character, Long> vowelCounts) throws SQLException {
        Connection conn = getConnection();

        for (Map.Entry<Character, Long> entry : vowelCounts.entrySet()){
            try (PreparedStatement stmt = conn.prepareStatement(INCREMENT_VOWEL)){
                stmt.setInt(1, entry.getValue().intValue());
                stmt.setString(2, String.valueOf(entry.getKey()));
                stmt.executeUpdate();
            }
        }

    }
}
