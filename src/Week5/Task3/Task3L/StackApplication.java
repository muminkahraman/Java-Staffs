package Week5.Task3.Task3L;

import Week5.Task2.Task2L.DVD;
import Week5.Task2.Task2L.Person;

public class StackApplication {

    public static void main(String[] args) {

        Stack<String> stringStack =new Stack<>();
        StackD<Person> personStackD = new StackD<>();
        StackD<DVD> dvdStackD = new StackD<>();

        stringStack.push("Lamine");
        stringStack.push("Diedhiou");
        stringStack.push("Rex");

       System.out.println(stringStack);

       stringStack.pop();
       //Delete  the last in the list of stack class with arraylist
       System.out.println(stringStack);
       stringStack.pop();
       stringStack.pop();
       //stringStack.pop(); Give us an error

        System.out.println(stringStack);


       Person P1 = new Person("Lamine","Diedhiou");
       Person P2 = new Person("Moussa","Tall");
       Person P3 = new Person("Mumin","Karahman");

        personStackD.push(P1);
        personStackD.push(P2);
        personStackD.push(P3);

        System.out.println(personStackD);
        //Delete  the last in the  stack class with arrayDeque
        personStackD.popEnd();
        personStackD.popEnd();
        personStackD.popEnd();
        //personStackD.popEnd(); Give as an error

        System.out.println(personStackD);

        DVD dvd1 = new DVD(5,"Fast and Furious",P1,32);
        DVD dvd2 = new DVD(3,"Joker",P2,21);
        DVD dvd3 = new DVD(4,"Batman",P2,23);

        dvdStackD.push(dvd1);
        dvdStackD.push(dvd2);
        dvdStackD.push(dvd3);

        System.out.println(dvdStackD);

        //Delete  the last in the  stack class with arrayDeque
        dvdStackD.popEnd();
        dvdStackD.popEnd();
        dvdStackD.popEnd();
        //dvdStackD.popEnd(); Give as an error

        System.out.println(dvdStackD);


    }
}
