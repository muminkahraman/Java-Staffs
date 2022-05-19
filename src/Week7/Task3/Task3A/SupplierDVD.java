package Week7.Task3.Task3A;

import java.util.function.Supplier;

public class SupplierDVD implements Supplier<DVD> {
    private int id;
    private String title;
    private Person leadActor;
    private int star;

    public SupplierDVD(int id, String title, Person leadActor, int star) {
        this.id = id;
        this.title = title;
        this.leadActor = leadActor;
        this.star = star;
    }

    @Override
    public DVD get() {
        return new DVD(id,title,leadActor,star);
    }
}
