package Week3.Task3;

public class DVDapplication {
    public static void main(String[] args) {
        Person bruceWillis = new Person("Bruce", "Willis");
        DVD Armageddon = new DVD("Armageddon", bruceWillis, 5);
        System.out.println(Armageddon);

        Armageddon.setNumberOfStars(4);
        System.out.println(Armageddon);
        System.out.println("star change test done : 5 to 4");

        DVD Armageddon2 = null;

        System.out.println("\nBefore cloning");
        System.out.println("\tDVD = " + Armageddon.toString());
        System.out.println("\tDVDclone = " + Armageddon2);

        try {
            Armageddon2 = Armageddon.clone();
            System.out.println(Armageddon2);
        } catch (CloneNotSupportedException e) {
            System.out.println("\nERROR: There was a problem with the clone");
        }

        System.out.println("\nAfter cloning");
        System.out.println("\tDVD = " + Armageddon.toString());
        System.out.println("\tDVDclone = " + Armageddon2.toString());

    if ((Armageddon != Armageddon2) && (Armageddon.equals(Armageddon2))){
        System.out.println("\nClone success (checked with equals)");
    } else {
        System.out.println("\nClone failed (checked with equals) ");
    }
    }
}
