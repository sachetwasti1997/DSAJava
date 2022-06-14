package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BurnBinaryTree {

    public static void fillArr(Map<Integer, List<Integer>> list, TreeNode root){
        if (root == null){
            return;
        }
        if (!list.containsKey(root.getData())){
            list.put(root.getData(), new ArrayList<>());
        }else{
            list.get(root.getData()).add(root.getRight().getData());
            list.get(root.getData()).add(root.getLeft().getData());
        }
    }

}
