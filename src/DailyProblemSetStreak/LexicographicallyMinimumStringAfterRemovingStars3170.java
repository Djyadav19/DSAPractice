package DailyProblemSetStreak;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LexicographicallyMinimumStringAfterRemovingStars3170 {

    class Pair {
        char c;
        int idx;
        Pair(char c , int i){
            this.c =c;
            this.idx = i;
        }

    }
    public String clearStars(String s) {

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>((a,b)->{
            if(a.c  == b.c){
                return b.idx - a.idx;
            }
            return a.c - b.c;
        });

        int i = 0;
        char [] charArray = s.toCharArray();
        while(i<s.length()){
            char charAtI = s.charAt(i);
            if(charAtI == '*'){
                if(!priorityQueue.isEmpty()){
                    charArray[priorityQueue.poll().idx] = '*';
                }
                i++;
                continue;
            }
            priorityQueue.add(new Pair(charAtI,i));
            i++;

        }

        i = 0;
        StringBuilder sb = new StringBuilder();
        while (i<s.length()){
            if(charArray[i]!='*')
                sb.append(charArray[i]);
            i++;
        }
        return sb.toString();
    }

    public static void main(String [] args){
        LexicographicallyMinimumStringAfterRemovingStars3170 solver = new LexicographicallyMinimumStringAfterRemovingStars3170();

        System.out.println(solver.clearStars("aaba*"));
    }
}
