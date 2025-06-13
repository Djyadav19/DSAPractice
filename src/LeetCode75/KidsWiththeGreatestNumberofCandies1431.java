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


}
