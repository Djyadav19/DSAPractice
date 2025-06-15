package Disjoints;

public class DisjointsBySize {
    int [] size;
    int[] parent;
    int components;

    /**
     *
     * @param nodes
     * use constructor to intialize the rank and parent array same as the size of node
     * intially the each nodes are parent of their own, and thier rank = 0;
     */
    DisjointsBySize(int nodes){
        this.size = new int[nodes];
        this.parent = new int[nodes];
        this.components = nodes;
        for(int i = 0;i<nodes;i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    public void union(int node1, int node2){
        int parentOfNode1 = parent[node1];
        int parentOfNode2 = parent[node2];

        if(parentOfNode1 == parentOfNode2){
            return; // since they are from same component
        }
        int sizeOfParent1 = size[parentOfNode1];
        int sizeOfParent2 = size[parentOfNode2];
        if(sizeOfParent2 > sizeOfParent1){
            parent[parentOfNode1] = parentOfNode2;
            size[parentOfNode2] += size[parentOfNode1];
        } else if(sizeOfParent2 < sizeOfParent1){
            parent[parentOfNode2] = parentOfNode1;
            size[parentOfNode1] += size[parentOfNode2];
        } else{
            parent[parentOfNode2] = parentOfNode1;
            size[parentOfNode1] += size[parentOfNode2];
        }
        components--;
    }

    public static void main(String[] args){
        DisjointsBySize obj = new DisjointsBySize(4);
        System.out.println("Total components: "+ obj.components);
        System.out.println(obj.findParent(0) == obj.findParent(3));
        obj.union(0,3);
        System.out.println("Total components: "+ obj.components);
        System.out.println(obj.findParent(0) == obj.findParent(3));

    }
}
