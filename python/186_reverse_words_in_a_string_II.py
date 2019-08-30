class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        s[:] = s[::-1]

        begin = 0
        while begin < len(s):
            end = begin + 1
            while end < len(s) and s[end] != " ":
                end += 1

            left = begin
            right = end - 1
            while left < right:
                s[left], s[right] = s[right], s[left]
                left += 1
                right -= 1

            begin = end + 1

