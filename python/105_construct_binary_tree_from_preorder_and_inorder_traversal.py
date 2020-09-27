# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder, inorder):
        inor_dict = {}
        for i, num in enumerate(inorder):
            inor_dict[num] = i
        pre_iter = iter(preorder)

        def recursive(start, end):
            if start > end:return None
            root_val = next(pre_iter)
            root = TreeNode(root_val)
            idx = inor_dict[root_val]
            root.left = recursive(start, idx - 1)
            root.right = recursive(idx + 1, end)
            return root

        return recursive(0, len(inorder) - 1)
