package DP.DP1D;

import java.util.Arrays;

public class MaximumAlternatingSubsequenceSum1911 {
    public long maxAlternatingSum(int[] nums) {
        long answer = 0;
        int n = nums.length;
        int i = 0;
        boolean isEven = true;
        long[][] dp = new long[n+1][2];
        for(int j=0;j<=n;j++){
            Arrays.fill(dp[j],-1);

        }
        dp[0][0]=nums[i];
        answer = findMax(nums,i,isEven,n,dp);
        return answer;
    }


    private long findMax(int[]nums,int idx,boolean isEven,int n,long[][]dp){
        if(idx > n-1) return 0;
        if(dp[idx][isEven?1:0] != -1) return dp[idx][isEven?1:0];
        // either we will take it or skip.
        // if we skip then we will just call this method again by increasing index.
        // if we take then we need to update isEven index since it will increase the index.
        // will need to add that value to the answer.
        long skip = findMax(nums,idx+1,isEven,n,dp);
        long value = nums[idx];
        if(!isEven){
            value = -value;
        }
        long take = value + findMax(nums,idx+1,!isEven,n,dp);
        dp[idx][isEven?1:0] = Math.max(skip,take);
        return dp[idx][isEven?1:0];
    }

    public static void main(String[] args) {
        MaximumAlternatingSubsequenceSum1911 solver = new MaximumAlternatingSubsequenceSum1911();

        // Test case 1: Regular case
        int[] nums1 = {4,2,5,3};
        System.out.println("Test 1: " + solver.maxAlternatingSum(nums1)); // Expected: 7

        // Test case 2: All elements are the same
        int[] nums2 = {1,1,1,1};
        System.out.println("Test 2: " + solver.maxAlternatingSum(nums2)); // Expected: 1

        // Test case 3: Single element (corner case)
        int[] nums3 = {10};
        System.out.println("Test 3: " + solver.maxAlternatingSum(nums3)); // Expected: 10

        // Test case 4: Empty array (corner case)
        int[] nums4 = {};
        System.out.println("Test 4: " + solver.maxAlternatingSum(nums4)); // Expected: 0

        // Test case 5: Decreasing sequence
        int[] nums5 = {10, 9, 8, 7};
        System.out.println("Test 5: " + solver.maxAlternatingSum(nums5)); // Expected: 10
    }
}
