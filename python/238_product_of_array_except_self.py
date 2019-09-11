class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        N = len(nums)
        res = [1] * N
        for i in range(N - 1):
            res[i + 1] = res[i] * nums[i]

        pivot = 1

        for j in range(N - 1, -1, -1):
            res[j] *= pivot
            pivot *= nums[j]
        return res
