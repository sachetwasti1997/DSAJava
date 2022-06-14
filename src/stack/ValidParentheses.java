package stack;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() == 0 || s.length() == 1)return false;
        var stk = new Stack<Character>();
        var bracketMap = new HashMap<Character, Character>();
        bracketMap.put(')','(');
        bracketMap.put('}','{');
        bracketMap.put(']','[');
        for(int i=0; i<s.length(); i++){
            if(!bracketMap.containsKey(s.charAt(i))){
                stk.add(s.charAt(i));
            }else{
                if(!stk.isEmpty()){
                    char c = stk.pop();
                    if(c != bracketMap.get(s.charAt(i))){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(!stk.isEmpty()){
            return false;
        }
        return true;
    }
}
