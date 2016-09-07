/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        int addon = 0;
        ListNode p1 = l1, p2 = l2, p3 = ans;
        while(p1 != null && p2 != null){
            int temp = p1.val + p2.val + addon;
            p3.next = new ListNode( temp  % 10 );
            addon = temp / 10;
            p1 = p1.next;
            p2 = p2.next;
            p3 = p3.next;
        }
        
        while(p1 != null) {
            int temp = p1.val + addon;
            p3.next = new ListNode(temp % 10);
            addon = temp / 10;
            p1 = p1.next;
            p3 = p3.next;
        }

        while(p2 != null) {
            int temp = p2.val + addon;
            p3.next = new ListNode(temp % 10);
            addon = temp / 10;
            p2 = p2.next;
            p3 = p3.next;
        }
        
        if (addon > 0) {
            p3.next = new ListNode(addon);
        }
        
        return ans.next;
    }

}

