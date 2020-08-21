# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
        def dfs(root: TreeNode):
            if not root: return
            dfs(root.left)
            if self.prev:
                self.res = min(self.res, abs(root.val - self.prev.val))
            self.prev = root
            dfs(root.right)

        self.res = float('inf')
        self.prev = None
        dfs(root)
        return self.res
