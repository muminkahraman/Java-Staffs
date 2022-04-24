package Week3.Task2;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        String jsonStr = readJsonFromFile();
        Team T1 = new Gson().fromJson(jsonStr, Team.class);
        System.out.println("data transferred from source file to output file");
        System.out.println("data : " + T1.toString());

        writeJsonToFile(jsonStr);
    }

    private static String readJsonFromFile()
    {
        String str = "";
        try
        {
            Scanner jsonFile = new Scanner(new File("src/Week3/Task2/source_file.json"));
            str = jsonFile.nextLine();
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
        return str;
    }

    private static void writeJsonToFile(String jsonStr)
    {
        try
        {
            PrintWriter jsonFile = new PrintWriter("src/Week3/Task2/output_file.json");
            jsonFile.print(jsonStr);
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
    }
}
