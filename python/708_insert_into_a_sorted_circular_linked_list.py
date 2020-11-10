"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    def insert(self, head: 'Node', insertVal: int) -> 'Node':
        if not head:
            new_node = Node(insertVal, head)
            new_node.next = new_node
            return new_node

        prev = head
        cur = head.next
        while True:
            # Found a spot between smaller and bigger node.
            if prev.val <= insertVal <= cur.val:
                break
            # Reached inflection point. This is for catching `insertVal`s
            # that are smaller than min or bigger than max.
            elif (prev.val > cur.val and
                  # We might have hit the inflection point because the given
                  # head started us off past the expected insertion point. So
                  # this is only the insertion point if it fits the order.
                  # `or` because it cannot be both bigger than max and smaller than min.
                    (insertVal <= cur.val or insertVal >= prev.val)):
                break
            # Put this *before* next `if` condition to skip the very first
            # loop iteration (when `prev` is always `head`).
            prev, cur = prev.next, cur.next
            # Means we made a complete cycle without breaking, meaning
            # all nodes are dupe vals (prev<=val<=cur doesn't hit because
            # val could be larger or smaller than the dupe).
            if prev == head:
                break

        node = Node(insertVal, cur)
        prev.next = node
        return head

