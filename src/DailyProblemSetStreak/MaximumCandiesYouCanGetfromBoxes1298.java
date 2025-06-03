package DailyProblemSetStreak;

import java.util.HashSet;
import java.util.Set;

public class MaximumCandiesYouCanGetfromBoxes1298 {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        int totalCandies = 0;

        boolean[] visited = new boolean[status.length];
        Set<Integer> boxfound = new HashSet<>();
        for(int box : initialBoxes){
            totalCandies+= dfs(box,status,candies,keys,containedBoxes,visited,boxfound);
        }

        return totalCandies;
    }

    private int dfs(int box, int[] status, int[] candies, int[][] keys, int[][] containedBoxes, boolean[] visited, Set<Integer> boxfound) {
        if(visited[box]){
            return 0;
        }
        int candyCount =0;
        if(status[box] == 1){
            visited[box] = true;
            candyCount += candies[box];
        }else{
            boxfound.add(box);
            return candyCount;
        }
        for(int neigh : containedBoxes[box]){
            if(!visited[neigh])
                candyCount += dfs(neigh,status,candies,keys,containedBoxes,visited,boxfound);
        }

        for(int key : keys[box]){
            status[key] = 1;
            if(boxfound.contains(key)){
                candyCount+= dfs(key,status,candies,keys,containedBoxes,visited,boxfound);
            }
        }
        return candyCount;
    }

    public static void main(String[] args) {
            int[] status = {1,0,0,0,0,0};
            int[] candies = {1,1,1,1,1,1};
            int[][] keys = {{1,2,3,4,5},{},{},{},{},{}};
            int[][] containedBoxes = {{1,2,3,4,5},{},{},{},{},{}};
            int[] initialBoxes = {0};
            MaximumCandiesYouCanGetfromBoxes1298 obj = new MaximumCandiesYouCanGetfromBoxes1298();
            int result = obj.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
            System.out.println(result); // Output: 6
        }
}
