package trees;

public class ChildrenSumProperty {

    static int childrenSumProperty(TreeNode root){
        if (root == null){
            return -1;
        }
        var left = childrenSumProperty(root.getLeft());
        var right = childrenSumProperty(root.getRight());
        if (left == -1 && right == -1){
            return root.getData();
        }
        if (left == -1){
            return right == root.getData() ? root.getData() : Integer.MIN_VALUE;
        }
        else if (right == -1){
            return left == root.getData() ? root.getData() : Integer.MIN_VALUE;
        }
        return (left+right) == root.getData() ? root.getData() : Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Integer[] t = {3};
        ConstructTree tree = new ConstructTree();
        var root = tree.root(t);
        System.out.println(childrenSumProperty(root));
    }

}
