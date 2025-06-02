package Graph;

import java.util.*;

public class EvaluateDivision399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //generate the adj map here as it make the lookup easy for the values.
        Map<String,HashMap<String,Double>> adjMap = new HashMap<>();
        double[] ans = new double[queries.size()];
        for(int i = 0;i < values.length;i++){
            List<String> equation = equations.get(i);
            String dividend  = equation.get(0);
            String divisor = equation.get(1);
            double cost = values[i];
            
            if(!adjMap.containsKey(dividend)){
                adjMap.put(dividend,new HashMap<String ,Double>());
            }
            if(!adjMap.containsKey(divisor)){
                adjMap.put(divisor,new HashMap<String ,Double>());
            }
            adjMap.get(dividend).put(divisor,cost);
            adjMap.get(divisor).put(dividend,1/cost);
        }

        for(int i = 0;i<queries.size();i++){
            List<String> query = queries.get(i);

            String start = query.get(0);
            String target = query.get(1);
            if(!adjMap.containsKey(start) || !adjMap.containsKey(target)){
                ans[i] = -1.00000;
                continue;
            }
            if(start.equals(target)){
                ans[i] = 1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();
            ans[i] =dfs((HashMap<String, HashMap<String, Double>>) adjMap,visited,1.00000,start,target);

        }
        return ans;
    }

    private double dfs(Map<String, HashMap<String, Double>> adjMap, Set<String> visited, double cost, String start, String target) {
        double ret = -1.0;
        visited.add(start);
        if(adjMap.get(start).containsKey(target)){
            ret = cost * adjMap.get(start).get(target);
        } else{
            // will run dfs
            for(String neighbour : adjMap.get(start).keySet()){
                if(!visited.contains(neighbour)){
                    ret  = dfs(adjMap,visited,cost * adjMap.get(start).get(neighbour),neighbour,target);
                    if(ret != -1.0){
                        break;
                    }
                }
            }
        }
        //to use backtracking need to remove from the visited so that it can divide the value multiplied.
        visited.remove(start);
        return ret;
    }


    public static void main (String[] args){
        EvaluateDivision399 obj = new EvaluateDivision399();
        List<List<String>> equations = List.of(
            List.of("x1", "x2"),
            List.of("x2", "x3"),
            List.of("x3", "x4"),
            List.of("x4", "x5")
        );
        double[] values = {3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = List.of(
            List.of("x1", "x5"),
            List.of("x5", "x2"),
            List.of("x2", "x4"),
            List.of("x2", "x2"),
            List.of("x2", "x9"),
            List.of("x9", "x9")
        );
        double[] ans  = obj.calcEquation(equations,values,queries);
        for(double d : ans){
            System.out.print(d + " ");
        }
       // out put [360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000]
    }
}
