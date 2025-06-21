package DP.DP1D;

public class ClimbingStairs70 {
    public int climbStairs(int n) {
        int ans = 0;
        return climbStairsRec(n);
    }

    private int climbStairsRec(int n ){
        if(n < 0) return 0;
        if(n == 0) return 1;
        //one steps.
        int ansFrom1steps = climbStairsRec(n-1);
        //two steps
        int ansFrom2Steps= climbStairsRec(n-2);
        return ansFrom1steps+ansFrom2Steps;
    }

    public static void main(String[] args) {
        ClimbingStairs70 solver = new ClimbingStairs70();
        //System.out.println(solver.climbStairs(2)); // Expected: 2
        System.out.println(solver.climbStairs(3)); // Expected: 3
        System.out.println(solver.climbStairs(4)); // Expected: 5
        System.out.println(solver.climbStairs(5)); // Expected: 8
    }
}
