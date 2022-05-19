package Week7.Task3.Task3L;

import java.util.function.Supplier;

public abstract class DVDSupplier implements Supplier<DVD>{

    private final String title ;
    private final Person leadActor;
    private  final int numberOfStars;
    private final int id ;

    public DVDSupplier(int numberOfStars, String title, Person leadActor, int id)
    {
        this.title = title;
        this.leadActor = leadActor;
        this.numberOfStars = numberOfStars;
        this.id=id;
    }

    @Override
    public DVD get() {
        return new DVD(numberOfStars,title,leadActor,id);
    }
}
