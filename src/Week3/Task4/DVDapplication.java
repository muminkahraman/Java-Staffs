package Week3.Task4;

public class DVDapplication {
    public static void main(String[] args) {
        Person bruceWillis = new Person("Bruce", "Willis");
        DVD Armageddon = new DVD("Armageddon", bruceWillis, 5);
        System.out.println("Before star change : " + Armageddon);

        Armageddon = new DVD(Armageddon.getTitle(), Armageddon.getLeadActor(), 4);
        System.out.println("After Star Change : " + Armageddon);
        System.out.println("star change done : 5 to 4");
    }

}
