# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        def getSize(head) -> int:
            counter = 0
            while head:
                counter += 1
                head = head.next
            return counter

        def split(head, step) -> ListNode:
            # split list by steps
            i = 1
            while i < step and head:
                head = head.next
                i += 1
            if not head:
                return None
            second_half_head, head.next = head.next, None
            return second_half_head

        # merge left and right list by combining them
        # to head node
        # return last node of new linked list
        def merge(l, r, head) -> ListNode:
            curr = head
            while l and r:
                if l.val < r.val:
                    curr.next = l
                    l = l.next
                else:
                    curr.next = r
                    r = r.next
                curr = curr.next
            curr.next = l or r
            while curr.next:
                curr = curr.next

            return curr

        size = getSize(head)
        bs = 1
        dummy = ListNode(-1)
        dummy.next = head
        l, r, tail = None, None, None
        while bs < size:
            curr = dummy.next
            tail = dummy
            while curr:
                l = curr
                r = split(l, bs)
                curr = split(r, bs)
                tail = merge(l, r, tail)
            bs <<= 1
        return dummy.next





