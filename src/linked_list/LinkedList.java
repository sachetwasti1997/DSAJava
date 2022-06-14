package linked_list;

public class LinkedList {

    private static class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode reverseLinkedList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode prevHead = null;
        ListNode nextHead = head.next;
        while (nextHead != null){
            head.next = prevHead;
            prevHead = head;
            head = nextHead;
            nextHead = nextHead.next;
        }
        head.next = prevHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = node4;

        head = reverseLinkedList(head);
        System.out.println(head);
    }

}
