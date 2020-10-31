# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val > q.val:
            p, q = q, p
        def recursive(node, p, q):
            if node.val >= p.val and node.val <= q.val:
                return node
            if node.val > p.val and node.val > q.val:
                return recursive(node.left, p, q)
            else:
                return recursive(node.right, p, q)

        return recursive(root, p, q)
