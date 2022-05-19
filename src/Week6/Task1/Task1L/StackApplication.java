package Week6.Task1.Task1L;

import Week5.Task2.Task2L.DVD;
import Week5.Task2.Task2L.Person;

public class StackApplication  {

    public static void main(String[] args) throws Exception {

        Stack<String> stringStack =new Stack<>();
        Stack<Person> personStack = new Stack<>();


        stringStack.push("lamine");
        stringStack.push("Rex");
        stringStack.push("Mex");
        stringStack.push("Dex");
        stringStack.push("Tex");

        System.out.println(stringStack);

        // Throw the full stack exception
       // stringStack.push("Mum");

        System.out.println("--------------------------------------------------------------------------");

        Person P1 = new Person("Lamine","Diedhiou");
        Person P2 = new Person("Moussa","Tall");
        Person P3 = new Person("Mumin","Karahman");
        Person P4 = new Person("Lamine","Diedhiou");
        Person P5 = new Person("Moussa","Tall");
        Person P6 = new Person("Mumin","Karahman");

        personStack.push(P1);
        personStack.push(P2);
        personStack.push(P3);
        personStack.push(P4);
        personStack.push(P5);

        System.out.println(personStack);

        // Throw the full stack exception
        //personStack.push(P6);

        System.out.println("--------------------------------------------------------------------------");

        personStack.pop();
        personStack.pop();
        personStack.pop();
        personStack.pop();
        personStack.pop();

        System.out.println(personStack);

        // Throw the emptystack exception
        //personStack.pop();

        System.out.println("--------------------------------------------------------------------------");

        stringStack.pop();
        stringStack.pop();
        stringStack.pop();
        stringStack.pop();
        stringStack.pop();

        System.out.println(stringStack);

        // Throw the emptystack exception
        //stringStack.pop();

        System.out.println("--------------------------------------------------------------------------");




    }
}
