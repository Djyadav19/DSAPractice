package DailyProblemSetStreak;

public class FindtheMaximumLengthofValidSubsequenceI3201 {
    public int maximumLength(int[] nums) {

        int evenCount = 0;
        int oddCount = 0;
        for(int n : nums){
            if(n % 2 == 0){
                evenCount++;
            }else{
                oddCount++;
            }
        }

        int parity = nums[0]%2;
        int alternateCount = 1;
        for(int i = 1;i<nums.length;i++){
            int currParity = nums[i]%2;
            if(currParity != parity){
                alternateCount++;
                parity = currParity;
            }
        }

        return Math.max(Math.max(evenCount,oddCount),alternateCount);
    }

    public static void main(String[] args){
        FindtheMaximumLengthofValidSubsequenceI3201 solver = new FindtheMaximumLengthofValidSubsequenceI3201();
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(solver.maximumLength(arr));
    }
}
