class Solution:
    # Time complexity: O(klogk)
    # Space Complexity: O(k)
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        from heapq import heappush, heappop
        # min queue, sorted by pair sum
        q = []
        res = []
        if not nums1 or not nums2: return res
        N1, N2 = len(nums1), len(nums2)
        # push initial pairs {num1, num2, index_of_num2}
        for i in range(min(N1, k)):
            sum = nums1[i] + nums2[0]
            nums2_index = 0
            heappush(q, (sum, nums1[i], nums2[0], nums2_index))
        # get 1st k elem into result, each time, push potential better apirs into queue
        # if there are not enough pair, just return all pairs
        for i in range(min(N1 * N2, k)):
            _, num1, num2, nums2_index = heappop(q)
            res.append([num1, num2])
            # next better pair could with be A: {after(num1), num2} or B: {num1. after(num2)}
            # for A, we've already added top possible k into queue, so A is either in the queue already, or not qualified
            # for B, it might be a better choice, so we offer it into queue
            if nums2_index < N2 - 1:    # still at least one elem after num2 in array nums2
                idx = nums2_index + 1
                sum = num1 + nums2[idx]
                heappush(q, (sum, num1, nums2[idx], idx))
        return res
