package DailyProblemSetStreak;

import java.util.*;

public class RearrangingFruits2561 {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> freq = new HashMap<>();
        int minEle = Integer.MAX_VALUE;
        for(int i : basket1){
            freq.put(i,freq.getOrDefault(i,0)+1);
            minEle = Math.min(i,minEle);
        }
        for(int i : basket2){
            freq.put(i,freq.getOrDefault(i,0)-1);
            minEle = Math.min(i,minEle);
        }
        List<Integer> extras  = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(entry.getValue() == 0) continue;
            if(entry.getValue() %2 != 0) return -1;
            for(int i = 1;i<=Math.abs(entry.getValue())/2;i++){
                extras.add(entry.getKey());
            }
        }
        Collections.sort(extras);
        long result = 0;
        //now take half of list as ans considering indirect swap.
        for(int i = 0;i<extras.size()/2;i++){
            result += Math.min(extras.get(i),2*minEle);
        }
        return result;

    }

    public static void main(String[] args){
        int[] basket1 = {4,2,2,2};
        int [] basket2 = {1,4,1,2};
        RearrangingFruits2561 solver = new RearrangingFruits2561();
        System.out.println(solver.minCost(basket1,basket2));
    }

}
