package Week5.Task3;

public class StackApplication {
    public static void main(String[] args) throws Exception {
        Stack_ArrayList<String> stackArrayListString = new Stack_ArrayList<>();
        Stack_ArrayList<Person> stackArrayListPerson = new Stack_ArrayList();
        Stack_ArrayList<DVD> stackArrayListDVD = new Stack_ArrayList();

        Stack_ArrayDeque stackArrayDequeString = new Stack_ArrayDeque();
        Stack_ArrayDeque stackArrayDequePerson = new Stack_ArrayDeque();
        Stack_ArrayDeque stackArrayDequeDVD = new Stack_ArrayDeque();

        System.out.println("Created data : ");
        String string1 = "string1";
        String string2 = "string2";
        String string3 = "string3";
        System.out.println("String string1 = " + string1);
        System.out.println("String string2 = " + string2);
        System.out.println("String string3 = " + string3);

        Person person1 = new Person("firsName1", "lastName1");
        Person person2 = new Person("firsName2", "lastName2");
        Person person3 = new Person("firsName3", "lastName3");
        System.out.println("Person person1 = " + person1);
        System.out.println("Person person2 = " + person2);
        System.out.println("Person person3 = " + person3);

        DVD dvd1 = new DVD("title1", person1, 1);
        DVD dvd2 = new DVD("title2", person2, 2);
        DVD dvd3 = new DVD("title3", person3, 3);
        System.out.println("DVD dvd1 = " + dvd1);
        System.out.println("DVD dvd2 = " + dvd2);
        System.out.println("DVD dvd3 = " + dvd3);

        System.out.println("\nOperations on the ArrayList stacks :");
        System.out.println("Operations on String stack :");
        try {
            stackArrayListString.push(string1);
            System.out.println("string1 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (String stack): " + e.getMessage());
        }
        try {
            stackArrayListString.push(string2);
            System.out.println("string2 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (String stack): " + e.getMessage());
        }
        try {
            stackArrayListString.push(string3);
            System.out.println("string3 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (String stack): " + e.getMessage());
        }
        System.out.println(stackArrayListString);

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("pop : " + stackArrayListString.pop());
            } catch (Exception e) {
                System.out.println("ERROR (String stack): " + e.getMessage());
            }
        }

        System.out.println("\nOperations on Person stack :");
        try {
            stackArrayListPerson.push(person1);
            System.out.println("person1 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }
        try {
            stackArrayListPerson.push(person2);
            System.out.println("person2 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }
        try {
            stackArrayListPerson.push(person3);
            System.out.println("person3 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }
        System.out.println(stackArrayListPerson);

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("pop : " + stackArrayListPerson.pop());
            } catch (Exception e) {
                System.out.println("ERROR (Person stack): " + e.getMessage());
            }
        }

        System.out.println("\nOperations on DVD stack :");
        try {
            stackArrayListDVD.push(dvd1);
            System.out.println("dvd1 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (DVD stack): " + e.getMessage());
        }
        try {
            stackArrayListDVD.push(dvd2);
            System.out.println("dvd2 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (DVD stack): " + e.getMessage());
        }
        try {
            stackArrayListDVD.push(dvd3);
            System.out.println("dvd3 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (DVD stack): " + e.getMessage());
        }
        System.out.println(stackArrayListDVD);

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("pop : " + stackArrayListDVD.pop());
            } catch (Exception e) {
                System.out.println("ERROR (DVD stack): " + e.getMessage());
            }
        }

        System.out.println("\nOperations on the ArrayDeque stacks :");
        System.out.println("Operations on String stack :");
        try {
            stackArrayDequeString.push(string1);
            System.out.println("string1 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (String stack): " + e.getMessage());
        }
        try {
            stackArrayDequeString.push(string2);
            System.out.println("string2 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (String stack): " + e.getMessage());
        }
        try {
            stackArrayDequeString.push(string3);
            System.out.println("string3 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (String stack): " + e.getMessage());
        }
        System.out.println(stackArrayDequeString);

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("pop : " + stackArrayDequeString.pop());
            } catch (Exception e) {
                System.out.println("ERROR (String stack): " + e.getMessage());
            }
        }

        System.out.println("\nOperations on Person stack :");
        try {
            stackArrayDequePerson.push(person1);
            System.out.println("person1 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }
        try {
            stackArrayDequePerson.push(person2);
            System.out.println("person2 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }
        try {
            stackArrayDequePerson.push(person3);
            System.out.println("person3 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }
        System.out.println(stackArrayDequePerson);

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("pop : " + stackArrayDequePerson.pop());
            } catch (Exception e) {
                System.out.println("ERROR (Person stack): " + e.getMessage());
            }
        }

        System.out.println("\nOperations on DVD stack :");
        try {
            stackArrayDequeDVD.push(dvd1);
            System.out.println("dvd1 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (DVD stack): " + e.getMessage());
        }
        try {
            stackArrayDequeDVD.push(dvd2);
            System.out.println("dvd2 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (DVD stack): " + e.getMessage());
        }
        try {
            stackArrayDequeDVD.push(dvd3);
            System.out.println("dvd3 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (DVD stack): " + e.getMessage());
        }
        System.out.println(stackArrayDequeDVD);

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("pop : " + stackArrayDequeDVD.pop());
            } catch (Exception e) {
                System.out.println("ERROR (DVD stack): " + e.getMessage());
            }
        }

    }
}
