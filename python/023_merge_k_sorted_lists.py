# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        import queue

        head = curr = ListNode(0)

        pq = queue.PriorityQueue()

        def add_node_in_pq(idx, node):
            if node:
                pq.put((node.val, idx, node))

        for idx, node in enumerate(lists):
            add_node_in_pq(idx, node)

        while not pq.empty():
            _, idx, node = pq.get()
            add_node_in_pq(idx, node.next)

            # remember to unlink the node

            node.next = None
            curr.next = node
            curr = curr.next

        return head.next

