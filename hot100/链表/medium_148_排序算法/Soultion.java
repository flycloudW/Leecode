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
 // 分治排序： 把链表从中间打断，直到最小，按递归的打断顺序把小段的链表重新按大小连接链表
class Solution {
    public ListNode sortList(ListNode head) {
        // 
        if(head == null || head.next == null) {
            return head;
        }
        // 找中间节点来断开链表
        ListNode head2 = middleNode(head);
        // 分治两头
        head = sortList(head);
        head2 = sortList(head2);
        // 按大小把两个子串连接
        return merge(head, head2);
    }

    // 找中间节点并且打断，奇数中间归右边
    private ListNode middleNode(ListNode head) {
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // ListNode pre = slow;//不能用这个是因为打断后这个中点是右边的头节点，打断应该是把前一次的slow和新的slow打断
        // 打断链表
        pre.next = null;
        return slow;
    }

    // 按大小合并两个子串
    private ListNode merge(ListNode list1, ListNode list2) {
        // 虚拟头节点
        ListNode xuni = new ListNode();
        ListNode cur = xuni;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return xuni.next;
    }
}
