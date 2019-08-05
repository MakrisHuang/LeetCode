class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        sorted_nums = sorted(nums)
        left_idx = 0
        for left in range(0, len(nums)):
            if sorted_nums[left] != nums[left]:
                left_idx = left
                break;
        right_idx = len(nums) - 1
        for right in range(len(nums) - 1, -1, -1):
            if sorted_nums[right] != nums[right]:
                right_idx = right
                break
        sub_len = right_idx - left_idx + 1
        return sub_len if sorted_nums != nums else 0
