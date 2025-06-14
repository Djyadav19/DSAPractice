package Stack;

public class StackTest {

    public static void main(String[] args) {
        // Test ArrayStack with Double
        Stack<Double> doubleStack = new ArrayStack<Double>();
        doubleStack.push(1.1);
        doubleStack.push(2.2);
        System.out.println("ArrayStack<Double> top: " + doubleStack.peek());
        System.out.println("ArrayStack<Double> pop: " + doubleStack.pop());
        System.out.println("ArrayStack<Double> size: " + doubleStack.size());
        doubleStack.clear();
        System.out.println("ArrayStack<Double> isEmpty after clear: " + doubleStack.isEmpty());

        // Test ArrayStack with Integer
        Stack<Integer> intStack = new ArrayStack<Integer>();
        intStack.push(10);
        intStack.push(20);
        System.out.println("ArrayStack<Integer> top: " + intStack.peek());
        System.out.println("ArrayStack<Integer> pop: " + intStack.pop());
        System.out.println("ArrayStack<Integer> size: " + intStack.size());
        intStack.clear();
        System.out.println("ArrayStack<Integer> isEmpty after clear: " + intStack.isEmpty());

        // Test ArrayStack with Character
        Stack<Character> charStack = new ArrayStack<Character>();
        charStack.push('a');
        charStack.push('b');
        System.out.println("ArrayStack<Character> top: " + charStack.peek());
        System.out.println("ArrayStack<Character> pop: " + charStack.pop());
        System.out.println("ArrayStack<Character> size: " + charStack.size());
        charStack.clear();
        System.out.println("ArrayStack<Character> isEmpty after clear: " + charStack.isEmpty());

        // Test ArrayStack with Boolean
        Stack<Boolean> boolStack = new ArrayStack<Boolean>();
        boolStack.push(true);
        boolStack.push(false);
        System.out.println("ArrayStack<Boolean> top: " + boolStack.peek());
        System.out.println("ArrayStack<Boolean> pop: " + boolStack.pop());
        System.out.println("ArrayStack<Boolean> size: " + boolStack.size());
        boolStack.clear();
        System.out.println("ArrayStack<Boolean> isEmpty after clear: " + boolStack.isEmpty());

        // Test ArrayStack with Float
        Stack<Float> floatStack = new ArrayStack<Float>();
        floatStack.push(1.5f);
        floatStack.push(2.5f);
        System.out.println("ArrayStack<Float> top: " + floatStack.peek());
        System.out.println("ArrayStack<Float> pop: " + floatStack.pop());
        System.out.println("ArrayStack<Float> size: " + floatStack.size());
        floatStack.clear();
        System.out.println("ArrayStack<Float> isEmpty after clear: " + floatStack.isEmpty());

        // Test ArrayStack with Long
        Stack<Long> longStack = new ArrayStack<Long>();
        longStack.push(100L);
        longStack.push(200L);
        System.out.println("ArrayStack<Long> top: " + longStack.peek());
        System.out.println("ArrayStack<Long> pop: " + longStack.pop());
        System.out.println("ArrayStack<Long> size: " + longStack.size());
        longStack.clear();
        System.out.println("ArrayStack<Long> isEmpty after clear: " + longStack.isEmpty());

        // Test ArrayStack with Short
        Stack<Short> shortStack = new ArrayStack<Short>();
        shortStack.push((short)1);
        shortStack.push((short)2);
        System.out.println("ArrayStack<Short> top: " + shortStack.peek());
        System.out.println("ArrayStack<Short> pop: " + shortStack.pop());
        System.out.println("ArrayStack<Short> size: " + shortStack.size());
        shortStack.clear();
        System.out.println("ArrayStack<Short> isEmpty after clear: " + shortStack.isEmpty());

        // Test ArrayStack with Byte
        Stack<Byte> byteStack = new ArrayStack<Byte>();
        byteStack.push((byte)10);
        byteStack.push((byte)20);
        System.out.println("ArrayStack<Byte> top: " + byteStack.peek());
        System.out.println("ArrayStack<Byte> pop: " + byteStack.pop());
        System.out.println("ArrayStack<Byte> size: " + byteStack.size());
        byteStack.clear();
        System.out.println("ArrayStack<Byte> isEmpty after clear: " + byteStack.isEmpty());

        // Test LinkedListStack with Double
        Stack<Double> linkedDoubleStack = new LinkedListStack<Double>();
        linkedDoubleStack.push(3.3);
        linkedDoubleStack.push(4.4);
        System.out.println("LinkedListStack<Double> top: " + linkedDoubleStack.peek());
        System.out.println("LinkedListStack<Double> pop: " + linkedDoubleStack.pop());
        System.out.println("LinkedListStack<Double> size: " + linkedDoubleStack.size());
        linkedDoubleStack.clear();
        System.out.println("LinkedListStack<Double> isEmpty after clear: " + linkedDoubleStack.isEmpty());

        // Test LinkedListStack with Integer
        Stack<Integer> linkedIntStack = new LinkedListStack<Integer>();
        linkedIntStack.push(100);
        linkedIntStack.push(200);
        System.out.println("LinkedListStack<Integer> top: " + linkedIntStack.peek());
        System.out.println("LinkedListStack<Integer> pop: " + linkedIntStack.pop());
        System.out.println("LinkedListStack<Integer> size: " + linkedIntStack.size());
        linkedIntStack.clear();
        System.out.println("LinkedListStack<Integer> isEmpty after clear: " + linkedIntStack.isEmpty());

        // Test LinkedListStack with Character
        Stack<Character> linkedCharStack = new LinkedListStack<Character>();
        linkedCharStack.push('x');
        linkedCharStack.push('y');
        System.out.println("LinkedListStack<Character> top: " + linkedCharStack.peek());
        System.out.println("LinkedListStack<Character> pop: " + linkedCharStack.pop());
        System.out.println("LinkedListStack<Character> size: " + linkedCharStack.size());
        linkedCharStack.clear();
        System.out.println("LinkedListStack<Character> isEmpty after clear: " + linkedCharStack.isEmpty());

        // Test LinkedListStack with Boolean
        Stack<Boolean> linkedBoolStack = new LinkedListStack<Boolean>();
        linkedBoolStack.push(false);
        linkedBoolStack.push(true);
        System.out.println("LinkedListStack<Boolean> top: " + linkedBoolStack.peek());
        System.out.println("LinkedListStack<Boolean> pop: " + linkedBoolStack.pop());
        System.out.println("LinkedListStack<Boolean> size: " + linkedBoolStack.size());
        linkedBoolStack.clear();
        System.out.println("LinkedListStack<Boolean> isEmpty after clear: " + linkedBoolStack.isEmpty());

        // Test LinkedListStack with Float
        Stack<Float> linkedFloatStack = new LinkedListStack<Float>();
        linkedFloatStack.push(3.5f);
        linkedFloatStack.push(4.5f);
        System.out.println("LinkedListStack<Float> top: " + linkedFloatStack.peek());
        System.out.println("LinkedListStack<Float> pop: " + linkedFloatStack.pop());
        System.out.println("LinkedListStack<Float> size: " + linkedFloatStack.size());
        linkedFloatStack.clear();
        System.out.println("LinkedListStack<Float> isEmpty after clear: " + linkedFloatStack.isEmpty());

        // Test LinkedListStack with Long
        Stack<Long> linkedLongStack = new LinkedListStack<Long>();
        linkedLongStack.push(300L);
        linkedLongStack.push(400L);
        System.out.println("LinkedListStack<Long> top: " + linkedLongStack.peek());
        System.out.println("LinkedListStack<Long> pop: " + linkedLongStack.pop());
        System.out.println("LinkedListStack<Long> size: " + linkedLongStack.size());
        linkedLongStack.clear();
        System.out.println("LinkedListStack<Long> isEmpty after clear: " + linkedLongStack.isEmpty());

        // Test LinkedListStack with Short
        Stack<Short> linkedShortStack = new LinkedListStack<Short>();
        linkedShortStack.push((short)3);
        linkedShortStack.push((short)4);
        System.out.println("LinkedListStack<Short> top: " + linkedShortStack.peek());
        System.out.println("LinkedListStack<Short> pop: " + linkedShortStack.pop());
        System.out.println("LinkedListStack<Short> size: " + linkedShortStack.size());
        linkedShortStack.clear();
        System.out.println("LinkedListStack<Short> isEmpty after clear: " + linkedShortStack.isEmpty());

        // Test LinkedListStack with Byte
        Stack<Byte> linkedByteStack = new LinkedListStack<Byte>();
        linkedByteStack.push((byte)30);
        linkedByteStack.push((byte)40);
        System.out.println("LinkedListStack<Byte> top: " + linkedByteStack.peek());
        System.out.println("LinkedListStack<Byte> pop: " + linkedByteStack.pop());
        System.out.println("LinkedListStack<Byte> size: " + linkedByteStack.size());
        linkedByteStack.clear();
        System.out.println("LinkedListStack<Byte> isEmpty after clear: " + linkedByteStack.isEmpty());

        // Test LinkedListStack with String
        Stack<String> linkedStringStack = new LinkedListStack<String>();
        linkedStringStack.push("A");
        linkedStringStack.push("B");
        System.out.println("LinkedListStack<String> top: " + linkedStringStack.peek());
        System.out.println("LinkedListStack<String> pop: " + linkedStringStack.pop());
        System.out.println("LinkedListStack<String> size: " + linkedStringStack.size());
    }
}
