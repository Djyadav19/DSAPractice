package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    int rows,cols;

    /*
        private void dfs(int row, int col, int newColor, int currentColor,boolean [][] visited, int[][] image){
            //constraint row col
            if((row < 0 || row >= rows || col < 0 || col >= cols) || currentColor != image[row][col] || visited[row][col] ){
                return;
            }
            visited[row][col] = true;
            image[row][col] = newColor;
            int[][]adjList = {{row,col-1},{row,col+1},{row-1,col},{row+1,col}};
            for(int[] node : adjList){
                dfs(node[0],node[1],newColor,currentColor,visited,image);
            }
        }

        */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        // boolean [][]visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr,sc});
        int colorOfNode = image[sr][sc];
        image[sr][sc] = color;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int[][] adjList = {{row,col-1},{row,col+1},{row-1,col},{row+1,col}};
            for(int[] neigh : adjList){
                int r = neigh[0];
                int c = neigh[1];
                if((r < 0 || r >= rows || c < 0 || c >= cols) || image[r][c] != colorOfNode || image[r][c] == color ){
                    continue;
                }
                image[r][c] = color;
                queue.offer(neigh);
            }
        }
        // dfs(sr,sc,color,image[sr][sc],visited,image);
        return image;
    }

    public static void main(String[]args){
        int[][] image = new int[3][3];
        image[0][0] = 1;
        image[0][1] = 1;
        image[0][2] = 1;
        image[1][0] = 1;
        image[1][1] = 1;
        image[1][2] = 0;
        image[2][0] = 1;
        image[2][1] = 0;
        image[2][2] = 1;

        FloodFill obj = new FloodFill();
        //start = 1,1
        int[][]and =  obj.floodFill( image,  1,  1,  2);
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                System.out.print(and[i][j]+" ");
            }
            System.out.println("\n");
        }

    }
}
