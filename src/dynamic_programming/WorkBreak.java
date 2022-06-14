package dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WorkBreak {

    public boolean workBreak(String st, int i, int j, Set<String> stringSet, Boolean[][] t){
        if(i > j){
            return false;
        }
        System.out.println(st.substring(i, j+1));
        if (t[i][j] != null){
            return t[i][j];
        }
        if (stringSet.contains(st.substring(i, j+1)))return true;
        boolean b = false;
        for (int k=i; k<=j-1; k++){
            b = b || workBreak(st, i, k, stringSet, t) && workBreak(st, k+1, j, stringSet, t);
        }
        return t[i][j] = b;
    }

    public static void main(String[] args) {
        Set<String> wordList = new HashSet<>();
        wordList.add("cats");
        wordList.add("dog");
        wordList.add("sand");
        wordList.add("and");
        wordList.add("cat");
        String s = "catsandog";
        Boolean[][] tstore = new Boolean[s.length()+1][s.length()+1];
        Arrays.stream(tstore).forEach(t -> Arrays.fill(t, null));
        WorkBreak workBreak = new WorkBreak();
        System.out.println(workBreak.workBreak(s, 0, s.length()-1, wordList, tstore));
        Arrays.stream(tstore).forEach(t -> System.out.println(Arrays.toString(t)));
    }

}
