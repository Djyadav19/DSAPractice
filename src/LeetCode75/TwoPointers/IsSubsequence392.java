package LeetCode75.TwoPointers;

public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        if(s==null) return false;
        if(s.length() == t.length()){
            return s.equals(t);
        }
        int i = 0;
        int j = 0;
        while(i<s.length() && j< t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                while(j<t.length()){
                    if(s.charAt(i) == t.charAt(j)){
                        j++;
                        i++;
                        break;
                    }
                    j++;
                }
            }
        }
        return i==s.length()?true:false;
    }

    public static void main(String[] args) {
        IsSubsequence392 solution = new IsSubsequence392();
        System.out.println(solution.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(solution.isSubsequence("axc", "ahbgdc")); // false
        System.out.println(solution.isSubsequence("", "ahbgdc")); // true
        System.out.println(solution.isSubsequence("abc", "")); // false
        System.out.println(solution.isSubsequence("abc", "abc")); // true
    }
}
