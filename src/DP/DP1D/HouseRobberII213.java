package DP.DP1D;

import java.util.Arrays;

public class HouseRobberII213 {

    private int robHouse(int[] nums, int i,int n,int[] dp){
        if(i > n-1) return 0;
        // here we will have two scenarios either to steal or to skip.
        if(dp[i] > -1 && dp[i] > nums[i]) return dp[i];
        int steal = nums[i]+ robHouse(nums, i+2,n,dp);
        int skip = robHouse(nums,i+1,n,dp);
        dp[i] =  Math.max(steal,skip);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        /**
         let's go with recursion approch first.
         */

        int total = 0;
        int[]dp = new int[n];
        Arrays.fill(dp,-1);
        //consider he is going to rob the 0th house.
        int byTaking1st = robHouse(nums,0,n-1,dp);
        Arrays.fill(dp,-1);
        int byTakingLastIndex = robHouse(nums,1,n,dp);
        return Math.max(byTaking1st,byTakingLastIndex);
    }

    public static void main(String[] args) {
            HouseRobberII213 solver = new HouseRobberII213();

            // Corner case: only one house
            System.out.println(solver.rob(new int[]{5})); // Expected: 5

            // Corner case: two houses
            System.out.println(solver.rob(new int[]{1,2, 3})); // Expected: 3

            // Corner case: three houses
            System.out.println(solver.rob(new int[]{2, 3, 2})); // Expected: 3

            // All houses have the same value
            System.out.println(solver.rob(new int[]{1, 1, 1, 1})); // Expected: 2

            // Large values
            System.out.println(solver.rob(new int[]{100, 1, 1, 100})); // Expected: 100

            // Increasing values
            System.out.println(solver.rob(new int[]{1, 2, 3, 4, 5})); // Expected: 8

            // Decreasing values
            System.out.println(solver.rob(new int[]{5, 4, 3, 2, 1})); // Expected: 8

            // Alternate high and low
            System.out.println(solver.rob(new int[]{2, 7, 9, 3, 1})); // Expected: 11

            // All zeros
            System.out.println(solver.rob(new int[]{0, 0, 0, 0})); // Expected: 0

            // Empty array (should handle gracefully, though not in original code)
            try {
                System.out.println(solver.rob(new int[]{})); // Expected: 0 or error
            } catch (Exception e) {
                System.out.println("Handled empty array: " + e.getMessage());
            }
        }
}
