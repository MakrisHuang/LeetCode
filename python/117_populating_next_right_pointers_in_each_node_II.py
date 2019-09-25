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
    def connect(self, root: 'Node') -> 'Node':
        q = []
        if root:
            q.append(root)
            q.append(None)

        while q:
            curr = q.pop(0)
            if curr:
                curr.next = q[0]
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            else:
                if q:
                    q.append(None)

        return root
