# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.validate(root, None, None)

    def validate(self, root: TreeNode, low, high) -> bool:
        if not root: return True
        return (low == None or root.val > low) and \
               (high == None or root.val < high) and \
               self.validate(root.left, low, root.val) and \
               self.validate(root.right, root.val, high)

    def count(self, root: TreeNode) -> int:
        if not root: return 0
        return 1 + self.count(root.left) + self.count(root.right)

    def findBST(self, root: TreeNode, bst: List[TreeNode]):
        if not root: return
        if self.isValidBST(root):
            bst.append(root)
        self.findBST(root.left, bst)
        self.findBST(root.right, bst)

    def largestBSTSubtree(self, root: TreeNode) -> int:
        # ensure BST properties
        # get all BST subtree
        # and count the number of each tree

        # iterate each node, and find it's a BST
        bst_nodes = []
        self.findBST(root, bst_nodes)
        max_num = 0
        for node in bst_nodes:
            max_num = max(max_num, self.count(node))
        return max_num


