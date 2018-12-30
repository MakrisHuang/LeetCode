/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((node1, node2) -> {
            return node1.val - node2.val;
        });

        for (ListNode node: lists) {
            // append the first node
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (! queue.isEmpty()) {
            // get the node with smallest value
            // and link it
            curr.next = queue.poll();
            curr = curr.next;

            // push the remaining node at this linked list
            if (curr.next != null) {
                queue.offer(curr.next);
            }
        }
        return head.next;
    }
}
