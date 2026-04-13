/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // 先复制所有节点在原节点后，再补充random，最后拆分两个链表
        for(Node cur = head; cur != null; cur = cur.next.next) {
            cur.next = new Node(cur.val, cur.next);
        }
        for(Node cur = head; cur !=null; cur = cur.next.next) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }

        Node n1 = new Node(0);
        Node n2 = n1;
        for(Node cur = head; cur != null; cur = cur.next, n2 = n2.next) {
            Node copy = cur.next;
            n2.next = copy;
            cur.next = copy.next;
        }
        return n1.next;
    }
}
