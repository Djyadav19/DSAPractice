package LeetCode75.DP1D;

import java.util.Arrays;

public class NthTribonacciNumber1137 {
    public int tribonacci(int n) {

        if( n == 0)return 0;
        if(n < 3) return 1;
        /**
         now lets try using bottom up approch.
         here we need to first define the state.
         so here dp[0] = 0, dp[1] = 1;dp[2] = 1;
         dp[3] = dp[2]+dp[1]+dp[0];
         // instead of using array we can do it by using 4 variables .
         d = c + b + a;
         */
        int a = 0, b = 1, c = 1;
        int d = 0;
        for(int i = 3;i<=n;i++){
            d = c + b + a;
            a = b;
            b = c;
            c = d;
        }
        return d;
        /**
         let's start with recursion and memoization.

         */
        /**
        if( n == 0)return 0;
        if(n < 3) return 1;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        return calculateTribonacci(n, dp);
         */

    }
    private int calculateTribonacci(int n, int[]dp){
        if(n == 0 )return 0;
        if(n == 1|| n == 2) return 1;
        if(dp[n] != -1) return dp[n];
        dp[n] = calculateTribonacci(n-3,dp) + calculateTribonacci(n-2,dp) + calculateTribonacci(n-1,dp);
        return dp[n];
    }

    public static void main(String[] args) {
        NthTribonacciNumber1137 solver = new NthTribonacciNumber1137();
        System.out.println(solver.tribonacci(0)); // Output: 0
        System.out.println(solver.tribonacci(1)); // Output: 1
        System.out.println(solver.tribonacci(2)); // Output: 1
        System.out.println(solver.tribonacci(3)); // Output: 2
        System.out.println(solver.tribonacci(4)); // Output: 4
        System.out.println(solver.tribonacci(25)); // Output: 1389537
    }
}
