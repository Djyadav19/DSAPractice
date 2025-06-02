package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximizetheNumberofTargetNodesAfterConnectingTreesI3372 {

    static class Pair{
        int parent;
        int current;
        Pair(int parent,int current){
            this.parent = parent;
            this.current = current;
        }
    }
    private int BFS(int start, List<List<Integer>> adj, int k) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(-1,start));
        int count = 0;
        while (!queue.isEmpty() && k >= 0){
            int size = queue.size();
            count += size;
            for(int i = 0; i<size;i++){
                Pair curr = queue.poll();
                int position = curr.current;
                int parent = curr.parent;
                for(int nigh : adj.get(position)){
                    if(nigh != parent){
                        queue.add(new Pair(position,nigh));
                    }
                }
            }
            k--;
        }
        return  count;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int length1 = edges1.length+1;
        int length2 = edges2.length+1;

        //now need to create adjMatrix for both.

        List<List<Integer>> adj1 = new ArrayList<>();
        initializeAdjList(length1, adj1);
        createAdjList(edges1, adj1);

        List<List<Integer>> adj2 = new ArrayList<>();
        initializeAdjList(length2, adj2);

        createAdjList(edges2, adj2);

        //now let's get the max of 2nd graph. 
        int maxOfSecond = 0;
        for(int i = 0;i<length2;i++){
            int connection = BFS(i,adj2,k-1);
            maxOfSecond = Math.max(maxOfSecond,connection);
        }
        //now for first.
        int res[] = new int[length1];
        for(int i = 0;i<length1;i++){
            int connection = BFS(i,adj1,k-1);
            res[i] = connection + maxOfSecond;
        }
        
        return res;

    }
    private void initializeAdjList(int length, List<List<Integer>> adj) {
        for(int i = 0; i< length; i++){
            adj.add(new ArrayList<>());
        }
    }
    private void createAdjList(int[][] edges, List<List<Integer>> adj1) {
        for(int [] edge: edges){
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }
    }

    public static void main(String[] args) {
            int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
            int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
            int k = 2;
            MaximizetheNumberofTargetNodesAfterConnectingTreesI3372 obj = new MaximizetheNumberofTargetNodesAfterConnectingTreesI3372();
            int[] result = obj.maxTargetNodes(edges1, edges2, k);
            for (int val : result) {
                System.out.print(val + " ");
            }
            // Expected Output: 9 7 9 8 8
    }
}
