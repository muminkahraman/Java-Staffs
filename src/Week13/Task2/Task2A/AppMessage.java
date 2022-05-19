package Week13.Task2.Task2A;


public class AppMessage {
    public static void main(String[] args) {
        Message msg1=new Message(10,"msg1");
        Message msg2=new Message(15,"msg2");
        Message msg3=new Message(5,"msg3");

        msg1.start();
        msg2.start();
        msg3.start();

    }
}
