package trees;

public class InvertBinaryTree {

      //Definition for a binary tree node.
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


    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        var temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void main(String[]args){}

}
