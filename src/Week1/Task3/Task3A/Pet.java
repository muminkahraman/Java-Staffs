package Week1.Task3.Task3A;

public class Pet {
    private String name;
    private String overName;

    public Pet(String name, String overName) {
        this.name = name;
        this.overName = overName;
    }

    public String getName() {
        return name;
    }

    public String getOverName() {
        return overName;
    }


    public String toString() {
        System.out.printf("%s",getName());
        return null;
    }
}
