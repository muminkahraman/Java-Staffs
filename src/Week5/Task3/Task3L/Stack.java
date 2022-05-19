package Week5.Task3.Task3L;

import java.util.ArrayList;
import java.util.List;

public class Stack<T>{

    private List<T> list ;

    public Stack()
    {
        this.list = new ArrayList<>();
    }

    public void push(T item)
    {
        list.add(item);
        System.out.println("Push of " +item.toString());
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public T pop()
    {

        if(isEmpty())
        {
            System.out.println("error");
            throw new IllegalStateException("the stack is Empty");
        }
        int size = this.list.size()-1;
        T item =this.list.get(size);
        this.list.remove(size);
        System.out.println("Remove of "+ item.toString());
        return item ;


       /* if(list.size()==0)
            throw new IllegalStateException("Stack is empty");
        return list.remove(list.size()-1);

        int size = this.list.size()-1;
        T item =this.list.get(size);

        if(this.list.size() == 0)
        {
            throw new IllegalStateException("Stack is empty");
        }
        this.list.remove(size);
        System.out.println("Remove of "+ item.toString());
        return item ; */


    }

    @Override
    public String toString() {
        return "list=" + list.toString();

    }


}
