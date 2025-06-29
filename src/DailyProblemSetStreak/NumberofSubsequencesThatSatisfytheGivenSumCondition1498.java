package DailyProblemSetStreak;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubsequencesThatSatisfytheGivenSumCondition1498 {


    private static final int MOD = 1_000_000_007;
    private int count(int [] nums, int curr, int n, int max, int min, int target, boolean taken, Map<String, Integer> memo){
        String key = curr + "," + max + "," + min + "," + taken;
        if(memo.containsKey(key)) return memo.get(key);
        if (curr == n) {
            // Only count non-empty subsequences
            int res = (taken && max + min <= target) ? 1 : 0;
            res = res % MOD;
            memo.put(key,res);
            return res;
        }
        int skip = count(nums,curr+1,n,max,min,target,taken, memo);
        int newMax = taken ? Math.max(max, nums[curr]) : nums[curr];
        int newMin = taken ? Math.min(min, nums[curr]) : nums[curr];
        int take = count(nums,curr+1,n,newMax,newMin,target,true, memo);
        int res =  (skip + take) % MOD;
        memo.put(key,res);
        return res;
    }

    public int numSubseq(int[] nums, int target) {
        /**
         lets' start with take skip approch and see .
         */
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int start = 0;
        Map<String, Integer> memo = new HashMap<>();
        return count(nums, 0, n, Integer.MIN_VALUE, Integer.MAX_VALUE, target, false, memo);
        // return answer;
    }

    public static void main(String[] args) {
        NumberofSubsequencesThatSatisfytheGivenSumCondition1498 solver = new NumberofSubsequencesThatSatisfytheGivenSumCondition1498();
        int[] nums1 = {7,10,7,3,7,5,4};
        int target1 = 12;
        System.out.println("Test 1: " + solver.numSubseq(nums1, target1)); // Expected output depends on logic

        int[] nums2 = {3,3,6,8};
        int target2 = 10;
        System.out.println("Test 2: " + solver.numSubseq(nums2, target2)); // Expected output depends on logic

        int[] nums3 = {2,3,3,4,6,7};
        int target3 = 12;
        System.out.println("Test 3: " + solver.numSubseq(nums3, target3)); // Expected output depends on logic

        int[] nums4 = {5,2,4,1,7,6,8};
        int target4 = 16;
        System.out.println("Test 4: " + solver.numSubseq(nums4, target4)); // Expected output depends on logic
    }
}
