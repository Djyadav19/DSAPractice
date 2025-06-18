package RandomLeetCode;

public class TrappingRainWater42 {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;
        /**
         * try using two pointers approach.
         */
        int left = 0;
        int right = n-1;
        int ans = 0;
        int leftMax = height[0];
        int rightMax = height[n-1];
        while(left<right){
            if(height[left] <= height[right]){
                if(height[left] < leftMax){
                    ans += leftMax-height[left];
                }else{
                    leftMax = height[left];
                }
                left++;
            } else{
                if(height[right] < rightMax){
                    ans += rightMax-height[right];
                } else{
                    rightMax = height[right];
                }
                right--;
            }
        }
        return ans;
        /**
         *  O(n) space is being used.
        int []leftMax = new int [n];
        int [] rightMax = new int [n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for(int i = 1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for(int j= n-2;j>=0;j--){
            rightMax[j] = Math.max(rightMax[j+1],height[j]);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans += Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
         */
    }

    public static void main(String[] args) {
            TrappingRainWater42 solver = new TrappingRainWater42();

            int[] test1 = {0,1,0,2,1,0,1,3,2,1,2,1};
            System.out.println("Test 1: " + solver.trap(test1)); // Expected: 6

            int[] test2 = {4,2,0,3,2,5};
            System.out.println("Test 2: " + solver.trap(test2)); // Expected: 9

            int[] test3 = {2,0,2};
            System.out.println("Test 3: " + solver.trap(test3)); // Expected: 2

            int[] test4 = {3,0,0,2,0,4};
            System.out.println("Test 4: " + solver.trap(test4)); // Expected: 10

            int[] test5 = {};
            System.out.println("Test 5: " + solver.trap(test5)); // Expected: 0
        }
}
