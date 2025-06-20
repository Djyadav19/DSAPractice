package DailyProblemSetStreak;

public class MaximumManhattanDistanceAfterKChanges3443 {
    public int maxDistance(String s, int k) {
        /**
         * key to take away is when we modify we get increase of 2step for one modification.
         * best case will steps taken == md.
         * if not then steps got wasted.
         * so those wasted steps can be taken from the bandwidth what we have.
         */
        int n = 0, south = 0, e = 0, w =0;
        int md = 0;
        // directly steps count = i+ 1;int stepCount = 0;
        int bandWidth = 2*k;
        int maxDist = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'N') n++;
            else if(c == 'S') south++;
            else if(c =='E')e++;
            else w++;
            int dx = Math.abs(e-w);
            int dy = Math.abs(n-south);
            int extraStepsFromBandWidth = 0;
            md = dx+dy;
            if (md < i+1){
                int wastedSteps = i+1 - md;
                extraStepsFromBandWidth = Math.min(bandWidth, wastedSteps);
            }
            maxDist = Math.max(md + extraStepsFromBandWidth,maxDist);
        }
        maxDist = Math.min(s.length(), maxDist);
        return maxDist;
    }

    public static void main(String[] args) {
        MaximumManhattanDistanceAfterKChanges3443 solver = new MaximumManhattanDistanceAfterKChanges3443();
        System.out.println(solver.maxDistance("NSEW", 1)); // Example test case
        System.out.println(solver.maxDistance("NNNN", 2)); // All north, 2 changes
        System.out.println(solver.maxDistance("EESSWW", 3)); // Mixed directions, 3 changes
        System.out.println(solver.maxDistance("N", 0)); // Single move, no changes
        System.out.println(solver.maxDistance("SENW", 2)); // All directions, 2 changes
    }

}
