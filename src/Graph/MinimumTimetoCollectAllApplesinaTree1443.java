package Graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimetoCollectAllApplesinaTree1443 {


    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[]edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return dfs(0,-1,hasApple,adjList);
    }

    private int dfs(int currNode, int parent, List<Boolean> hasApple, List<List<Integer>> adjList) {
        int timeTake = 0;

        for(int neighbour: adjList.get(currNode)){
            if(neighbour == parent) continue;;
            int timeTakeByChild = dfs(neighbour,currNode,hasApple,adjList);
            if(hasApple.get(neighbour) || timeTakeByChild > 0) {
                timeTake += timeTakeByChild + 2;
            }
        }
        return  timeTake;
    }


    public static void main(String[]args){
        int n = 4;
        int[][] edges = {{0,1},{1,2},{0,3}};
        List<Boolean> hasApple = new ArrayList<>();
        hasApple.add(true);
        hasApple.add(true);
        hasApple.add(true);
        hasApple.add(true);
        MinimumTimetoCollectAllApplesinaTree1443 obj = new MinimumTimetoCollectAllApplesinaTree1443();
        System.out.println(obj.minTime(n, edges, hasApple));
    }
}
