package arrays;

import java.util.*;

public class CheckUniqueSet {
    public static boolean hasAllCodes(String s, int k) {
        var stringSet = new HashSet<String>();
        for(int i = 0; i < s.length() - k + 1; i++){
            stringSet.add(s.substring(i, i+k));
        }
        return stringSet.size() == Math.pow(2, k);
    }

    public static void main(String[] args) {
        String s = "00110110";
        System.out.println(hasAllCodes(s, 2));
    }
}
