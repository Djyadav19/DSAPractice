package DailyProblemSetStreak;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK2294 {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            int req = nums[i] + k;
            while(i<nums.length && req >= nums[i]){
                i++;
                if(i<nums.length){
                    if(req > nums[i]){
                        continue;
                    }if(req == nums[i]){
                        ans++;
                        break;
                    }if(req < nums[i]){
                        ans++;
                        i--;
                        break;
                    }
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
            PartitionArraySuchThatMaximumDifferenceIsK2294 solver = new PartitionArraySuchThatMaximumDifferenceIsK2294();
            int[] nums1 = {3, 6, 1, 2, 5};
            int k1 = 2;
            System.out.println(solver.partitionArray(nums1, k1)); // Example output

            int[] nums2 = {1, 2, 3, 4};
            int k2 = 1;
            System.out.println(solver.partitionArray(nums2, k2)); // Example output

            int[] nums3 = {1, 10, 20, 30};
            int k3 = 5;
            System.out.println(solver.partitionArray(nums3, k3)); // Example output
        }
}
