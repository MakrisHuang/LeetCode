class Solution:
    """
    Time Complexity: O(NlogN)
    Space Complexity: O(1)
    """
    def longestConsecutive_sort(self, nums: List[int]) -> int:
        if not nums:
            return 0

        nums.sort()

        longest = 1
        current = 1

        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                if nums[i] == nums[i - 1] + 1:
                    current += 1
                else:
                    longest = max(longest, current)
                    current = 1
        return max(longest, current)

    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums: return 0

        s = set(nums)

        longest = 0
        for num in nums:
            if num - 1 not in s:
                curr_num = num
                curr_length = 1

                while curr_num + 1 in s:
                    curr_num += 1
                    curr_length += 1

                longest = max(longest, curr_length)

        return longest
