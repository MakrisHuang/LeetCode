# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        res = head
        while head:
            next = head.next
            while next and next.val == head.val:
                next = next.next
            head.next = next
            head = next
        return res
