package Week5.Task3.Task3A;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> list;

    public Stack() {
        this.list = new ArrayList<>();
    }

    public void push(T item){
        System.out.println("push of : "+item.toString());
        list.add(item);
    }

    public T pop() throws Exception {
        if (isEmpty()){
            System.out.println("error");
            throw new Exception("The stack is empty");
        }
        int size=list.size()-1;
        T item=list.get(size);
        list.remove(size);
        System.out.println("pop of : "+item.toString());
        return item;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
