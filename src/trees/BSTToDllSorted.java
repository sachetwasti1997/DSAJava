package trees;

public class BSTToDllSorted {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    Node head = null, temphead = null;
    public void helper(Node root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(head == null){
            head = new Node(root.val);
            temphead = head;
        }else{
            var newNode = new Node(root.val);
            temphead.right = newNode;
            newNode.left = temphead;
            temphead = temphead.right;
        }
        helper(root.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null)return null;
        helper(root);
        head.left = temphead;
        temphead.right = head;
        return head;
    }
}
