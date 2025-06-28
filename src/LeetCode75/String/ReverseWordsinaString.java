package LeetCode75.String;

public class ReverseWordsinaString {

    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        String ans = "";
        for(int i = str.length-1;i>=0;i--){
            ans = ans + " " +str[i].trim();
        }
        return ans.trim();

    }

    public static void main(String[] args) {
        ReverseWordsinaString obj = new ReverseWordsinaString();
        String input = "  the sky   is blue  ";
        String result = obj.reverseWords(input);
        System.out.println("Reversed: \"" + result + "\"");
    }
}
