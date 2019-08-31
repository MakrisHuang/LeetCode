class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        from collections import Counter
        count = dict(Counter(nums))

        def update_key(nums, curr_idx, count, key):
            nums[curr_idx] = key
            count[key] -= 1
            if count[key] == 0:
                del count[key]

        for i in range(len(nums)):
            if 0 in count:
                update_key(nums, i, count, 0)
            elif 1 in count:
                update_key(nums, i, count, 1)
            elif 2 in count:
                update_key(nums, i, count, 2)

