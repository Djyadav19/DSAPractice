package DailyProblemSetStreak;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            ans.add(row);
            for(int j = 0;j<=i;j++){
                if(j == 0 ||j== i){
                    row.add(1);
                    continue;
                }
                int left = ans.get(i-1).get(j-1);
                int right = ans.get(i-1).get(j);
                row.add(left+right);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        PascalsTriangle118 solver = new PascalsTriangle118();
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        List<List<Integer>> ans = solver.generate(i);
        for(List<Integer> row : ans){
            for(int index : row){
                System.out.print(index + ",");
            }
            System.out.println();
        }
    }
}
