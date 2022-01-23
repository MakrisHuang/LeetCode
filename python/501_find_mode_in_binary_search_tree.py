# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        node2Count = collections.defaultdict(int)

        def inorder(node):
            if not node: return
            inorder(node.left)
            node2Count[node.val] += 1
            inorder(node.right)

        inorder(root)
        maxCount = max(node2Count.values())
        res = []
        for nodeVal, count in node2Count.items():
            if count == maxCount:
                res.append(nodeVal)
        return res
