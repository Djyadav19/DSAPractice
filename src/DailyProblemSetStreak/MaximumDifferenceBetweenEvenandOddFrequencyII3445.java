package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.List;

public class MaximumDifferenceBetweenEvenandOddFrequencyII3445 {

    public int maxDifference(String s, int k) {

        /*
        So here we need a shrinking window till the size k. // or we can increase from 4 to max.
        then in the substring we need to find the even and odd freq and their differnce.
         */
        int n = s.length();
        int windowSize = n;
        List<String> allSubstrings = new ArrayList<>();
        int ans = Integer.MIN_VALUE;
        while(windowSize >= k){
            for(int i = 0; i + windowSize <= n;i++){
                String subs = s.substring(i,i+windowSize);
                ans = Math.max(calculateMaxDiffOfThisSubString(subs),ans);
            }
            windowSize--;
        }
        return ans;
    }

    private int calculateMaxDiffOfThisSubString(String subs) {

        int[]freqCount = new int[5];// since in constraint it's given s only contains 0 to 4.
        int minEven= Integer.MAX_VALUE,maxOdd = Integer.MIN_VALUE;
        for(int i = 0;i<subs.length();i++){
            int currentFreq = ++freqCount[subs.charAt(i)-'0'];
            if(currentFreq % 2 == 0){
                minEven = Math.min(minEven,currentFreq);
            }else{
                maxOdd = Math.max(maxOdd,currentFreq);
            }
        }
        return maxOdd-minEven;
    }

    public static void main(String[] args){
        MaximumDifferenceBetweenEvenandOddFrequencyII3445 solver = new MaximumDifferenceBetweenEvenandOddFrequencyII3445();
        String s = "1122211";
        int k = 3;
       System.out.println(solver.maxDifference(s,k));
        s = "2222130";
        k = 2;
        System.out.println(solver.maxDifference(s,k));
    }
}
