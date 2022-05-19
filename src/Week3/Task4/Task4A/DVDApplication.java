package Week3.Task4.Task4A;

public class DVDApplication {
    public static void main(String[] args) {
        Person moi=new Person("Mumin","Kahraman");
        DVD titanic=new DVD("Titanic",moi,3);
        System.out.println(titanic);
        DVD titanic2=null;

        try {
            titanic2=titanic.clone(5);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(titanic2.getStar());


    }
}