package DailyProblemSetStreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimizetheMaximumDifferenceofPairs2616 {

    int n;
    private boolean isValid(int[] nums, int mid, int p) {
        int i = 0;
        int pairs = 0;

        while (i < n - 1) {
            if (nums[i + 1] - nums[i] <= mid) {
                pairs++;
                i += 2;
            } else {
                i++;
            }
        }

        return pairs >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        //let's do with sorting first.
        n = nums.length;
        int ans = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int l = 0;
        int r = nums[n-1] - nums[0];
        while(l<=r){
            int mid = (l+r)/2;

            if(isValid(nums,mid,p)){
                ans = mid;
                r = mid-1;
            } else{
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
            MinimizetheMaximumDifferenceofPairs2616 solver = new MinimizetheMaximumDifferenceofPairs2616();
            int[] nums1 = {1,1,0,3};
            int p1 = 2;
            System.out.println("Test 1: " + solver.minimizeMax(nums1, p1)); // Example output : 2

            int[] nums2 = {10, 1, 2, 7, 5};
            int p2 = 1;
            System.out.println("Test 2: " + solver.minimizeMax(nums2, p2)); // Example output

            int[] nums3 = {4, 2, 1, 3};
            int p3 = 2;
            System.out.println("Test 3: " + solver.minimizeMax(nums3, p3)); // Example output
        }
}
