package DailyProblemSetStreak;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaximumNumberofEventsThatCanBeAttended1353 {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events,(int[]a, int[]b)->Integer.compare(a[1],b[1]));
        int count = 0;
        int day = events[0][0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while(!pq.isEmpty() || i < n){
            if(pq.isEmpty()){
                day = events[i][0];
            }
            while(i < n && events[i][0] == day){
                pq.add(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }
            day++;
            if(!pq.isEmpty()  && day > pq.peek()){
                pq.poll();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumNumberofEventsThatCanBeAttended1353 solver = new MaximumNumberofEventsThatCanBeAttended1353();

        int[][] events1 = {{1,2},{2,3},{3,4}};
        System.out.println("Test 1 Output: " + solver.maxEvents(events1) + " (Expected: 3)");

        int[][] events2 = {{1,2},{2,3},{3,4},{1,2}};
        System.out.println("Test 2 Output: " + solver.maxEvents(events2) + " (Expected: 4)");

        int[][] events3 = {{1,4},{4,4},{2,2},{3,4},{1,1}};
        System.out.println("Test 3 Output: " + solver.maxEvents(events3) + " (Expected: 4)");

        int[][] events4 = {{1,1},{1,2},{1,3},{1,4},{1,5}};
        System.out.println("Test 4 Output: " + solver.maxEvents(events4) + " (Expected: 5)");
    }
}
