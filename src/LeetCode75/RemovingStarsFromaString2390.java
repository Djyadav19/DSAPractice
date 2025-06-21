package LeetCode75;
import java.util.Stack;

public class RemovingStarsFromaString2390 {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*' && !stack.isEmpty()){
                stack.pop();
            } else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemovingStarsFromaString2390 remover = new RemovingStarsFromaString2390();
        System.out.println(remover.removeStars("leet**cod*e")); // Output: "lecoe"
        System.out.println(remover.removeStars("erase*****"));   // Output: ""
        System.out.println(remover.removeStars("abc*de**f*"));   // Output: "a"
    }
}
