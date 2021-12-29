# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # use prefix sum
        # if i1 + i2 = i1 + i2 + ... + i5, then it means sum(i3, i4, i5) = 0
        # therefore we need to remove i3, i4 and i5
        # we can use a hashmap to store the prefix and the corresponding node
        # key is the prefix, value is the next node where it points to
        # reference: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/discuss/414285/Python-easy-to-understand-solution-with-explanations
        dummy = ListNode(0)
        dummy.next = head
        prefix = {0: dummy}
        accum = 0
        while head:
            accum += head.val
            prefix[accum] = head
            head = head.next

        head = dummy
        accum = 0
        while head:
            accum += head.val
            head.next = prefix[accum].next
            head = head.next
        return dummy.next
