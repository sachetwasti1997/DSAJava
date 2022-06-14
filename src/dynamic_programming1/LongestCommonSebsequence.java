package dynamic_programming1;

public class LongestCommonSebsequence {

    static int findLCS(String a, String b, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }
        if(a.charAt(m-1) == b.charAt(n-1)){
            return 1 + findLCS(a, b, m-1, n-1);
        }
        return Integer.max(findLCS(a, b, m-1, n), findLCS(a, b, m, n-1));
    }

    public static void main(String[] args) {
        String a = "ABCDGH";
        String b = "AEDFHR";
        System.out.println(findLCS(a, b, a.length(), b.length()));
    }

}
