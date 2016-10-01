package oa2;

import java.util.HashMap;

public class CopyRandomList {
	// 	copy list with random pointer
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) { return null; }
		
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode pre = dummy, newNode;
		
		while (head != null) {  // special case !!
			if (map.containsKey(head)) {
				newNode = map.get(head);
			} else {
				newNode = new RandomListNode(head.label);
				map.put(head, newNode);
			}
			
			if (head.random != null) {
				if (map.containsKey(head.random)) {
					newNode.random = map.get(head.random);
				} else {
					newNode.random = new RandomListNode(head.random.label);
					map.put(head.random, newNode.random);
				}
			}
			pre.next = newNode;
			pre = pre.next;
			head = head.next;
		}
		return dummy.next;				
	}
}
