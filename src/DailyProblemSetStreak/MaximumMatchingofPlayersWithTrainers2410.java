package DailyProblemSetStreak;

import java.util.Arrays;

public class MaximumMatchingofPlayersWithTrainers2410 {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Thread t1 = new Thread(() -> Arrays.sort(players));
        Thread t2 = new Thread(() -> Arrays.sort(trainers));
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch(Exception e){

        }
        int i = 0;
        int j = 0;
        int match = 0;
        while(i < players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                i++;
                j++;
                match++;
            } else if(players[i]>trainers[j]){
                j++;
            }
        }
        return match;

    }

    public static void main(String[] args) {
        MaximumMatchingofPlayersWithTrainers2410 solution = new MaximumMatchingofPlayersWithTrainers2410();

        int[] players1 = {4, 7, 9};
        int[] trainers1 = {8, 2, 5};
        System.out.println(solution.matchPlayersAndTrainers(players1, trainers1)); // Expected: 2

        int[] players2 = {1, 2, 3};
        int[] trainers2 = {2, 3, 4};
        System.out.println(solution.matchPlayersAndTrainers(players2, trainers2)); // Expected: 3

        int[] players3 = {5, 6};
        int[] trainers3 = {1, 2, 3};
        System.out.println(solution.matchPlayersAndTrainers(players3, trainers3)); // Expected: 0
    }
}
