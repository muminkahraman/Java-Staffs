package Week6.Task3.Task3L;

import com.google.gson.Gson;

import java.io.*;


public class TeamApplication {

    public static void main(String[] args) throws Exception {

        try(Team Staffs = new Team("Staffs",5)) {

            Player P0 = new Player("Lamine");
            Player P1 = new Player("Moussa");
            Player P2 = new Player("Essaid");
            Player P3 = new Player("Mumin");
            Player P4 = new Player("Antoine");

            Staffs.addPlayer(P0);
            Staffs.addPlayer(P1);
            Staffs.addPlayer(P2);
            Staffs.addPlayer(P3);
            Staffs.addPlayer(P4);


            writeTeamToJsonFile(Staffs);
            TeamFromToBinaryFile(Staffs);

            String Squad = new Gson().toJson(Staffs);



        }

    }

    private static Team readSquadFromBinaryFile() {
        Team T = null;
        try {
            ObjectInputStream objInFile
                    = new ObjectInputStream(
                    new FileInputStream(
                            "data.bin"));
            T = (Team) objInFile.readObject();
            objInFile.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return T;

    }

        private static void TeamFromToBinaryFile(Team T)
        {
            try
            {
                ObjectOutputStream objOutFile
                        = new ObjectOutputStream(
                        new FileOutputStream(
                                "data.bin"));
                objOutFile.writeObject(T);
                objOutFile.close();
            }
            catch (IOException ioe)
            {
                System.out.println("ERROR: " + ioe.getMessage());
            }
        }

    private static Team readTeamFromJsonFile()
    {
        String str = "";
        try
        {
            BufferedReader jsonFile
                    = new BufferedReader(
                    new FileReader(
                          "data.txt"));
//            Scanner str = new Scanner(new File("Squadlist"));
//            str = jsonFile.nextLine();
             str = jsonFile.readLine();
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
        return new Gson().fromJson(str, Team.class);
    }

    private static void writeTeamToJsonFile(Team T)
    {
        String str = new Gson().toJson(T);
        try
        {
            PrintWriter jsonFile
                    = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("data.txt")));
            jsonFile.print(str);
            jsonFile.close();
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
    }

    }

