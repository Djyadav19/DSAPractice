package DailyProblemSetStreak;

import java.util.Arrays;

public class Candy135 {

    public int candy(int[] ratings) {
        //think like mountain elevation and slopes.
        int n = ratings.length;
        int candyReq = n;
        int i = 1;
        while(i < n){
            if(ratings[i] == ratings[i-1]){
                i++;
                continue;
            }
            int peak = 0;
            while( i<n && ratings[i] > ratings[i-1]){
                peak++;
                candyReq+=peak;
                if(i == n){
                    return candyReq;
                }
                i++;
            }
            int deep = 0;
            while(i<n && ratings[i] <ratings[i-1]){
                deep++;
                candyReq += deep;
                i++;
            }
            candyReq -= Math.min(peak,deep);

        }

        return candyReq;
    }
    /*public int candy(int[] ratings) {

        int n = ratings.length;
        int[] l2r = new int[n];
        //int [] r2l = new int[n];
        Arrays.fill(l2r,1);
        //Arrays.fill(r2l,1);
        for(int i = 1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                l2r[i] = l2r[i-1] + 1;
            }
        }
        for(int i = n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                l2r[i] = Math.max(l2r[i+1] + 1,l2r[i]);
            }
        }
        int candyReq = 0;
        for(int i = 0;i<n;i++){
            candyReq+= l2r[i];
        }
        return candyReq;
    }
*/
    public static void main(String[] args) {
            Candy135 obj = new Candy135();
            int[] ratings = {1, 2, 2};
            int result = obj.candy(ratings);
            System.out.println(result); // Output: 4
        }
}
