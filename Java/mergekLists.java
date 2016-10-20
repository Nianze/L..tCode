/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */

    // divide and conquer
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right)
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummy.next;
    }

    // heap
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists = null || lists.size() == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
                public int compare (ListNode left, ListNode right) {
                    return left.val - right.val;
                }                
            });
            
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummy.next;
    }

}
