package Week3.Task2.Task2A;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Application {
    public static void main(String[] args) {
        Gson gson = new Gson();


        Team team = null;
        {
            try {
                team = gson.fromJson(new FileReader("./OutJava/Task3/Task31_out.txt"), Team.class);
                System.out.println(team.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        team.addPlayer(new Player("Lamine"));
        PrintWriter out = null;
        try {
            out=new PrintWriter("./OutJava/Task3/Task32_out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.print(gson.toJson(team));
        out.close();
    }
}
