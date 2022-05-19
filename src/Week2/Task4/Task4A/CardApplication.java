package Week2.Task4.Task4A;

import java.util.Iterator;

public class CardApplication {
    public static void main(String[] args) {
        Desk desk =new Desk();
        Iterator<Card> it=desk.iterator();

        StringBuilder sb = new StringBuilder();
        sb.append("Desk : \n");
        for (;;) {
            Card card = it.next();
            sb.append(card);
            if (! it.hasNext()) {
                System.out.println(sb);
                break;
            }

        }


    }
}
