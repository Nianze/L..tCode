// Created By Rym on 11/08/2016
public class LRUCache {
    class DLinkedNode {
        int value;
        int key;
        DLinkedNode pre;
        DLinkedNode next;
        DLinkedNode(int k, int v) {
            key = k;
            value = v;
            pre = next = null;
        }
    }
    // always add node right after head
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }
    
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private DLinkedNode head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode(-1, -1);
        tail = new DLinkedNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            if (cache.size() == capacity) {
                DLinkedNode old = tail.pre;
                removeNode(old);
                cache.remove(old.key);
            }
            cache.put(key, newNode);            
            addNode(newNode);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}
