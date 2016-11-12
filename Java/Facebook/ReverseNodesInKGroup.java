// Created by Rym on 11/11/2016

public class ReverseNodesInKGroup {
    /**
     * Reverse a link list between pre and next exclusively
     * e.g.: 
     * 0->1->2->3->4->5->6
     * |           |   
     * pre        next
     *
     * after call pre = reverse(pre, next):
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     * @param pre 
     * @param next
     * @return the precedence of parameter next
     */
    private static ListNode reverse(ListNode pre, ListNode next) {
        ListNode end = pre.next, cur = end.next;
        while (cur != next) {
            end.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = end.next;
        }
        return end;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while (head != null) {
            head = head.next;            
            if (++i % k == 0) pre = reverse(pre, head);
        }
        return dummy.next;
    }
}
/**
 * the while loop is the same as following process, which is easier to understand:
 * while(head != null){
 *    i++;
 *    if(i % k ==0){
 *        pre = reverse(pre, head.next);
 *        head = pre.next;
 *    }else {
 *        head = head.next;
 *    }
 * }
 */
