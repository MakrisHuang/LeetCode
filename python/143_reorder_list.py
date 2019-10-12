# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return

        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # reverse second-half in place
        prev, node = None, slow
        while node:
            prev, node.next, node = node, prev, node.next

        first, second = head, prev
        # the last node of 'first' and 'second' are the same
        # so only need to check second.next
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next


