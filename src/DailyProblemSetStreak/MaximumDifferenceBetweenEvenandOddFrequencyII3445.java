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
            if(ans >= windowSize){
                break;
            }
            for(int i = 0; i + windowSize <= n;i++){
                String subs = s.substring(i,i+windowSize);
                ans = Math.max(calculateMaxDiffOfThisSubString(subs),ans);
            }
            windowSize--;
        }
        return ans != Integer.MIN_VALUE ? ans : -1;
    }

    private int calculateMaxDiffOfThisSubString(String subs) {
        int[]freqCount = new int[5];// since in constraint it's given s only contains 0 to 4.
        int minEven= Integer.MAX_VALUE,maxOdd = Integer.MIN_VALUE;
        for(int i = 0;i<subs.length();i++){
            freqCount[subs.charAt(i)-'0']++;

        }
        for(int i =0;i<5;i++){
            int currentFreq = freqCount[i];
            if( currentFreq != 0 && currentFreq % 2 == 0){
                minEven = Math.min(minEven,currentFreq);
            }else{
                maxOdd = Math.max(maxOdd,currentFreq);
            }
        }
        return maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE ?Integer.MIN_VALUE:maxOdd-minEven;
    }

    public static void main(String[] args){
        MaximumDifferenceBetweenEvenandOddFrequencyII3445 solver = new MaximumDifferenceBetweenEvenandOddFrequencyII3445();
        String s = "1122211";
        int k = 3;
        //System.out.println(solver.maxDifference(s,k));
        s = "2222130";
        k = 2;
        //System.out.println(solver.maxDifference(s,k));
        s = "2421";
        k = 1;
        //System.out.println(solver.maxDifference(s,k));
        s = "02401";
        k = 3;
        //System.out.println(solver.maxDifference(s,k));
        s = "330130303114333";
        k =13;
        System.out.println(solver.maxDifference(s,k));
    }
}
