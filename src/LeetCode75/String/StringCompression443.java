package LeetCode75.String;

public class StringCompression443 {
    public int compress(char[] chars) {

        int ans = 0;
        int occurance = 0;
        int prevStoredIdx = 0;
        for(int i = 0;i<chars.length;){
            occurance = 1;
            char currentChar = chars[i];
            int nextPtr = i+1;
            while(nextPtr < chars.length && chars[nextPtr] == currentChar){
                occurance++;
                chars[nextPtr++] = 0;
            }
            chars[prevStoredIdx] = currentChar;
            if(occurance == 1){
                ans += 1;
                prevStoredIdx++;
            } else {
                String os = String.valueOf(occurance);
                char[] oArray = os.toCharArray();
                ans += 1 + oArray.length;
                for(int j = 0;j<oArray.length;j++){
                    prevStoredIdx = prevStoredIdx+1;
                    if(prevStoredIdx >=chars.length)continue;
                    chars[prevStoredIdx] = oArray[j];
                }
                prevStoredIdx++;
            }
            i += occurance;

        }
        return ans;
    }
    public static void main(String[] args){
        StringCompression443 solver = new StringCompression443();
        char [] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        //chars = new char[]{'a','a','a','b','b','a','a'};
        System.out.println(solver.compress(chars));
        System.out.println(chars);
    }
}
