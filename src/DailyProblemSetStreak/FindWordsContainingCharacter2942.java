package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindWordsContainingCharacter2942 {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        String y = String.valueOf(x);
        for(int i = 0;i<words.length;i++){
            if(words[i].contains(y)){
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[]args){

        String[] words = {"leet", "code"};
                char x = 'e';
                System.out.println(new FindWordsContainingCharacter2942().findWordsContaining(words, x));
    }
}
