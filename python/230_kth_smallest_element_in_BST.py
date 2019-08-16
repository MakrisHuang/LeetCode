# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while root:
            stack.insert(0, root)
            root = root.left

        while k != 0:
            node = stack.pop(0)
            k -= 1
            if k == 0:
                return node.val
            right = node.right
            while right:
                stack.insert(0, right)
                right = right.left

        return -1

