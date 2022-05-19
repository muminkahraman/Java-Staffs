package Week5.Task3.Task3A;

import Week5.Task2.Task2A.DVD;
import Week5.Task2.Task2A.Person;

public class ApplicationStack {
    public static void main(String[] args) throws Exception {
        Stack<String> stackString=new Stack<>();
        stackString.push("Bonjour");
        stackString.push("hello");
        stackString.push("holla");
        System.out.println(stackString);
        stackString.pop();
        System.out.println(stackString);
        stackString.pop();
        stackString.pop();
        //stackString.pop(); error

        StackArrayD<String> stringStackArrayD=new StackArrayD<>();
        stringStackArrayD.push("1");
        stringStackArrayD.push("2");
        stringStackArrayD.push("3");
        System.out.println(stringStackArrayD);
        System.out.println(stringStackArrayD.pop());
        System.out.println(stringStackArrayD.pop());
        System.out.println(stringStackArrayD.pop());
        //System.out.println(stringStackArrayD.pop());

        //Person

        StackArrayD<Person> personStackArrayD=new StackArrayD<>();
        personStackArrayD.push(new Person("Mumin","Kahraman"));
        personStackArrayD.push(new Person("Lamine","Diedhiou"));
        personStackArrayD.push(new Person("Lucas","Kahraman"));
        System.out.println(personStackArrayD);
        personStackArrayD.pop();

        //DVD

        Stack<DVD> DVDstack=new Stack<>();
        DVDstack.push(new DVD(1,"Titanic",new Person("Mumin","Kahraman"),5));




    }
}
