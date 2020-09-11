class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        res = []
        i = 0
        # use another index to indicate the end of a range
        N = len(nums)
        while i < N:
            curr = i
            while curr + 1 < N and nums[curr + 1] - nums[curr] == 1:
                curr += 1
            if curr - i >= 1:
                res.append(f'{nums[i]}->{nums[curr]}')
            else:
                res.append(str(nums[i]))
            i = curr + 1
        return res
