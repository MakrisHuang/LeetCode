# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        def recursive(node, arr: List[int]) -> int:
            if not node: return 0
            arr.append(node.val)
            if not node.left and not node.right:
                str_val = "".join([str(i) for i in arr])
                val = int(str_val, 2)    # binary string to binar int
                arr.pop()
                return val
            left = recursive(node.left, arr)
            right = recursive(node.right, arr)
            arr.pop()
            return left + right

        return recursive(root, [])
