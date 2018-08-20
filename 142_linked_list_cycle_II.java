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
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    // public ListNode detectCycle(ListNode head) {
    //     Map<ListNode, Boolean> map = new HashMap<>();
    //     ListNode dummy = new ListNode(0);
    //     dummy.next = head;
    //     ListNode curr = dummy;
    //     while (curr.next != null) {
    //         if (! map.containsKey(curr.next)) {
    //             map.put(curr.next, true);
    //             curr = curr.next;
    //         } else {
    //             return curr.next;
    //         }
    //     }
    //     return null;
    // }
}
