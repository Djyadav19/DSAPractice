package DailyProblemSetStreak;

import java.util.*;

public class LongestPalindromebyConcatenatingTwoLetterWords2131 {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> wordMap = new HashMap<>();
        Map<String,Integer> symWordMap = new HashMap<>();
        for(String word: words){
            if(word.charAt(0) == word.charAt(1)){
                symWordMap.put(word,symWordMap.getOrDefault(word,0)+1);
                continue;
            }
            wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }
        int ans = 0;
        boolean addedInMiddle = false;
        for(String word : symWordMap.keySet()){
            int wordCount = symWordMap.get(word);
            if(wordCount >= 2){
               ans += wordCount %2 == 0 ? wordCount : wordCount-1;
               if(wordCount%2 != 0 && !addedInMiddle){
                   ans +=1;
                   addedInMiddle = true;
               }
           }else if(wordCount == 1 && !addedInMiddle){
                ans +=1;
                addedInMiddle = true;
            }
        }
        Set<String> wordMapKeySet = new HashSet<String>(wordMap.keySet());
        for(String word : wordMapKeySet){
            int wordCount = wordMap.getOrDefault(word,0);
            String reverse = new StringBuilder(word).reverse().toString();
            int reverseCount = wordMap.getOrDefault(reverse,0);
            if(wordCount > 0 && reverseCount > 0){
                ans += Math.min(wordCount,reverseCount) *2;
            }
            wordMap.remove(word);wordMap.remove(reverse);
        }
        return ans*2;

    }

    public static void main(String[]args){
        LongestPalindromebyConcatenatingTwoLetterWords2131 obj = new LongestPalindromebyConcatenatingTwoLetterWords2131();

        String[] input1 = {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
        System.out.println("Ans: " + obj.longestPalindrome(input1)); // Expected: 14

        String[] input2 = {"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"};
        System.out.println("Ans: " + obj.longestPalindrome(input2)); // Expected: 22

    }
}
