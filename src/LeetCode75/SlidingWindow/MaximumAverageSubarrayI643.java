package LeetCode75.SlidingWindow;

public class MaximumAverageSubarrayI643 {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if(k > n){
            return 0;
        }
        if(n == 1 && k== 1){
            return nums[0];
        }
        double sum = 0;
        for(int i = 0;i<k;i++){
            sum += nums[i];
        }
        double ans = sum / k;
        for(int i = 1;i<=n-k;i++){
            sum -= nums[i-1];
            sum += nums[i+k-1];
            ans = Math.max(sum/k,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI643 solver = new MaximumAverageSubarrayI643();
        int[] nums1 = {0,1,1,3,3};
        int k1 = 4;
        System.out.println("Test 1: " + solver.findMaxAverage(nums1, k1)); // Expected: 12.75

        int[] nums2 = {5};
        int k2 = 1;
        System.out.println("Test 2: " + solver.findMaxAverage(nums2, k2)); // Expected: 5.0

        int[] nums3 = {0, 4, 0, 3, 2};
        int k3 = 1;
        System.out.println("Test 3: " + solver.findMaxAverage(nums3, k3)); // Expected: 4.0

        int[] nums4 = {7, 4, 5, 8, 8, 3, 9, 8, 7, 6};
        int k4 = 7;
        System.out.println("Test 4: " + solver.findMaxAverage(nums4, k4)); // Expected: 7.142857...

        int[] nums5 = {1, 2};
        int k5 = 3;
        System.out.println("Test 5: " + solver.findMaxAverage(nums5, k5)); // Expected: 0.0 (k > n)
    }
}
