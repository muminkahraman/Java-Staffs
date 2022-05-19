package Week8.Task3.Task3A;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
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
        //employeeStream.forEach(e-> System.out.println(Arrays.toString(e.split(" "))));

        assert employeeStream != null;
        employeeStream
                .map(e -> e.split(" "))
                .map(Arrays::asList)
                .map(e -> new Employee(e.get(0), e.get(1), Integer.parseInt(e.get(2))))
                .sorted(Comparator.comparing(Employee::getName).thenComparingInt(Employee::getSalarie))
                .forEach(System.out::println);

    }

}
/*(employee1, employee2) -> {
                    int i = employee1.getName().compareTo(employee2.getName());
                    if (i == 0) {
                        i = employee1.getSalarie() - employee2.getSalarie();
                    }
                    return i;
                }

 */