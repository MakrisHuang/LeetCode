# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.getDepth(root) != -1

    def getDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        left_dep = self.getDepth(root.left)
        if left_dep == -1:
            return -1

        right_dep = self.getDepth(root.right)
        if right_dep == -1:
            return -1

        max_depth = max(left_dep, right_dep)
        return max_depth + 1 if abs(left_dep - right_dep) <= 1 else -1
