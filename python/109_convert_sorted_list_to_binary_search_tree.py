# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        def build(arr: List[int]) -> TreeNode:
            if not arr: return None
            mid = len(arr) // 2
            new_node = TreeNode(arr[mid])
            new_node.left = build(arr[:mid])
            new_node.right = build(arr[mid + 1:])
            return new_node

        nums = []
        while head:
            nums.append(head.val)
            head = head.next
        return build(nums)


