# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        odd = odd_head = ListNode(0)
        even = even_head = ListNode(0)
        is_odd = True
        while head:
            if is_odd:
                odd.next = head
                odd = odd.next
            else:
                even.next = head
                even = even.next
            head = head.next
            is_odd = not is_odd
        even.next = None
        odd.next = even_head.next
        return odd_head.next
