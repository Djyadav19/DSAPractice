package DailyProblemSetStreak;

import java.util.Arrays;
import java.util.Comparator;

public class FindSubsequenceofLengthKWiththeLargestSum2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        /*using greedy.
            first sort the array in desc and also maintain the index.
            now copy the k element to another array .
            now sort it again on the basis of index.
            now return the sorted array value in a new array .
         */
        int n = nums.length;
        int[][] sortedNumsWithIdx = new int[n][2];

        for(int i = 0;i<n;i++){
            sortedNumsWithIdx[i][0] = nums[i];
            sortedNumsWithIdx[i][1] = i;
        }

        Arrays.sort(sortedNumsWithIdx,(a, b)->Integer.compare(b[0],a[0]));
        int[][] topKEle = Arrays.copyOfRange(sortedNumsWithIdx,0,k);
        //again sort on basis of index
        Arrays.sort(topKEle, Comparator.comparingInt(a -> a[1]));
        int[] answer = new int[k];
        for(int i = 0;i<k;i++){
            answer[i] = topKEle[i][0];
        }
        return answer;

    }

    public static void main(String[] args) {
        FindSubsequenceofLengthKWiththeLargestSum2099 solver = new FindSubsequenceofLengthKWiththeLargestSum2099();
        int[] nums = {2, 1, 3, 3};
        int k = 2;
        int[] result = solver.maxSubsequence(nums, k);
        System.out.println(Arrays.toString(result)); // Example output: [3, 3]
    }
}
