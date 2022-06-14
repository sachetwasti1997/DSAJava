package trees;

public class TreeNode {
    private TreeNode right;
    private TreeNode left;
    private int data;
    public TreeNode(int data){
        this.data = data;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                ", data=" + data +
                '}';
    }
}
