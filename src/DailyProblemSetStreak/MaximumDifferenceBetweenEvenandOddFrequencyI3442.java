package DailyProblemSetStreak;

import java.util.Arrays;

public class MaximumDifferenceBetweenEvenandOddFrequencyI3442 {

    public int maxDifference(String s) {

        int n = s.length();
        int[] occuranceCount = new int[26];
        int minEven= Integer.MAX_VALUE,maxOdd = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int currentCount = ++occuranceCount[s.charAt(i)-'a'];
            if(currentCount%2 == 0){
                if(currentCount < minEven && currentCount != 0){
                    minEven = currentCount;
                }
            }else{
                if(currentCount > maxOdd){
                    maxOdd = currentCount;
                }
            }
        }
        return (maxOdd - minEven);
        /*
        for(int i = 0;i<26;i++){
            if(occuranceCount[i]%2 == 0){
                if(occuranceCount[i] < minEven && occuranceCount[i] != 0){
                    minEven = occuranceCount[i];
                }
            }else{
                if(occuranceCount[i] > maxOdd){
                    maxOdd = occuranceCount[i];
                }
            }
        }*/

    }

    public static void main(String[] args){
        MaximumDifferenceBetweenEvenandOddFrequencyI3442 solver = new MaximumDifferenceBetweenEvenandOddFrequencyI3442();
        System.out.println(solver.maxDifference("aaaaabbc"));
    }
}
