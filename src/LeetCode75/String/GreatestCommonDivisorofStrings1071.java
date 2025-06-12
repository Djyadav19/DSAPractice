package LeetCode75.String;

public class GreatestCommonDivisorofStrings1071 {
    public String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1)){
            int a = str1.length();
            int b = str2.length();
            int gcd = gcd(a,b);
            return str1.substring(0,gcd);

        }
        return "";


    }
    private int gcd(int a,int b){
        while(b%a != 0){
            int rem = b%a;
            b = a;
            a = rem;
        }
        return a;
    }

    public static void main(String[] args) {
            GreatestCommonDivisorofStrings1071 solver = new GreatestCommonDivisorofStrings1071();
            System.out.println(solver.gcdOfStrings("ABCABC", "ABC")); // Output: "ABC"
            System.out.println(solver.gcdOfStrings("LEET", "CODE")); // Output: ""
        }
}
