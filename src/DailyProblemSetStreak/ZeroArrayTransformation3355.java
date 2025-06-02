package DailyProblemSetStreak;

public class ZeroArrayTransformation3355 {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diffs = new int[nums.length+1]; // this the transformed array.

        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];
            diffs[i]++;
            if (j + 1 < nums.length)
                diffs[j+1]--;

        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += diffs[i];
            if (nums[i] > sum) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ZeroArrayTransformation3355 obj = new ZeroArrayTransformation3355();
        int[] nums = {5, 4};
        int[][] queries = {{1, 1}, {1, 1}, {0, 1}, {1, 1}, {0, 0}, {0, 0}, {0, 1}, {1, 1}, {1, 1}};
        System.out.println("Is zero Array: " + obj.isZeroArray(nums, queries));
    }
}

