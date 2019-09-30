# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res = []
        self.findPath(root, sum, res, [])
        return res

    def findPath(self, root: TreeNode, sum: int, paths: List[List[int]], temp: List[int]):
        if not root: return

        sum -= root.val
        temp.append(root.val)

        if not root.left and not root.right:
            if sum == 0:
                paths.append(list(temp))

        self.findPath(root.left, sum, paths, temp)
        self.findPath(root.right, sum, paths, temp)
        temp.pop()
