package DailyProblemSetStreak;

public class FindtheKthCharacterinStringGameI3304 {
    public char kthCharacter(int k) {
        //count the bit.
        int bitCount = Integer.bitCount(k-1);
        return (char) ('a'+bitCount);

       /** String startWord = "a";
        int count = 1;
        while(startWord.length() < k){
            StringBuilder newTemp = new StringBuilder();
            count = startWord.length();
            for(int i = 0;i<startWord.length() && k > count+i;i++){
                newTemp.append((char)(startWord.charAt(i) == 'z'?'a':startWord.charAt(i) + 1));
            }
            startWord = startWord + newTemp.toString();
        }
        return startWord.charAt(k-1);
        */
    }

    public static void main(String[] args) {
        FindtheKthCharacterinStringGameI3304 solver = new FindtheKthCharacterinStringGameI3304();
        System.out.println(solver.kthCharacter(1));   // Expected: a
        System.out.println(solver.kthCharacter(2));   // Expected: b
        System.out.println(solver.kthCharacter(3));   // Expected: b
        System.out.println(solver.kthCharacter(4));   // Expected: c
        System.out.println(solver.kthCharacter(10));  // Example test
        System.out.println(solver.kthCharacter(500)); // Edge test
    }

}
