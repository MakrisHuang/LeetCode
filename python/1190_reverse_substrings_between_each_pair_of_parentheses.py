class Solution:
    # Time Complexity: O(N ^ 2)
    # Space Complexity: O(N)
    def reverseParentheses(self, s: str) -> str:
        open_stack = []
        i = 0
        while (i < len(s)):
            if s[i] == "(":
                open_stack.append(i)
            elif s[i] == ")":
                start = open_stack.pop(-1)
                sub_string = s[start + 1:i]
                if i == len(s)-1:
                    s = s[:start] + sub_string[::-1]
                else:
                    # keep the prefix, reverse current string and concatenate the rest
                    s = s[:start] + sub_string[::-1] + s[i + 1:]
                i -= 2  # remove open parenthes and close parenthes, so minus 2
            i += 1  # move to next character
        return s
