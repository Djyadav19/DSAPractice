package Graph;

import java.util.*;

public class RottingOranges994 {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        List<int[]>locationOfRottenOranges = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int countFreshOrange = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 2){
                    int [] loc = new int[2];
                    loc[0] = i;
                    loc[1] = j;
                    queue.offer(loc); // lets add them directly to queue.//locationOfRottenOranges.add(loc);
                }else if(grid[i][j] == 1){
                    countFreshOrange++;
                }
            }
        }

        //need to apply bfs.

        if(countFreshOrange == 0){
            return 0;
        }
        int level = 0;
        while (!queue.isEmpty()){

            int size = queue.size();
            //
            for(int i = 0;i<size;i++){
                int[] node = queue.poll();
                assert node != null;
                int row = node[0];
                int col = node[1];

                int[][] adj = {{row, col+1}, {row, col-1}, {row+1, col}, {row-1, col}};
                for(int[] neighbhour: adj){
                    int r = neighbhour[0];
                    int c = neighbhour[1];
                    if(r < 0 || c < 0 ||r >= rows || c >= cols || grid[r][c] == 0 || grid[r][c] == 2){
                        continue;
                    }
                    grid[r][c] = 2;
                    queue.add(new int[]{r,c});
                    countFreshOrange--;
                }
            }
            level++;
            if(countFreshOrange == 0){
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
