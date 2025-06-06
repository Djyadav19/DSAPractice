package DailyProblemSetStreak;

import java.util.Stack;

public class UsingaRobottoPrinttheLexicographicallySmallestString2434 {
    public String robotWithString(String s) {

        int n = s.length();
        char[] minCharArray = new char[n];
        StringBuilder answer = new StringBuilder();
        minCharArray[n-1] = s.charAt(n-1);
        for(int i = n-2;i>=0;i--){
            minCharArray[i] = (char) Math.min(s.charAt(i), minCharArray[i + 1]);
        }
        Stack<Character> t = new Stack<>();
        for(int i = 0;i<n;i++){
            t.push(s.charAt(i));
            char minNextChar  = i+1 < n? minCharArray[i+1]: s.charAt(i);
            while( !t.isEmpty() && minNextChar >= t.peek()){
                answer.append(t.pop());
            }
        }
        while(!t.isEmpty()){
            answer.append(t.pop());
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        UsingaRobottoPrinttheLexicographicallySmallestString2434 solver = new UsingaRobottoPrinttheLexicographicallySmallestString2434();
        System.out.println(solver.robotWithString("bac"));  // Output: abc
        System.out.println(solver.robotWithString("bdda")); // Output: addb

        System.out.println(solver.robotWithString("zza"));  // Output: azz
    }
}
