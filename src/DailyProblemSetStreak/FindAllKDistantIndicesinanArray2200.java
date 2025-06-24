package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllKDistantIndicesinanArray2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> index = new HashSet<>();
        for(int i = 0;i< nums.length;i++){
            if(nums[i] == key){
                index.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            boolean flag = false;
            for(int idx : index){
                if(Math.abs(i-idx) <= k){
                    flag = true;
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        FindAllKDistantIndicesinanArray2200 solver = new FindAllKDistantIndicesinanArray2200();

        // Test case 1
        int[] nums1 = {3,4,9,1,3,9,5};
        int key1 = 9, k1 = 1;
        System.out.println(solver.findKDistantIndices(nums1, key1, k1)); // Expected: [1,2,3,4,5,6]

        // Test case 2
        int[] nums2 = {2,2,2,2,2};
        int key2 = 2, k2 = 2;
        System.out.println(solver.findKDistantIndices(nums2, key2, k2)); // Expected: [0,1,2,3,4]

        // Test case 3
        int[] nums3 = {1,2,3,4,5};
        int key3 = 6, k3 = 1;
        System.out.println(solver.findKDistantIndices(nums3, key3, k3)); // Expected: []

        // Test case 4
        int[] nums4 = {1,2,3,4,5,6,7,8,9,10};
        int key4 = 5, k4 = 3;
        System.out.println(solver.findKDistantIndices(nums4, key4, k4)); // Expected: [2,3,4,5,6,7]

        // Test case 5 (edge case: k = 0)
        int[] nums5 = {1,2,3,2,1};
        int key5 = 2, k5 = 0;
        System.out.println(solver.findKDistantIndices(nums5, key5, k5)); // Expected: [1,3]
    }
}
