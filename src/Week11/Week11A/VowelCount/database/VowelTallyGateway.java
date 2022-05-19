package Week11.Week11A.VowelCount.database;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;


public class VowelTallyGateway {
    private static final VowelTallyGateway VOWEL_TALLY_GATEWAY=new VowelTallyGateway();
    private VowelTallyGateway(){}

    public static VowelTallyGateway getInstance(){
        return VOWEL_TALLY_GATEWAY;
    }
    /*
     * This method returns a connection to your database
    */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?"+"useSSL=false","root","mumin1999.");
    }
    
    /*
     * This method gets the data from all rows of the VowelTally table 
     * in your database and returns them as a Map
    */
    public Map<Character, Long> getVowelTallies() throws SQLException {
        ResultSet resultSet=getConnection().createStatement().executeQuery("SELECT * FROM VowelTally");
        TreeMap<Character, Long> characterLongTreeMap=new TreeMap<>();
        while (resultSet.next()){
            characterLongTreeMap.put(resultSet.getString(1).charAt(0), resultSet.getLong(2) );
        }
        return characterLongTreeMap;
    }
    
    /*
     * This method uses the vowelCounts map to update the relevant rows 
     * in the VowelTally table in your database
    */
    public void updateVowelTally(Map<Character, Long> vowelCounts) throws SQLException {

        String query = "update VowelTally set  ` Tally`= ` Tally`+? where Vowel=?";
        PreparedStatement preparedStmt=getConnection().prepareStatement(query);
        vowelCounts.forEach((key, value) -> {
            try {
                preparedStmt.setInt(1, Math.toIntExact(vowelCounts.get(key)));
                preparedStmt.setString(2, String.valueOf(key));
                preparedStmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        
    }


    /*
    getVowelTallies().entrySet().stream()
                .filter(e->!e.getValue().equals(vowelCounts.get(e.getKey())))
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue())); why Object Object
     */
}
