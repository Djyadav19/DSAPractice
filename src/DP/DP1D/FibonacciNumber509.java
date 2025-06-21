package DP.DP1D;

import java.util.Arrays;

public class FibonacciNumber509 {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int[] dp = new int [n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        return findFibUsingRecursionTopToDownApproch(n, dp);
        //return dp[n];
    }

    private int findFibUsingRecursionTopToDownApproch(int n, int[] dp) {
        if(n == 0 || n == 1) return n;
        if(dp[n] != -1 ) return dp[n];
        dp[n] = findFibUsingRecursionTopToDownApproch(n-1,dp)+findFibUsingRecursionTopToDownApproch(n-2,dp);
        return dp[n];
    }

    /**
     * here normal fibonacci call using recursion.

    if(n == 0) return 0;
    if(n == 1) return 1;
    return fib(n-1)+fib(n-2);
     */

    public static void main(String[] args) {
        FibonacciNumber509 fibObj = new FibonacciNumber509();
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fibObj.fib(n));
    }
}
