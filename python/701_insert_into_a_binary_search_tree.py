# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Time Complexity: O(height) -> O(n) for skewed tree
    # Space Complexity: O(height) because of recursion stack
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        def inorderInsert(curr: TreeNode, newNode: TreeNode):
            if not curr:
                curr = newNode
                return

            # search in BST
            if curr.val > newNode.val:
                # current value is larger
                # put new value in the left
                if not curr.left:
                    curr.left = newNode
                else:
                    inorderInsert(curr.left, newNode)
            else:
                # current value is smaller
                # put new value in the right
                if not curr.right:
                    curr.right = newNode
                else:
                    inorderInsert(curr.right, newNode)
        node = TreeNode(val)
        inorderInsert(root, node)
        return root


