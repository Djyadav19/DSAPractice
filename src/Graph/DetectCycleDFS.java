package Graph;

import java.util.*;

public class DetectCycleDFS {
    public boolean checkIfCycle(int current, int parent, List<List<Integer>> adj, Set visited ){
        visited.add(current);
       for(int neighbour : adj.get(current)) {
            if (neighbour == parent) {
                continue; //skip
            } else if (visited.contains(neighbour)) {
                return true;
            } else {
                if(checkIfCycle(neighbour,current,adj,visited)){
                    return true; //if any cycle detected just return from here only don't make another call.
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
            if(!visited.contains(i) && checkIfCycle(i,-1,adjList,visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[]args){
        int V = 6;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}};
        DetectCycleBFS obj = new DetectCycleBFS();
        System.out.println(obj.isCycle(V, edges));
    }
}
