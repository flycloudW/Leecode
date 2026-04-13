/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 // 维护一个优先队列，堆顶始终是最小的节点，只要堆本身没空，那就把最小节点原链表的下一个节点也加进来排序，直到全空了。
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head : lists) {
            if(head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
