package Week13.Task3.Task3A;


public class AppBuffer {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer=new Buffer(10);
        Producer producer1=new Producer(buffer,1);
        Producer producer2=new Producer(buffer,2);
        Consumer consumer1=new Consumer(buffer,1);
        Consumer consumer2=new Consumer(buffer,2);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        producer1.join();
        producer2.join();
        consumer1.join();

        System.out.println(buffer);

        Thread thread=new Thread(()-> System.out.println("Mumin"));

    }
}
