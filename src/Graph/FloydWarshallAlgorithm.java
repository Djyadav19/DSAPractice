package Graph;

public class FloydWarshallAlgorithm {

    public void floydWarshall(int[][] dist) {
        // Code here

        // floydWarshell means to find the all possible root to the target node from source
        // via k node. so need to give the relaxation for k.
        int INF = (int)1e8;
        for(int k = 0;k<dist.length;k++){
            for (int i= 0;i<dist.length;i++){
                for(int j= 0;j<dist.length;j++){
                    if(dist[i][k] !=INF && dist[k][j] != INF)
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
            int INF = (int)1e8;
            int[][] dist = {
                {0, 4, INF, 5, INF},
                {INF, 0, 1, INF, 6},
                {2, INF, 0, 3, INF},
                {INF, INF, 1, 0, 2},
                {1, INF, INF, 4, 0}
            };
            FloydWarshallAlgorithm fwa = new FloydWarshallAlgorithm();
            fwa.floydWarshall(dist);
            for(int i = 0;i<dist.length;i++){
                for(int j= 0;j<dist.length;j++){
                    System.out.print(dist[i][j]+",");
                }
                System.out.print("\n");
            }
        }
}
