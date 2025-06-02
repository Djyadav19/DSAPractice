package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        List<int[]> zerosList = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(matrix[i][j] == 0){
                    zerosList.add(new int[]{i,j});
                }
            }
        }
        for(int[] index : zerosList){
            for(int j = 0;j<cols;j++){
                matrix[index[0]][j] = 0;
            }
            for(int i = 0;i<rows;i++){
                matrix[i][index[1]] = 0;
            }
        }
    }
    public static void main(String args []){
        SetMatrixZeroes obj = new SetMatrixZeroes();
        int [][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        obj.setZeroes(matrix);
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
