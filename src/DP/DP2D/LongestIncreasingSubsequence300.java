package DP.DP2D;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        /**
         * let's go for bottom up now.
         * So we need to define a state : so dp[i] will contains the max value of what can be generated for the ith index.
         * initially, we can see that if index is take as LIS the count will be one.
         * dp array will be initialized with 1.
         * now will iterate upto n and will see that if we can take dp[i] = Math.max(dp[j] + 1,dp[i]);
         * and will update the ans accordingly.
         */
        int [] dp = new int [n];
        Arrays.fill(dp,1);
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int j = 0;
            while(j<i){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    ans = Math.max(ans,dp[i]);
                }
                j++;
            }
        }
        return ans;
        /**
        int[][] dp = new int[n][n+1];
        for(int [] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, -1,nums,dp);
         */
    }

    private int solve(int curr, int prevIdx, int[] nums, int[][] dp) {
        if(curr > nums.length-1){
            return 0;
        }
        if(dp[curr][prevIdx+1] != -1) return dp[curr][prevIdx+1];
        int take = 0;
        if(prevIdx == -1 || nums[curr] > nums[prevIdx]){
            take = 1 + solve(curr+1,curr,nums,dp);
        }
        int skip = solve(curr+1, prevIdx,nums,dp);
        dp[curr][prevIdx+1] = Math.max(skip,take);
        return dp[curr][prevIdx+1];
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence300 lis = new LongestIncreasingSubsequence300();
        int[] nums = {0,1,0,3,2,3};
        int result = lis.lengthOfLIS(nums);
        System.out.println("Length of LIS: " + result);
    }
}
