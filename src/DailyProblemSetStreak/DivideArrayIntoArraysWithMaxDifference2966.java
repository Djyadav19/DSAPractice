package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference2966 {
    public int[][] divideArray(int[] nums, int k) {

        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        for(int i = 0;i<nums.length-2;i+=3){
            int diff1 = Math.abs(nums[i]-nums[i+1]);
            int diff2 = Math.abs(nums[i]-nums[i+2]);
            int diff3 = Math.abs(nums[i+1]-nums[i+2]);
            if( diff1 <=k && diff2<=k && diff3<=k){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[i+1]);
                temp.add(nums[i+2]);
                ansList.add(temp);
            } else{
                return new int[0][0];
            }
        }

        int[][] ans = new int[ansList.size()][3];
        for(int i = 0;i<ansList.size();i++){
            ans[i] = new int[]{ansList.get(i).get(0),ansList.get(i).get(1),ansList.get(i).get(2)};
        }
        return ans;
    }

    public static void main(String[] args) {
            DivideArrayIntoArraysWithMaxDifference2966 solution = new DivideArrayIntoArraysWithMaxDifference2966();
            int[] nums = {1,3,4,8,7,9,3,5,1};
            int k = 2;
            int[][] result = solution.divideArray(nums, k);
            System.out.print("[");
            for (int i = 0; i < result.length; i++) {
                System.out.print(Arrays.toString(result[i]));
                if (i < result.length - 1) System.out.print(",");
            }
            System.out.println("]");
        }
}
