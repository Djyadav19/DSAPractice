package DailyProblemSetStreak;

import java.util.Arrays;

public class MaximumNumberofEventsThatCanBeAttendedII1751 {

    private int solve(int curr, int prev, int[][] events, int k, int[][][] dp) {
        if (curr >= events.length || k == 0) return 0;
        if (dp[curr][prev + 1][k] != -1) return dp[curr][prev + 1][k];

        int take = 0;
        if (prev == -1 || events[prev][1] < events[curr][0]) {
            take = events[curr][2] + solve(curr + 1, curr, events, k - 1, dp);
        }
        int skip = solve(curr + 1, prev, events, k, dp);

        dp[curr][prev + 1][k] = Math.max(take, skip);
        return dp[curr][prev + 1][k];
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[][][] dp = new int[n][n + 1][k + 1];
        for (int[][] arr2d : dp)
            for (int[] arr1d : arr2d)
                Arrays.fill(arr1d, -1);
        return solve(0, -1, events, k, dp);
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
