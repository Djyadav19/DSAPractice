package DailyProblemSetStreak;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaxDifferenceYouCanGetFromChanginganInteger1432 {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        char x = 0;
        char y = s.charAt(0);

        char forMin = '1';
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)!='9'){
                x = s.charAt(i);
                break;
            }
        }
        if(y == '1'){
            for(int i = 1;i<s.length();i++){
                if(s.charAt(i)!='0' && s.charAt(i)!='1'){
                    y = s.charAt(i);
                    forMin = '0';
                    break;
                }
            }
        }
        return Integer.parseInt(s.replace(x, '9')) - Integer.parseInt(s.replace(y,forMin));
    }

    public static void main(String[]args){
        MaxDifferenceYouCanGetFromChanginganInteger1432 solver = new MaxDifferenceYouCanGetFromChanginganInteger1432();
        System.out.println(solver.maxDiff(123456));
    }
}
