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
        /**
         * here again let' try to solve using bottom up.
         * As we need to define the state of dp[i] : It means the largest chain till that index.
         * will iterate upto n and update dp[i] on the condition if pairs[i-1][1] < pairs[i][0].
         * And first we need to sort the pairs on the first index.
         */
        Arrays.sort(pairs, new Comparator<int[]> (){
            @Override
            public int compare (int[] arr1 , int[] arr2){
                return Integer.compare(arr1[0],arr2[0]);
            }
        });
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        int ans = 0;
        for(int i = 0;i<n;i++){
            int j = 0;
            while(j<i){
                if(pairs[j][1]< pairs[i][0]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    ans = Math.max(ans,dp[i]);
                }
                j++;
            }
        }
        return ans;


        /**
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
         */
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
