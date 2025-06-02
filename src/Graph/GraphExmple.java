package Graph;

import java.util.ArrayList;
import java.util.List;

class pair{
    int n;
    int weight;
    pair(int n, int w){
        this.n = n;
        this.weight = w;
    }

    @Override
    public String toString() {
        return "node : " + n + " , weight: " + weight;
    }
}

class Graph{
    //adjecentMatrix
    int adjMatrix[][];

    List<List<Integer>> adjList;

    List<List<pair>> adjListWithWeight;
    Graph(int nodes){
        adjMatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        adjListWithWeight = new ArrayList<>();
        for(int i = 0;i < nodes;i++){
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }
    public List<List<Integer>> getAdjList(){
        return adjList;
    }

    public List<List<pair>> getAdjListWithWeight(){
        return adjListWithWeight;
    }

    public void setAdjMatrix(int u , int v){
        adjMatrix[u][v] = 1;
    }
    public void setWeightedAdjMatrix(int u , int v,int weight){
        adjMatrix[u][v] = weight;
    }

    public int[][] getAdjMatrix(){
        return adjMatrix;
    }

    public List<Integer> degree(){
        List<Integer> degree = new ArrayList<>();
        for(List<Integer> node : adjList){
            degree.add(node.size());
        }
        System.out.println("\n Degree of the Graph.Graph : "+degree);
        return degree;
    }
}



public class GraphExmple {

    public static void addEdegesInMatrix(int edges[][],boolean isDirected, Graph graph){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            if(isDirected){
                graph.setAdjMatrix(u,v);
            } else{
                //un directed so will be path for both the sides.
                graph.setAdjMatrix(u,v);
                graph.setAdjMatrix(v,u);
            }
        }
    }

    public static void addWeightedEdegesInMatrix(int edges[][],boolean isDirected, Graph graph){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(isDirected){
                graph.setWeightedAdjMatrix(u,v,w);
            }else{
                //un directed so will be path for both the sides.
                graph.setWeightedAdjMatrix(u,v,w);
                graph.setWeightedAdjMatrix(v,u,w);
            }
        }
    }

    public static void printGraph(Graph graph){
        //print like a 2Dmatrix
        System.out.print("Graph.Graph : \n");
        for(int i = 0;i<graph.getAdjMatrix().length;i++){
            System.out.print("Row : " + i + " :-> ");
            for(int j = 0; j<graph.getAdjMatrix().length;j++){
                System.out.print(graph.getAdjMatrix()[i][j] + ",");
            }
            System.out.print("\n");
        }
    }

    public static void addEdegesInList(int edges[][],boolean isDirected, Graph graph){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            if(isDirected){
                graph.getAdjList().get(u).add(v);
            } else{
                //un directed so will be path for both the sides.
                graph.getAdjList().get(u).add(v);
                graph.getAdjList().get(v).add(u);
            }
        }
    }

    public static void addWeightedEdegesInList(int edges[][],boolean isDirected, Graph graph){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(isDirected){
                graph.getAdjListWithWeight().get(u).add(new pair(v,w));
            } else{
                //un directed so will be path for both the sides.
                graph.getAdjListWithWeight().get(u).add(new pair(v,w));
                graph.getAdjListWithWeight().get(v).add(new pair(u,w));
            }
        }
    }

    public static void printAdjList(Graph graph){
        System.out.println("\nAdjList: " + graph.getAdjList());

    }

    public static void printAdjListWithWeight(Graph graph){
        System.out.println("\nAdjList: " + graph.getAdjListWithWeight());

    }

    public static  void main(String args[]){
        int edges[][] = {{0,2,10},{0,1,20},{1,3,30}};
        int numberOfVertex = 4;
        Graph graph = new Graph(4);
        addEdegesInMatrix(edges,false,graph);
        System.out.println("Undirected Graph.Graph");
        printGraph(graph);

        int edges2[][] = {{0,2},{0,1},{1,3}};
        Graph graph1 = new Graph(4);
        addEdegesInList(edges2,false,graph1);
        printAdjList(graph1);
        graph1.degree();
        addWeightedEdegesInList(edges,false,graph);
        printAdjListWithWeight(graph);

        Graph directedGraph = new Graph(4);
        addEdegesInMatrix(edges,true,directedGraph);
        addEdegesInList(edges,true,directedGraph);
        System.out.println("Directed Graph.Graph");
        printGraph(directedGraph);


        Graph weightedGraph = new Graph(4);
        addWeightedEdegesInMatrix(edges,false,weightedGraph);
        addEdegesInList(edges,false,weightedGraph);
        System.out.println("weighted Undirected Graph.Graph");
        printGraph(weightedGraph);

        Graph weightedDirectedGraph = new Graph(4);
        addWeightedEdegesInMatrix(edges,true,weightedDirectedGraph);
        addEdegesInList(edges,true,weightedDirectedGraph);
        System.out.println("weighted Directed Graph.Graph");
        printGraph(weightedDirectedGraph);
    }
}
