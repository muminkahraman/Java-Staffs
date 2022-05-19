package Week8.Task1.Task1A;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class SportApp {
    private static  Scanner scanner;
    public static void main(String[] args) {
        scanner=new Scanner(System.in);
        int pupils=inputNb("Type the number of pupils : ");
        System.out.println("We have "+ pupils+" pupils");


        Stream<Pupils> stream=Stream.empty();
        for (int i=0;i<pupils;i++){
            String name;
            int age;
            System.out.print("Type the name of pupils "+i+": ");
            name= scanner.next();
            System.out.println(name);
            age=inputNb("How old is "+name+"? :");
            stream =Stream.concat(stream,Stream.of(new Pupils(age,name))); //is it the good way to do this ? or ( Arrays.stream or Stream.of)
        }
        stream.forEach(System.out::println);

    }
    public static int inputNb(String msg){
        try {
            System.out.print(msg);
            return scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid choice");
            scanner.next(); //why we need that?
        }
        return inputNb(msg);
    }

    private static class Pupils{
        private int age;
        private String name;

        public Pupils(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Pupils{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
