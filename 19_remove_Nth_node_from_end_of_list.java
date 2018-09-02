/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode curr = head;
        int idx = 0, total = 0;
        while (curr != null) {
            map.put(idx, curr);
            curr = curr.next;
            idx++;
        }
        total = idx;

        int nodeIdx = total - n;
        if (nodeIdx == 0) return head.next;

        ListNode prev = map.get(nodeIdx - 1);
        if (nodeIdx + 1 == total) { // handle the last one
            prev.next = null;
            return head;
        }

        ListNode next = map.get(nodeIdx + 1);
        prev.next = next;
        return head;
    }
}
