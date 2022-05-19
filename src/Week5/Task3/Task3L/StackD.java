package Week5.Task3.Task3L;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class StackD <T> {

    private ArrayDeque<T> deque ;

    public StackD()
    {
        this.deque = new ArrayDeque<>();
    }

    public void push(T item)
    {
        deque.add(item);
        System.out.println("Push of " +item.toString());
    }

    public boolean isEmpty()
    {
        return deque.isEmpty();
    }

    public T popEnd()
    {
        if(isEmpty())
        {
            System.out.println("error");
            throw new IllegalStateException("the stack is Empty");
        }

        System.out.println("Remove to the last"+deque.getLast());
        return deque.pop();

    }

    @Override
    public String toString() {
        return "deque=" + deque.toString();
    }
}
