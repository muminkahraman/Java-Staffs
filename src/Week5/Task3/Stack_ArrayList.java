package Week5.Task3;

import java.util.ArrayList;
import java.util.List;

public class Stack_ArrayList<T> {
    private List<T> stack;

    public Stack_ArrayList(){
        stack = new ArrayList<>();
    }

    public void push(T item)throws Exception{
        stack.add(item);
    }

    public T pop() throws Exception {
        if(stack.isEmpty()){
            throw new Exception("The stack is empty, there is nothing to pop");
        }

        T item = stack.remove(stack.size()-1);
        return item;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "stack=" + stack.toString();
    }
}
