package trees;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null){
            return p == q;
        }
        boolean t = p.getData() == q.getData();
        return t && isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
    }

    public static void main(String[] args) {
        Integer[] p = {1,2,3};
        Integer[] q = {1,2,3};
        SameTree sameTree = new SameTree();
        ConstructTree tree = new ConstructTree();
        var tempP = tree.root(p);
        var tempQ = tree.root(q);
        System.out.println(sameTree.isSameTree(tempP, tempQ));
    }

}
