package DailyProblemSetStreak;

public class DivisibleandNondivisibleSumsDifference2894 {

    public int differenceOfSums(int n, int m) {
        int divSum =0;
        int noDivSum =0;
        for(int i = 1;i<=n;i++){
            if(i%m == 0){
                divSum += i;
            }else{
                noDivSum += i;
            }
        }
        return noDivSum - divSum;

    }

    public static void main(String[] args) {
            DivisibleandNondivisibleSumsDifference2894 obj = new DivisibleandNondivisibleSumsDifference2894();
            int n = 10, m = 3;
            int result = obj.differenceOfSums(n, m);
            System.out.println(result);
        }
}
