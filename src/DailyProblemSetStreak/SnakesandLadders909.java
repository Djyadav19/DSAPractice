package DailyProblemSetStreak;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesandLadders909 {

    private int[] helperMethodToCreateRowAndCol(int cellNumber, int length) {
        int rowFromBottom = (cellNumber - 1) / length;         // how many rows up from bottom
        int colInRow = (cellNumber - 1) % length;              // position in that row (before adjusting for zigzag)

        int actualRow = length - 1 - rowFromBottom;       // convert from bottom-up to top-down index

        int actualCol = rowFromBottom % 2 == 0       // even row (from bottom) → left to right
                ? colInRow
                : length - 1 - colInRow;                      // odd row (from bottom) → right to left

        return new int[]{actualRow, actualCol};
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n*n+1];
        queue.offer(1);
        visited[1] = true;
        int stepsCount = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0) {
                int currentPosition = queue.poll();
                if (currentPosition == n * n) {
                    return stepsCount;
                }
                 for (int i = 1; i <= 6; i++) {
                    int neigh = currentPosition+i;
                    if (neigh > n*n) continue;
                     int rowAndCols[] = helperMethodToCreateRowAndCol(neigh, n);
                     int r = rowAndCols[0];
                     int c = rowAndCols[1];
                     int destination = board[r][c] != -1 ? board[r][c] : neigh;
                     if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            stepsCount++;
        }
        return -1;
    }

    public static void main(String [] args){
        int[][] board = {
                  {-1, -1, -1, 46, 47, -1, -1, -1},
                  {51, -1, -1, 63, -1, 31, 21, -1},
                  {-1, -1, 26, -1, -1, 38, -1, -1},
                  {-1, -1, 11, -1, 14, 23, 56, 57},
                  {11, -1, -1, -1, 49, 36, -1, 48},
                  {-1, -1, -1, 33, 56, -1, 57, 21},
                  {-1, -1, -1, -1, -1, -1, 2, -1},
                  {-1, -1, -1, 8, 3, -1, 6, 56}
              };
        SnakesandLadders909 obj = new SnakesandLadders909();
        int result = obj.snakesAndLadders(board);
        System.out.println(result); // Output: 4
    }
}
