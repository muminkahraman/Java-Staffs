package Week4.Task1;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        System.out.println("\nwe read a Team from a Json file");
        Team t = readTeamFromJsonFile("src/Week4/Task1/source_file.json");
        System.out.println(t);

        System.out.println("\nthen we write this team to a binary file");
        writeTeamToBinaryFile(t);

        System.out.println("\nthen we read this team from binary file");
        Team t2 = readTeamFromBinaryFile();
        System.out.println(t2);

        System.out.println("\nthen we write this team to another Json file");
        writeTeamToJsonFile(t2);

        System.out.println("\nthen we read the team from the second Json file");
        Team t3 = readTeamFromJsonFile("src/Week4/Task1/output_file.json");
        System.out.println(t3);

        System.out.println("\nwe can see that they are all same.");

        if (t.equals(t2) && t2.equals(t3)){
            System.out.println("\nthey are all similar (tested with equals)");
        } else {
            System.out.println("\nthe equals check failed");
        }

    }

    private static Team readTeamFromBinaryFile()
    {
        Team t = null;
        try
        {
            ObjectInputStream objInFile
                    = new ObjectInputStream(
                    new FileInputStream(
                            new File("src/Week4/Task1/middle_bin_file.bin")));
            t = (Team)objInFile.readObject();
            objInFile.close();
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
        return t;
    }

    private static Team readTeamFromJsonFile(String path)
    {
        String jsonStr = "";
        try
        {
            BufferedReader jsonFile
                    = new BufferedReader(
                    new FileReader(
                            new File(path)));
            jsonStr = jsonFile.readLine();
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
        return new Gson().fromJson(jsonStr, Team.class);
    }

    private static void writeTeamToBinaryFile(Team t)
    {
        try
        {
            ObjectOutputStream objOutFile
                    = new ObjectOutputStream(
                    new FileOutputStream(
                            new File("src/Week4/Task1/middle_bin_file.bin")));
            objOutFile.writeObject(t);
            objOutFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
    }

    private static void writeTeamToJsonFile(Team t)
    {
        String jsonStr = new Gson().toJson(t);
        try
        {
            PrintWriter jsonFile
                    = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("src/Week4/Task1/output_file.json")));
            jsonFile.print(jsonStr);
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
    }
}
