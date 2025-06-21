package DP.DP1D;

import java.util.Arrays;

public class FibonacciNumber509 {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int[] dp = new int [n+1];
        dp[0] = 0;
        dp[1] = 1;
        /**
         * now let's try bottoms up approach where we already have value.
         * let's define the state here.
         * dp[0] = 0, dp[1] = 1
         * dp[i] will contains the calculated fibValue for the i th index.
         * dp[2] = dp[1] + dp[0] => 1+0= 1;
         * dp[3] = dp[2] + dp[1] => 1+1 = 2;
         * dp[4] = dp[3] + dp[2] => 2+1 = 3;
         * dp[5] = dp[4] + dp[3] => 3+2 = 5;
         */

        for(int i = 2 ;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
        /*
        so here we are using the recursion and saving the result in on memo. to resue it
        */
        /*
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        return findFibUsingRecursionTopToDownApproch(n, dp);
        */
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
