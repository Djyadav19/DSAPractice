package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUsingTopoSort {

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>>adjList = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        int[]inDegree = new int[V];

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
            int size = queue.size();
            while (size-- >0){
                int node = queue.poll();
                if(inDegree[node]==0){
                    answer.add(node);
                }
                for(int neigh : adjList.get(node)){
                    inDegree[neigh]--;
                    if(inDegree[neigh]==0){
                        queue.offer(node);
                    }
                }
            }
        }
        if(answer.size() != V){
            return true;
        }
        return false;
    }
}
