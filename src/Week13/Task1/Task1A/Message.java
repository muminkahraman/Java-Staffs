package Week13.Task1.Task1A;

public class Message{
    private int num;
    private String msg;

    public Message(int num,String msg) {
        this.num = num;
        this.msg=msg;
    }

    public void run() {
        for (int i=0; i<num; i++){
            System.out.println(msg+" "+i);
        }
    }
}
