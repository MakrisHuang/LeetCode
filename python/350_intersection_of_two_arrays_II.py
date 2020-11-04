class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m1 = dict(collections.Counter(nums1))
        m2 = dict(collections.Counter(nums2))
        keys = set(m1.keys()) & set(m2.keys())
        res = []
        for key in keys:
            min_count = min(m1[key], m2[key])
            res += [key] * min_count
        return res
