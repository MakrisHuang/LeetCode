class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        arr_sum = 0
        m = dict()
        m[0] = -1   # key: remainder, value: index
        for i in range(len(nums)):
            arr_sum += nums[i]
            if k != 0:
                arr_sum %= k
            if arr_sum in m:
                if i - m[arr_sum] > 1:
                    return True
            else:
                m[arr_sum] = i
        return False
