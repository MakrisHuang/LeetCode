class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def validPalindrome(self, s: str) -> bool:
        def isPalindrome(i, j):
            return all(s[k] == s[j - k + i] for k in range(i, j))

        left = 0
        right = len(s) - 1
        while left < right:
            if s[left] == s[right]:
                left += 1
                right -= 1
            else:
                return isPalindrome(left + 1, right) or isPalindrome(left, right - 1)
        return True
