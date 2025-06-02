package Graph;

import java.util.*;

public class AccountsMerge721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> mergedAccount = new ArrayList<>();
        Map<String,List<String>> adjMap = new HashMap<>();
        constructAdjMap(adjMap,accounts);
        Set<String> visited = new HashSet<>();
        for(int i  = 0;i<accounts.size();i++){
            Set<String> subSet = new HashSet<>();
            if(!visited.contains(accounts.get(i).get(1))){
                dfs(accounts.get(i).get(1),adjMap,accounts,subSet,visited);
            }
            if(!subSet.isEmpty()){
            List <String>subList = new ArrayList<>(subSet);
            Collections.sort(subList);
            subList.addFirst(accounts.get(i).get(0));
            mergedAccount.add(subList);
            }

        }

        return mergedAccount;
    }

    private void dfs(String start, Map<String, List<String>> adjMap, List<List<String>> accounts, Set<String> subList, Set<String> visited) {
        visited.add((start));
        subList.add(start);
        List<String> neighbours = adjMap.get(start);
        if(neighbours != null && neighbours.size()>0) {
            for (String neigh : adjMap.get(start)) {
                if (!visited.contains(neigh)) {
                    dfs(neigh, adjMap, accounts, subList, visited);
                }
            }
        }
    }

    private void constructAdjMap(Map<String, List<String>> adjMap, List<List<String>> accounts) {
        for(List<String> account : accounts){
            List<String> subList = account.subList(2,account.size());
            String key = account.get(1);
            adjMap.putIfAbsent(key,new ArrayList<>());
            for(String neigh : subList){
                List<String> KeyNeighList = adjMap.get(key);
                KeyNeighList.add(neigh);
                List<String > neighList = adjMap.getOrDefault(neigh,new ArrayList<>());
                neighList.add(key);
                adjMap.put(key,KeyNeighList);
                adjMap.put(neigh,neighList);
            }
        }
    }

    public static void main(String[] args){
        //Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        List<List<String>> accounts = List.of(
                    List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                    List.of("John","johnsmith@mail.com","john00@mail.com"),
                    List.of("Mary","mary@mail.com"),
                    List.of("John","johnnybravo@mail.com")
                );
                AccountsMerge721 obj = new AccountsMerge721();
                List<List<String>> result = obj.accountsMerge(accounts);
                System.out.println(result);
    }
}
