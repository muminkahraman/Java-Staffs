package Week13.Task3.Task3A;


public class Consumer extends Thread{
    private int id;
    private Buffer buffer;

    public Consumer(Buffer buffer,int id) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i=0;i<15;i++){
            try {
                buffer.getNext(id);
                Thread.sleep((long) (Math.random() * 5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
