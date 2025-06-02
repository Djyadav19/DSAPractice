package DailyProblemSetStreak;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ZeroArrayTrnsformationIII3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        int ans = 0;
        int n = nums.length;
        PriorityQueue<Integer> availableQueries = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> usedQuery  = new PriorityQueue<>();

        //now need to sort the query on the basis of their startIndex
        Arrays.sort(queries,(a,b) -> Integer.compare(a[0],b[0]));
        int queryPos = 0;
        int appliedQuery = 0;

        // will try to make each position to zeros.
        for(int i = 0;i<n;i++){
            //push all queries starting at i to available query queue.
            while (queryPos < queries.length && queries[queryPos][0] == i){
                availableQueries.offer(queries[queryPos][1]);
                queryPos++;
            }

            //Adjust num[i] by subtracting the  by the number of queries used.
            nums[i] -= usedQuery.size();

            //Apply queries if nums[i] > 0; to make it 0
            while (nums[i] > 0 && !availableQueries.isEmpty() && availableQueries.peek() >=i){
                int end = availableQueries.poll();
                usedQuery.offer(end);
                nums[i]--;
                appliedQuery++;
            }
            //if num[i]  == 0; retrun -1;
            if(nums[i] > 0){
                return  -1;
            }

            //Remove queries that end at i from used query
            while (!usedQuery.isEmpty() && usedQuery.peek() ==i){
                usedQuery.poll();
            }

        }
        return queries.length-appliedQuery;


        /*int[]transformationArray = new int[nums.length+1];
        int querySize = queries.length;
        for(int i = 0;i<querySize;i++){
            int[]query = queries[i];
            int start = query[0];
            int end = query[1]+1;
            transformationArray[start]++;
            transformationArray[end]--;

            if(checkForZeroArray(nums, transformationArray)){
                return querySize-i;
            }

        }*/
        
        //return -1;
    }

    private boolean checkForZeroArray(int[] nums, int[] transformationArray) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += transformationArray[i];
            if(nums[i] > sum){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3};
        int[][] queries = {{0, 1}, {0, 0}, {0, 1}, {0, 1}, {0, 0}};
        ZeroArrayTrnsformationIII3362 obj = new ZeroArrayTrnsformationIII3362();
        System.out.println(obj.maxRemoval(nums, queries)); // Output: 2
    }
}
