package Week14.Task1.Task1A;

import java.util.concurrent.Callable;


public class Consumer implements Callable<Integer> {
    private int id;
    private Buffer buffer;

    public Consumer(Buffer buffer, int id) {
        this.id = id;
        this.buffer = buffer;
    }



    @Override
    public Integer call() throws Exception {
        for (int i=0;i<15;i++){
            try {
                buffer.getNext(id);
                Thread.sleep((long) (Math.random() * 5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return 15;
    }
}
