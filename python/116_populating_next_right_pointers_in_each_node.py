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
    def connect(sefl, root: 'Node') -> 'Node':
        if not root:
            return None

        curr = root
        next = root.left

        while curr.left:
            curr.left.next = curr.right
            if curr.next:
                curr.right.next = curr.next.left
                curr = curr.next
            else:
                curr = next
                next = curr.left
        return root

    def connect_bfs(self, root: 'Node') -> 'Node':
        q = []
        if root:
            q.append(root)

        while q:
            size = len(q)
            prev = None
            for _ in range(size):
                curr = q.pop(0)
                if not prev:
                    prev = curr
                else:
                    prev.next = curr
                    prev = curr
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return root

