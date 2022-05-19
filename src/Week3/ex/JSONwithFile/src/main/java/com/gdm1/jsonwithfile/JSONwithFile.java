package com.gdm1.jsonwithfile;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class JSONwithFile
{

    public static void main(String[] args)
    {
        Person p = new Person("Graham", "Mansfield");
        Calendar dob = Calendar.getInstance();
        dob.set(Calendar.DATE, 23);
        dob.set(Calendar.MONTH, 0);
        dob.set(Calendar.YEAR, 1970);
        p.setDob(dob);

        System.out.println("\np.toString():\n\t" + p);

        String jsonStr = new Gson().toJson(p);
        writeJsonToFile(jsonStr);

        jsonStr = readJsonFromFile();
        Person p1 = new Gson().fromJson(jsonStr, Person.class);
        System.out.println("\np1.toString():\n\t" + p1);
    }

    private static String readJsonFromFile()
    {
        String str = "";
        try
        {
            Scanner jsonFile = new Scanner(new File("data.txt"));
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
            PrintWriter jsonFile = new PrintWriter("data.txt");
            jsonFile.print(jsonStr);
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
    }
}
