package HashMapImpl;

public class TestMyHashMapUsingLL {
    public static void main(String[] args) {
            MyHashMapUsingLL<Integer, String> map = new MyHashMapUsingLL<>(4, "four");

            // Test put and get
            map.put(1, "One");
            map.put(2, "Two");
            map.put(3, "Three");
            map.put(4, "Four");
            System.out.println("Get 1: " + map.get(1)); // One
            System.out.println("Get 2: " + map.get(2)); // Two

            // Test update value
            map.put(2, "Two Updated");
            System.out.println("Get 2 after update: " + map.get(2)); // Two Updated

            // Test remove
            System.out.println("Remove 3: " + map.remove(3)); // Three
            System.out.println("Get 3 after remove: " + map.get(3)); // null

            // Test containsKey and containsValue
            System.out.println("Contains key 1: " + map.containsKey(1)); // true
            System.out.println("Contains value 'Four': " + map.containsValue("Four")); // true

            // Test size and isEmpty
            System.out.println("Size: " + map.size()); // 3
            System.out.println("Is empty: " + map.isEmpty()); // false

            // Test clear
            map.clear();
            System.out.println("Size after clear: " + map.size()); // 0
            System.out.println("Is empty after clear: " + map.isEmpty()); // true

            System.out.println("Size after clearing: " + map.size());
            // Test load factor and resizing
            for (int i = 0; i < 200; i++) {
                map.put(i, "Val" + i);
            }
            System.out.println("Size after adding 200 elements: " + map.size());
            for (int i = 0; i < 10; i++) {
                System.out.println("Get " + i + ": " + map.get(i));
            }
        }
}
