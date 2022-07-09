class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # this can be made in dynamic programming but we can also thinking from end index
        # if we start from endpoition, can we reach the index at 0?
        last_position = len(nums) - 1

        # starting at second last item since we want to know if we can reach to last one
        # by adding nums[i] to current index
        for i in range(len(nums) - 2, -1, -1):
            # ff this index has jump count which can reach to or beyond the last position
            if i + nums[i] >= last_position:
                # since we just need to reach this destination
                last_position = i
        return last_position == 0
