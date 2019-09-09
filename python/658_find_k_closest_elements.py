class Solution:
    # Time Complexity: O(N)
    # Space Complexity: O(N)
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if x < arr[0]:
            return arr[:k]
        elif x >= arr[-1]:
            return arr[len(arr) - k:]
        else:
            curr = 0
            while curr < len(arr):
                if arr[curr] > x:
                    arr.insert(curr, x)
                    break
                curr += 1
            left = curr - 1
            right = curr + 1
            smaller = []
            larger = []
            while left >= 0 and right < len(arr) and k > 0:
                if abs(x - arr[left]) <= abs(x - arr[right]):
                    smaller.insert(0, arr[left])
                    left -= 1
                else:
                    larger.append(arr[right])
                    right += 1
                k -= 1
            if k > 0:
                if left < 0 and right < len(arr):
                    larger += arr[right:right + k]
                elif left >= 0 and right >= len(arr):
                    smaller = arr[left - k + 1:left + 1] + smaller
            return smaller + larger

