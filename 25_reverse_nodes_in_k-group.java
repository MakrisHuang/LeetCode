/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        ListNode fast = pre;
        pre.next = head;
        while(true) {
            for(int i = 0; i < k; i++) {
                if(fast.next == null)
                    return res.next;
                fast = fast.next;
            }
            ListNode tmp = pre.next;
            reverse(pre, k);
            fast = tmp;
            pre = tmp;
        }
    }

    public void reverse(ListNode pre, int k) {
        ListNode head = pre.next;
        for(int i = 0; i < k - 1; i++) {
            ListNode tmp = pre.next;
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = tmp;
        }
    }
}
