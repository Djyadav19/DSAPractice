package LeetCode75.Arrays;

public class ProductofArrayExceptSelf238 {

    public int[] productExceptSelf(int[] nums) {

        /**
         * Here we can't use division.
         * So will be taking two array prefix and suffix.
         * we will fill these array and multiply them at the end will return it.
         */
        int n = nums.length;
        int[]prefix = new int[n];
        prefix[0] = 1; // since no one is there before zeroth index.
        int[]suffix = new int[n];
        suffix[n-1] = 1; // since no one will be after it to get multiplied.
        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
            suffix[n-1-i] = suffix[n-i]*nums[n-i];
        }
        for(int i = 0;i<n;i++){
            nums[i] = prefix[i]*suffix[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf238 solution = new ProductofArrayExceptSelf238();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Expected output: 24 12 8 6
    }
}
