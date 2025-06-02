package Graph;

import java.util.*;

public class DetectCycleBFS {

    public boolean checkIfCycle(int src,List<List<Integer>> adj, Set visited ){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src,-1});
        visited.add(src);
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int currentNode = pair[0];
            int parentNode = pair[1];
            for(int neighbour : adj.get(currentNode)) {
                if (neighbour == parentNode) {
                    continue; //skip
                } else if (visited.contains(neighbour)) {
                    return true;
                } else {
                    queue.offer(new int[]{neighbour,currentNode});
                    visited.add(neighbour);
                }
            }

        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        // Code here

        List<List<Integer>>adjList = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[]edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        boolean ans ;
        for(int i = 0;i<V;i++){
            if(!visited.contains(i) && checkIfCycle(i,adjList,visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[]args){
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        DetectCycleBFS obj = new DetectCycleBFS();
        System.out.println(obj.isCycle(V, edges));
    }
}
