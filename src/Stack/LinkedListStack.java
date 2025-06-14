package Stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListStack <T> implements Iterable<T>, Stack<T>{

    LinkedList<T> list = new LinkedList<>();

    public LinkedListStack(){}
    public LinkedListStack(T t){
        push(t);
    }
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() ==0;
    }

    @Override
    public void push(T t) {
        list.addLast(t);
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    @Override
    public T peek() {
        if(isEmpty()) throw  new EmptyStackException();
        return list.peekLast();
    }

    @Override
    public void clear() {
        list.clear();
    }

    public int search(T t){
        return list.indexOf(t);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
