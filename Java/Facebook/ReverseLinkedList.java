// Created by Rym on 10/20/2016
public class Solution {
    // Iterative 
    public ListNode reverseList(ListNode head) {
        ListNode cur = null, next;
        while (head != null) {
            next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }

    /* recursive solution */    
    public ListNode reverseList(ListNode head) {
        return reverseListInt(head, null);
    }
    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
