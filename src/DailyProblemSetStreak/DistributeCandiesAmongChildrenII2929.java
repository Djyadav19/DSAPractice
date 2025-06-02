package DailyProblemSetStreak;

public class DistributeCandiesAmongChildrenII2929 {

    public long distributeCandies(int n, int limit) {
        long ans = 0;
        //need to find the min and Max for the first children.
        int firstMax = Math.min(limit,n);
        int firstMin = Math.max(0,n-2*limit); //will give the maximum of limit to two children.
        for(int i = firstMin;i<=firstMax;i++){
            //let's find the secon Max and min.
            int secondMin = Math.max(0,n-i-limit);// let's assume that max of the limit is given to the 3rd.
            int secondMax = Math.min(limit,n-i);

            ans += secondMax-secondMin+1;

        }
        return  ans;
    }
    public static void main(String[] args) {
            DistributeCandiesAmongChildrenII2929 obj = new DistributeCandiesAmongChildrenII2929();
            int n = 3, limit = 3;
            long result = obj.distributeCandies(n, limit);
            System.out.println(result); // Output: 10
        }
}
