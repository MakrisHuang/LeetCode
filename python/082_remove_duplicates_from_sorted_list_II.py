# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy = ListNode(-1)
        dummy.next = head
        prev, curr = dummy, head

        while curr:
            if curr.next and curr.next.val == curr.val:
                val_to_remain = curr.val
                while curr and curr.val == val_to_remain:
                    curr = curr.next
                prev.next = curr
            else:
                prev, curr = curr, curr.next
        return dummy.next
