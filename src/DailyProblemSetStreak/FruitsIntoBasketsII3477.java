package DailyProblemSetStreak;

public class FruitsIntoBasketsII3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        for(int i = 0;i<fruits.length;i++){
            for(int j = 0;j<baskets.length;j++){
                if(fruits[i] <= baskets[j] ){
                    baskets[j] = 0;
                    ans++;
                    break;
                }
            }
        }
        return fruits.length-ans;
    }

    public static void main(String[] args){
        FruitsIntoBasketsII3477 solver = new FruitsIntoBasketsII3477();
        int [] fruits = new int[]{4,2,5};
        int [] baskets = new int[]{3,5,4};
        System.out.println(solver.numOfUnplacedFruits(fruits,baskets));
    }
}
