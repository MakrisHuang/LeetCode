class Solution:
    def reverseWords(self, s: str) -> str:
        s = list(s)
        left = right = 0
        N = len(s)
        while left < N and right < N:
            # find next space
            while right < N and s[right] != ' ':
                right += 1
            # reverse word
            curr_right, curr_left = right - 1, left
            while curr_left < curr_right:
                s[curr_left], s[curr_right] = s[curr_right], s[curr_left]
                curr_left += 1
                curr_right -= 1
            # update index
            right += 1
            left = right
        return "".join(s)
