class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        ans = 0
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                if stack:
                    stack.pop()
                if not stack:
                    # since stack is empty, indicateing previous parentheses
                    # are valid, and it shows s[:i] are valid
                    # so we can push current index to stack
                    stack.append(i)
                else:
                    ans = max(ans, i - stack[-1])
        return ans
