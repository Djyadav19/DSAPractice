package DailyProblemSetStreak;

import java.util.*;

public class SumofkMirrorNumbers2081 {
    public long kMirror(int k, int n) {
        int req = 0;
        long ans = 0;
        //List<Long>generateBase10Palindromes = generateBase10Palindromes();
        //Collections.sort(generateBase10Palindromes);
        int len = 1;
        while (req < n) {
            List<Long> pals = generatePalindromesOfLength(len);
            for(long pal : pals) {
                if(req == n)break;
                if (checkPlaindrom(convertToBaseK(k, pal))) {
                    ans += pal;
                    req++;
                }
            }
            len++;
        }
        return ans;
    }

    private String convertToBaseK(int k, long i) {
        long number = i;
        StringBuilder sb = new StringBuilder();
        while(number>0){
            sb.append(number% k);
            number = number/ k;
        }
        return sb.reverse().toString();
    }

    private boolean checkPlaindrom(String sb) {
        int l = 0;
        int r = sb.length()-1;
        while(l<=r){
            if(sb.charAt(l) != sb.charAt(r)){
                return  false;
            }
            l++;
            r--;
        }
        return true;
    }


    private List<Long> generatePalindromesOfLength(int len) {
        List<Long> res = new ArrayList<>();
        int half = (len + 1) / 2;
        long start = (long) Math.pow(10, half - 1);
        long end = (long) Math.pow(10, half);
        for (long i = start; i < end; i++) {
            String first = Long.toString(i);
            String pal = first + new StringBuilder(first.substring(0, len % 2 == 0 ? first.length() : first.length() - 1)).reverse();
            res.add(Long.parseLong(pal));
        }
        return res;
    }

    private List<Long> generateBase10Palindromes() {
        Set<Long> palindromes = new HashSet<>();

        // 1-digit palindromes: 1 to 9
        for (int i = 1; i < 10; i++) {
            palindromes.add((long) i);
        }

        // Multi-digit palindromes
        for (int i = 1; i < 100000; i++) {
            String s = String.valueOf(i);

            // Odd-length: i = 12 → 121
            String odd = s + new StringBuilder(s.substring(0, s.length() - 1)).reverse();
            palindromes.add(Long.parseLong(odd));

            // Even-length: i = 12 → 1221
            String even = s + new StringBuilder(s).reverse();
            palindromes.add(Long.parseLong(even));
        }
        ;
        return new ArrayList<>(palindromes);
    }

    public static void main(String[] args) {
        SumofkMirrorNumbers2081 solver = new SumofkMirrorNumbers2081();
        System.out.println("k=2, n=5: " + solver.kMirror(2, 5));
        System.out.println("k=3, n=7: " + solver.kMirror(3, 7));
    }
}
