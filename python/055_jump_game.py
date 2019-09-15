class Solution:
    """
    Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex). If we can reach a GOOD index, then our position is itself GOOD. Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the beginning of the array. If first position is a GOOD index then we can reach the last index from the first position.
    """
    def canJump(self, nums: List[int]) -> bool:
        N = len(nums)
        last_idx = N - 1
        for i in range(N - 1, -1, -1):
            if i + nums[i] >= last_idx:
                last_idx = i
        return last_idx == 0
