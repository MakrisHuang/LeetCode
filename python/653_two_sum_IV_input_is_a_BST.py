# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def findTarget(self, root: TreeNode, k: int) -> bool:

        def inorder(node: TreeNode, s: set, target: int):
            if not node: return False
            if (target - node.val) in s:
                return True
            s.add(node.val)
            return inorder(node.left, s, target) or inorder(node.right, s, target)

        return inorder(root, set(), k)


