package DailyProblemSetStreak;

public class FindtheMaximumSumofNodeValues3068 {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        long count = 0;
        long discardedNode = Integer.MAX_VALUE; // Minimize the loss due to not finding XOR (Only applicable for ODD case)

        for (int num : nums) {
            ans += Math.max(num, num ^ k);
            count += (num ^ k) > num ? 1 : 0;
            discardedNode = Math.min(discardedNode, Math.abs(num - (num ^ k)));
        }

        return count % 2 == 0 ? ans : (ans - discardedNode);
    }


    public static void main(String[]args){
        int[] nums = {2, 3};
        int k = 7;
        int[][] edges = {{0, 1}};
        FindtheMaximumSumofNodeValues3068 obj = new FindtheMaximumSumofNodeValues3068();

        System.out.println(obj.maximumValueSum(nums,k,edges));
    }
}
