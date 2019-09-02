# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
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

        remaining = None
        if curr_l1 and not curr_l2:
            remaining = curr_l1
        elif not curr_l1 and curr_l2:
            remaining = curr_l2

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
