package trees;

public class BalancedBinaryTree {

    static int balancedBinaryTree(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = balancedBinaryTree(root.getLeft());
        int right = balancedBinaryTree(root.getRight());
        if (left == -1 || right == -1){
            return -1;
        }
        System.out.println(root.getData()+" "+(left)+" "+right);
        if (Math.abs(left - right) > 1){
            System.out.println(root.getData()+" "+(left)+" "+right+" Inside");
            return -1;
        }
        else return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Integer[] t = {3, 4, null, 5};
        ConstructTree tree = new ConstructTree();
        var root = tree.root(t);
        System.out.println(balancedBinaryTree(root));
    }

}
