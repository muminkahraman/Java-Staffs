package Week8.Task3.Task3L;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnterpriseApplication {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        filltheRegisterFile(employees);

        String filename ="/Users/diedhiou/IdeaProjects/Pra/EmployeeRegisterFile";
        File file = new File(filename);

        Stream<String> StreamOfEmployee = null ;

        try {
            StreamOfEmployee = Files.lines(file.toPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        assert StreamOfEmployee != null;
        StreamOfEmployee
                .map(e -> e.split(" "))
                .map(Arrays::asList)
                .map(e -> new Employee(e.get(3), e.get(6), Integer.parseInt(e.get(10))))
                .sorted()
                .forEach(i -> System.out.println(i));



        // registerEmployee(employees);

        //sortInSalaryOrder(employees);

        //the sort work with a perfect order

    }



    public static void filltheRegisterFile(ArrayList<Employee> employees)
    {
         employees = new ArrayList<>();

        // Creation of employee to have base and well see the test
        Employee P1 =new Employee("Lamine","dep2",2000);
        Employee P2 =new Employee("Lamine","dep2",1400);
        Employee P3 =new Employee("Mex","dep2",2000);
        Employee P4 =new Employee("Tex","dep2",2500);
        Employee P5 =new Employee("Rex","dep2",1700);
        Employee P6 =new Employee("Lamine","dep2",2100);
        Employee P7 =new Employee("Dex","dep2",1400);
        Employee P8 =new Employee("Rania","dep2",1000);
        Employee P9 =new Employee("Elon","dep2",2500);
        Employee P10 =new Employee("Syrius","dep2",1700);
        Employee P11 =new Employee("Kuro","dep2",1000);
        Employee P12 =new Employee("Frame","dep2",1400);
        Employee P13 =new Employee("Lucifer","dep2",1600);
        Employee P14 =new Employee("Chloe","dep2",2500);
        Employee P15 =new Employee("Mumin","dep2",1700);

        employees.add(P1);
        employees.add(P2);
        employees.add(P3);
        employees.add(P4);
        employees.add(P5);
        employees.add(P6);
        employees.add(P7);
        employees.add(P8);
        employees.add(P9);
        employees.add(P10);
        employees.add(P11);
        employees.add(P12);
        employees.add(P13);
        employees.add(P14);
        employees.add(P15);

        Stream<Employee> StreamOfEmployee = employees.stream();

        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(
                Paths.get(String.valueOf(new File("EmployeeRegisterFile")))))) {
            StreamOfEmployee
                    .forEach(pw::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static <T, U> Set<U> transform(Set<T> set, Function<T, U> function)
    {
        return set.stream()
                .map(function)
                .collect(Collectors.toSet());
    }

    
}
