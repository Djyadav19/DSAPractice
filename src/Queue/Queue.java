package Queue;

public interface Queue<T> {

    public void offer(T t);

    public T poll();

    public T peek();

    public int size();

    public boolean isEmpty();

}
