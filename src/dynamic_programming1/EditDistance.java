package dynamic_programming1;

public class EditDistance {

    static int editDistance(String m1, String n1, int m, int n){
        if (m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        if (m1.charAt(m-1) == n1.charAt(n-1)){
            return editDistance(m1, n1, m-1, n-1);
        }
        else {
            return 1 + Integer.min(editDistance(m1, n1, m, n-1), Integer.min(editDistance(m1, n1, m-1, n), editDistance(m1, n1, m-1, n-1)));
        }
    }

}
