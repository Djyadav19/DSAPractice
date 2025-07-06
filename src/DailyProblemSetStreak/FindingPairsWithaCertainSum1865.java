package DailyProblemSetStreak;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithaCertainSum1865 {
    class FindSumPairs {
        int[] nums1 = null;
        int[] nums2 = null;
        Map<Integer,Integer> freqMap = new HashMap<>();
        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = Arrays.copyOf(nums1,nums1.length);
            this.nums2 = Arrays.copyOf(nums2,nums2.length);
            for(int i : nums2){
                freqMap.put(i,freqMap.getOrDefault(i,0)+1);
            }

        }

        public void add(int index, int val) {
            freqMap.put(nums2[index],freqMap.get(nums2[index])-1);
            nums2[index] += val;
            freqMap.put(nums2[index],freqMap.getOrDefault(nums2[index],0)+1);
        }

        public int count(int tot) {
            int count = 0;
            for(int i = 0;i<nums1.length;i++){
                if(freqMap.containsKey(tot - nums1[i])){
                    count += freqMap.get(tot-nums1[i]);
                }
            }
            return count;
        }
    }

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
}
