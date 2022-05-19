package Week4.Task1.Task1A;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Gson gson = new Gson();


        Team team = null;
        {
            try {
                team = gson.fromJson(new FileReader("./OutJava/Task3/Task31_out.txt"), Team.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        team.addPlayer(new Player("Lamine"));
        PrintWriter out = null;
        try {
            out = new PrintWriter("./OutJava/Task3/Task32_out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String json = gson.toJson(team);
        System.out.println(json);
        byte[] data = json.getBytes();
        System.out.println(Arrays.toString(data));

        String fichier = "./OutJava/Task3/Task41_out.txt";

        try (FileOutputStream fos = new FileOutputStream(new File("./OutJava/Task3/Task41_out.txt"))) {
            fos.write(data);
            System.out.println("Successfully written data to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (
                InputStream inputStream = new FileInputStream(fichier)
        ) {
            int byteRead = -1;
            List<Byte> data2AL=new ArrayList<>();
            while ((byteRead = inputStream.read()) != -1) {
                data2AL.add((byte) byteRead);
                System.out.println(byteRead);
            }
            int size=data2AL.size();
            byte[] data2Char=new byte[size];  //convert ArrayList<Byte> to byte[]
            for (int i=0;i<size;i++) {
                data2Char[i]=data2AL.get(i);
            }

            String data2= new String(data2Char);
            System.out.println(data2);

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
