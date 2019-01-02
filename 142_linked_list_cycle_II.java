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

            /*
            From our calculation slow pointer traveled exactly full cycle when it meets fast pointer, and since originally it travled A before starting on a cycle, it must travel A to reach the point where cycle begins! We can start another slow pointer at head node, and move both pointers until they meet at the beginning of a cycle.
            */
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
