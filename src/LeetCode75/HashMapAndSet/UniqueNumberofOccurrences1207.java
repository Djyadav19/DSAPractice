package LeetCode75.HashMapAndSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberofOccurrences1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(int i : map.keySet()){
            if(!set.add(map.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueNumberofOccurrences1207 obj = new UniqueNumberofOccurrences1207();
        int[] arr = {1,2,2,1,1,3};
        System.out.println(obj.uniqueOccurrences(arr)); // Expected: true

        int[] arr2 = {1,2};
        System.out.println(obj.uniqueOccurrences(arr2)); // Expected: false
    }
}
