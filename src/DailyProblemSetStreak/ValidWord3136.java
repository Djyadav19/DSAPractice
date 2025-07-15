package DailyProblemSetStreak;

public class ValidWord3136 {

    private boolean checkVowel(char c){
        if(c == 'a' || c == 'e'||c == 'i'||c == 'o'||c == 'u'||c == 'A'||c == 'E'||c == 'I'||c == 'O'||c == 'U'){
            return true;
        }
        return false;
    }
    public boolean isValid(String word) {

        int size = 0,cons = 0, vowel = 0;
        for(int i = 0;i<word.length();i++){
            size++;
            char c = word.charAt(i);
            if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)){
                if(checkVowel(c)){
                    vowel++;
                }else{
                    cons++;
                }
                if(size >= 3 && vowel >=1 && cons >= 1){
                    return true;
                }
            }

        }
        return false;
    }

    public static void main (String[] args){
        ValidWord3136 solver = new ValidWord3136();
        System.out.println(solver.isValid("aya"));
    }
}
