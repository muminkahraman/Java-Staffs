package Week9.Task4.Task4A;

import jdk.jshell.execution.StreamingExecutionControl;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactorialStream {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int nb =inputNb("Type a integer to factorise : ");
        int[] fracto=new int[nb];
        for (int i=0;i<nb;i++){
            fracto[i]=i+1;
        }

        //Arrays.stream(fracto).collect(()-);


        System.out.println(Arrays.toString(fracto));
    }
    public static int inputNb(String msg) {
        try {
            System.out.print(msg);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice");
            scanner.next(); //why we need that?
        }
        return inputNb(msg);
    }
}

