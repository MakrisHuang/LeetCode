class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)

        if 1 not in nums:
            return 1

        if n == 1:
            return 2

        # negate numbers if number is not in range
        # only consider 0 < num <= n, so filter out others
        for i, num in enumerate(nums):
            if num <= 0 or num > n:
                nums[i] = 1

        # Use index as a hash key and number sign as a presence detector.
        # For example, if nums[1] is negative that means that number `1`
        # is present in the array.
        # If nums[2] is positive - number 2 is missing
        # then return 2
        for i in range(n):
            a = abs(nums[i])

            if a == n:
                # consider the last element (i.e. n)
                nums[0] = -abs(nums[0])
            else:
                nums[a] = -abs(nums[a])

        # iterate all numbers to find out first non-negative
        for i in range(1, n):
            if nums[i] > 0:
                return i

        if nums[0] > 0:
            return n

        return n + 1
