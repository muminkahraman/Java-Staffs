package Week5.Task2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack_ArrayDeque<T> {
    private Deque<T> stack;

    public Stack_ArrayDeque(){
        stack = new ArrayDeque<>();
    }

    public void push(T item) throws Exception{
        stack.addLast(item);
    }

    public T pop() throws Exception {
        if(stack.isEmpty()){
            throw new Exception("The ArrayDeque is empty, there is nothing to pop");
        }else{
            return stack.pollLast();
        }
    }

    public T popRear() throws Exception {
        if(stack.isEmpty()){
            throw new Exception("The ArrayDeque is empty, there is nothing to pop");
        }else{
            return stack.pollFirst();
        }
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "stack=" + stack.toString();
    }

    public int size() {
        return stack.size();
    }
}