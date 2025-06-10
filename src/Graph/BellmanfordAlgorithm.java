package Graph;

import java.util.Arrays;

public class BellmanfordAlgorithm {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here

        //In bellmanFord algo what we do we calculate for n-1  times to get the shortest path.
        // If we are getting any answer at nth calculation it means that it contains a negative cycle.
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src] = 0;
        for(int i = 0;i<V-1;i++){
            // will now iterate all the neighbours.
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(dist[u] != (int)1e8 && w != 1e8 && dist[v] > dist[u] + w){
                    dist[v] = dist[u]+ w;
                }
            }
        }

        // to detect cycle
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dist[u] != (int)1e8 && w != 1e8 && dist[v] > dist[u] + w){
                return new int[]{-1};
            }
        }
        return dist;
    }
    public static void main(String[] args) {
            int V = 5;
            int[][] edges = {
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
            };
            int src = 0;
            BellmanfordAlgorithm algo = new BellmanfordAlgorithm();
            int[] result = algo.bellmanFord(V, edges, src);
            System.out.println(Arrays.toString(result));

            // Test case 2: Graph with negative weights and possible negative cycle
            int V2 = 6;
            int[][] edges2 = {
                {1, 0, -4},
                {3, 5, -4},
                {4, 3, -5},
                {5, 3, -10}
            };
            int src2 = 1;
            int[] result2 = algo.bellmanFord(V2, edges2, src2);
            System.out.println(Arrays.toString(result2));
        }
}
