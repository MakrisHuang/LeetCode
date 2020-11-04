class Solution:
    def intersect_hash(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m1 = dict(collections.Counter(nums1))
        m2 = dict(collections.Counter(nums2))
        keys = set(m1.keys()) & set(m2.keys())
        res = []
        for key in keys:
            min_count = min(m1[key], m2[key])
            res += [key] * min_count
        return res

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        i, j, k = 0, 0, 0
        res = []
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                nums1[k] = nums1[i]
                k += 1
                i += 1
                j += 1
        return nums1[:k]

