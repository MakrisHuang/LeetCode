/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> result = new Stack<>();

        ListNode curr = l1;
        while (curr != null) {
            st1.push(curr.val); curr = curr.next;
        }
        curr = l2;
        while (curr != null) {
            st2.push(curr.val); curr = curr.next;
        }

        int carry = 0;
        while (true) {
            int v1 = 0, v2 = 0;
            if (! st1.empty()) {
                v1 = st1.pop();
            } else { v1 = 0; }
            if (! st2.empty()) {
                v2 = st2.pop();
            } else { v2 = 0; }

            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum  = sum % 10;

            result.push(sum);

            if (st1.empty() && st2.empty()){
                if (carry != 0) result.push(carry);
                break;
            }
        }

        ListNode dummy = new ListNode(0);
        curr = dummy;
        while (!result.empty()) {
            ListNode node = new ListNode(result.pop());
            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }
}
