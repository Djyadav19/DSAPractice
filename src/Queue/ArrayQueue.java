package Queue;

import Stack.ArrayStack;

import java.util.Arrays;

public class ArrayQueue <T> implements Queue<T>{

    private int size = 0;
    private int capacity = 0;
    private Object[] data;

    public ArrayQueue(){
        capacity = 16;
        data = new Object[capacity];
    }
    public ArrayQueue(T t){
        capacity = 16;
        data = new Object[capacity];
        offer(t);
    }
    @Override
    public void offer(T t) {
        if(size > 0 && size == capacity){
            increaseCapacity();
        }
        data[size] = t;
        size++;
    }

    private void increaseCapacity() {
        capacity *= 2;
        data = Arrays.copyOf(data,capacity);
    }

    @Override
    public T poll() {
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        return (T) data[size--];

    }

    @Override
    public T peek() {
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        return (T) data[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
