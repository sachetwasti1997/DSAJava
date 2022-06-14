package arrays;

import java.util.*;

public class MinWindow {
    public String minWindow(String s, String s2) {
        int i=0, j=0;
        String str = "", resStr = "";
        var charMap = new HashMap<Character, Integer>(26);
        for(i=0; i<s2.length(); i++){
            if(!charMap.containsKey(s2.charAt(i)))charMap.put(s2.charAt(i), 1);
            else charMap.put(s2.charAt(i), charMap.get(s2.charAt(i))+1);
        }
        int maxLength = Integer.MAX_VALUE;
        i=0; j = 0;
        int flag = 0, maxI = 0, maxJ = 0;
        var temp = new HashMap<Character, Integer>();
        temp.putAll(charMap);
        var window = new HashMap<Character, Integer>();
        int requiredLength = 0;
        while(i < s.length() && j < s.length() && i < j){
            if(temp.containsKey(s.charAt(j))){
                if(!window.containsKey(s.charAt(j)))window.put(s.charAt(j), 1);
                else window.put(s.charAt(j), window.get(s.charAt(j))+1);
                if(window.get(s.charAt(j)) == temp.get(s.charAt(j))){
                    requiredLength ++;
                }
            }
            if(requiredLength == s2.length()){
                if(maxLength > (j-i+1)){
                    maxLength = j-i+1;
                    maxI = i;
                    maxJ = j;
                    if(window.containsKey(s.charAt(i))){
                        window.put(s.charAt(i), window.get(s.charAt(i)) - 1);
                        if(window.get(s.charAt(i)) < temp.get(s.charAt(i))){
                            requiredLength--;
                        }
                    }
                    i++;
                }
            }
            if(requiredLength < s2.length())j++;
        }
        return s.substring(maxI, maxJ+1);
    }

    public static void main(String[] args){
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        MinWindow w = new MinWindow();
        System.out.println(w.minWindow(s1, s2));
    }
}
