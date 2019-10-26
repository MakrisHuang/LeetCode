# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Time Complexity: O(logN)
    # Space Complexity: O(1)
    def minValueNode(self, node: TreeNode) -> TreeNode:
        curr = node
        while curr.left:
            curr = curr.left
        return curr

    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root:
            return root
        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            if not root.left:
                temp = root.right
                root = None
                return temp
            elif not root.right:
                temp = root.left
                root = None
                return temp

            temp = self.minValueNode(root.right)

            # copy inorder successor's value to current node
            root.val = temp.val

            # delete the inorder successor
            root.right = self.deleteNode(root.right, temp.val)
        return root
