class Solution:
    """
    This approach is based on the fact that when we rotate the array k times,
    k elements from the back end of the array come to the front
    and the rest of the elements from the front shift backwards.

    In this approach, we firstly reverse all the elements of the array.
    Then, reversing the first k elements followed by reversing the rest
    n-k elements gives us the required result.
    """
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(nums: List[int], start: int, end: int) -> None:
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1

        n = len(nums)
        k = k % len(nums)
        reverse(nums, 0, n - 1)
        reverse(nums, 0, k - 1)
        reverse(nums, k, n - 1)
