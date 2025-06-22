package DailyProblemSetStreak;

public class DivideaStringIntoGroupsofSizek2138 {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length() % k == 0 ? s.length()/k : s.length()/k + 1;
        String[] groups = new String[n];
        for(int i = 0;i < n;i++){
            groups[i] = s.substring(i*k, Math.min((i*k)+k,s.length()));
        }
        if(groups[n-1].length() < k){
            StringBuilder lastString = new StringBuilder(groups[n-1]);
            for(int i = lastString.length();i<k;i++){
                lastString.append(fill);
            }
            groups[n-1] = lastString.toString();
        }
        return groups;
    }
    public static void main(String[] args) {
        DivideaStringIntoGroupsofSizek2138 solver = new DivideaStringIntoGroupsofSizek2138();

        // Test case 1
        String[] result1 = solver.divideString("usukzxkpxuzvzqwbwkgulnfelrkndfzqbrbhxwsgmjahxqkyoekicwbsndnundojugway", 6, 'y');
        System.out.println(java.util.Arrays.toString(result1)); // Expected: [abc, def, ghi]

        // Test case 2
        String[] result2 = solver.divideString("abcdefghij", 3, 'x');
        System.out.println(java.util.Arrays.toString(result2)); // Expected: [abc, def, ghi, jxx]

        // Test case 3
        String[] result3 = solver.divideString("a", 2, 'z');
        System.out.println(java.util.Arrays.toString(result3)); // Expected: [az]
    }
}
