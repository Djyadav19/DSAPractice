package DailyProblemSetStreak;

import java.util.*;

public class LargestColorValueinaDirectedGraph1857 {

    private int dfs(int curr, List<List<Integer>> adj, int[] visited, int[][] longest, String colors) {
        if (visited[curr] == 1) // Cycle found
            return Integer.MAX_VALUE;

        if (visited[curr] == 0) { // Visiting for 1st time
            visited[curr] = 1;
            for (int nbr : adj.get(curr)) {
                int res = dfs(nbr, adj, visited, longest, colors);
                if (res == Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;

                // Iterate for each color for the current nbr and update max_len for each color at current node
                for (int i = 0; i < 26; ++i)
                    longest[i][curr] = Math.max(longest[i][curr], longest[i][nbr]);
            }
            longest[colors.charAt(curr) - 'a'][curr]++;
            visited[curr] = 2;
        }
        return longest[colors.charAt(curr) - 'a'][curr];
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        int[][] longest = new int[26][n];

        //    longest: Table to store the count of each color from a given node
        //    longest[i][j]=X: There are 'X' number of 'i' color nodes from current node 'j'

        // Perform DFS from each node and maximize color length
        int maxColorLength = 0;
        int[] visited = new int[n];

        //    3-color method is used to detect cycle in directed graph.
        //    0: Unvisited
        //    1: Visited & Processing
        //    2: Visited & Processed

        for (int i = 0; i < n; ++i) {
            int res = dfs(i, adj, visited, longest, colors);
            if (res == Integer.MAX_VALUE)
                return -1;
            maxColorLength = Math.max(maxColorLength, res);
        }
        return maxColorLength;
    }

    /*public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<colors.length();i++){
            adjList.add(new ArrayList<Integer>());
        }
        //create adjList.
        for(int[] edge:edges){
            int from = edge[0];
            int to = edge[1];
            if(from != to)
                adjList.get(from).add(to);
        }

        int ans = Integer.MIN_VALUE;
        Set<Integer> visited = new HashSet<>();
        for(int i = 0;i<colors.length();i++){

            HashMap<Character, Integer> colorCount = new HashMap<>();
            if(!visited.contains(i) && !adjList.get(i).isEmpty()){
                ans = Math.max(dfs(i,adjList,visited,colors,colorCount),ans);
            }
            for(char col : colorCount.keySet()){
                ans = Math.max(colorCount.get(col),ans);
            }
        }
        return ans > 0 ? ans : -1;
    }

    private int dfs(int i, List<List<Integer>> adjList, Set<Integer> visited, String colors, HashMap<Character, Integer> colorCount) {
        int count = 0;
        if(visited.contains(i)){
            return -1;
        }
        visited.add(i);
        colorCount.put(colors.charAt(i),colorCount.getOrDefault(colors.charAt(i),0)+1);
        for(int neigh : adjList.get(i)){
            if(!visited.contains(neigh)) {
                dfs(neigh, adjList, visited, colors, colorCount);
            }
        }
        for(char col : colorCount.keySet()){
            count = Math.max(colorCount.get(col),count);
        }
        return count;
    }
*/
    public static void main(String[] args){
        String colors = "hhqhuqhqff";
        int[][] edges = {{0,1},{0,2},{2,3},{3,4},{3,5},{5,6},{2,7},{6,7},{7,8},{3,8},{5,8},{8,9},{3,9},{6,9}};
        LargestColorValueinaDirectedGraph1857 obj = new LargestColorValueinaDirectedGraph1857();
        System.out.println(obj.largestPathValue(colors, edges)); // Output: 3
    }
}
