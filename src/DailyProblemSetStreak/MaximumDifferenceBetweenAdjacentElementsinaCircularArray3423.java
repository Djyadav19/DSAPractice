package DailyProblemSetStreak;

public class MaximumDifferenceBetweenAdjacentElementsinaCircularArray3423 {
    public int maxAdjacentDistance(int[] nums) {

        int ans = Math.abs(nums[0]-nums[nums.length-1]);

        for(int i = 1;i<nums.length;i++){
            ans = Math.max(Math.abs(nums[i]-nums[i-1]),ans);
        }
        return ans;

    }

    public static void main(String[]args){
        MaximumDifferenceBetweenAdjacentElementsinaCircularArray3423 solver = new MaximumDifferenceBetweenAdjacentElementsinaCircularArray3423();
        int []arr = new int[]{1,3,4,9};
        System.out.println(solver.maxAdjacentDistance(arr));
    }
}
