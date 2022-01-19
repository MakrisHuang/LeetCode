"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    def insert(self, head: 'Optional[Node]', insertVal: int) -> 'Node':
        # case 1: prev < insertVal < head
        # case 2: insertVal > curr > prev => moving curr and prev to next
        # ex. 5 => moving until curr is smaller than prev
        # case 3: curr > prev > insertVal => ex. -5 => moving until curr is smaller than prev

        new_node = Node(insertVal)
        if not head:
            new_node.next = new_node
            return new_node

        prev, curr = head, head.next
        toInsert = False

        while True:
            if prev.val <= insertVal <= curr.val:
                toInsert = True

            elif prev.val > curr.val:
                if insertVal >= prev.val or insertVal <= curr.val:
                    toInsert = True

            if toInsert:
                prev.next = Node(insertVal, curr)
                return head

            prev, curr = curr, curr.next
            if prev == head:
                break

        # handle case 3 where all values are identical
        prev.next = Node(insertVal, curr)
        return head
