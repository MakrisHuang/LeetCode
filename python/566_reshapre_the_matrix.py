class Solution:
    def matrixReshape(self, nums: List[List[int]], r: int, c: int) -> List[List[int]]:
        old_r = len(nums)
        old_c = len(nums[0])
        if r * c != old_r * old_c:
            return nums
        res = []
        temp_row = []
        for row in nums:
            for ele in row:
                temp_row.append(ele)
                if len(temp_row) == c:
                    res.append(temp_row)
                    temp_row = []
        return res

