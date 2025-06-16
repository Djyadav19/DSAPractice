package Disjoints;

public class RedundantConnection684 {
    class Disjoint{
        int[] parent;
        int[] size;
        Disjoint(int nodes){
            this.parent = new int[nodes];
            this.size = new int[nodes];
            for(int i = 0;i<nodes;i++){
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int parentCompression(int node){
            if(parent[node] == node){
                return node;
            }
            return parentCompression(parent[node]);
        }

        public boolean union(int node1, int node2){
            int root1 = parentCompression(node1);
            int root2 = parentCompression(node2);

            if(root1 == root2){
                return false;
            }
            int size1 = size[root1];
            int size2 = size[root2];

            if(size1 > size2){
                parent[node2] = node1;
                size[node1] += size[node2];
            } else {
                parent[node1] = node2;
                size[node2] += size[node1];
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Disjoint dsu = new Disjoint(n);
        int[] ans = new int[2];
        for(int[] edge : edges){
            if(!dsu.union(edge[0]-1,edge[1]-1)){
                ans[0] = edge[0];
                ans[1] = edge[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RedundantConnection684 solver = new RedundantConnection684();

        int[][] edges1 = {{1,2},{1,3},{2,3}};
        int[] result1 = solver.findRedundantConnection(edges1);
        System.out.println("Test 1: " + result1[0] + ", " + result1[1]); // Expected: 2,3

        int[][] edges2 = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] result2 = solver.findRedundantConnection(edges2);
        System.out.println("Test 2: " + result2[0] + ", " + result2[1]); // Expected: 1,4

        int[][] edges3 = {{1,2},{2,3},{3,1}};
        int[] result3 = solver.findRedundantConnection(edges3);
        System.out.println("Test 3: " + result3[0] + ", " + result3[1]); // Expected: 3,1
    }
}
