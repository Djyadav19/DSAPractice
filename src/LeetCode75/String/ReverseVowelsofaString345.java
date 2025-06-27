package LeetCode75.String;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsofaString345 {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        StringBuilder sb = new StringBuilder(s);
        int j = vowels.size() - 1;
        for (int i = 0; i < sb.length(); i++) {
            if (isVowel(sb.charAt(i))) {
                sb.setCharAt(i, vowels.get(j--));
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        ReverseVowelsofaString345 solver = new ReverseVowelsofaString345();
        String input = "hello";
        String result = solver.reverseVowels(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
    }
}
