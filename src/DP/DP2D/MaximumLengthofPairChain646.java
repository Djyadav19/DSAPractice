package DP.DP2D;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain646 {
    private int solve(int curr, int prevIndex, int[][] pairs,int[][]dp){
        if(curr > pairs.length-1){
            return 0;
        }
        if(dp[curr][prevIndex+1] != -1) return dp[curr][prevIndex+1];
        int take = 0;
        if (prevIndex == -1 || pairs[prevIndex][1] < pairs[curr][0]){
            take = 1 + solve(curr+1,curr,pairs,dp);
        }
        int skip = solve(curr+1,prevIndex,pairs,dp);
        dp[curr][prevIndex + 1] = Math.max(take, skip);
        return dp[curr][prevIndex+1];
    }
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                return Integer.compare(arr1[0],arr2[0]);
            }
        });
        int[][]dp = new int[n+1][n];
        //int prevIndex = -1//pairs[0][1];
        for(int [] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0,-1,pairs,dp);

    }

    public static void main(String[] args) {
        MaximumLengthofPairChain646 solver = new MaximumLengthofPairChain646();
        int[][] test1 = {{1,2}, {2,3}, {3,4}};
        int[][] test2 = {{1,2}, {7,8}, {4,5}};
        int[][] test3 = {{5,24},{15,25},{27,40},{50,60}};
        System.out.println(solver.findLongestChain(test1)); // Expected: 2
        System.out.println(solver.findLongestChain(test2)); // Expected: 3
        System.out.println(solver.findLongestChain(test3)); // Expected: 3
    }
}
