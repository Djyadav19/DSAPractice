package DP.DP1D;

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
         * now let's start with the bottom up approach for this .
         * here we have to first define a state dp[] array.
         * dp[] i  mean the max amount a thief have stolen till the house i th.
         * again he will have two scnearios one is to steal or not .
         * if he steal then profit from the ith index will also be added to the dp[i] and will jump the value.
         * other wise only the last max of dp[i] will be considered.
         * dp[0] = nums[0];
         * dp[1] = Math.max(nums[0],nums[1]);.
         *
         */
                //take from the first index.

        int maxWhen1stIndexTaken = bottomUp(nums,0,n-2);
        int maxWhenLastIndexTaken = bottomUp(nums,1,n-1);
        return Math.max(maxWhenLastIndexTaken,maxWhen1stIndexTaken);



        /**
         let's go with recursion approch first.
         */

        /**
         *

        int total = 0;
        int[]dp = new int[n];
        Arrays.fill(dp,-1);
        //consider he is going to rob the 0th house.
        int byTaking1st = robHouse(nums,0,n-1,dp);
        Arrays.fill(dp,-1);
        int byTakingLastIndex = robHouse(nums,1,n,dp);
        return Math.max(byTaking1st,byTakingLastIndex);
         */
    }

    private int bottomUp(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int prev1 = nums[start];
        int prev2 = 0;

        for(int i = start+1;i<=end;i++){
            //again we will have take or skip.
            int take = nums[i] + prev2;
            int skip = prev1;
            int temp = Math.max(take,skip);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
            HouseRobberII213 solver = new HouseRobberII213();

            // Corner case: only one house
            System.out.println(solver.rob(new int[]{5})); // Expected: 5

            // Corner case: two houses
            System.out.println(solver.rob(new int[]{1,2, 3,1})); // Expected: 3

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
