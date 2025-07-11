package DailyProblemSetStreak;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIII2402 {

    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<long[]> occupiedRoom = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]) return Long.compare(a[0],b[0]);
            return Long.compare(a[1],b[1]);
        });
        PriorityQueue<long[]> freeRoom = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]) return Long.compare(a[0],b[0]);
            return Long.compare(a[1],b[1]);
        });

        int[] freq = new int [n];
        for(int i = 0;i<n;i++){
            freeRoom.add(new long[]{0,i});
        }
        for(int [] meet : meetings){
            long start = meet[0];
            long end = meet[1];
            while(!occupiedRoom.isEmpty() && occupiedRoom.peek()[0] <= start){
                long[] currRoom = occupiedRoom.poll();
                currRoom[0] = 0;
                freeRoom.offer(currRoom);
            }

            if(!freeRoom.isEmpty()){
                long[]currRoom = freeRoom.poll();
                freq[(int)currRoom[1]]++;
                currRoom[0] = end;
                occupiedRoom.add(currRoom);
            }else{
                long[]currRoom = occupiedRoom.poll();
                freq[(int)currRoom[1]]++;
                currRoom[0] += end-start;
                occupiedRoom.add(currRoom);
            }
        }
        int max = 0;
        int idx =0;
        for(int i = 0 ;i<n;i++){
            if(freq[i] > max){
                max = freq[i];
                idx = i;
            }
        }
        return idx;
    }
}
