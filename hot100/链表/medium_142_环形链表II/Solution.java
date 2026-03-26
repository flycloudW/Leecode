/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 相遇
            if(fast == slow) {
                ListNode curf = head;
                ListNode curs = fast;
                // 相遇后，从当前节点和头同时走到相遇就是入口
                while(curf != curs) {
                    curf = curf.next;
                    curs = curs.next;
                }
                return curf;
            }
        }
        return null;
    }
}
