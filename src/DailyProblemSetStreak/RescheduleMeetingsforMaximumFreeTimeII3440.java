package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.List;

public class RescheduleMeetingsforMaximumFreeTimeII3440 {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        if(startTime.length == 0 || endTime.length == 0) return eventTime;
        List<Integer> ft = new ArrayList<>();
        ft.add(startTime[0]);
        for(int i = 1;i<startTime.length;i++){
            ft.add(startTime[i]-endTime[i-1]);
        }
        ft.add(eventTime-endTime[endTime.length-1]);
        int n = ft.size();
        int []leftMaxFree = new int[n];
        int [] rightMaxFree = new int[n];

        for(int i = n-2;i>=0;i--){
            rightMaxFree[i] = Math.max(rightMaxFree[i+1],ft.get(i+1));
        }
        for(int i = 1;i<n;i++){
            leftMaxFree[i] = Math.max(leftMaxFree[i-1],ft.get(i-1));
        }

        int ans = 0;
        for(int i = 1;i<n;i++){
            int currEventDuration = endTime[i-1]  -startTime[i-1];
            if(currEventDuration <= Math.max(leftMaxFree[i-1],rightMaxFree[i])){
                ans = Math.max(ft.get(i)+ft.get(i-1) + currEventDuration,ans);
            }
            ans = Math.max(ft.get(i) + ft.get(i-1),ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        RescheduleMeetingsforMaximumFreeTimeII3440 solver = new RescheduleMeetingsforMaximumFreeTimeII3440();

        // Simple test case
        int eventTime = 10;
        int[] startTime = {1, 4, 7};
        int[] endTime = {3, 6, 8};
        int result = solver.maxFreeTime(eventTime, startTime, endTime);
        System.out.println("Max Free Time: " + result); // Expected output depends on logic
    }
}
