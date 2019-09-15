# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDiffInBST(self, root: TreeNode) -> int:
        def dfs(root: TreeNode):
            if not root: return
            dfs(root.left)
            if self.prev:
                self.res = min(self.res, root.val - self.prev.val)
            self.prev = root
            dfs(root.right)

        self.res = float('inf')
        self.prev = None
        dfs(root)
        return self.res
