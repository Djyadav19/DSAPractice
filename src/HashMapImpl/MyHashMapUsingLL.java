package HashMapImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMapUsingLL<K,V> {

    static class Entry<K,V>{
        K key;
        V value;
        Entry(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private double loadFactor = 0.75f;
    private int totalComponent;

    LinkedList<Entry<K,V>>[] bucket;

    MyHashMapUsingLL(){
        this.capacity = 16;
        this.totalComponent =0;
        bucket = new LinkedList[capacity];
        for(int i = 0;i<capacity;i++){
            bucket[i] = new LinkedList<>();
        }
    }
    MyHashMapUsingLL(K key, V value){
        this.capacity = 16;
        this.totalComponent =0;
        bucket = new LinkedList[capacity];
        for(int i = 0;i<capacity;i++){
            bucket[i] = new LinkedList<>();
        }
        put(key,value);
    }

    private void needToRehas() {
        totalComponent = 0; // since again all the entries going to be added again so in put it will be updated automatically
        LinkedList<Entry<K,V>>[] oldBucket = bucket;
        bucket = new LinkedList[capacity*2];
        //now intialize all the ll
        for(int i = 0;i<capacity*2;i++){
            bucket[i] = new LinkedList<>();
        }
        capacity *= 2;
        for(int i = 0;i<oldBucket.length;i++){
            LinkedList<Entry<K,V>> currentll = oldBucket[i];
            for(int j = 0;j<currentll.size();j++){
                put(currentll.get(j).key,currentll.get(j).value);
            }
        }

    }

    private int getDataIndexFromBucketLinkedList(K key, int bucketIdx) {
        LinkedList<Entry<K,V>> ll = bucket[bucketIdx];
        for(int i =0;i<ll.size();i++){
            if(ll.get(i).key.equals(key)){
                return i;
            }
        }
        return -1;
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode())%capacity;
    }

    public void put(K key,V value){
        int bucketIdx = getBucketIndex(key);
        int dataIndex = getDataIndexFromBucketLinkedList(key,bucketIdx);
        if(dataIndex == -1){
            bucket[bucketIdx].add(new Entry<K,V>(key,value));
            totalComponent++;
        }else{
            bucket[bucketIdx].get(dataIndex).value = value;
            return;
        }

        //now will check for loadFactor
        if(totalComponent >= capacity*loadFactor){
            needToRehas();
        }
    }

    public V get(K key){
        int bucketIdx = getBucketIndex(key);
        int dataIndex = getDataIndexFromBucketLinkedList(key,bucketIdx);
        if(dataIndex == -1){
            return null;
        }
        return bucket[bucketIdx].get(dataIndex).value;
    }

    public int size(){
        return totalComponent;
    }

    public V remove(K key){
        int bucketIdx = getBucketIndex(key);
        int dataIndex = getDataIndexFromBucketLinkedList(key,bucketIdx);
        if(dataIndex == -1){
            return null;
        }
        return bucket[bucketIdx].remove(dataIndex).value;
    }

    public boolean contains(K key){
        int bucketIdx = getBucketIndex(key);
        int dataIndex = getDataIndexFromBucketLinkedList(key,bucketIdx);
        if(dataIndex == -1){
            return false;
        }
        return true;
    }

    public boolean containsValue(V value) {
        for(int i = 0;i<capacity;i++){
            LinkedList<Entry<K,V>> ll = bucket[i];
            for(Entry<K,V> entry : ll){
                if(entry.value == value){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return totalComponent == 0;
    }

    public boolean containsKey(K key) {
        int bucketIdx = getBucketIndex(key);
        int dataIndex = getDataIndexFromBucketLinkedList(key,bucketIdx);
        if(dataIndex == -1){
            return false;
        }
        return true;
    }

    public void clear() {
        for(int i = 0;i<capacity;i++){
            bucket[i].clear();
        }
        totalComponent = 0;
    }


    public List<K> keySet(){
        List<K> keySet = new ArrayList<>();
        for(int i = 0;i<capacity;i++){
            LinkedList<Entry<K,V>> currentll = bucket[i];
            for(int j = 0;j<currentll.size();j++){
                keySet.add(currentll.get(j).key);
            }
        }
        return keySet;
    }

    public List<Entry<K,V>> entrySet(){
        List<Entry<K,V>> entrySet = new ArrayList<>();
        for(int i = 0;i<capacity;i++){
            LinkedList<Entry<K,V>> currentll = bucket[i];
            for(int j = 0;j<currentll.size();j++){
                entrySet.add(currentll.get(j));
            }
        }
        return entrySet;
    }

}
