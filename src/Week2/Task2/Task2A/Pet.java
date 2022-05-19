package Week2.Task2.Task2A;

public abstract class Pet {
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

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();
}
