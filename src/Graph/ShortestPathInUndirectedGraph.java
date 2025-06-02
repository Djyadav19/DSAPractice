package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()+1];
        queue.offer(src);
        visited[src] = true;
        int[] answer = new int[adj.size()];
        Arrays.fill(answer,-1);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int node = queue.poll();
                answer[node] = level;
                for(int neigh : adj.get(node)){
                    if(!visited[neigh]){
                        queue.offer(neigh);
                        visited[neigh] = true;
                    }
                }
            }
            level++ ;
        }
        return answer;
    }

    public static void main(String[] args) {
            int[][] adjArr = {
                {1, 3},    // 0
                {0, 2},    // 1
                {1, 6},    // 2
                {0, 4},    // 3
                {3, 5},    // 4
                {4, 6},    // 5
                {2, 5, 7, 8}, // 6
                {6, 8},    // 7
                {7, 6}     // 8
            };
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int[] neighbors : adjArr) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int n : neighbors) {
                    list.add(n);
                }
                adj.add(list);
            }
            int src = 0;
            ShortestPathInUndirectedGraph obj = new ShortestPathInUndirectedGraph();
            int[] result = obj.shortestPath(adj, src);
            // Print only the first adj.size() elements (since answer array is of size adj.size()+1)
            for (int i = 0; i < adj.size(); i++) {
                System.out.print(result[i]);
                if (i < adj.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
}
