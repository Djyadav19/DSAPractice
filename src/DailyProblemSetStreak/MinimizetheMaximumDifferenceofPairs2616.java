package DailyProblemSetStreak;

import java.util.HashSet;
import java.util.Set;

public class MinimizetheMaximumDifferenceofPairs2616 {
    public int minimizeMax(int[] nums, int p) {
        //let's do with sorting first.
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int[] pairs = new int[p];

        Set<Integer> indexSet = new HashSet<>();
        while(p-- > 0){
            int minDiff = Integer.MAX_VALUE;
            int[] idx = new int[2];
            for(int i = 0;i<n-1;i++){
                if(indexSet.contains(i))continue;
                for(int j = 0;j<n;j++){
                    if(indexSet.contains(j) || j == i)continue;
                    if(Math.abs(nums[i]-nums[j]) < minDiff){
                        minDiff = Math.min(Math.abs(nums[i]-nums[j]),minDiff);
                        idx[0] = i; idx[1] = j;
                    }
                }
            }
            ans = Math.max(minDiff,ans);
            indexSet.add(idx[0]);
            indexSet.add(idx[1]);
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
