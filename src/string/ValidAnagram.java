package string;

import java.util.*;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        var freqMap = new HashMap<Character, Integer>(s.length());
        for(int i = 0; i < s.length(); i++){
            if(!freqMap.containsKey(s.charAt(i))){
                freqMap.put(s.charAt(i), 1);
            }else{
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(!freqMap.containsKey(t.charAt(i))){
                return false;
            }else{
                freqMap.put(t.charAt(i), freqMap.get(t.charAt(i)) - 1);
            }
        }
        for(Map.Entry<Character, Integer>charMap: freqMap.entrySet()){
            if(charMap.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
