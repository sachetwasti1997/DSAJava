package trees;

import java.util.ArrayList;
import java.util.List;

public class FindPathToNode {

    static boolean findPathToNode(TreeNode root, List<TreeNode> path, int data){
        if (root == null){
            return false;
        }
        if (root.getData() == data){
            return true;
        }
        boolean left = findPathToNode(root.getLeft(), path, data);
        boolean right = findPathToNode(root.getRight(), path, data);
        if (left || right){
            path.add(root);
        }
        return left || right;
    }

    public static void main(String[] args) {
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
        List<TreeNode> pathList = new ArrayList<>();
        findPathToNode(t1, pathList, 30);
        System.out.println(pathList);
    }

}
