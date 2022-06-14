package greedy;

public class ValidParenthesisString {
    class IndexStore{
        int index;
        int left;
        int right;
        IndexStore(int index, int left, int right){
            this.index = index;
            this.left = left;
            this.right = right;
        }
        public boolean equals(IndexStore obj){
            if(this == obj){
                return true;
            }
            if(obj.index == this.index && obj.left == this.left && obj.right == this.right){
                return true;
            }
            return false;
        }
        public int hashCode(){
            int result = (int) (index ^ (index >>> 32));
            result = 31 * result + (int) (left ^ (left >>> 32));
            result = 31 * result + (int) (right ^ (right >>> 32));
            return result;
        }
    }
    public boolean checkRecursive(int index, int left, int right, String s){
        if(index == s.length()){
            return true;
        }
        boolean b = true;
        while(index < s.length()){
            if(s.charAt(index) == '('){
                left++;
            }
            else if(s.charAt(index) == ')'){
                right++;
            }else{
                b = (checkRecursive(index+1, ++left, right, s)
                        || checkRecursive(index+1, left, ++right, s)
                        || checkRecursive(index+1, left, right, s));
            }
            index++;
        }
        return right == left && b;
    }
}
