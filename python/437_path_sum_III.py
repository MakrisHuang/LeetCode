# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    def __init__(self):
        self.count = 0

    def pathSum(self, root: TreeNode, sum: int) -> int:
        pre_sum_map = {0: 1}
        self.recursion(root, 0, sum, pre_sum_map)
        return self.count

    def recursion(self, root: TreeNode, curr_sum: int, target: int, pre_sum_map: dict):
        if not root: return

        curr_sum += root.val

        if curr_sum - target in pre_sum_map:
            self.count += pre_sum_map[curr_sum - target]

        if curr_sum not in pre_sum_map:
            pre_sum_map[curr_sum] = 1
        else:
            pre_sum_map[curr_sum] = pre_sum_map[curr_sum] + 1

        self.recursion(root.left, curr_sum, target, pre_sum_map)
        self.recursion(root.right, curr_sum, target, pre_sum_map)
        pre_sum_map[curr_sum] = pre_sum_map[curr_sum] - 1
