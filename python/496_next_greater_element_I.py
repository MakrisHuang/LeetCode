class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        map = dict()
        stack = []

        for index, value in enumerate(nums2):
            while stack and value > stack[-1]:
                map[stack.pop()] = value
            stack.append(value)

        while stack:
            map[stack.pop()] = -1

        res = [map[value] for value in nums1]
        return res
