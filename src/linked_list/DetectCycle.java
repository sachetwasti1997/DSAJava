package linked_list;

public class DetectCycle {

    private static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fastHead = head;
        while(fastHead != null && fastHead.next != null){
            fastHead = fastHead.next.next;
            head = head.next;
            if(fastHead == head){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(0);
//        ListNode listNode3 = new ListNode(-4);
//
        head.next = listNode1;
        listNode1.next = head;
//        listNode2.next = listNode3;
//        listNode3.next = listNode1;

        System.out.println(hasCycle(head));
    }

}
