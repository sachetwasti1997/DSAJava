package trees;

import java.util.*;

public class ZigZagTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        var stk1 = new Stack<TreeNode>();
        var stk2 = new Stack<TreeNode>();
        stk1.add(root);
        int stk1Size = 1, stk2Size = 0;
        List<List<Integer>> res = new ArrayList<>();
        int resIndex = 0;
        res.add(resIndex, new ArrayList<>());
        while(!stk1.isEmpty() || !stk2.isEmpty()){
            if(!stk1.isEmpty()){
                for(int i=0; i<stk1Size; i++){
                    var temp = stk1.pop();
                    res.get(resIndex).add(temp.val);
                    if(temp.left != null)stk2.add(temp.left);
                    if(temp.right != null)stk2.add(temp.right);
                }
                if(!stk2.isEmpty()){
                    resIndex++;
                    res.add(resIndex, new ArrayList<>());
                }
                stk2Size = stk2.size();
            }
            if(!stk2.isEmpty()){
                for(int i=0; i<stk2Size; i++){
                    var temp = stk2.pop();
                    res.get(resIndex).add(temp.val);
                    if(temp.right != null)stk1.add(temp.right);
                    if(temp.left != null)stk1.add(temp.left);
                }
                if(!stk1.isEmpty()){
                    resIndex++;
                    res.add(resIndex, new ArrayList<>());
                }
                stk1Size = stk1.size();
            }
        }
        while(!stk1.isEmpty()){
            res.get(resIndex).add(stk1.pop().val);
        }
        while(!stk2.isEmpty()){
            res.get(resIndex).add(stk2.pop().val);
        }
        return res;
    }

}
