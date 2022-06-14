package trees;

public class MaxPathSum {

    static class SumHolder{
        int sum;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int maxSumHelper(TreeNode root, SumHolder sum){
        if(root == null){
            return 0;
        }
        int leftSum = maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);
        int temp = Integer.max(root.val, root.val + Integer.max(leftSum, rightSum));
        int ans = Integer.max(root.val+leftSum+rightSum, temp);
        sum.sum = Integer.max(ans, sum.sum);
        return temp;
    }
    public int maxPathSum(TreeNode root) {
        SumHolder sum = new SumHolder();
        maxSumHelper(root, sum);
        return sum.sum;
    }

    public static void main(String[] args){
        MaxPathSum sum = new MaxPathSum();

    }

}
