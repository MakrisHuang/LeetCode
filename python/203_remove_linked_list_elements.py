# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        curr = dummy
        while curr:
            while curr.next and curr.next.val == val:
                curr.next = curr.next.next
            curr = curr.next
        return dummy.next
