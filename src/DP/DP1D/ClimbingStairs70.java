package DP.DP1D;

import java.util.Arrays;

public class ClimbingStairs70 {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int ans = 0;
        int[] dp = new int [n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        /**
         * now lets start the bottom up approach .
         * here we will first define the state so dp[i] will contain the ways to reach to that steps.
         * let's start from  0 .
         * dp[0] = 0, dp[1] = 1, dp[2] = 2.
         * dp[3] = d
         */
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];


        /**
         * here is the climbStair top to bottom approach
         * here we need to think to write for the first case and then will use recursion.
         * will use dp array to store the calculated sub problems.
         */
        //Arrays.fill(dp,-1);
        //return climbStairsRec(n,dp);
    }

    private int climbStairsRec(int n ,int[] dp){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        //one steps.
        int ansFrom1steps = climbStairsRec(n-1,dp);
        //two steps
        int ansFrom2Steps= climbStairsRec(n-2,dp);
        dp[n] = ansFrom1steps+ansFrom2Steps;
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs70 solver = new ClimbingStairs70();
        //System.out.println(solver.climbStairs(2)); // Expected: 2
        //System.out.println(solver.climbStairs(3)); // Expected: 3
        //System.out.println(solver.climbStairs(4)); // Expected: 5
        System.out.println(solver.climbStairs(5)); // Expected: 8
    }
}
