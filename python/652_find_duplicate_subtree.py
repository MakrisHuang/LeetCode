# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Time Complexity: O(N ^ 2)
    # Space Complexity: O(N ^ 2)
    def findDuplicateSubtrees(self, root: TreeNode) -> List[TreeNode]:
        res = []
        counter = collections.Counter()
        def dfs(node: TreeNode):
            if not node: return '#'
            serialized = "{},{},{}".format(node.val, dfs(node.left), dfs(node.right))
            counter[serialized] += 1
            if counter[serialized] == 2:
                res.append(node)
            return serialized
        dfs(root)
        return res
