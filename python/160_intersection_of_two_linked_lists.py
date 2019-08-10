# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        # get the length of head A
        len_a = 0
        curr_a = headA
        while curr_a:
            len_a += 1
            curr_a = curr_a.next

        len_b = 0
        curr_b = headB
        while curr_b:
            len_b += 1
            curr_b = curr_b.next
        while len_a > len_b:
            headA = headA.next
            len_a -= 1
        while len_b > len_a:
            headB = headB.next
            len_b -= 1

        while headA and headB:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next

    def getIntersectionNode(self, headA, headB):
        if not headA or not headB:
            return None
        pa = headA
        pb = headB
        while pa is not pb:
            pa = headB if pa == None else pa.next
            pb = headA if pb == None else pb.next
        return pa
