package Week6.Task1.Task1A;


import Week5.Task2.Task2A.Person;

public class ApplicationStack {
    public static void main(String[] args) throws Exception {
        Person p=new Person("Mumin","Kahraman");
        Stack<Person> sp=new Stack<>();
        sp.push(p);
        sp.push(p);
        sp.push(p);
        System.out.println(sp);
        System.out.println(sp.pop());
        System.out.println(sp);
        System.out.println(sp.pop());
        System.out.println(sp);
        System.out.println(sp.pop());
        System.out.println(sp);
        System.out.println(sp.pop());
        System.out.println(sp);
    }
}
