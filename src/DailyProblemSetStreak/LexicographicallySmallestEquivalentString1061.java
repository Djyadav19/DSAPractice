package DailyProblemSetStreak;

import java.util.*;

public class LexicographicallySmallestEquivalentString1061 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        /*
        let's create adjList.
         */
        Map<Character,List<Character>> adjMap = new HashMap<>();

        for(int i = 0;i<s1.length();i++){
            List<Character> s1tos2 = adjMap.getOrDefault(s1.charAt(i),new ArrayList<>());
            s1tos2.add(s2.charAt(i));
            adjMap.put(s1.charAt(i),s1tos2);
            List<Character> s2tos1 = adjMap.getOrDefault(s2.charAt(i),new ArrayList<>());
            s2tos1.add(s1.charAt(i));
            adjMap.put(s2.charAt(i),s2tos1);
        }
        StringBuilder sb = new StringBuilder();

        for(char c : baseStr.toCharArray()){
            Set<Character> visited = new HashSet<>();
            sb.append(dfs(c,Character.MAX_VALUE,adjMap,visited,sb));
        }

        return sb.toString();
    }

    private char dfs(char c, char base, Map<Character, List<Character>> adjMap, Set<Character> visited, StringBuilder sb) {
        if(visited.contains(c)){
            if(c > base){
                return  base;
            }
            return c;
        }
        visited.add(c);
        List<Character> neighbours = adjMap.getOrDefault(c,new ArrayList<>());
        char tempChar = Character.MAX_VALUE;
        if(base > c){;
            tempChar = c;
        }else {
            tempChar = base;
        }
        for(char ch : neighbours){
            if(!visited.contains(ch)) {
                char dfsChar =  dfs(ch, c, adjMap, visited, sb);
                if(tempChar > dfsChar ){
                    tempChar = dfsChar;
                }
            }
        }

        return tempChar;
    }

    public static void main(String[] args) {
        LexicographicallySmallestEquivalentString1061 solver = new LexicographicallySmallestEquivalentString1061();

        String res2 = solver.smallestEquivalentString("hello", "world", "hold");
        System.out.println(res2); // Output: "hdld"

        String res3 = solver.smallestEquivalentString("parker", "morris", "parser");
        System.out.println(res3); // Output: "makkek"

        String res1 = solver.smallestEquivalentString("leetcode", "programs", "sourcecode");
        System.out.println(res1); // Output: "aauaaaaada"




    }
}
