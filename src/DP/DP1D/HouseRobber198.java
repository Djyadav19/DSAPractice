package DP.DP1D;

import java.util.Arrays;

public class HouseRobber198 {
    public int rob(int[] nums) {
        if(nums.length == 1 || nums.length == 0) return 0;
        if(nums.length == 2 ) return Math.max(nums[0],nums[1]);
        /**
         * So here we have a robber, he can't rob two adjacent house.
         * so he will have two choice either to rob the house and keep the profit or skip the house.
         * so if he robbed a house then he must need to leave the just next house
         * he can have option next to that.
         */
        /**
         * Now let's try Bottoms up approch.
         * so let's create a state of defination will create a dp[] of size nums.length+1;
         * so let's start for the value what we have.
         * dp[i] = Max stolen till the i th house.
         * dp[0] = 0;
         * dp[1] = nums[0];
         * dp[2] = max(nums[1],nums[0])
         * dp[3] = again two condition now either he steal or skip.
         *  In case of steal = dp[i-2]  + nums[i-1];
         *  In case of skip = dp[i-1]
         *  so dp[3] = Max(steal,skip).
         */
        int[]dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[1],nums[0]);
        for( int i = 3;i<=nums.length;i++){
            int steal = dp[i-2] + nums[i-1]; // so last from dp and the current house money.
            int skip = dp[i-1]; // here it will take just take the last index money as.
            dp[i] = Math.max(steal,skip);
        }
        return dp[nums.length];

        /**
         * let's try using Brute force approch.
         */
        /**
        int i = 1;
        int [] dp = new int [nums.length+1];
        Arrays.fill(dp,-1);
        return robByRecursion(i,nums,dp);
         *
         */

    }
    private int robByRecursion(int i, int[] nums,int[]dp) {
        if(i > nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int steal = robByRecursion(i + 2,nums,dp) + nums[i-1];
        int skip = robByRecursion(i + 1, nums,dp);
        dp[i] = Math.max(steal,skip);
        return dp[i];
    }

    public static void main(String[] args) {
        HouseRobber198 robber = new HouseRobber198();
        int[] test1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + robber.rob(test1)); // Expected: 4

        int[] test2 = {2, 7, 9, 3, 1};
        System.out.println("Test 2: " + robber.rob(test2)); // Expected: 12

        int[] test3 = {2, 1, 1, 2};
        System.out.println("Test 3: " + robber.rob(test3)); // Expected: 4

        int[] test4 = {5};
        System.out.println("Test 4: " + robber.rob(test4)); // Expected: 5

        int[] test5 = {};
        System.out.println("Test 5: " + robber.rob(test5)); // Expected: 0
    }
}
