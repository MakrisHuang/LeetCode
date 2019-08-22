# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        self.levelTravel(res, 0, root)
        return res

    def levelTravel(self, res: List[List[int]], level: int, root: TreeNode):
        if not root:
            return
        if len(res) < level + 1:
            res.append([])
        if level % 2 == 1:
            res[level].insert(0, root.val)
        else:
            res[level].append(root.val)
        self.levelTravel(res, level + 1, root.left)
        self.levelTravel(res, level + 1, root.right)
