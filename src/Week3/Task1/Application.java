package Week3.Task1;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        ArrayList<Team> teams = new ArrayList<Team>(5);

        Team France = new Team("France", 11);
        France.addPlayer(new Player("Mumin"));
        France.addPlayer(new Player("Mbappe"));
        teams.add(France);

        Team England = new Team("England", 15);
        England.addPlayer(new Player("Kante"));
        teams.add(England);

        Gson gson = new Gson();

        try {
            PrintWriter file = new PrintWriter("src/Week3/Task1/file.json");
            System.out.println(gson.toJson(France));
            file.println(gson.toJson(France));
            file.close();
        } catch (IOException ioe) {
            System.out.println("ERROR: " + ioe.getMessage());
        }
    }
}
