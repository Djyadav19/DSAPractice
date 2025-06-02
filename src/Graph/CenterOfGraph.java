package Graph;

import java.util.ArrayList;
import java.util.List;

public class CenterOfGraph {
    //edges = [[1,2],[2,3],[4,2]]

    public static int findCenter(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ;i< edges.length;i++){
            adjList.add( new ArrayList<>());
        }

        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int size = adjList.size();
        for(int i = 0;i< size;i++){
            if(adjList.get(i).size() == adjList.size()){
                System.out.println(i);
                return i;
            }
        }
        return 0;
    }
    public static void main(String args[]){
        int [][] edges = {{1,2},{2,3},{4,2}};
        findCenter(edges);
    }
}
