package Week9.Task4;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number, this program will caltulate his factorial.");
        int number = scanner.nextInt();

        IntStream numbers = IntStream.range(1, number+1);

        int fact = numbers
                .reduce(1, (a, b) -> a*b);

        System.out.printf("\nThe factorial for %d is %d.", number, fact);
    }

}
