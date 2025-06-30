package DailyProblemSetStreak;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence594 {

    public int findLHS(int[] nums) {

        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        int answer = 0;
        for(int i : map.keySet()) {
            if(map.containsKey(i-1)){
                answer = Math.max(answer,map.get(i)+map.get(i-1));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
            LongestHarmoniousSubsequence594 solver = new LongestHarmoniousSubsequence594();

            int[] test1 = {1,3,2,2,5,2,3,7};
            System.out.println("Test 1: " + solver.findLHS(test1)); // Expected: 5

            int[] test2 = {1,2,3,4};
            System.out.println("Test 2: " + solver.findLHS(test2)); // Expected: 2

            int[] test3 = {1,1,1,1};
            System.out.println("Test 3: " + solver.findLHS(test3)); // Expected: 0

            int[] test4 = {1,2,2,1};
            System.out.println("Test 4: " + solver.findLHS(test4)); // Expected: 4

            int[] test5 = {};
            System.out.println("Test 5: " + solver.findLHS(test5)); // Expected: 0
        }
}
