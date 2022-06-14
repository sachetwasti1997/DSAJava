package trees;

import java.util.*;

public class KthSmallestBST {
    static class DataHolder{
        int data;
        int index;
    }

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

    public void kthElementHelper(List<Integer> resArray, TreeNode root, int k, DataHolder holder){
        if(root == null){
            return;
        }
        kthElementHelper(resArray, root.left, k, holder);
        holder.index++;
        if(holder.index == k){
            holder.data = root.val;
            return;
        }
        kthElementHelper(resArray, root.right, k, holder);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>(k);
        DataHolder holder = new DataHolder();
        kthElementHelper(list, root, k, holder);
        return holder.data;
    }
}
