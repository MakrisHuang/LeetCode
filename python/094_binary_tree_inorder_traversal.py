# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []

        stack = []
        while root:
            stack.insert(0, root)
            root = root.left

        while len(stack) > 0:
            node = stack.pop(0)
            res.append(node.val)

            right = node.right
            while right:
                stack.insert(0, right)
                right = right.left
        return res
