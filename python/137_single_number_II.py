class Solution:
    def singleNumber_sort(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return nums[0]
        nums.sort()
        i = 0
        while i < len(nums):
            if i + 1 < len(nums) and nums[i] != nums[i + 1]:
                return nums[i]
            elif i == len(nums) - 1:
                return nums[i]
            i += 3

    def singleNumber_hashset(self, nums: List[int]) -> int:
        return (3 * sum(set(nums)) - sum(nums)) // 2

    def singleNumber(self, nums: List[int]) -> int:
        seen_once = seen_twice = 0

        for num in nums:
            # first appearance:
            # add num to seen_once
            # don't add to seen_twice because of presence in seen_once

            # second appearance:
            # remove num from seen_once
            # add num to seen_twice

            # third appearance:
            # don't add to seen_once because of presence in seen_twice
            # remove num from seen_twice
            seen_once = ~seen_twice & (seen_once ^ num)
            seen_twice = ~seen_once & (seen_twice ^ num)

        return seen_once
