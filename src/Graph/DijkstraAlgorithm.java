package Graph;

import java.util.ArrayList;
import java.util.List;

public class DijkstraAlgorithm {

    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i= 0;i <V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v= edge[1];
            int w = edge[2];
           // adjList.get(u).add(v).add(w);
            adjList.get(v).add(u);
        }
        // so here we need a priority queue. to get the distance
        return null;
    }

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {
            {0, 1, 1},
            {1, 2, 3},
            {0, 2, 6}
        };
        int src = 2;
        DijkstraAlgorithm obj = new DijkstraAlgorithm();
        int[] result = obj.dijkstra(V, edges, src);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
