# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        p = head
        prev = dummy
        while p and p.next:
            q = p.next
            r = q.next
            prev.next = q

            q.next = p
            p.next = r

            prev = p
            p = r

        return dummy.next
