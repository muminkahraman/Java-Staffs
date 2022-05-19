package Week13.Task2.Task2A;


public class Message extends Thread{
    private int num;
    private String msg;

    public Message(int num,String msg) {
        this.num = num;
        this.msg=msg;
    }

    @Override
    public void run() {
        for (int i=0; i<num; i++){
            System.out.println(msg+" "+i);
            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
