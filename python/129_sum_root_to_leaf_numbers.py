# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.res = 0

    def sumNumbers(self, root: TreeNode) -> int:
        self.dfs(root, "")
        return int(self.res)

    def dfs(self, node: TreeNode, accum: str):
        if not node:
            return

        accum += str(node.val)
        if not node.left and not node.right:
            self.res += int(accum)
            return

        self.dfs(node.left, accum)
        self.dfs(node.right, accum)

