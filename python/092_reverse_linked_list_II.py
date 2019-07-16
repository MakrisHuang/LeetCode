# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        prev = None
        curr = head

        while m > 1:
            prev = curr
            curr = curr.next
            m -= 1
            n -= 1

        con, tail = prev, curr
        while n > 0:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
            n -= 1

        if con:
            # 1 (con) -> prev (4)
            con.next = prev
        else:
            # in:  1, 2, 3, 4, 5, m = 1, n = 4
            # out: 4, 3, 2, 1, 5
            # head originally points to 1 (from n while loop)
            # now points to 4
            head = prev

        # connect tail
        # 2 (tail) -> 5 (new curr)
        tail.next = curr
        return head
