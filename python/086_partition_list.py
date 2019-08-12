# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        curr_small = dummy_small = ListNode(0)
        curr_large = dummy_large = ListNode(0)

        while head:
            if head.val < x:
                curr_small.next = head
                curr_small = curr_small.next
            else:
                curr_large.next = head
                curr_large = curr_large.next
            head = head.next

        curr_large.next = None
        curr_small.next = dummy_large.next
        return dummy_small.next
