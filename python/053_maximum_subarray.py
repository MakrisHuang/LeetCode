class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum = -math.inf
        accum = 0
        start = end = 0
        temp_idx = 0

        for index, val in enumerate(nums):
            accum += val
            if accum > max_sum:
                max_sum = accum
                start = temp_idx
                end = index # keep updating end since the sum is increasing

            if accum < 0:
                accum = 0
                # new sum shows up, need to move to new position
                temp_idx = index + 1
        print("subarray start index", start, "end index", end)
        return max_sum
