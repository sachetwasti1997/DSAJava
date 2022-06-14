package linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

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

    static class HeapInsert{
        ListNode listNode;
        int positionInList;

        public HeapInsert(ListNode data, int positionInList) {
            this.listNode = data;
            this.positionInList = positionInList;
        }
    }

    public static PriorityQueue<HeapInsert> fillPriorityQueue(ListNode[] list, PriorityQueue<HeapInsert> priorityQueue){
        for (int i=0; i< list.length; i++){
            priorityQueue.add(new HeapInsert(new ListNode(list[i].data), i));
        }
        return priorityQueue;
    }

    public static ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<HeapInsert> pq = new PriorityQueue<>(new Comparator<HeapInsert>() {
            @Override
            public int compare(HeapInsert o1, HeapInsert o2) {
                return o1.listNode.data - o2.listNode.data;
            }
        });
        fillPriorityQueue(lists, pq);
        ListNode newHead = null, temporaryHead = null;
        while (!pq.isEmpty()){
            HeapInsert h = pq.remove();
            int position = h.positionInList;
            var temp = lists[position];
            while (temp.data != h.listNode.data){
                temp = temp.next;
            }
            if (temp.next != null){
                pq.add(new HeapInsert(new ListNode(temp.next.data), position));
            }
            if (newHead != null){
                temporaryHead.next = h.listNode;
                temporaryHead = temporaryHead.next;
            }else {
                newHead = h.listNode;
                temporaryHead = newHead;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode node4 = new ListNode(2);

        head.next = listNode1;
        listNode1.next = listNode2;
        head2.next = listNode3;
        listNode3.next = node4;

        ListNode[] lists = new ListNode[]{head, head2};
        mergeKLists1(lists);
    }

}












