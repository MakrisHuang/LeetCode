# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        # calculate the length of left node and right node
        # thinking the depth starting from the bottom of a leaf node
        self.ans = 0
        def depth(node):
            if not node: return 0
            left = depth(node.left)
            right = depth(node.right)
            # path
            self.ans = max(self.ans, left + right)
            # depth
            return max(left, right) + 1
        depth(root)
        return self.ans
