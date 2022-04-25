package Week6.Task2;

public class StackApplication {
    public static void main(String[] args) throws Exception {
        Stack_ArrayList<String> stackArrayListString = new Stack_ArrayList<>();
        Stack_ArrayList<Person> stackArrayListPerson = new Stack_ArrayList();

        System.out.println("Created data : ");
        String string1 = "string1";
        String string2 = "string2";
        String string3 = "string3";
        String string4 = "string4";
        String string5 = "string5";
        String string6 = "string6";
        System.out.println("String string1 = " + string1);
        System.out.println("String string2 = " + string2);
        System.out.println("String string3 = " + string3);
        System.out.println("String string4 = " + string4);
        System.out.println("String string5 = " + string5);
        System.out.println("String string6 = " + string6);

        Person person1 = new Person("firsName1", "lastName1");
        Person person2 = new Person("firsName2", "lastName2");
        Person person3 = new Person("firsName3", "lastName3");
        Person person4 = new Person("firsName4", "lastName4");
        Person person5 = new Person("firsName5", "lastName5");
        Person person6 = new Person("firsName6", "lastName6");
        System.out.println("Person person1 = " + person1);
        System.out.println("Person person2 = " + person2);
        System.out.println("Person person3 = " + person3);
        System.out.println("Person person4 = " + person4);
        System.out.println("Person person5 = " + person5);
        System.out.println("Person person6 = " + person6);

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
        try {
            stackArrayListString.push(string4);
            System.out.println("string4 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (String stack): " + e.getMessage());
        }
        try {
            stackArrayListString.push(string5);
            System.out.println("string5 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (String stack): " + e.getMessage());
        }
        try {
            stackArrayListString.push(string6);
            System.out.println("string6 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (String stack): " + e.getMessage());
        }
        System.out.println(stackArrayListString);

        for (int i = 0; i < 6; i++) {
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
        try {
            stackArrayListPerson.push(person4);
            System.out.println("person4 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }
        try {
            stackArrayListPerson.push(person5);
            System.out.println("person5 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }
        try {
            stackArrayListPerson.push(person6);
            System.out.println("person6 pushed.");
        } catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }
        System.out.println(stackArrayListPerson);

        for (int i = 0; i < 6; i++) {
            try {
                System.out.println("pop : " + stackArrayListPerson.pop());
            } catch (Exception e) {
                System.out.println("ERROR (Person stack): " + e.getMessage());
            }
        }

    }
}
