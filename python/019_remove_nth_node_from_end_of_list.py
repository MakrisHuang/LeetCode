# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd_withCount(self, head: ListNode, n: int) -> ListNode:
        m = dict()
        curr = head
        index = total = 0
        while curr:
            m[index] = curr
            curr = curr.next
            index += 1

        total = index

        node_index = total - n
        if node_index == 0:
            return head.next

        prev = m[node_index - 1]
        if node_index + 1 == total:
            prev.next = None
            return head

        prev.next = m[node_index + 1]
        return head
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # add two pointers and separate those pointers by n nodes apart
        first = second = dummy = ListNode()
        dummy.next = head
        # advance first pointer by n + 1 steps
        for _ in range(n + 1):
            first = first.next
        # update second pointer with delay
        while first:
            first = first.next
            second = second.next
        second.next = second.next.next
        return dummy.next
