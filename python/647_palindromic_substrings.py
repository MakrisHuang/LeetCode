class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0
        for left in range(len(s)):
            for index in [0,1]:
                right = left + index
                count += self.getPalindrome(s, left, right)
        return count

    def getPalindrome(self, s: str, left: int, right: int) -> int:
        count = 0
        while left >= 0 and right < len(s) and s[left] == s[right]:
            cand = s[left:right + 1]
            count += 1
            left -= 1
            right += 1
        return count

