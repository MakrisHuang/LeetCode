# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        right = self.reverseList(slow)
        while head and right:
            if head.val != right.val:
                return False
            head = head.next
            right = right.next
        return True

    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        while head:
            next = head.next
            head.next = prev
            prev = head
            head = next
        return prev
