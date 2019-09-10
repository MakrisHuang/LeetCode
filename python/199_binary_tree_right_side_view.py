# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        # apply bfs to print out the last node in each level
        res = []
        q = collections.deque()
        if root:
            q.append(root)
        while q:
            size = len(q)
            val = None
            for i in range(size):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                val = node.val
            res.append(val)
        return res

