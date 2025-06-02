package Graph;

import java.util.*;

public class TopologicalSortDFS {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
        }
        //construct the ajdList.
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for( int i = 0;i<V;i++) {
            if(!visited[i]) {
                dfs(i, visited, adjList, stack);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

    private static void dfs(int source, boolean[] visited, List<List<Integer>> adjList, Stack<Integer> stack) {
        visited[source]=true;
        for(int neigh : adjList.get(source)){
            if(!visited[neigh]){
                dfs(neigh, visited,adjList,stack);
            }
        }
        stack.push(source);

    }

    public static void main(String[] args) {
           int V = 4;
            int[][] edges = {{3, 0}, {1, 0}, {2, 0}};
            ArrayList<Integer> result = topoSort(V, edges);
            System.out.println(result);
    }
}
