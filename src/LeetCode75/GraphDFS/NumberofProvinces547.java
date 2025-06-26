package LeetCode75.GraphDFS;

import java.util.ArrayList;
import java.util.List;

public class NumberofProvinces547 {
    public int findCircleNum(int[][] isConnected) {
        /**
         As mentioned here that province are directly or indirectly connected city.
         So here we need just find out how many components of graph we have.
         */
        int n = isConnected.length;
        boolean [] visited = new boolean[n];
        int components = 0;
        /**
         let's create the adjList.
         */

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,adjList);
                components++;
            }
        }
        return components;
    }
    private void dfs(int i , boolean[] visited, List<List<Integer>> adjList){
        if(visited[i]) return;
        visited[i] = true;
        for(int neigh : adjList.get(i)){
            if(!visited[neigh]){
                dfs(neigh,visited,adjList);
            }
        }
    }


    public static void main(String[] args) {
        NumberofProvinces547 solution = new NumberofProvinces547();
        int[][] isConnected = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };
        int result = solution.findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result); // Output should be 2
    }
}
