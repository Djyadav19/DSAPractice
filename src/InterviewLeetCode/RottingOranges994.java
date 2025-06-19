package InterviewLeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {
    int rows ;
    int cols;
    public int orangesRotting(int[][] grid) {
        // bfs queue. start .
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresCount = 0;
        // try to get the location of rotten oranges and also count the freshOranges .......
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 2){queue.add(new int []{i,j});}
                else if(grid[i][j] == 1){fresCount++;}

            }
        }
        if(fresCount == 0){
            return 0;
        }
        return bfs(grid, queue, rows, cols, fresCount);

    }

    private int bfs(int[][] grid, Queue<int[]> queue, int rows, int cols, int fresCount) {
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int[] node = queue.poll();
                int row = node[0];
                int col = node [1];
                int[][] adj = {{row,col+1},{row,col-1},{row+1,col},{row-1,col}};
                for(int[] neigh : adj){
                    int r = neigh[0];
                    int c = neigh[1];
                    if(r >= 0 && r < rows && c >= 0 && c < cols){
                        if(grid[r][c] == 1){
                            grid[r][c] = 2;
                            queue.add(new int[]{r,c});
                            fresCount--;
                        }
                    }
                }
            }
            level++;
            if(fresCount == 0){
                return level;
            }
        }
        return -1;
    }


    public static void main(String args[]){
        RottingOranges994 obj = new RottingOranges994();
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(obj.orangesRotting(grid)); // Output: 4
    }
}
