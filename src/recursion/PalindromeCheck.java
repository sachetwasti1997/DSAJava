package recursion;

public class PalindromeCheck {

    public static boolean checkPalindrome(String str, int i, int j){
        if(i > j){
            return true;
        }
        if(str.charAt(i) != str.charAt(j)){
            return false;
        }
        return checkPalindrome(str, i+1, j-1);
    }

    public static void main(String[] args){
        System.out.println(checkPalindrome("abb", 0, 2));
    }

}
