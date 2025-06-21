package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDeletionstoMakeStringKSpecial3085 {
    public int minimumDeletions(String word, int k) {
        int [] arr = new int [26];
        char[] charArray = word.toCharArray();
        int minDeletions = Integer.MAX_VALUE;
        arr[charArray[0]-'a']++;
        for(int i = 1;i<charArray.length ;i++){
            arr[charArray[i]-'a']++;
        }
        Arrays.sort(arr);
        for(int i = 0;i<26;i++){
            if(arr[i] == 0) continue;
            int deletions = 0;
            int minFreq = arr[i];
            int maxAllowed = minFreq + k;

            // Remove characters with freq > maxAllowed
            for (int j = 25; j >= 0; j--) {
                if (arr[j] == 0) continue;
                if (arr[j] > maxAllowed) {
                    deletions += arr[j] - maxAllowed;
                }
            }

            // Remove characters with freq < minFreq
            for (int j = 0; j < i; j++) {
                deletions += arr[j];
            }

            minDeletions = Math.min(minDeletions, deletions);
        }
        return minDeletions == Integer.MAX_VALUE ? 0 : minDeletions;
    }

    public static void main(String[] args) {
            MinimumDeletionstoMakeStringKSpecial3085 solver = new MinimumDeletionstoMakeStringKSpecial3085();
            System.out.println(solver.minimumDeletions("dabdcbdcdcd", 2)); // Example test case
            System.out.println(solver.minimumDeletions("abcabc", 0)); // Example test case
            System.out.println(solver.minimumDeletions("aaaaa", 2)); // Example test case
            System.out.println(solver.minimumDeletions("abcd", 3)); // Example test case
        }
}
