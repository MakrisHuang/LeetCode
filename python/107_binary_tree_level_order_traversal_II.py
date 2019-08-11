# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        queue = deque()
        if root is not None:
            queue.append(root)
            queue.append(None)

        res = []
        row = []
        while len(queue) > 0:
            node = queue.popleft()
            if node is not None:
                row.append(node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            else:
                res.append(list(row))
                row = []
                if len(queue) > 0:
                    queue.append(None)
        res.reverse()
        return res

