# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        # use BFS and load the last element
        from collections import deque
        q = deque()
        res = []
        if not root: return []
        q.append(root)
        while q:
            N = len(q)
            for i in range(N):
                curr = q.popleft()
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                if i == N - 1:
                    res.append(curr.val)
        return res

    def rightSideView_levelTraversal(self, root: TreeNode) -> List[int]:
        def levelVisit(res: List[List[int]], level: int, node: TreeNode):
            if not node: return
            if len(res) < level:
                res.append([])
            levelVisit(res, level + 1, node.left)
            row = res[level - 1]
            row.append(node.val)
            res[level - 1] = row
            levelVisit(res, level + 1, node.right)

        levels = []
        levelVisit(levels, 1, root)
        res = []
        for row in levels:
            res.append(row[-1])
        return res
