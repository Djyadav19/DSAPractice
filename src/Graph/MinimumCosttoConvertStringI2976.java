package Graph;

import java.util.Arrays;

public class MinimumCosttoConvertStringI2976 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        /* Since we need to find the Minimum cost to converting String.
            Here we will use the Floyd Warshall algorithm.
            As it used to find all the shortest from source to target via  K
            Since we are checking via k so we need to give relaxation for the via k path.
            Will be constructing adjMartix of 26 size as it conatians only lowercase letter.
        */

        long [][] adjMatrix = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0;
        }

        for(int i = 0;i<original.length;i++){
            int src =original[i]-'a';
            int trgt = changed[i]-'a';
            adjMatrix[src][trgt] =Math.min(adjMatrix[src][trgt],(long) cost[i]);

        }

        for(int k = 0;k<26;k++){
            for(int i = 0;i<26;i++){
                for(int j = 0;j<26;j++){
                    //if(adjMatrix[i][j] < Integer.MAX_VALUE)
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j],adjMatrix[i][k]+adjMatrix[k][j]);
                }
            }
        }
        long ans = 0L;
        for(int i = 0;i< source.length();i++){
            int src = source.charAt(i)-'a';
            int trgt  = target.charAt(i)-'a';
            if(adjMatrix[src][trgt] ==Integer.MAX_VALUE )
                return -1L;

            ans += (long)adjMatrix[src][trgt];
        }
        return ans;
    }

    public static void main(String[] args) {
            MinimumCosttoConvertStringI2976 solver = new MinimumCosttoConvertStringI2976();

            // Example 1
            String source1 = "abcd";
            String target1 = "acbe";
            char[] original1 = {'a','b','c','c','e','d'};
            char[] changed1 = {'b','c','b','e','b','e'};
            int[] cost1 = {2,5,5,1,2,20};
            System.out.println(solver.minimumCost(source1, target1, original1, changed1, cost1)); // Output: 28

            // Example 2
            String source2 = "aaaa";
            String target2 = "bbbb";
            char[] original2 = {'a','c'};
            char[] changed2 = {'c','b'};
            int[] cost2 = {1,2};
            System.out.println(solver.minimumCost(source2, target2, original2, changed2, cost2)); // Output: 12

            // Example 3
            String source3 = "abcd";
            String target3 = "abce";
            char[] original3 = {'a'};
            char[] changed3 = {'e'};
            int[] cost3 = {10000};
            System.out.println(solver.minimumCost(source3, target3, original3, changed3, cost3)); // Output: -1
        }
}
