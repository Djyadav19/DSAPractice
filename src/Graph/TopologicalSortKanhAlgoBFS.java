package Graph;

import java.awt.color.ICC_ColorSpace;
import java.util.*;

public class TopologicalSortKanhAlgoBFS {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        //construct the ajdList.
        int [] inDegree = new int[V];
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer>queue = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            answer.add(node);
            for(int neigbhour : adjList.get(node)){
                inDegree[neigbhour]--;
                if(inDegree[neigbhour] == 0){
                    queue.offer(neigbhour);
                }
            }
        }
        return answer;
    }
}
