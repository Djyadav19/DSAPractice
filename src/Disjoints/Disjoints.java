package Disjoints;

public class Disjoints {
    int [] rank;
    int[] parent;
    int components;

    /**
     *
     * @param nodes
     * use constructor to intialize the rank and parent array same as the size of node
     * intially the each nodes are parent of their own, and thier rank = 0;
     */
    Disjoints(int nodes){
        this.rank = new int[nodes];
        this.parent = new int[nodes];
        this.components = nodes;
        for(int i = 0;i<nodes;i++){
            this.parent[i] = i;
            this.rank[i] = 0;
        }
    }
    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        parent[node] =  findParent(parent[node]);
        return parent[node];
    }

    public void union(int node1, int node2){
        int parentOfNode1 = findParent(node1);
        int parentOfNode2 = findParent(node2);

        if(parentOfNode1 == parentOfNode2){
            return; // since they are from same component
        }

        int rankOfParent1 = rank[parentOfNode1];
        int rankOfParent2 = rank[parentOfNode2];
        if(rankOfParent2 > rankOfParent1){
            parent[parentOfNode1] = parentOfNode2;
        } else if(rankOfParent2 < rankOfParent1){
            parent[parentOfNode2] = parentOfNode1;
        } else{
            parent[parentOfNode2] = parentOfNode1;
            rank[parentOfNode1]++;
        }
        components--;
    }

    public static void main(String[] args){
        Disjoints obj = new Disjoints(4);
        System.out.println("Total components: "+ obj.components);
        System.out.println(obj.findParent(0) == obj.findParent(3));
        obj.union(0,3);
        System.out.println("Total components: "+ obj.components);
        System.out.println(obj.findParent(0) == obj.findParent(3));

        System.out.println("Total components: "+ obj.components);
    }
}
