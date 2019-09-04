# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def getPath(root, target_node, res):
            if not root or (res and res[-1] == target_node): return

            res.append(root)
            getPath(root.left, target_node, res)
            getPath(root.right, target_node, res)
            if res[-1] != target_node:
                res.pop()

        def getLowestCommonNode(l1, l2):
            iter1, iter2 = iter(l1), iter(l2)
            res = None

            while True:
                node_1 = next(iter1, None)
                node_2 = next(iter2, None)
                if not node_1 and not node_2:
                    break
                if node_1 and node_2 and node_1.val == node_2.val:
                    res = node_1
            return res

        if not root or not p or not q: return None

        list_p = []
        getPath(root, p, list_p)

        list_q = []
        getPath(root, q, list_q)

        return getLowestCommonNode(list_p, list_q)
