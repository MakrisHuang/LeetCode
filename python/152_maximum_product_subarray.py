class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        # consider positive / negative values
        # set up max, min and iterate it with nums[i]
        max_ans = mmax = mmin = nums[0]

        for i in range(1, len(nums)):
            mx, mi = mmax, mmin
            val = nums[i]
            mmax = max(val, mx * val, mi * val)
            mmin = min(val, mx * val, mi * val)
            max_ans = max(mmax, max_ans)
        return max_ans
