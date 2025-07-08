package DailyProblemSetStreak;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberofEventsThatCanBeAttendedII1751 {

    private int bs(int[][]events,int curr){
        int l = curr+1;
        int r = events.length-1;
        int res = events.length; // if didn't find any then will return the end of the events
        while(l<=r){
            int mid = l + (r-l)/2;
            if(events[mid][0] > events[curr][1]){
                res = mid;
                r = mid -1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }

    private int solve(int curr, int[][] events, int k, Map<String, Integer> memo) {
        if (curr >= events.length || k == 0) return 0;
        String key = curr + "," + k;
        if (memo.containsKey(key)) return memo.get(key);

        int next = bs(events,curr);
        int take =events[curr][2] + solve(next, events, k - 1, memo);
        int skip = solve(curr + 1, events, k, memo);

        int res = Math.max(take, skip);
        memo.put(key, res);
        return res;
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        Map<String, Integer> memo = new HashMap<>();
        return solve(0,events, k, memo);
    }

    public static void main(String[] args) {
        MaximumNumberofEventsThatCanBeAttendedII1751 solver = new MaximumNumberofEventsThatCanBeAttendedII1751();
        int[][] events = {
            {1, 2, 4},
            {3, 4, 3},
            {2, 3, 1}
        };
        int k = 2;
        int result = solver.maxValue(events, k);
        System.out.println();
        System.out.println("Expected output: 7  Actual output: " + result);
    }

}
