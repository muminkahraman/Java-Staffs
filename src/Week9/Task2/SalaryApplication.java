package Week9.Task2;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class SalaryApplication {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        String path = "src/Week9/Task2/source_file.json";

        System.out.println("\nEmployees Sorted:");
        Stream<Employee> employeeStream = employees.stream();

        readTeamFromJsonFile(path, employees);

        double average = employeeStream
                .sorted()
                .peek(element -> System.out.println(element))
                .mapToInt(element -> element.getSalary())
                .average()
                .getAsDouble();

        System.out.println("\nSalary average = " + String.format("%.2f", average));
    }


    private static void readTeamFromJsonFile(String path, ArrayList<Employee> employees)
    {
        String jsonStr = "";
        try
        {
            BufferedReader jsonFile
                    = new BufferedReader(
                    new FileReader(
                            new File(path)));
            String line;
            ArrayList<String> lines = new ArrayList<String>();
            while((line = jsonFile.readLine()) != null){
                lines.add(line);
            }
            jsonFile.close();

            for(String str : lines.subList(1, lines.size()-2)){
                employees.add(new Gson().fromJson(str.substring(0, str.length()-1), Employee.class));
            }
            employees.add(new Gson().fromJson(lines.get(lines.size()-2), Employee.class));

        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
        //return new Gson().fromJson(jsonStr, Employee.class);
    }

}
