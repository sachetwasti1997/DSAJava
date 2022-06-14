package dynamic_programming;

public class LongestPalindromicSubstring {

    static class LengthHolder{
        int maxLength = 0;
    }
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        String res = "";
        LengthHolder l = new LengthHolder();
        for(int i=0; i<s.length()-1; i++){
            var oddLengthStr = getLongestPalindrome(s, i, i, l);
            var evenLengthStr = getLongestPalindrome(s, i, i+1, l);
            if(oddLengthStr != ""){
                res = oddLengthStr;
            }
            if(evenLengthStr != ""){
                res = evenLengthStr;
            }
        }
        return res;
    }
    public String getLongestPalindrome(String s, int L, int R, LengthHolder l){
        String res = "";
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            if(R-L+1 > l.maxLength){
                l.maxLength = R-L+1;
                res = s.substring(L, R+1);
            }
            L--;
            R++;
        }
        return res;
    }

    public static void main(String[] args){
        LongestPalindromicSubstring pal = new LongestPalindromicSubstring();
        pal.longestPalindrome("ac");
    }

}
