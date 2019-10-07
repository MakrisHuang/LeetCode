"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None

        # set up a dummy node at the most left of curr level
        # whenever linking next pointer for 'node'
        # we keep the previous link
        # that when node == None, we can keep track for previous layer
        curr = dummy = Node()
        node = root
        while node:
            if node.left:
                curr.next = node.left
                curr = node.left
            if node.right:
                curr.next = node.right
                curr = node.right
            node = node.next
            if not node:
                node = dummy.next
                dummy.next = None
                curr = dummy
        return root
