package LeetCode75.GraphDFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysandRooms841 {

    private void dfs(int currentNode , Set<Integer> visited, List<List<Integer>> rooms){
        if(visited.contains(currentNode)){
            return;
        }
        visited.add(currentNode);
        for(int neigh : rooms.get(currentNode)){
            if(!visited.contains(neigh)){
                dfs(neigh,visited,rooms);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(0,visited,rooms);
        return visited.size() == rooms.size()? true: false;

    }

    public static void main(String[] args) {
            KeysandRooms841 solver = new KeysandRooms841();

            // Test case 1: All rooms can be visited
            List<List<Integer>> rooms1 = List.of(
                List.of(1),        // Room 0 has key to room 1
                List.of(2),        // Room 1 has key to room 2
                List.of(3),        // Room 2 has key to room 3
                List.of()          // Room 3 has no keys
            );
            System.out.println(solver.canVisitAllRooms(rooms1)); // Expected: true

            // Test case 2: Not all rooms can be visited
            List<List<Integer>> rooms2 = List.of(
                List.of(1,3),      // Room 0 has keys to rooms 1 and 3
                List.of(3,0,1),    // Room 1 has keys to rooms 3, 0, and 1
                List.of(2),        // Room 2 has key to room 2
                List.of(0)         // Room 3 has key to room 0
            );
            System.out.println(solver.canVisitAllRooms(rooms2)); // Expected: false

            // Test case 3: Only one room
            List<List<Integer>> rooms3 = List.of(
                List.of()          // Room 0 has no keys
            );
            System.out.println(solver.canVisitAllRooms(rooms3)); // Expected: true
        }

}
