package Week3.Task2.Task2L;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.*;


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

        Player P6 = new Player("Rex");
        Player P5 = new Player("Mex");

        Team Staff2 = new Team("Staffoot2",2);

        Staff2.addPlayer(P6);
        Staff2.addPlayer(P5);


        String Squad = new Gson().toJson(Staff2);

        writeJsonToFile(Squad);
        System.out.println("\nThere is the Squadlist:\n\t" + Squad);

        Squad = readJsonFromFile();
        Staffs = new Gson().fromJson(Squad, Team.class);
        System.out.println("\nStaffs.toString():\n\t" + Staffs.getName() );


    }


    private static void writeJsonToFile(String jsonStr)
    {
        try
        {
            PrintWriter jsonFile = new PrintWriter("Task32/Squadlist2");
            jsonFile.print(jsonStr);
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
    }

    private static String readJsonFromFile()
    {
        String str = "";
        try
        {
            Scanner jsonFile = new Scanner(new File("Squadlist"));
            str = jsonFile.nextLine();
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
        return str;
    }


}
