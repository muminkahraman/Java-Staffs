package Week3.Task1.Task1A;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Application {
    public static void main(String[] args) {
        Player mumin=new Player("Mumin");
        Player roger=new Player("Roger");
        Player fred =new Player("Fred");
        Player moussa=new Player("Moussa");
        Team france=new Team("France",4);
        Team afrique=new Team("Afrique",1);
        france.addPlayer(mumin);
        mumin.setTeam(france);
        france.addPlayer(roger);
        france.addPlayer(fred);
        afrique.addPlayer(moussa);

        Gson gson = new Gson();
        try {
            PrintWriter out=new PrintWriter("./OutJava/Task3/Task31_out.txt");
            System.out.println(gson.toJson(france));
            out.print(gson.toJson(france));
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
