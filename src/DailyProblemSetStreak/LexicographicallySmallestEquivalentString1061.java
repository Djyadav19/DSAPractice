package DailyProblemSetStreak;

import java.util.*;

public class LexicographicallySmallestEquivalentString1061 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        /*
        let's create adjList.
         */
        Map<Character,Set<Character>> adjMap = new HashMap<>();

        //let's convert them to charArray to check the decrease in execution time.
        char[] s1array = s1.toCharArray();
        char[]s2array = s2.toCharArray();
        for(int i = 0;i<s1.length();i++){
            Set<Character> s1tos2 = adjMap.getOrDefault(s1array[i],new HashSet<>());
            s1tos2.add(s2array[i]);
            adjMap.put(s1array[i],s1tos2);
            Set<Character> s2tos1 = adjMap.getOrDefault(s2array[i],new HashSet<>());
            s2tos1.add(s1array[i]);
            adjMap.put(s2array[i],s2tos1);
        }
        StringBuilder sb = new StringBuilder();

        //let's try caching.
        Map<Character,Character> cache = new HashMap<>();
        for(char c : baseStr.toCharArray()){
            Set<Character> visited = new HashSet<>();
            if(!cache.containsKey(c)) {
                sb.append(dfs(c, Character.MAX_VALUE, adjMap, visited));
            }else {
                sb.append(cache.get(c));
            }
        }

        return sb.toString();
    }

    private char dfs(char c, char base, Map<Character, Set<Character>> adjMap, Set<Character> visited) {
        if(visited.contains(c)){
            if(c > base){
                return  base;
            }
            return c;
        }
        visited.add(c);
        Set<Character> neighbours = adjMap.getOrDefault(c,new HashSet<>());
        char tempChar = Character.MAX_VALUE;
        if(base > c){;
            tempChar = c;
        }else {
            tempChar = base;
        }
        for(char ch : neighbours){
            if(!visited.contains(ch)) {
                char dfsChar =  dfs(ch, c, adjMap, visited);
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
