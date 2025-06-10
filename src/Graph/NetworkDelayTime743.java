package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime743 {
    class Pair implements Comparable<Pair>{
        int nextNode;
        int weight;
        Pair(int nextNode,int weight){
            this.nextNode = nextNode;
            this.weight = weight;
        }
        @Override
        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        // since in question it's given that node start from 1.
        //using DijkastraAlgo()
        int ans =  usingDijkastraAlgo(times,n,k);
        System.out.println("Using Dijkastara: "+ ans);


        //using BellmanFord Algo.
        // As bellman ford is use to get shortest path from a start node.
        return usingBellManFordAlgo(times, n, k);
    }

    private int usingDijkastraAlgo(int[][] times, int n, int k) {
        int dist[] = new int[n +1];
        int INF = (int)1e8;
        Arrays.fill(dist,INF);
        dist[k] = 0;
        //let's construct the adjList for this directed Map.
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[]time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adjList.get(u).add(new Pair(v,w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while (!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.nextNode;
            int weight = pair.weight;
            if(dist[node] > weight) continue; // No need of relaxation.
            for(Pair neigh: adjList.get(node)){
                int neighNode = neigh.nextNode;
                int neighWeight = neigh.weight;
                if(dist[neighNode] > dist[node] + neighWeight){
                    dist[neighNode] = dist[node] + neighWeight;
                    pq.add(new Pair(neighNode,dist[neighNode]));
                }
            }
        }
        int max = 0;
        for(int i = 1; i<= n; i++){
            if(dist[i] == INF) return -1;
            max = Math.max(max,dist[i]);
        }
        return max;

    }

    private int usingBellManFordAlgo(int[][] times, int n, int k) {
        int dist[] = new int[n +1];
        int INF = (int)1e8;
        Arrays.fill(dist,INF);
        dist[k] = 0;
        for(int i = 1; i< n; i++){
            for(int[]time : times){
                int u = time[0];
                int v= time[1];
                int w= time[2];
                if(dist[u] != INF && w != INF && dist[v] > dist[u]+ w){
                    dist[v] = dist[u]+ w; //this is the relaxation.
                }
            }
        }
        for(int[]time : times){
            int u = time[0];
            int v= time[1];
            int w= time[2];
            if(w != INF && dist[v] > dist[u]+ w){
                return -1;
            }
        }
        int max = 0;
        for(int i = 1; i<= n; i++){
            if(dist[i] == INF) return -1;
            max = Math.max(max,dist[i]);
        }
        return max;
    }

    public static void main(String args[]){
        NetworkDelayTime743 solver = new NetworkDelayTime743();
        // Test case 1
        int[][] times1 = {{2,1,1},{2,3,1},{3,4,1}};
        int n1 = 4, k1 = 2;
        System.out.println(solver.networkDelayTime(times1, n1, k1)); // Output: 2

        // Test case 2
        int[][] times2 = {{1,2,1}};
        int n2 = 2, k2 = 1;
        System.out.println(solver.networkDelayTime(times2, n2, k2)); // Output: 1

        // Test case 3
        int[][] times3 = {{1,2,1}};
        int n3 = 2, k3 = 2;
        System.out.println(solver.networkDelayTime(times3, n3, k3)); // Output: -1
    }

}
