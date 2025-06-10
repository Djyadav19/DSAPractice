package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    class Pair implements Comparable<Pair>{
        int node = 0;
        int weight = 0;
        Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here

        List<List<Pair>> adjList = new ArrayList<>();
        for(int i= 0;i <V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v= edge[1];
            int w = edge[2];
           adjList.get(u).add(new Pair(v, w));
           adjList.get(v).add(new Pair(u, w));
        }
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        bfsDijkastraAlgo(pq, distance, adjList);
        return distance;
    }

    private void bfsDijkastraAlgo(PriorityQueue<Pair> pq, int[] distance, List<List<Pair>> adjList) {
        while(!pq.isEmpty()){
            Pair nodeAndWeight = pq.poll();
            int node = nodeAndWeight.node;
            int weight = nodeAndWeight.weight;
            if(weight <= distance[node]){
                //let's get the neighbours.
                for(Pair neighbours : adjList.get(node)){
                    int neighNode = neighbours.node;
                    int neighWeight = neighbours.weight;
                    if(distance[node]+neighWeight < distance[neighNode]){
                        distance[neighNode] = distance[node]+ neighWeight;
                        pq.add(new Pair(neighNode, distance[neighNode]));
                    }
                }
            }
        }
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
