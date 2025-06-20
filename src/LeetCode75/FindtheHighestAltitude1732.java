package LeetCode75;

public class FindtheHighestAltitude1732 {
    public int largestAltitude(int[] gain) {
        int start = 0;
        int ans = Math.max(0,gain[0]);
        for(int i = 1;i<gain.length;i++){
            gain[i] =gain[i-1]+ gain[i];
            ans = Math.max(ans,gain[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        FindtheHighestAltitude1732 solver = new FindtheHighestAltitude1732();
        int[] test1 = {-5,1,5,0,-7};
        int[] test2 = {-4,-3,-2,-1,4,3,2};
        int[] test3 = {0,0,0,0};
        System.out.println(solver.largestAltitude(test1)); // Output: 1
        System.out.println(solver.largestAltitude(test2)); // Output: 0
        System.out.println(solver.largestAltitude(test3)); // Output: 0
    }
}
