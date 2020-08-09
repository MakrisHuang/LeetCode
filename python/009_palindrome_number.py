class Solution:
    # reverse half number
    # O(logN)
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x is not 0): return False
        reverse = 0
        while reverse < x:
            reverse = reverse * 10 + (x % 10)
            x = int(x / 10)

        return reverse == x or x == int(reverse / 10)

