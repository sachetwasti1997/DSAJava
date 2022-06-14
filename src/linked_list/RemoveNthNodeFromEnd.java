package linked_list;

public class RemoveNthNodeFromEnd {

    private static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode forwardNode = head;
        ListNode behindNode = head;
        for (int i=0; i<n; i++){
            if (forwardNode.next == null){
                if (i == n - 1) head = head.next;
                return head;
            }
            forwardNode = forwardNode.next;
        }
        while (forwardNode.next != null){
            behindNode = behindNode.next;
            forwardNode = forwardNode.next;
        }
        behindNode.next = behindNode.next.next;
        return head;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);

//        head.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = node4;
//        head = removeNthFromEnd(head, 2);
//        System.out.println(head);
    }

}
