class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(min(n, k))
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        def getBucketId(x, w):
            return x // w if x >= 0 else (x + 1) // w - 1

        if t < 0: return False
        d = dict()
        w = t + 1   # num of buckets
        for i in range(len(nums)):
            m = getBucketId(nums[i], w)
            # check if bucket m is empty, each bucket may contain at most one element
            if m in d:
                return True

            # check the neighbor buckets for almost duplicate
            if (m - 1) in d and abs(nums[i] - d[m - 1]) < w:
                return True
            if (m + 1) in d and abs(nums[i] - d[m + 1]) < w:
                return True

            # now bucket m is empty and no almost duplicate in neighbor buckets
            d[m] = nums[i]
            if i >= k:
                del d[getBucketId(nums[i - k], w)]
        return False


