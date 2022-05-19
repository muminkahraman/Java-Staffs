package Week6.Task2.Task2A;

import java.util.Arrays;

public class Stack<T> implements AutoCloseable {
    private T[] list;
    private int s;

    public Stack() {
        list= (T[]) new Object[5];
        s=0;
    }

    public void push(T item) throws FullStackException {
        if (s==list.length){
            throw new FullStackException("The maximum size is "+list.length);
        }
        list[s]=item;
        s++;
        System.out.println("Push of : "+item.toString());

    }

    public T pop() throws Exception {
        if (s==0){
            throw new EmptyStackException("The stack is empty");
        }
        T item=list[s-1];
        list[s-1]=null;
        s--;
        System.out.println("Pop of : "+item.toString());
        return item;
    }

    public boolean isEmpty(){
        return (s==0);
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }

    @Override
    public void close() throws Exception {
        System.out.println("closing");
        list=(T[]) new Object[5];
    }
}
