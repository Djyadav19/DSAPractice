package DailyProblemSetStreak;

public class MaximumDifferenceBetweenIncreasingElements2016 {

    public int maximumDifference(int[] nums) {

        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                ans = Math.max(nums[j]-nums[i],ans);
            }
        }
        return ans<=0? -1: ans;
    }
    public static void main(String[] args) {
            MaximumDifferenceBetweenIncreasingElements2016 solver = new MaximumDifferenceBetweenIncreasingElements2016();

            int[][] testCases = {
                {7,1,5,4},
                {9,4,3,2},
                {1,5,2,10},
                {2,3,10,2,4,8,1},
                {1,2,3,4,5}
            };

            for (int i = 0; i < testCases.length; i++) {
                int result = solver.maximumDifference(testCases[i]);
                System.out.println("Test case " + (i+1) + ": " + result);
            }
        }
}
