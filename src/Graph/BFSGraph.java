package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

    public static void main(String[] args){
        int edges[][] = {{0,2},{0,1},{1,3},{3,4}};
        int v = 5;
        List<List<Integer>> adjList = createAdjList(edges, v);

        List<Integer> ans = new ArrayList<>();
        boolean[]visited = new boolean[v];
        Queue<Integer> nodesQueue = new LinkedList<>();
        visited[0]  = true; // will be given the start node.
        nodesQueue.offer(0);
        while(!nodesQueue.isEmpty()){
            int node = nodesQueue.poll();
            ans.add(node);
            for(int neighbhour : adjList.get(node)){
                if(!visited[neighbhour]){
                    visited[neighbhour] = true;
                    nodesQueue.offer(neighbhour);
                }
            }

        }
        System.out.println("DFS : -> " + ans);
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
