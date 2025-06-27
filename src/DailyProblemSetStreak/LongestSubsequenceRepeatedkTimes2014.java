package DailyProblemSetStreak;

public class LongestSubsequenceRepeatedkTimes2014 {
    private boolean isSubSeq(String s, String curr, int k){
        int i = 0, j= 0, l = curr.length(),n = s.length();
        while(i<n && j< k*l){
            if(s.charAt(i) == curr.charAt(j%l))
                j++;
            i++;
        }
        return j == k*l;
    }
    private void backtracing(String s, StringBuilder curr, boolean[]canBeUsed, int[]atMostUsed, int maxLength, int k, String[] answer){
        if(curr.length() > maxLength) return ;
        if (((curr.length() > answer[0].length()) ||
                (curr.length() == answer[0].length() && curr.toString().compareTo(answer[0]) > 0))
                && isSubSeq(s, curr.toString(), k)) {
            answer[0] = curr.toString();
        }

        // will try to generate
        for(int i = 25;i>=0;i--){
            if(canBeUsed[i] && atMostUsed[i] > 0){
                char c = (char) (i +'a');
                curr.append(c);
                atMostUsed[i]--;

                //explore again
                backtracing(s,curr,canBeUsed,atMostUsed,maxLength,k,answer);

                //undo
                curr.deleteCharAt(curr.length() - 1);
                atMostUsed[i]++;
            }
        }
    }
    public String longestSubsequenceRepeatedK(String s, int k) {

        /**
         : let's find the frequency of each character as it should be greater then or equal to k
         then it can be used in our subsequence. Also need to identify that how many times we can use them. count/k .
         then we need to mark all other characters as not to be used.
         will use bactracking to generate the subsequence and will check that is the generated is part of the the string or not.

         */

        int [] freq = new int [26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        // now need to check which can be used.
        boolean [] canBeUsed = new boolean[26];
        int[] atMostUsed = new int[26];
        for(int i = 0;i<26;i++){
            if(freq[i] >= k){
                canBeUsed[i] = true;
                atMostUsed[i] = freq[i]/k;
            }
        }
        //now find the maxLength of subseq.
        int maxLengthSeq = s.length()/k;
        StringBuilder curr = new StringBuilder();
        String[]  answer = new String[]{""};
        backtracing(s,curr,canBeUsed,atMostUsed,maxLengthSeq,k,answer);
        return answer[0];
    }

    public static void main(String[] args) {
        LongestSubsequenceRepeatedkTimes2014 solver = new LongestSubsequenceRepeatedkTimes2014();
        String s = "letsleetcode";
        int k = 2;
        String result = solver.longestSubsequenceRepeatedK(s, k);
        System.out.println("Longest subsequence repeated " + k + " times: " + result);
    }
}
