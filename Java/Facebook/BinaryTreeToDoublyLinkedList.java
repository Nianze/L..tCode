// Created by Rym on 11/13/2016
class Node {
    int val;
    Node left, right;
    public Node(int v) {
        this.val = v;
        left = right = null;
    }
}


public class BinaryTreeToDoublyLinkedList {
    Node head;
    static Node prev = null;
    // this will create a doubly linked list, with static node to store prev
    void bt2DLL(Node root) {
        if (root == null) return;
        bt2DLL(root.left);
        if (prev == null) head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bt2DLL(root.right);
    }
    // this will create a circular doubly linked list without static prev node
    void bt2CircularDLL(Node root, Node prev, Node head) {
        if (root == null) return;
        bt2CircularDLL(root.left, prev, head);
        if (prev == null) head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        Node right = root.right;
        root.right = head;
        head.left = root;
        prev = root;
        bt2CircularDLL(right, prev, head);
    }
    
}
