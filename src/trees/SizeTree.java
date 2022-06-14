package trees;

public class SizeTree {

    public int getSize(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + getSize(root.getLeft()) + getSize(root.getRight());
    }

    public static void main(String[] args) {
            Integer[] arr = {10, 20, 30, 40, 50, null, 70};
            ConstructTree tree = new ConstructTree();
            var temp = tree.root(arr);
            SizeTree sizeTree = new SizeTree();
        System.out.println(sizeTree.getSize(temp));
    }

}
