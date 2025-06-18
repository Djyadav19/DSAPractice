package HashMapImpl;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap <K, V>  {
    class Entry<K,V>{
        K key; // key
        V value; // value
        Entry<K,V> next; // next object
        Entry(K key,V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry<K,V> [] buckets;
    private int capacity = 16; // initial capacity
    private final float loadFactor = 0.75f;
    private int sizeOfDataInMap = 0;


    // call the constructor
    MyHashMap(){
        buckets = new Entry[capacity];
    }

    private int getBucketIndex(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value){
        int idx = getBucketIndex(key);
        Entry<K,V> head = buckets[idx];

        //check that if key Exists then we need to update.
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return; // now have update the value of that key now return.
            }
            head = head.next;
        }
        // Insert new entry at head.
        Entry<K,V> newNode = new Entry<>(key,value);
        newNode.next = buckets[idx];
        buckets[idx] = newNode;
        sizeOfDataInMap++;
        if((1.0*sizeOfDataInMap)/capacity >= loadFactor){
            increaseSize();
        }
    }

    private void increaseSize() {
        int temp = capacity;
        capacity *= 2;
        Entry<K,V> [] newBuckets = new Entry[capacity];

        for(int i = 0;i<temp;i++){
            Entry<K,V> head = buckets[i];
            while(head != null){

                int newIndex = getBucketIndex(head.key);
                newBuckets[newIndex] = head;
                head = head.next;
            }
        }
        buckets = newBuckets;
    }

    public V get(K key){
        int idx = getBucketIndex(key);
        Entry<K,V> head = buckets[idx];
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void remove(K key){
        int idx = getBucketIndex(key);
        Entry<K, V> head = buckets[idx];
        Entry<K,V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                if(prev == null){
                    buckets[idx] = head.next;
                } else{
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public List<K> keySet(){
        List<K> keySet = new ArrayList<>();
        for(int i =0;i<capacity;i++){
            Entry<K,V> head = buckets[i];
            while(head != null){
                keySet.add(head.key);
                head = head.next;
            }
        }
        return keySet;
    }

    public List<Entry<K,V>> entrySet(){
        List<Entry<K,V>> entries = new ArrayList<>();
        for(int i = 0;i<capacity;i++){
            Entry<K,V> head = buckets[i];
            while(head!= null){
                entries.add(head);
                head = head.next;
            }
        }
        return entries;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Apple", 30); // Update value

        System.out.println(map.get("Apple")); // 30
        System.out.println(map.get("Banana")); // 20

        map.remove("Apple");
        System.out.println(map.get("Apple")); // null
        System.out.println("Keyset: " + map.keySet());

        System.out.println("Entries:" + map.entrySet());
    }


}
