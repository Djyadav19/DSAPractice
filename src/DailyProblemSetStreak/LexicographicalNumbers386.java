package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers386 {

    public List<Integer> lexicalOrder(int n) {

        List<Integer> answer = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            answer.add(i);
        }
        Collections.sort(answer, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return answer;
    }

    public static void main(String[] args){
        LexicographicalNumbers386 solver  = new LexicographicalNumbers386();
        System.out.println(solver.lexicalOrder(20));
    }
}
