package LeetCode75.TwoPointers;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(left<right){
            int leftHeight = height[left];
            int rightHeight = height[right];
            maxArea = Math.max(Math.min(leftHeight,rightHeight) * (right -left),maxArea);
            if(leftHeight < rightHeight){
                left++;
            } else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
            ContainerWithMostWater11 solver = new ContainerWithMostWater11();

            int[] test1 = {1,8,6,2,5,4,8,3,7};
            System.out.println(solver.maxArea(test1)); // Expected: 49

            int[] test2 = {1,1};
            System.out.println(solver.maxArea(test2)); // Expected: 1

            int[] test3 = {4,3,2,1,4};
            System.out.println(solver.maxArea(test3)); // Expected: 16

            int[] test4 = {1,2,1};
            System.out.println(solver.maxArea(test4)); // Expected: 2

            int[] test5 = {2,3,10,5,7,8,9};
            System.out.println(solver.maxArea(test5)); // Expected: 36
        }
}
