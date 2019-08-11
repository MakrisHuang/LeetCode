# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        else:
            return self.checkSymmetric(root.left, root.right)

    def checkSymmetric(self, p: TreeNode, q: TreeNode) -> bool:
        if p == None:
            return q == None
        if q == None:
            return p == None
        if p.val == q.val:
            return self.checkSymmetric(p.left, q.right) and self.checkSymmetric(p.right, q.left)
        return False
