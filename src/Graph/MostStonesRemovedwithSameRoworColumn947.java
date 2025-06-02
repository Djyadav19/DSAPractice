package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MostStonesRemovedwithSameRoworColumn947 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        createAdjList(stones,n,adjList);
        boolean[] visited = new boolean[n];
        int components = 0;
        for(int i = 0;i<n;i++) {
            if(!visited[i]) {
                dfs(i, adjList, stones, visited);
                components++;
            }
        }
        return n-components;
    }

    private void dfs(int curr, List<List<Integer>> adjList, int[][] stones, boolean[] visited) {
        visited[curr] = true;
        for(int neighbour : adjList.get(curr)){
            if(!visited[neighbour]){
                dfs(neighbour,adjList,stones,visited);
            }
        }
    }

    private void createAdjList(int[][] stones, int n, List<List<Integer>> adjList) {
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
    }

    public static void main(String[]args){
        //Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        MostStonesRemovedwithSameRoworColumn947 obj = new MostStonesRemovedwithSameRoworColumn947();
        System.out.println(obj.removeStones(stones));
    }
}
