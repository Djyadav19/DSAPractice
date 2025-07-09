package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.List;

public class RescheduleMeetingsforMaximumFreeTimeI3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int ans = 0;
        List<Integer> freeTime = new ArrayList<>();
        freeTime.add(startTime[0]);
        for(int i = 1;i<startTime.length;i++){
            freeTime.add(startTime[i] - endTime[i-1]);
        }

        freeTime.add(eventTime-endTime[endTime.length-1]);
        int windowSum = 0;
        for (int i = 0; i < k + 1 && i < freeTime.size(); i++) {
            windowSum += freeTime.get(i);
        }
        ans = windowSum;

        for (int i = k + 1; i < freeTime.size(); i++) {
            windowSum = windowSum - freeTime.get(i - (k + 1)) + freeTime.get(i);
            ans = Math.max(windowSum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        RescheduleMeetingsforMaximumFreeTimeI3439 solver = new RescheduleMeetingsforMaximumFreeTimeI3439();

        int[] startTime5 = {0, 2, 9};
                int[] endTime5 = {1, 4, 10};
                int result5 = solver.maxFreeTime(10, 1, startTime5, endTime5);
                System.out.println("Test 5 Output: " + result5 + " (Expected: 6)");
        int[] startTime4 = {1, 3};
        int[] endTime4 = {2, 5};
        int result4 = solver.maxFreeTime(5, 1, startTime4, endTime4);

        System.out.println("Test 4 Output: " + result4 + " (Expected: ?)");
        int[] startTime1 = {1, 4, 7};
        int[] endTime1 = {3, 6, 9};
        int result1 = solver.maxFreeTime(10, 2, startTime1, endTime1);
        System.out.println("Test 1 Output: " + result1 + " (Expected: 4)");

        int[] startTime2 = {0, 5, 10};
        int[] endTime2 = {2, 7, 12};
        int result2 = solver.maxFreeTime(15, 1, startTime2, endTime2);
        System.out.println("Test 2 Output: " + result2 + " (Expected: 5)");

        int[] startTime3 = {2, 8, 15, 20};
        int[] endTime3 = {5, 10, 18, 25};
        int result3 = solver.maxFreeTime(30, 3, startTime3, endTime3);
        System.out.println("Test 3 Output: " + result3 + " (Expected: 10)");
    }
}
