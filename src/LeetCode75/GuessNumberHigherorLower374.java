package LeetCode75;

public class GuessNumberHigherorLower374 {
    int n = 0;
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        while(l<=r){
            int mid = l + (r-l)/2;
            int response = guess(mid);
            if (response == 0) return mid;
            else if (response < 0) r = mid - 1;
            else l = mid + 1;
        }
        return -1;

    }

    private int guess(int mid) {
        if(n == mid) return 0;
        else if(n < mid) return 1;
        else return -1;

    }

    public static void main(String[] args) {
        GuessNumberHigherorLower374 game = new GuessNumberHigherorLower374();

        // Test case 1: n = 10, pick = 6
        game.n = 6;
        System.out.println("Test 1: " + (game.guessNumber(10) == 6));

        // Test case 2: n = 1, pick = 1
        game.n = 1;
        System.out.println("Test 2: " + (game.guessNumber(1) == 1));

        // Test case 3: n = 100, pick = 100
        game.n = 100;
        System.out.println("Test 3: " + (game.guessNumber(100) == 100));

        // Test case 4: n = 50, pick = 25
        game.n = 25;
        System.out.println("Test 4: " + (game.guessNumber(50) == 25));
    }
}
