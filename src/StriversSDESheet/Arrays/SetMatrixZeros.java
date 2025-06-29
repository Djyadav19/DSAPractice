package StriversSDESheet.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeros {

    private void setZero(int[][] nums) {
        /**
         * let's try for O(1) space.
         * so here in this case we will take the first row and first column as the marker.
         * on the basis of that we will mark the matrix to 0.
         * will always look into the first row and first column
         */
        int row = nums.length;
        int col = nums[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for(int j = 0;j <col;j++) {if( nums[0][j] == 0) {firstRowHasZero = true;break;}}
        for( int i = 0; i< row; i++) { if(nums[i][0] == 0) {firstColHasZero = true;break;}}

        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(nums[i][j] == 0){
                    nums[i][0] = 0;
                    nums[0][j] = 0;
                }
            }
        }

        for(int i = 1;i<row;i++) {
            for (int j = 1; j < col; j++) {
                // check first col and row for 0 if they are zero then make these value 0.
                if (nums[i][0] == 0 || nums[0][j] == 0) {
                    nums[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) for (int j = 0; j < col; j++) nums[0][j] = 0;
        if (firstColHasZero) for (int i = 0; i < row; i++) nums[i][0] = 0;

        /**
         * here one thing we can do is that we get that which indexes are zero.
         * then we can agin iterate and will make that row and col to zero.
         */

        /**
        int n  = nums.length;
        List<int[]> zerosIndex = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums[0].length;j++){
                if(nums[i][j] == 0){
                    zerosIndex.add(new int[]{i,j});
                }
            }
        }
        for(int[] idx : zerosIndex){
            for(int i = 0;i<nums.length;i++){
                nums[idx[0]][i] = 0;
            }
            for(int i = 0;i<nums[0].length;i++){
                nums[i][idx[1]] = 0;
            }
        }*/
    }


    public static void main(String[] args){
        int[][] nums = new int[][]{
                {1,2,3},
                {2,0,5},
                {3,4,5}};
        SetMatrixZeros solver = new SetMatrixZeros();
        solver.setZero(nums);
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums[0].length;j++){
                System.out.print(nums[i][j] + ",") ;
            }
            System.out.println();
        }
    }

}
