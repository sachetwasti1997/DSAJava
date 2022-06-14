package trees;

public class MaxInBinaryTree {

    int getMax(TreeNode root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        return Integer.max(root.getData(), Integer.max(getMax(root.getLeft()), getMax(root.getRight())));
    }

    public static void main(String[] args) {
        Integer[] arr = {20,80,30,null,null,40,50};
        ConstructTree tree =new ConstructTree();
        TreeNode root = tree.root(arr);
        MaxInBinaryTree maxInBinaryTree = new MaxInBinaryTree();
        System.out.println(maxInBinaryTree.getMax(root));
    }

}
