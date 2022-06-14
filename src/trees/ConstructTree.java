package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConstructTree {

    public TreeNode root(Integer[] arr){
        TreeNode root = new TreeNode(arr[0]);
        TreeNode temp = root;
        Map<Integer, TreeNode> hashMap = new HashMap<>();
        hashMap.put(0, root);
        for (int i=0; i< arr.length; i++){
            if (arr[i] != null && !hashMap.containsKey(i)){
                hashMap.put(i, new TreeNode(arr[i]));
            }
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            if (leftChild < arr.length && arr[leftChild] != null){
                if (!hashMap.containsKey(leftChild)){
                    hashMap.put(leftChild, new TreeNode(arr[leftChild]));
                }
                hashMap.get(i).setLeft(hashMap.get(leftChild));
            }
            if (rightChild < arr.length && arr[rightChild] != null){
                if (!hashMap.containsKey(rightChild)){
                    hashMap.put(rightChild, new TreeNode(arr[rightChild]));
                }
                hashMap.get(i).setRight(hashMap.get(rightChild));
            }
        }
        return root;
    }

    public void levelOrder(TreeNode root){
        Queue<TreeNode> levelOrder = new LinkedList<>();
        if (root != null)levelOrder.add(root);
        while (!levelOrder.isEmpty()){
            TreeNode temp = levelOrder.poll();

                System.out.print(temp.getData()+" ");
                if (temp.getLeft() != null){
                    levelOrder.add(temp.getLeft());
                }if (temp.getRight() != null){
                    levelOrder.add(temp.getRight());
                }
        }
    }

    public void preOrderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.getData()+" ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public void inOrderTraversal(TreeNode root){
        preOrderTraversal(root.getLeft());
        System.out.print(root.getData()+" ");
        preOrderTraversal(root.getRight());
    }

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,8,15,7, 5, 12};
        ConstructTree tree = new ConstructTree();
        var temp = tree.root(arr);
        tree.levelOrder(temp);
        System.out.println();
        tree.preOrderTraversal(temp);
        System.out.println();
        tree.inOrderTraversal(temp);
    }

}
