package Week13.Task3.Task3A;


public class Producer extends Thread{
    private int id;
    private Buffer buffer;

    public Producer(Buffer buffer,int id) {
        this.buffer = buffer;
        this.id=id;
    }

    @Override
    public void run() {
        for (int i=0;i<15;i++){
            try {
                buffer.add(i,id);
                Thread.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
