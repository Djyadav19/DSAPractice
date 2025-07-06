package DP.DP2D;

import java.util.Arrays;

public class LongestStringChain1048 {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(),b.length()));
        int[][] dp = new int[words.length+1][words.length];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,-1,words,dp);

    }

    private int solve(int curr, int prev, String[] words, int[][] dp){
        if(curr > words.length-1){
            return 0;
        }
        if(prev != -1 && dp[curr][prev] != -1) return dp[curr][prev];
        int take = 0;
        if(prev == -1 || isPredecessor(words[prev],words[curr])){
            take = 1 + solve(curr+1,curr,words, dp);
        }

        int skip = solve(curr+1,prev,words, dp);
        if(prev != -1)
            dp[curr][prev] = Math.max(take,skip);
        return Math.max(take,skip);
    }

    private boolean isPredecessor(String prev, String curr){
        int n = prev.length();
        int m = curr.length();
        if(n>m || m-n != 1){
            return false;
        }
        int i = 0,j =0;
        while(i < n && j<m){
            if(prev.charAt(i) == curr.charAt(j))
                i++;
            j++;
        }
        return i==n;
    }


    public static void main(String[] args) {
        LongestStringChain1048 solver = new LongestStringChain1048();

        String[] words1 = {"a","b","ba","bca","bda","bdca"};
        System.out.println(solver.longestStrChain(words1)); // Expected: 4

        String[] words2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(solver.longestStrChain(words2)); // Expected: 5

        String[] words3 = {"abcd","dbqca"};
        System.out.println(solver.longestStrChain(words3)); // Expected: 1

        String[] words4 = {"a","ab","ac","bd","abc","abd","abdd"};
        System.out.println(solver.longestStrChain(words4)); // Expected: 4
    }

}
