package Week6.Task2;

public class StackApplication {
    public static void main(String[] args) throws Exception {
        System.out.println("Created data : ");

        Person person1 = new Person("firsName1", "lastName1");
        Person person2 = new Person("firsName2", "lastName2");
        Person person3 = new Person("firsName3", "lastName3");

        System.out.println("Person person1 = " + person1);
        System.out.println("Person person2 = " + person2);
        System.out.println("Person person3 = " + person3);

        System.out.println("\nOperations on the ArrayList stack :");
        System.out.println("\nOperations on Person stack :");


        try(Stack_ArrayList<Person> stackArrayListPerson = new Stack_ArrayList<>();) {
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

        }catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }

        System.out.println("\nOperations on the ArrayDeque stack :");
        System.out.println("\nOperations on Person stack :");

        try(Stack_ArrayDeque<Person> stackArrayDequePerson = new Stack_ArrayDeque<>();) {
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

        }catch (Exception e) {
            System.out.println("ERROR (Person stack): " + e.getMessage());
        }

    }
}
