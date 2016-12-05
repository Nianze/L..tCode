// Created by Rym on 10/18/2016
public class ConvertBSTtoDoublyLinkedList {
    Node head;
    static Node prev = null;
    // this will create a doubly linked list, with static node to store prev    
    public Node bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        bt2DLL(root.left);
        if (prev == null) head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bt2DLL(root.right);
        return head;
    }
}
