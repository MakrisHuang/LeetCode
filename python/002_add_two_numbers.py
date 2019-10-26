# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers_recursive(self, l1: ListNode, l2: ListNode, carry = 0) -> ListNode:
        val = l1.val + l2.val + carry
        carry = val // 10
        ret = ListNode(val % 10)

        if l1.next or l2.next or carry != 0:
            if l1.next is None:
                l1.next = ListNode(0)
            if l2.next is None:
                l2.next = ListNode(0)
            ret.next = self.addTwoNumbers(l1.next, l2.next, carry)
        return ret

    def addTwoNumbers_iterative(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 or not l2:
            return l1 or l2

        carry = 0
        curr = dummy = ListNode(0)

        curr_l1, curr_l2 = l1, l2
        while curr_l1 and curr_l2:
            sum = curr_l1.val + curr_l2.val + carry
            carry = sum // 10
            sum %= 10
            curr.next = ListNode(sum)
            curr = curr.next
            curr_l1 = curr_l1.next
            curr_l2 = curr_l2.next

        remaining = curr_l1 or curr_l2

        while remaining:
            sum = remaining.val + carry
            carry = sum // 10
            sum %= 10
            curr.next = ListNode(sum)
            curr = curr.next
            remaining = remaining.next

        if carry > 0:
            curr.next = ListNode(carry)

        return dummy.next
