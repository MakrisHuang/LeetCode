class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        arr_set = set(arr)
        for i in range(1, k + len(arr) + 1):
            if i not in arr_set:
                k -= 1
            if k == 0:
                return i
    def findKthPositive_binary(self, arr: List[int], k: int) -> int:
        # https://leetcode.com/problems/kth-missing-positive-number/discuss/1004535/Python-Two-solutions-O(n)-and-O(log-n)-explained
        beg, end = 0, len(arr)
        while beg < end:
            mid = (beg + end) // 2
            if arr[mid] - mid - 1 < k:
                beg = mid + 1
            else:
                end = mid
        return end + k
