package LeetCode75.TwoPointers;

public class MoveZeroes283 {

    public void moveZeroes(int[] nums) {
        /**
         * let's start here with the intuition that we will first fill all the non zeros in start
         * and the will fill the remaining index with 0.
          */

        int pos = 0;
        for(int num : nums){
            if(num != 0){
                nums[pos++] = num;
            }
        }
        while(pos < nums.length){
            nums[pos++] = 0;
        }

        /**
        //naive
        int left = 0;
        int right = 1;
        while(left<nums.length && right < nums.length){
            if(nums[left] != 0){
                left++;
                if(left == right){
                    right++;
                }
                continue;
            }
            if(nums[left] == 0 && nums[right] != 0){
                nums[left] = nums[right];
                nums[right] = 0;
                right++;
            } else if(nums[left] == 0 && nums[right] == 0){
                while(right < nums.length){
                    if(nums[right] != 0){
                        nums[left] = nums[right];
                        nums[right] = 0;
                        break;
                    }
                    right++;
                }
            }
            left++;
        }
         */
    }

    public static void main(String[] args) {
        MoveZeroes283 solution = new MoveZeroes283();

        int[][] testCases = {
            {0,1,0,3,12},
            {0,0,1},
            {1,0,1},
            {0,0,0},
            {1,2,3,4,5},
            {0},
            {},
            {2,0,0,1,3,0,4}
        };

        for (int[] testCase : testCases) {
            int[] nums = testCase.clone();
            solution.moveZeroes(nums);
            System.out.print("Result: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
