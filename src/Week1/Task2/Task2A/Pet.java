package Week1.Task2.Task2A;

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

    @Override
    public String toString() {
        return name +"             "+ overName ;
    }
}
