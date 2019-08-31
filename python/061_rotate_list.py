# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head: return head
        leng = 0
        curr = head
        while curr:
            curr = curr.next
            leng += 1
        if leng == 1:
            return head

        k %= leng
        offset = leng - k

        curr = head
        prev = None
        while offset > 0:
            if offset == 1:
                prev = curr
            curr = curr.next
            if not curr:
                curr = head
            offset -= 1

        if curr != head:
            tail = curr
            while tail.next:
                tail = tail.next
            prev.next = None
            tail.next = head

        return curr


