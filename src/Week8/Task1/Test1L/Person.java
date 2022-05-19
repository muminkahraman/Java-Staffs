package Week8.Task1.Test1L;

public class Person  {

    private String name ;
    private  int age ;



    public Person(String name,int age )
    {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person : " +
                "name= " + name +" "+
                "age= " + age
                ;
    }


}