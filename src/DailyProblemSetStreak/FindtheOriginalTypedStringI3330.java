package DailyProblemSetStreak;

public class FindtheOriginalTypedStringI3330 {
    public int possibleStringCount(String word) {
        /**
         * *
         *          *  one thing is that we need to take 1 as it the correct one.
         *          *  after that for each occurance he have choice either to keep it or remove it.
         *          *  so for each character the answer will be increase the possibility by 1.
         */
        int answer = 1;
        for(int i = 1;i<word.length();i++){
            if(word.charAt(i)==word.charAt(i-1)){
                answer++;
            }
        }
        return answer;
        /**
        int i = 0;
        int answer = 0;
        while(i<word.length()){
            char ch = word.charAt(i);
            int freq = 0;
            i++;
            while( i<word.length() && ch == word.charAt(i)){
                freq++;
                i++;
            }
            answer += freq;
        }
        return answer+1;
        */
    }
}
