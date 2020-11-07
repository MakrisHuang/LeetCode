class Solution:
    def sortColors_detailed(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left, right = 0, len(nums) - 1
        i = 0
        while i <= right:
            if nums[i] == 0:
                # swap nums[i] with left pointer
                nums[left], nums[i] = nums[i], nums[left]
                left += 1
                i += 1
            elif nums[i] == 2:
                # swap nums[i] with right pointer
                nums[right], nums[i] = nums[i], nums[right]
                right -= 1
            else:
                i += 1

    """
        r = where next red to store (A[r]=0 when r==i or A[r]=1 after first 1 occurs)
        b = where next blue to store (unknown value)
              r   i     b
        0 0 0 1 1 ? ... ? 2 2 2
    """
    def sortColors(self, nums: List[int]) -> None:

        left, right = 0, len(nums) - 1
        i = 0
        while i <= right:
            if nums[i] == 0:
                nums[left], nums[i] = nums[i], nums[left]
                left += 1
            elif nums[i] == 2: # Continue handle i after swap, since we don't know A[b]
                nums[right], nums[i] = nums[i], nums[right]
                right -= 1
                i -= 1
            i += 1


