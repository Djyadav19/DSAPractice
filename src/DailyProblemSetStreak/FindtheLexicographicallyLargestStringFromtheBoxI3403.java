package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindtheLexicographicallyLargestStringFromtheBoxI3403 {


    public String answerString(String word, int numFriends) {

        if (numFriends == 1) {
            return word;
        }
        int n = word.length();

        int maxLength = n-(numFriends-1);
        String  ans = "";
        for (int i = 0; i < n; i++) {
            int canTakeLength = Math.min(maxLength, n - i);
            String sub = word.substring(i, i + canTakeLength);
            if (sub.compareTo(ans) > 0) {
                ans = sub;
            }
        }
        return ans;
    }
    /*public String answerString(String word, int numFriends) {

        if(numFriends ==1){
            return word;
        }
        int n = word.length();
        int windowSize = n-numFriends+1;

        String ans;
        char[] charArray = word.toCharArray();
        int biggestCharPosition = 0;
        char c = 'a';
        for(int i = 0;i<charArray.length;i++){
            if(c < charArray[i]){
                c = charArray[i];
                biggestCharPosition = i;
            }
        }
        windowSize = windowSize+biggestCharPosition > n ? windowSize+(n - (windowSize+biggestCharPosition)): windowSize;
        return word.substring(biggestCharPosition,biggestCharPosition+windowSize);

       // return ans;

    }*/
    //TLE
    /*public String answerString(String word, int numFriends) {

        if(numFriends ==1){
            return word;
        }
        int n = word.length();
        List<String> ansList = new ArrayList<>();
        int windowSize = n-numFriends+1;

        String ans = "";
        while (windowSize > 0) {
            for (int i = 0; i + windowSize <= word.length(); i++) {
                String extracted = word.substring(i, i + windowSize);
                if(ans.compareTo(extracted) < 0){
                    ans = extracted;
                }

            }
            windowSize--;
        }
        return ans;

    }

     */
    //memory out .
    /*public String answerString(String word, int numFriends) {

        int n = word.length();
        List<String> ansList = new ArrayList<>();
        int windowSize = n-numFriends+1;

        while (windowSize > 0) {
            for (int i = 0; i + windowSize <= word.length(); i++) {
                ansList.add(word.substring(i, i + windowSize));
            }
            windowSize--;
        }
        Collections.sort(ansList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        return ansList.get(ansList.size()-1);

    }*/


    public static void main(String[] args) {
        FindtheLexicographicallyLargestStringFromtheBoxI3403 solver = new FindtheLexicographicallyLargestStringFromtheBoxI3403();

        System.out.println(solver.answerString("aann", 2)); // Expected: "nn"
        System.out.println(solver.answerString("gggg", 4)); // Expected: "gggg"
        System.out.println(solver.answerString("dbca", 2)); // Expected: "ca"
        System.out.println(solver.answerString("dbca", 2)); // Expected: "ca"
    }

}
