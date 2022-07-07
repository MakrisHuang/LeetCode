class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # use divide and conquer
        def recursive(nums: List[int], left: int, right: int) -> int:
            if left == right: return nums[left]
            # Step1. Select the middle element of the array.
            # So the maximum subarray may contain that middle element or not.
            mid = (left + right) // 2
            left_ans = recursive(nums, left, mid)
            right_ans = recursive(nums, mid + 1, right)

            left_max = nums[mid]
            right_max = nums[mid + 1]

            # Step 2.1 If the maximum subarray does not contain the middle element, then we can apply the same algorithm to the the subarray to the left of the middle element and the subarray to the right of the middle element.
            temp = 0
            for i in range(mid, left - 1, -1):
                temp += nums[i]
                if temp > left_max:
                    left_max = temp
            # Step 2.2 If the maximum subarray does contain the middle element, then the result will be simply the maximum suffix subarray of the left subarray plus the maximum prefix subarray of the right subarray
            temp = 0
            for j in range(mid + 1, right + 1):
                temp += nums[j]
                if temp > right_max:
                    right_max = temp
            return max(max(left_ans, right_ans), left_max + right_max)

        return recursive(nums, 0, len(nums) - 1)

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
