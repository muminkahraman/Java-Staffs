package Week6.Task2.Task2L;

import Week5.Task2.Task2L.Person;

public class StackApplication  {

    public static void main(String[] args) throws Exception {


        try(Stack<String> stringStack =new Stack<>();) {

            stringStack.push("lamine");
            stringStack.push("Rex");
            stringStack.push("Mex");
            stringStack.pop();

            System.out.println(stringStack);

        }


        System.out.println("--------------------------------------------------------------------------");

       try(Stack<Person> personStack = new Stack<>();) {

           Person P1 = new Person("Lamine","Diedhiou");
           Person P2 = new Person("Moussa","Tall");
           Person P3 = new Person("Mumin","Karahman");
           personStack.push(P1);
           personStack.push(P2);
           personStack.push(P3);

           System.out.println(personStack);

           personStack.pop();


       }

       System.out.println("--------------------------------------------------------------------------");



    }
}
