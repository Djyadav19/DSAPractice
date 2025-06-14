package DailyProblemSetStreak;

public class MaximumDifferencebyRemappingaDigit2566 {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        char toBeMax = 0;
        char toBeMin = 0;
        boolean maxTaken = false;
        boolean minTaken = false;
        StringBuilder maxString = new StringBuilder();
        StringBuilder minString = new StringBuilder();
        for(int i = 0;i<chars.length;i++){
            if(chars[i] != '9' && !maxTaken){
                toBeMax = chars[i];
                maxTaken = true;
                maxString.append('9');
            } else if(chars[i] == toBeMax  && maxTaken){
                maxString.append('9');
            }else{
                maxString.append(chars[i]);
            }
            if(chars[i] != '0' && !minTaken){
                toBeMin = chars[i];
                minTaken = true;
                minString.append('0');
            } else if(chars[i] == toBeMin  && minTaken){
                minString.append('0');
            }else{
                minString.append(chars[i]);
            }
        }
        return  (Integer.parseInt(maxString.toString()) -Integer.parseInt(minString.toString()));
    }

    public static void main(String[]args){
        MaximumDifferencebyRemappingaDigit2566 solver = new MaximumDifferencebyRemappingaDigit2566();
        System.out.println(solver.minMaxDifference(11891));
    }
}
