package Week6.Task2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack_ArrayDeque<T> implements AutoCloseable{
    private Deque<T> stack;

    public Stack_ArrayDeque(){
        stack = new ArrayDeque<>();
    }

    public void push(T item) throws Exception{
        stack.addLast(item);
    }

    public T pop() throws Exception {
        if(stack.isEmpty()){
            throw new Exception("The stack is empty, there is nothing to pop");
        }

        return stack.pollLast();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "stack=" + stack.toString();
    }

    @Override
    public void close() throws Exception {
        stack = new ArrayDeque<>();
        System.out.println("the stack has been emptied by the close()");
    }
}