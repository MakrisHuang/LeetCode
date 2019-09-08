"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""
class Solution:
    def flatten(self, head: 'Node') -> 'Node':
        curr = head
        while curr:
            if curr.child:
                next = curr.next
                new_head = self.flatten(curr.child)
                curr.next = new_head
                new_head.prev = curr

                # get tail
                new_tail = new_head
                while new_tail.next:
                    new_tail = new_tail.next
                if next:
                    new_tail.next = next
                    next.prev = new_tail
                curr.child = None
            curr = curr.next
        return head

