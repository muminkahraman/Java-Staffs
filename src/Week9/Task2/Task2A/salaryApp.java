package Week9.Task2.Task2A;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Stream;

public class salaryApp {
    private static Scanner scanner;

    public static void main(String[] args) {
        ;
        Stream<String> employeeStream = null;
        try {
            employeeStream = Files.lines(Path.of("resources/employee.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert employeeStream != null;
        OptionalDouble avg= employeeStream.map(e -> e.split(" "))
                .map(Arrays::asList)
                .map(e -> new Employee(e.get(0), e.get(1), Integer.parseInt(e.get(2))))
                .sorted(Comparator.comparing(Employee::getName).thenComparingInt(Employee::getSalarie))
                .peek(System.out::println)
                .map(Employee::getSalarie)
                .mapToInt(Integer::valueOf)
                .average();

        avg.ifPresent(System.out::println);
    }

}


//employeeStream.forEach(e-> System.out.println(Arrays.toString(e.split(" "))));
        /*double somm=0;


        Object[] listSalarie= employeeStream
                .map(e -> e.split(" "))
                .map(Arrays::asList)
                .map(e -> new Employee(e.get(0), e.get(1), Integer.parseInt(e.get(2))))
                .sorted(Comparator.comparing(Employee::getName).thenComparingInt(Employee::getSalarie))
                .map(employee -> {
                    System.out.println(employee);
                    return employee.getSalarie();
                }).toArray();

        for (Object salarie:listSalarie) {
            somm+=(int)salarie;
        }
        System.out.println("avg : "+somm/listSalarie.length);

        */