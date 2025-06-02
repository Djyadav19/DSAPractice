package Graph;

import java.util.ArrayList;
import java.util.List;

public class DFSGraph {

    public static void main(String[] args){

        int edges[][] = {{0,2},{0,1},{1,3},{3,4}};
        int v = 5;
        List<List<Integer>> adjList = createAdjList(edges, v);

        /*
        to do DFS serach
         */
        List<Integer> ans = new ArrayList<>();
        boolean[]visited = new boolean[5];
        for(int i = 0;i<v;i++){
            if(!visited[i]) {
                dfsTraversal(adjList,visited,i,ans);
            }
        }

        System.out.println("DFS Traveral: -> "+ans);
    }

    public static void dfsTraversal(List<List<Integer>> adjList, boolean[] visited, int i, List<Integer> ans) {
        visited[i] = true;
        ans.add(i);
        for(int node : adjList.get(i)){
            if(!visited[node]){
                dfsTraversal(adjList,visited,node,ans);
            }
        }
    }

    private static List<List<Integer>> createAdjList(int[][] edges,int v) {
        List<List<Integer>>adjList = new ArrayList<>();
        for(int i = 0;i<v;i++){
            adjList.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }
}
