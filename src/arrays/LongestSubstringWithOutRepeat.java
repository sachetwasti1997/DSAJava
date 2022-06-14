package arrays;

import java.util.*;

public class LongestSubstringWithOutRepeat {
        public int lengthOfLongestSubstring(String s) {
            if(s.length() == 0 || s.length() == 1)return s.length();
            int res= 0, startWord = 1, endWord = 1;
            Set<Character> set = new HashSet<>();
            while(startWord <= s.length()&&endWord <= s.length()){
                if(!set.contains(s.charAt(endWord-1))){
                    set.add(s.charAt(endWord-1));
                }else{
                    res = Integer.max(res, endWord-startWord);
                    startWord++;
                    endWord = startWord;
                    set.clear();
                    set.add(s.charAt(endWord-1));
                }
                endWord++;
            }
            res = Integer.max(res, set.size());
            return res;
        }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length() == 0 || s.length() == 1)return s.length();
        int res= 0, startWord = 0, endWord = 0;
        Map<Character, Integer> set = new HashMap<>();
        while(startWord < s.length()&&endWord < s.length()){
            if(!set.containsKey(s.charAt(endWord))){
                set.put(s.charAt(endWord), endWord);
                res = Integer.max(res, endWord-startWord+1);
            }else{
                if(startWord < set.get(s.charAt(endWord))+1)startWord = set.get(s.charAt(endWord)) + 1;
                set.put(s.charAt(endWord), endWord);
                res = Integer.max(res, endWord-startWord+1);
            }
            endWord++;
        }
        // res = Integer.max(res, set.size());
        return res;
    }

    public int lengthOfLongestSubstring3(String s){
        int  l = 0;
        var set = new HashSet<Character>();
        int res = 0;
        for(int i=0; i<s.length(); i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l = l+1;
            }
            set.add(s.charAt(i));
            res = Integer.max(res, i-l+1);
        }
        return res;
    }
}
