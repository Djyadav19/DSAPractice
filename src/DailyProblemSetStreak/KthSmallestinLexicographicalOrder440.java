package DailyProblemSetStreak;

import javax.swing.plaf.metal.MetalTheme;
import java.util.*;

public class KthSmallestinLexicographicalOrder440 {

    private int count(long current, long next, int n) {
        int countNumber = 0;
        while(current <= n){
            countNumber += (next-current);
            current *= 10;
            next = Math.min(next*10 ,(long)n+1);
        }
        return countNumber;
    }

    public int findKthNumber(int n, int k) {

        int current = 1;
        k -= 1; // since one is already considered.

        while(k>0){
            int numberCount = count(current,current+1,n);

            if(numberCount <= k){
                current += 1;
                k -= numberCount; // skip the number occured on that branch before jumping to the next branch.
            } else{
                // so we need to go dipper in the tree and will consider one node in our count.
                current *= 10; // to go one leve deep
                k -= 1; // now consider that node and subtract the  from the k.
            }
        }
        return  current;

        /* It will give TLE
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
        */
    }



    public static void main(String [] args){
        KthSmallestinLexicographicalOrder440 solver = new KthSmallestinLexicographicalOrder440();
        System.out.println(solver.findKthNumber(10,3));
    }
}
