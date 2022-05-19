package Week3.Task1.Task1L;

import com.google.gson.Gson ;
import java.io.File ;
import java.io.IOException;
import java.io.PrintWriter ;
import java.util.Scanner ;


public class TeamApplication {

    public static void main(String[] args) {

        Player P0 = new Player("Lamine");
        Player P1 =new Player("Moussa");
        Player P2 = new Player("Essaid");
        Player P3 = new Player("Mumin");
        Player P4 = new Player("Antoine");

        Team Staffs = new Team("StaffFoot",5);

        Staffs.addPlayer(P0);
        Staffs.addPlayer(P1);
        Staffs.addPlayer(P2);
        Staffs.addPlayer(P3);
        Staffs.addPlayer(P4);

        String Squad = new Gson().toJson(Staffs);
        writeJsonToFile(Squad);
        System.out.println("\nThere is the Squadlist:\n\t" + Squad);




    }


    private static void writeJsonToFile(String jsonStr)
    {
        try
        {
            PrintWriter jsonFile = new PrintWriter("Squadlist");
            jsonFile.print(jsonStr);
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
    }
}
