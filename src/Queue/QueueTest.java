package Queue;

public class QueueTest {
    public static void main(String[] args){
    // Test ArrayQueue with Integer
            ArrayQueue<Integer> arrayQueueInt = new ArrayQueue<>(5);
            arrayQueueInt.offer(1);
            arrayQueueInt.offer(2);
            arrayQueueInt.offer(3);
            System.out.println("ArrayQueue<Integer> dequeue: " + arrayQueueInt.poll());
            System.out.println("ArrayQueue<Integer> peek: " + arrayQueueInt.peek());
            System.out.println("ArrayQueue<Integer> isEmpty: " + arrayQueueInt.isEmpty());
            System.out.println("ArrayQueue<Integer> size: " + arrayQueueInt.size());

            // Test ArrayQueue with String
            ArrayQueue<String> arrayQueueStr = new ArrayQueue<String>("5");
            arrayQueueStr.offer("A");
            arrayQueueStr.offer("B");
            arrayQueueStr.offer("C");
            System.out.println("ArrayQueue<String> dequeue: " + arrayQueueStr.poll());
            System.out.println("ArrayQueue<String> peek: " + arrayQueueStr.peek());
            System.out.println("ArrayQueue<String> isEmpty: " + arrayQueueStr.isEmpty());
            System.out.println("ArrayQueue<String> size: " + arrayQueueStr.size());

            // Test LinkedListQueue with Integer
            LinkedListQueue<Integer> linkedQueueInt = new LinkedListQueue<Integer>();
            linkedQueueInt.offer(10);
            linkedQueueInt.offer(20);
            linkedQueueInt.offer(30);
            System.out.println("LinkedListQueue<Integer> dequeue: " + linkedQueueInt.poll());
            System.out.println("LinkedListQueue<Integer> peek: " + linkedQueueInt.peek());
            System.out.println("LinkedListQueue<Integer> isEmpty: " + linkedQueueInt.isEmpty());
            System.out.println("LinkedListQueue<Integer> size: " + linkedQueueInt.size());

            // Test LinkedListQueue with String
            LinkedListQueue<String> linkedQueueStr = new LinkedListQueue<String>();
            linkedQueueStr.offer("X");
            linkedQueueStr.offer("Y");
            linkedQueueStr.offer("Z");
            System.out.println("LinkedListQueue<String> dequeue: " + linkedQueueStr.poll());
            System.out.println("LinkedListQueue<String> peek: " + linkedQueueStr.peek());
            System.out.println("LinkedListQueue<String> isEmpty: " + linkedQueueStr.isEmpty());
            System.out.println("LinkedListQueue<String> size: " + linkedQueueStr.size());
    }
}
