class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        ans, count = 0, 0
        for num in nums:
            if num == 0:
                count = 0
            else:
                count += 1
            ans = max(ans, count)
        return ans

    def findMaxConsecutiveOnes_long(self, nums: List[int]) -> int:
        if not nums: return 0
        i = 0
        max_1 = 0
        while i < len(nums):
            curr = i
            if nums[curr] == 1:
                count = 1
                while curr + 1 < len(nums) and nums[curr + 1] == 1:
                    curr += 1
                    count += 1
                max_1 = max(max_1, count)
                i = curr + 1
            else:   # skip 0
                while curr < len(nums) and nums[curr] == 0:
                    curr += 1
                i = curr
        return max_1
