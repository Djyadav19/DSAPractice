package Graph;

import java.util.*;

public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // convert the wordList to Set so that it will make easy to search and will be used to check visited.
        List<List<String>> ansList = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        //remove the begin word if exists.
        if(wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }
        Queue<List<String>> queue = new LinkedList<>();
        List<String> dummyList = new ArrayList<>();
        dummyList.add(beginWord);
        queue.offer(dummyList);
        int level = 0,resultLevel = -1;
        List<String> currentNodeList = new ArrayList<>();
        while (!queue.isEmpty()){
            HashSet<String> usedWords = new HashSet<>();
            int tempLevel = queue.size();
            for(int i = 0;i<tempLevel;i++){
                List<String> nodeList = queue.poll();
                String node = nodeList.get(nodeList.size()-1);
                if(node.equals(endWord)){
                    ansList.add(nodeList);
                    resultLevel = level;
                }
                List<String> adjList = getAdjList(node,wordSet);
                for(String neighbour: adjList){
                    if(wordSet.contains(neighbour)){
                        nodeList.add(neighbour);
                        usedWords.add(neighbour);
                        queue.offer(new ArrayList<>(nodeList));
                        nodeList.remove(neighbour);
                    }
                }
            }
            for(String word: usedWords){
                wordSet.remove(word); //here it will marked as visited as we removed from the array.
            }
            if(level == resultLevel){
                break;
            }
            level++;

        }
        return ansList;
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
        WordLadder2 obj = new WordLadder2();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Minimum word change : " + obj.findLadders(beginWord,endWord,wordList));
    }
}
