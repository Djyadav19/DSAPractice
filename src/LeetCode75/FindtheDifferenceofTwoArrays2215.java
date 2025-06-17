package LeetCode75;

import java.util.*;

public class FindtheDifferenceofTwoArrays2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();

        for (int j : nums1) {
            list1.add(j);
        }
        for (int j : nums2) {
            if(list1.contains(j)){
                list1.remove(j);
            }
            list2.add(j);
        }
        for (int j : nums1) {
            if(list2.contains(j)){
                list2.remove(j);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(list1));
        ans.add(new ArrayList<>(list2));
        return ans;
    }
}
