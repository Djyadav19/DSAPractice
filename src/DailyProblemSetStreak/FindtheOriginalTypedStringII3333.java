package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindtheOriginalTypedStringII3333 {

    int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        //count the freq.
        int freqCount = 1;
        List<Integer> freqList = new ArrayList<>();
        for(int i = 1;i<word.length();i++){
            if(word.charAt(i) == word.charAt(i-1)){
                freqCount++;
            }else{
                freqList.add(freqCount);
                freqCount = 1;
            }
        }
        freqList.add(freqCount);
        //now find all the possibilites.
        long possibilites = 1;
        for(int freq : freqList){
            possibilites = (possibilites * freq) %MOD;
        }
        if(k <= freqList.size()){
            return (int)possibilites;
        }
        //otherwise we need count all the invalid sceanrios.
        int n= freqList.size();
        int[][] dp = new int[n+1][k+1];
        /**
         * let try bottom up.
         * so here we will take the base case from recursion as state definiation.
         *  so all the value which is greater than k will valid one.
         *  and for row greater than n will have value 1.
         */
        for(int count = k-1;count >= 0;count--){
            dp[n][count] = 1;
        }

        //Now will memic the recursion call for filling the 2dArray.
        for(int i = n-1;i>=0;i--){
            int[] prefix = new int[k+1];
            for(int h = 1;h<=k;h++){ //1 based indexing calculate prefix sum here only .
                prefix[h] = (prefix[h-1]+ dp[i+1][h-1])%MOD;
            }
            for(int count = k-1;count >= 0;count--){
                int l = count+1;
                int r = Math.min(count + freqList.get(i), k - 1);
                if(l<=r){
                    dp[i][count] = (prefix[r+1]-prefix[l]+MOD)%MOD;
                }
            }
        }
        /**
         for(int i = 0;i<freqList.size()+1;i++){
         Arrays.fill(dp[i],-1);
         }

         long invalid = invalidCount(0,0,freqList,k,dp);
         */
        long invalid = dp[0][0];
        return Math.toIntExact((possibilites - invalid + MOD) % MOD);

    }

    private long invalidCount(int curr, int count, List<Integer> freqList, int k, int[][] dp){
        //base case.
        if(curr >= freqList.size()){
            return count<k ? 1:0; // found invalid
        }
        if(dp[curr][count] != -1){
            return dp[curr][count];
        }
        long invalidCount = 0;
        for(int take = 1;take<=freqList.get(curr);take++){
            if(count + take < k){ // invalid count;
                invalidCount = (invalidCount + invalidCount(curr+1,count+take,freqList,k, dp) )%MOD;
            } else{
                break;
            }
        }
        return dp[curr][count] = (int)invalidCount;

    }

    public static void main(String[] args) {
        FindtheOriginalTypedStringII3333 solver = new FindtheOriginalTypedStringII3333();
        // Test case 1
        String word1 = "aabbccdd";
        int k1 = 7;
        System.out.println("Test 1: " + solver.possibleStringCount(word1, k1)); // Expected output depends on logic

        // Test case 2
        String word2 = "aaa";
        int k2 = 2;
        System.out.println("Test 2: " + solver.possibleStringCount(word2, k2)); // Expected output depends on logic

        // Test case 3
        String word3 = "abc";
        int k3 = 1;
        System.out.println("Test 3: " + solver.possibleStringCount(word3, k3)); // Expected output depends on logic

        // Test case 4
        String word4 = "aabbcc";
        int k4 = 4;
        System.out.println("Test 4: " + solver.possibleStringCount(word4, k4)); // Expected output depends on logic
    }
}
