class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # search for the first one which is smallar than the right one
        left = len(nums) - 2
        while left >= 0 and nums[left] >= nums[left + 1]:
            left -= 1

        if left >= 0:
            # search from the right to find the one is greater than left one
            right = len(nums) - 1
            while right >= 0 and  nums[right] <= nums[left]:
                right -= 1

            nums[left], nums[right] = nums[right], nums[left]

        # flip the right to make the number smaller
        # ex [4, 2, 2] -> [2, 2, 4]
        i_left = left + 1
        i_right = len(nums) - 1
        while i_left < i_right:
            nums[i_left], nums[i_right] = nums[i_right], nums[i_left]
            i_left += 1
            i_right -= 1

