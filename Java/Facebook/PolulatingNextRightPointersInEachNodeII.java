// Created by Rym on 11/10/2016
// three pointers: parent points to up layer, head points to low layer's first node, cur points to current nude
public class PolulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode par = root, head = null, cur = null;
        while (par != null) {
            while (par != null) {
                if (par.left != null) {
                    if (head == null) { head = par.left; }
                    else { cur.next = par.left; }
                    cur = par.left;
                }
                if (par.right != null) {
                    if (head == null) { head = par.right; }
                    else { cur.next = par.right; }
                    cur = par.right;
                }
                par = par.next;
            }
            par = head;
            head = cur = null;
        }
    }
}
