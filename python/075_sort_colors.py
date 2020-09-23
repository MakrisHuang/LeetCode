class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        map = dict(collections.Counter(nums))
        index = 0
        for color in [0, 1, 2]:
            if color in map:
                count = map[color]
                while count > 0:
                    nums[index] = color
                    count -= 1
                    index += 1
