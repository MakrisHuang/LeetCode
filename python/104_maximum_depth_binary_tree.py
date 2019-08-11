# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
#     def maxDepth(self, root: TreeNode) -> int:
#         return self.findMax(root, 0)

#     def findMax(self, node: TreeNode, depth: int) -> int:
#         if not node:
#             return depth
#         left_depth = self.findMax(node.left, depth + 1)
#         right_depth = self.findMax(node.right, depth + 1)
#         return max(left_depth, right_depth)

    def maxDepth(self, root: TreeNode) -> int:
        stack = []
        if root is not None:
            stack.append((1, root))
        depth = 0
        while stack != []:
            current_depth, root = stack.pop()
            if root is not None:
                depth = max(current_depth, depth)
                stack.append((current_depth + 1, root.left))
                stack.append((current_depth + 1, root.right))
        return depth

