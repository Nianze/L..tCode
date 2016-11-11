// Created by Rym on 11/10/2016
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, start, cur;
        for (int i = 0; i < m-1; i++) { pre = pre.next; }
        start = pre.next;
        cur = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = start.next;
        }
        return dummy.next;        
    }
}
