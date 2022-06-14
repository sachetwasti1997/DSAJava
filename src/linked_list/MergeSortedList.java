package linked_list;

public class MergeSortedList {

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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = null, temp = null;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                if (listNode == null){
                    listNode = new ListNode(list1.val);
                    temp = listNode;
                }else {
                    temp.next = new ListNode(list1.val);
                }
                list1 = list1.next;
                temp = temp.next;
            }else if (list1.val == list2.val){
                if (listNode == null){
                    listNode = new ListNode(list1.val);
                    listNode.next = new ListNode(list2.val);
                    temp = listNode;
                }else {
                    temp.next = new ListNode(list1.val);
                    temp = temp.next;
                    temp.next = new ListNode(list2.val);
                }
                list1 = list1.next;
                list2 = list2.next;
                temp = temp.next;
            }else{
                if (listNode == null){
                    listNode = new ListNode(list2.val);
                    temp = listNode;
                }else {
                    temp.next = new ListNode(list2.val);
                }
                list2 = list2.next;
                temp = temp.next;
            }
        }
        while (list1 != null){
            if (listNode == null){
                listNode = list1;
                temp = listNode;
            }else {
                temp.next = list1;
            }
            list1 = list1.next;
        }
        while (list2 != null){
            if (listNode == null){
                listNode = list2;
                temp = listNode;
            }else {
                temp.next = list2;
            }
            list2 = list2.next;
        }
        return listNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode head2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = listNode1;
        listNode1.next = listNode2;
        head2.next = listNode3;
        listNode3.next = node4;
        System.out.println(head+" "+head2);

        var mergedList = mergeTwoLists(head, head2);
        System.out.println(mergedList);
    }

}
