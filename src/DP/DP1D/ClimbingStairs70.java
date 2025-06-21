package DP.DP1D;

import java.util.Arrays;

public class ClimbingStairs70 {
    public int climbStairs(int n) {
        int ans = 0;
        int dp[] = new int [n+1];
        Arrays.fill(dp,-1);
        return climbStairsRec(n,dp);
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
        System.out.println(solver.climbStairs(2)); // Expected: 2
        System.out.println(solver.climbStairs(3)); // Expected: 3
        System.out.println(solver.climbStairs(4)); // Expected: 5
        System.out.println(solver.climbStairs(5)); // Expected: 8
    }
}
