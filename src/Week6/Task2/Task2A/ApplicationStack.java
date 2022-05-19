package Week6.Task2.Task2A;


import Week5.Task2.Task2A.Person;

public class ApplicationStack {
    public static void main(String[] args) throws Exception {
        Person p=new Person("Mumin","Kahraman");
        try(Stack<Person> sp=new Stack<>();){
            sp.push(p);
            sp.push(p);
            sp.push(p);
            sp.pop();
            System.out.println(sp);
        }

    }
}
