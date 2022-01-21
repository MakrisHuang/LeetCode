# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:

        res = []
        targets = set(to_delete)

        def postOrderDelete(node):
            if not node: return
            left = postOrderDelete(node.left)
            right = postOrderDelete(node.right)
            if node.val in targets:
                if left:
                    res.append(left)
                if right:
                    res.append(right)
                return None
            else:
                node.left = left
                node.right = right
                return node
        top = postOrderDelete(root)
        if top:
            res.append(top)
        return res
