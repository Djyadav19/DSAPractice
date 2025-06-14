package Queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListQueue<T> implements Queue<T> ,Iterable<T>{

    private LinkedList<T> list = new LinkedList<T>();
    public LinkedListQueue(){

    }
    public LinkedListQueue(T t){
        list.addLast(t);
    }
    @Override
    public void offer(T t) {
        list.addLast(t);
    }

    @Override
    public T poll() {
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        return (T) list.removeFirst();
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        return (T) list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
