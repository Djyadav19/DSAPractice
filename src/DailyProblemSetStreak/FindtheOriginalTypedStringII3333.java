package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindtheOriginalTypedStringII3333 {

    int MOD = 1_000_000_007;
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
    public int possibleStringCount(String word, int k) {
        //count the freq.
        int count = 1;
        List<Integer> freqList = new ArrayList<>();
        for(int i = 1;i<word.length();i++){
            if(word.charAt(i) == word.charAt(i-1)){
                count++;
            }else{
                freqList.add(count);
                count = 1;
            }
        }
        freqList.add(count);
        //now find all the possibilites.
        long possibilites = 1;
        for(int freq : freqList){
            possibilites = (possibilites * freq) %MOD;
        }
        if(k <= freqList.size()){
            return (int)possibilites;
        }
        //otherwise we need count all the invalid sceanrios.
        int[][] dp = new int[freqList.size()+1][k+1];
        for(int i = 0;i<freqList.size()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        long invalid = invalidCount(0,0,freqList,k,dp);
        return Math.toIntExact((possibilites - invalid + MOD) % MOD);

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
