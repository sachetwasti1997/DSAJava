package linked_list;

import java.util.*;

public class AddTwoNumbers {

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return null;
        }
        int carry = 0;
        ListNode head = null, temp = null;
        while(l1 != null && l2 != null){
            int l1Val = l1.val;
            int l2Val = l2.val;
            int total = carry + l1Val + l2Val;
            carry = total / 10;
            int nodeVal = total % 10;
            if(head == null){
                head = new ListNode(nodeVal);
                temp = head;
            }else{
                temp.next = new ListNode(nodeVal);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int l1Val = l1.val;
            int total = carry + l1Val;
            carry = total / 10;
            int nodeVal = total % 10;
            temp.next = new ListNode(nodeVal);
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int l1Val = l2.val;
            int total = carry + l1Val;
            carry = total / 10;
            int nodeVal = total % 10;
            temp.next = new ListNode(nodeVal);
            temp = temp.next;
            l2 = l2.next;
        }

        if(carry > 0){
            temp.next = new ListNode(carry);
        }

        return head;
    }

}
