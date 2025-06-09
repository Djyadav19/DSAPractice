package DailyProblemSetStreak;

import java.util.*;

public class KthSmallestinLexicographicalOrder440 {
    public int findKthNumber(int n, int k) {

        List<Integer>array = new ArrayList<>();

        for(int i = 1;i<=n;i++){
            array.add(i);
        }
        Collections.sort(array,new Comparator<Integer>(){
            @Override
            public int compare(Integer i1,Integer i2){
                return i1.toString().compareTo(i2.toString());
            }
        });
        return array.get(k-1);
    }

    public static void main(String [] args){
        KthSmallestinLexicographicalOrder440 solver = new KthSmallestinLexicographicalOrder440();
        System.out.println(solver.findKthNumber(10,3));
    }
}
