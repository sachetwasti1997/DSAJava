package trees;

import java.util.ArrayList;
import java.util.HashMap;

public class MaximumDepth {

    public int maxDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
            int leftHeight = maxDepth(root.getLeft());
            int rightHeight = maxDepth(root.getRight());
            return Integer.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        ConstructTree tree = new ConstructTree();
        var temp = tree.root(arr);
        MaximumDepth depth = new MaximumDepth();
        System.out.println(depth.maxDepth(temp));
        var map = new HashMap<String, String>();
//        map.remove();
        ArrayList ar = new ArrayList<>();
//        ar.re
    }

}
