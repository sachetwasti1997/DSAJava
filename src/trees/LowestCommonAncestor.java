package trees;

import java.util.*;

public class LowestCommonAncestor {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}

        @Override
        public String toString() {
            Integer left = null, right = null;
            if(left != null){
                left = this.left.val;
            }
            if(right != null){
                right = this.right.val;
            }
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static boolean findNode(TreeNode root, int searchedNode, List<TreeNode> nodeList){
        if(root == null){
            return false;
        }
        if(root.val == searchedNode){
            nodeList.add(root);
            return true;
        }
        boolean searchResultL = findNode(root.left, searchedNode, nodeList);
        boolean searchResultR = findNode(root.right, searchedNode, nodeList);
        if(searchResultL || searchResultR){
            nodeList.add(root);
            return true;
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = new ArrayList<>();
        findNode(root, p.val, list);
        List<TreeNode> list1 = new ArrayList<>();
        findNode(root, q.val, list1);
        System.out.println(list+" "+list1);
        TreeNode res = null;
        int listPointer = list.size() - 1, list1Pointer = list1.size() - 1;
        while(list1Pointer >= 0 && listPointer >= 0){
            if(list.get(listPointer) != list1.get(list1Pointer)){
                return res;
            }else{
                res = list.get(listPointer);
            }
            listPointer--;
            list1Pointer--;
        }
        return res;
    }
    
    public static void main(String[]args){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(50);
        TreeNode t3 = new TreeNode(60);
        TreeNode t4 = new TreeNode(70);
        TreeNode t5 = new TreeNode(20);
        TreeNode t6 = new TreeNode(40);
        TreeNode t7 = new TreeNode(90);
        TreeNode t9 = new TreeNode(80);
        TreeNode t10 = new TreeNode(30);
        TreeNode t11 = new TreeNode(36);
        t1.left = t2;
        t1.right = (t3);
        t2.left = (t4);
        t2.right = (t5);
        t4.left = (t6);
        t5.left = (t7);
        t5.right = (t9);
        t7.left = (t10);
        t7.right = t11;
        LowestCommonAncestor l = new LowestCommonAncestor();
        System.out.println(l.lowestCommonAncestor(t1, t10, t11));
    }

}
