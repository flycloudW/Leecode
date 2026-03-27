class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        // 统计节点
        int n = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) n++;
        // 虚拟头节点
        ListNode f = new ListNode(0, head);
        // 每组的第一个节点
        ListNode f0 = f;
        //当前状态: f-1-2-3-4-5    null-1-2-3-4-5
    
        ListNode pre = null;
        ListNode cur = head;
        while(n >= k) {
            n -= k;
            // 反转逻辑
            for(int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // cur->4 pre->3
            // 当前状态 f-1-null    3-2-1-null    4-5   目标 f-3-2-1-4-5
            // 存下一组的虚拟头节点,1
            ListNode ne = f0.next;
            // 把当前组的尾连上下一组的头,1-4(cur)
            f0.next.next = cur;
            // 当前组的新头,f-3(pre)
            f0.next = pre;
            // 更新下一组的虚拟头节点
            f0 = ne;

        }
        return f.next;
    }
}
