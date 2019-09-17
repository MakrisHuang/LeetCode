class Solution:
    # Time Complexity: O(n ^ 2)
    # Space Complexity: O(1)
    def threeSumSmaller(self, nums: List[int], target: int) -> int:
        nums.sort()
        count = 0
        for i in range(len(nums) - 2):
            # no need to consider duplication since we want all results
            low, high = i + 1, len(nums) - 1
            # if current sum < target, increase low
            # otherwise, decrease high
            while low < high:
                curr_sum = nums[i] + nums[low] + nums[high]
                if curr_sum < target:
                    count += (high - low)
                    low += 1
                else:
                    high -= 1
        return count
