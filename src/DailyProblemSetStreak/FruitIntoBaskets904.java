package DailyProblemSetStreak;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets904 {

    public int totalFruit(int[] fruits) {
        int ans = 0;

        int i = 0;
        int j= 0;
        Map<Integer,Integer> freq = new HashMap<>();
        while( j < fruits.length){
            freq.put(fruits[j],freq.getOrDefault(fruits[j],0)+1);
            while(freq.size()>2){
                freq.put(fruits[i],freq.get(fruits[i])-1);
                if(freq.get(fruits[i]) == 0){
                    freq.remove(fruits[i]);
                }
                i++;
            }
            j++;
            ans = Math.max(ans, j-i);
        }
        return ans;

    }

    public static void main(String[] args){
        FruitIntoBaskets904 solver  = new FruitIntoBaskets904();
        int[]fruits = new int[]{1,2,3,2,3,3,4,4,4,4,4,4,4,4,3};
        System.out.println(solver.totalFruit(fruits));
    }
}
