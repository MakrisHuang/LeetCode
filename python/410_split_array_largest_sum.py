class Solution:
    # Time Complexity: O(n * log(sum of the array))
    # Space Complexity: O(n)
    def splitArray(self, nums: List[int], m: int) -> int:
        """
        apply greedy with binary search
        The range sum will be within min(arr) <-> sum(arr)
        Therefore, we can choose a value between them and do binary search
        if number of ranges < m, means the range sum is too smaller
        and we need to enlarge it

        otherwise, we need decrease range sum to have more range sums
        """
        l = max(nums)
        r = sum(nums)
        ans = r

        while l <= r:
            mid = (l + r) // 2
            range_sum = 0
            range_sum_count = 1
            for i in range(len(nums)):
                if (range_sum + nums[i] > mid):
                    range_sum = nums[i]
                    range_sum_count += 1
                else:
                    range_sum += nums[i]
            if range_sum_count <= m:
                ans = min(ans, mid)
                r = mid - 1
            else:
                l = mid + 1
        return ans
