package DailyProblemSetStreak;

import java.util.*;

public class TheEarliestandLatestRoundsWherePlayersCompete1900 {

    int minRound = Integer.MAX_VALUE;
    int maxRound= Integer.MIN_VALUE;
    int f,s;
    Set<String> memo = new HashSet<>();

    private void dfs(List<Integer> players, int round){
        String key = players.toString() + "-" + round;
        if (memo.contains(key)) return;  // Already visited this exact state
        memo.add(key);
        int size = players.size();
        for(int i = 0;i<size/2;i++){
            int leftPlayer = players.get(i);
            int rightPlayer = players.get(size-1-i);
            if((leftPlayer == f && rightPlayer == s)||(rightPlayer == f && leftPlayer == s )){
                minRound = Math.min(round,minRound);
                maxRound = Math.max(round,maxRound);
                return;
            }
        }
        List<List<Integer>> nextRounds = new ArrayList<>();
        generateNextMatches(players,0,new ArrayList<>(),nextRounds);
        for(List<Integer> next: nextRounds){
            dfs(next,round+1);
        }
    }

    private void generateNextMatches(List<Integer> players, int i, List<Integer> temp, List<List<Integer>> res) {
        int n = players.size();
        if (i >= n - i) {
            List<Integer> next = new ArrayList<>(temp);
            Collections.sort(next);  // Must sort to match ordering
            res.add(next);
            return;
        }

        int left = players.get(i);
        int right = players.get(n - 1 - i);

        // always keep firstPlayer and secondPlayer if present
        if (left == f || left == s) {
            temp.add(left);
            generateNextMatches(players, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        } else if (right == f || right == s) {
            temp.add(right);
            generateNextMatches(players, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        } else {
            // Try both outcomes
            temp.add(left);
            generateNextMatches(players, i + 1, temp, res);
            temp.remove(temp.size() - 1);

            temp.add(right);
            generateNextMatches(players, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }

        // If odd number, middle player advances automatically
        if (i == n - 1 - i) {
            temp.add(left);  // left == right here
            generateNextMatches(players, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        f = firstPlayer;
        s = secondPlayer;
        List<Integer> players = new ArrayList<>();
        for(int i = 1;i<=n;i++) {
            players.add(i);
        }
        dfs(players,1);
        return new int[]{minRound,maxRound};

    }
}
