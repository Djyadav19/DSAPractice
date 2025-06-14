package Stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

public interface Stack<T>   {
    public int size();
    public boolean isEmpty();
    public void push(T t);
    public T pop();
    public T peek();

    public void clear();
}
