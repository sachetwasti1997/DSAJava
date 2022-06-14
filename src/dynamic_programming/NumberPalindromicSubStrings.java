package dynamic_programming;

public class NumberPalindromicSubStrings {
    public int countSubstrings(String s) {
        if(s.length() == 1){
            return 1;
        }
        int res = 0;
        for(int i=0; i<s.length(); i++){
            int oddLengthMax = lengthSubStr(s, i, i);
            int evenLengthMax = lengthSubStr(s, i, i+1);
            res += evenLengthMax+oddLengthMax;
        }
        return res;
    }
    public int lengthSubStr(String s, int L, int R){
        int res = 0;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            res ++;
            L--;
            R++;
        }
        return res;
    }
    public static void main(String[] args){
        NumberPalindromicSubStrings pal = new NumberPalindromicSubStrings();
        pal.countSubstrings("abc");
    }
}
