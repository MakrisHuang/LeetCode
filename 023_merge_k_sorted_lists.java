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
            if (node != null) {
                queue.offer(node);    
            }
        }
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (! queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) {
                queue.offer(curr.next);
            }
        }
        return head.next;
    }
}