package DP.DP1D;

public class HouseRobber198 {
    public int rob(int[] nums) {
        /**
         * So here we have a robber, he can't rob two adjacent house.
         * so he will have two choice either to rob the house or skip the house.
         * so if he robbed a house then he must need to leave the just next house
         * he can have option next to that.
         */
        /**
         * let's try using Brute force approch.
         */
        int i = 1;
        return robByRecursion(i,nums);

    }

    private int robByRecursion(int i, int[] nums) {
        if(i > nums.length) return 0;
        int steal = robByRecursion(i + 2,nums) + nums[i-1];
        int skip = robByRecursion(i + 1, nums);
        return Math.max(steal,skip);
    }

    public static void main(String[] args) {
        HouseRobber198 robber = new HouseRobber198();
        int[] test1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + robber.rob(test1)); // Expected: 4

        int[] test2 = {2, 7, 9, 3, 1};
        System.out.println("Test 2: " + robber.rob(test2)); // Expected: 12

        int[] test3 = {2, 1, 1, 2};
        System.out.println("Test 3: " + robber.rob(test3)); // Expected: 4

        int[] test4 = {5};
        System.out.println("Test 4: " + robber.rob(test4)); // Expected: 5

        int[] test5 = {};
        System.out.println("Test 5: " + robber.rob(test5)); // Expected: 0
    }
}
