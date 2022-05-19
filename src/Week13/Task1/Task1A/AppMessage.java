package Week13.Task1.Task1A;

public class AppMessage {
    public static void main(String[] args) {
        Message msg1=new Message(10,"msg1");
        Message msg2=new Message(15,"msg2");
        Message msg3=new Message(5,"msg3");

        msg1.run();
        msg2.run();
        msg3.run();

    }
}
