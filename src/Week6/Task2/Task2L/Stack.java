package Week6.Task2.Task2L;

import java.util.Arrays;

public class Stack<T> implements AutoCloseable  {

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
                "array=" + Arrays.toString(array)
                ;
    }

    @Override
    public void close() throws Exception {
        //We make the class empty
        array = (T[]) new Object[5];
        System.out.println("The Array is now empty");
    }
}