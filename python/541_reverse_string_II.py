class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        curr = 0
        arr = list(s)
        while curr < len(s):
            k_idx = curr + k - 1
            left = curr
            right = k_idx if k_idx < len(s) else len(s) - 1
            while left < right:
                arr[left], arr[right] = arr[right], arr[left]
                left += 1
                right -= 1
            curr += 2 * k
        return "".join(arr)
