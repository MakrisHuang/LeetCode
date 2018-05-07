/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        while (k > 0){
            if (curr.next != null){
                curr = curr.next;
            }else{ // in the trail one, go to the original head
                curr = head;
            }
            k--;
        }
        ListNode finalHead = curr;
        if (curr.next == null){ // the tail node
            ListNode secondNode = head.next;
            while (secondNode.next != null) secondNode = secondNode.next;

            // append the first one node to the last
            ListNode firstOne = new ListNode(head.val);
            firstOne.next = head.next;
            finalHead = firstOne;
        }
        if (curr != head){ // append remaining from curr.next to the end
            ListNode secondNode = curr.next;
            finalHead = secondNode;
            while (secondNode.next != null){
                secondNode = secondNode.next;
            }
            curr.next = null;
            secondNode.next = head;
        }

        return finalHead;
    }
}
