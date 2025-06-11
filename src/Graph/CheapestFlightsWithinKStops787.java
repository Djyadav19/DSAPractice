package Graph;

import java.util.Arrays;

public class CheapestFlightsWithinKStops787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         // since we have to find the shortest path from soruce to destination using atMost k stops.
        /*
        let's start from source -> and visit all it's neighbours -> upto K relaxation as given in ques.
        we will be using BellManFord algo.
        and in bellmanford algo we need to iterate n-1 time and if we iterate for the next term if there is
        any negative cycle we will get. (Since in question it's given no negative cycle.

         */
        int price[] = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src] = 0;
        for(int i = 0;i<k+1;i++){
            int [] tempPrice = Arrays.copyOf(price,n);
            for(int[]flight : flights){
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if(price[u] != Integer.MAX_VALUE &&  price[u]+w < tempPrice[v] ){
                    tempPrice[v] = price[u]+w;
                }
            }
            price = tempPrice;
        }

        return price[dst] != Integer.MAX_VALUE ? price[dst] : -1;

    }

    public static void main(String[] args){
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        CheapestFlightsWithinKStops787 solver = new CheapestFlightsWithinKStops787();
        int result = solver.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result); // Output: 700
    }
}
