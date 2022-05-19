package Week14.Task1.Task1A;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AppBuffer {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer=new Buffer(10);
        Producer producer1=new Producer(buffer,1);
        Producer producer2=new Producer(buffer,2);
        Consumer consumer1=new Consumer(buffer,1);
        Consumer consumer2=new Consumer(buffer,2);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(producer1);
        executor.submit(producer2);
        executor.submit(consumer1);
        executor.submit(consumer2);


    }
}
