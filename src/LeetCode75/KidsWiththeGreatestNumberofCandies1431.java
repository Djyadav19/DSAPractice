package LeetCode75;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> ans = new ArrayList<>();
        int maxOfAll = Integer.MIN_VALUE;
        for(int i = 0;i<candies.length;i++){
            maxOfAll = Math.max(candies[i],maxOfAll);
        }
        for(int i : candies){
            if(i+ extraCandies >= maxOfAll){
                ans.add(true);
                continue;
            }
            ans.add(false);
        }
        return ans;
    }

public static void main(String[] args) {
        KidsWiththeGreatestNumberofCandies1431 solution = new KidsWiththeGreatestNumberofCandies1431();

        int[] candies1 = {2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        System.out.println(solution.kidsWithCandies(candies1, extraCandies1)); // [true, true, true, false, true]

        int[] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        System.out.println(solution.kidsWithCandies(candies2, extraCandies2)); // [true, false, false, false, false]

        int[] candies3 = {12, 1, 12};
        int extraCandies3 = 10;
        System.out.println(solution.kidsWithCandies(candies3, extraCandies3)); // [true, false, true]
    }
}
