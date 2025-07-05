package DP.DP1D;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int [] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, -1,nums,dp);
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
