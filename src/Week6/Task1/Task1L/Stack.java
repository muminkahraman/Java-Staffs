package Week6.Task1.Task1L;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack<T> {

    private T[] array;
    private int size;

    public Stack() {
        this.array = (T[]) new Object[5];
        this.size = 0;
    }

    public void push(T item) throws FullStackException {
        if (size == array.length) {
            throw new FullStackException("We got mawimum size :" + array.length);
        }
        array[size] =item ;
        size++;

        System.out.println("We push the object "+item);
    }

    public T pop() throws EmptyStackException
    {
        if(array.length == 0 && size == array.length)
        {
            throw new EmptyStackException("The stack is empty");
        }

        T item = array[size-1];
        array[size-1]=null;
        size--;

        System.out.println("We remove the object"+item);
        return item;

    }

    @Override
    public String toString() {
        return "Stack{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}