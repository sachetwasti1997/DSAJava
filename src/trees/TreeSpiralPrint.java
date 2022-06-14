package trees;

import java.util.Stack;

public class TreeSpiralPrint {

    public static void printSpiral(TreeNode root){
        Stack<TreeNode> normalInsert = new Stack<>();
        Stack<TreeNode> reverseInsert = new Stack<>();
        normalInsert.add(root);
        while (!normalInsert.isEmpty() && !reverseInsert.isEmpty()){
            while (!normalInsert.isEmpty()){
                var t = normalInsert.pop();
                System.out.println(t.getData()+" ");
                reverseInsert.add(t.getLeft());
                reverseInsert.add(t.getRight());
            }
            while (!reverseInsert.isEmpty()){
                var t = reverseInsert.pop();
                System.out.println(t.getData()+" ");
                normalInsert.add(t.getRight());
                normalInsert.add(t.getLeft());
            }
        }
    }

    public static void main(String[] args) {

    }
}
