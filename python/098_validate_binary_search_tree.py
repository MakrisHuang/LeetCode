# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.validate(root, None, None)

    def validate(self, root: TreeNode, low, high) -> bool:
        if not root: return True
        return (low == None or root.val > low) and \
               (high == None or root.val < high) and \
               self.validate(root.left, low, root.val) and \
               self.validate(root.right, root.val, high)

