package DailyProblemSetStreak;

import java.util.*;

public class FindClosestNodetoGivenTwoNodes2359 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        // since there is only one outgoing node and it is directed so
        // we can skip creating the adjList as the array will already work like that.
        // whenever we need to find the closest distance first try to go with bfs.
        //Map<Integer, Integer> distanceMap1 = bfs(edges,node1);
        //Map<Integer,Integer> distanceMap2 = bfs(edges,node2);
        int[]distance1 = bfs(edges,node1);
        int[]distance2 = bfs(edges,node2);

        int minDistanc = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0;i<edges.length;i++){
            if(distance1[i] != -1 && distance2[i] != -2){
                int maxDist = Math.max(distance1[i] ,distance2[i]);
                if(maxDist < minDistanc || (maxDist == minDistanc && i<ans)){
                    minDistanc = maxDist;
                    ans = i;
                }
            }
        }

        /*for(int key : distanceMap1.keySet()){
            if(distanMap2.containsKey(key)){
                int maxOfBoth = Math.max(distanMap2.get(key),distanceMap1.get(key));
                if(minDistanc>maxOfBoth){
                    minDistanc = maxOfBoth;
                    ans = key;
                }
            }
        }*/
        return ans;
    }

    private int[] bfs(int[] edges, int start) {
        //in bfs we need a queue to keep the nodes to iterate.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);// here it is giving the start node and its distnace.
        //Map<Integer,Integer> disMap= new HashMap<>();
        int n = edges.length;
        int[] distance = new int[n];
        Arrays.fill(distance,-1);
        distance[start] = 0;

        while (!queue.isEmpty()){
            int node = queue.poll();

            int nextNode = edges[node];
            if(nextNode != -1 && distance[nextNode] == -1){
                distance[nextNode] = distance[node]+1;
                queue.offer(nextNode);
            }

        }
        return distance;
    }
    /*
    private Map<Integer, Integer> bfs(int[] edges, int start) {
        //in bfs we need a queue to keep the nodes to iterate.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,0});// here it is giving the start node and its distnace.
        Map<Integer,Integer> disMap= new HashMap<>();
        int count = 0;

        while (!queue.isEmpty()){
            int[] pair = queue.poll();
            int node = pair[0];
            int dist = pair[1];
            if(disMap.containsKey(node)) continue;
            disMap.put(node,dist);

            int nextNode = edges[node];
            if(nextNode != -1 && !disMap.containsKey(nextNode)){
                queue.offer(new int[]{nextNode,dist+1});
            }

        }
        return disMap;
    }
*/
    public static void main(String[] args) {
        int[] edges = {1, 2, -1};
        int node1 = 0;
        int node2 = 2;
        FindClosestNodetoGivenTwoNodes2359 obj = new FindClosestNodetoGivenTwoNodes2359();
        int result = obj.closestMeetingNode(edges, node1, node2);
        System.out.println(result); // Output: 2
    }
}
