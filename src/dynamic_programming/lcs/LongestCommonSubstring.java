package dynamic_programming.lcs;

import java.util.Arrays;

public class LongestCommonSubstring {

    static class IndexStore{
        int i = 0, j = 0;
    }

//    public static void longestCommonSubstring(String a, String b, int m, int n, int[][] t, indexStore indexStore){
//        int max = 0;
//        for (int i=1; i<n+1; i++){
//            for(int j=m; j>=1; j++){
//                if(a.charAt(i-1) == b.charAt(j-1) && i-1 == n-j){
//                    t[i][j] = 1 + t[i-1][j-1];
//                    if(max < t[i][j]){
//                        max = t[i][j];
//                        indexStore.i = i;
//                        indexStore.j = j;
//                    }
//                }else{
//                    t[i][j] = 0;
//                }
//            }
//        }
//    }
//
//    public static String longestPalindrome(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        String sReversed = sb.reverse().toString();
//        sb.delete(0, s.length());
//        indexStore indexStore = new indexStore();
//        int[][] t = new int[s.length()+1][s.length()+1];
//        longestCommonSubstring(s, sReversed, s.length(), sReversed.length(), t, indexStore);
//        Arrays.stream(t).forEach(ar -> System.out.println(Arrays.toString(ar)));
//        int i = indexStore.i, j = indexStore.j;
//        while (true){
//            if(t[i][j] != 0){
//                sb.append(s.charAt(i-1));
//            }else{
//                break;
//            }
//            i--;
//            j--;
//        }
//        return sb.toString();
//    }

    public static String longestPalindrome(String s){
        int max = 0, iFinal = 0, jFinal = 0;
        for (int i=0; i<s.length(); i++){
            IndexStore indexStore = calculateIndicies(s, i, i);
            if(indexStore.j - indexStore.i + 1 > max){
                max = indexStore.j - indexStore.i;
                iFinal = indexStore.i;
                jFinal = indexStore.j;
            }
        }
        for (int i=0; i<s.length()-1; i++){
            IndexStore indexStore = calculateIndicies(s, i, i+1);
            if(indexStore.j - indexStore.i + 1 > max){
                max = indexStore.j - indexStore.i;
                iFinal = indexStore.i;
                jFinal = indexStore.j;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = iFinal; i <= jFinal; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    static IndexStore calculateIndicies(String s, int l, int r){
        int i = 0, j = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            i = l;
            j = r;
            l--;
            r++;
        }
        IndexStore indexStore = new IndexStore();
        indexStore.i = i;
        indexStore.j = j;
        return indexStore;
    }

    public static void main(String[]args){
        String s = "aacabdkacaa";
                  //aackdbaacaa
        System.out.println(longestPalindrome(s));
    }

}
