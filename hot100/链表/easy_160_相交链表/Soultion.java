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
 // x:链表A的不重复长度。y:链表B的不重复长度。z:重复的长度
 // (x + z) + y = (y + z) + x;只要每个链表走到尾再跳转回去，一定会走到两个Node都相同
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while(A != B) {
            A = A != null ? A.next : headA;
            B = B != null ? B.next : headB;
        }
        return A;
    }
}
