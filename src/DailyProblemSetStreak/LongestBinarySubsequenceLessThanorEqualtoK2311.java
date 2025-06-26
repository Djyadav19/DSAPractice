package DailyProblemSetStreak;

import java.util.Arrays;

public class LongestBinarySubsequenceLessThanorEqualtoK2311 {
    public int longestSubsequence(String s, int k) {

        /**
         * here we are using recursion and memoization.
         * using the dp[] array. .
         */
        int n = s.length();
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        //dp[n-1] = 0;
        return solveUsingRecurssion(s,n,n-1,k,dp);
    }

    private int solveUsingRecurssion(String s, int n, int i, int k, int[] dp){
        //here we will have two scenarios either we take the element or skip the element.
        // if after taking the element the size > k return 0, if after taking < k then we will add it to the ans.
        // if n < 0 return.
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i];
        int value = (int) (Integer.parseInt(String.valueOf(s.charAt(i))) * Math.pow(2,n-i-1));
        int take = 0;
        if(value<=k){
            take = 1 + solveUsingRecurssion(s,n,i-1,k-value, dp);
        }
        int skip = solveUsingRecurssion(s,n,i-1,k, dp);
        dp[i]= Math.max(take,skip);
        return dp[i];
    }

    public static void main(String[] args) {
        LongestBinarySubsequenceLessThanorEqualtoK2311 solver = new LongestBinarySubsequenceLessThanorEqualtoK2311();
        String s = "1001010";
        int k = 5;
        int result = solver.longestSubsequence(s, k);
        System.out.println("Longest subsequence length: " + result);
    }
}
