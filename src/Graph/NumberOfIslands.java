package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    int rows,cols;
    int result;
    public void dfs(int row,int col,char[][]grid, boolean[][] visited){
        if(row < 0 || row >= rows || col< 0 || col >= cols || visited[row][col]  || grid[row][col] == '0'){
            return;
        }
        //System.out.println(row+" "+ col+" "+result);
        //result++;
        int[][] adjList = {{row,col+1},{row,col-1},{row-1,col},{row+1,col}};
        visited[row][col] = true;
        for(int node[] : adjList){
            dfs(node[0],node[1],grid,visited);
        }

    }
    public int numIslands(char[][] grid) {
        result = 0 ;
        rows = grid.length;
        cols = grid[0].length;
        boolean [][] visited = new boolean[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == '1'){
                    if(!visited[i][j]){
                        dfs(i,j,grid,visited);
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private int numIslandsUsingBFS(char[][] grid) {
        result = 0 ;
        rows = grid.length;
        cols = grid[0].length;
        boolean [][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == '1'){
                    if(!visited[i][j]){

                        queue.offer(new int []{i,j});
                        visited[i][j] = true;
                        while(!queue.isEmpty()){
                            int [] node = queue.poll();
                            int row = node[0];
                            int col = node[1];
                            int[][]adjList = {{row,col+1},{row,col-1},{row-1,col},{row+1,col}};
                            for(int[] neigh : adjList){
                                int r = neigh[0];
                                int c = neigh[0];
                                if(r >= rows || r<0 || col>= cols ||col < 0 || grid[r][c] == '0' || visited[r][c]){
                                    continue;
                                }
                                visited[r][c] = true;
                                queue.offer(neigh);
                            }
                        }
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String [] args){
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NumberOfIslands obj = new NumberOfIslands();
        System.out.println("Number of Island Using DFS : "+ obj.numIslands(grid));
        System.out.println("Number of Island Using BFS : "+ obj.numIslandsUsingBFS(grid));

    }

}
