package Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T>{
    private int size;
    private int capcity;
    private Object[] data;

    public ArrayStack(){
        capcity = 16;
        data = new Object[capcity];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }

    @Override
    public void push(T t) {
        if(size > 0 && size == capcity){
            increaseCapcity();
        }
        data[size] = t;
        size++;
    }

    private void increaseCapcity() {
        capcity *= 2;
        data = Arrays.copyOf(data,capcity);
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        T element = (T) data[--size];
        data[size] = null;
        return element;
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new EmptyStackException();
        return (T) data[size-1];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
}
