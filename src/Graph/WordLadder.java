package Graph;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // convert the wordList to Set so that it will make easy to search and will be used to check visited.
        Set<String> wordSet = new HashSet<>(wordList);
        //remove the begin word if exists.
        if(wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;

        while (!queue.isEmpty()){
            int tempLevel = queue.size();
            for(int i = 0;i<tempLevel;i++){
                String node = queue.poll();
                if(node.equals(endWord)){
                    return ++level;
                }
                List<String> adjList = getAdjList(node,wordSet);
                for(String neighbour: adjList){
                    if(wordSet.contains(neighbour)){
                        wordSet.remove(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
            level++;

        }
        return 0;

    }

    private List<String> getAdjList(String node, Set<String> wordSet) {
        List<String> neighbours = new ArrayList<>();
        for(int i = 0;i<node.length();i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == node.charAt(i)) {
                    continue;
                }
                String newWord = node.substring(0, i) + ch + node.substring(i+1, node.length());
                if (wordSet.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }

    public static void main (String[] args){
        WordLadder obj = new WordLadder();
        String beginWord = "hit", endWord = "cog";
        List<String>wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Minimum word change : " + obj.ladderLength(beginWord,endWord,wordList));
    }
}
