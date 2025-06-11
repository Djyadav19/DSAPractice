package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDifferenceBetweenEvenandOddFrequencyII3445 {

    private int getState(int count_a, int count_b) {
        int parity_a = count_a % 2;
        int parity_b = count_b % 2;

        if (parity_a == 0 && parity_b == 0) return 0; // even even
        if (parity_a == 0 && parity_b == 1) return 1; // even odd
        if (parity_a == 1 && parity_b == 0) return 2; // odd even
        return 3; // odd odd
    }

    /*

     */
    public int maxDifference(String s, int k) {
        int n = s.length();
        int result = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                int[] stateMinPrev_a_b = new int[4];
                Arrays.fill(stateMinPrev_a_b, Integer.MAX_VALUE);

                int count_a = 0;
                int count_b = 0;

                int prev_a = 0;
                int prev_b = 0;

                int l = -1;
                int r = 0;

                while (r < n) {
                    count_a += (s.charAt(r) == a) ? 1 : 0;
                    count_b += (s.charAt(r) == b) ? 1 : 0;

                    while (r - l >= k && count_b - prev_b >= 2 && count_a - prev_a >= 1) {
                        int leftState = getState(prev_a, prev_b);
                        stateMinPrev_a_b[leftState] = Math.min(stateMinPrev_a_b[leftState], prev_a - prev_b);

                        l++;
                        if (s.charAt(l) == a) prev_a++;
                        if (s.charAt(l) == b) prev_b++;
                    }

                    int rightState = getState(count_a, count_b);
                    int bestLeftState = rightState ^ 2;
                    int bestMinDiffValueLeft = stateMinPrev_a_b[bestLeftState];

                    if (bestMinDiffValueLeft != Integer.MAX_VALUE) {
                        result = Math.max(result, (count_a - count_b) - bestMinDiffValueLeft);
                    }

                    r++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        MaximumDifferenceBetweenEvenandOddFrequencyII3445 solver = new MaximumDifferenceBetweenEvenandOddFrequencyII3445();
        String s = "1122211";
        int k = 3;
        System.out.println(solver.maxDifference(s,k));
        s = "2222130";
        k = 2;
        System.out.println(solver.maxDifference(s,k));
        s = "2421";
        k = 1;
        System.out.println(solver.maxDifference(s,k));
        s = "02401";
        k = 3;
        System.out.println(solver.maxDifference(s,k));
        s = "330130303114333";
        k =13;
        System.out.println(solver.maxDifference(s,k));
    }

    /*
    TLE
    public int maxDifference(String s, int k) {


        So here we need a shrinking window till the size k. // or we can increase from 4 to max.
        then in the substring we need to find the even and odd freq and their differnce.

        int n = s.length();
        int windowSize = n;
        List<String> allSubstrings = new ArrayList<>();
        int ans = Integer.MIN_VALUE;
        while(windowSize >= k){
            if(ans > windowSize){
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
*/
}
