# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    from collections import deque
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root: return res

        q = deque([root, None])
        level_vals = []
        while q:
            node = q.popleft()
            if node:
                level_vals.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            else:
                res.append(level_vals)
                level_vals = []
                if q:
                    q.append(None)
        return res
