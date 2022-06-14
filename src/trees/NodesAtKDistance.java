package trees;

public class NodesAtKDistance {

    void nodesAtKDis(TreeNode root, int count, int k){
        if (root == null){
            return;
        }
        if (count == k){
            System.out.print(root.getData()+" ");
        }
        nodesAtKDis(root.getLeft(), count+1, k);
        nodesAtKDis(root.getRight(), count+1, k);
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 20, 30, 40, 50, null, 70};
        ConstructTree tree = new ConstructTree();
        var temp = tree.root(arr);
        NodesAtKDistance nodesAtKDistance = new NodesAtKDistance();
        nodesAtKDistance.nodesAtKDis(temp, 0, 2);
    }

}
