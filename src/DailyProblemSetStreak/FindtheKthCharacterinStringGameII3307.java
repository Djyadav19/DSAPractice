package DailyProblemSetStreak;

public class FindtheKthCharacterinStringGameII3307 {

    public char kthCharacter(long k, int[] operations) {
        /**
         * here we first find out that after how many jump we are going to find the k th position
         * since in each simulation we double the size so need to take logk base 2 to get the number of jump.
         * After getting the jump now we will find the last index of the jump-1 it will be the middle point for this jump.
         * afte getting the middle we will locate how far we are from the middle.
         * this distance will give us position which has been changed .
         * and from the operation array we will get that we have made the change or not.
         * if change has been made we will add that and shift 'a' that many times will get the result.
         */
        int ops = 0;
        long currValue = k;
        while(currValue>1){
            int jump = (int) Math.ceil((Math.log(currValue)/Math.log(2)));
            long middle = (long)Math.pow(2,jump-1);
            currValue = currValue-middle;
            ops += operations[jump-1];
        }
        return (char)('a' + (ops%26));
    }

    public static void main(String[] args) {
        FindtheKthCharacterinStringGameII3307 solver = new FindtheKthCharacterinStringGameII3307();

        // Test case 1
        int[] operations1 = {0,1,0,1};
        long k1 = 10;
        System.out.println("Test 1: " + solver.kthCharacter(k1, operations1)); // Output depends on logic

    }
}
