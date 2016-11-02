// Created by Rym on 11/1/2016

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
    // two pointer
    // slow stop at the middle
    // reverse the first half at the same time
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        ListNode pre, forward = slow.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = forward;
            forward = forward.next;
            slow.next = pre;
        }
        if (fast.next == null)  slow = slow.next; // odd number
        while (forward != null) {
            if (forward.val != slow.val) return false;
            forward = forward.next;
            slow = slow.next;
        }
        return true;
    }

    // recover the list to orignal
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        ListNode pre, forward = slow.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = forward;
            forward = forward.next;
            slow.next = pre;
        }
        ListNode recover = slow, pre = forward;
        if (fast.next == null) { // odd number
            slow = slow.next;
            recover.next = pre;
            pre = recover;
            recover = slow;
        }
        boolean ans = true;
        while (forward != null) {
            if (forward.val != slow.val) { ans = false; }
            forward = forward.next;
            slow = slow.next;
            recover.next = pre;
            pre = recover;
            recover = slow;
        }
        return ans;
    }
}
