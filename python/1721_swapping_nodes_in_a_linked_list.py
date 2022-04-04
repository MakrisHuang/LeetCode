# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        curr = head
        # get length of the linked list
        count = 0
        while curr:
            count += 1
            curr = curr.next

        dummy_head = ListNode(0)
        dummy_head.next = head

        left_node = dummy_head
        left_pos = k
        while left_node and left_pos > 0:
            left_node = left_node.next
            left_pos -= 1

        right_node = head
        right_pos = count - k
        while right_node and right_pos > 0:
            right_node = right_node.next
            right_pos -= 1

        left_node.val, right_node.val = right_node.val, left_node.val

        return head
