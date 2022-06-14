package linked_list;

public class ReorderList {

    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode newHead = node;
        ListNode currentHead = node;
        while(newHead != null){
            newHead = newHead.next;
            currentHead.next = prev;
            prev = currentHead;
            currentHead = newHead;
        }
        return prev;
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        slow = reverseList(slow);
        ListNode tail = head;
        ListNode l1 = head;
        boolean headTrueSlowFalse = true;
        while(l1 != null && slow != null){
            if(headTrueSlowFalse){
                l1 = l1.next;
                tail.next = slow;
                headTrueSlowFalse = false;
                tail = tail.next;
            }else{
                slow = slow.next;
                tail.next = l1;
                headTrueSlowFalse = true;
                tail = tail.next;
            }
        }
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
        reorderList(head);
        System.out.println(head);
    }

}
