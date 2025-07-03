package LeetCode75.SlidingWindow;

public class MaximumNumberofVowelsinaSubstringofGivenLength1456 {
    private boolean checkVowel(char c){
        return (c == 'a'||c =='e' ||c=='i'||c=='o'||c=='u') ? true:false;
    }
    public int maxVowels(String s, int k) {
        int count = 0;
        int n = s.length();
        for(int i = 0;i<k && i < n;i++){
            if(checkVowel(s.charAt(i))){
                count++;
            }
        }
        if(n <=k){
            return count;
        }
        int ans = 0;
        for(int i = k;i<n;i++){
            if(checkVowel(s.charAt(i-k))){
                count--;
            }
            if(checkVowel(s.charAt(i))){
                count++;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumNumberofVowelsinaSubstringofGivenLength1456 solver = new MaximumNumberofVowelsinaSubstringofGivenLength1456();
        System.out.println(solver.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33)); // Expected: 3
        System.out.println(solver.maxVowels("aeiou", 2));     // Expected: 2
        System.out.println(solver.maxVowels("leetcode", 3));  // Expected: 2
        System.out.println(solver.maxVowels("rhythms", 4));   // Expected: 0
        System.out.println(solver.maxVowels("tryhard", 4));   // Expected: 1
    }
}
