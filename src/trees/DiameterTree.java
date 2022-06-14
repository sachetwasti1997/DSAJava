package trees;

public class DiameterTree {

    static class HoldDiameter{
        int diameter;
    }

    static int diameter(TreeNode root, HoldDiameter i1){
        if (root == null){
            return 0;
        }
        int left = diameter(root.getLeft(), i1);
        int right = diameter(root.getRight(), i1);
        int temp = Integer.max(1+left+right, 1 + Integer.max(left, right));
        i1.diameter = Integer.max(temp, i1.diameter);
        return 1 + Integer.max(left, right);
    }

    public static void main(String[] args) {
        HoldDiameter i1 = new HoldDiameter();
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(50);
        TreeNode t3 = new TreeNode(60);
        TreeNode t4 = new TreeNode(70);
        TreeNode t5 = new TreeNode(20);
        TreeNode t6 = new TreeNode(40);
        TreeNode t7 = new TreeNode(90);
        TreeNode t9 = new TreeNode(80);
        TreeNode t10 = new TreeNode(30);
        t1.setLeft(t2);
        t1.setRight(t3);
        t2.setLeft(t4);
        t2.setLeft(t5);
        t4.setLeft(t6);
        t5.setLeft(t7);
        t5.setRight(t9);
        t7.setLeft(t10);
        diameter(t1, i1);
        System.out.println(i1.diameter);
    }

}
