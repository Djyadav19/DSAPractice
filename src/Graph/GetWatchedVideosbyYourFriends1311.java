package Graph;

import java.util.*;

public class GetWatchedVideosbyYourFriends1311 {

    class  Pair implements Comparable<Pair>{
        String videos;
        int freq;
        Pair(String videos,int freq){
            this.videos = videos;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.freq == that.freq){
                return this.videos.compareTo(that.videos);
            }
            return this.freq-that.freq;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String > ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        Set<Integer> visited = new HashSet<>();
        visited.add(id);
        int levelVisited = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int node = queue.poll();
                int[] adjList = friends[node];

                for(int nearestFried : adjList){
                    if(visited.add(nearestFried)){
                        queue.offer(nearestFried);
                    }
                }
            }
            levelVisited++;
            if(level == levelVisited){
                break;
            }
        }
        //so now I can use the visited to get the watched movies from the list.
        Map<String,Integer> movieFreq = new HashMap<>();
        while(!queue.isEmpty()){
            int personId = queue.poll();
            List<String> watechedMoviesList =  watchedVideos.get(personId);
            for(String watched: watechedMoviesList){
                movieFreq.put(watched, movieFreq.getOrDefault(watched,0)+1);
            }
        }

        List<Pair> movieFreqList = new ArrayList<>();
        for(String movie: movieFreq.keySet()){
            movieFreqList.add(new Pair(movie,movieFreq.get(movie)));
        }
        Collections.sort(movieFreqList);
        for(Pair pair : movieFreqList){
            ans.add(pair.videos);
        }
        return ans;
    }


    public static void main(String [] args){
        GetWatchedVideosbyYourFriends1311 obj = new GetWatchedVideosbyYourFriends1311();

        List<List<String>> watchedVideos = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("C"),
            Arrays.asList("B", "C"),
            Arrays.asList("D")
        );
        int[][] friends = {
            {1, 2},
            {0, 3},
            {0, 3},
            {1, 2}
        };
        int id = 0, level = 1;
        System.out.println(obj.watchedVideosByFriends(watchedVideos, friends, id, level));

    }
}
