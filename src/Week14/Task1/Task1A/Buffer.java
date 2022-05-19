package Week14.Task1.Task1A;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final Queue<Integer> theData;
    private final int MAX;  // maximum size of the buffer
    private int numItems;


    public Buffer(int m) {
        MAX = m;
        theData = new LinkedList<>();
        numItems = 0;
    }

    public synchronized int getNext(int consumerNo) throws InterruptedException {

      while (theData.isEmpty()) {
            System.out.println("Consumer " + consumerNo + " attempting to remove from empty buffer - wait");
            wait();
        }
        int data = theData.remove();

        /*int data;
        synchronized (theData){
            data = theData.remove();
            --numItems;
        }*/
        --numItems;
        System.out.println("Consumer " + consumerNo + " retrieved " + data + " from buffer: " + theData);
        notifyAll();


        return data;
    }

    public synchronized void add(int data, int producerNo) throws InterruptedException {
        while (numItems == MAX) {
            System.out.println("Producer " + producerNo + " attempting to add to full buffer - wait");
            wait();
        }
        theData.add(data);
        System.out.println("Producer " + producerNo + " added " + data + " to buffer:" + theData.toString());
        ++numItems;
        notifyAll();
    }

    @Override
    public String toString() {
        return theData.toString();
    }
}


