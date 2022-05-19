package Week14.Task1.Task1A;

import java.util.concurrent.Callable;

public class Producer implements Callable<Integer> {
    private int id;
    private Buffer buffer;

    public Producer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id=id;
    }


    @Override
    public Integer call() throws Exception {
        for (int i=0;i<15;i++){
            try {
                buffer.add(i,id);
                Thread.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        return 15;
    }

}
