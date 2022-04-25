package Week6.Task1;

import java.util.ArrayList;
import java.util.List;

public class Stack_ArrayList<T> {
    private T[] stack;
    private final int MAXSIZE = 5;
    private int actualSize;

    public Stack_ArrayList(){
        stack = (T[]) new Object[MAXSIZE];
        actualSize = 0;
    }

    public void push(T item)throws FullStackException{
        if (actualSize >= MAXSIZE){
            throw new FullStackException("Error Stack is full");
        }else {
            stack[actualSize] = item;
            actualSize++;
        }
    }

    public T pop() throws EmptyStackException {
        if(actualSize == 0){
            throw new EmptyStackException("The stack is empty, there is nothing to pop");
        }else {
            T item = stack[actualSize - 1];
            stack[actualSize - 1] = null;
            actualSize--;
            return item;
        }
    }

    public boolean isEmpty(){
        if (actualSize == 0) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "stack=" + stack.toString();
    }
}
