package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers386 {

    private void constructNumber(int currentNumber, int n, List<Integer> answer) {
        if(currentNumber>n){
            return;
        }
        answer.add(currentNumber);
        for(int append = 0;append<=9;append++){
            int number = currentNumber*10 + append;
            constructNumber(number,n,answer);
        }
    }
    public List<Integer> lexicalOrder(int n) {

        List<Integer> answer = new ArrayList<>();
        for(int i = 1;i<=9;i++){
            constructNumber(i,n,answer);
        }

        return answer;
        /*
        List<Integer> answer = new ArrayList<>();
        for(int i = 0;i<n;i++){
            answer.add(i);
        }
        Collections.sort(answer, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return answer;*/
    }



    public static void main(String[] args){
        LexicographicalNumbers386 solver  = new LexicographicalNumbers386();
        System.out.println(solver.lexicalOrder(13));
    }
}
