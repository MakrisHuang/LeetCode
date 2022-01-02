# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        def remove(node):
            if not node:
                return None
            if not node.left and not node.right:
                return None
            node.left = remove(node.left)
            node.right = remove(node.right)
            return node

        def findLeaves(node, res: List[TreeNode]):
            if not node: return
            if not node.left and not node.right:
                res.append(node.val)
            findLeaves(node.left, res)
            findLeaves(node.right, res)

        ans = []
        while root:
            leaves = []
            findLeaves(root, leaves)
            ans.append(list(leaves))
            root = remove(root)
        return ans


