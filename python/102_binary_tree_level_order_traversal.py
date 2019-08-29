# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        from queue import Queue
        q = Queue()
        if root:
            q.put(root)
            q.put(None)

        res = []
        temp = []
        while q.qsize() > 0:
            node = q.get()
            if node:
                temp.append(node.val)
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
            else:
                res.append(list(temp))
                temp = []
                if q.qsize() > 0:
                    q.put(None)
        return res
