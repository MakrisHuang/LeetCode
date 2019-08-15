class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        nums_1 = [*map(int, version1.split("."))]
        nums_2 = [*map(int, version2.split("."))]
        diff = len(nums_2) - len(nums_1)
        nums_1, nums_2 = nums_1 + [0] * diff, nums_2 + [0] * -diff
        if nums_1 > nums_2: return 1
        elif nums_2 > nums_1: return -1
        else: return 0

