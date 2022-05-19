package Week5.Task3.Task3A;

import java.util.ArrayDeque;

public class StackArrayD<T> {
    private ArrayDeque<T> list;

    public StackArrayD() {
        this.list = new ArrayDeque<>();
    }

    public void push(T item){
        System.out.println("push of : "+item.toString());
        list.push(item);
    }

    public T pop() {
        System.out.println("pop of : "+list.getLast());
        return list.pop();

    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
