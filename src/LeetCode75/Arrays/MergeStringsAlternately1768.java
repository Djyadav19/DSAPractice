package LeetCode75.Arrays;

public class MergeStringsAlternately1768 {
    public String mergeAlternately(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < n1 && i< n2){
            sb.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
        }
        if(i< n1){
            sb.append(word1.substring(i,n1));
        }
        if(i< n2){
            sb.append(word2.substring(i,n2));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
            MergeStringsAlternately1768 merger = new MergeStringsAlternately1768();
            String result1 = merger.mergeAlternately("abc", "pqr");
            System.out.println(result1); // Expected: "apbqcr"

            String result2 = merger.mergeAlternately("ab", "pqrs");
            System.out.println(result2); // Expected: "apbqrs"
        }
}
