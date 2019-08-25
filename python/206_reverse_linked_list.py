# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList_iterative(self, head: ListNode) -> ListNode:
        # method 1. iterative
        last = None
        while head:
            temp = head.next
            head.next = last
            last = head
            head = temp
        return last

    def reverseList(self, head: ListNode) -> ListNode:
        return self.recursive(head, None)

    def recursive(self, head: ListNode, new_head: ListNode) -> ListNode:
        # method 2. recursive
        if not head: return new_head
        next = head.next
        head.next = new_head
        return self.recursive(next, head)


