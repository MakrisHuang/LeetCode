/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode q = dummy;
        dummy.next = head;
        RandomListNode curr = head;
        while (curr != null){
            q.next = new RandomListNode(curr.label);
            map.put(curr, q.next);
            q = q.next;
            curr = curr.next;
        }
        // move to head
        curr = head;
        q = dummy;
        while (curr != null){
            q.next.random = map.get(curr.random);
            q = q.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
