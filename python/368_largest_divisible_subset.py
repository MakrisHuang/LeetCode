class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        n = len(nums)
        if n <= 1:
            return nums

        # step 1
        nums.sort()

        # step 2: traverse all elements. For every element, find a
        # divisable nums[j] with larger-value by lds[j] and store
        # lds[i] = lds[j] + 1
        lds = [0 for i in range(len(nums))]
        prev = [-1 for i in range(len(nums))]

        maxIndex, maxVal = -1, 0
        for i in range(n):
            lds[i] = 1
            prev[i] = -1
            for j in range(i - 1, -1, -1):
                # lds[j] + 1 means if include the current nums[i]
                # it should be greater than current lds[i]
                if nums[i] % nums[j] == 0 and lds[j] + 1 > lds[i]:
                    lds[i] = lds[j] + 1
                    prev[i] = j
            if lds[i] > maxVal:
                maxIndex, maxVal = i, lds[i]

        i = maxIndex
        res = []
        while i != -1:
            res.append(nums[i])
            i = prev[i]
        return res
